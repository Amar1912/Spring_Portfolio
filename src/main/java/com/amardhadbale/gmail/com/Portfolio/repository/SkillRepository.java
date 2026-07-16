package com.amardhadbale.gmail.com.Portfolio.repository;

import com.amardhadbale.gmail.com.Portfolio.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

}