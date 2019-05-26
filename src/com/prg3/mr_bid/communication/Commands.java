package com.prg3.mr_bid.communication;

public enum Commands {

	SIGNIN("signin"), LOGIN("login"), UPBIDDING("up_bidding"), DELETE_USER("delete_user"),
	CHANGE_BIDDING("change_bidding"), DELETE_BIDDING("delete_bidding"), ;
	
	private String value;
	
	private Commands(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
}
