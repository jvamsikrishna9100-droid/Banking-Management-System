package com.krishna.demobankingmanagaement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krishna.demobankingmanagaement.entity.BankAccount;
import com.krishna.demobankingmanagaement.repository.BankAccountRepository;

import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import java.time.LocalDateTime;

import com.krishna.demobankingmanagaement.entity.Transaction;
import com.krishna.demobankingmanagaement.exception.ResourceNotFoundException;
import com.krishna.demobankingmanagaement.repository.TransactionRepository;

@Service
public class BankAccountService {

	@Autowired
	private BankAccountRepository bankAccountRepository;

	// Create Bank Account
	public BankAccount createAccount(BankAccount bankAccount) {

		if (bankAccountRepository.existsByAccountNumber(bankAccount.getAccountNumber())) {
			throw new IllegalArgumentException("Account number already exists");
		}

		return bankAccountRepository.save(bankAccount);
	}

	// Get All Bank Accounts
	public List<BankAccount> getAllAccounts() {
		return bankAccountRepository.findAll();
	}

	// Get Bank Account By ID
	public Optional<BankAccount> getAccountById(Long id) {
		return bankAccountRepository.findById(id);
	}

	@Transactional
	public BankAccount depositMoney(Long id, BigDecimal amount) {

		if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
			throw new IllegalArgumentException("Amount must be greater than zero");
		}

		Optional<BankAccount> optionalAccount = bankAccountRepository.findById(id);

		if (optionalAccount.isPresent()) {

			BankAccount account = optionalAccount.get();

			account.setBalance(account.getBalance().add(amount));

			bankAccountRepository.save(account);

			saveTransaction(account, "DEPOSIT", amount);

			return account;
		}

		return null;
	}

	@Transactional
	public BankAccount withdrawMoney(Long id, BigDecimal amount) {

		if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
			throw new IllegalArgumentException("Amount must be greater than zero");
		}

		BankAccount account = bankAccountRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Bank account not found with ID: " + id));

		if (account.getBalance().compareTo(amount) < 0) {
			throw new IllegalArgumentException("Insufficient balance");
		}

		account.setBalance(account.getBalance().subtract(amount));

		bankAccountRepository.save(account);

		saveTransaction(account, "WITHDRAW", amount);

		return account;
	}

	public BigDecimal checkBalance(Long id) {

		BankAccount account = bankAccountRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Bank account not found with ID: " + id));

		return account.getBalance();

//	    Meaning of this
//	    .orElseThrow(() -> new RuntimeException("bank account not found with the iD"));
//	    		If the account exists → return its balance.
//	    		If the account doesn't exist → throw an exception.
	}

	@Transactional
	public void transferMoney(Long fromId, Long toId, BigDecimal amount) {

		if (fromId == null || toId == null) {
			throw new IllegalArgumentException("Account IDs cannot be null");
		}

		if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
			throw new IllegalArgumentException("Transfer amount must be greater than zero");
		}

		if (fromId.equals(toId)) {
			throw new IllegalArgumentException("Cannot transfer money to the same account");
		}

		BankAccount fromAccount = bankAccountRepository.findById(fromId)
				.orElseThrow(() -> new RuntimeException("Source account not found"));

		BankAccount toAccount = bankAccountRepository.findById(toId)
				.orElseThrow(() -> new RuntimeException("Destination account not found"));

		if (fromAccount.getBalance().compareTo(amount) < 0) {
			throw new RuntimeException("Insufficient balance");
		}

		fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
		toAccount.setBalance(toAccount.getBalance().add(amount));

		bankAccountRepository.save(fromAccount);
		bankAccountRepository.save(toAccount);

		saveTransaction(fromAccount, "TRANSFER_SENT", amount);
		saveTransaction(toAccount, "TRANSFER_RECEIVED", amount);
	}
//	 		What is @Transactional?
//
//			Imagine money is deducted from Account 1, but an error occurs before it reaches Account 2.
//
//			@Transactional ensures that both database updates succeed together or are rolled back together when an exception occurs.

	@Autowired
	private TransactionRepository transactionRepository;

	private void saveTransaction(BankAccount account, String type, BigDecimal amount) {

		Transaction transaction = new Transaction();

		transaction.setTransactionType(type);
		transaction.setAmount(amount);
		transaction.setTransactionDate(LocalDateTime.now());
		transaction.setAccount(account);

		transactionRepository.save(transaction);
	}

}