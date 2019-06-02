package com.prg3.mr_bid.model.entity;

/** Enum Gender - Enumerado con generos
 *
 * @author Yohan Caro
 * @version 1.0 - 26/05/2019
 */
public enum Gender {
	
	FEMALE("femanino"), MALE ("masculino");
	
	private String value;
	
	/**
	 * Constructor
	 * @param value valor
	 */
	private Gender(String value) {
		this.value = value;
	}
	
	/**
	 * Obtiene el valor del genero
	 * @return value valor
	 */
	public String getValue() {
		return value;
	}

}
