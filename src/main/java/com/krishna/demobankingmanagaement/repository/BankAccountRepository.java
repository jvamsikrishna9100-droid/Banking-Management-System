package com.krishna.demobankingmanagaement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krishna.demobankingmanagaement.entity.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

	boolean existsByAccountNumber(String accountNumber);
	
	
//	BankAccount –--> the entity this repository manages.
//	Long –--> the data type of the primary key (id).
//	By extending JpaRepository, you automatically get methods such as:
//	Method	Purpose
//	save()	Save a bank account
//	findAll()	Retrieve all accounts
//	findById()	Find an account by ID
//	deleteById()	Delete an account
//	existsById()	Check whether an account exists
	
}