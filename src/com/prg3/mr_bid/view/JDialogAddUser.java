package com.prg3.mr_bid.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class JDialogAddUser extends JDialog {
	JPanelForm jPanelForm;
	// JpanelNorte jpanelNorte;

	public JDialogAddUser() {
		this.jPanelForm = new JPanelForm();
		// this.jpanelNorte = new JpanelNorte();
		init();
	}

	private void init() {
		this.setResizable(false);
		setSize(500, 600);
		this.setLocationRelativeTo(null);

		// this.add(jpanelNorte, BorderLayout.NORTH);
		this.add(jPanelForm, BorderLayout.CENTER);

		// this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

}
