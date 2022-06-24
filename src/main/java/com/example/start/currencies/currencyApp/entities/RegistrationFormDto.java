package com.example.start.currencies.currencyApp.entities;

import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Data
public class RegistrationFormDto {
    private String username;
    private String password;


    public ApplicationUser toApplicationUser (BCryptPasswordEncoder passwordEncoder) {

        Set<ApplicationUserRole> roles = new HashSet<>();
        roles.add(ApplicationUserRole.builder().name("ROLE_USER").build());

        return ApplicationUser.builder().password(passwordEncoder.encode(password)).username(username)
                .accountProfile(initializeAccountProfile()).roles(roles).build();
    }


    private AccountProfile initializeAccountProfile() {

        return AccountProfile.builder().accountProfileNumber(generateAccountProfileNumber())
                .balance(new BigDecimal(100.00)).currency("PLN").build();
    }


    private String generateAccountProfileNumber() {

        StringBuilder stringBuilder = new StringBuilder("66"); //prefix
        Random random = new Random();

        for (int i = 0; i < 24; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        return  stringBuilder.toString();
    }



}
