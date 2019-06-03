package com.prg3.mr_bid.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.prg3.mr_bid.controller.ControlCommands;
import com.prg3.mr_bid.controller.UserController;
import com.prg3.mr_bid.model.entity.ConstantsBid;
import com.prg3.mr_bid.model.entity.User;
import com.prg3.mr_bid.utilities.HandlerLanguage;

public class JPanelMainWindowCuenta extends JPanel {

	private JPanel jPanelNorth, jPanelNorth2, jPanelSouth, jPanelSouth2, jPanelWest, jPanelEast, jPanelCenter,
			jPanelMainImage, jPanelTools, jPanelPhoto;
	private JPanelCard jPanelMainWindowProduct;
	private JPanelOptionMenu jPanelOptionMenu;
	private JLabel jLabel;
	private ImageIcon imageIcon;
	private Icon icon;
	private JLabel jLabelName;
	private JButton jButton, jButton2, jButton3, jButton4, jButton5;

	public JPanelMainWindowCuenta(UserController controller) {
		this.setOpaque(false);
		this.jPanelMainWindowProduct = new JPanelCard();
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
		// this.jPanelOptionMenu = new JPanelOptionMenu();
		this.jLabel = new JLabel();
		panelPhoto();
		myjButton(controller);
		character();
		sizePanel();
		JpanelImage();
		init();
	}

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
		jPanelTools.setBackground(Color.WHITE);
		// jPanelPhoto.setBackground(Color.ORANGE);

	}

	private void JpanelImage() {
		imageIcon = new ImageIcon(getClass().getResource("/images/usuario.png"));
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_AREA_AVERAGING));
		jLabel.setIcon(icon);
		jPanelMainImage.setOpaque(false);
		jPanelMainImage.add(jLabel);
	}

	private void sizePanel() {

		jPanelWest.setPreferredSize(new Dimension(100, 0));
		jPanelEast.setPreferredSize(new Dimension(100, 0));
		jPanelNorth.setPreferredSize(new Dimension(0, 100));
		jPanelSouth.setPreferredSize(new Dimension(0, 100));
		jPanelSouth2.setPreferredSize(new Dimension(0, 100));

		jPanelMainImage.setPreferredSize(new Dimension(0, 300));
		jPanelTools.setPreferredSize(new Dimension(600, 0));
		jPanelPhoto.setPreferredSize(new Dimension(100, 0));
		jPanelNorth2.setPreferredSize(new Dimension(100, 10));

	}

	private void myjButton(UserController control) {

		jPanelTools.setLayout(new GridLayout(4, 1));

		jButton = new JButton(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_SUMMARY));
		jButton.setForeground(new Color(244, 244, 244));
		jButton.setBackground(new Color(48, 48, 48));
		jButton.setActionCommand(ControlCommands.SHOW_HISTORY.name());
		jButton.addActionListener(control);
		imageIcon = new ImageIcon(getClass().getResource("/images/bloc.png"));
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(70, 70, Image.SCALE_AREA_AVERAGING));
		jButton.setIcon(icon);
		jPanelTools.add(jButton);
		
		
		jButton2 = new JButton(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_CREATEAUCTIONS));
		jButton2.setForeground(new Color(244, 244, 244));
		jButton2.setBackground(new Color(48, 48, 48));
		jButton2.setActionCommand(ControlCommands.SHOW_ADDPRODUCT.name());
		jButton2.addActionListener(control);
		imageIcon = new ImageIcon(getClass().getResource("/images/venta.png"));
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(70, 70, Image.SCALE_AREA_AVERAGING));
		jButton2.setIcon(icon);
		jPanelTools.add(jButton2);
		

		jButton3 = new JButton(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_PROFILE));
		jButton3.setForeground(new Color(244, 244, 244));
		jButton3.setBackground(new Color(48, 48, 48));
		jButton3.setActionCommand(ControlCommands.SHOW_ADDPRODUCT.name());
		jButton3.addActionListener(control);
		imageIcon = new ImageIcon(getClass().getResource("/images/bloc.png"));
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(70, 70, Image.SCALE_AREA_AVERAGING));
		jButton3.setIcon(icon);
		jPanelTools.add(jButton3);
		
		jButton5 = new JButton(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_CONFIGURATION));
		jButton5.setForeground(new Color(244, 244, 244));
		jButton5.setBackground(new Color(48, 48, 48));
		jButton5.setActionCommand(ControlCommands.SHOW_ADDPRODUCT.name());
		jButton5.addActionListener(control);
		imageIcon = new ImageIcon(getClass().getResource("/images/ajuste.png"));
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(70, 70, Image.SCALE_AREA_AVERAGING));
		jButton5.setIcon(icon);
		jPanelTools.add(jButton5);
		


	}

	private void panelPhoto() {

		jLabelName = new JLabel("DANIEL FELIPE GARCIA LOPEZ");
		jLabelName.setFont(new Font("Arian", 1, 30));
		jPanelSouth2.add(jLabelName);
		jPanelPhoto.setLayout(new BorderLayout());
		jPanelPhoto.add(jPanelNorth2, BorderLayout.NORTH);
		jPanelPhoto.add(jPanelSouth2, BorderLayout.SOUTH);
		jPanelPhoto.add(jPanelMainImage, BorderLayout.CENTER);

	}

	public void changeData(User user) {
		System.out.println(user.toString());
		jLabelName.setText(user.getFirstName() + " " + user.getLastName());
		this.repaint();
	}

	public JButton createJbuton(String name, int x, int y, JButton atribute, String url, String commands,
			UserController control) {
		atribute = new JButton(HandlerLanguage.languageProperties.getProperty(name));
		atribute.setForeground(new Color(244, 244, 244));
		atribute.setBackground(new Color(48, 48, 48));
		atribute.setActionCommand(commands);
		atribute.addActionListener(control);
		imageIcon = new ImageIcon(getClass().getResource(url));
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(70, 70, Image.SCALE_AREA_AVERAGING));
		atribute.setIcon(icon);
		return atribute;

	}

	private void init() {

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
		imageIcon = new ImageIcon(getClass().getResource("/images/fondoLogin.jpg"));
		g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paintComponent(g);
	}

	public void changeLanguage() {
		jButton.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_SUMMARY));
		jButton2.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_CREATEAUCTIONS));
		jButton3.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_PROFILE));
		jButton5.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_CONFIGURATION));




	}

}
