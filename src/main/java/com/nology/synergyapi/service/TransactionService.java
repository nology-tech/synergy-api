package com.nology.synergyapi.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nology.synergyapi.model.Transaction;
import com.nology.synergyapi.model.User;
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
    private static UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public  List<Transaction> getTransactionData() throws IOException {
        return transactionRepository.findAll();
    }

    public  List<Transaction> getTransactionByUserId(Long userId) throws IOException {

        User user=userRepository.findById(userId).orElse(null);
        return user.getAccount().getTransactions();
    }

    public Transaction createTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
        return transaction;
    }
}
