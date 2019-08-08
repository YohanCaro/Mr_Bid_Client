package com.prg3.mr_bid.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.Bidi;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.prg3.mr_bid.controller.ControlCommands;
import com.prg3.mr_bid.controller.UserController;
import com.prg3.mr_bid.model.entity.BidState;
import com.prg3.mr_bid.model.entity.Bidding;
import com.prg3.mr_bid.model.entity.ConstantsBid;
import com.prg3.mr_bid.structures.simple_list.SimpleList;
import com.prg3.mr_bid.utilities.Constants;
import com.prg3.mr_bid.utilities.HandlerLanguage;
import com.prg3.mr_bid.utilities.Utilities;

/**
 * Esta clase tiene el diseño de la venytana donde se muestra la informacion de
 * cada Producto
 * 
 * @author Daniel Garcia
 * @version 1.0 - 23/07/2019
 */
public class JPanelMainProduct extends JPanel {

	private JpanelChat jpanelChat;
	private JPanel jPanelSouth, jPanelWest, jPanelEast, jPanelCenter, jPanelDere, jPanelizq, jPanelizqImage,
			jPanelizqInfo, jPanelderNorth, jPanelderCenter, jPanelCard, jPanelCardnorth, jPanelCardSouth,
			jPanelCardWest, jPanelCardEast, jPanelCard2, jPanelCardnorth2, jPanelCardSouth2, jPanelCardWest2,
			jPanelCardEast2, jPanelNorth3, jPanelCardWest3, jPanelCardEast3, jPanelizqSouth, jPanelNorth4,
			jPanelCardCenterIzquie, jPanelCardWest4, jPanelCardEast4, jPanelCardSouthIzquie, cardPublicaciones,
			cardParticipantes;
	private JPanelOptionMenu jPanelOptionMenu;
	private JScrollPane jScrollPane, jScrollPane2;
	private JTextArea jTextArea, jTextAreaChat, jTextAreaParticipantes;
	private JTextField name, correo, password, offer, publicaciones, valuePuja, valueActually, mayorPostor,
			jTextFieldPrincipalName;
	private JLabel jLabelPrinciaplName, jLabel, jLabel2, jLabel3, jLabel4, jLabelState, jLabelTime, jLabelFinish,
			jLabelCurrenntValue, jLabelMayorPostor, jLabelVauleBid;
	private ImageIcon imageIcon, imageIcon2;
	private Icon icon, icon2;
	private String text;
	private Bidding bidding;
	JButton jButton;

	/**
	 * Constructor vacio
	 */
	public JPanelMainProduct() {

	}

	/**
	 * inicializa los componentes de la clase
	 * 
	 * @param userController
	 */
	public void start(UserController userController, long idBid) {
		this.setOpaque(false);
		this.jpanelChat = new JpanelChat(idBid);
		this.jPanelSouth = new JPanel();
		this.jPanelizqImage = new JPanel();
		this.jPanelizqInfo = new JPanel();
		this.jPanelderNorth = new JPanel();
		this.jPanelderCenter = new JPanel();
		this.jPanelWest = new JPanel();
		this.jPanelDere = new JPanel();
		this.jPanelizq = new JPanel();
		this.jPanelEast = new JPanel();
		this.jPanelCenter = new JPanel();
		this.jPanelCard = new JPanel();
		this.jPanelCard2 = new JPanel();
		this.jScrollPane = new JScrollPane(jTextAreaParticipantes);
		this.jScrollPane2 = new JScrollPane(jTextArea);

		jPanelCenter.setOpaque(false);
		jPanelizqImage.setOpaque(false);
		jPanelderNorth.setOpaque(false);
		jPanelderCenter.setOpaque(false);
		jPanelWest.setOpaque(false);
		jPanelDere.setOpaque(false);
		jPanelizq.setOpaque(false);
		jPanelEast.setOpaque(false);
		this.jTextArea = new JTextArea();
		this.jLabel = new JLabel();
		// getValueActually();
		cardParticipantes();
		card();
		jtextArea();
		sizePanel();
		card2(userController);
		cardPublicaciones();
		JpanelImage();
		init();
		this.blockJTextField();
	}

