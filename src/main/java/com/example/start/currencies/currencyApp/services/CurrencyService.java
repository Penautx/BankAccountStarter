package com.example.start.currencies.currencyApp.services;

import com.example.start.currencies.currencyApp.api.CurrencyRateDto;


import java.math.BigDecimal;
import java.util.Optional;

public interface CurrencyService {

    BigDecimal calculateToCurrency(BigDecimal amount, CurrencyRateDto currencyRateBefore, CurrencyRateDto currencyRateAfter);

    Optional<CurrencyRateDto> findRateByCode(String code);


}
