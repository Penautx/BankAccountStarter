package com.example.start.currencies.currencyApp.repositories;

import com.example.start.currencies.currencyApp.api.CurrencyRateDto;

import java.util.List;

public interface CurrencyRateRepository {

    List<CurrencyRateDto> findAll();
}
