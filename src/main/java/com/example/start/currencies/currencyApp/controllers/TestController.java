package com.example.start.currencies.currencyApp.controllers;

import com.example.start.currencies.currencyApp.api.CurrencyRateDto;
import com.example.start.currencies.currencyApp.entities.AccountBalanceChange;
import com.example.start.currencies.currencyApp.entities.Payment;
import com.example.start.currencies.currencyApp.repositories.AccountRepository;
import com.example.start.currencies.currencyApp.repositories.CurrencyRateRepository;
import com.example.start.currencies.currencyApp.repositories.PaymentRepository;
import com.example.start.currencies.currencyApp.services.*;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

@Log
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private NpbCurrencyService currencyService;
    @Autowired
    private CurrencyRateRepository repo;
    @Autowired
    private JpaAccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private JpaAccountBalanceChangeService accountBalanceChangeService;


    @GetMapping
    public String calculate (Model model){

        BigDecimal amount = BigDecimal.valueOf(200);
        CurrencyRateDto currencyRate = new CurrencyRateDto("polski zloty", "PLN" , 1);
        CurrencyRateDto currencyRate1 = new CurrencyRateDto("dolar amerykański", "USD" , 4.3363);
        BigDecimal result = currencyService.calculateToCurrency(amount, currencyRate, currencyRate1);
        System.out.println(result);
        AccountBalanceChange accountBalanceChange = new AccountBalanceChange();
        accountBalanceChange.setDeposit(true);
        accountBalanceChange.setDateTime();
        accountBalanceChange.setAmount(BigDecimal.valueOf(200));
        accountBalanceChange.setAccountProfile(accountRepository.findById(1l).get());

        accountService.addDepositOrWithdraw(accountBalanceChange, accountService.findById(1).get());



        Payment payment = new Payment();
        payment.setAmount(BigDecimal.valueOf(200));
        payment.setCurrency("PLN");
        payment.setAccountProfileNumber("1234");
        payment.setDatetime();
        payment.setAccountProfile(accountRepository.findById(1l).get());


        System.out.println(paymentRepository.save(payment));
        System.out.println(accountService.findById(1));



















        return "test";
    }
}
