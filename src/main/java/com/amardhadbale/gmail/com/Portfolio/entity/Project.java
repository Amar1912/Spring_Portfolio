package com.amardhadbale.gmail.com.Portfolio.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String projectName;
    private String projectDescription;
    private String githubLink;
    private String liveDemo;
    private String technologies;
    private String imageName;
}
