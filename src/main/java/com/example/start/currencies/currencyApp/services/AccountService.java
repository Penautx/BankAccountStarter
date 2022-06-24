package com.example.start.currencies.currencyApp.services;

import com.example.start.currencies.currencyApp.entities.AccountProfile;
import com.example.start.currencies.currencyApp.entities.AccountBalanceChange;
import com.example.start.currencies.currencyApp.entities.Payment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;
public interface AccountService {

    Optional<AccountProfile> findById (long id);

    Optional<AccountProfile> findByAccountNumber (String accountNumber);

    AccountProfile addDepositOrWithdraw (AccountBalanceChange change, AccountProfile accountProfile);

    AccountProfile addPayment (Payment payment);

}
