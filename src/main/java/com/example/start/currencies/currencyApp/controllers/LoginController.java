package com.example.start.currencies.currencyApp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String loginForm(){
        return "login";
    }

    @PostMapping
    public String processLogin(){
        return "redirect:/dashboard";
    }


}
