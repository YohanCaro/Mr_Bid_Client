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

import com.prg3.mr_bid.controller.ControlCommands;
import com.prg3.mr_bid.controller.UserController;
import com.prg3.mr_bid.model.entity.ConstantsBid;
import com.prg3.mr_bid.utilities.HandlerLanguage;



public class JPanelOptionMenu extends JPanel {

	private JPanel jPanelWhite;
	private JMenu jMenu, jMenu2, jMenu3, jMenu4, jMenu5;
	private JButton jButtonCompras, signin, jButtonLogin;
	private JMenuItem jMenuItemHome, jMenuItemEstadisticas, jMenuItemLogin, jMenuItemAportesHis, jMenuItemCreateBotanic,
			jMenuItemMyCount, jMenuItemMobile, jMenuItemDeleteBotanic;
	private JMenuBar jMenuBar;
	ImageIcon imageIcon;
	Icon icon;

	public JPanelOptionMenu(UserController controller) {
		init(controller);
	}

	private void init(UserController control) {
		// this.setLayout(new GridLayout(1, 7));
		this.setLayout(new BorderLayout());
		this.setBackground(new Color(48, 48, 48));
		this.setPreferredSize(new Dimension(0, 100));
		// setOpaque(false);

		jPanelWhite = new JPanel();
		jPanelWhite.setLayout(new GridLayout(1, 3));
		jPanelWhite.setPreferredSize(new Dimension(400, 100));

		jButtonCompras = new JButton();
		jButtonCompras.setBackground(new Color(48, 48, 48));
		// jButtonEnglish.setActionCommand(Commands.C_ENGLISH.name());
		// jButtonEnglish.addActionListener(control);
		imageIcon = new ImageIcon(getClass().getResource("/images/carro.png"));
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(70, 70, Image.SCALE_AREA_AVERAGING));
		jButtonCompras.setIcon(icon);

		signin = new JButton("Registrar");
		signin.setForeground(Color.WHITE);
		signin.setBackground(new Color(48, 48, 48));
		signin.setActionCommand(ControlCommands.SHOW_REGISTER_USER.name());
		signin.addActionListener(control);

		jButtonLogin = new JButton();
		jButtonLogin.setActionCommand(ControlCommands.SHOW_LOGIN.name());
		jButtonLogin.addActionListener(control);
		jButtonLogin.setBackground(new Color(48, 48, 48));
		imageIcon = new ImageIcon(getClass().getResource("/images/usuario.png"));
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(70, 70, Image.SCALE_AREA_AVERAGING));
		jButtonLogin.setIcon(icon);

		jPanelWhite.add(jButtonCompras);
		jPanelWhite.add(signin);
		jPanelWhite.add(jButtonLogin);

		jMenuBar = new JMenuBar();
		jMenuBar.setLayout(new FlowLayout());
		jMenuBar.setOpaque(false);

		jMenuItemHome = new JMenuItem("HOME");
		jMenuItemHome.setActionCommand(ControlCommands.SHOW_HOME.name());
		jMenuItemHome.setPreferredSize(new Dimension(100, 100));
		jMenuItemHome.setFont(new Font("Arial", 1, 15));
		jMenuItemHome.setOpaque(false);
		jMenuItemHome.setForeground(Color.WHITE);
		jMenuItemHome.addActionListener(control);
		jMenuBar.add(jMenuItemHome);

		jMenu2 = new JMenu("CUENTA");
		jMenu2.setFont(new Font("Arial", 1, 15));
		jMenu2.setBackground(Color.BLACK);
		jMenu2.setForeground(Color.WHITE);
		jMenuBar.add(jMenu2);

		jMenu3 = new JMenu("IDIOMA");
		jMenu3.setFont(new Font("Arial", 1, 15));
		jMenu3.setBackground(Color.BLACK);
		jMenu3.setForeground(Color.WHITE);
		jMenuBar.add(jMenu3);

		jMenu4 = new JMenu("OPTION2");
		jMenu4.setFont(new Font("Arial", 1, 15));
		jMenu4.setBackground(Color.BLACK);
		jMenu4.setForeground(Color.WHITE);
		jMenuBar.add(jMenu4);

		jMenu5 = new JMenu("OPTION4");
		jMenu5.setFont(new Font("Arial", 1, 15));
		jMenu5.setBackground(Color.BLACK);
		jMenu5.setForeground(Color.WHITE);
		jMenuBar.add(jMenu5);

		jMenuItemLogin = new JMenuItem("LOGIN");
		jMenuItemLogin.setActionCommand(ControlCommands.SHOW_REGISTER_USER.name());
		jMenuItemLogin.addActionListener(control);
		jMenu2.add(jMenuItemLogin);

		jMenuItemMyCount = new JMenuItem("Mi Cuenta");
		jMenuItemMyCount.setActionCommand(ControlCommands.SHOW_MYCOUNT.name());
		jMenuItemMyCount.addActionListener(control);
		jMenu2.add(jMenuItemMyCount);

		jMenuItemAportesHis = new JMenuItem("ESPAÑOL");
		jMenuItemAportesHis.setActionCommand(ControlCommands.C_SPANISH.name());
		jMenuItemAportesHis.addActionListener(control);
		jMenu3.add(jMenuItemAportesHis);

		jMenuItemDeleteBotanic = new JMenuItem("INGLES");
		jMenuItemDeleteBotanic.setActionCommand(ControlCommands.C_ENGLISH.name());
		jMenuItemDeleteBotanic.addActionListener(control);
		jMenu3.add(jMenuItemDeleteBotanic);

		this.add(jMenuBar, BorderLayout.CENTER);
		this.add(jPanelWhite, BorderLayout.EAST);

	}
	
	
	public void changeLanguage() {
		jMenuItemHome.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_MENU_HOME));
//		jMenu2.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.T_MENU_Plantlibrary));
//		jMenu3.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.T_MENU_HistoricalContributions));
//		jMenu4.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.T_MENU_STATISTICS));
//		jMenu5.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.T_MENU_MORE));
//		jMenuItemPlantLibrary.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.T_MENU_Plantlibrary));
//		jMenuItemEstadisticas
//				.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.T_MENU_STATISTICS));
//		jMenuItemAportesHis
		
	

	}

}
