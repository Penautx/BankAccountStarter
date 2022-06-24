package com.example.start.currencies.currencyApp.controllers;


import com.example.start.currencies.currencyApp.repositories.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private ApplicationUserRepository userRepository;
    @GetMapping
    public String home() {
        return "home";
    }

}
