package com.example.start.currencies.currencyApp.services;
import com.example.start.currencies.currencyApp.api.CurrencyRateDto;
import com.example.start.currencies.currencyApp.repositories.CurrencyRateRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class NpbCurrencyServiceTestRate {
    @Mock
    private CurrencyRateRepository repository;
    @InjectMocks
    private NpbCurrencyService service;


    @Test
    public void isAmountCorrectAfterConversion(){

        BigDecimal amount = BigDecimal.valueOf(10);
        CurrencyRateDto currencyRate = new CurrencyRateDto("euro", "EUR" , 4.603);
        CurrencyRateDto currencyRate1 = new CurrencyRateDto("dolar amerykański", "USD" , 4.3363);
        CurrencyRateDto currencyRate2 = new CurrencyRateDto("polski złoty", "PLN" , 1.0);


        assertEquals(BigDecimal.valueOf(1062, 2), service.calculateToCurrency(amount, currencyRate, currencyRate1));
        assertEquals(BigDecimal.valueOf(1001, 2), service.calculateToCurrency(BigDecimal.valueOf(10.62), currencyRate1, currencyRate));
        assertEquals(BigDecimal.valueOf(0), service.calculateToCurrency(BigDecimal.valueOf(0), currencyRate, currencyRate1));
        assertEquals(BigDecimal.valueOf(2.31), service.calculateToCurrency(BigDecimal.valueOf(10), currencyRate2, currencyRate1));
        assertEquals(BigDecimal.valueOf(10.42), service.calculateToCurrency(BigDecimal.valueOf(10.42), currencyRate2, currencyRate2));

    }

}