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

@Service   // Marks this class as the Service Layer (Business Logic)
public class ProjectService {

    // Inject ProjectRepository object automatically
    @Autowired
    private ProjectRepository projectRepository;

    /*
     * Method: saveProject()
     * Purpose:
     * 1. Save uploaded image into static/imgs folder.
     * 2. Save image name inside Project object.
     * 3. Save complete Project object into database.
     */
    public void saveProject(Project project, MultipartFile image) throws IOException {

        // Folder where uploaded images will be stored
        String uploadDir = "src/main/resources/static/imgs/";

        // Get original file name from uploaded image
        // Example: helmet.png
        String fileName = image.getOriginalFilename();

        // Create complete file path
        // Example:
        // src/main/resources/static/imgs/helmet.png
        Path path = Paths.get(uploadDir + fileName);

        // Save uploaded image into imgs folder
        Files.write(path, image.getBytes());

        // Save only image name into Project object
        // Example:
        // imageName = helmet.png
        project.setImageName(fileName);

        // Save complete project into database
        // Hibernate automatically generates INSERT query
        projectRepository.save(project);
    }

    /*
     * Method: getAllProjects()
     * Purpose:
     * Retrieve all projects from the database.
     *
     * Flow:
     * HomeController
     *        ↓
     * ProjectService
     *        ↓
     * ProjectRepository.findAll()
     *        ↓
     * Hibernate
     *        ↓
     * SELECT * FROM project;
     *        ↓
     * List<Project>
     */
    public List<Project> getAllProjects() {

        // Fetch all records from Project table
        return projectRepository.findAll();
    }
    /*
     * Get a single project by its ID
     */
    public Project getProjectById(Long id) {

        return projectRepository.findById(id).orElse(null);

    }

    /*
     * Update existing project
     */
    public void updateProject(Project project, MultipartFile image) throws IOException {

        // Check if a new image is uploaded
        if (!image.isEmpty()) {

            // Folder path
            String uploadDir = "src/main/resources/static/imgs/";

            // Image name
            String fileName = image.getOriginalFilename();

            // Save image
            Path path = Paths.get(uploadDir + fileName);

            Files.write(path, image.getBytes());

            // Set new image name
            project.setImageName(fileName);

        } else {

            // Keep old image if no new image uploaded
            Project oldProject = projectRepository.findById(project.getId()).orElse(null);

            if (oldProject != null) {
                project.setImageName(oldProject.getImageName());
            }
        }

        // Save updated project
        projectRepository.save(project);
    }
    public void deleteProject(Long id) {

        projectRepository.deleteById(id);

    }

}