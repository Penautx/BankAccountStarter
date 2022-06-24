package com.example.start.currencies.currencyApp;

import com.example.start.currencies.currencyApp.api.NbpApiCurrencyRate;
import com.example.start.currencies.currencyApp.services.NpbCurrencyService;
import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Log
@SpringBootApplication
public class CurrencyAppApplication implements WebMvcConfigurer {


	public static void main(String[] args) {


		SpringApplication.run(CurrencyAppApplication.class, args);

		NbpApiCurrencyRate apiOfCurrencyAndRates = new NbpApiCurrencyRate();
		log.info(apiOfCurrencyAndRates.findAll().toString());


	}

}
