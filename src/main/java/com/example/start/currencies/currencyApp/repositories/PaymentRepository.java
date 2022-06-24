package com.example.start.currencies.currencyApp.repositories;

import com.example.start.currencies.currencyApp.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
