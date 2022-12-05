package com.nology.synergyapi.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nology.synergyapi.model.Transaction;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class TransactionService {
    private static ObjectMapper objectMapper = new ObjectMapper();
//    List<UserProfile> userData = objectMapper.readValue(new File("src/main/java/com/nology/synergyapi/data/users.json"), new TypeReference<List<UserProfile>>() { });

    public static List<Transaction> getTransactionData() throws IOException {
        List<Transaction> transactionData = objectMapper.readValue(new File("src/main/java/com/nology/synergyapi/data/users.json"), new TypeReference<List<Transaction>>() { });
        return transactionData;
    }

    public static Optional<Transaction> getTransactionByUserID(Long tid) throws IOException {
        Optional<Transaction> userData = getTransactionData().stream().filter(userProfile -> userProfile.get()==tid).findFirst();
        System.out.println(userData);
        return userData;
    }
}
