package com.freddyportfolio.api.controller;


import com.freddyportfolio.api.model.Project;
import com.freddyportfolio.api.service.ProjectsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/projects")
public class ProjectsController extends ControllerBase<Project, ProjectsService> {}
