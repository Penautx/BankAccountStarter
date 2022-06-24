package com.example.start.currencies.currencyApp.services;

import com.example.start.currencies.currencyApp.api.CurrencyRateDto;
import com.example.start.currencies.currencyApp.repositories.CurrencyRateRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Optional;

@Service
public class NpbCurrencyService implements CurrencyService {
    private final CurrencyRateRepository currencyRateRepository;

    public NpbCurrencyService(CurrencyRateRepository currencyRateRepository) {
        this.currencyRateRepository = currencyRateRepository;
    }

    @Override
    public BigDecimal calculateToCurrency(BigDecimal amount, CurrencyRateDto currencyRateBefore, CurrencyRateDto currencyRateTarget) {

        BigDecimal midCurrencyBefore = new BigDecimal(currencyRateBefore.getMid());
        BigDecimal midCurrencyTarget = new BigDecimal(currencyRateTarget.getMid());

        return amount.multiply(
                midCurrencyBefore.divide(
                        midCurrencyTarget, new MathContext(32)
                        )
                ).setScale(2,RoundingMode.UP).stripTrailingZeros();

    }

    @Override
    public Optional<CurrencyRateDto> findRateByCode(String code) {

        if (code.equals("PLN")){
            return Optional.of(new CurrencyRateDto("Polski złoty", "PLN" , 1));
        }

        return currencyRateRepository.findAll()
                .stream()
                .filter(rate -> rate.getCode().equals(code))
                .findFirst();
    }


}
