package pom.qa.business.repository;

public interface IAccountRepository {
	
	String getAllAccounts();
	
	String getAccount(Long id);
	
	String addAccount(String MovieJson);
	
	String deleteAccount(Long id);
	
	String updateAccount(Long id, String update);

}
