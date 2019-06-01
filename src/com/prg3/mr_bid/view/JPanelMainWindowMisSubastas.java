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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JPanelMainWindowMisSubastas extends JPanel {

	private JPanel jPanelNorth, jPanelNorth2, jPanelSouth, jPanelSouth2, jPanelWest, jPanelEast, jPanelCenter,
			jPanelMainImage, jPanelTools, jPanelPhoto;
	private JPanelOptionMenu jPanelOptionMenu;
	private JLabel jLabel, jLabelMisSubastas, jLabelParticipaciones;
	private ImageIcon imageIcon;
	private Icon icon;
	private JLabel jLabelName;
	private JButton jButton, jButton2, jButton3, jButton4, jButton5;
	private JTextArea jTextAreaMyBid, jTextAreaParticiped;
	private JScrollPane jScrollPane, jScrollPane2;

	public JPanelMainWindowMisSubastas() {
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
		panelPhoto();
		myjButton();
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

		// jPanelCenter.setBackground(Color.WHITE);
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

		jPanelMainImage.setPreferredSize(new Dimension(0, 100));
		jPanelTools.setPreferredSize(new Dimension(300, 0));
		jPanelPhoto.setPreferredSize(new Dimension(550, 0));
		jPanelNorth2.setPreferredSize(new Dimension(100, 100));

	}

	private void myjButton() {
		createLabel("MIS PARTICIPACIONES", 50, 20, jLabelParticipaciones, jPanelTools);
		jPanelTools.setLayout(null);
		jPanelTools.setBackground(new Color(0, 0, 0, 94));
		jPanelTools.setPreferredSize(new Dimension(300, 300));
		jTextAreaParticiped = new JTextArea("MIS PARTICIPACIONES");
		jTextAreaParticiped.setEditable(false);
		jTextAreaParticiped.setBounds(50, 60, 450, 300);
		jPanelTools.add(jTextAreaParticiped);
		;

	}

	private void panelPhoto() {
		createLabel("MIS SUBASTAS", 50, 20, jLabelMisSubastas, jPanelPhoto);
		jPanelPhoto.setBackground(Color.red);
		jPanelPhoto.setLayout(null);
		jPanelPhoto.setBackground(new Color(0, 0, 0, 94));
		jTextAreaMyBid = new JTextArea("MIS SUBASTAS");
		jTextAreaMyBid.setEditable(false);
		jTextAreaMyBid.setBounds(50, 60, 450, 300);
		jPanelPhoto.add(jTextAreaMyBid);

	}

	public JButton createJbuton(String name, int x, int y, JButton atribute, String url) {
		atribute = new JButton(name);
		atribute.setForeground(new Color(244, 244, 244));
		atribute.setBackground(new Color(48, 48, 48));
		// atribute.setActionCommand(Commands.C_ENGLISH.name());
		// atribute.addActionListener(control);
		imageIcon = new ImageIcon(getClass().getResource(url));
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(70, 70, Image.SCALE_AREA_AVERAGING));
		atribute.setIcon(icon);
		return atribute;

	}

	private void init() {

		this.setLayout(new BorderLayout());
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		jPanelCenter.setLayout(new BorderLayout());
		jPanelCenter.setOpaque(false);
		jPanelCenter.add(jPanelTools, BorderLayout.CENTER);
		jPanelCenter.add(jPanelPhoto, BorderLayout.WEST);

		this.add(jPanelNorth, BorderLayout.NORTH);
		this.add(jPanelSouth, BorderLayout.SOUTH);
		this.add(jPanelWest, BorderLayout.WEST);
		this.add(jPanelEast, BorderLayout.EAST);
		this.add(jPanelCenter, BorderLayout.CENTER);

	}

	public JLabel createLabel(String name, int x, int y, JLabel jLabel, JPanel jPanel) {
		jLabel = new JLabel(name);
		jLabel.setBounds(x, y, 200, 50);
		jLabel.setBackground(new Color(244, 244, 244));
		jLabel.setPreferredSize(new Dimension(200, 60));
		jPanel.add(jLabel);
		return jLabel;

	}

	@Override
	protected void paintComponent(Graphics g) {
		imageIcon = new ImageIcon(getClass().getResource("/images/fondoLogin.jpg"));
		g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paintComponent(g);
	}

}
