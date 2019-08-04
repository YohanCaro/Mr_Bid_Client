package com.prg3.mr_bid.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.prg3.mr_bid.controller.ControlCommands;
import com.prg3.mr_bid.controller.UserController;
import com.prg3.mr_bid.model.entity.ConstantsBid;
import com.prg3.mr_bid.utilities.ConstantsView;
import com.prg3.mr_bid.utilities.HandlerLanguage;
import com.prg3.mr_bid.utilities.Utilities;

/**
 * Clase JPanelOptionMenu - Se encarga de crear el menu de opciones del panel 
 * principal
 *
 * @version 1.0 - 4/08/2019
 * @author Daniel García
 */
public class JPanelOptionMenu extends JPanel {

	/**
	 * Serial por defecto
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel jPanelWhite;
	private JMenu jMenu2, jMenu3, jMenu4;
	private JButton jButtonCompras, signin, jButtonLogin;
	private JMenuItem jMenuItemHome, jMenuItemESPANISH, jMenuItemMyCount, jMenuItemENGLISH,
			jMenuItemABOUT;
	private JMenuBar jMenuBar;
	private ImageIcon imageIcon;
	private Icon icon;

	/**
	 * Constructor del panel
	 * @param controller controlador
	 */
	public JPanelOptionMenu(UserController controller) {
		init(controller);
	}

	/**
	 * Inicia los componentes del menú
	 * @param control controlador
	 */
	private void init(UserController control) {
		this.setLayout(new BorderLayout());
		this.setBackground(ConstantsView.BACKGROUD_MENU);
		this.setPreferredSize(Utilities.setDimension(0, 100));

		jPanelWhite = new JPanel();
		jPanelWhite.setLayout(new GridLayout(1, 3));
		jPanelWhite.setPreferredSize(Utilities.setDimension(400, 100));

		jButtonCompras = new JButton();
		jButtonCompras.setBackground(ConstantsView.BACKGROUD_MENU);
		// jButtonEnglish.setActionCommand(Commands.C_ENGLISH.name());
		// jButtonEnglish.addActionListener(control);
		imageIcon = new ImageIcon(ConstantsView.PATH_ICON_CAR_MENU);
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(70, 70, Image.SCALE_AREA_AVERAGING));
		jButtonCompras.setIcon(icon);

		signin = new JButton(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_SIGNIN));
		signin.setFont(ConstantsView.FONT_SIGNIN_MENU);
		signin.setForeground(ConstantsView.COLOR_FOREGROUND_MENU);
		signin.setBackground(ConstantsView.BACKGROUD_MENU);
		signin.setActionCommand(ControlCommands.SHOW_REGISTER_USER.name());
		signin.addActionListener(control);

		jButtonLogin = new JButton();
		jButtonLogin.setActionCommand(ControlCommands.SHOW_LOGIN.name());
		jButtonLogin.addActionListener(control);
		jButtonLogin.setBackground(ConstantsView.BACKGROUD_MENU);
		imageIcon = new ImageIcon(ConstantsView.PATH_ICON_USER_MENU);
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
		jMenuItemHome.setPreferredSize(Utilities.setDimension(100, 100));
		jMenuItemHome.setFont(ConstantsView.FONT_ITEM_HOME_MENU);
		jMenuItemHome.setOpaque(false);
		jMenuItemHome.setForeground(ConstantsView.COLOR_FOREGROUND_MENU);
		jMenuItemHome.addActionListener(control);
		jMenuBar.add(jMenuItemHome);

		jMenu2 = new JMenu(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_ACCOUNT));
		jMenu2.setFont(ConstantsView.FONT_ITEM_HOME_MENU);
		jMenu2.setBackground(ConstantsView.BACKGROUD_MENU_2);
		jMenu2.setForeground(ConstantsView.COLOR_FOREGROUND_MENU);
		jMenuBar.add(jMenu2);

		jMenu3 = new JMenu(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_LENGUAGE));
		jMenu3.setFont(ConstantsView.FONT_ITEM_HOME_MENU);
		jMenu3.setBackground(ConstantsView.BACKGROUD_MENU_2);
		jMenu3.setForeground(ConstantsView.COLOR_FOREGROUND_MENU);
		jMenuBar.add(jMenu3);

		jMenu4 = new JMenu(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_ABOUT));
		jMenu4.setActionCommand(ControlCommands.C_SHOWABOUT.name());
		jMenu4.addActionListener(control);
		jMenu4.setFont(ConstantsView.FONT_ITEM_HOME_MENU);
		jMenu4.setBackground(ConstantsView.BACKGROUD_MENU_2);
		jMenu4.setForeground(ConstantsView.COLOR_FOREGROUND_MENU);
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

	/**
	 * Cambia el lenguaje del menú
	 */
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
