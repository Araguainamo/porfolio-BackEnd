package com.freddyportfolio.api.controller;

import com.freddyportfolio.api.model.LoginObject;
import com.freddyportfolio.api.model.UserPorfolio;
import com.freddyportfolio.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserPorfolio> findALl() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserPorfolio findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/login")
    public UserPorfolio login(@RequestBody LoginObject object) {
        return userService.login(object.username, object.password);
    }

    @PostMapping
    public Boolean saveUser(@RequestBody UserPorfolio u){
        return userService.saveUser(u);
    }
}
