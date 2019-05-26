package com.prg3.mr_bid.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.text.DefaultFormatter;

public class JPanelFormCreditCard extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabelName;
	private JButton jButton;
	private JTextField jTextFieldDate, jTextFieldName, jTextFieldNumberFront, jTextFieldCod;

	public JPanelFormCreditCard() {
		this.setLayout(null);
		setSize(350, 400);
		initComponents();

	}

	private void initComponents() {

		this.setBackground(Color.WHITE);
		createLabel("AGREGAR TARJETA DE CREDITO", 20, 0);

		createLabel("FECHA DE VENCIMIENTO", 20, 50);
		createTextField("FECHA DE VENCIMIENTO", 200, 50, jTextFieldDate);

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