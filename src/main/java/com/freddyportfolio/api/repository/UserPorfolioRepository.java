package com.freddyportfolio.api.repository;

import com.freddyportfolio.api.model.UserPorfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserPorfolioRepository extends JpaRepository<UserPorfolio, Long> {
    public List<UserPorfolio> findByEmail(String email);
    public List<UserPorfolio> findByUsernameAndPassword(String username, String password);
    public List<UserPorfolio> findByNameAndEmail(String name, String email);
}
