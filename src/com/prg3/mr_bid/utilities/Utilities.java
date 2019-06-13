package com.prg3.mr_bid.utilities;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import com.prg3.mr_bid.model.entity.BidDate;
import com.prg3.mr_bid.model.entity.BidTime;
import com.prg3.mr_bid.model.entity.Bidding;
import com.prg3.mr_bid.model.entity.Product;
import com.prg3.mr_bid.model.entity.TypeProduct;

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
	
//	public static void fillBiddings() {
//		ArrayList<String> list = new ArrayList<>();
//		list.add("/images/iphone.png");
//		for (int i = 0; i < 5; i++) {
//			Constants.biddingsList.add(new Bidding("Car " + i, TypeProduct.VEHICLES,
//					new Product("Carrito", "Un carro comun y corriente jajajaja", list), 
//					new BidTime(new BidDate("5/10/2019"), (short) 10), 
//					new BidTime(new BidDate("5/10/2019"), (short) 10), 
//					new BidTime(new BidDate("5/10/2019"), (short) 10), 
//					true, true));
//			Constants.biddingsList.get(i).setId(i+10000);
//		}
//	}

}
