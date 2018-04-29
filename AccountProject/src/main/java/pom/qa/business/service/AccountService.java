package pom.qa.business.service;

import javax.inject.Inject;

import pom.qa.business.repository.IAccountRepository;
import pom.qa.business.repository.AccountDBRepository;
import pom.qa.persistence.domain.Account;
import pom.qa.util.JSONUtil;

public class AccountService implements IAccountService {

	@Inject
	JSONUtil util;
	
	@Inject
	private IAccountRepository mr;
	
	public String GetAllAccounts() {
		return mr.getAllAccounts();
	}

	public String getAccount(Long id) {
		// TODO Auto-generated method stub
		return mr.getAccount(id);
	}

	public String addAccount(String accountJson) {
		// TODO Auto-generated method stub
		return mr.addAccount(accountJson);
	}

	public String deleteAccount(Long id) {
		// TODO Auto-generated method stub
		return mr.deleteAccount(id);
	}
	
	public String updateAccount(Long id, String update) {
		// TODO Auto-generated method stub
		return mr.updateAccount(id,update);
	}
	
	

	



	
	
	
	
}
