package com.example.start.currencies.currencyApp.controllers;

import com.example.start.currencies.currencyApp.entities.RegistrationFormDto;
import com.example.start.currencies.currencyApp.repositories.ApplicationUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/register")
public class RegistrationController {
    @Autowired
    private ApplicationUserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping
    public String registerForm(Model model) {
        model.addAttribute("RegistrationForm", new RegistrationFormDto());
        return "registration";
    }

    @PostMapping
    public String processRegistration( @ModelAttribute(name = "RegistrationForm" ) RegistrationFormDto form) {

        if (!userRepository.existsByUsername(form.getUsername())) {
            userRepository.save(form.toApplicationUser(passwordEncoder));

            return "redirect:/login";
        }
        return "registration";
    }
}