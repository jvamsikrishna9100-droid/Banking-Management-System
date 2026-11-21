package com.krishna.demobankingmanagaement.exception;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String message) {
		super(message);

//        extends RuntimeException – Creates our own custom exception.
//        ResourceNotFoundException – Represents a resource (such as a bank account) that doesn't exist.
//        super(message) – Passes the error message to the parent exception class.

	}
}