package com.amardhadbale.gmail.com.Portfolio.controller;

import com.amardhadbale.gmail.com.Portfolio.entity.Contact;
import com.amardhadbale.gmail.com.Portfolio.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private final ContactService contactService;

    public HomeController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping({" ", "/", "/home"})
    public String home() {
        return "home";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @PostMapping("/contact")
    public String receiveContact(
            @ModelAttribute Contact contact,
            Model model
    ) {

        contactService.saveContact(contact);

        model.addAttribute("success", "Msg sent");

        return "home";
    }
}