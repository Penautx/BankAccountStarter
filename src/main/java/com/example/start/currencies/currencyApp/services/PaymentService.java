package com.example.start.currencies.currencyApp.services;

import com.example.start.currencies.currencyApp.entities.AccountProfile;
import com.example.start.currencies.currencyApp.entities.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService {

    List<Payment> findAll();
    Optional<Payment> findById (long id);
    Payment save (Payment payment);

}
