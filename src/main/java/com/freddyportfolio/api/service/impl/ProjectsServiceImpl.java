package com.freddyportfolio.api.service.impl;

import com.freddyportfolio.api.model.Project;
import com.freddyportfolio.api.model.UserPorfolio;
import com.freddyportfolio.api.repository.ProjectRepository;
import com.freddyportfolio.api.repository.UserPorfolioRepository;
import com.freddyportfolio.api.service.ProjectsService;
import com.freddyportfolio.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectsServiceImpl implements ProjectsService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserPorfolioRepository userPorfolioRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Boolean save(Long id, Project object) {
        try {
            remove(id, object.getId());

            UserPorfolio user = userService.findById(id);
            if (user == null) return false;

            user.getProjects().add(object);
            userPorfolioRepository.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean remove(Long id, Long objectId) {
        Project projectRef = null;
        if (objectId != null) {
            projectRef = projectRepository.getReferenceById(objectId);
        }

        UserPorfolio user = userService.findById(id);
        if (user == null) return false;

        if (projectRef != null) {
            user.getSkills().remove(projectRef);
        }

        return true;
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project findById(Long id) {
        return projectRepository.getReferenceById(id);
    }
}
