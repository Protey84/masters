package com.example.protey.controller;

import com.example.protey.entity.Job;
import com.example.protey.entity.Task;
import com.example.protey.repo.JobTypeRepo;
import com.example.protey.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JobController {
    TaskService service;
    JobTypeRepo jobTypeRepo;

    public JobController(TaskService service, JobTypeRepo jobTypeRepo) {
        this.service = service;
        this.jobTypeRepo = jobTypeRepo;
    }

    @PostMapping("/addTask")
    public String addTaskFromForm(@ModelAttribute("task") Task task, Model model){
        Task task1=service.save(task);
        model.addAttribute("task", task1);
        Job job=new Job();
        model.addAttribute("job", job);
        model.addAttribute("jobTypes", jobTypeRepo.findAll());
        return "addJob";
    }

    @PostMapping("/addJob")
    public String addJob(@ModelAttribute("job") Job job, @ModelAttribute("taskId") int taskId, Model model){
        model.addAttribute("task", service.addJob(taskId, job));
        model.addAttribute("job", new Job());
        model.addAttribute("jobTypes", jobTypeRepo.findAll());
        return "addJob";
    }
}
