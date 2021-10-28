package com.example.protey.controller;

import com.example.protey.service.MasterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MasterController {
    private MasterService service;

    public MasterController(MasterService service) {
        this.service = service;
    }

    @GetMapping("/addMaster")
    public String addMaster(@RequestParam(name = "name", required = false)String name, Model model){
        service.save(name);
        model.addAttribute("masters", service.getMasters());
        return "masters";
    }
}
