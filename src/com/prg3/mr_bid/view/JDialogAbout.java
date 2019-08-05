package com.prg3.mr_bid.view;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.prg3.mr_bid.utilities.ConstantsView;

/**
 * Clase JDialogAbout - Clase que crea un dialogo Del "Acerca De"
 *
 * @version 1.2 - 13/06/2019
 * @author Daniel García
 */
public class JDialogAbout extends JDialog {

	/**
	 * Serial por defecto
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel label1;
	private JScrollPane scrollpane1;
	private JTextArea textarea1;
	String nombre = "";

	/**
	 * Constructor que crea el dialogo
	 */
	public JDialogAbout() {
		this.label1 = new JLabel("ACERCA DE");
		this.textarea1 = new JTextArea();
		this.scrollpane1 = new JScrollPane(textarea1);
		
		this.init();
	}
	
	/**
	 * Inicializa los componentes del dialog
	 */
	private void init() {
		setLayout(null);
		this.setResizable(false);
		setSize(600, 400);
		this.setLocationRelativeTo(null);
		
		label1.setBounds(215, 5, 200, 30);
		label1.setFont(ConstantsView.FONT_DA_1);
		label1.setForeground(ConstantsView.COLOR_DA);
		add(label1);
		
		textarea1.setEditable(false);
		textarea1.setLineWrap(true);
		textarea1.setFont(ConstantsView.FONT_DA_2);
		textarea1.setText(ConstantsView.TEXT_DIALOG_ABOUT);
		
		scrollpane1.setBounds(10, 40, 575, 270);
		add(scrollpane1);
	}

}