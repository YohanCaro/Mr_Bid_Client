package com.prg3.mr_bid.utilities;

import java.awt.Dimension;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import com.prg3.mr_bid.model.entity.BidDate;
import com.prg3.mr_bid.model.entity.BidState;
import com.prg3.mr_bid.model.entity.BidTime;
import com.prg3.mr_bid.model.entity.Bidding;
import com.prg3.mr_bid.structures.simple_list.Cursor;
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
	
	/**
	 * Convierte una cadena en una lista simple de subatas
	 * @param stringList lista
	 * @return lista de subastas
	 */
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
	 * @param hours horas
	 * @return tiempo en segundos
	 */
	public static float hoursToSeconds(float hours) {
		return hours*3600;
	}
	
	/**
	 * Verifica el estado actual de una subasta
	 * @param bidding subasta
	 * @return estado actual de las subasta
	 */
	public static BidState getState(Bidding bidding) {
		if (!isAfterOfToDay(bidding.getFinishTime())) {
			return BidState.FINALIZADA;
		} 
		if (!isAfterOfToDay(bidding.getInitTime())) {
			return BidState.INICIADA;
		} 
		return BidState.NO_INICIADA;
	}
	
	/**
	 * Verifica cual es la fecha más cercana en tiempo y verifica el estado
	 * actual de la subasta
	 * @param bidding subasta
	 * @return cadena con el tiempo
	 */
	public static String getTimeRemaining(Bidding bidding) {
		if (isAfterOfToDay(bidding.getInitTime())) {
			return convertTime(bidding.getInitTime());
		} else if (isAfterOfToDay(bidding.getFinishTime())) {
			return convertTime(bidding.getFinishTime());
		} else {
			return "0";
		}
	}
	
	public static int getTimeRemainingInt(Bidding bidding) {
		if (isAfterOfToDay(bidding.getInitTime())) {
			return toSeconds(bidding.getInitTime());
		} else if (isAfterOfToDay(bidding.getFinishTime())) {
			return toSeconds(bidding.getFinishTime());
		} else {
			return 0;
		}
	}
	
	/**
	 * Conviete una fecha de subasta a una cadena con la inofrmación del 
	 * teimp restante para ser iniciada o finalizada
	 * @param bt fecha de subasta
	 * @return cadena con el tiempo restante
	 */
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
	
	/**
	 * Convierte segundos en minutos
	 * @param s segundos
	 * @return int con los minutos
	 */
	public static int minutes(float s) {
		float i = (s/60);
		int h = ((int) (s/3600)*60);
		return (int)(i - h);
	}
	
	/**
	 * Convierte segundos en horas
	 * @param s segundos
	 * @return int con las horas
	 */
	public static int hours(float s) {
		float h = (s/3600);
		int d = ((int) (s/86400)*24);
		return (int)(h - d);
	}
	
	/**
	 * Pasa a segundos el tiempo de hoy a la fecha
	 * @param bt time
	 * @return tiempo en segundos
	 */
	public static int toSeconds(BidTime bt) {
		return (int) hoursToSeconds(bt.getTimeOnHours());
	}
		
	/**
	 * Setea una dimension para un componente de una ventana o panel
	 * @param x pos x
	 * @param y pos y
	 * @return la dimension
	 */
	public static Dimension setDimension(int x, int y) {
		return new Dimension(x, y);
	}
	
	/**
	 * Cambia el criterio de comparación, para ordenar las subastas
	 */
	public static void changeCritrium() {
		SimpleList<Bidding> list = Constants.biddingsList;
		Constants.biddingsList = new SimpleList<Bidding>(new Comparator<Bidding>() {

			@Override
			public int compare(Bidding b1, Bidding b2) {
				return getTimeRemainingInt(b1) - getTimeRemainingInt(b2);
			}
		});
		
		Cursor<Bidding> cursor = new Cursor<>(list);
		while (!cursor.isOut()) {
			Bidding b = cursor.nextAndGetInfo();
			if (!getTimeRemaining(b).equals("0")) {
				Constants.biddingsList.add(b);
			} else {
				Constants.biddingsList.addLast(b);
			}
		}
	}

}
