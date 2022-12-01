package com.nology.synergyapi.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.nology.synergyapi.model.Currency;
import com.nology.synergyapi.service.CurrencyService;
import org.h2.util.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@RestController
@CrossOrigin(origins  =  "http://localhost:3000")
public class CurrencyController {
    @GetMapping("/currencies")
    public List<Currency> getAllCurrencies() throws IOException {
        return CurrencyService.getCurrencyData();
    }
}
