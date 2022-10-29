package com.freddyportfolio.api.service.impl;

import com.freddyportfolio.api.model.UserPorfolio;
import com.freddyportfolio.api.repository.UserPorfolioRepository;
import com.freddyportfolio.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserPorfolioRepository userPorfolioRepository;
    @Override
    public Boolean saveUser(UserPorfolio userPorfolio) {
        try {
            userPorfolioRepository.save(userPorfolio);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<UserPorfolio> findAll() {
        return userPorfolioRepository.findAll();
    }

    @Override
    public UserPorfolio findById(Long id) {
        return userPorfolioRepository.getReferenceById(id);
    }

    @Override
    public UserPorfolio login(String username, String password) {
        try {
            return userPorfolioRepository.findByUsernameAndPassword(username, password).get(0);
        } catch (Exception e) {
            return null;
        }
    }
}
