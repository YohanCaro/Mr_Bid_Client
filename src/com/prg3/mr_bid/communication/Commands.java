package com.prg3.mr_bid.communication;

/**
 * Enum Commands - Comandos utilizados del cliente y el servidor
 *
 * @author Yohan Caro
 * @version 1.0 - 2/06/2019
 */
public enum Commands {

	SIGNIN("signin"), LOGIN("login"), UPBIDDING("up_bidding"), DELETE_USER("delete_user"),
	CHANGE_BIDDING("change_bidding"), DELETE_BIDDING("delete_bidding"), SENDIMG("send_img"),
	ERROR_SINGIN("error_sigin"), ERROR_LOGIN("error_login"), UPDATE_BID("update_bid");
	
	private String value;
	
	/**
	 * Obtiene un camando
	 * @param value valor
	 */
	private Commands(String value) {
		this.value = value;
	}
	
	/**
	 * Obtiene el nombre del comando
	 * @return value valor
	 */
	public String getValue() {
		return value;
	}
	
}
