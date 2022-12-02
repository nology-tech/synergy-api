package com.nology.synergyapi.controller;

import com.nology.synergyapi.service.FXRateService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;


    @RestController
    @CrossOrigin(origins  =  "http://localhost:3000")
    public class FXController {
        @GetMapping("/fxrates")
        public HashMap getAllFXRates() throws IOException {
            return FXRateService.getFXRateData().getConversion_rates();
        }

        @GetMapping("/fxrates/{currencyCode}")
        public Object getRateByCode(@PathVariable String currencyCode) throws IOException {
            return FXRateService.getFXRateData().getConversion_rates().get(currencyCode);

        }

}
