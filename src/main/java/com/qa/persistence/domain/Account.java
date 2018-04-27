package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long accountNumber;
	private String firstName;
	private String SecondName;
	
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return SecondName;
	}
	public void setSecondName(String secondName) {
		SecondName = secondName;
	}
	
	public Account() {
		
	}
	
	public Account(Long accountNumber, String firstName, String secondName) {
		this.accountNumber = accountNumber;
		this.firstName = firstName;
		this.SecondName = secondName;
		
	}

}
