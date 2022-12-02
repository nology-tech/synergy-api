package com.nology.synergyapi.controller;

import com.nology.synergyapi.model.Currency;
import com.nology.synergyapi.model.CurrencyRate;
import com.nology.synergyapi.service.CurrencyService;
import com.nology.synergyapi.service.FXRateService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins  =  "http://localhost:3000")
public class CurrencyRateController {
    @GetMapping("/currencyrates")
    public List<CurrencyRate> getAllCurrencyRates() throws IOException {
        List<Currency> currencydetails = CurrencyService.getCurrencyData();
        HashMap<String, Double> rates = FXRateService.getFXRateData().getConversion_rates();
        // adding USD manually as a first element as it cannot cast rate 1 to double
        Currency usdCurrency = currencydetails.stream().filter(currency -> currency.getCode().equals("USD")).collect(Collectors.toList()).get(0);
        CurrencyRate usdCurrencyRate = new CurrencyRate(usdCurrency.getCode(), usdCurrency.getFlag(), usdCurrency.getCountryName(), usdCurrency.getCurrency(), usdCurrency.getSymbol(), 1.000);
        List<CurrencyRate> currencyRates = new ArrayList<>();
        currencyRates.add(usdCurrencyRate);
        // construct rates array with currency details
        currencydetails.forEach (currency -> {
             if (rates.get(currency.getCode())!=null && !currency.getCode().equals("USD")) {
                CurrencyRate currencyRate = new CurrencyRate(currency.getCode(), currency.getFlag(), currency.getCountryName(), currency.getCurrency(), currency.getSymbol(), rates.get(currency.getCode()));
                 currencyRates.add(currencyRate);
             }
        });
        return currencyRates;
    }
}
