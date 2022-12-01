package com.nology.synergyapi.controller;

import com.nology.synergyapi.model.Currency;
import com.nology.synergyapi.model.FXRate;
import com.nology.synergyapi.service.CurrencyService;
import com.nology.synergyapi.service.FXRateService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


    @RestController
    @CrossOrigin(origins  =  "http://localhost:3000")
    public class FXController {
        @GetMapping("/fxrates")
        public FXRate getAllFXRates() throws IOException {
            return FXRateService.getFXRateData();
        }

//        @GetMapping("/fxrates/{currencyCode}")
//        public Currency getCurrencyByCode(@PathVariable String currencyCode) throws IOException {
//            return FXRateService.getCurrencyData().stream().filter(
//                    currency -> currency.getCode().equals(currencyCode)).collect(Collectors.toList()).get(0);
//        }

}
