package com.qa.interoperability;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.IAccountService;

@Path("account")
public class AccountEndpoint {
	
	@Inject
	private IAccountService service;
	
	@GET
	@Path("json")
	@Produces({"application/json"})
	public String listAllAccounts() {
		return service.listAllAccounts();
	}
	
	@POST
	@Path("json")
	@Produces({"application/json"})
	public String createAccount(String jsonString) {
		return service.createAccount(jsonString);
	}
	
	@DELETE
	@Path("json/{id}")
	@Produces({"application/json"})
	public String deleteAccount(@PathParam("id")Long id) {
		return service.deleteAccount(id);
	}
	
	@PUT
	@Path("json")
	@Produces({"application/json"})
	public String updateAccount(String jsonString) {
		return service.updateAccount(jsonString);
	}
	
	@GET
	@Path("json/{id}")
	@Produces({"application/json"})
	public String listAAccount(@PathParam("id")Long id) {
		return service.listAAccount(id);
	}
	

}
