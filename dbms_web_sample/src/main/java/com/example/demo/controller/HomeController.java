package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class HomeController implements WebMvcConfigurer {

    @GetMapping("/home&loginpage/index")
    public String homeLoginPage() {
        return "home&loginpage/index"; // Return the name of your HTML or Thymeleaf template
    }
}
