package com.prg3.mr_bid.view;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.prg3.mr_bid.utilities.ConstantsView;

/**
 * Clase JDialogAddCreditCard - Clase que crea un dailogo para los datos de
 *  tarjeta de credito
 *
 * @version 1.0 - 13/06/2019
 * @author Daniel García
 */
public class JDialogAddCreditCard extends JDialog {
	
	/**
	 * Serial por defecto
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanelFormCreditCard jPanelForm;

	/**
	 * Constructor que inicializa el panel de la la tarjeta
	 */
	public JDialogAddCreditCard() {
		this.jPanelForm = new JPanelFormCreditCard();
		init();
	}

	/**
	 * Inicializa los componentes
	 */
	private void init() {
		this.setResizable(false);
		setSize(ConstantsView.SIZE_DIALOG_CREDIT_CARD);
		this.setLocationRelativeTo(null);

		this.add(jPanelForm, BorderLayout.CENTER);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
