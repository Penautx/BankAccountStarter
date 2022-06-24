package com.example.start.currencies.currencyApp.repositories;

import com.example.start.currencies.currencyApp.entities.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    boolean existsByUsername(String username);
    Optional<ApplicationUser> findByUsername(String username);
}
