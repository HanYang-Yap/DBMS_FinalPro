package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebPageController {
    @GetMapping("/")
    public String defaultUrl() {
        return "redirect:/home&loginpage/index";
    }

    @GetMapping("/home&loginpage/loginpage")
    public String login() {
        return "home&loginpage/loginpage";
    }

    @GetMapping("/home&loginpage/signup")
    public String signup() {
        return "home&loginpage/signup";
    }

    @GetMapping("/adminPages/admin1")
    public String admin1() {
        return "admin1";
    }

    @GetMapping("/adminPages/admin2")
    public String admin2() {
        return "admin2";
    }

    @GetMapping("/reservation1")
    public String resevation() {
        return "reservation1";
    }

    @GetMapping("/userInterface")
    public String user() {
        return "userInterface";
    }

    @GetMapping("/venues/badminton")
    public String badminton() {
        return "badminton";
    }

    @GetMapping("/venues/basketball")
    public String basketball() {
        return "basketball";
    }

    @GetMapping("/venues/gym")
    public String gym() {
        return "gym";
    }

    @GetMapping("/venues/swimmingPool")
    public String swimmingPool() {
        return "swimmingPool";
    }

    @GetMapping("/venues/tennis")
    public String tennis() {
        return "tennis";
    }
}
