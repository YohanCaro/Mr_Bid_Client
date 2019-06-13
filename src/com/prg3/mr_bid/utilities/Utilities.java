package com.prg3.mr_bid.utilities;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import com.prg3.mr_bid.model.entity.BidDate;
import com.prg3.mr_bid.model.entity.BidState;
import com.prg3.mr_bid.model.entity.BidTime;
import com.prg3.mr_bid.model.entity.Bidding;

/** Clase Utilities - Utilidades de la apicación
 *
 * @author Yohan Caro
 * @version 1.0 - 1/06/2019
 */
public class Utilities {
	
	/**
	 * Envia un mensaje de advertencia
	 * @param menssage mensjae
	 * @param title titulo del JOptionPane
	 */
	public static void showMessageWarning(String menssage, String title) {
		JOptionPane.showMessageDialog(null, menssage, title, JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Envia un mensaje de Error
	 * @param menssage mensjae
	 * @param title titulo del JOptionPane
	 */
	public static void showMessageError(String menssage, String title) {
		JOptionPane.showMessageDialog(null, menssage, title, JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Envia un mensaje de información
	 * @param menssage mensjae
	 * @param title titulo del JOptionPane
	 */
	public static void showMessageInfo(String menssage, String title) {
		JOptionPane.showMessageDialog(null, menssage, title, JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Evalua si un correo tiene un formato valido
	 * @param email correo
	 * @return true/false
	 */
	public static boolean isEmailAvailable(String email) {
		Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		if (email != null && !email.isEmpty()) {
			Matcher mather = pattern.matcher(email);
			return mather.find();
		} 
		return false;
	}
	
	/**
	 * Verifica que la fecha sea mayor a la actual
	 * @param time tiempo
	 * @return true / false
	 */
	public static boolean isAfterOfToDay(BidTime time) {
		return (time.getTime() > 0)?true:false;
	}
	
	/**
	 * Verifica que la fecha sea mayor a la actual
	 * @param time tiempo
	 * @return true / false
	 */
	public static boolean isAfterOfToDay(String time, float hours) {
		BidTime t = new BidTime(new BidDate(time), hours);
		return (t.getTime() > 0)?true:false;
	}
	
	/**
	 * Convierte las horas a segundos
	 * @param hours
	 * @return
	 */
	public static float hoursToSeconds(int hours) {
		return hours*3600;
	}
	
	public static BidState getState(Bidding bidding) {
		System.out.println("B: " + bidding.getBiddingName());
		if (isAfterOfToDay(bidding.getInitTime())) {
			return BidState.INICIADA;
		} 
		if (!isAfterOfToDay(bidding.getFinishTime())) {
			return BidState.FINALIZADA;
		} 
		return BidState.NO_INICIADA;
	}

}
