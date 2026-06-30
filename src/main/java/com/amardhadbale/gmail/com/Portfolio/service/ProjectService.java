package com.amardhadbale.gmail.com.Portfolio.service;

import com.amardhadbale.gmail.com.Portfolio.entity.Project;
import com.amardhadbale.gmail.com.Portfolio.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public void saveProject(Project project, MultipartFile image) throws IOException {

        // Folder where images will be stored
        String uploadDir = "src/main/resources/static/imgs/";

        // Get uploaded file name
        String fileName = image.getOriginalFilename();

        // Create full path
        Path path = Paths.get(uploadDir + fileName);

        // Save image to folder
        Files.write(path, image.getBytes());

        // Save image name in database
        project.setImageName(fileName);

        // Save project details
        projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
}