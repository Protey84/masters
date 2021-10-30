package com.example.protey.controller;

import com.example.protey.entity.FilterTask;
import com.example.protey.entity.Task;
import com.example.protey.repo.MasterRepo;
import com.example.protey.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class TaskController {
    private final TaskService service;
    private final MasterRepo repo;

    public TaskController(TaskService service, MasterRepo repo) {
        this.service = service;
        this.repo = repo;
    }

    @GetMapping("/tasks")
    public String orders(Model model) {
        model.addAttribute("tasks", service.getAll());
        return "tasks";
    }
    @GetMapping("/")
    public String main2(){
        return "redirect:/main";
    }

    @GetMapping("/main")
    public String main(Model model){
        FilterTask filter=new FilterTask();
        model.addAttribute("filter", filter);
        model.addAttribute("masters", repo.findAll());
        model.addAttribute("schedule", service.getSchedule(filter.getStartDay(), filter.getFinishDay()));
        return "main";
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
        model.addAttribute("date", date);
        Task task=new Task();
        model.addAttribute("task", task);
        model.addAttribute("masters", repo.findAll());
        return "addTask";
    }



}
