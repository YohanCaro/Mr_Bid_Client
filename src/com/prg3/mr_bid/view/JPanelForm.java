package com.prg3.mr_bid.view;

import java.awt.Color;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import com.prg3.mr_bid.controller.ControlCommands;
import com.prg3.mr_bid.controller.UserController;
import com.prg3.mr_bid.model.entity.Gender;
import com.prg3.mr_bid.model.entity.TypeDocument;
import com.prg3.mr_bid.utilities.ConstantsView;
import com.prg3.mr_bid.utilities.HintJTextField;
import com.prg3.mr_bid.utilities.Utilities;
import com.toedter.calendar.JDateChooser;

/**
 * Clase JPanelForm - Se encarga de crear el panel de formulario
 * para el registro del cliente
 *
 * @version 1.0 - 4/08/2019
 * @author Bid Team
 */
public class JPanelForm extends JPanel {

	/**
	 * Serial por defecto
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel jLabelName, jLabelImage;
	private JButton jBRegist, jButton;
	private HintJTextField jTextFieldName, jTextFieldEmail, jTextFieldPasswor, jTextFieldid,
			jTextFieldLastName, jTextFieldCaptchat;
	private JComboBox<TypeDocument> jComboBox;
	private JPanelRobotCenter jPanelRobotCenter;
	private JDateChooser jDateChooser;
	private JRadioButton jRadioButton, jRadioButton2;
	private ButtonGroup buttonGroup;

	/**
	 * Constructor que crea el formualrio
	 * @param controller controlador
	 */
	public JPanelForm(UserController controller) {
		this.jPanelRobotCenter = new JPanelRobotCenter();
		this.setLayout(null);
//		setSize(350, 400);
		initComponents(controller);
	}

	/**
	 * Inicializa los componentes del panel
	 * @param controller controlador
	 */
	private void initComponents(UserController controller) {
		this.setBackground(Color.WHITE);
		
		createLabel(ConstantsView.TEXT_NAME_PF, 20, 20);
		jTextFieldName = createTextField(ConstantsView.TEXT_NAME_PF, 150, 20, jTextFieldName, 120);
		jTextFieldLastName = createTextField(ConstantsView.TEXT_LAST_NAME_PF, 280, 20, jTextFieldLastName, 120);

		createLabel(ConstantsView.TEXT_EMAIL_PF, 20, 70);
		jTextFieldEmail = createTextField(ConstantsView.TEXT_EMAIL_PF, 150, 70, jTextFieldEmail, 250);

		createLabel(ConstantsView.TEXT_PASSWORD_PF, 20, 120);
		jTextFieldPasswor = createTextField(ConstantsView.TEXT_PASSWORD_PF, 150, 120, jTextFieldPasswor, 250);

		createLabel(ConstantsView.TEXT_TYPE_DOC_PF, 20, 170);
		jComboBox = new JComboBox<TypeDocument>();
		jComboBox.setBackground(Color.WHITE);
		jComboBox.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(0, 0, 0, 0), new EtchedBorder()));
		jComboBox.setBounds(150, 170, 250, 40);
		jComboBox.setBackground(ConstantsView.COLOR__FORE_WD);
		add(jComboBox);

		jComboBox.addItem(TypeDocument.CEDULA);
		jComboBox.addItem(TypeDocument.TI);
		jComboBox.addItem(TypeDocument.PASAPORTE);

		createLabel(ConstantsView.TEXT_NUMBER_DOC_PF, 20, 220);
		jTextFieldid = createTextField("Numero Documento", 150, 220, jTextFieldid, 250);

		createLabel(ConstantsView.TEXT_BIRTHDATE_PF, 20, 270);
		jDateChooser = new JDateChooser();
		jDateChooser.setBounds(150, 280, 250, 30);
		add(jDateChooser);

		createLabel(ConstantsView.TEXT_GENDER_PF, 20, 320);

		jRadioButton = new JRadioButton(ConstantsView.TEXT_FEMALE_PF);
		jRadioButton.setBounds(150, 330, 100, 30);
		jRadioButton.setSelected(true);
		add(jRadioButton);

		jRadioButton2 = new JRadioButton(ConstantsView.TEXT_MALE_PF);
		jRadioButton2.setBounds(250, 330, 100, 30);
		add(jRadioButton2);

		buttonGroup = new ButtonGroup();
		buttonGroup.add(jRadioButton);
		buttonGroup.add(jRadioButton2);

		jButton = new JButton(ConstantsView.TEXT_ADD_CARD_PF);
		jButton.setActionCommand(ControlCommands.SHOW_ADD_CREDIT_CARD.name());
		jButton.addActionListener(controller);
		jButton.setBounds(150, 370, 250, 40);
		add(jButton);

		createLabel(ConstantsView.TEXT_CAPTCHA_PF, 20, 420);
		jTextFieldCaptchat = createTextField(ConstantsView.TEXT_CAPTCHA_PF, 150, 420,
				jTextFieldCaptchat, 250);

		jBRegist = new JButton(ConstantsView.BT_REGIST_PF);
		jBRegist.setBounds(150, 480, 250, 40);
		jBRegist.setActionCommand(ControlCommands.ACTION_SINGIN.name());
		jBRegist.addActionListener(controller);
		add(jBRegist);
	}
	
	/**
	 * Crea un label con:
	 * @param name nombre
	 * @param x posX
	 * @param y posY
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
	 * @param name nombre
	 * @param x posX
	 * @param y posY
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
	 * @param name nombre
	 * @param x posX
	 * @param y posY
	 * @param atribute valor
	 * @param xsize tamaño en x
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
	 * @return jTextFieldEmail correo
	 */
	public String getEmail() {
		if (Utilities.isEmailAvailable(jTextFieldEmail.getText())){
			return jTextFieldEmail.getText();
		} else {
			jTextFieldEmail.setForeground(Color.RED);
		}
		return null;
	}

	/**
	 * Obtiene la contraseña del usuario
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
	 * @return jComboBox tipo
	 */
	public TypeDocument getTypeDocument() {
		return (TypeDocument) jComboBox.getSelectedItem();
	}
	
	/**
	 * Obtiene el genero del usuario
	 * @return gender genero
	 */
	public Gender getGender() {
		return (jRadioButton2.isSelected()?Gender.MALE:Gender.FEMALE);
	}

	/**
	 * Metodo que verifica el campo de entrada de la fecha de nacimiento utilizando 
	 * una libreria externa y convirtiendo el valor en un String!
	 * @return la cadena con el valor extraido del textfield si lo encuantra, sino 
	 * devuelve un null!
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