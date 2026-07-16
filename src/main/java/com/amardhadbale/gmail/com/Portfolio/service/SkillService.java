package com.amardhadbale.gmail.com.Portfolio.service;

import com.amardhadbale.gmail.com.Portfolio.entity.Skill;
import com.amardhadbale.gmail.com.Portfolio.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }
    public void saveSkill(Skill skill) {
        skillRepository.save(skill);
    }
}