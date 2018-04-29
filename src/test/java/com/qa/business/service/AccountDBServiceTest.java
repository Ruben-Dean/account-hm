package com.qa.business.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.repository.AccountDBRepository;
import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;



@RunWith(MockitoJUnitRunner.class)
public class AccountDBServiceTest {

	@InjectMocks 
	private AccountDBRepository repo;
	
	@Mock
	private EntityManager manager;
	

	@Mock 
	Query query;
	
	private JSONUtil util;
	
	private static final String MockObject="{\"firstName\":\"Paul\",\"surname\":\"Pogba\",\"accountNumber\":1}";
	private static final String MockArray="[{\"firstName\":\"Paul\",\"surname\":\"Pogba\",\"accountNumber\":1,\"generateAccountNumber\":false}]";
	
	
	@Before
	public void testInit() {
		util=new JSONUtil();
		repo.setManager(manager);
		repo.setUtil(util);
		
	}
	@Test
	public void createAccountTest(){
		String expected=repo.createAccount(MockObject);
		assertEquals(expected,"{\"message\":\"Account created\"}");
	}
	
	
	

}
