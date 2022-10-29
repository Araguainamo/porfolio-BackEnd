package com.freddyportfolio.api.service;

import com.freddyportfolio.api.model.UserPorfolio;

import java.util.List;

public interface UserService {
    public Boolean saveUser(UserPorfolio userPorfolio);
    public List<UserPorfolio> findAll();
    public UserPorfolio findById(Long id);
    public UserPorfolio login(String username, String password);
}
