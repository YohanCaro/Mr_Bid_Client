package com.prg3.mr_bid.view;

import java.awt.Color;
import java.io.IOException;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import com.prg3.mr_bid.communication.Client;
import com.prg3.mr_bid.controller.ControlCommands;
import com.prg3.mr_bid.controller.UserController;
import com.prg3.mr_bid.model.entity.Gender;
import com.prg3.mr_bid.model.entity.TypeDocument;
import com.prg3.mr_bid.model.entity.User;
import com.prg3.mr_bid.utilities.ConstantsView;
import com.prg3.mr_bid.utilities.HintJTextField;
import com.prg3.mr_bid.utilities.Utilities;
import com.toedter.calendar.JDateChooser;

/**
 * Clase JPanelForm - Se encarga de crear el panel de formulario para el
 * registro del cliente
 *
 * @version 1.0 - 4/08/2019
 * @author Bid Team
 */
public class JPanelFormProfile extends JPanel {

	/**
	 * Serial por defecto
	 */
	private static final long serialVersionUID = 1L;

	private JLabel jLabelName, jLabelImage;
	private JTextField jTextFieldName, jTextFieldEmail, jTextFieldid, jTextFieldLastName, jTextFieldBirthday,
			jTextFieldGender;
	private JComboBox<TypeDocument> jComboBox;
	private JPanelRobotCenter jPanelRobotCenter;
	private JDateChooser jDateChooser;
	private JRadioButton jRadioButton, jRadioButton2;
	private JPasswordField jTextFieldPasswor;
	private String name;

	/**
	 * Constructor que crea el formualrio
	 * 
	 * @param controller
	 *            controlador
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	public JPanelFormProfile(UserController controller) throws UnknownHostException, IOException {
		this.jPanelRobotCenter = new JPanelRobotCenter();
		this.setLayout(null);
		// setSize(350, 400);
		initComponents(controller);
	}

	/**
	 * Inicializa los componentes del panel
	 * 
	 * @param controller
	 *            controlador
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	private void initComponents(UserController controller) throws UnknownHostException, IOException {
		this.setBackground(Color.WHITE);

		createLabel(ConstantsView.TEXT_NAME_PF, 20, 20);
		jTextFieldName = new JTextField();
		jTextFieldName.setEditable(false);
		jTextFieldName.setBackground(ConstantsView.COLOR__FORE_WD);
		jTextFieldName.setBounds(150, 20, 120, 40);
		add(jTextFieldName);

		jTextFieldLastName = new JTextField();
		jTextFieldLastName.setEditable(false);
		jTextFieldLastName.setBackground(ConstantsView.COLOR__FORE_WD);
		jTextFieldLastName.setBounds(280, 20, 120, 40);
		add(jTextFieldLastName);

		createLabel(ConstantsView.TEXT_EMAIL_PF, 20, 70);
		jTextFieldEmail = new JTextField();
		jTextFieldEmail.setEditable(false);
		jTextFieldEmail.setBackground(ConstantsView.COLOR__FORE_WD);
		jTextFieldEmail.setBounds(150, 70, 250, 40);
		add(jTextFieldEmail);

		createLabel(ConstantsView.TEXT_NUMBER_DOC_PF, 20, 120);
		jTextFieldid = new JTextField();
		jTextFieldid.setEditable(false);

		jTextFieldid.setBackground(ConstantsView.COLOR__FORE_WD);
		jTextFieldid.setBounds(150, 120, 250, 40);
		add(jTextFieldid);

		createLabel(ConstantsView.TEXT_BIRTHDATE_PF, 20, 170);
		jTextFieldBirthday = new JTextField();
		jTextFieldBirthday.setEditable(false);

		jTextFieldBirthday.setBackground(ConstantsView.COLOR__FORE_WD);
		jTextFieldBirthday.setBounds(150, 170, 250, 40);
		add(jTextFieldBirthday);

		createLabel(ConstantsView.TEXT_GENDER_PF, 20, 220);
		jTextFieldGender = new JTextField();
		jTextFieldGender.setEditable(false);
		jTextFieldGender.setBackground(ConstantsView.COLOR__FORE_WD);
		jTextFieldGender.setBounds(150, 220, 250, 40);
		add(jTextFieldGender);

	}

	public void changeData(User user) {
		if (user != null) {
			jTextFieldBirthday.setText(user.getBirthDate().getDateString());
			jTextFieldGender.setText(user.getGender().getValue());
			jTextFieldid.setText(user.getDocument());
			jTextFieldLastName.setText(user.getLastName());
			jTextFieldEmail.setText(user.getEmail());
			jTextFieldName.setText(user.getFirstName());
			this.repaint();
		}
	}



	/**
	 * Crea un label con:
	 * 
	 * @param name
	 *            nombre
	 * @param x
	 *            posX
	 * @param y
	 *            posY
	 * @return jLabelName lbl
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
	 * Crea un label con:
	 * 
	 * @param name
	 *            nombre
	 * @param x
	 *            posX
	 * @param y
	 *            posY
	 * @return jLabelImage lbl
	 */
	public JLabel createLabel2(String name, int x, int y) {
		jLabelImage.add(jPanelRobotCenter);
		jLabelImage.setBounds(x, y, 200, 50);
		jLabelImage.setBackground(ConstantsView.COLOR__FORE_WD);
		jLabelImage.setPreferredSize(Utilities.setDimension(200, 60));
		add(jLabelImage);
		return jLabelImage;

	}

