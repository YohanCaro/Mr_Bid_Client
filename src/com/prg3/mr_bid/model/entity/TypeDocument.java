package com.prg3.mr_bid.model.entity;

/** Enum TypeDocument - Enumerado con los tipos de documentos validos
 *
 * @author Yohan Caro
 * @version 1.0 - 26/05/2019
 */
public enum TypeDocument {
	
	CEDULA ("cedula"), TI ("T.I"), PASAPORTE ("pasaporte");
	
	private String value;

	/**
	 * Constructor
	 * @param value valor
	 */
	private TypeDocument(String value) {
		this.value = value;
	}
	
	/**
	 * Obtiene el valor
	 * @return value valor
	 */
	public String getValue() {
		return value;
	}
	
}
