package com.freddyportfolio.api.service.impl;

import com.freddyportfolio.api.model.Experience;
import com.freddyportfolio.api.model.UserPorfolio;
import com.freddyportfolio.api.repository.ExperienceRepository;
import com.freddyportfolio.api.repository.UserPorfolioRepository;
import com.freddyportfolio.api.service.ExperienceService;
import com.freddyportfolio.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceServiceImpl implements ExperienceService {
    @Autowired
    private UserService userService;
    @Autowired
    private UserPorfolioRepository userPorfolioRepository;
    @Autowired
    private ExperienceRepository experienceRepository;
    @Override
    public Boolean save(Long id, Experience object) {
        try {
            remove(id, object.getId());

            UserPorfolio user = userService.findById(id);
            if (user == null) return false;

            user.getExperiences().add(object);
            userPorfolioRepository.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean remove(Long id, Long objectId) {
        Experience experienceRef = null;
        if (objectId != null) {
            experienceRef = experienceRepository.getReferenceById(objectId);
        }

        UserPorfolio user = userService.findById(id);
        if (user == null) return false;

        if (experienceRef != null) {
            user.getExperiences().remove(experienceRef);
        }

        return true;
    }

    @Override
    public List<Experience> findAll() {
        return experienceRepository.findAll();
    }

    @Override
    public Experience findById(Long id) {
        return experienceRepository.getReferenceById(id);
    }
}
