package com.prg3.mr_bid.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;



public class JPanelOptionMenu extends JPanel {

	private JPanel jPanelWhite;
	private JMenu jMenu, jMenu2, jMenu3, jMenu4, jMenu5;
	private JButton jButtonEnglish, jButtonSpanish, jButtonLogin;
	private JMenuItem jMenuItemHome, jMenuItemEstadisticas, jMenuItemPlantLibrary, jMenuItemAportesHis,
			jMenuItemCreateBotanic, jMenuItemJtableInstitucion, jMenuItemMobile, jMenuItemDeleteBotanic;
	private JMenuBar jMenuBar;
	ImageIcon imageIcon;
	Icon icon;

	public JPanelOptionMenu() {
		init();
		this.repaint();
	}

	private void init() {
		// this.setLayout(new GridLayout(1, 7));
		this.setLayout(new BorderLayout());
		this.setBackground(new Color(48, 48, 48));
		this.setPreferredSize(new Dimension(0, 100));
		// setOpaque(false);

		jPanelWhite = new JPanel();
		jPanelWhite.setLayout(new GridLayout(1, 3));
		jPanelWhite.setPreferredSize(new Dimension(400, 100));

		jButtonEnglish = new JButton();
		jButtonEnglish.setBackground(new Color(48, 48, 48));
		// jButtonEnglish.setActionCommand(Commands.C_ENGLISH.name());
		// jButtonEnglish.addActionListener(control);
		imageIcon = new ImageIcon("data/images/carro.png");
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(70, 70, Image.SCALE_AREA_AVERAGING));
		jButtonEnglish.setIcon(icon);

		jButtonSpanish = new JButton();
		jButtonSpanish.setBackground(new Color(48, 48, 48));
		// jButtonSpanish.setActionCommand(Commands.C_SPANISH.name());
		// jButtonSpanish.addActionListener(control);
		imageIcon = new ImageIcon("data/images/notificacion.png");
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(70, 70, Image.SCALE_AREA_AVERAGING));
		jButtonSpanish.setIcon(icon);

		jButtonLogin = new JButton();
		// jButtonLogin.setActionCommand(Commands.SHOW_LOGIN.name());
		// jButtonLogin.addActionListener(control);
		jButtonLogin.setBackground(new Color(48, 48, 48));
		imageIcon = new ImageIcon("data/images/usuario.png");
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(70, 70, Image.SCALE_AREA_AVERAGING));
		jButtonLogin.setIcon(icon);

		jPanelWhite.add(jButtonEnglish);
		jPanelWhite.add(jButtonSpanish);
		jPanelWhite.add(jButtonLogin);

		jMenuBar = new JMenuBar();
		jMenuBar.setLayout(new FlowLayout());
		jMenuBar.setOpaque(false);

		jMenuItemHome = new JMenuItem("HOME");
		// jMenuItemHome.setActionCommand(Commands.SHOW_HOME.name());
		jMenuItemHome.setPreferredSize(new Dimension(100, 100));
		jMenuItemHome.setFont(new Font("Arial", 1, 15));
		jMenuItemHome.setOpaque(false);
		jMenuItemHome.setForeground(Color.WHITE);
		// jMenuItemHome.addActionListener(control);
		jMenuBar.add(jMenuItemHome);

		jMenu2 = new JMenu("OPTION");
		jMenu2.setFont(new Font("Arial", 1, 15));
		jMenu2.setBackground(Color.BLACK);
		jMenu2.setForeground(Color.WHITE);
		jMenuBar.add(jMenu2);

		jMenu3 = new JMenu("OPTION");
		jMenu3.setFont(new Font("Arial", 1, 15));
		jMenu3.setBackground(Color.BLACK);
		jMenu3.setForeground(Color.WHITE);
		jMenuBar.add(jMenu3);

		jMenu4 = new JMenu("OPTION");
		jMenu4.setFont(new Font("Arial", 1, 15));
		jMenu4.setBackground(Color.BLACK);
		jMenu4.setForeground(Color.WHITE);
		jMenuBar.add(jMenu4);

		jMenu5 = new JMenu("OPTION");
		jMenu5.setFont(new Font("Arial", 1, 15));
		jMenu5.setBackground(Color.BLACK);
		jMenu5.setForeground(Color.WHITE);
		jMenuBar.add(jMenu5);

		jMenuItemPlantLibrary = new JMenuItem("OPTION");
//		jMenuItemPlantLibrary.setActionCommand(Commands.SHOW_PLANTLIBRARY.name());
//		jMenuItemPlantLibrary.addActionListener(control);
		jMenu2.add(jMenuItemPlantLibrary);

		jMenuItemJtableInstitucion = new JMenuItem("OPTION");
//		jMenuItemJtableInstitucion.setActionCommand(Commands.SHOW_TABLE_INSTITUCION.name());
//		jMenuItemJtableInstitucion.addActionListener(control);
		jMenu2.add(jMenuItemJtableInstitucion);

		jMenuItemEstadisticas = new JMenuItem("OPTION");
//		jMenuItemEstadisticas.setActionCommand(Commands.SHOW_ESTADISTIC.name());
//		jMenuItemEstadisticas.addActionListener(control);
		jMenu4.add(jMenuItemEstadisticas);

		jMenuItemAportesHis = new JMenuItem("OPTION");
//		jMenuItemAportesHis.setActionCommand(Commands.SHOW_HISTORICALCONTRIBUTIONS.name());
//		jMenuItemAportesHis.addActionListener(control);
		jMenu3.add(jMenuItemAportesHis);

		jMenuItemDeleteBotanic = new JMenuItem("OPTION");
//		jMenuItemDeleteBotanic.setActionCommand(Commands.DELETE_BOTANIC.name());
//		jMenuItemDeleteBotanic.addActionListener(control);
		jMenu5.add(jMenuItemDeleteBotanic);

		jMenuItemCreateBotanic = new JMenuItem("OPTION");
//		jMenuItemCreateBotanic.setActionCommand(Commands.SHOW_CREATEBOTANICO.name());
//		jMenuItemCreateBotanic.addActionListener(control);
		jMenu5.add(jMenuItemCreateBotanic);

		jMenuItemMobile = new JMenuItem("APP MOBILE");
//		jMenuItemMobile.setActionCommand(Commands.SHOW_MOBILE.name());
//		jMenuItemMobile.addActionListener(control);
		jMenu5.add(jMenuItemMobile);

		this.add(jMenuBar, BorderLayout.CENTER);
		this.add(jPanelWhite, BorderLayout.EAST);

	}



}
