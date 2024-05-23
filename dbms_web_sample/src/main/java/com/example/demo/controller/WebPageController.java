
package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class WebPageController implements WebMvcConfigurer{
    @GetMapping("/")
    public String home() {
        return "home&loginpage/index"; // Return the name of your HTML or Thymeleaf template
    }

    @GetMapping("/loginpage")
    public String loginPage() {
        return "home&loginpage/loginpage"; // Assuming "loginpage" is the name of your login HTML file
    }

    @GetMapping("/signup")
    public String signup() {
        return "home&loginpage/signup"; // Assuming "loginpage" is the name of your login HTML file
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

    @GetMapping("/home&loginpage/style.css")
    public String style() {
        return "style.css";
    }

    @GetMapping("/home&loginpage/style1.css")
    public String style1() {
        return "style1.css";
    }

    @GetMapping("/home&loginpage/NCCU_Gymnasium.jpg")
    public String NCCU_Gymnasium() {
        return "NCCU_Gymnasium.jpg";
    }

    @GetMapping("/home&loginpage/NCCU_logo.jpg")
    public String NCCU_logo() {
        return "NCCU_logo.jpg";
    }

    @GetMapping("/home&loginpage/NCCU_SportVenue.jpg")
    public String NCCU_SportVenue() {
        return "NCCU_SportVenue.jpg";
    }

    @GetMapping("/home&loginpage/NCCU_LiuQi.jpg")
    public String NCCU_LiuQi() {
        return "NCCU_LiuQi.jpg";
    }

    @GetMapping("/home&loginpage/Sport_Day_Banner.jpg")
    public String Sport_Day_Banner() {
        return "Sport_Day_Banner.jpg";
    }
    
    @SuppressWarnings("null")
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**", "/js/**", "/images/**")
                .addResourceLocations("classpath:/static/css/", "classpath:/static/js/", "classpath:/static/images/");
    }

}
