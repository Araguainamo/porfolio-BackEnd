package com.freddyportfolio.api.controller;
import com.freddyportfolio.api.service.ServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class ControllerBase<K ,T extends ServiceBase<K>> {
    @Autowired
    private T service;

    @GetMapping
    public List<K> findALl() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public K findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("{userId}")
    public Boolean saveSkill(@PathVariable Long userId, @RequestBody K object){
        return service.save(userId, object);
    }

    @DeleteMapping("{userId}/{objectId}")
    public Boolean deleteSkill(@PathVariable Long userId, @PathVariable Long objectId){
        return service.remove(userId, objectId);
    }
}
