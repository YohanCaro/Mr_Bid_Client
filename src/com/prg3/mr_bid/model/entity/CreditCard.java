package com.prg3.mr_bid.model.entity;

/**
 * Clase CreditCard - Crea la tarjeta de credito
 *
 * @author Yohan Caro
 * @version 1.0 - 2/06/2019
 */
public class CreditCard {
	
	private BidDate expirationDate;
	private String cardholderName;
	private String cardNumber;
	private String securityCode;
	
	/**
	 * Constructor que crew una tarjeta de credito con los siguientes datos
	 * @param expirationDate tiempo de expiración
	 * @param cardholderName propietario de la tarjeta
	 * @param cardNumber numero de la tarjeta
	 * @param securityCode codigo de seguridad
	 */
	public CreditCard(BidDate expirationDate, String cardholderName, String cardNumber, String securityCode) {
		this.expirationDate = expirationDate;
		this.cardholderName = cardholderName;
		this.cardNumber = cardNumber;
		this.securityCode = securityCode;
	}
	
	/**
	 * Constructor vacio
	 */
	public CreditCard () {
		
	}

	/**
	 * Obtiene la fecha de expiración
	 * @return expirationDate e
	 */
	public BidDate getExpirationDate() {
		return expirationDate;
	}

	/**
	 * Obtiene el nombre del propietario
	 * @return cardholderName c
	 */
	public String getCardholderName() {
		return cardholderName;
	}

	/**
	 * Obtiene el número de la tarjeta
	 * @return cardNumber numero de tarjeta
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * Obtiene el código de seguridad
	 * @return securityCode cdigo de seguridad
	 */
	public String getSecurityCode() {
		return securityCode;
	}	

}
