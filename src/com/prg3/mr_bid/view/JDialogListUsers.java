package com.prg3.mr_bid.view;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.prg3.mr_bid.controller.UserController;
/**
 * DIALOGO QUE MUESTRA LAS LISTA DE USUARIOS CONECTADOS
 * @author Daniel Garcia
 * fecha 13/06/2019
 */
public class JDialogListUsers extends JDialog {
	JPListUsers jPanelForm;
	// JpanelNorte jpanelNorte;

	public JDialogListUsers(UserController controllerApp) {
		this.jPanelForm = new JPListUsers(controllerApp);
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
