package com.nology.synergyapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nology.synergyapi.model.FXCodesNames;
import com.nology.synergyapi.model.FXRateFullAPI;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;

public class CurrencyNamesService {
    public static FXCodesNames getCurrencyNames() throws IOException {
        // Uncomment to take data from the downloaded file and comment 24-26
        ObjectMapper objectMapper = new ObjectMapper();
        FXCodesNames codenames = objectMapper.readValue(
                new File("src/main/java/com/nology/synergyapi/data/codesnames.json"), FXCodesNames.class);

        // Comment to take data from the downloaded file and uncomment lines 19-21
//        String url = "https://v6.exchangerate-api.com/v6/4c65c48d303418aba580438b/codes";
//        RestTemplate restTemplate = new RestTemplate();
//        FXCodesNames codenames = restTemplate.getForObject(url, FXCodesNames.class);
        return codenames;
    }
}
