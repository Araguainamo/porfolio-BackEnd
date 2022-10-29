package com.freddyportfolio.api.service.impl;

import com.freddyportfolio.api.model.Skill;
import com.freddyportfolio.api.model.UserPorfolio;
import com.freddyportfolio.api.repository.SkillRepository;
import com.freddyportfolio.api.repository.UserPorfolioRepository;
import com.freddyportfolio.api.service.SkillService;
import com.freddyportfolio.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private UserPorfolioRepository userPorfolioRepository;
    @Autowired
    private UserService userService;

    @Override
    public Boolean save(Long id, Skill skill) {
        try {
            remove(id, skill.getId());

            UserPorfolio user = userService.findById(id);
            if (user == null) return false;

            user.getSkills().add(skill);
            userPorfolioRepository.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean remove(Long id, Long skillId) {
        Skill skillRef = null;
        if (skillId != null) {
            skillRef = skillRepository.getReferenceById(skillId);
        }

        UserPorfolio user = userService.findById(id);
        if (user == null) return false;

        if (skillRef != null) {
            user.getSkills().remove(skillRef);
        }

        return true;
    }

    @Override
    public List<Skill> findAll() {
        return skillRepository.findAll();
    }

    @Override
    public Skill findById(Long id) {
        return skillRepository.getReferenceById(id);
    }
}