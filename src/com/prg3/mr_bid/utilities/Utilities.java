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
import com.prg3.mr_bid.structures.simple_list.SimpleList;

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
	
	public static SimpleList<Bidding> stringToBiddings(String stringList) {
		SimpleList<Bidding> list = new SimpleList<>();
		String[] array = stringList.split("#");
		for (int i = 0; i < array.length; i++) {
			list.add(Bidding.stringToBidding(array[i]));
		}
		return list;
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
	public static float hoursToSeconds(float hours) {
		return hours*3600;
	}
	
	public static BidState getState(Bidding bidding) {
		if (isAfterOfToDay(bidding.getInitTime())) {
			return BidState.INICIADA;
		} 
		if (!isAfterOfToDay(bidding.getFinishTime())) {
			return BidState.FINALIZADA;
		} 
		return BidState.NO_INICIADA;
	}
	
	public static String getTimeRemaining(Bidding bidding) {
		if (isAfterOfToDay(bidding.getInitTime())) {
			return convertTime(bidding.getInitTime());
		} else if (isAfterOfToDay(bidding.getFinishTime())) {
			return convertTime(bidding.getFinishTime());
		} else {
			return "0";
		}
	}
	
	public static String convertTime(BidTime bt) {
		float time = hoursToSeconds(bt.getTime());
		String out = "";
		if (time < 60) {
			out = time + " s";
		} else if (time < 3600) {
			out = minutes(time) + " min";
		} else if (time < 86400) {
			out = (int)(time/3600) + " h " + minutes(time) + " min";
		} else {
			out = (int)(time/86400) + " d " + hours(time) + " h " + minutes(time) + " min";
		}
		
		return out;
	}
	
	public static int minutes(float s) {
		float i = (s/60);
		int h = ((int) (s/3600)*60);
		return (int)(i - h);
	}
	
	public static int hours(float s) {
		float h = (s/3600);
		int d = ((int) (s/86400)*24);
		return (int)(h - d);
	}

}
