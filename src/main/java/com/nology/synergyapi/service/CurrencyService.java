package com.nology.synergyapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nology.synergyapi.model.Currency;
import org.apache.tomcat.util.json.JSONParser;
import org.h2.util.json.JSONArray;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CurrencyService {

    public static void getCurrencyData() throws IOException {
//        JSONParser parser = new JSONParser();
//        JSONArray currencyData = (JSONArray) parser.parse(new FileReader("../data/world_currency_symbols.json"));
        ObjectMapper objectMapper = new ObjectMapper();
        Currency currency = objectMapper.readValue(new File("../data/world_currency_symbols.json"), Currency.class);
        System.out.println(currency);
    }


}
