package com.prg3.mr_bid.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import com.prg3.mr_bid.controller.ControlCommands;
import com.prg3.mr_bid.controller.UserController;
import com.prg3.mr_bid.model.entity.ConstantsBid;
import com.prg3.mr_bid.model.entity.TypeProduct;
import com.prg3.mr_bid.utilities.HandlerLanguage;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

/**
 * Clase JPanelMainAddProduct - 
 *
 * @version 1.0 - 2/06/2019
 */
public class JPanelMainAddProduct extends JPanel {

	private JPanel jPanelNorth, jPanelSouth, jPanelWest, jPanelEast, jPanelCenter, jPanelCard1, jPanelCard2,
			jPanelCard3;
	private JLabel jLabel;
	private ImageIcon imageIcon;
	private Icon icon;
	private JLabel jLabelName,jLabelDescription;
	private JComboBox<TypeProduct> typeJComboBox;
	private JTextField jTextFieldName, jTextFieldTy;
	private JTextArea descriptionJTextArea;
	private JDateChooser jCalendar, jCalendar2, jCalendar3;
	private JRadioButton jRadioButton, jRadioButton2, jRadioButtonPublic, jRadioButtonPrivate;
	private ButtonGroup buttonGroup, buttonGroup2;
	private JSpinner jSpinnerPublicatedHour, jSpinnerStartHour, jSpinnerFinishHour;
	private JFileChooser jFileChooser;
	private JButton jButtoncreate, jButtonCancel;

	public JPanelMainAddProduct(UserController control) {
		this.jPanelNorth = new JPanel();
		this.jPanelSouth = new JPanel();
		this.jPanelWest = new JPanel();
		this.jPanelEast = new JPanel();
		this.jPanelCenter = new JPanel();

		this.jLabel = new JLabel();
		character();
		sizePanel();
		Card1(control);
		Card2();
		Card3(control);

		init();
	}

	private void character() {
		// jPanelNorth.setBackground(Color.RED);
		jPanelSouth.setBackground(Color.GREEN);
		jPanelCenter.setBackground(Color.black);

	}

	private void sizePanel() {

		jPanelWest.setPreferredSize(new Dimension(100, 0));
		jPanelEast.setPreferredSize(new Dimension(100, 0));
		jPanelNorth.setPreferredSize(new Dimension(0, 100));
		jPanelCenter.setPreferredSize(new Dimension(0, 1000));// tamaño del panel central

	}

	private void Card1(UserController control) {
		this.jPanelCard1 = new JPanel();
		JButton jButton = new JButton("Agregar imagen");
		jButton.setActionCommand(ControlCommands.ADD_PHOTO.name());
		jButton.addActionListener(control);
		descriptionJTextArea = new JTextArea();
		descriptionJTextArea.setBounds(600, 60, 500, 200);
		jButton.setBounds(200, 180, 200, 30);
		jPanelCard1.setLayout(null);
		jPanelCard1.setBackground(Color.LIGHT_GRAY);

		jPanelCard1.add(createLabel("DATOS DEL PRODUCTO", 10, 10, 200, 30));
		
		
//		jPanelCard1.add(createLabel("DESCRIPCION", 600, 10, 200, 30));
		jLabelDescription = new JLabel(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_DESCRIPTION));
		jLabelDescription.setBounds(600, 10, 200, 30);
		jLabelDescription.setBackground(new Color(244, 244, 244));
		jLabelDescription.setPreferredSize(new Dimension(200, 60));
		jPanelCard1.add(jLabelDescription);
		
		
		