	/**
	 * Crea un campo de texto
	 * 
	 * @param name
	 *            nombre
	 * @param x
	 *            posX
	 * @param y
	 *            posY
	 * @param atribute
	 *            valor
	 * @param xsize
	 *            tamaño en x
	 * @return atribute tf
	 */
	public HintJTextField createTextField(String name, int x, int y, HintJTextField atribute, int xsize) {
		atribute = new HintJTextField(name);
		atribute.setBounds(x, y, xsize, 40);
		atribute.setBackground(ConstantsView.COLOR__FORE_WD);
		atribute.setPreferredSize(Utilities.setDimension(200, 60));
		add(atribute);
		return atribute;
	}

	/**
	 * Obtien el nombre del usuario
	 * 
	 * @return jTextFieldName nombre
	 */
	public String getFirstName() {
		if (jTextFieldName.getText() != null && !jTextFieldName.getText().isEmpty()) {
			return jTextFieldName.getText();
		}
		return null;
	}

	/**
	 * Obtien el apellido del usuario
	 * 
	 * @return jTextFieldLastName tf
	 */
	public String getLastName() {
		if (jTextFieldLastName.getText() != null && !jTextFieldLastName.getText().isEmpty()) {
			return jTextFieldLastName.getText();
		}
		return null;
	}

	/**
	 * Obtiene el correo electronico de usuario
	 * 
	 * @return jTextFieldEmail correo
	 */
	public String getEmail() {
		if (Utilities.isEmailAvailable(jTextFieldEmail.getText())) {
			return jTextFieldEmail.getText();
		} else {
			jTextFieldEmail.setForeground(Color.RED);
		}
		return null;
	}

	/**
	 * Obtiene la contraseña del usuario
	 * 
	 * @return jTextFieldPasswor contraseña
	 */
	public String getPassword() {
		if (jTextFieldPasswor.getText() != null && !jTextFieldPasswor.getText().isEmpty()) {
			return jTextFieldPasswor.getText();
		}
		return null;
	}

	/**
	 * Obtiene el documento del usuario
	 * 
	 * @return jTextFieldid doc
	 */
	public String getDocument() {
		if (jTextFieldid.getText() != null && !jTextFieldid.getText().isEmpty()) {
			return jTextFieldid.getText();
		}
		return null;
	}

	/**
	 * Obtiene el tipo de documento del usuario
	 * 
	 * @return jComboBox tipo
	 */
	public TypeDocument getTypeDocument() {
		return (TypeDocument) jComboBox.getSelectedItem();
	}

	/**
	 * Obtiene el genero del usuario
	 * 
	 * @return gender genero
	 */
	public Gender getGender() {
		return (jRadioButton2.isSelected() ? Gender.MALE : Gender.FEMALE);
	}

	/**
	 * Metodo que verifica el campo de entrada de la fecha de nacimiento utilizando
	 * una libreria externa y convirtiendo el valor en un String!
	 * 
	 * @return la cadena con el valor extraido del textfield si lo encuantra, sino
	 *         devuelve un null!
	 */
	public String getBirthDate() {
		if (jDateChooser.getDate() != null) {
			Date date = jDateChooser.getDate();
			DateFormat df = DateFormat.getDateInstance();
			String date2 = df.format(date);
			return date2;
		}
		return null;
	}

}