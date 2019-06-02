package com.prg3.mr_bid.model.entity;

/**
 * Clase BidTime - Crea una fecha con una hora especifica
 *
 * @author Yohan Caro
 * @version 1.0 - 2/06/2019
 */
public class BidTime {
	
	private BidDate date;
	private short hours;
	
	/**
	 * Constructor que crea un tiempo de subasta con:
	 * @param date fecha
	 * @param hours hora
	 */
	public BidTime(BidDate date, short hours) {
		this.date = date;
		this.hours = hours;
	}
	
	/**
	 * Obtiene la fecha
	 * @return
	 */
	public BidDate getDate() {
		return date;
	}
	
	/**
	 * Obtiene la hora
	 * @return
	 */
	public short getHours() {
		return hours;
	}
	
	@Override
	/**
	 * To string
	 */
	public String toString() {
		return date.getDateString() + " " + hours;
	}

}
