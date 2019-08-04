package com.prg3.mr_bid.view;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.prg3.mr_bid.controller.UserController;
import com.prg3.mr_bid.utilities.ConstantsView;

/**
 * Clase JDialogAddUser - DIALOGO PARA AGRERAR UN USUARIO NUEVO
 *
 * @version 1.0 - 13/06/2019
 * @author Daniel García
 */
public class JDialogAddUser extends JDialog {
	
	/**
	 * Serial por defecto
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanelForm jPanelForm;

	/**
	 * Constructor que crea la ventana de registro de usuario
	 * @param controller
	 */
	public JDialogAddUser(UserController controller) {
		this.jPanelForm = new JPanelForm(controller);
		init();
	}

	/**
	 * Inicializa los componentes del dialog
	 */
	private void init() {
		this.setResizable(false);
		setSize(ConstantsView.SIZE_DIALOG_USER);
		this.setLocationRelativeTo(null);

		this.add(jPanelForm, BorderLayout.CENTER);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	/**
	 * Obtien el formulario
	 * @return jPanelForm jpanel
	 */
	public JPanelForm getjPanelForm() {
		return jPanelForm;
	}

}
