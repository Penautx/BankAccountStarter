package com.example.start.currencies.currencyApp.services;

import com.example.start.currencies.currencyApp.entities.AccountProfile;
import com.example.start.currencies.currencyApp.entities.AccountBalanceChange;
import com.example.start.currencies.currencyApp.entities.Payment;
import com.example.start.currencies.currencyApp.repositories.AccountRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
@Component
@Service
public class JpaAccountService implements  AccountService {

    private AccountRepository accountRepository;
    private CurrencyService currencyService;

    public JpaAccountService (AccountRepository repository, CurrencyService currencyService){
        this.accountRepository = repository;
        this.currencyService = currencyService;
    }
    @Override

    public Optional<AccountProfile> findById(long id) {

        return accountRepository.findById(id);
    }

    @Override
    public Optional<AccountProfile> findByAccountNumber(String accountNumber) {
        return accountRepository.findAll()
                .stream()
                .filter(number -> number.getAccountProfileNumber().equals(accountNumber))
                .findFirst();

    }

    @Override
    public AccountProfile addDepositOrWithdraw(AccountBalanceChange change, AccountProfile accountProfile) {
        if (change.isDeposit()) {
            accountProfile.setBalance(accountProfile.getBalance().add(change.getAmount()));
            accountRepository.updateAccountBalance(accountProfile.getId(), accountProfile.getBalance());
        } else {
            accountProfile.setBalance(accountProfile.getBalance().subtract(change.getAmount()));
            accountRepository.updateAccountBalance(accountProfile.getId(), accountProfile.getBalance());
        }
        return accountProfile;
    }

    @Override
    public AccountProfile addPayment(Payment payment) {
        AccountProfile accountProfileReceiver = findByAccountNumber(payment.getAccountProfileNumber()).orElseThrow();

        BigDecimal newAmount = currencyService.calculateToCurrency(
                payment.getAmount(),
                currencyService.findRateByCode(payment.getCurrency()).orElseThrow(),
                currencyService.findRateByCode(accountProfileReceiver.getCurrency()).orElseThrow()).add(accountProfileReceiver.getBalance()
        );

        accountProfileReceiver.setBalance(newAmount);
        accountRepository.updateAccountBalance(accountProfileReceiver.getId(), accountProfileReceiver.getBalance());

        return findByAccountNumber(payment.getAccountProfileNumber()).orElseThrow();
    }
}
