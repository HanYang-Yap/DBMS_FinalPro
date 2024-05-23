package com.example.demo.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class HomeController implements WebMvcConfigurer {

    @GetMapping("/")
    public String home() {
        return "home&loginpage/index"; // Return the name of your HTML or Thymeleaf template
    }

    @GetMapping("/home&loginpage/index")
    public String homeLoginPage() {
        return "home&loginpage/index"; // Return the name of your HTML or Thymeleaf template
    }

    @SuppressWarnings("null")
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**", "/js/**", "/images/**")
                .addResourceLocations("classpath:/static/css/", "classpath:/static/js/", "classpath:/static/images/");
    }
    
}
