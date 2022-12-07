package com.nology.synergyapi.controller;

import com.nology.synergyapi.service.CurrencyNamesService;
import com.nology.synergyapi.service.FXRateService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;

@RestController
@CrossOrigin(origins  =  "http://localhost:3000")
public class CurrencyNamesController {
    @GetMapping("/currencynames")
    public String[][] getAllCurrencyNames() throws IOException {
        return CurrencyNamesService.getCurrencyNames().getSupported_codes();
    }
}
