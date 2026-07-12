package com.amardhadbale.gmail.com.Portfolio.controller;
import com.amardhadbale.gmail.com.Portfolio.entity.Project;
import com.amardhadbale.gmail.com.Portfolio.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.io.IOException;

@Controller
@RequestMapping("/admin/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // =========================
    // Open Admin Page
    // =========================
    @GetMapping
    public String adminPage(Model model) {

        // Send all projects to admin.html
        model.addAttribute("projects", projectService.getAllProjects());

        return "admin";
    }
    /*
     * Open Edit Project Page
     */
    @GetMapping("/edit/{id}")
    public String editProject(@PathVariable Long id, Model model) {

        // Get selected project
        Project project = projectService.getProjectById(id);

        // Send project to edit page
        model.addAttribute("project", project);

        return "edit-project";
    }
    // =========================
    // Save Project
    // =========================
    @PostMapping("/save")
    public String saveProject(
            @ModelAttribute Project project,
            @RequestParam("image") MultipartFile image) throws IOException {

        projectService.saveProject(project, image);

        return "redirect:/admin/project";
    }
    @GetMapping("/delete/{id}")
    public String deleteProject(@PathVariable Long id) {

        projectService.deleteProject(id);

        return "redirect:/admin/project";
    }
    /*
     * Update Project
     */
    @PostMapping("/update")
    public String updateProject(
            @ModelAttribute Project project,
            @RequestParam("image") MultipartFile image) throws IOException {

        // Call Service
        projectService.updateProject(project, image);

        // Go back to admin page
        return "redirect:/admin/project";
    }

}