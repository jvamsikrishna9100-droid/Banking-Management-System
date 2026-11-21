package com.krishna.demobankingmanagaement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity //@Entity means what --->  Maps Java class to a database table
public class Customer {

	public Customer(Long id, String name, String email, String phone, String address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	@Id // @Id means what  ---> Defines the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	//	@GeneratedValue	means  --->  Automatically generates ID
    //GenerationType.IDENTITY  --->   Uses MySQL auto-increment
	
	private Long id;

	private String name;

	private String email;

	private String phone;

	private String address;
	
	public Customer() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
