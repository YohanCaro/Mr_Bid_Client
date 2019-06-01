package com.prg3.mr_bid.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

/**Clase Utilities.java - 
 *
 * @author Yohan Caro
 * @version 1.0 - 1/06/2019
 */
public class Utilities {
	
	public static void showMessageWarning(String mensaje, String title) {
		JOptionPane.showMessageDialog(null, mensaje, title, JOptionPane.WARNING_MESSAGE);
	}

	public static void showMessageError(String mensaje, String title) {
		JOptionPane.showMessageDialog(null, mensaje, title, JOptionPane.ERROR_MESSAGE);
	}
	
	public static void showMessageInfo(String mensaje, String title) {
		JOptionPane.showMessageDialog(null, mensaje, title, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static boolean isEmailAvailable(String email) {
		Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		if (email != null && !email.isEmpty()) {
			Matcher mather = pattern.matcher(email);
			return mather.find();
		} 
		return false;
	}

}
