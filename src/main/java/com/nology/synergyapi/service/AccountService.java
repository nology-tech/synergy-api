package com.nology.synergyapi.service;
//
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.nology.synergyapi.model.Account;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//import java.util.Optional;

public class AccountService {
//    private static ObjectMapper objectMapper = new ObjectMapper();
//
//    public static List<Account> getAccountData() throws IOException {
//        List<Account> accountData = objectMapper.readValue(new File("src/main/java/com/nology/synergyapi/data/accounts.json"), new TypeReference<List<Account>>() { });
//        return accountData;
//    }
//    public static Optional<Account> getAccountByID(String accountID) throws IOException {
//        Optional<Account> accountData = getAccountData().stream().filter(Account -> Account.getAccountID().equals(accountID)).findFirst();
//        System.out.println(accountData);
//        return accountData;
//    }
}