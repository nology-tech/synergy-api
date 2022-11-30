package com.nology.synergyapi.controller;

import com.nology.synergyapi.service.CurrencyService;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.h2.util.json.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Currency;
import java.util.List;

@RestController
@CrossOrigin(origins  =  "http://localhost:3000")
public class CurrencyController {
    @GetMapping("/currencies")
//    public ResponseEntity<Map<String, Object>> getAllCurrencies() throws IOException {
//        ClassPathResource staticDataResource = new ClassPathResource("world_currency_symbols.json");
//        String staticDataString = IOUtils.toString(staticDataResource.getInputStream(), StandardCharsets.UTF_8);
//
//        return new ResponseEntity<>(
//                new JSONObject(staticDataString).toMap(),
//                HttpStatus.OK
//        );
//    }
    public void getAllCurrencies() throws IOException {
        CurrencyService.getCurrencyData();
//        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }
}
