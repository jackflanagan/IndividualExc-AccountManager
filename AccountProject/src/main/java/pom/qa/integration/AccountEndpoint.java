package pom.qa.integration;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;


import pom.qa.business.service.IAccountService;


@Path("/Account")
public class AccountEndpoint {
	
	
	private static final Logger LOGGER = Logger.getLogger(AccountEndpoint.class);
	
	@Inject
	private IAccountService ims;
	
	@GET 
	@Path("/json")
	@Produces(("application/json"))
	public String getAllAccounts() {
		return ims.GetAllAccounts();
		
	}
	
	@GET 
	@Path("/json/{id}")
	@Produces(("application/json"))
	public String getAccount(@PathParam("id") Long id) {
		return ims.getAccount(id);
		
	}
	
	@POST 
	@Path("/json")
	@Produces(("application/json"))
	public String addAccount(String accountToAdd) {
		LOGGER.info("This is the string " + accountToAdd);
		return ims.addAccount(accountToAdd);
		
	}
	
	@DELETE 
	@Path("/json/{id}")
	@Produces(("application/json"))
	public String addDeleteAccount(@PathParam("id") Long id) {
		return ims.deleteAccount(id);
		
	}
	
	@PUT 
	@Path("/json/{id}")
	@Produces(("application/json"))
	public String updateAccount(@PathParam("id") Long id,String update) {
		LOGGER.info("This is the string update " + update);
		return ims.updateAccount(id,update);
		
	}
	
	

}
