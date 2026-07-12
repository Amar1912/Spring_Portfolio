package com.amardhadbale.gmail.com.Portfolio.repository;

import com.amardhadbale.gmail.com.Portfolio.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * @Repository
 * -------------------------
 * Marks this interface as the Repository Layer.
 * Repository is responsible for communicating with the database.
 *
 * Note:
 * Since this interface extends JpaRepository,
 * @Repository is optional because Spring detects it automatically.
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    /*
     * JpaRepository<Project, Long>
     *
     * Project
     * --------
     * Entity class (represents Project table)
     *
     * Long
     * -----
     * Data type of Primary Key (id)
     *
     * Because we extend JpaRepository,
     * Spring Boot automatically provides many methods.
     */

    /*
     * ==========================
     * Built-in CRUD Methods
     * ==========================
     *
     * save(project)
     * -----------------------------
     * Insert a new project.
     *
     * If project.id == null
     * → INSERT
     *
     * If project.id already exists
     * → UPDATE
     *
     * Example:
     * projectRepository.save(project);
     *
     * ----------------------------------
     *
     * findAll()
     * -----------------------------
     * Fetch all projects.
     *
     * Internally generates:
     *
     * SELECT * FROM project;
     *
     * Returns:
     *
     * List<Project>
     *
     * Example:
     * projectRepository.findAll();
     *
     * ----------------------------------
     *
     * findById(id)
     * -----------------------------
     * Find one project using Primary Key.
     *
     * Example:
     * projectRepository.findById(1L);
     *
     * Internally:
     *
     * SELECT * FROM project
     * WHERE id = 1;
     *
     * ----------------------------------
     *
     * deleteById(id)
     * -----------------------------
     * Delete project using id.
     *
     * Example:
     * projectRepository.deleteById(1L);
     *
     * ----------------------------------
     *
     * delete(project)
     * -----------------------------
     * Delete a Project object.
     *
     * ----------------------------------
     *
     * count()
     * -----------------------------
     * Returns total number of projects.
     *
     * Example:
     * long total = projectRepository.count();
     *
     * ----------------------------------
     *
     * existsById(id)
     * -----------------------------
     * Checks whether a project exists.
     *
     * Returns:
     * true / false
     *
     */

}