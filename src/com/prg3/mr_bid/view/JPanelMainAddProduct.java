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
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class JPanelMainAddProduct extends JPanel {

	private JPanel jPanelNorth, jPanelSouth, jPanelWest, jPanelEast, jPanelCenter, jPanelCard1, jPanelCard2,
			jPanelCard3, jPanelCard4, jPanelCard5;
	private JLabel jLabel;
	private ImageIcon imageIcon;
	private Icon icon;
	private JLabel jLabelName;
	private JTextField jTextFieldName;
	private JDateChooser jCalendar, jCalendar2, jCalendar3;

	public JPanelMainAddProduct() {
		this.jPanelNorth = new JPanel();
		this.jPanelSouth = new JPanel();
		this.jPanelWest = new JPanel();
		this.jPanelEast = new JPanel();
		this.jPanelCenter = new JPanel();

		this.jLabel = new JLabel();
		character();
		sizePanel();
		Card1();
		Card2();
		Card3();
		Card4();
		Card5();

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

	private void Card1() {
		this.jPanelCard1 = new JPanel();
		JButton jButton = new JButton("Agregar imagen");
		JTextArea jTextArea = new JTextArea();
		jTextArea.setBounds(600, 60, 500, 200);
		jButton.setBounds(200, 180, 200, 30);
		jPanelCard1.setLayout(null);
		jPanelCard1.setBackground(Color.LIGHT_GRAY);

		jPanelCard1.add(createLabel("DATOS DEL PRODUCTO", 10, 10, 200, 30));
		jPanelCard1.add(createLabel("DESCRIPCION", 600, 10, 200, 30));

		jPanelCard1.add(createLabel("TIPO DE LA PUBLICACIONs", 20, 60, 200, 30));
		jPanelCard1.add(createTextField("TIPO DE LA PUBLICACIONs", 200, 60, 200, 30));
		jPanelCard1.add(createLabel("TIPO DE PRODUCTO", 20, 120, 200, 30));
		jPanelCard1.add(createTextField("TIPO DE  PRODUCTO", 200, 120, 200, 30));
		jPanelCard1.add(createLabel("Agregar Imagen", 20, 180, 200, 30));
		jPanelCard1.add(jButton);
		jPanelCard1.add(jTextArea);

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
		// jPanelCard2.add(createTextField("FECHA DE INICIO", 200, 120, 200, 30));
		jPanelCard2.add(createLabel("FECHA DE CIERRE", 20, 180, 200, 30));
		// jPanelCard2.add(createTextField("FECHA DE CIERRE", 200, 180, 200, 30));

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
		jPanelCard2.add(createTextField("HORA DE LA PUBLICACION", 790, 60, 200, 30));
		jPanelCard2.add(createLabel("HORA DE INICIO", 600, 120, 200, 30));
		jPanelCard2.add(createTextField("HORA DE INICIO", 790, 120, 200, 30));
		jPanelCard2.add(createLabel("HORA DE CIERRE", 600, 180, 200, 30));
		jPanelCard2.add(createTextField("HORA DE CIERRE", 790, 180, 200, 30));

	}

	private void Card3() {
		this.jPanelCard3 = new JPanel();
		jPanelCard3.setBackground(Color.red);

	}

	private void Card4() {
		this.jPanelCard4 = new JPanel();
		jPanelCard4.setBackground(Color.blue);

	}

	private void Card5() {
		this.jPanelCard5 = new JPanel();
		jPanelCard5.setBackground(Color.ORANGE);

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

}
