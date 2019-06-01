package com.prg3.mr_bid.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.prg3.mr_bid.controller.UserController;

public class JPanelMainWindow extends JPanel {

	private JPanel jPanelNorth, jPanelSouth, jPanelWest, jPanelEast, jPanelCenter, jPanelMainImage, jPanelEspacio;
	private JPanelCard jPanelMainWindowProduct;
	private JLabel jLabel;
	private ImageIcon imageIcon;
	private JScrollPane jScrollPane;
	private String names;
	private Icon icon;

	public JPanelMainWindow(UserController controller) {
		this.jPanelMainWindowProduct = new JPanelCard();
		this.jPanelNorth = new JPanel();
		this.jPanelSouth = new JPanel();
		this.jPanelWest = new JPanel();
		this.jPanelEast = new JPanel();
		this.jPanelCenter = new JPanel();
		this.jPanelMainImage = new JPanel();
		this.jPanelEspacio = new JPanel();
		this.jScrollPane = new JScrollPane();
		this.jLabel = new JLabel();
		// addNewProduct(name, type, staut, time, url);
		character();
		sizePanel();
		JpanelImage();
		init(controller);

	}
	
	



	public JPanelMainWindow(String name, String type, String staut, String time, String url, UserController control) {
		addNewProduct(name, type, staut, time, url, control);
		
		names = name;
		System.out.println(names);
//		System.out.println(name+ type+ staut+ time+ url);

	}
	
	public String getNames() {
		return names;
	}

	private void character() {
		jPanelNorth.setBackground(Color.RED);
		jPanelSouth.setBackground(Color.GREEN);
		// jPanelWest.setBackground(Color.YELLOW);
		// jPanelEast.setBackground(Color.BLUE);
		jPanelCenter.setBackground(Color.black);
		// jPanelMainImage.setBackground(Color.cyan);
		jPanelEspacio.setBackground(Color.ORANGE);

	}

	private void JpanelImage() {
		imageIcon = new ImageIcon(getClass().getResource("/images/publicidad1.png"));
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(1150, 300, Image.SCALE_AREA_AVERAGING));
		jLabel.setIcon(icon);
		jPanelMainImage.add(jLabel);
	}

	private void sizePanel() {

		jPanelWest.setPreferredSize(new Dimension(100, 0));
		jPanelEast.setPreferredSize(new Dimension(100, 0));
		jPanelNorth.setPreferredSize(new Dimension(0, 100));
		jPanelMainImage.setPreferredSize(new Dimension(0, 300));
		jPanelCenter.setPreferredSize(new Dimension(0, 1000));// tamaño del panel central
		jPanelMainWindowProduct.setPreferredSize(new Dimension(0, 500));

	}

	public JPanelCard addNewProduct(String name, String type, String staut, String time, String url, UserController control) {
		return jPanelMainWindowProduct = new JPanelCard(name, type, staut, time, url,control);
	}

	private void init(UserController control) {

		this.setLayout(new BorderLayout());
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());

		jPanelCenter.setLayout(new BorderLayout());
		jScrollPane.setViewportView(jPanelEspacio);

		jPanelCenter.add(jPanelMainImage, BorderLayout.NORTH);
		jPanelCenter.add(jScrollPane, BorderLayout.CENTER);

		
		jPanelEspacio.setLayout(new GridLayout(0, 1));
		
//		jPanelEspacio.add(addNewProduct(this.getNames(), "Publico", "No inicida",
//				 "7;80", "/images/lg.jpg"));
		 jPanelEspacio.add(new JPanelCard("Computador LG", "Publico", "No inicida",
		 "7;80", "/images/lg.jpg", control));
		 jPanelEspacio.add(new JPanelCard("Iphone X", "Publico", " Inicida", "8;80",
		 "/images/iphone.png",control));
		 jPanelEspacio.add(new JPanelCard("Computador LG", "Publico", "No inicida",
		 "7;80", "/images/lg.jpg",control));
//		 jPanelEspacio.add(new JPanelCard("Iphone X", "Publico", " Inicida", "8;80",
//		 "/images/iphone.png"));
//		 jPanelEspacio.add(new JPanelCard("Computador LG", "Publico", "No inicida",
//		 "7;80", "/images/lg.jpg"));
//		 jPanelEspacio.add(new JPanelCard("Iphone X", "Publico", " Inicida", "8;80",
//		 "/images/iphone.png"));
//		 jPanelEspacio.add(new JPanelCard("Computador LG", "Publico", "No inicida",
//		 "7;80", "/images/lg.jpg"));
//		 jPanelEspacio.add(new JPanelCard("Iphone X", "Publico", " Inicida", "8;80",
//		 "/images/iphone.png"));

		this.add(jPanelSouth, BorderLayout.SOUTH);
		this.add(jPanelWest, BorderLayout.WEST);
		this.add(jPanelEast, BorderLayout.EAST);
		this.add(jPanelCenter, BorderLayout.CENTER);

	}

}
