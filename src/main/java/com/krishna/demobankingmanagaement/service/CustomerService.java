package com.krishna.demobankingmanagaement.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.krishna.demobankingmanagaement.entity.Customer;
import com.krishna.demobankingmanagaement.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
	
	public Optional<Customer> getCustomerById(Long id) {
	    return customerRepository.findById(id);
	}
	
	public Optional<Customer> updateCustomer(Long id, Customer updatedCustomer) {

	    Optional<Customer> existingCustomer = customerRepository.findById(id);

	    if (existingCustomer.isPresent()) {

	        Customer customer = existingCustomer.get();

	        customer.setName(updatedCustomer.getName());
	        customer.setEmail(updatedCustomer.getEmail());
	        customer.setPhone(updatedCustomer.getPhone());
	        customer.setAddress(updatedCustomer.getAddress());

	        return Optional.of(customerRepository.save(customer));
	    }

	    return Optional.empty();
	}
	
	public boolean deleteCustomer(Long id) {

	    if (customerRepository.existsById(id)) {

	        customerRepository.deleteById(id);

	        return true;
	    }

	    return false;
	}
	
}

//@Service tells Spring that this class contains business logic.
//@Autowired injects the repository into the service.
//createCustomer() receives customer details.
//save() stores the customer in MySQL.
//What does findById() do?
//It searches for a customer using the primary key (ID) in your MySQL database.
//findById(id) – searches for the customer.
//isPresent() – checks whether the customer exists.
//get() – retrieves the existing customer.
//setName() and other setters – update the customer's details.
//save() – saves the updated customer into MySQL.
//Optional.empty() – indicates that the customer was not found.
//existsById(id) – checks whether the customer exists.
//deleteById(id) – deletes the customer from MySQL.
//return true – deletion successful.
//return false – customer not found.







