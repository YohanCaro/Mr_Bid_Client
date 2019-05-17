package com.pgr3.mr_bid.model.entity;

import java.time.LocalDate;

public class CreditCard {
	
	private LocalDate expirationDate;
	private String cardholderName;
	private String cardNumber;
	private String securityCode;
	
	public CreditCard(LocalDate expirationDate, String cardholderName, String cardNumber, String securityCode) {
		this.expirationDate = expirationDate;
		this.cardholderName = cardholderName;
		this.cardNumber = cardNumber;
		this.securityCode = securityCode;
	}
	
	public CreditCard () {
		
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public String getCardholderName() {
		return cardholderName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public String getSecurityCode() {
		return securityCode;
	}	

}
