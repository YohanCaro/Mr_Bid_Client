package com.prg3.mr_bid.model.entity;

import java.util.ArrayList;

public class User {
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private BidDate birthDate;
	private boolean isFemale;
	private CreditCard creditCard;
	private ArrayList<Bidding> myBiddings;
	private ArrayList<Bidding> myParcitipations;
	
	public User(String firstName, String lastName, String email, String password, BidDate birthDate, boolean isFemale,
			CreditCard creditCard) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.birthDate = birthDate;
		this.isFemale = isFemale;
		this.creditCard = creditCard;
		
		myBiddings = new ArrayList<>();
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

	public BidDate getBirthDate() {
		return birthDate;
	}

	public boolean isFemale() {
		return isFemale;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}
	
	public ArrayList<Bidding> getMyBiddings() {
		return myBiddings;
	}
	
	public ArrayList<Bidding> getMyParcitipations() {
		return myParcitipations;
	}
	
	@Override
	public String toString() {
		return "Nombre y apellido: " + firstName + " email " + email +
				"\nFecha de nacimiento: " + birthDate.getDateString() + " genero " + (isFemale?"Femenino":"Masculino");
	}

}
