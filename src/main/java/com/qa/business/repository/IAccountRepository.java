package com.qa.business.repository;

public interface IAccountRepository {
	
	String listAllAccounts();
	String createAccount(String accountJSON);
	String deleteAccount(Long id);
	String updateAccount(String accountJSON);

}
