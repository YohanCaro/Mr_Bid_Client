package com.prg3.mr_bid.view;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class JDialogAbout extends JDialog {

	private JLabel label1, label2;
	private JCheckBox check1;
	private JButton boton1, boton2;
	private JScrollPane scrollpane1;
	private JTextArea textarea1;
	String nombre = "";

	public JDialogAbout() {
		setLayout(null);
		this.setResizable(false);
		setSize(600, 400);
		this.setLocationRelativeTo(null);


		label1 = new JLabel("ACERCA DE");
		label1.setBounds(215, 5, 200, 30);
		label1.setFont(new Font("Andale Mono", 1, 14));
		label1.setForeground(new Color(0, 0, 0));
		add(label1);

		textarea1 = new JTextArea();
		textarea1.setEditable(false);
		textarea1.setFont(new Font("Andale Mono", 0, 9));
		textarea1.setText("\n\n          ACERCA DE"
				+ "\n\n            A.  PROHIBIDA SU VENTA O DISTRIBUCIÓN SIN AUTORIZACIÓN."
				+ "\n            B.  PROHIBIDA LA ALTERACIÓN DEL CÓDIGO FUENTE O DISEÑO DE LAS INTERFACES GRÁFICAS."
				+ "\n            C.  LA _______NO SE HACE RESPONSABLE DEL MAL USO DE ESTE SOFTWARE."
				+ "\n\n          LOS ACUERDOS LEGALES EXPUESTOS ACONTINUACIÓN RIGEN EL USO QUE USTED HAGA DE ESTE SOFTWARE"
				+ "\n          (LA _________________), NO SE RESPONSABILIZAN DEL USO QUE USTED"
				+ "\n          HAGA CON ESTE SOFTWARE Y SUS SERVICIOS. PARA ACEPTAR ESTOS TERMINOS HAGA CLIC EN (ACEPTO)"
				+ "\n          SI USTED NO ACEPTA ESTOS TERMINOS, HAGA CLIC EN (NO ACEPTO) Y NO UTILICE ESTE SOFTWARE."
				+ "\n\n          PARA MAYOR INFORMACIÓN SOBRE NUESTROS PRODUCTOS O SERVICIOS, POR FAVOR VISITE"
				+ "\n            C.  _______________ NO SE HACE RESPONSABLE DEL MAL USO DE ESTE SOFTWARE."
				+ "\n\n          LOS ACUERDOS LEGALES EXPUESTOS ACONTINUACIÓN RIGEN EL USO QUE USTED HAGA DE ESTE SOFTWARE"
				+ "\n          _____________________, NO SE RESPONSABILIZAN DEL USO QUE USTED"
				+ "\n          HAGA CON ESTE SOFTWARE Y SUS SERVICIOS. PARA ACEPTAR ESTOS TERMINOS HAGA CLIC EN (ACEPTO)"
				+ "\n          SI USTED NO ACEPTA ESTOS TERMINOS, HAGA CLIC EN (NO ACEPTO) Y NO UTILICE ESTE SOFTWARE."
				+ "\n\n          PARA MAYOR INFORMACIÓN SOBRE NUESTROS PRODUCTOS O SERVICIOS, POR FAVOR VISITE"
				+ "\n          ");
		scrollpane1 = new JScrollPane(textarea1);
		scrollpane1.setBounds(10, 40, 575, 270);
		add(scrollpane1);

	

		ImageIcon imagen = new ImageIcon("images/coca-cola.png");
		label2 = new JLabel(imagen);
		label2.setBounds(315, 135, 300, 300);
		add(label2);
	}

	public void stateChanged(ChangeEvent e) {
		if (check1.isSelected() == true) {
			boton1.setEnabled(false);
			boton1.setEnabled(true);

		} else {
			boton1.setEnabled(true);
			boton1.setEnabled(false);

		}

	}


}