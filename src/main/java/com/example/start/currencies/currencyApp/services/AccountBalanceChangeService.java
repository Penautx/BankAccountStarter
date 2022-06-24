package com.example.start.currencies.currencyApp.services;

import com.example.start.currencies.currencyApp.entities.AccountBalanceChange;

import java.util.List;

public interface AccountBalanceChangeService {

    List<AccountBalanceChange> findRecordsByProfileUser(Long id);

    AccountBalanceChange save(AccountBalanceChange accountBalanceChange);
}
