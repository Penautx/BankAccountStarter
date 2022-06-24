package com.example.start.currencies.currencyApp.api;
import com.example.start.currencies.currencyApp.repositories.CurrencyRateRepository;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.List;

@Service
@Log
public class NbpApiCurrencyRate implements CurrencyRateRepository {
    @Override
    public List<CurrencyRateDto> findAll() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            URI uri = UriComponentsBuilder.fromHttpUrl("https://api.nbp.pl/api/exchangerates/tables/A?format=json")
                    .build().toUri();

            TableRates[] table = restTemplate.getForObject(uri, TableRates[].class);

            return table[0].getRates();
        } catch (RestClientException e) {
            e.printStackTrace();
        }
        return null;
    }
}
