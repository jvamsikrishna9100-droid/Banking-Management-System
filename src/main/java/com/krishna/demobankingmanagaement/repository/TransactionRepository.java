package com.krishna.demobankingmanagaement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krishna.demobankingmanagaement.entity.Transaction;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	List<Transaction> findByAccountId(Long accountId);
}



//- Transaction  →   Entity class.
//- Long		 →   Data type of the primary key (id).
//  By extending JpaRepository, we automatically get methods such as:
//- save()		 –>  Save transaction.
//- findAll() 	 –>  Get all transactions.
//- findById()   –>  Get transaction by ID.
//- deleteById() –>  Delete transaction.