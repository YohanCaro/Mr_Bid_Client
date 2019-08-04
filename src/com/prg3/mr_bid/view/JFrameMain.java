package com.prg3.mr_bid.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import com.prg3.mr_bid.controller.UserController;
import com.prg3.mr_bid.utilities.Utilities;
/**
 * CLASE QUE CONTIENE TODOS LOS PANELES DE LA VISTA
 * @author Daniel Garcia
 * fecha 13/06/2019
 */
public class JFrameMain extends JFrame {

	private JScrollPane jScrollPane;
	private JPanelMainWindow jPanelMain;
	private JPanelPrincipalLogin jPanelPrincipalLogin;
	private JPanelOptionMenu jPanelOptionMenu;
	private JPanelMainWindowCuenta jPanelMainWindowCuenta;
	private JPanelMainAddProduct jPanelMainAddProduct;
	private MainPanelHome jMainPanelHome;
	private JPanelMainProduct jPanelMainProduct;
	private JPanelMainWindowMisSubastas jPanelMainWindowMisSubastas;
	Icon icon;

	public JFrameMain(UserController control) {
		this.jScrollPane = new JScrollPane();
		jScrollPane.setOpaque(false);
		this.jPanelMain = new JPanelMainWindow(control);
		this.jPanelPrincipalLogin = new JPanelPrincipalLogin(control);
		this.jMainPanelHome = new MainPanelHome(control);
		jMainPanelHome.setOpaque(false);
		this.jPanelOptionMenu = new JPanelOptionMenu(control);
		this.jPanelMainWindowCuenta = new JPanelMainWindowCuenta(control);
		this.jPanelMainAddProduct = new JPanelMainAddProduct(control);
		this.jPanelMainWindowMisSubastas = new JPanelMainWindowMisSubastas();
		
		init();
	}

	private void init() {
		this.setResizable(true);
		this.setLayout(new BorderLayout());
//		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setTitle("MR BID");
		jScrollPane.setViewportView(jPanelMain);
		this.add(jScrollPane, BorderLayout.CENTER);
		this.add(jPanelOptionMenu, BorderLayout.NORTH);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void showHome() {
		jPanelMain.removeAll();
		jPanelMain.add(jMainPanelHome, BorderLayout.CENTER);
		repaint();
		revalidate();
	}
	
	public void showMain(UserController controller) {
		this.jPanelMain = new JPanelMainWindow(controller);
		jScrollPane.setViewportView(jPanelMain);
		jScrollPane.repaint();
		this.repaint();
	}

	public void showLogin() {
		jPanelMain.removeAll();
		jPanelMain.add(jPanelPrincipalLogin, BorderLayout.CENTER);
		repaint();
		revalidate();
	}
	
	public void showMyCount() {
		jPanelMain.removeAll();
		jPanelMain.add(jPanelMainWindowCuenta, BorderLayout.CENTER);
		repaint();
		revalidate();
	}
	
	public void showPanelAddProduct() {
		jPanelMain.removeAll();
		jPanelMain.add(jPanelMainAddProduct, BorderLayout.CENTER);
//		repaint();
		revalidate();
	}
	
	public void showPanelCardProduct() {
		jPanelMain.removeAll();
		jPanelMain.add(jPanelMainProduct, BorderLayout.CENTER);
		repaint();
		revalidate();
	}
	
	public void showMyHistory() {
		jPanelMain.removeAll();
		jPanelMain.add(jPanelMainWindowMisSubastas, BorderLayout.CENTER);
		repaint();
		revalidate();
	}
	
	public JPanelMainProduct getjPanelMainProduct() {
		return jPanelMainProduct;
	}
	
	/**
	 * Obtiene 
	 * @return jPanelPrincipalLogin
	 */
	public JPanelPrincipalLogin getjPanelPrincipalLogin() {
		return jPanelPrincipalLogin;
	}
	
	
	public void changeLanguage() {
		jPanelOptionMenu.changeLanguage();
		jPanelMainWindowCuenta.changeLanguage();
		jPanelMain.getjPanelMainWindowProduct().changeLanguage();
		jPanelMainProduct.changeLanguage();
		jPanelMainAddProduct.changeLanguage();

	}

	/**
	 * Cambia 
	 * @param jPanelMainProduct the jPanelMainProduct to set
	 */
	public void setjPanelMainProduct(JPanelMainProduct jPanelMainProduct) {
		this.jPanelMainProduct = jPanelMainProduct;
	}
	
	/**
	 * Obtiene 
	 * @return jPanelMainWindowCuenta
	 */
	public JPanelMainWindowCuenta getjPanelMainWindowCuenta() {
		return jPanelMainWindowCuenta;
	}
	
	/**
	 * Obtiene 
	 * @return jPanelMain
	 */
	public JPanelMainWindow getjPanelMain() {
		return jPanelMain;
	}
	
	/**
	 * Cambia 
	 * @param jPanelMain a jPanelMain 
	 */
	public void setjPanelMain(JPanelMainWindow jPanelMain) {
		this.jPanelMain = jPanelMain;
	}
	
	/**
	 * Obtiene 
	 * @return jPanelMainAddProduct
	 */
	public JPanelMainAddProduct getjPanelMainAddProduct() {
		return jPanelMainAddProduct;
	}
	
	public void getrepaint() {
		jPanelMain.repaints();
	}
	
}
