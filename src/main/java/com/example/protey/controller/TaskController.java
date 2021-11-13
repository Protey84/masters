package com.example.protey.controller;

import com.example.protey.entity.FilterTask;
import com.example.protey.entity.Task;
import com.example.protey.repo.MasterRepo;
import com.example.protey.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class TaskController {
    private final TaskService service;
    private final MasterRepo repo;

    public TaskController(TaskService service, MasterRepo repo) {
        this.service = service;
        this.repo = repo;
    }

    @GetMapping(value = {"/main", "/", "index"})
    public String main(Model model){
        FilterTask filter=new FilterTask();
        model.addAttribute("filter", filter);
        model.addAttribute("masters", repo.findAll());
        model.addAttribute("schedule", service.getSchedule(filter.getStartDay(), filter.getFinishDay(), filter.getMaster()));
        return "main";
    }

    @GetMapping("/main/{idMaster}")
    public String mainMaster(@PathVariable("idMaster") int idMaster, Model model){
        FilterTask filter=new FilterTask();
        filter.setMaster(repo.findById(idMaster).get());
        model.addAttribute("filter", filter);
        model.addAttribute("masters", repo.findAll());
        model.addAttribute("schedule", service.getSchedule(filter.getStartDay(), filter.getFinishDay(), filter.getMaster()));
        return "main";
    }

    @GetMapping("delete/{id}")
    public String deleteTask(@PathVariable("id") int id, Model model){
        if (service.isIdExists(id))
            service.deleteById(id);
        return "redirect: /";
    }
    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model){
        Task task=service.getTaskById(id);
        model.addAttribute("task", task);
        model.addAttribute("masters", repo.findAll());
        return "task";
    }

    @PostMapping("/save")
    public String editTask(@ModelAttribute("task") Task task, Model model){
        service.save(task);
        return "redirect:/";
    }
    @PostMapping("/main")
    public String filteredMain(@ModelAttribute("filter") FilterTask filter, Model model){
        model.addAttribute("filter", filter);
        model.addAttribute("masters", repo.findAll());
        model.addAttribute("schedule", service.getSchedule(filter.getStartDay(), filter.getFinishDay(), filter.getMaster()));
        return "main";
    }
    @GetMapping("/addTask/{date}")
    public String addTask(@PathVariable String date, Model model){
        Task task=new Task();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dt = LocalDate.parse(date, dtf);
        task.setDate(dt);
        model.addAttribute("task", task);
        model.addAttribute("masters", repo.findAll());
        return "addTask";
    }



}