		jPanelCard1.add(createLabel("TIPO DE LA PUBLICACIONs", 20, 60, 200, 30));
		jTextFieldName = createTextField("TIPO DE LA PUBLICACIONs", 200, 60, 200, 30);
		jPanelCard1.add(jTextFieldName);
		jPanelCard1.add(createLabel("TIPO DE PRODUCTO", 20, 120, 200, 30));
//		jPanelCard1.add(createTextField("TIPO DE  PRODUCTO", 200, 120, 200, 30));
		typeJComboBox = new JComboBox<>(TypeProduct.values());
		typeJComboBox.setBounds(200, 120, 200, 30);
		jPanelCard1.add(typeJComboBox);
		jPanelCard1.add(jButton);
		jPanelCard1.add(descriptionJTextArea);

	}

	private void Card2() {
		this.jPanelCard2 = new JPanel();

		JButton jButton = new JButton("Agregar imagen");
		JTextArea jTextArea = new JTextArea();
		jTextArea.setBounds(600, 60, 500, 200);
		jButton.setBounds(200, 180, 200, 30);
		jPanelCard2.setLayout(null);
		jPanelCard2.setBackground(Color.LIGHT_GRAY);

		jPanelCard2.add(createLabel("TIEMPO DE LA SUBASTA", 10, 10, 200, 30));

		jPanelCard2.add(createLabel("FECHA DE LA PUBLICACION", 20, 60, 200, 30));
		jPanelCard2.add(createLabel("FECHA DE INICIO", 20, 120, 200, 30));
		jPanelCard2.add(createLabel("FECHA DE CIERRE", 20, 180, 200, 30));

		jCalendar = new JDateChooser();
		jCalendar.setBounds(200, 60, 200, 30);
		jPanelCard2.add(jCalendar);

		jCalendar2 = new JDateChooser();
		jCalendar2.setBounds(200, 120, 200, 30);
		jPanelCard2.add(jCalendar2);

		jCalendar3 = new JDateChooser();
		jCalendar3.setBounds(200, 180, 200, 30);
		jPanelCard2.add(jCalendar3);

		jPanelCard2.add(createLabel("HORA DE LA PUBLICACION", 600, 60, 200, 30));
		jSpinnerPublicatedHour = new JSpinner(new SpinnerNumberModel(8, 0, 24, 1));
		jSpinnerPublicatedHour.setBounds(790, 60, 200, 30);
		jPanelCard2.add(jSpinnerPublicatedHour);

		jPanelCard2.add(createLabel("HORA DE INICIO", 600, 120, 200, 30));
		jSpinnerStartHour = new JSpinner(new SpinnerNumberModel(8, 0, 24, 1));
		jSpinnerStartHour.setBounds(790, 120, 200, 30);
		jPanelCard2.add(jSpinnerStartHour);

		jPanelCard2.add(createLabel("HORA DE CIERRE", 600, 180, 200, 30));
		jSpinnerFinishHour = new JSpinner(new SpinnerNumberModel(8, 0, 24, 1));
		jSpinnerFinishHour.setBounds(790, 180, 200, 30);
		jPanelCard2.add(jSpinnerFinishHour);

	}

	private void Card3(UserController controller) {
		this.jPanelCard3 = new JPanel();

		JButton jButton = new JButton("Agregar imagen");
		JTextArea jTextArea = new JTextArea();
		jTextArea.setBounds(600, 60, 500, 200);
		jButton.setBounds(200, 180, 200, 30);
		jPanelCard3.setLayout(null);
		jPanelCard3.setBackground(Color.LIGHT_GRAY);

		jPanelCard3.add(createLabel("SOBRE LA SUBASTA", 10, 10, 200, 30));

		jPanelCard3.add(createLabel("VALOR MINIMO ACEPTADO", 20, 60, 200, 30));
		jPanelCard3.add(createLabel("TIPO DE INCEMENTO ", 20, 120, 200, 30));
		jPanelCard3.add(createLabel("TIPO DE SUBASTA", 20, 180, 200, 30));
		jTextFieldTy = createTextField2("TIPO DE INCREMENTO ", 200, 120, 200, 30);
		jPanelCard3.add(jTextFieldTy);

		jRadioButton = new JRadioButton("FEMALE");
		jRadioButton.setBounds(200, 60, 100, 30);
		jRadioButton.setSelected(true);
		jPanelCard3.add(jRadioButton);

		jRadioButton2 = new JRadioButton("MALE");
		jRadioButton2.setBounds(300, 60, 100, 30);
		jPanelCard3.add(jRadioButton2);

		buttonGroup = new ButtonGroup();
		buttonGroup.add(jRadioButton);
		buttonGroup.add(jRadioButton2);

		jRadioButtonPublic = new JRadioButton("PUBLIC");
		jRadioButtonPublic.setBounds(200, 180, 100, 30);
		jRadioButtonPublic.setSelected(true);
		jPanelCard3.add(jRadioButtonPublic);

		jRadioButtonPrivate = new JRadioButton("PRIVATE");
		jRadioButtonPrivate.setBounds(300, 180, 100, 30);
		jPanelCard3.add(jRadioButtonPrivate);

		buttonGroup2 = new ButtonGroup();
		buttonGroup2.add(jRadioButtonPublic);
		buttonGroup2.add(jRadioButtonPrivate);
		
		
		jButtoncreate = new JButton("CREAR");
		jButtoncreate.setBounds(400, 230, 100, 30);
		jButtoncreate.setActionCommand(ControlCommands.ACTION_BIDDING.name());
		jButtoncreate.addActionListener(controller);
		jPanelCard3.add(jButtoncreate);
		
		
		jButtonCancel = new JButton("CANCELAR");
		jButtonCancel.setBounds(600, 230, 100, 30);
		jButtonCancel.setActionCommand(ControlCommands.CLOSE_PRODUCT.name());
		jButtonCancel.addActionListener(controller);
		jPanelCard3.add(jButtonCancel);

	}

	private void init() {

		this.setLayout(new BorderLayout());
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());

		jPanelCenter.setLayout(new GridLayout(3, 1, 0, 20));
		jPanelCenter.add(jPanelCard1);
		jPanelCenter.add(jPanelCard2);
		jPanelCenter.add(jPanelCard3);

		this.add(jPanelNorth, BorderLayout.NORTH);
		this.add(jPanelSouth, BorderLayout.SOUTH);
		this.add(jPanelWest, BorderLayout.WEST);
		this.add(jPanelEast, BorderLayout.EAST);
		this.add(jPanelCenter, BorderLayout.CENTER);

	}

	public JLabel createLabel(String name, int x, int y, int sisex, int sizey) {
		jLabelName = new JLabel(name);
		jLabelName.setBounds(x, y, sisex, sizey);
		jLabelName.setBackground(new Color(244, 244, 244));
		jLabelName.setPreferredSize(new Dimension(200, 60));
		add(jLabelName);
		return jLabelName;

	}

	public JTextField createTextField(String name, int x, int y, int sisex, int sizey) {
		jTextFieldName = new JTextField(name);
		jTextFieldName.setBounds(x, y, sisex, sizey);
		jTextFieldName.setBackground(new Color(244, 244, 244));
		add(jTextFieldName);
		return jTextFieldName;

	}
	
	public JTextField createTextField2(String name, int x, int y, int sisex, int sizey) {
		jTextFieldTy = new JTextField(name);
		jTextFieldTy.setBounds(x, y, sisex, sizey);
		jTextFieldTy.setBackground(new Color(244, 244, 244));
		add(jTextFieldTy);
		return jTextFieldTy;

	}
	
	public String getJTextName() {
		if (jTextFieldName.getText() != null && !jTextFieldName.getText().isEmpty()) {
			return jTextFieldName.getText();
		}
		return null;
	}
	
	public String getDescription() {
		if (descriptionJTextArea.getText() != null && !descriptionJTextArea.getText().isEmpty()) {
			return descriptionJTextArea.getText();
		}
		return null;
	}
	
	public TypeProduct getTypeProduct() {
		return (TypeProduct) typeJComboBox.getSelectedItem();
	}
	
	/**
	 * Metodo que verifica el campo de entrada de la fecha 
	 * @return la cadena con el valor extraido del textfield si lo encuantra, sino 
	 * devuelve un null!
	 */
	public String getDateP() {
		if (jCalendar.getDate() != null) {
			Date date = jCalendar.getDate();
			DateFormat df = DateFormat.getDateInstance();
			String date2 = df.format(date);
			return date2; 
		}
		return null;
	}

	/**
	 * Metodo que verifica el campo de entrada de la fecha 
	 * @return la cadena con el valor extraido del textfield si lo encuantra, sino 
	 * devuelve un null!
	 */
	public String getDateI() {
		if (jCalendar.getDate() != null) {
			Date date = jCalendar.getDate();
			DateFormat df = DateFormat.getDateInstance();
			String date2 = df.format(date);
			return date2; 
		}
		return null;
	}
	
	/**
	 * Metodo que verifica el campo de entrada de la fecha 
	 * @return la cadena con el valor extraido del textfield si lo encuantra, sino 
	 * devuelve un null!
	 */
	public String getDateF() {
		if (jCalendar.getDate() != null) {
			Date date = jCalendar.getDate();
			DateFormat df = DateFormat.getDateInstance();
			String date2 = df.format(date);
			return date2; 
		}
		return null;
	}
	
	public byte hourP() {
		return (byte)((int) jSpinnerPublicatedHour.getModel().getValue());
	}
	
	public byte hourI() {
		return (byte)((int) jSpinnerStartHour.getModel().getValue());
	}
	
	public byte hourF() {
		return (byte)((int) jSpinnerFinishHour.getModel().getValue());
	}
	
	public void changeLanguage() {
//		jRadioButton.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_ENGLISH));


	}

}