	/**
	 * Metodo que recibe un lsita simple con los mensajes para el chat
	 * 
	 * @param message
	 */
	public JPanelMainProduct(SimpleList<String> message) {
		sendComment(message);
	}

	/**
	 * Panel que contiene la imagen del producto
	 */
	private void JpanelImage() {
		imageIcon = new ImageIcon("data/images/tv.jpg");
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(350, 350, Image.SCALE_AREA_AVERAGING));
		jLabel.setIcon(icon);
		jPanelizqImage.add(jLabel);
	}

	/**
	 * Metdo encargado de disñar el campo donde se alamcena la descripcion del
	 * producto
	 */
	private void jtextArea() {
		jTextArea.setText(bidding.getProduct().getDescription());
		jTextArea.setPreferredSize(new Dimension(400, 180));
		jTextArea.setLineWrap(true);
		jPanelizqInfo.setBackground(new Color(0, 0, 0, 94));
		jScrollPane2.setPreferredSize(new Dimension(400, 300));
		jScrollPane2.setViewportView(jTextArea);
		jPanelizqInfo.add(jScrollPane2);
	}

	/**
	 * Crea una tarjtea tipo panel donde se almacen la informacion del producto
	 * relacionada con los tiempos de la subasta
	 */
	private void card() {
		jPanelCard.setLayout(null);
		jPanelCard.setBackground(new Color(0, 0, 0, 94));

		jLabelState = new JLabel("NOMBRE");
		jLabelState.setBounds(20, 10, 300, 25);
		jLabelState.setFont(new Font("Andale Mono", 3, 15));
		jLabelState.setForeground(Color.WHITE);
		// jLabel.setBackground(Color.BLUE);
		jPanelCard.add(jLabelState);

		name = new JTextField(bidding.getBiddingName());
		name.setBounds(20, 40, 320, 25);
		name.setBackground(new java.awt.Color(224, 224, 224));
		name.setFont(new java.awt.Font("Andale Mono", 1, 14));
		name.setForeground(new java.awt.Color(255, 0, 0));
		jPanelCard.add(name);

		jLabelTime = new JLabel(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_STATE));
		jLabelTime.setBounds(20, 85, 200, 25);
		jLabelTime.setFont(new Font("Andale Mono", 3, 15));
		jLabelTime.setForeground(Color.WHITE);
		jLabelTime.setBackground(Color.BLUE);
		jPanelCard.add(jLabelTime);

		correo = new JTextField(Utilities.getState(bidding).toString());
		correo.setBounds(20, 115, 320, 25);
		correo.setBackground(new java.awt.Color(224, 224, 224));
		correo.setFont(new java.awt.Font("Andale Mono", 1, 14));
		correo.setForeground(new java.awt.Color(255, 0, 0));
		jPanelCard.add(correo);

		jLabelFinish = new JLabel(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_TIME));
		jLabelFinish.setBounds(20, 150, 200, 25);
		jLabelFinish.setFont(new Font("Andale Mono", 3, 15));
		jLabelFinish.setForeground(Color.WHITE);
		jLabelFinish.setBackground(Color.BLUE);
		jPanelCard.add(jLabelFinish);

		password = new JTextField(Utilities.getTimeRemaining(bidding));
		password.setBounds(20, 175, 320, 25);
		password.setBackground(new java.awt.Color(224, 224, 224));
		password.setFont(new java.awt.Font("Andale Mono", 1, 14));
		password.setForeground(new java.awt.Color(255, 0, 0));
		jPanelCard.add(password);

		jLabelPrinciaplName = new JLabel(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_FINISH));
		jLabelPrinciaplName.setBounds(20, 200, 200, 25);
		jLabelPrinciaplName.setFont(new Font("Andale Mono", 3, 15));
		jLabelPrinciaplName.setForeground(Color.WHITE);
		jLabelPrinciaplName.setBackground(Color.BLUE);
		jPanelCard.add(jLabelPrinciaplName);

		jTextFieldPrincipalName = new JTextField(bidding.getFinishTime().toString() + " horas");
		jTextFieldPrincipalName.setBounds(20, 225, 320, 25);
		jTextFieldPrincipalName.setBackground(new java.awt.Color(224, 224, 224));
		jTextFieldPrincipalName.setFont(new java.awt.Font("Andale Mono", 1, 14));
		jTextFieldPrincipalName.setForeground(new java.awt.Color(255, 0, 0));
		jPanelCard.add(jTextFieldPrincipalName);

		this.jPanelCardnorth = new JPanel();
		this.jPanelCardSouth = new JPanel();
		this.jPanelCardWest = new JPanel();
		this.jPanelCardEast = new JPanel();

		jPanelCardnorth.setOpaque(false);
		jPanelCardSouth.setOpaque(false);
		jPanelCardWest.setOpaque(false);
		jPanelCardEast.setOpaque(false);

		// jPanelCard.setBackground(new Color(0, 0, 0, 94));
		jPanelderNorth.setLayout(new BorderLayout());
		jPanelderNorth.setOpaque(false);

		jPanelCardnorth.setPreferredSize(new Dimension(50, 50));
		jPanelCardSouth.setPreferredSize(new Dimension(50, 50));
		jPanelCardWest.setPreferredSize(new Dimension(50, 50));
		jPanelCardEast.setPreferredSize(new Dimension(50, 50));

		jPanelderNorth.add(jPanelCard, BorderLayout.CENTER);
		jPanelderNorth.add(jPanelCardnorth, BorderLayout.NORTH);
		jPanelderNorth.add(jPanelCardSouth, BorderLayout.SOUTH);
		jPanelderNorth.add(jPanelCardWest, BorderLayout.WEST);
		jPanelderNorth.add(jPanelCardEast, BorderLayout.EAST);
	}

	/**
	 * Metodo que crea una tarjeta con la informacion de la puja de la subasta
	 * 
	 * @param userController
	 */
	private void card2(UserController userController) {
		JLabel jLabel, jLabel2;
		JTextField name, correo;
		// this.bidding = Constants.biddingsList.get((int)(bidding.getId()-1));
		jPanelCard2.setLayout(null);
		jPanelCard2.setBackground(new Color(0, 0, 0, 94));

		jLabelCurrenntValue = new JLabel(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_CURRENTVALUE));
		jLabelCurrenntValue.setBounds(20, 10, 300, 25);
		jLabelCurrenntValue.setFont(new Font("Andale Mono", 3, 15));
		jLabelCurrenntValue.setForeground(Color.WHITE);
		jLabelCurrenntValue.setBackground(Color.BLUE);
		jPanelCard2.add(jLabelCurrenntValue);
		valueActually = new JTextField(bidding.getValue() + "");
		valueActually.setBounds(20, 40, 320, 25);
		valueActually.setBackground(new java.awt.Color(224, 224, 224));
		valueActually.setFont(new java.awt.Font("Andale Mono", 1, 14));
		valueActually.setForeground(new java.awt.Color(255, 0, 0));
		jPanelCard2.add(valueActually);

		jLabelVauleBid = new JLabel(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_VALUEBID));
		jLabelVauleBid.setBounds(20, 85, 200, 25);
		jLabelVauleBid.setFont(new Font("Andale Mono", 3, 15));
		jLabelVauleBid.setForeground(new Color(0, 0, 0, 94));
		jLabelVauleBid.setBackground(new Color(0, 0, 0, 94));
		jPanelCard2.add(jLabelVauleBid);

		// valuePuja = new JTextField(bidding.getIncrement());
		valuePuja = new JTextField("0");
		valuePuja.setBounds(20, 115, 320, 25);
		valuePuja.setBackground(new java.awt.Color(224, 224, 224));
		valuePuja.setFont(new java.awt.Font("Andale Mono", 1, 14));
		valuePuja.setForeground(new java.awt.Color(255, 0, 0));
		jPanelCard2.add(valuePuja);

		jButton = new JButton(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_BID));
		jButton.setBounds(20, 150, 320, 50);
		jButton.setActionCommand(ControlCommands.SEND_BID.name() + "," + bidding.getId());
		jButton.addActionListener(userController);
		jButton.setEnabled(false);
		if (Utilities.getState(bidding).equals(BidState.INICIADA)) {
			jButton.setEnabled(true);
		}
		jPanelCard2.add(jButton);

		this.jPanelCardnorth2 = new JPanel();
		this.jPanelCardSouth2 = new JPanel();
		this.jPanelCardWest2 = new JPanel();
		this.jPanelCardEast2 = new JPanel();
		this.jPanelCardWest3 = new JPanel();
		this.jPanelCardEast3 = new JPanel();
		this.jPanelCardWest4 = new JPanel();
		this.jPanelCardEast4 = new JPanel();
		this.jPanelNorth4 = new JPanel();

		jPanelCardnorth2.setOpaque(false);
		jPanelCardSouth2.setOpaque(false);
		jPanelCardWest2.setOpaque(false);
		jPanelCardEast2.setOpaque(false);
		jPanelCardWest3.setOpaque(false);
		jPanelCardEast3.setOpaque(false);
		jPanelCardWest4.setOpaque(false);
		jPanelCardEast4.setOpaque(false);

		jPanelCard2.setBackground(new Color(0, 0, 0, 94));
		jPanelCard2.setPreferredSize(new Dimension(500, 900));
		jPanelderCenter.setLayout(new BorderLayout());

		jPanelCardnorth2.setPreferredSize(new Dimension(50, 50));
		jPanelCardSouth2.setPreferredSize(new Dimension(50, 500));
		jPanelCardWest2.setPreferredSize(new Dimension(50, 50));
		jPanelCardEast2.setPreferredSize(new Dimension(50, 50));
		jPanelCardWest3.setPreferredSize(new Dimension(50, 100));
		jPanelCardEast3.setPreferredSize(new Dimension(50, 200));

		jPanelNorth3 = new JPanel();
		jPanelNorth3.setPreferredSize(new Dimension(50, 50));
		jPanelNorth3.setOpaque(false);
		jpanelChat.setPreferredSize(new Dimension(400, 300));
		jPanelCardSouth2.setLayout(new BorderLayout());
		jPanelCardSouth2.add(jPanelNorth3, BorderLayout.NORTH);
		jPanelCardSouth2.add(jpanelChat, BorderLayout.CENTER);
		jPanelCardSouth2.add(jPanelCardWest3, BorderLayout.WEST);
		jPanelCardSouth2.add(jPanelCardEast3, BorderLayout.EAST);

		jPanelderCenter.add(jPanelCard2, BorderLayout.CENTER);
		jPanelderCenter.add(jPanelCardnorth2, BorderLayout.NORTH);
		jPanelderCenter.add(jPanelCardSouth2, BorderLayout.SOUTH);
		jPanelderCenter.add(jPanelCardWest2, BorderLayout.WEST);
		jPanelderCenter.add(jPanelCardEast2, BorderLayout.EAST);

	}

	/**
	 * Asigane el tamaño de los paneles
	 */
	private void sizePanel() {

		jPanelWest.setPreferredSize(new Dimension(100, 0));
		jPanelEast.setPreferredSize(new Dimension(100, 0));
		jPanelizq.setPreferredSize(new Dimension(500, 0));
		jPanelDere.setPreferredSize(new Dimension(100, 0));
		jPanelizqImage.setPreferredSize(new Dimension(100, 400));
		jPanelderNorth.setPreferredSize(new Dimension(100, 400));

		jPanelCenter.setPreferredSize(new Dimension(100, 1300));

	}

	/**
	 * Crea una tarjeta con la informacion de la persona que ofrece el producto y
	 * los usuarios que participan
	 */
	private void cardPublicaciones() {

		cardPublicaciones = new JPanel();
		cardPublicaciones.setLayout(null);
		cardPublicaciones.setBackground(new Color(0, 0, 0, 94));

		jLabel3 = new JLabel(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_OFFEREDBY));
		jLabel3.setBounds(20, 10, 300, 25);
		jLabel3.setFont(new Font("Andale Mono", 3, 15));
		jLabel3.setForeground(Color.WHITE);
		jLabel3.setBackground(Color.BLUE);
		cardPublicaciones.add(jLabel3);

		offer = new JTextField("PRIVATE");
		if (bidding.isPublic()) {
			offer = new JTextField(bidding.getOwner());
		}
		offer.setBounds(20, 40, 320, 25);
		offer.setBackground(new java.awt.Color(224, 224, 224));
		offer.setFont(new java.awt.Font("Andale Mono", 1, 14));
		offer.setForeground(new java.awt.Color(255, 0, 0));
		cardPublicaciones.add(offer);

		jLabel2 = new JLabel(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_NUMBEROFPUBLICATIONS));
		jLabel2.setBounds(20, 85, 200, 25);
		jLabel2.setFont(new Font("Andale Mono", 3, 15));
		jLabel2.setForeground(Color.WHITE);
		jLabel2.setBackground(Color.BLUE);
		cardPublicaciones.add(jLabel2);

		publicaciones = new JTextField("PRIVATE");
		if (bidding.isPublic()) {
			publicaciones = new JTextField(bidding.getOwner());
		}
		publicaciones.setBounds(20, 115, 320, 25);
		publicaciones.setBackground(new java.awt.Color(224, 224, 224));
		publicaciones.setFont(new java.awt.Font("Andale Mono", 1, 14));
		publicaciones.setForeground(new java.awt.Color(255, 0, 0));
		cardPublicaciones.add(publicaciones);

		jLabelMayorPostor = new JLabel("MAYOR POSTOR");
		jLabelMayorPostor.setBounds(20, 160, 200, 25);
		jLabelMayorPostor.setFont(new Font("Andale Mono", 3, 15));
		jLabelMayorPostor.setForeground(Color.WHITE);
		jLabelMayorPostor.setBackground(Color.BLUE);
		cardPublicaciones.add(jLabelMayorPostor);

		mayorPostor = new JTextField();
		mayorPostor.setBounds(20, 195, 320, 25);
		mayorPostor.setFont(new Font("Andale Mono", 3, 15));
		mayorPostor.setForeground(new java.awt.Color(255, 0, 0));
		mayorPostor.setBackground(new java.awt.Color(224, 224, 224));
		cardPublicaciones.add(mayorPostor);

	}

	/**
	 * Crea un TexArea donde se almacena los usuarios que participan en la subasta
	 */
	private void cardParticipantes() {

		cardParticipantes = new JPanel();
		cardParticipantes.setLayout(null);
		cardParticipantes.setBackground(new Color(0, 0, 0, 94));

		cardParticipantes.setPreferredSize(new Dimension(10, 200));

		jLabel4 = new JLabel(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_PARTICIPANTS));
		jLabel4.setBounds(20, 10, 300, 25);
		jLabel4.setFont(new Font("Andale Mono", 3, 15));
		jLabel4.setForeground(Color.WHITE);
		jLabel4.setBackground(Color.BLUE);
		cardParticipantes.add(jLabel4);

		jTextAreaParticipantes = new JTextArea("Participantes");
		jTextAreaParticipantes.setEditable(false);
		jTextAreaParticipantes.setBounds(20, 50, 400, 100);
		jScrollPane.setBounds(20, 50, 400, 100);
		jScrollPane.setViewportView(jTextAreaParticipantes);
		cardParticipantes.add(jScrollPane);

	}

	/**
	 * Metodo que inicializa los componentes y orena la ubicacion de las tarjetan en
	 * el panel
	 */
	private void init() {

		this.setLayout(new BorderLayout());
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());

		jPanelDere.setLayout(new BorderLayout());
		jPanelDere.setOpaque(false);
		jPanelderNorth.setOpaque(false);
		jPanelderCenter.setOpaque(false);

		jPanelDere.add(jPanelderNorth, BorderLayout.NORTH);
		jPanelDere.add(jPanelderCenter, BorderLayout.CENTER);

		jPanelizq.setLayout(new BorderLayout());
		jPanelizqSouth = new JPanel();
		jPanelizqSouth.setPreferredSize(new Dimension(0, 500));
		jPanelizq.add(jPanelizqImage, BorderLayout.NORTH);
		jPanelizqSouth.setLayout(new BorderLayout());
		jPanelNorth4 = new JPanel();
		jPanelNorth4.setPreferredSize(new Dimension(50, 50));
		jPanelCardCenterIzquie = new JPanel();
		jPanelCardCenterIzquie.setPreferredSize(new Dimension(50, 50));

		jPanelCardSouthIzquie = new JPanel();
		jPanelCardSouthIzquie.setPreferredSize(new Dimension(50, 300));

		jPanelizqSouth.add(jPanelNorth4, BorderLayout.NORTH);
		jPanelizqSouth.add(cardPublicaciones, BorderLayout.CENTER);
		jPanelizqSouth.add(cardParticipantes, BorderLayout.SOUTH);

		jPanelizq.add(jPanelizqInfo, BorderLayout.CENTER);
		jPanelizq.add(jPanelizqSouth, BorderLayout.SOUTH);

		jPanelCenter.setLayout(new BorderLayout());
		jPanelCenter.setOpaque(false);
		jPanelCenter.add(jPanelDere, BorderLayout.CENTER);
		jPanelCenter.add(jPanelizq, BorderLayout.WEST);

		this.add(jPanelSouth, BorderLayout.SOUTH);
		this.add(jPanelWest, BorderLayout.WEST);
		this.add(jPanelEast, BorderLayout.EAST);
		this.add(jPanelCenter, BorderLayout.CENTER);

	}

	public void blockJTextField() {
		this.jTextArea.setEditable(false);
		this.name.setEditable(false);
		this.correo.setEditable(false);
		this.offer.setEditable(false);
		this.password.setEditable(false);
		this.publicaciones.setEditable(false);
		this.valueActually.setEditable(false);
		this.mayorPostor.setEditable(false);
		if (bidding.isAutomaticIncremet()) {
			this.valuePuja.setEditable(false);
		}
	}

	/**
	 * Asigna una imagen de fondo a la subasta
	 */
	@Override
	protected void paintComponent(Graphics g) {
		imageIcon = new ImageIcon("data/images/fondoLogin.jpg");
		g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paintComponent(g);
	}

	/**
	 * Metodo que manda una lista de mensajes provenientes del chat Provicional
	 * 
	 * @param message
	 * @return
	 */
	public SimpleList<String> sendComment(SimpleList<String> message) {
		SimpleList<String> aux = new SimpleList<>();
		for (int i = 0; i < message.size(); i++) {
			this.text = message.get(i);
			jTextAreaChat.append("\n" + "\n" + "    User: " + text);

		}
		aux.add(jTextAreaChat.getText());
		return aux;
	}

	public void getComment(SimpleList<String> message) {

	}

	/**
	 * Cambia
	 * 
	 * @param bidding
	 *            the bidding to set
	 */
	public void setBidding(Bidding bidding) {
		this.bidding = bidding;
	}

	/**
	 * Obtiene el valor de la puja
	 * 
	 * @return
	 */
	public Double getValuePuja() {
		try {
			return Double.parseDouble(valuePuja.getText());
		} catch (NumberFormatException e) {
			Utilities.showMessageWarning("El valor de la puja debe ser numerico!", "Valorno valido");
		}
		return 0.0;
	}

	/**
	 * Metodo que evalua el tipo de incremento en la subasta
	 * 
	 * @return
	 */
	public boolean isAutomaticIncrement() {
		return bidding.isAutomaticIncremet();
	}

	/**
	 * Obtiene el valor actual del precio del producto
	 * 
	 * @return
	 */
	public Double getValueActually() {

		try {
			return Double.parseDouble(valueActually.getText());

		} catch (NumberFormatException e) {
			Utilities.showMessageWarning("El valor debe ser numerico!", "Valor no valido");
		}

		return 0.0;
	}

	/**
	 * Manda el valor nuevo del producto
	 * 
	 * @param value
	 */
	public void setValueActually(int value) {
		valueActually.setText("" + value);
	}

	/**
	 * Cambia el idioma al panel
	 */
	public void changeLanguage() {
		jLabelState.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_STATE));
		jLabelTime.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_TIME));
		jLabelFinish.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_FINISH));
		jLabelCurrenntValue.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_CURRENTVALUE));
		jLabelVauleBid.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_VALUEBID));
		jButton.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_BID));
		jLabel2.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_NUMBEROFPUBLICATIONS));
		jLabel3.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_OFFEREDBY));
		jLabel4.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_PARTICIPANTS));
	}

	/**
	 * Setea el jtextarea
	 * 
	 * @param s
	 *            set new text
	 */
	public void setJTextP(String s) {
		this.jTextAreaParticipantes.setText(jTextAreaParticipantes.getText() + "\n" + s);
	}

}
