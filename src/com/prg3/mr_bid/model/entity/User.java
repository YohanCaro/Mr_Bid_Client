package com.prg3.mr_bid.model.entity;

import java.util.ArrayList;

import com.prg3.mr_bid.structures.simple_list.SimpleList;

/**
 * Clase User - Clase que crea un usuario
 *
 * @author Yohan Caro
 * @version 1.0 - 2/06/2019
 */
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
	
	/**
	 * Crea un usuario con los siguientes datos
	 * @param firstName nombre
	 * @param lastName apellido
	 * @param email correo
	 * @param password contraseña
	 * @param birthDate fecha de nacimiento
	 * @param document documento
	 * @param typeDocument tipo de documento
	 * @param isFemale genero
	 * @param creditCard tarjeta de credito
	 * @param myBiddings mis subastas
	 * @param myParcitipations mis participaciones
	 */
	public User(String firstName, String lastName, String email, String password, BidDate birthDate, String document,
			TypeDocument typeDocument, Gender gender, CreditCard creditCard) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.birthDate = birthDate;
		this.document = document;
		this.typeDocument = typeDocument;
		this.gender = gender;
		this.creditCard = creditCard;
	}

	/**
	 * Obtiene el nombre
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Obtiene el apellido
	 * @return lastName a
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Obtiene correo
	 * @return email c
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Obtiene la contraseña 
	 * @return password c
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Obtiene la fecha de nacimiento
	 * @return birthDate b
	 */
	public BidDate getBirthDate() {
		return birthDate;
	}

	/**
	 * Obtiene el documento
	 * @return document d
	 */
	public String getDocument() {
		return document;
	}

	/**
	 * Obtiene el tupo de producto
	 * @return typeDocument tp
	 */
	public TypeDocument getTypeDocument() {
		return typeDocument;
	}

	/**
	 * Obtiene el genero
	 * @return gender genero
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * Obtiene la tarjeta de credito
	 * @return creditCard cc
	 */
	public CreditCard getCreditCard() {
		return creditCard;
	}

	@Override
	public String toString() {
		return "Nombre y apellido: " + firstName + " email " + email +
				"\nFecha de nacimiento: " + birthDate.getDateString() + " genero " + gender.getValue();
	}

}
