package pom.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;




@Entity
public class Account {
	
	
	
	
	@GeneratedValue
	@Id
	private Long id;
	@Column
	private String firstName;
	@Column
	private String secondName;
	@Column
	private String accountNumber;
	
	
public Account() {
		
	}
	
	public Account(String firstName,String secondName,String accountNumber ) {
		
		this.firstName = firstName;
		this.secondName = secondName;
		this.accountNumber = accountNumber;
		
	}

	public Long getId() {
		return id;
	}

	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstname) {
		firstName = firstname;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setMovieGenre(String secondname) {
		secondName = secondname;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accno) {
		accountNumber = accno;
	}
	

}
