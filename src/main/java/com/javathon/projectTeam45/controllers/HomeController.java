package com.javathon.projectTeam45.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("time", new Date());
        return "home";
    }

}