package com.example.start.currencies.currencyApp.services;

import com.example.start.currencies.currencyApp.entities.ApplicationUser;
import com.example.start.currencies.currencyApp.entities.ApplicationUserRole;
import com.example.start.currencies.currencyApp.repositories.ApplicationUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApplicationUserService implements UserDetailsService {

    private final ApplicationUserRepository applicationUserRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       Optional<ApplicationUser> applicationUserOptional =  applicationUserRepository.findByUsername(username);
        if(applicationUserOptional.isPresent()){
            return applicationUserOptional.get();
        }
        throw new UsernameNotFoundException("User with username: " + username + " was not found in database");
    }


    public Set<ApplicationUserRole> loadRolesByUsername(String username) throws UsernameNotFoundException {

        Optional<ApplicationUser> applicationUserOptional =  applicationUserRepository.findByUsername(username);
        if(applicationUserOptional.isPresent()){
            return applicationUserOptional.get().getRoles();
        }
        throw new UsernameNotFoundException("User with username: " + username + " was not found in database");
    }
}
