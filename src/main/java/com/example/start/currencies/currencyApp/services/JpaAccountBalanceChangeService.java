package com.example.start.currencies.currencyApp.services;
import com.example.start.currencies.currencyApp.entities.AccountBalanceChange;
import com.example.start.currencies.currencyApp.repositories.AccountBalanceChangeRepository;
import com.example.start.currencies.currencyApp.repositories.ApplicationUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JpaAccountBalanceChangeService implements AccountBalanceChangeService{

    private AccountBalanceChangeRepository accountBalanceChangeRepository;
    private ApplicationUserRepository applicationUserRepository;

    public JpaAccountBalanceChangeService (AccountBalanceChangeRepository accountBalanceChangeRepository,
                                           ApplicationUserRepository applicationUserRepository) {
        this.accountBalanceChangeRepository = accountBalanceChangeRepository;
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public List<AccountBalanceChange> findRecordsByProfileUser(Long id) {

        if (applicationUserRepository.findById(id).isPresent()) {
            return applicationUserRepository.findById(id).get().getAccountProfile().getAccountBalanceChanges();
        }
        throw new RuntimeException();
    }

    @Override
    public AccountBalanceChange save(AccountBalanceChange accountBalanceChange) {
       return accountBalanceChangeRepository.save(accountBalanceChange);
    }
}
