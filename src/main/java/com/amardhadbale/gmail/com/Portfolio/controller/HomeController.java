package com.amardhadbale.gmail.com.Portfolio.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping({" ","/","/home"})
    public String home(){
        return "home";
    }

    @GetMapping({"/about"})
    public String about(){
        return "about";
    }
    @PostMapping("/contact")
    public String receiveContact(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String subject,
            @RequestParam String message
    ){
       System.out.println("Contact "+name+" "+email+" "+subject+" "+message);
       return "home";

    }

}
