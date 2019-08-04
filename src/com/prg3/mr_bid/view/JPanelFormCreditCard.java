package com.prg3.mr_bid.view;

import java.awt.Color;
import java.awt.Dimension;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class JPanelFormCreditCard extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabelName;
	private JButton jButton;
	private JTextField jTextFieldDate, jTextFieldName, jTextFieldNumberFront, jTextFieldCod;
	private JDateChooser jDateChooser;

	public JPanelFormCreditCard() {
		this.setLayout(null);
		setSize(350, 400);
		initComponents();

	}

	private void initComponents() {

		this.setBackground(Color.WHITE);
		createLabel("AGREGAR TARJETA DE CREDITO", 20, 0);

		createLabel("FECHA DE VENCIMIENTO", 20, 50);
		// createTextField("FECHA DE VENCIMIENTO", 200, 50, jTextFieldDate);

		jDateChooser = new JDateChooser();
		jDateChooser.setBounds(200, 50, 250, 40);
		add(jDateChooser);

		createLabel("NOMBRE TITULAR", 20, 100);
		createTextField("NOMBRE TITULAR", 200, 100, jTextFieldName);

		createLabel("NUMERO DE TARJETA", 20, 150);
		createTextField("NUMERO DE TARJETA", 200, 150, jTextFieldNumberFront);

		createLabel("CODIGO DE SEGURIDAD", 20, 200);
		createTextField("CODIGO DE SEGURIDAD", 200, 200, jTextFieldCod);

		jButton = new JButton("Aceptar");
		jButton.setBounds(200, 250, 250, 40);
		add(jButton);

	}

	public String getnameholder() {
		return jTextFieldName.getText();
	}

	public String getcardnNumber() {
		return jTextFieldName.getText();
	}

	public String getsecurityCode() {
		return jTextFieldName.getText();
	}

	/**
	 * Metodo que verifica el campo de entrada de la fecha de nacimiento utilizando
	 * una libreria externa y convirtiendo el valor en un String!
	 * 
	 * @return la cadena con el valor extraido del textfield si lo encuantra, sino
	 *         devuelve un null!
	 */
	public String getexpirationdDate() {
		if (jDateChooser.getDate() != null) {
			Date date = jDateChooser.getDate();
			DateFormat df = DateFormat.getDateInstance();
			String date2 = df.format(date);
			return date2;
		}
		return null;
	}

	public JLabel createLabel(String name, int x, int y) {
		jLabelName = new JLabel(name);
		jLabelName.setBounds(x, y, 200, 50);
		jLabelName.setBackground(new Color(244, 244, 244));
		jLabelName.setPreferredSize(new Dimension(200, 60));
		add(jLabelName);
		return jLabelName;

	}

	public JTextField createTextField(String name, int x, int y, JTextField atribute) {
		atribute = new JTextField(name);
		atribute.setBounds(x, y, 250, 40);
		atribute.setBackground(new Color(244, 244, 244));
		atribute.setPreferredSize(new Dimension(200, 60));
		add(atribute);
		return atribute;

	}

}