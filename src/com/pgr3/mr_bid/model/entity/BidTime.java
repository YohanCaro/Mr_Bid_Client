package com.pgr3.mr_bid.model.entity;

import java.util.Date;

public class BidTime {
	
	private BidDate date;
	private short hours;
	
	public BidTime(BidDate date, short hours) {
		this.date = date;
		this.hours = hours;
	}
	
	public BidDate getDate() {
		return date;
	}
	
	public short getHours() {
		return hours;
	}
	
	@Override
	public String toString() {
		return date.getDateString() + " " + hours;
	}

}
