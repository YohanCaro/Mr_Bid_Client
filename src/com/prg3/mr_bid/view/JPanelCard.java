package com.prg3.mr_bid.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.prg3.mr_bid.controller.ControlCommands;
import com.prg3.mr_bid.controller.UserController;
import com.prg3.mr_bid.model.entity.Bidding;
import com.prg3.mr_bid.model.entity.ConstantsBid;
import com.prg3.mr_bid.utilities.HandlerLanguage;
import com.prg3.mr_bid.utilities.Utilities;


public class JPanelCard extends JPanel {

	private JPanel jPanelNorth, jPanelSouth, jPanelWest, jPanelEast, jPanelCenter, jPanelCenterEast, jPanelCenterWest,
			jpanelImageProduct, jPanelNameProduct, jPanelInfoProduct;
	private JLabel jLabel, jLabelName, jLabelType, jLabelSatus, jLabelTime, jLabelType2, jLabelSatus2, jLabelTime2;
	private ImageIcon imageIcon;
	private Icon icon;
	private JButton jButton;
	private String product;

	public JPanelCard() {

	}

	public JPanelCard(String name, String type, String staut, String time, String url, UserController controller) {
		this.jPanelNorth = new JPanel();
		this.jPanelSouth = new JPanel();
		this.jPanelWest = new JPanel();
		this.jPanelEast = new JPanel();
		this.jPanelCenter = new JPanel();
		this.jPanelCenterWest = new JPanel();
		this.jPanelCenterEast = new JPanel();
		this.jpanelImageProduct = new JPanel();
		this.jPanelNameProduct = new JPanel();
		this.jPanelInfoProduct = new JPanel();
		this.jLabel = new JLabel();
		informacion(name, type, staut, time,controller);
		character();
		sizePanel();
		init();
		changeLanguage();
	}
	
	public JPanelCard(Bidding bid, UserController controller) {
		this.jPanelNorth = new JPanel();
		this.jPanelSouth = new JPanel();
		this.jPanelWest = new JPanel();
		this.jPanelEast = new JPanel();
		this.jPanelCenter = new JPanel();
		this.jPanelCenterWest = new JPanel();
		this.jPanelCenterEast = new JPanel();
		this.jpanelImageProduct = new JPanel();
		this.jPanelNameProduct = new JPanel();
		this.jPanelInfoProduct = new JPanel();
		this.jLabel = new JLabel();
//		informacion(name, type, staut, time,controller);
		changeData(bid, controller);
		character();
		sizePanel();
		myJButton(bid.getProduct().getImages(), bid.getId());
		init();
		this.repaint();

	}

	private void character() {
		jPanelNorth.setBackground(Color.WHITE);
		jPanelSouth.setBackground(Color.WHITE);
		jPanelWest.setBackground(Color.WHITE);
		jPanelEast.setBackground(Color.WHITE);
//		jPanelCenter.setBackground(Color.BLACK);
		jPanelCenter.setOpaque(false);
		jPanelCenterWest.setBackground(Color.GRAY);
		jPanelCenterEast.setBackground(Color.BLUE);

		jPanelNameProduct.setBackground(Color.GRAY);
		jPanelInfoProduct.setBackground(Color.LIGHT_GRAY);

	}

