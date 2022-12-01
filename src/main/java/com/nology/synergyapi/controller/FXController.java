package com.nology.synergyapi.controller;

import com.nology.synergyapi.model.Currency;
import com.nology.synergyapi.model.FXRate;
import com.nology.synergyapi.model.FXRateFullAPI;
import com.nology.synergyapi.service.CurrencyService;
import com.nology.synergyapi.service.FXRateService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


    @RestController
    @CrossOrigin(origins  =  "http://localhost:3000")
    public class FXController {
        @GetMapping("/fxrates")
        public HashMap getAllFXRates() throws IOException {
            return FXRateService.getFXRateData().getConversion_rates();
        }

        @GetMapping("/fxrates/{currencyCode}")
        public Object getCurrencyByCode(@PathVariable String currencyCode) throws IOException {
            return FXRateService.getFXRateData().getConversion_rates().get(currencyCode);

        }

}
