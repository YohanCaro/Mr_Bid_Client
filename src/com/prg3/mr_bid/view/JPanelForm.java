package com.prg3.mr_bid.view;

import java.awt.Color;
import java.awt.Dimension;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.text.Utilities;

import com.prg3.mr_bid.controller.ControlCommands;
import com.prg3.mr_bid.controller.UserController;
import com.prg3.mr_bid.utilities.HintJTextField;
import com.toedter.calendar.JDateChooser;

public class JPanelForm extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabelName, jLabelImage;
	private JButton jBLogin, jButton;
	private HintJTextField jTextFieldName, jTextFieldEmail, jTextFieldPasswor, jTextFieldid, jTextFieldgenero, jTextFieldCaptchat;
	private JDateChooser jDateChooseBirthDate;
	private JComboBox<String> jComboBox;
	private JPanelRobotCenter jPanelRobotCenter;

	public JPanelForm(UserController controller) {
		this.jPanelRobotCenter = new JPanelRobotCenter();
		this.setLayout(null);
		setSize(350, 400);
		initComponents(controller);
	}

	private void initComponents(UserController controller) {

		this.setBackground(Color.WHITE);

		createLabel("Nombre", 20, 20);
		createTextField("name", 150, 20,jTextFieldName);

		createLabel("EMAIL", 20, 70);
		createTextField("email", 150, 70,jTextFieldEmail);

		createLabel("Passwor", 20, 120);
		createTextField("Password", 150, 120,jTextFieldPasswor);

		createLabel("Tipo de Documento", 20, 170);
		jComboBox = new JComboBox<String>();
		jComboBox.setBackground(Color.WHITE);
		jComboBox.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(0, 0, 0, 0), new EtchedBorder()));
		jComboBox.setBounds(150, 170, 250, 40);
		jComboBox.setBackground(new java.awt.Color(244, 244, 244));
		add(jComboBox);
		
		jComboBox.addItem("CEDULA");
		jComboBox.addItem("T.I");
		jComboBox.addItem("PASAPORTE");

		createLabel("Numero Documento", 20, 220);
		createTextField("Numero Documento", 150, 220,jTextFieldid);
		
		createLabel("Fecha de Nacimiento", 20, 270);
		jDateChooseBirthDate = new JDateChooser();
		jDateChooseBirthDate.setBounds(130, 270, 250, 40);
		
		createLabel("Genero", 20, 320);
		createTextField("Genero", 150, 320,jTextFieldgenero);
		
		jButton = new JButton("Add Tarjeta");
		jButton.setActionCommand(ControlCommands.SHOW_ADD_CREDIT_CARD.name());
		jButton.addActionListener(controller);
		jButton.setBounds(150, 370, 250, 40);
		add(jButton);
		
		createLabel("CAPTCHAT", 20, 420);
		createTextField("CAPTCHAT", 150, 420,jTextFieldCaptchat);
		
		jBLogin = new JButton("Registrar");
		jBLogin.setBounds(20, 470, 450, 40);
		add(jBLogin);
	}

	public JLabel createLabel(String name, int x, int y) {
		jLabelName = new JLabel(name);
		jLabelName.setBounds(x, y, 200, 50);
		jLabelName.setBackground(new Color(244, 244, 244));
		jLabelName.setPreferredSize(new Dimension(200, 60));
		add(jLabelName);
		return jLabelName;
	}
	
	public JLabel createLabel2(String name, int x, int y) {
		jLabelImage.add(jPanelRobotCenter);
		jLabelImage.setBounds(x, y, 200, 50);
		jLabelImage.setBackground(new Color(244, 244, 244));
		jLabelImage.setPreferredSize(new Dimension(200, 60));
		add(jLabelImage);
		return jLabelImage;
	}

	public HintJTextField createTextField(String name, int x, int y, HintJTextField atribute) {
		atribute = new HintJTextField(name);
		atribute.setBounds(x, y, 250, 40);
		atribute.setBackground(new Color(244, 244, 244));
		atribute.setPreferredSize(new Dimension(200, 60));
		add(atribute);
		return atribute;
	}
	
	public String getFirstName() {
		return jTextFieldName.getText();
	}
	
	public String getLastName() {
		return null;
	}
	
	public String getEmail() {
		return jTextFieldEmail.getText();
	}
	
	public String getPassword() {
		return jTextFieldPasswor.getText();
	}
	
	public String getDocument() {
		return jTextFieldid.getText();
	}
	
	public String getTypeDocument() {
		return (String) jComboBox.getSelectedItem();
	}
	
	/**
	 * Metodo que verifica el campo de entrada de la fecha de nacimiento utilizando 
	 * una libreria externa y convirtiendo el valor en un String!
	 * @return la cadena con el valor extraido del textfield si lo encuantra, sino 
	 * devuelve un null!
	 */
	public String getBirthDate() {
		if (jDateChooseBirthDate.getDate() != null) {
			Date date = jDateChooseBirthDate.getDate();
			DateFormat df = DateFormat.getDateInstance();
			String date2 = df.format(date);
			return date2;
		}
		return null;
	}

}