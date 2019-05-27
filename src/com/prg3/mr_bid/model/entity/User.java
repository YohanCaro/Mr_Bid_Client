package com.prg3.mr_bid.model.entity;

import java.util.ArrayList;

public class User {
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private BidDate birthDate;
	private String document;
	private TypeDocument typeDocument;
	private Gender gender;
	private CreditCard creditCard;
	private ArrayList<Bidding> myBiddings;
	private ArrayList<Bidding> myParcitipations;
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 * @param birthDate
	 * @param document
	 * @param typeDocument
	 * @param isFemale
	 * @param creditCard
	 * @param myBiddings
	 * @param myParcitipations
	 */
	public User(String firstName, String lastName, String email, String password, BidDate birthDate, String document,
			TypeDocument typeDocument, Gender gender, CreditCard creditCard) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.birthDate = birthDate;
		this.document = document;
		this.typeDocument = typeDocument;
		this.gender = gender;
		this.creditCard = creditCard;
		
		myBiddings = new ArrayList<>();
		myParcitipations = new ArrayList<>();
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

	public Gender getGender() {
		return gender;
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
				"\nFecha de nacimiento: " + birthDate.getDateString() + " genero " + gender.getValue();
	}

}
