package com.nology.synergyapi.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nology.synergyapi.model.Currency;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class CurrencyService {
    public static List<Currency> getCurrencyData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Currency> currencyData = objectMapper.readValue(new File("src/main/java/com/nology/synergyapi/data/world_currency_symbols.json"), new TypeReference<List<Currency>>() { });
        return currencyData;
    }
}
