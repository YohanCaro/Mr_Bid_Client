package com.prg3.mr_bid.view;

import java.awt.Color;
import java.awt.Dimension;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import com.prg3.mr_bid.controller.ControlCommands;
import com.prg3.mr_bid.controller.UserController;
import com.prg3.mr_bid.model.entity.Gender;
import com.prg3.mr_bid.model.entity.TypeDocument;
import com.prg3.mr_bid.utilities.HintJTextField;
import com.prg3.mr_bid.utilities.Utilities;
import com.toedter.calendar.JDateChooser;

public class JPanelForm extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabelName, jLabelImage;
	private JButton jBRegist, jButton;
	private HintJTextField jTextFieldName, jTextFieldEmail, jTextFieldPasswor, jTextFieldid,
			jTextFieldLastName, jTextFieldCaptchat;
	private JComboBox<TypeDocument> jComboBox;
	private JPanelRobotCenter jPanelRobotCenter;
	private JDateChooser jDateChooser;
	private JRadioButton jRadioButton, jRadioButton2;
	private ButtonGroup buttonGroup;

	public JPanelForm(UserController controller) {
		this.jPanelRobotCenter = new JPanelRobotCenter();
		this.setLayout(null);
		setSize(350, 400);
		initComponents(controller);

	}

	private void initComponents(UserController controller) {

		this.setBackground(Color.WHITE);
		
		createLabel("Nombre", 20, 20);
		jTextFieldName = createTextField("name", 150, 20, jTextFieldName, 120);
		jTextFieldLastName = createTextField("last name", 280, 20, jTextFieldLastName, 120);

		createLabel("EMAIL", 20, 70);
		jTextFieldEmail = createTextField("email", 150, 70, jTextFieldEmail, 250);

		createLabel("Passwor", 20, 120);
		jTextFieldPasswor = createTextField("Password", 150, 120, jTextFieldPasswor, 250);

		createLabel("Tipo de Documento", 20, 170);
		jComboBox = new JComboBox<TypeDocument>();
		jComboBox.setBackground(Color.WHITE);
		jComboBox.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(0, 0, 0, 0), new EtchedBorder()));
		jComboBox.setBounds(150, 170, 250, 40);
		jComboBox.setBackground(new java.awt.Color(244, 244, 244));
		add(jComboBox);

		jComboBox.addItem(TypeDocument.CEDULA);
		jComboBox.addItem(TypeDocument.TI);
		jComboBox.addItem(TypeDocument.PASAPORTE);

		createLabel("Numero Documento", 20, 220);
		jTextFieldid = createTextField("Numero Documento", 150, 220, jTextFieldid, 250);

		createLabel("Fecha de Nacimiento", 20, 270);
		jDateChooser = new JDateChooser();
		jDateChooser.setBounds(150, 280, 250, 30);
		add(jDateChooser);

		createLabel("Genero", 20, 320);

		jRadioButton = new JRadioButton("FEMALE");
		jRadioButton.setBounds(150, 330, 100, 30);
		jRadioButton.setSelected(true);
		add(jRadioButton);

		jRadioButton2 = new JRadioButton("MALE");
		jRadioButton2.setBounds(250, 330, 100, 30);
		add(jRadioButton2);

		buttonGroup = new ButtonGroup();
		buttonGroup.add(jRadioButton);
		buttonGroup.add(jRadioButton2);

		jButton = new JButton("Add Tarjeta");
		jButton.setActionCommand(ControlCommands.SHOW_ADD_CREDIT_CARD.name());
		jButton.addActionListener(controller);
		jButton.setBounds(150, 370, 250, 40);
		add(jButton);

		createLabel("CAPTCHAT", 20, 420);
		jTextFieldCaptchat = createTextField("CAPTCHAT", 150, 420, jTextFieldCaptchat, 250);

		jBRegist = new JButton("Registrar");
		jBRegist.setBounds(150, 480, 250, 40);
		jBRegist.setActionCommand(ControlCommands.ACTION_SINGIN.name());
		jBRegist.addActionListener(controller);
		add(jBRegist);
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

	public HintJTextField createTextField(String name, int x, int y, HintJTextField atribute, int xsize) {
		atribute = new HintJTextField(name);
		atribute.setBounds(x, y, xsize, 40);
		atribute.setBackground(new Color(244, 244, 244));
		atribute.setPreferredSize(new Dimension(200, 60));
		add(atribute);
		return atribute;

	}
	
	public String getFirstName() {
		if (jTextFieldName.getText() != null && !jTextFieldName.getText().isEmpty()) {
			return jTextFieldName.getText();
		} 
		return null;
	}

	public String getLastName() {
		if (jTextFieldLastName.getText() != null && !jTextFieldLastName.getText().isEmpty()) {
			return jTextFieldLastName.getText();
		} 
		return null;
	}

	public String getEmail() {
		if (Utilities.isEmailAvailable(jTextFieldEmail.getText())){
			return jTextFieldEmail.getText();
		} else {
			jTextFieldEmail.setForeground(Color.RED);
		}
		return null;
	}

	public String getPassword() {
		if (jTextFieldPasswor.getText() != null && !jTextFieldPasswor.getText().isEmpty()) {
			return jTextFieldPasswor.getText();
		} 
		return null;
	}

	public String getDocument() {
		if (jTextFieldid.getText() != null && !jTextFieldid.getText().isEmpty()) {
			return jTextFieldid.getText();
		} 
		return null;
	}

	public TypeDocument getTypeDocument() {
		return (TypeDocument) jComboBox.getSelectedItem();
	}
	
	public Gender getGender() {
		return (jRadioButton2.isSelected()?Gender.MALE:Gender.FEMALE);
	}

	/**
	 * Metodo que verifica el campo de entrada de la fecha de nacimiento utilizando 
	 * una libreria externa y convirtiendo el valor en un String!
	 * @return la cadena con el valor extraido del textfield si lo encuantra, sino 
	 * devuelve un null!
	 */
	public String getBirthDate() {
		if (jDateChooser.getDate() != null) {
			Date date = jDateChooser.getDate();
			DateFormat df = DateFormat.getDateInstance();
			String date2 = df.format(date);
			return date2; 
		}
		return null;
	}

}