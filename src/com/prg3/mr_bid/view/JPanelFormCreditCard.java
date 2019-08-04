package com.prg3.mr_bid.view;

import java.awt.Color;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.prg3.mr_bid.utilities.ConstantsView;
import com.prg3.mr_bid.utilities.HintJTextField;
import com.prg3.mr_bid.utilities.Utilities;
import com.toedter.calendar.JDateChooser;

/**
 * Clase JPanelFormCreditCard - Crea el panel para intoducir los datos de 
 * la tarjeta de credito de los usuarios
 *
 * @version 1.0 - 4/08/2019
 * @author Daniel García
 */
public class JPanelFormCreditCard extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabelName;
	private JButton jButton;
	private HintJTextField jTextFieldName, jTextFieldNumberFront, jTextFieldCod;
	private JDateChooser jDateChooser;

	/**
	 * Constructor que crea elpanel
	 */
	public JPanelFormCreditCard() {
		this.setLayout(null);
		setSize(ConstantsView.SIZE_PFC);
		initComponents();
	}

	/**
	 * Inicializa los componentes del panel
	 */
	private void initComponents() {
		this.setBackground(Color.WHITE);
		createLabel(ConstantsView.TEXT_ADD_CREDIT_CARD, 20, 0);

		createLabel(ConstantsView.TEXT_EXP_DATE_FPC, 20, 50);

		jDateChooser = new JDateChooser();
		jDateChooser.setBounds(200, 50, 250, 40);
		add(jDateChooser);

		createLabel(ConstantsView.TEXT_HOLDER_NAME_FPC, 20, 100);
		createTextField(ConstantsView.TEXT_HOLDER_NAME_FPC, 200, 100, jTextFieldName);

		createLabel(ConstantsView.TEXT_CARD_NUMBER_FPC, 20, 150);
		createTextField(ConstantsView.TEXT_CARD_NUMBER_FPC, 200, 150, jTextFieldNumberFront);

		createLabel(ConstantsView.TEXT_SECURITY_CODE_FPC, 20, 200);
		createTextField(ConstantsView.TEXT_SECURITY_CODE_FPC, 200, 200, jTextFieldCod);

		jButton = new JButton(ConstantsView.BT_ACEPT_PFC);
		jButton.setBounds(200, 250, 250, 40);
		add(jButton);
	}

	/**
	 * Obtiene el nombre del propietario
	 * @return jTextFieldName tf
	 */
	public String getnameholder() {
		return jTextFieldName.getText();
	}

	/**
	 * Obtiene el numero de la tarjeta
	 * @return jTextFieldName tf
	 */
	public String getcardnNumber() {
		return jTextFieldName.getText();
	}

	/**
	 * Obtiene el código de seguridad de la terjeta
	 * @return jTextFieldName tf
	 */
	public String getsecurityCode() {
		return jTextFieldName.getText();
	}

	/**
	 * Metodo que verifica el campo de entrada de la fecha de nacimiento utilizando
	 * una libreria externa y convirtiendo el valor en un String!
	 * 
	 * @return la cadena con el valor extraido del textfield si lo encuantra, sino
	 *         devuelve un null!
	 */
	public String getexpirationdDate() {
		if (jDateChooser.getDate() != null) {
			Date date = jDateChooser.getDate();
			DateFormat df = DateFormat.getDateInstance();
			String date2 = df.format(date);
			return date2;
		}
		return null;
	}

	/**
	 * Crea un label con una información
	 * @param name nombre
	 * @param x posX
	 * @param y posY
	 * @return jLabelName label
	 */
	public JLabel createLabel(String name, int x, int y) {
		jLabelName = new JLabel(name);
		jLabelName.setBounds(x, y, 200, 50);
		jLabelName.setBackground(ConstantsView.COLOR__FORE_WD);
		jLabelName.setPreferredSize(Utilities.setDimension(200, 60));
		add(jLabelName);
		return jLabelName;
	}

	/**
	 * Crea un textfield con:
	 * @param name nombre
	 * @param x posX
	 * @param y posY
	 * @param atribute valor
	 * @return atribute tf
	 */
	public HintJTextField createTextField(String name, int x, int y, HintJTextField atribute) {
		atribute = new HintJTextField(name);
		atribute.setBounds(x, y, 250, 40);
		atribute.setBackground(ConstantsView.COLOR__FORE_WD);
		atribute.setPreferredSize(Utilities.setDimension(200, 60));
		add(atribute);
		return atribute;
	}

}