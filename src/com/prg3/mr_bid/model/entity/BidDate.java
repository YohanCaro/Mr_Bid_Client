package com.prg3.mr_bid.model.entity;

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
	
	public BidDate(String date) {
		this(stringToDate(date)[0], stringToDate(date)[1], stringToDate(date)[2]);
	}
	
	public static short[] stringToDate(String date) {
		short[] shortDate = new short[3];
		for (int i = 0; i < shortDate.length; i++) {
			shortDate[i] = Short.parseShort(date.split("/")[i]);
		}
		return shortDate;
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
