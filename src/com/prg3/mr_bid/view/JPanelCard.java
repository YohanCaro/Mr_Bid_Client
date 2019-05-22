package com.prg3.mr_bid.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelCard extends JPanel {

	private JPanel jPanelNorth, jPanelSouth, jPanelWest, jPanelEast, jPanelCenter, jPanelCenterEast, jPanelCenterWest,
			jpanelImageProduct;
	private JLabel jLabel;
	private ImageIcon imageIcon;
	private Icon icon;

	public JPanelCard() {
		this.jPanelNorth = new JPanel();
		this.jPanelSouth = new JPanel();
		this.jPanelWest = new JPanel();
		this.jPanelEast = new JPanel();
		this.jPanelCenter = new JPanel();
		this.jPanelCenterWest = new JPanel();
		this.jPanelCenterEast = new JPanel();
		this.jpanelImageProduct = new JPanel();
		this.jLabel = new JLabel();

		character();
		sizePanel();
		JpanelImageProduct();
		init();
	}

	private void character() {
		jPanelNorth.setBackground(Color.WHITE);
		jPanelSouth.setBackground(Color.WHITE);
		jPanelWest.setBackground(Color.WHITE);
		jPanelEast.setBackground(Color.WHITE);
		jPanelCenter.setBackground(Color.BLACK);
		jPanelCenterWest.setBackground(Color.GRAY);
		jPanelCenterEast.setBackground(Color.GREEN);

	}

	private void JpanelImageProduct() {
		imageIcon = new ImageIcon("data/images/product.jpg");
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(250	, 250, Image.SCALE_AREA_AVERAGING));
		jLabel.setIcon(icon);
		jpanelImageProduct.add(jLabel);
	}

	private void sizePanel() {
		jPanelCenterWest.setPreferredSize(new Dimension(500, 0));
		jPanelCenterEast.setPreferredSize(new Dimension(700, 0));


	}

	private void init() {
		this.setLayout(new BorderLayout());
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setPreferredSize(new Dimension(1200, 250));
		


		jPanelCenter.setLayout(new BorderLayout());
		jPanelCenter.add(jpanelImageProduct, BorderLayout.CENTER);
		jPanelCenter.add(jPanelCenterEast, BorderLayout.EAST);
		
		

		this.add(jPanelNorth, BorderLayout.NORTH);
		this.add(jPanelSouth, BorderLayout.SOUTH);
		this.add(jPanelWest, BorderLayout.WEST);
		this.add(jPanelEast, BorderLayout.EAST);
		this.add(jPanelCenter, BorderLayout.CENTER);
		
	}

}
