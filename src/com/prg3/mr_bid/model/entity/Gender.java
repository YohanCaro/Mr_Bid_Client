package com.prg3.mr_bid.model.entity;

/**Clase Gender.java - 
 *
 * @author Yohan Caro
 * @version 1.0 - 26/05/2019
 */
public enum Gender {
	
	FEMALE("femanino"), MALE ("masculino");
	
	private String value;
	
	private Gender(String value) {
		this.value = value;
	}
	
	/**
	 * Obtiene 
	 * @return value
	 */
	public String getValue() {
		return value;
	}

}
