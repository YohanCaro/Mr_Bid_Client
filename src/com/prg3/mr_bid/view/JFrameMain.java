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
	private MainPanelHome jMainPanelHome;
	Icon icon;

	public JFrameMain(UserController control) {
		this.jScrollPane = new JScrollPane();
		this.jPanelMain = new JPanelMainWindow(control);
		this.jPanelPrincipalLogin = new JPanelPrincipalLogin();
		this.jMainPanelHome = new MainPanelHome(control);
		this.jPanelOptionMenu = new JPanelOptionMenu(control);

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
}
