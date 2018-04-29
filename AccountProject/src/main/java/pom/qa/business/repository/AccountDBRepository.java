package pom.qa.business.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import pom.qa.persistence.domain.Account;
import pom.qa.util.JSONUtil;

public class AccountDBRepository implements IAccountRepository{

	
	private static final Logger LOGGER = Logger.getLogger(AccountDBRepository.class);
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em; 
	
	@Inject
	private JSONUtil util;
	
	public String getAllAccounts() {
		LOGGER.info("Accountdb : running the get all account");
		Query query = em.createQuery("Select a from Account a");
		Collection <Account> movies = (Collection <Account>) query.getResultList();
		
		return util.getJsonForObject(movies);
	}
	
	public String getAccount(Long id) {
		Account aAcc = findAccount(id);
		if(aAcc != null) {
			return util.getJsonForObject(aAcc);
		}
		return "{\"message\": \"account has been found\"}";
	}
	
	
	@Transactional(REQUIRED)
	public String addAccount(String AccountJson) {
		Account accountToAdd = util.getObjectForJSON(AccountJson, Account.class);
		em.persist(accountToAdd);
		return AccountJson;
	}
	
	
	private Account findAccount(Long id) {
		Account aMovie = em.find(Account.class, id);
		return aMovie;
	}

	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {
		Account accountToDelete = findAccount(id);
		if(accountToDelete != null) {
			em.remove(accountToDelete);
		}
		
		return "{\"message\": \"account sucessfully deleted\"}";
	}
	
	@Transactional(REQUIRED)
	public String updateAccount(Long id, String update) {
		
		Account updateAcc = util.getObjectForJSON(update, Account.class);
		Account theAcc = findAccount(id);
		
		if(update != null) {
			theAcc = updateAcc;
			em.merge(theAcc);
		}
		
		
		return "{\"message\": \"account sucessfully updated\"}";
	}


	
	

}
