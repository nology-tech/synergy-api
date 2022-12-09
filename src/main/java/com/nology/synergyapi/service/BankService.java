package com.nology.synergyapi.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nology.synergyapi.model.Bank;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Currency;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankService {

    public static List<Bank> getBankData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Bank> bankData = objectMapper.readValue(new File("src/main/java/com/nology/synergyapi/data/banks.json"),new TypeReference<List<Bank>>() { });
        return bankData;
    }

    public static Bank getBank(String sortCode) throws IOException {
        System.out.println(sortCode);
        System.out.println(getBankData());
        System.out.println(getBankData().stream().filter(banks -> banks.getSortCode().equals(sortCode)));
        return getBankData().stream().filter(banks -> banks.getSortCode().equals(sortCode)).collect(Collectors.toList()).get(0);
    }

    }