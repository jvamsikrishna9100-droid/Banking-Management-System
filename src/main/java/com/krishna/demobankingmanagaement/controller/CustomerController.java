package com.krishna.demobankingmanagaement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.krishna.demobankingmanagaement.entity.Customer;
import com.krishna.demobankingmanagaement.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@PostMapping
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerService.createCustomer(customer);
	}

	@GetMapping
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
	    return ResponseEntity.of(customerService.getCustomerById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Customer> updateCustomer(
	        @PathVariable Long id,
	        @RequestBody Customer customer) {

	    return ResponseEntity.of(customerService.updateCustomer(id, customer));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {

	    boolean deleted = customerService.deleteCustomer(id);

	    if (deleted) {
	        return ResponseEntity.noContent().build();
	    }

	    return ResponseEntity.notFound().build();
	}
	
}






