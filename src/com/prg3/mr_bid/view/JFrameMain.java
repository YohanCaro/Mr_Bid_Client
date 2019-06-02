package com.prg3.mr_bid.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import com.prg3.mr_bid.controller.UserController;

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
		this.jPanelMain = new JPanelMainWindow(control);
		this.jPanelPrincipalLogin = new JPanelPrincipalLogin(control);
		this.jMainPanelHome = new MainPanelHome(control);
		this.jPanelOptionMenu = new JPanelOptionMenu(control);
		this.jPanelMainWindowCuenta = new JPanelMainWindowCuenta(control);
		this.jPanelMainAddProduct = new JPanelMainAddProduct(control);
		this.jPanelMainProduct = new JPanelMainProduct();
		this.jPanelMainWindowMisSubastas = new JPanelMainWindowMisSubastas();

		init();
	}

	private void init() {
		this.setResizable(true);
		this.setLayout(new BorderLayout());
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
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
		repaint();
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
}
