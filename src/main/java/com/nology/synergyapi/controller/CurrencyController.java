package com.nology.synergyapi.controller;

import com.nology.synergyapi.model.Currency;
import com.nology.synergyapi.service.CurrencyNamesService;
import com.nology.synergyapi.service.CurrencyService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins  =  "http://localhost:3000")
public class CurrencyController {
    @GetMapping("/currencies")
    public static List<Currency> getAllCurrencies() throws IOException {
        //Currency currency = new Currency();
        List<Currency> currencyList = new ArrayList<>();
        List<Currency> currencydetails = CurrencyService.getCurrencyData();
        String[][] currencynames = CurrencyNamesService.getCurrencyNames().getSupported_codes();
        // convert array of arrays of names to a hashmap so we can find a currency code / currency name pair
        Map<String, String> hashMapNames = new HashMap<String, String>();
        for (String[] name :currencynames) {
            String ccode = name[0];
            String cname = name[1];
            hashMapNames.put(ccode, cname);
        }
        currencydetails.forEach (currency -> {
                Currency enrichedcurrency = new Currency(currency.getCode(), currency.getFlag(), currency.getCountryName(), hashMapNames.get(currency.getCode()), currency.getSymbol());
                currencyList.add(enrichedcurrency);
            });
        return currencyList;
    }

    @GetMapping("/currencies/{myCode}")
    public Currency getCurrencyByCode(@PathVariable String myCode) throws IOException {
        String[][] currencynames = CurrencyNamesService.getCurrencyNames().getSupported_codes();
        // convert array of arrays of names to a hashmap so we can find a currency code / currency name pair
        Map<String, String> hashMapNames = new HashMap<String, String>();
        for (String[] name :currencynames) {
            String ccode = name[0];
            String cname = name[1];
            hashMapNames.put(ccode, cname);
        }
        Currency currencydetails = CurrencyService.getCurrencyData().stream().filter(currency -> currency.getCode().equals(myCode)).collect(Collectors.toList()).get(0);
        Currency enrichedcurrency = new Currency(currencydetails.getCode(), currencydetails.getFlag(), currencydetails.getCountryName(), hashMapNames.get(currencydetails.getCode()), currencydetails.getSymbol());
        return enrichedcurrency;

    }


}
