package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebPageController {
    @GetMapping("/")
    public String defaultUrl() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "registration";
    }

    @GetMapping("/buyerhome")
    public String home() {
        return "buyerHome";
    }

    @GetMapping("/sellerhome")
    public String sellerHome() {
        return "sellerHome";
    }
}
