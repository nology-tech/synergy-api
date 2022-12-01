package com.nology.synergyapi.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nology.synergyapi.model.FXRate;
import com.nology.synergyapi.model.FXRateFullAPI;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FXRateService {

    public static FXRateFullAPI getFXRateData() throws IOException {
      //  ObjectMapper objectMapper = new ObjectMapper();
//        FXRateFullAPI fxrate = objectMapper.readValue(
//                new File("src/main/java/com/nology/synergyapi/data/exchangerate.json"), FXRateFullAPI.class);

        String url = "https://v6.exchangerate-api.com/v6/4c65c48d303418aba580438b/latest/USD";
        RestTemplate restTemplate = new RestTemplate();
        FXRateFullAPI fxrate = restTemplate.getForObject(url, FXRateFullAPI.class);
        return fxrate;
    }
}
