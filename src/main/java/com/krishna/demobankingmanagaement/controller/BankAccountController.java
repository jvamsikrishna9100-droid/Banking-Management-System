package com.krishna.demobankingmanagaement.controller;

import com.krishna.demobankingmanagaement.dto.BankAccountDTO;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

import com.krishna.demobankingmanagaement.entity.BankAccount;
import com.krishna.demobankingmanagaement.exception.ResourceNotFoundException;
import com.krishna.demobankingmanagaement.service.BankAccountService;

@RestController
@RequestMapping("/api/accounts")
public class BankAccountController {

	private final BankAccountService bankAccountService;

	public BankAccountController(BankAccountService bankAccountService) {
		this.bankAccountService = bankAccountService;
	}

	// Create Bank Account
	@PostMapping
	public BankAccountDTO createAccount(@RequestBody BankAccount bankAccount) {

		BankAccount savedAccount = bankAccountService.createAccount(bankAccount);

		return BankAccountDTO.fromEntity(savedAccount);
	}

	// Get All Bank Accounts
	@GetMapping
	public List<BankAccountDTO> getAllAccounts() {

		return bankAccountService.getAllAccounts().stream().map(BankAccountDTO::fromEntity).toList();
	}

	// Get Account By ID
	@GetMapping("/{id}")
	public ResponseEntity<BankAccountDTO> getAccountById(@PathVariable Long id) {

		return bankAccountService.getAccountById(id).map(BankAccountDTO::fromEntity).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}/deposit")
	public ResponseEntity<BankAccountDTO> depositMoney(@PathVariable Long id, @RequestParam BigDecimal amount) {

		BankAccount account = bankAccountService.depositMoney(id, amount);

		return ResponseEntity.ok(BankAccountDTO.fromEntity(account));
	}

	@PutMapping("/{id}/withdraw")
	public ResponseEntity<BankAccountDTO> withdrawMoney(@PathVariable Long id, @RequestParam BigDecimal amount) {

		BankAccount account = bankAccountService.withdrawMoney(id, amount);

		return ResponseEntity.ok(BankAccountDTO.fromEntity(account));
	}
	
	@GetMapping("/{id}/balance")
	public ResponseEntity<BankAccountDTO> checkBalance(@PathVariable Long id) {

	    BankAccount account = bankAccountService.getAccountById(id)
	            .orElseThrow(() -> new ResourceNotFoundException(
	                    "Bank account not found with ID: " + id));

	    return ResponseEntity.ok(BankAccountDTO.fromEntity(account));
	}

	@PutMapping("/transfer")
	public ResponseEntity<String> transferMoney(@RequestParam Long fromId, @RequestParam Long toId,
			@RequestParam BigDecimal amount) {

		bankAccountService.transferMoney(fromId, toId, amount);

		return ResponseEntity.ok("Money transferred successfully!");
	}

}