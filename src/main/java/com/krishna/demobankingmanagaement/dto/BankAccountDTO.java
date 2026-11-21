package com.krishna.demobankingmanagaement.dto;

import java.math.BigDecimal;

import com.krishna.demobankingmanagaement.entity.BankAccount;

public class BankAccountDTO {

    private Long id;
    private String accountNumber;
    private String accountType;
    private BigDecimal balance;
    private Long customerId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public static BankAccountDTO fromEntity(BankAccount account) {

	    BankAccountDTO dto = new BankAccountDTO();

	    dto.setId(account.getId());
	    dto.setAccountNumber(account.getAccountNumber());
	    dto.setAccountType(account.getAccountType());
	    dto.setBalance(account.getBalance());
	    dto.setCustomerId(account.getCustomer().getId());

	    return dto;
	}

}