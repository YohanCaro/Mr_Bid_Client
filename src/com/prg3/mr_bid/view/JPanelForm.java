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

import com.prg3.mr_bid.controller.Commands;
import com.prg3.mr_bid.controller.UserController;

public class JPanelForm extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabelName, jLabelImage;
	private JButton jBLogin, jButton;
	private JTextField jTextFieldName, jTextFieldEmail, jTextFieldPasswor, jTextFieldid, jTextFieldBirthdate, jTextFieldgenero, jTextFieldCaptchat ;
	private JComboBox jComboBox;
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
		createTextField("Fecha de Nacimiento", 150, 270,jTextFieldBirthdate);
		
		createLabel("Genero", 20, 320);
		createTextField("Genero", 150, 320,jTextFieldgenero);
		
		
		jButton = new JButton("Add Tarjeta");
		jButton.setActionCommand(Commands.SHOW_ADD_CREDIT_CARD.name());
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


	public JTextField createTextField(String name, int x, int y, JTextField atribute) {
		atribute = new JTextField(name);
		atribute.setBounds(x, y, 250, 40);
		atribute.setBackground(new Color(244, 244, 244));
		atribute.setPreferredSize(new Dimension(200, 60));
		add(atribute);
		return atribute;

	}

}