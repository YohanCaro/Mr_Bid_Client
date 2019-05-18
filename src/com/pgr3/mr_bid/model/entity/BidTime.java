package com.pgr3.mr_bid.model.entity;

import java.util.Date;

public class BidTime {
	
	private Date date;
	private short hours;
	
	public BidTime(Date date, short hours) {
		this.date = date;
		this.hours = hours;
	}
	
	public Date getDate() {
		return date;
	}
	
	public short getHours() {
		return hours;
	}

}
