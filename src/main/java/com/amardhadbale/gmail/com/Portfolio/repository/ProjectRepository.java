package com.amardhadbale.gmail.com.Portfolio.repository;

import com.amardhadbale.gmail.com.Portfolio.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
