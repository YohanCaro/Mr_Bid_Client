package com.pgr3.mr_bid.model;

import java.time.LocalDate;

public class User {
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private LocalDate birthDate;
	private boolean isFemale;
	private CreditCard creditCard;
	
	public User(String firstName, String lastName, String email, String password, LocalDate birthDate, boolean isFemale,
			CreditCard creditCard) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.birthDate = birthDate;
		this.isFemale = isFemale;
		this.creditCard = creditCard;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public boolean isFemale() {
		return isFemale;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

}
