/**
 * 
 */
package com.prg3.mr_bid.utilities;

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

}
