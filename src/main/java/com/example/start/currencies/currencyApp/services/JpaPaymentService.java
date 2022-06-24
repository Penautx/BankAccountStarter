package com.example.start.currencies.currencyApp.services;

import com.example.start.currencies.currencyApp.entities.Payment;
import com.example.start.currencies.currencyApp.repositories.PaymentRepository;

import java.util.List;
import java.util.Optional;

public class JpaPaymentService implements PaymentService {

    private PaymentRepository paymentRepository;

    public JpaPaymentService(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }



    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Optional<Payment> findById(long id) {
        return Optional.empty();
    }

    @Override
    public Payment save(Payment payment) {
        return null;
    }
}
