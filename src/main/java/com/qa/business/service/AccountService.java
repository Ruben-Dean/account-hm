package com.qa.business.service;

import javax.inject.Inject;

import com.qa.business.repository.IAccountRepository;

public class AccountService implements IAccountService{
	
	@Inject
	private IAccountRepository repo;

	@Override
	public String listAllAccounts() {
		
		return repo.listAllAccounts();
	}

}
