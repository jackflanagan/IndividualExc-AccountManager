package pom.qa.business.service;

public interface IAccountService {

	String GetAllAccounts();
	
	String getAccount(Long id);
	
	String addAccount(String accountToAdd);
	
	String deleteAccount(Long id);
	
	String updateAccount(Long id,String update);
	
	
	
	
}
