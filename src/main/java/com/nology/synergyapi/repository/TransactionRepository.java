package com.nology.synergyapi.repository;

import com.nology.synergyapi.model.Transaction;
import com.nology.synergyapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
    Transaction findByTxnID(String txnID);
}