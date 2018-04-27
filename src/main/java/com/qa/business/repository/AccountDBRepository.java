package com.qa.business.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
public class AccountDBRepository implements IAccountRepository{
	
	private static final Logger logger = Logger.getLogger(AccountDBRepository.class);
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;
	
	@Override
	public  String listAllAccounts() {
		Query query = manager.createQuery("SELECT a FROM Account a");
		Collection<Account> accounts = (Collection<Account>) query.getResultList();
		
		if(accounts.size() == 0) {
			return "{\"message\":\"ERROR No Accounts\"}";
		}else {
			return util.getJSONForObject(accounts);
		}
	}

	@Override
	@Transactional(REQUIRED)
	public String createAccount(String accountJSON) {
		Account accounts = util.getObjectForJSON(accountJSON, Account.class);
		manager.persist(accounts);
		return "{\"message\":\"Account created\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {
		Account accounts = findAccount(new Long(id));
		
		if(accounts != null) {
			manager.remove(accounts);
			
			return "{\"message\":\"Account Deleted\"}";
		}else {
			return "{\"message\":\"Account not found\"}";
		}
		
	}

	private Account findAccount(Long id) {

		return manager.find(Account.class, id);
	}

	@Override
	@Transactional(REQUIRED)
	public String updateAccount(String accountJSON) {
		Account updateAccount = util.getObjectForJSON(accountJSON, Account.class);
		Account accounts = findAccount(new Long(updateAccount.getAccountNumber()));
		
		if(accounts != null) {
			accounts = updateAccount;
			manager.merge(updateAccount);
			
			return "{\"message\":\"Account updated\"}";
		}else {
			return "{\"message\":\"Could not update account\"}";
			
		}
		
	}

	@Override
	public String ListAAccount(Long id) {
		Account account = findAccount(id);
		if(account != null) {
			return util.getJSONForObject(account);
		}else {
			return "{\"message\":\"Account not found\"}";
		}
		
	}
	
	
}
