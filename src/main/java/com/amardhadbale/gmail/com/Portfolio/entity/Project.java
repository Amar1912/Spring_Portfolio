package com.amardhadbale.gmail.com.Portfolio.entity;

import jakarta.persistence.*;
import lombok.Data;

/*
 * ==========================================================
 *                    PROJECT ENTITY
 * ==========================================================
 *
 * An Entity is a Java class that represents a table in the
 * database.
 *
 * One object of this class = One row in the Project table.
 *
 * Example:
 *
 * id | projectName      | technologies
 * -----------------------------------------
 * 1  | Portfolio        | Spring Boot
 * 2  | Cab Booking      | Laravel
 * 3  | Smart Helmet     | ESP32
 *
 * Hibernate automatically converts this Java class into a
 * database table.
 */

@Entity
@Table(name = "Project")     // Database table name
@Data                        // Lombok generates Getters, Setters,
// toString(), equals(), hashCode()
public class Project {

    /*
     * ==========================================================
     * Primary Key
     * ==========================================================
     *
     * @Id
     * -----
     * Marks this field as the Primary Key.
     *
     * @GeneratedValue
     * ----------------
     * MySQL automatically generates id values.
     *
     * Example:
     *
     * 1
     * 2
     * 3
     * 4
     *
     * Similar to AUTO_INCREMENT in MySQL.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * ==========================================================
     * Project Name
     * ==========================================================
     *
     * Stores the project title.
     *
     * Example:
     *
     * Portfolio Website
     * Smart Helmet
     * Cab Booking System
     */

    private String projectName;

    /*
     * ==========================================================
     * Project Description
     * ==========================================================
     *
     * Stores detailed information about the project.
     */

    private String projectDescription;

    /*
     * ==========================================================
     * GitHub Link
     * ==========================================================
     *
     * Stores GitHub Repository URL.
     *
     * Example:
     * https://github.com/amar/project
     */

    private String githubLink;

    /*
     * ==========================================================
     * Live Demo
     * ==========================================================
     *
     * Stores deployed website URL.
     *
     * Example:
     * https://portfolio.com
     */

    private String liveDemo;

    /*
     * ==========================================================
     * Technologies Used
     * ==========================================================
     *
     * Stores technologies used in project.
     *
     * Example:
     *
     * Spring Boot
     * Thymeleaf
     * MySQL
     * Bootstrap
     */

    private String technologies;

    /*
     * ==========================================================
     * Image Name
     * ==========================================================
     *
     * Stores only image file name.
     *
     * Example:
     * helmet.png
     * portfolio.jpg
     *
     * NOTE:
     * The actual image is stored inside:
     *
     * src/main/resources/static/imgs/
     *
     * Database stores only:
     *
     * helmet.png
     */

    private String imageName;

}