package com.nology.synergyapi.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nology.synergyapi.model.FXRate;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FXRateService {

    public static FXRate getFXRateData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        FXRate fxrate = objectMapper.readValue(
                new File("src/main/java/com/nology/synergyapi/data/exchangerate.json"), FXRate.class);
        return fxrate;
    }
}
