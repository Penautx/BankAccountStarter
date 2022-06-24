package com.example.start.currencies.currencyApp.repositories;

import com.example.start.currencies.currencyApp.entities.AccountBalanceChange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountBalanceChangeRepository extends JpaRepository <AccountBalanceChange, Long> {

}
