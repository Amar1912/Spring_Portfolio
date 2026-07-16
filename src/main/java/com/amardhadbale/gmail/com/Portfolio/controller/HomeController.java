package com.amardhadbale.gmail.com.Portfolio.controller;

import com.amardhadbale.gmail.com.Portfolio.entity.Contact;
import com.amardhadbale.gmail.com.Portfolio.service.ContactService;
import com.amardhadbale.gmail.com.Portfolio.service.ProjectService;
import com.amardhadbale.gmail.com.Portfolio.service.SkillService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private final ProjectService projectService;
    private final SkillService skillService;
    private final ContactService contactService;

    public HomeController(ProjectService projectService,
                          SkillService skillService,
                          ContactService contactService) {
        this.projectService = projectService;
        this.skillService = skillService;
        this.contactService = contactService;
    }

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("projects", projectService.getAllProjects());
        model.addAttribute("skills", skillService.getAllSkills());

        return "home";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @PostMapping("/contact")
    public String receiveContact(@ModelAttribute Contact contact, Model model) {

        contactService.saveContact(contact);

        model.addAttribute("success", "Msg sent");

        return "home";
    }
}