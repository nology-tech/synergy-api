package com.nology.synergyapi.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nology.synergyapi.model.Account;
import com.nology.synergyapi.model.Transaction;
import com.nology.synergyapi.model.User;
import com.nology.synergyapi.repository.AccountRepository;
import com.nology.synergyapi.repository.TransactionRepository;
import com.nology.synergyapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public  List<Transaction> getTransactionData() throws IOException {
        return transactionRepository.findAll();
    }

    public  List<Transaction> getTransactionByUserId(Long userID) throws IOException {
        Account account=accountRepository.findByUserID(userID);
        return account.getTransactions();
    }

//    public Transaction createTransaction(RequestBody transaction) {
//        transactionRepository.save(transaction);
//        return transaction;
//    }
}
