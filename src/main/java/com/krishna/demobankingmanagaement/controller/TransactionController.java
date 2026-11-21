package com.krishna.demobankingmanagaement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krishna.demobankingmanagaement.entity.Transaction;
import com.krishna.demobankingmanagaement.repository.TransactionRepository;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionRepository transactionRepository;

    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    // Get All Transactions
    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
        
//      - @RestController – Handles REST API requests.
//      - @RequestMapping("/api/transactions") – Sets the base URL.
//      - @GetMapping – Handles GET requests.
//      - findAll() – Retrieves all transaction records from MySQL.
        
    }
    @GetMapping("/account/{accountId}")
    public List<Transaction> getTransactionsByAccountId(
            @PathVariable Long accountId) {

        return transactionRepository.findByAccountId(accountId);
        
//        /api/transactions → Base URL.
//        /account/1 → Requests transactions for Account ID 1.
//        @PathVariable → Extracts 1 from the URL.
    }
    

   
    
}