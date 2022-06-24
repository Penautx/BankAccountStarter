package com.example.start.currencies.currencyApp.controllers;


import com.example.start.currencies.currencyApp.repositories.ApplicationUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    public DashboardController(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @GetMapping
    public String accountDashboard(Principal principal, Model model){
        model.addAttribute("applicationUser", applicationUserRepository.findByUsername(principal.getName()).orElseThrow());
    return "dashboard";
    }
}
