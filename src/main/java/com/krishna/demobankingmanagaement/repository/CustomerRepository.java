package com.krishna.demobankingmanagaement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.krishna.demobankingmanagaement.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}



//interface    : Defines a repository contract.
//JpaRepository: Provides ready-made database operations.
//Customer     : Our entity class.
//Long         : Data type of the primary key.