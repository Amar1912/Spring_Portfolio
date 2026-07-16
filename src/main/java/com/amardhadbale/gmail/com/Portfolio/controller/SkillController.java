package com.amardhadbale.gmail.com.Portfolio.controller;

import com.amardhadbale.gmail.com.Portfolio.entity.Skill;
import com.amardhadbale.gmail.com.Portfolio.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/skill")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @PostMapping("/save")
    public String saveSkill(@ModelAttribute Skill skill) {

        System.out.println(skill);

        skillService.saveSkill(skill);

        return "redirect:/admin";
    }
}