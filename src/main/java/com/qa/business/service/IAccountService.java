package com.qa.business.service;

public interface IAccountService {

	String listAllAccounts();
	
	String createAccount(String JSONAccount);
	
	String deleteAccount(Long id);
}
