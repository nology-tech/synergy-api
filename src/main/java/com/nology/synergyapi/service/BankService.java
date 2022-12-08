package com.nology.synergyapi.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nology.synergyapi.model.Bank;

import java.io.File;
import java.io.IOException;
import java.util.Currency;
import java.util.List;

public class BankService {

    public static List<Bank> getBankData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Bank> bankData = objectMapper.readValue(new File("src/main/java/com/nology/synergyapi/data/banks.json"),new TypeReference<List<Bank>>() { });
        return bankData;
    }

    }