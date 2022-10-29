package com.freddyportfolio.api.controller;


import com.freddyportfolio.api.model.Experience;
import com.freddyportfolio.api.model.Project;
import com.freddyportfolio.api.service.ExperienceService;
import com.freddyportfolio.api.service.ProjectsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/experiences")
public class ExperienceController extends ControllerBase<Experience, ExperienceService> {}
