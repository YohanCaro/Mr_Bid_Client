package com.prg3.mr_bid.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;


public class JFrameMain extends JFrame {

	private JScrollPane jScrollPane;
	private JPanelMainWindow jPanelMain;
	Icon icon;

	
	public JFrameMain() {
		this.jScrollPane = new JScrollPane();
		this.jPanelMain = new JPanelMainWindow();
		init();
	}
	
	
	
	private void init() {
		this.setResizable(true);
		this.setLayout(new BorderLayout());
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setTitle("MR BID");
		jScrollPane.setViewportView(jPanelMain);
		this.add(jScrollPane, BorderLayout.CENTER);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
