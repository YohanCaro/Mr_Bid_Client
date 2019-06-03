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
	private JMenuItem jMenuItemHome, jMenuItemEstadisticas, jMenuItemLogin, jMenuItemESPANISH, jMenuItemCreateBotanic,
			jMenuItemMyCount, jMenuItemMobile, jMenuItemENGLISH, jMenuItemABOUT;
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

		signin = new JButton(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_SIGNIN));
		signin.setFont(new Font("Arial", 1, 13));
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

		jMenuItemHome = new JMenuItem(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_MENU_HOME));
		jMenuItemHome.setActionCommand(ControlCommands.SHOW_HOME.name());
		jMenuItemHome.setPreferredSize(new Dimension(100, 100));
		jMenuItemHome.setFont(new Font("Arial", 1, 15));
		jMenuItemHome.setOpaque(false);
		jMenuItemHome.setForeground(Color.WHITE);
		jMenuItemHome.addActionListener(control);
		jMenuBar.add(jMenuItemHome);

		jMenu2 = new JMenu(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_ACCOUNT));
		jMenu2.setFont(new Font("Arial", 1, 15));
		jMenu2.setBackground(Color.BLACK);
		jMenu2.setForeground(Color.WHITE);
		jMenuBar.add(jMenu2);

		jMenu3 = new JMenu(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_LENGUAGE));
		jMenu3.setFont(new Font("Arial", 1, 15));
		jMenu3.setBackground(Color.BLACK);
		jMenu3.setForeground(Color.WHITE);
		jMenuBar.add(jMenu3);

		jMenu4 = new JMenu(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_ABOUT));
		jMenu4.setActionCommand(ControlCommands.C_SHOWABOUT.name());
		jMenu4.addActionListener(control);
		jMenu4.setFont(new Font("Arial", 1, 15));
		jMenu4.setBackground(Color.BLACK);
		jMenu4.setForeground(Color.WHITE);
		jMenuBar.add(jMenu4);
	

		jMenuItemABOUT = new JMenuItem(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_ABOUT));
		jMenuItemABOUT.setActionCommand(ControlCommands.C_SHOWABOUT.name());
		jMenuItemABOUT.addActionListener(control);
		jMenu4.add(jMenuItemABOUT);

		jMenuItemMyCount = new JMenuItem(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_ACCOUNT));
		jMenuItemMyCount.setActionCommand(ControlCommands.SHOW_MYCOUNT.name());
		jMenuItemMyCount.addActionListener(control);
		jMenu2.add(jMenuItemMyCount);

		jMenuItemESPANISH = new JMenuItem(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_SPANISH));
		jMenuItemESPANISH.setActionCommand(ControlCommands.C_SPANISH.name());
		jMenuItemESPANISH.addActionListener(control);
		jMenu3.add(jMenuItemESPANISH);

		jMenuItemENGLISH = new JMenuItem(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_ENGLISH));
		jMenuItemENGLISH.setActionCommand(ControlCommands.C_ENGLISH.name());
		jMenuItemENGLISH.addActionListener(control);
		jMenu3.add(jMenuItemENGLISH);

		this.add(jMenuBar, BorderLayout.CENTER);
		this.add(jPanelWhite, BorderLayout.EAST);

	}

	public void changeLanguage() {
		jMenuItemHome.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_MENU_HOME));
		jMenuItemESPANISH.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_SPANISH));
		jMenuItemENGLISH.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_ENGLISH));
		jMenuItemENGLISH.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_ENGLISH));
		jMenu3.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_LENGUAGE));
		jMenu4.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_ABOUT));
		jMenu2.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_ACCOUNT));
		signin.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_SIGNIN));
		jMenuItemMyCount.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_ACCOUNT));

	}

}
