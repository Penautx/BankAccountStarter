package com.example.start.currencies.currencyApp.repositories;

import com.example.start.currencies.currencyApp.entities.ApplicationUserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplicationUserRoleRepository extends JpaRepository <ApplicationUserRole, Long> {
    boolean existsByName(String name);
    Optional<ApplicationUserRole> findByName(String name);
}
