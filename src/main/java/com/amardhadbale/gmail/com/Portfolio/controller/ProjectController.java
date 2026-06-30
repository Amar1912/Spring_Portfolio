package com.amardhadbale.gmail.com.Portfolio.controller;

import ch.qos.logback.core.model.Model;
import com.amardhadbale.gmail.com.Portfolio.entity.Project;
import com.amardhadbale.gmail.com.Portfolio.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/admin/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/save")
    public String saveProject(
            @ModelAttribute Project project,
            @RequestParam("image") MultipartFile image) throws IOException {

        projectService.saveProject(project, image);

        return "redirect:/admin";
    }
}
