package com.prg3.mr_bid.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class JDialogAddCreditCard extends JDialog {
	JPanelFormCreditCard jPanelForm;
	// JpanelNorte jpanelNorte;

	public JDialogAddCreditCard() {
		this.jPanelForm = new JPanelFormCreditCard();
		// this.jpanelNorte = new JpanelNorte();
		init();
	}

	private void init() {
		this.setResizable(false);
		setSize(500, 350);
		this.setLocationRelativeTo(null);

		// this.add(jpanelNorte, BorderLayout.NORTH);
		this.add(jPanelForm, BorderLayout.CENTER);

		// this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

}
