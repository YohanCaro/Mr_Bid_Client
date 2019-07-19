package com.prg3.mr_bid.model.entity;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Clase BidTime - Crea una fecha con una hora especifica
 *
 * @author Yohan Caro
 * @version 1.0 - 2/06/2019
 */
public class BidTime {
	
	private BidDate date;
	private float hours;
	private Calendar calendar;
	
	/**
	 * Constructor que crea un tiempo de subasta con:
	 * @param date fecha
	 * @param hours hora
	 */
	public BidTime(BidDate date, float hours) {
		this.date = date;
		this.hours = hours;
		calendar = new GregorianCalendar();
	}
	
	/**
	 * Obtiene el tiempo en dias
	 * @return t d
	 */
	public float getTimeOnDays() {
		if (calendar == null) {
			calendar = new GregorianCalendar();
		}
		short year = (short) (date.getYear() - calendar.get(calendar.YEAR));
		short month = (short) (date.getMonth() - (calendar.get(calendar.MONTH)+1));
		short day = (short) (date.getDay() - calendar.get(calendar.DAY_OF_MONTH));
		
		return (short) (year*365 + month*30 + day);
	}
	
	/**
	 * Obtiene el tiempo comparado con la fecha actual (en horas)
	 * @return time t
	 */
	public float getTime() {
		return this.getTimeOnHours() + this.getActualHour();
	}
	
	/**
	 * Obtiene la difrencia de una hora con la hora actual
	 * @return t h
	 */
	public float getActualHour() {
		return this.hours - calendar.get(calendar.HOUR_OF_DAY) - ((float)calendar.get(calendar.MINUTE)/60);
	}
	
	/**
	 * Obtiene el tiempo en horas 
	 * @return horas t
	 */
	public float getTimeOnHours() {
		return this.getTimeOnDays()*24;
	}
	
	/**
	 * Obtiene el tiempo en horas 
	 * @return horas t
	 */
	public float getTimeOnHours(int tim) {
		return tim*24;
	}
	
	/**
	 * Obtiene la fecha
	 * @return date
	 */
	public BidDate getDate() {
		return date;
	}
	
	/**
	 * Obtiene la hora
	 * @return hour
	 */
	public float getHours() {
		return hours;
	}
	
	@Override
	public String toString() {
		return date.getDateString() + " " + hours;
	}

}
