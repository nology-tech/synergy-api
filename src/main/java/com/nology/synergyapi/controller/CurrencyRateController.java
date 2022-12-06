package com.nology.synergyapi.controller;

import com.nology.synergyapi.model.Currency;
import com.nology.synergyapi.model.CurrencyRate;
import com.nology.synergyapi.model.FXCodesNames;
import com.nology.synergyapi.service.CurrencyNamesService;
import com.nology.synergyapi.service.CurrencyService;
import com.nology.synergyapi.service.FXRateService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins  =  "http://localhost:3000")
public class CurrencyRateController {
    @GetMapping("/currencyrates")
    public List<CurrencyRate> getAllCurrencyRates() throws IOException {
        List<Currency> currencydetails = CurrencyService.getCurrencyData();
        String[][] currencynames = CurrencyNamesService.getCurrencyNames().getSupported_codes();
        // convert array of arrays of names to a hashmap so we can find a currency code / currency name pair
        Map<String, String> hashMapNames = new HashMap<String, String>();
        for (String[] name :currencynames) {
            String ccode = name[0];
            String cname = name[1];
            hashMapNames.put(ccode, cname);
        }
        HashMap<String, Double> rates = FXRateService.getFXRateData().getConversion_rates();
        // adding USD manually as a first element as it cannot cast rate 1 to double
        Currency usdCurrency = currencydetails.stream().filter(currency -> currency.getCode().equals("USD")).collect(Collectors.toList()).get(0);
        CurrencyRate usdCurrencyRate = new CurrencyRate(usdCurrency.getCode(), usdCurrency.getFlag(), usdCurrency.getCountryName(), hashMapNames.get(usdCurrency.getCode()), usdCurrency.getSymbol(), 1.000);
        List<CurrencyRate> currencyRates = new ArrayList<>();
        currencyRates.add(usdCurrencyRate);

        // construct rates array with currency details
        currencydetails.forEach (currency -> {
             if (rates.get(currency.getCode())!=null && !currency.getCode().equals("USD")) {
                 CurrencyRate currencyRate = new CurrencyRate(currency.getCode(), currency.getFlag(), currency.getCountryName(), hashMapNames.get(currency.getCode()), currency.getSymbol(), rates.get(currency.getCode()));
                 currencyRates.add(currencyRate);
             }
        });
        return currencyRates;
    }
}
