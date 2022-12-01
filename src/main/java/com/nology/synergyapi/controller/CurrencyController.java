package com.nology.synergyapi.controller;


import com.nology.synergyapi.model.Currency;
import com.nology.synergyapi.service.CurrencyService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins  =  "http://localhost:8080")
public class CurrencyController {
    @GetMapping("/currencies")
    public List<Currency> getAllCurrencies() throws IOException {
        return CurrencyService.getCurrencyData();
    }

    @GetMapping("/currencies/{myCode}")
    public Currency getCurrencyByCode(@PathVariable String myCode) throws IOException {
        return CurrencyService.getCurrencyData().stream().filter(currency -> currency.getCode().equals(myCode)).collect(Collectors.toList()).get(0);
    }
}
