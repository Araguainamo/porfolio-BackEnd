package com.freddyportfolio.api.controller;

import com.freddyportfolio.api.model.Skill;
import com.freddyportfolio.api.service.SkillService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/skill")
// Comentario
public class SkillController extends ControllerBase<Skill, SkillService> { }