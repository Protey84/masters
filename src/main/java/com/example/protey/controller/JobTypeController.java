package com.example.protey.controller;

import com.example.protey.service.JobTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JobTypeController {
    private JobTypeService service;

    public JobTypeController(JobTypeService service) {
        this.service = service;
    }

    @GetMapping("/addJobType")
    public String addJobType(@RequestParam(name = "name", required = false)String name, Model model){
        service.save(name);
        model.addAttribute("masters", service.getAll());
        return "masters";
    }
}
