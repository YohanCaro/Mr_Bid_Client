package com.pgr3.mr_bid.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JPanelMainProduct extends JPanel {

	private JPanel jPanelSouth, jPanelWest, jPanelEast, jPanelCenter, jPanelDere, jPanelizq, jPanelizqImage,
			jPanelizqInfo, jPanelderNorth, jPanelderCenter, jPanelCard, jPanelCardnorth, jPanelCardSouth,
			jPanelCardWest, jPanelCardEast, jPanelCard2, jPanelCardnorth2, jPanelCardSouth2, jPanelCardWest2,
			jPanelCardEast2;
	private JPanelOptionMenu jPanelOptionMenu;
	private JTextArea jTextArea;
	private JLabel jLabel;
	private ImageIcon imageIcon;
	private Icon icon;

	public JPanelMainProduct() {
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

		this.jPanelOptionMenu = new JPanelOptionMenu();
		this.jTextArea = new JTextArea();
		this.jLabel = new JLabel();
		card();
		jtextArea();
		character();
		sizePanel();
		card2();

		JpanelImage();
		init();
	}

	private void character() {
		jPanelSouth.setBackground(Color.GREEN);
		jPanelCenter.setBackground(Color.black);
		jPanelDere.setBackground(Color.YELLOW);
		jPanelizq.setBackground(Color.BLUE);
		jPanelizqInfo.setBackground(Color.GREEN);
		jPanelderNorth.setBackground(Color.BLUE);
		jPanelderCenter.setBackground(Color.ORANGE);

	}

	private void JpanelImage() {
		imageIcon = new ImageIcon(getClass().getResource("/images/tv.jpg"));
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(350, 350, Image.SCALE_AREA_AVERAGING));
		jLabel.setIcon(icon);
		jPanelizqImage.add(jLabel);
	}

	private void jtextArea() {

		jTextArea.setText("Descrpcion");
		jTextArea.setPreferredSize(new Dimension(400, 300));
		jPanelizqInfo.add(jTextArea);
	}

	private void card() {
		JLabel jLabel, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9, foto;
		JTextField name, correo, password;

		jPanelCard.setLayout(null);
		this.setBackground(Color.white);

		jLabel = new JLabel("ESTADO");
		jLabel.setBounds(20, 10, 300, 25);
		jLabel.setFont(new Font("Andale Mono", 3, 15));
		jLabel.setForeground(Color.WHITE);
		jLabel.setBackground(Color.BLUE);
		jPanelCard.add(jLabel);

		name = new JTextField("");
		name.setBounds(20, 40, 320, 25);
		name.setBackground(new java.awt.Color(224, 224, 224));
		name.setFont(new java.awt.Font("Andale Mono", 1, 14));
		name.setForeground(new java.awt.Color(255, 0, 0));
		jPanelCard.add(name);

		jLabel2 = new JLabel("TIEMPO");
		jLabel2.setBounds(20, 85, 200, 25);
		jLabel2.setFont(new Font("Andale Mono", 3, 15));
		jLabel2.setForeground(Color.WHITE);
		jLabel2.setBackground(Color.BLUE);
		jPanelCard.add(jLabel2);

		correo = new JTextField();
		correo.setBounds(20, 115, 320, 25);
		correo.setBackground(new java.awt.Color(224, 224, 224));
		correo.setFont(new java.awt.Font("Andale Mono", 1, 14));
		correo.setForeground(new java.awt.Color(255, 0, 0));
		jPanelCard.add(correo);

		jLabel3 = new JLabel("FINALIZA");
		jLabel3.setBounds(20, 150, 200, 25);
		jLabel3.setFont(new Font("Andale Mono", 3, 15));
		jLabel3.setForeground(Color.WHITE);
		jLabel3.setBackground(Color.BLUE);
		jPanelCard.add(jLabel3);

		password = new JTextField();
		password.setBounds(20, 175, 320, 25);
		password.setBackground(new java.awt.Color(224, 224, 224));
		password.setFont(new java.awt.Font("Andale Mono", 1, 14));
		password.setForeground(new java.awt.Color(255, 0, 0));
		jPanelCard.add(password);
		this.jPanelCardnorth = new JPanel();
		this.jPanelCardSouth = new JPanel();
		this.jPanelCardWest = new JPanel();
		this.jPanelCardEast = new JPanel();

		jPanelCard.setBackground(Color.GRAY);
		jPanelderNorth.setLayout(new BorderLayout());

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

	private void card2() {
		JLabel jLabel, jLabel2;
		JTextField name, correo;
		JButton jButton;

		jPanelCard2.setLayout(null);
		this.setBackground(Color.white);

		jLabel = new JLabel("VALOR ACTUAL");
		jLabel.setBounds(20, 10, 300, 25);
		jLabel.setFont(new Font("Andale Mono", 3, 15));
		jLabel.setForeground(Color.WHITE);
		jLabel.setBackground(Color.BLUE);
		jPanelCard2.add(jLabel);

		name = new JTextField("");
		name.setBounds(20, 40, 320, 25);
		name.setBackground(new java.awt.Color(224, 224, 224));
		name.setFont(new java.awt.Font("Andale Mono", 1, 14));
		name.setForeground(new java.awt.Color(255, 0, 0));
		jPanelCard2.add(name);

		jLabel2 = new JLabel("VALOR DE LA PUJA");
		jLabel2.setBounds(20, 85, 200, 25);
		jLabel2.setFont(new Font("Andale Mono", 3, 15));
		jLabel2.setForeground(Color.WHITE);
		jLabel2.setBackground(Color.BLUE);
		jPanelCard2.add(jLabel2);

		correo = new JTextField();
		correo.setBounds(20, 115, 320, 25);
		correo.setBackground(new java.awt.Color(224, 224, 224));
		correo.setFont(new java.awt.Font("Andale Mono", 1, 14));
		correo.setForeground(new java.awt.Color(255, 0, 0));
		jPanelCard2.add(correo);

		jButton = new JButton("Pujar");
		jButton.setBounds(20, 150, 320, 50);
		jPanelCard2.add(jButton);

		this.jPanelCardnorth2 = new JPanel();
		this.jPanelCardSouth2 = new JPanel();
		this.jPanelCardWest2 = new JPanel();
		this.jPanelCardEast2 = new JPanel();

		jPanelCard2.setBackground(Color.RED);
		jPanelCard2.setPreferredSize(new Dimension(500, 100));
		jPanelderCenter.setLayout(new BorderLayout());

		jPanelCardnorth2.setPreferredSize(new Dimension(50, 50));
		jPanelCardSouth2.setPreferredSize(new Dimension(50, 300));
		jPanelCardWest2.setPreferredSize(new Dimension(50, 50));
		jPanelCardEast2.setPreferredSize(new Dimension(50, 50));

		jPanelderCenter.add(jPanelCard2, BorderLayout.CENTER);
		jPanelderCenter.add(jPanelCardnorth2, BorderLayout.NORTH);
		jPanelderCenter.add(jPanelCardSouth2, BorderLayout.SOUTH);
		jPanelderCenter.add(jPanelCardWest2, BorderLayout.WEST);
		jPanelderCenter.add(jPanelCardEast2, BorderLayout.EAST);

	}

	private void sizePanel() {

		jPanelWest.setPreferredSize(new Dimension(100, 0));
		jPanelEast.setPreferredSize(new Dimension(100, 0));
		jPanelizq.setPreferredSize(new Dimension(500, 0));
		jPanelDere.setPreferredSize(new Dimension(100, 0));
		jPanelizqImage.setPreferredSize(new Dimension(100, 400));
		jPanelderNorth.setPreferredSize(new Dimension(100, 400));

		jPanelCenter.setPreferredSize(new Dimension(100, 1000));

	}

	private void init() {

		this.setLayout(new BorderLayout());
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());

		jPanelDere.setLayout(new BorderLayout());
		jPanelDere.add(jPanelderNorth, BorderLayout.NORTH);
		jPanelDere.add(jPanelderCenter, BorderLayout.CENTER);

		jPanelizq.setLayout(new BorderLayout());
		jPanelizq.add(jPanelizqImage, BorderLayout.NORTH);
		jPanelizq.add(jPanelizqInfo, BorderLayout.CENTER);

		jPanelCenter.setLayout(new BorderLayout());
		jPanelCenter.add(jPanelDere, BorderLayout.CENTER);
		jPanelCenter.add(jPanelizq, BorderLayout.WEST);

		this.add(jPanelOptionMenu, BorderLayout.NORTH);
		this.add(jPanelSouth, BorderLayout.SOUTH);
		this.add(jPanelWest, BorderLayout.WEST);
		this.add(jPanelEast, BorderLayout.EAST);
		this.add(jPanelCenter, BorderLayout.CENTER);

	}

}