	private JButton myJButton(String url,long  id) {
		jButton = new JButton(String.valueOf(id));
		 
		jButton.setBounds(0, 0, 200, 200);
		jButton.setBackground(new Color(2, 41, 48));
		jButton.setForeground(new Color(255, 255, 255));// blanco
		imageIcon = new ImageIcon(url);
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(50, 50,Image.SCALE_AREA_AVERAGING));
		jButton.setIcon(icon);
		this.add(jButton);
		return jButton;
	}

	private void sizePanel() {
		jPanelCenterWest.setPreferredSize(new Dimension(500, 0));
		jPanelCenterEast.setPreferredSize(new Dimension(700, 0));
		jPanelNameProduct.setPreferredSize(new Dimension(300, 0));
		jPanelInfoProduct.setPreferredSize(new Dimension(300, 0));

	}

	private void informacion(String name, String type, String status, String time, UserController control) {
////		jPanelNameProduct.add(createLabel(name, 10, 100, jLabelName, 30, 400));
////		jPanelInfoProduct.add(createLabel("TIPO", 10, 20, jLabelType, 20, 130));
//		
//		
		jLabelType = new JLabel("JAJAJ");
		jLabelType.setFont(new Font("Arial", 1, 20));
		jLabelType.setBounds(10, 20, 130, 50);
		jLabelType.setBackground(new Color(244, 244, 244));
		jLabelType.setPreferredSize(new Dimension(200, 60));
		jPanelInfoProduct.add(jLabelType);
		
		
//		
////		jPanelInfoProduct.add(createLabel("ESTADO", 10, 70, jLabelSatus, 20, 130));
////		jPanelInfoProduct.add(createLabel("TIEMPO RESTANTE", 10, 120, jLabelTime, 20, 400));
//
//		jPanelInfoProduct.add(createLabel(type, 200, 20, jLabelType2, 20, 130));
//		jPanelInfoProduct.add(createLabel(status, 200, 70, jLabelSatus2, 20, 130));
//		jPanelInfoProduct.add(createLabel(time, 230, 120, jLabelTime2, 20, 130));
//
//		jButton = new JButton("Ingresar");
//		jButton.setBounds(150, 200, 100, 30);
//		jButton.setActionCommand(ControlCommands.SHOW_PRODUCT.name());
//		jButton.addActionListener(control);
//		jPanelInfoProduct.add(jButton);

	}
	
	public void changeData(Bidding b, UserController control) {
		jPanelNameProduct.add(createLabel(b.getBiddingName(), 10, 100, jLabelName, 30, 400));
		
		jLabelType = new JLabel(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_KIND));
		jLabelType.setFont(new Font("Arial", 1, 20));
		jLabelType.setBounds(10, 20, 130, 50);
		jLabelType.setBackground(new Color(244, 244, 244));
		jLabelType.setPreferredSize(new Dimension(200, 60));
		jPanelInfoProduct.add(jLabelType);
	
		
//		jPanelInfoProduct.add(createLabel(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_ENGLISH), 10, 20, jLabelType, 20, 130));
		jPanelInfoProduct.add(createLabel("ESTADO", 10, 70, jLabelSatus, 20, 130));
		jPanelInfoProduct.add(createLabel("TIEMPO RESTANTE", 10, 120, jLabelTime, 20, 400));
		
		jPanelInfoProduct.add(createLabel(b.getTypeProduct().name(), 200, 20, jLabelType2, 20, 130));
		jPanelInfoProduct.add(createLabel(Utilities.getState(b).toString(), 200, 70, jLabelSatus2, 20, 130));
		jPanelInfoProduct.add(createLabel(Utilities.getTimeRemaining(b), 230, 120, jLabelTime2, 20, 130));
		
		jButton = new JButton("Ingresar");
		jButton.setBounds(150, 200, 100, 30);
		jButton.setActionCommand(ControlCommands.SHOW_PRODUCT.name() + "," + b.getId());
		jButton.addActionListener(control);
		jPanelInfoProduct.add(jButton);
	}

	private void init() {
		this.setLayout(new BorderLayout());
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setPreferredSize(new Dimension(1200, 250));

		jPanelInfoProduct.setLayout(null);
		jPanelNameProduct.setLayout(null);

		jPanelCenterEast.setLayout(new BorderLayout());
		jPanelCenterEast.add(jPanelNameProduct, BorderLayout.WEST);
		jPanelCenterEast.add(jPanelInfoProduct, BorderLayout.CENTER);

		jPanelCenter.setLayout(new BorderLayout());
		jPanelCenter.add(jpanelImageProduct, BorderLayout.CENTER);
		jPanelCenter.add(jPanelCenterEast, BorderLayout.EAST);

		this.add(jPanelNorth, BorderLayout.NORTH);
		this.add(jPanelSouth, BorderLayout.SOUTH);
		this.add(jPanelWest, BorderLayout.WEST);
		this.add(jPanelEast, BorderLayout.EAST);
		this.add(jPanelCenter, BorderLayout.CENTER);

	}

	public JLabel createLabel(String name, int x, int y, JLabel jLabel, int size, int sizeCamp) {
		jLabel = new JLabel(name);
		jLabel.setFont(new Font("Arial", 1, size));
		jLabel.setBounds(x, y, sizeCamp, 50);
		jLabel.setBackground(new Color(244, 244, 244));
		jLabel.setPreferredSize(new Dimension(200, 60));
		add(jLabel);
		return jLabel;
	}
	
	/**
	 * Cambia 
	 * @param product the product to set
	 */
	public void setProduct(String product) {
		this.product = product;
	}
	
	public void changeLanguage() {
//		jLabelType.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_MENU_HOME));

	}


}
