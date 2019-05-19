package com.pgr3.mr_bid.model.entity;

public class BidDate {
	
	private short day;
	private short month;
	private short year;
		
	public BidDate(short day, short month, short year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
		
	public BidDate(int day, int month, int year) {
		this((short)day, (short) month, (short)year);
	}
	
	public short getDay() {
		return day;
	}
	
	public short getMonth() {
		return month;
	}
	
	public short getYear() {
		return year;
	}
	
	public String getDateString() {
		return day + "/" + month + "/" + year;
	}
	
}
