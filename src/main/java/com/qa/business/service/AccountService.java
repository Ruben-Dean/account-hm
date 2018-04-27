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

	@Override
	public String createAccount(String JSONAccount) {
		
		return repo.createAccount(JSONAccount);
	}

	@Override
	public String deleteAccount(Long id) {
		
		return repo.deleteAccount(id);
	}

	@Override
	public String updateAccount(String JSONAccount) {
		
		return repo.updateAccount(JSONAccount);
	}

	@Override
	public String listAAccount(Long id) {
		
		return repo.ListAAccount(id);
	}

}
