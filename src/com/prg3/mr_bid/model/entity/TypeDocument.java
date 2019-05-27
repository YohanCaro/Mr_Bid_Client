package com.prg3.mr_bid.model.entity;

/**Clase TypeDocument.java - 
 *
 * @author Yohan Caro
 * @version 1.0 - 26/05/2019
 */
public enum TypeDocument {
	
	CEDULA ("cedula"), TI ("T.I"), PASAPORTE ("pasaporte");
	
	private String value;

	/**
	 * @param value
	 */
	private TypeDocument(String value) {
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
