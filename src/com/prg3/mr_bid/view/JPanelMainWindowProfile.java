package com.prg3.mr_bid.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.prg3.mr_bid.controller.ControlCommands;
import com.prg3.mr_bid.controller.UserController;
import com.prg3.mr_bid.model.entity.ConstantsBid;
import com.prg3.mr_bid.model.entity.User;
import com.prg3.mr_bid.utilities.ConstantsView;
import com.prg3.mr_bid.utilities.HandlerLanguage;
import com.prg3.mr_bid.utilities.Utilities;

/**
 * Clase JPanelMainWindowCuenta - Se encarga de crear la ventana principal de la
 * cuenta de usuario
 *
 * @version 1.0 - 4/08/2019
 * @author Daniel García
 */
public class JPanelMainWindowProfile extends JPanel {

	/**
	 * Serial por defecto
	 */
	private static final long serialVersionUID = 1L;
	private JPanelFormProfile jPanelFormProfile;
	private JPanel jPanelNorth, jPanelNorth2, jPanelSouth, jPanelSouth2, jPanelWest, jPanelEast, jPanelCenter,
			jPanelMainImage, jPanelTools, jPanelPhoto;
	private JLabel jLabel;
	private ImageIcon imageIcon;
	private Icon icon;
	private JLabel jLabelName;
	private JButton jButton, jButton2, jButton3, jButton5;

	/**
	 * Constructor que crea los paneles
	 * 
	 * @param controller
	 *            controlador
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	public JPanelMainWindowProfile() throws UnknownHostException, IOException {
		this.setOpaque(false);
		this.jPanelNorth = new JPanel();
		this.jPanelNorth2 = new JPanel();
		this.jPanelSouth = new JPanel();
		this.jPanelSouth2 = new JPanel();
		this.jPanelWest = new JPanel();
		this.jPanelEast = new JPanel();
		this.jPanelCenter = new JPanel();
		this.jPanelMainImage = new JPanel();
		this.jPanelTools = new JPanel();
		this.jPanelPhoto = new JPanel();
		this.jLabel = new JLabel();
		this.jPanelFormProfile = new JPanelFormProfile(null);
		init();
	}

	/**
	 * Organiza los paneles del panel
	 */
	private void character() {
		jPanelNorth.setBackground(Color.WHITE);
		jPanelNorth.setOpaque(false);
		jPanelSouth.setBackground(Color.WHITE);
		jPanelSouth.setOpaque(false);

		jPanelWest.setBackground(Color.WHITE);
		jPanelWest.setOpaque(false);

		jPanelEast.setBackground(Color.WHITE);
		jPanelEast.setOpaque(false);

		jPanelCenter.setBackground(Color.WHITE);
		jPanelTools.setBackground(Color.RED);
	}

	/**
	 * Pone la imagen del usuario
	 */
	private void jPanelImage() {
		imageIcon = new ImageIcon(ConstantsView.PATH_USER_IMAGE);
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_AREA_AVERAGING));
		jLabel.setIcon(icon);
		jPanelMainImage.setOpaque(false);
		jPanelMainImage.add(jLabel);
	}

	/**
	 * Pone los tamaños de los paneles
	 */
	private void sizePanel() {
		jPanelWest.setPreferredSize(Utilities.setDimension(100, 0));
		jPanelEast.setPreferredSize(Utilities.setDimension(100, 0));
		jPanelNorth.setPreferredSize(Utilities.setDimension(0, 100));
		jPanelSouth.setPreferredSize(Utilities.setDimension(0, 100));
		jPanelSouth2.setPreferredSize(Utilities.setDimension(0, 100));

		jPanelMainImage.setPreferredSize(Utilities.setDimension(0, 300));
		jPanelTools.setPreferredSize(Utilities.setDimension(600, 0));
		jPanelPhoto.setPreferredSize(Utilities.setDimension(100, 0));
		jPanelNorth2.setPreferredSize(Utilities.setDimension(100, 10));
	}

	/**
	 * Añade un panel con los campos de los datos del usuario al lado izquierdo del
	 * panel
	 * @param control
	 *            controlador
	 */
	private void addPanelProfile() {
		jPanelTools.setLayout(new BorderLayout());
		jPanelTools.add(jPanelFormProfile, BorderLayout.CENTER);
	}

	/**
	 * Añade el panel donde se marca el nombre del usuario cuando se loguea
	 */
	private void panelPhoto() {
		jLabelName = new JLabel(ConstantsView.TEXT_NOT_LOGIN);
		jLabelName.setFont(ConstantsView.FONT_LABEL_NAME_WD);
		jPanelSouth2.add(jLabelName);
		jPanelPhoto.setLayout(new BorderLayout());
		jPanelPhoto.add(jPanelNorth2, BorderLayout.NORTH);
		jPanelPhoto.add(jPanelSouth2, BorderLayout.SOUTH);
		jPanelPhoto.add(jPanelMainImage, BorderLayout.CENTER);
	}

	/**
	 * Cambia el dato del usuario
	 * 
	 * @param user
	 *            usuario
	 */
	public void changeData(User user) {
		if (user != null) {
			jLabelName.setText(user.getFirstName() + " " + user.getLastName());
			this.repaint();
		}
	}

	/**
	 * Crea los botones con:
	 * 
	 * @param name
	 *            nombre
	 * @param x
	 *            posX
	 * @param y
	 *            posY
	 * @param atribute
	 *            valor
	 * @param url
	 *            path
	 * @param commands
	 *            comandos
	 * @param control
	 *            controlador
	 * @return button boton
	 */
	public JButton createJbuton(String name, int x, int y, JButton atribute, String url, String commands,
			UserController control) {
		atribute = new JButton(HandlerLanguage.languageProperties.getProperty(name));
		atribute.setForeground(ConstantsView.COLOR__FORE_WD);
		atribute.setBackground(ConstantsView.COLOR__BACK_WD);
		atribute.setActionCommand(commands);
		atribute.addActionListener(control);
		imageIcon = new ImageIcon(getClass().getResource(url));
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(70, 70, Image.SCALE_AREA_AVERAGING));
		atribute.setIcon(icon);
		return atribute;
	}

	/**
	 * Inicializa los componentes del panel
	 * 
	 * @param controller
	 *            controlador
	 */
	private void init() {
		panelPhoto();
		addPanelProfile();
		character();
		sizePanel();
		jPanelImage();

		this.setLayout(new BorderLayout());
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		jPanelCenter.setLayout(new BorderLayout());
		jPanelCenter.add(jPanelTools, BorderLayout.WEST);
		jPanelCenter.add(jPanelPhoto, BorderLayout.CENTER);

		this.add(jPanelNorth, BorderLayout.NORTH);
		this.add(jPanelSouth, BorderLayout.SOUTH);
		this.add(jPanelWest, BorderLayout.WEST);
		this.add(jPanelEast, BorderLayout.EAST);
		this.add(jPanelCenter, BorderLayout.CENTER);
	}

	@Override
	protected void paintComponent(Graphics g) {
		imageIcon = new ImageIcon(ConstantsView.PATH_BACK_IMG);
		g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paintComponent(g);
	}

	/**
	 * Cambia el idioma del panel
	 */
	public void changeLanguage() {
		jButton.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_SUMMARY));
		jButton2.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_CREATEAUCTIONS));
		jButton3.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_PROFILE));
		jButton5.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_CONFIGURATION));
	}

	/**
	 * Llama al panel tipo formulario
	 * @return
	 */
	public JPanelFormProfile getjPanelFormProfile() {
		return jPanelFormProfile;
	}

}
