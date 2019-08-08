package com.prg3.mr_bid.model.entity;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Clase BidDate - Maneja las fechas
 *
 * @author Yohan Caro
 * @version 1.0 - 2/06/2019
 */
public class BidDate {
	
	private short day;
	private short month;
	private short year;
	
	/**
	 * Crea una fecha con un dia, un mes y un año
	 * @param day dia
	 * @param month mes
	 * @param year año
	 */
	public BidDate(short day, short month, short year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
		
	/**
	 * Crea una fecha con datos enteros
	 * @param day dia
	 * @param month mes
	 * @param year año
	 */
	public BidDate(int day, int month, int year) {
		this((short)day, (short) month, (short)year);
	}
	
	/**
	 * Crea una fecha apartir de una cadena
	 * @param date string (dd-mm-yyyy)
	 */
	public BidDate(String date) {
		this(stringToDate(date)[0], stringToDate(date)[1], stringToDate(date)[2]);
	}
	
	/**
	 * Convierte una cadena en un vector de cadenas (de fechas)
	 * @param date fecha String
	 * @return shortDate si la cadena que entra no está vacia
	 */
	public static short[] stringToDate(String date) {
		if (date != null && !date.isEmpty()) {
			short[] shortDate = new short[3];
			for (int i = 0; i < shortDate.length; i++) {
				shortDate[i] = Short.parseShort(date.split("/")[i]);
			}
			return shortDate;
		}
		return null;
	}
	
	/**
	 * Pasa el tiempo a años
	 * @return int con años
	 */
	public int toYears() {
		Calendar calendar = new GregorianCalendar();
		short year = (short) (calendar.get(Calendar.YEAR) - this.year);
		short month = (short) ((calendar.get(Calendar.MONTH)+1) - this.month);
		short day = (short) (calendar.get(Calendar.DAY_OF_MONTH) - this.day);
		
		return ((year*365 + month*30 + day)/365);
	}
	
	/**
	 * Obtiene el día
	 * @return day dia
	 */
	public short getDay() {
		return day;
	}
	
	/**
	 * Obtiene el mes
	 * @return month mes
	 */
	public short getMonth() {
		return month;
	}
	
	/**
	 * Obtiene el año
	 * @return year año
	 */
	public short getYear() {
		return year;
	}
		
	/**
	 * Pasa la fecha a un formato string 
	 * @return string (dd-mm-yyyy)
	 */
	public String getDateString() {
		return day + "/" + month + "/" + year;
	}
	
}
