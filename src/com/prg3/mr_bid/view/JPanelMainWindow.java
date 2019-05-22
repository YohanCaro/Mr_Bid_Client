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

public class JPanelMainWindow extends JPanel {

	private JPanel jPanelNorth, jPanelSouth, jPanelWest, jPanelEast, jPanelCenter, jPanelMainImage,
			jPanelEspacio;
	private JPanelCard jPanelMainWindowProduct;
	private JPanelOptionMenu jPanelOptionMenu;
	private JLabel jLabel;
	private ImageIcon imageIcon;
	private Icon icon;


	public JPanelMainWindow() {
		this.jPanelMainWindowProduct = new JPanelCard();
		this.jPanelNorth = new JPanel();
		this.jPanelSouth = new JPanel();
		this.jPanelWest = new JPanel();
		this.jPanelEast = new JPanel();
		this.jPanelCenter = new JPanel();
		this.jPanelMainImage = new JPanel();
		this.jPanelEspacio = new JPanel();
		this.jPanelOptionMenu = new JPanelOptionMenu();
	

		this.jLabel = new JLabel();
		character();
		sizePanel();
		JpanelImage();
		init();
	}

	private void character() {
		jPanelNorth.setBackground(Color.RED);
		jPanelSouth.setBackground(Color.GREEN);
//		jPanelWest.setBackground(Color.YELLOW);
//		jPanelEast.setBackground(Color.BLUE);
		jPanelCenter.setBackground(Color.black);
//		jPanelMainImage.setBackground(Color.cyan);
		jPanelEspacio.setBackground(Color.ORANGE);

	}

	private void JpanelImage() {
		imageIcon = new ImageIcon("data/images/publicidad1.png");
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(1150, 300, Image.SCALE_AREA_AVERAGING));
		jLabel.setIcon(icon);
		jPanelMainImage.add(jLabel);
	}

	private void sizePanel() {

		jPanelWest.setPreferredSize(new Dimension(100, 0));
		jPanelEast.setPreferredSize(new Dimension(100, 0));
		jPanelNorth.setPreferredSize(new Dimension(0, 100));
		jPanelMainImage.setPreferredSize(new Dimension(0, 300));
		jPanelCenter.setPreferredSize(new Dimension(0, 3000));// tamaño del panel central
		jPanelMainWindowProduct.setPreferredSize(new Dimension(0, 500));

	}

	private void init() {

		this.setLayout(new BorderLayout());
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		jPanelCenter.setLayout(new BorderLayout());
		jPanelCenter.add(jPanelMainImage, BorderLayout.NORTH);
		jPanelCenter.add(jPanelEspacio, BorderLayout.CENTER);

		jPanelEspacio.setLayout(new GridLayout(10, 1));
		jPanelEspacio.add(new JPanelCard());
		jPanelEspacio.add(new JPanelCard());
		jPanelEspacio.add(new JPanelCard());
		jPanelEspacio.add(new JPanelCard());
		jPanelEspacio.add(new JPanelCard());

		this.add(jPanelOptionMenu, BorderLayout.NORTH);
		this.add(jPanelSouth, BorderLayout.SOUTH);
		this.add(jPanelWest, BorderLayout.WEST);
		this.add(jPanelEast, BorderLayout.EAST);
		this.add(jPanelCenter, BorderLayout.CENTER);

	}

}
