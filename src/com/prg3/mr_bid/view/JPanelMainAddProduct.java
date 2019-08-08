package com.prg3.mr_bid.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.io.File;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;

import com.prg3.mr_bid.controller.ControlCommands;
import com.prg3.mr_bid.controller.UserController;
import com.prg3.mr_bid.model.entity.ConstantsBid;
import com.prg3.mr_bid.model.entity.TypeProduct;
import com.prg3.mr_bid.utilities.ConstantsView;
import com.prg3.mr_bid.utilities.HandlerLanguage;
import com.prg3.mr_bid.utilities.HintJTextField;
import com.prg3.mr_bid.utilities.Utilities;
import com.toedter.calendar.JDateChooser;

/**
 * Clase JPanelMainAddProduct - Se encarag de añadir una nuevo producto (vista)
 *
 * @version 1.0 - 4/06/2019
 * @author Bid Team
 */
public class JPanelMainAddProduct extends JPanel {

	/**
	 * Serial por defecto
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane jScrollPane;
	private JPanel jPanelNorth, jPanelSouth, jPanelWest, jPanelEast, jPanelCenter, jPanelCard1, jPanelCard2,
			jPanelCard3;
	private JLabel jLabelName, jLabelDescription;
	private JComboBox<TypeProduct> typeJComboBox;
	private HintJTextField jTextFieldName, jTextFieldTy;
	private JTextArea descriptionJTextArea;
	private JDateChooser jCalendar, jCalendar2, jCalendar3;
	private JRadioButton jRadioButton, jRadioButton2, jRadioButtonPublic, jRadioButtonPrivate;
	private ButtonGroup buttonGroup, buttonGroup2;
	private JSpinner jSpinnerPublicatedHour, jSpinnerStartHour, jSpinnerFinishHour;
	private JFileChooser jFileChooser;
	private JButton jButtoncreate, jButtonCancel;

	/**
	 * Constructor que crea los paneles del panel
	 * 
	 * @param control
	 *            controlador
	 */
	public JPanelMainAddProduct(UserController control) {
		this.jPanelNorth = new JPanel();
		this.jPanelSouth = new JPanel();
		this.jPanelWest = new JPanel();
		this.jPanelEast = new JPanel();
		this.jPanelCenter = new JPanel();
		this.jScrollPane = new JScrollPane(descriptionJTextArea);

		character();
		sizePanel();
		Card1(control);
		Card2();
		Card3(control);
		init();
	}

	/**
	 * Colorea los paneles
	 */
	private void character() {
		jPanelCenter.setBackground(Color.black);
	}

	/**
	 * Le da tamaño a los paneles
	 */
	private void sizePanel() {
		jPanelWest.setPreferredSize(Utilities.setDimension(100, 0));
		jPanelEast.setPreferredSize(Utilities.setDimension(100, 0));
		jPanelNorth.setPreferredSize(Utilities.setDimension(0, 100));
		jPanelCenter.setPreferredSize(Utilities.setDimension(0, 1000));
	}

	/**
	 * Se dividen la secciones del panel por tarjetas Tarjeta 1
	 * 
	 * @param control
	 *            controlador
	 */
	private void Card1(UserController control) {
		this.jPanelCard1 = new JPanel();
		JButton jButton = new JButton(ConstantsView.BT_ADD_IMG_MAP);
		jButton.setActionCommand(ControlCommands.ADD_PHOTO.name());
		jButton.addActionListener(control);
		descriptionJTextArea = new JTextArea();
		descriptionJTextArea.setLineWrap(true);
		descriptionJTextArea.setBounds(600, 60, 500, 200);

		jScrollPane.setBounds(600, 60, 500, 200);
		jScrollPane.setViewportView(descriptionJTextArea);

		jButton.setBounds(200, 180, 200, 30);
		jPanelCard1.setLayout(null);
		jPanelCard1.setBackground(Color.LIGHT_GRAY);
		jPanelCard1.add(createLabel(ConstantsView.TEXT_DATA_PRODUCT, 10, 10, 200, 30));

		jPanelCard1.add(createLabel(ConstantsView.TEXT_DESCRIPTION, 600, 10, 200, 30));
		jLabelDescription = new JLabel(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_DESCRIPTION));
		jLabelDescription.setBounds(600, 10, 200, 30);
		jLabelDescription.setBackground(new Color(244, 244, 244));
		jLabelDescription.setPreferredSize(Utilities.setDimension(200, 60));
		jPanelCard1.add(jLabelDescription);

		jPanelCard1.add(createLabel(ConstantsView.TEXT_TYPE_PUB, 20, 60, 200, 30));
		jTextFieldName = createTextField(ConstantsView.TEXT_TYPE_PUB, 200, 60, 200, 30);
		jPanelCard1.add(jTextFieldName);
		jPanelCard1.add(createLabel(ConstantsView.TEXT_TYPE_PRO, 20, 120, 200, 30));
		typeJComboBox = new JComboBox<>(TypeProduct.values());
		typeJComboBox.setBounds(200, 120, 200, 30);
		jPanelCard1.add(typeJComboBox);
		jPanelCard1.add(jButton);
		jPanelCard1.add(jScrollPane);
	}

	/**
	 * Se dividen la secciones del panel por tarjetas Tarjeta 2
	 */
	private void Card2() {
		this.jPanelCard2 = new JPanel();

		JButton jButton = new JButton(ConstantsView.BT_ADD_IMG_MAP);
		JTextArea jTextArea = new JTextArea();
		jTextArea.setBounds(600, 60, 500, 200);
		jButton.setBounds(200, 180, 200, 30);
		jPanelCard2.setLayout(null);
		jPanelCard2.setBackground(Color.LIGHT_GRAY);

		jPanelCard2.add(createLabel(ConstantsView.TEXT_TIME_BID, 10, 10, 200, 30));

		jPanelCard2.add(createLabel(ConstantsView.TEXT_DATE_PUB, 20, 60, 200, 30));
		jPanelCard2.add(createLabel(ConstantsView.TEXT_DATE_INI, 20, 120, 200, 30));
		jPanelCard2.add(createLabel(ConstantsView.TEXT_DATE_FIN, 20, 180, 200, 30));

		jCalendar = new JDateChooser();
		jCalendar.setBounds(200, 60, 200, 30);
		jPanelCard2.add(jCalendar);

		jCalendar2 = new JDateChooser();
		jCalendar2.setBounds(200, 120, 200, 30);
		jPanelCard2.add(jCalendar2);

		jCalendar3 = new JDateChooser();
		jCalendar3.setBounds(200, 180, 200, 30);
		jPanelCard2.add(jCalendar3);

		jPanelCard2.add(createLabel(ConstantsView.TEXT_HOUR_PUB, 600, 60, 200, 30));
		jSpinnerPublicatedHour = new JSpinner(new SpinnerNumberModel(8, 0, 24, 1));
		jSpinnerPublicatedHour.setBounds(790, 60, 200, 30);
		jPanelCard2.add(jSpinnerPublicatedHour);

		jPanelCard2.add(createLabel(ConstantsView.TEXT_HOUR_INI, 600, 120, 200, 30));
		jSpinnerStartHour = new JSpinner(new SpinnerNumberModel(8, 0, 24, 1));
		jSpinnerStartHour.setBounds(790, 120, 200, 30);
		jPanelCard2.add(jSpinnerStartHour);

		jPanelCard2.add(createLabel(ConstantsView.TEXT_HOUR_FIN, 600, 180, 200, 30));
		jSpinnerFinishHour = new JSpinner(new SpinnerNumberModel(8, 0, 24, 1));
		jSpinnerFinishHour.setBounds(790, 180, 200, 30);
		jPanelCard2.add(jSpinnerFinishHour);
	}

	/**
	 * Se dividen la secciones del panel por tarjetas Tarjeta 3
	 * 
	 * @param control
	 *            controlador
	 */
	private void Card3(UserController controller) {
		this.jPanelCard3 = new JPanel();

		JButton jButton = new JButton(ConstantsView.BT_ADD_IMG_MAP);
		JTextArea jTextArea = new JTextArea();
		jTextArea.setBounds(600, 60, 500, 200);
		jButton.setBounds(200, 180, 200, 30);
		jPanelCard3.setLayout(null);
		jPanelCard3.setBackground(Color.LIGHT_GRAY);

		jPanelCard3.add(createLabel(ConstantsView.TEXT_ABOUT_BID, 10, 10, 200, 30));

		jPanelCard3.add(createLabel(ConstantsView.TEXT_TYPE_INCREMENT, 20, 60, 200, 30));
		jPanelCard3.add(createLabel(ConstantsView.TEXT_MIN_VALUE, 20, 120, 200, 30));
		jPanelCard3.add(createLabel(ConstantsView.TEXT_TYPE_BID, 20, 180, 200, 30));
		jTextFieldTy = createTextField2(ConstantsView.TEXT_MIN_VALUE, 200, 120, 200, 30);
		jPanelCard3.add(jTextFieldTy);

		jRadioButton = new JRadioButton(ConstantsView.TEXT_AUTOMATIC);
		jRadioButton.setBounds(200, 60, 100, 30);
		jRadioButton.setSelected(true);
		jPanelCard3.add(jRadioButton);

		jRadioButton2 = new JRadioButton(ConstantsView.TEXT_FOR_USER);
		jRadioButton2.setBounds(300, 60, 150, 30);
		jPanelCard3.add(jRadioButton2);

		buttonGroup = new ButtonGroup();
		buttonGroup.add(jRadioButton);
		buttonGroup.add(jRadioButton2);

		jRadioButtonPublic = new JRadioButton(ConstantsView.TEXT_PUBLIC);
		jRadioButtonPublic.setBounds(200, 180, 100, 30);
		jRadioButtonPublic.setSelected(true);
		jPanelCard3.add(jRadioButtonPublic);

		jRadioButtonPrivate = new JRadioButton(ConstantsView.TEXT_PRIVATE);
		jRadioButtonPrivate.setBounds(300, 180, 100, 30);
		jPanelCard3.add(jRadioButtonPrivate);

		buttonGroup2 = new ButtonGroup();
		buttonGroup2.add(jRadioButtonPublic);
		buttonGroup2.add(jRadioButtonPrivate);

		jButtoncreate = new JButton(ConstantsView.BT_CREATE_MAP);
		jButtoncreate.setBounds(400, 230, 100, 30);
		jButtoncreate.setActionCommand(ControlCommands.ACTION_BIDDING.name());
		jButtoncreate.addActionListener(controller);
		jPanelCard3.add(jButtoncreate);

		jButtonCancel = new JButton(ConstantsView.BT_CANCEL_MAP);
		jButtonCancel.setBounds(600, 230, 100, 30);
		jButtonCancel.setActionCommand(ControlCommands.CLOSE_PRODUCT.name());
		jButtonCancel.addActionListener(controller);
		jPanelCard3.add(jButtonCancel);
	}

	/**
	 * Inicia los componentes del panel
	 */
	private void init() {
		this.setLayout(new BorderLayout());
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());

		jPanelCenter.setLayout(new GridLayout(3, 1, 0, 20));
		jPanelCenter.add(jPanelCard1);
		jPanelCenter.add(jPanelCard2);
		jPanelCenter.add(jPanelCard3);

		this.add(jPanelNorth, BorderLayout.NORTH);
		this.add(jPanelSouth, BorderLayout.SOUTH);
		this.add(jPanelWest, BorderLayout.WEST);
		this.add(jPanelEast, BorderLayout.EAST);
		this.add(jPanelCenter, BorderLayout.CENTER);
	}

	/**
	 * Crea e instancia un label
	 * 
	 * @param name
	 *            nombre
	 * @param x
	 *            posX
	 * @param y
	 *            posY
	 * @param sisex
	 *            tamaño x
	 * @param sizey
	 *            tamaño y
	 * @return jLabelName label con el nombre
	 */
	public JLabel createLabel(String name, int x, int y, int sisex, int sizey) {
		jLabelName = new JLabel(name);
		jLabelName.setBounds(x, y, sisex, sizey);
		jLabelName.setBackground(ConstantsView.COLOR__FORE_WD);
		jLabelName.setPreferredSize(Utilities.setDimension(200, 60));
		add(jLabelName);
		return jLabelName;
	}

	/**
	 * Crea un HintTextField para los campos de texto
	 * 
	 * @param name
	 *            nombre
	 * @param x
	 *            posX
	 * @param y
	 *            posY
	 * @param sisex
	 *            tamaño X
	 * @param sizey
	 *            tamañoY
	 * @return jTextFieldName tf
	 */
	public HintJTextField createTextField(String name, int x, int y, int sisex, int sizey) {
		jTextFieldName = new HintJTextField(name);
		jTextFieldName.setBounds(x, y, sisex, sizey);
		jTextFieldName.setBackground(ConstantsView.COLOR__FORE_WD);
		add(jTextFieldName);
		return jTextFieldName;
	}

	/**
	 * Crea un HintTextField para los campos de texto
	 * 
	 * @param name
	 *            nombre
	 * @param x
	 *            posX
	 * @param y
	 *            posY
	 * @param sisex
	 *            tamaño X
	 * @param sizey
	 *            tamañoY
	 * @return jTextFieldName tf
	 */
	public HintJTextField createTextField2(String name, int x, int y, int sisex, int sizey) {
		jTextFieldTy = new HintJTextField(name);
		jTextFieldTy.setBounds(x, y, sisex, sizey);
		jTextFieldTy.setBackground(ConstantsView.COLOR__FORE_WD);
		add(jTextFieldTy);
		return jTextFieldTy;
	}

	/**
	 * Obtiene el valor del nombre
	 * 
	 * @return jTextFieldName name
	 */
	public String getJTextName() {
		if (jTextFieldName.getText() != null && !jTextFieldName.getText().isEmpty()) {
			return jTextFieldName.getText();
		}
		return null;
	}

	/**
	 * Obtien el valor de la puja
	 * 
	 * @return
	 */
	public String getValueMin() {
		if (jTextFieldTy.getText() != null && !jTextFieldTy.getText().isEmpty()) {
			return jTextFieldTy.getText();
		}
		return null;
	}

	/**
	 * Obtiene el valor de la descripción
	 * 
	 * @return descriptionJTextArea textArea
	 */
	public String getDescription() {
		if (descriptionJTextArea.getText() != null && !descriptionJTextArea.getText().isEmpty()) {
			return descriptionJTextArea.getText();
		}
		return null;
	}

	/**
	 * Obtiene le tipo de producto
	 * 
	 * @return typeJComboBox combo
	 */
	public TypeProduct getTypeProduct() {
		return (TypeProduct) typeJComboBox.getSelectedItem();
	}

	/**
	 * Metodo que verifica el campo de entrada de la fecha
	 * 
	 * @return la cadena con el valor extraido del textfield si lo encuantra, sino
	 *         devuelve un null!
	 */
	public String getDateP() {
		if (jCalendar.getDate() != null) {
			Date date = jCalendar.getDate();
			DateFormat df = DateFormat.getDateInstance();
			String date2 = df.format(date);
			return date2;
		}
		return null;
	}

	/**
	 * Metodo que verifica el campo de entrada de la fecha
	 * 
	 * @return la cadena con el valor extraido del textfield si lo encuantra, sino
	 *         devuelve un null!
	 */
	public String getDateI() {
		if (jCalendar2.getDate() != null) {
			Date date = jCalendar2.getDate();
			DateFormat df = DateFormat.getDateInstance();
			String date2 = df.format(date);
			return date2;
		}
		return null;
	}

	/**
	 * Metodo que verifica el campo de entrada de la fecha
	 * 
	 * @return la cadena con el valor extraido del textfield si lo encuantra, sino
	 *         devuelve un null!
	 */
	public String getDateF() {
		if (jCalendar3.getDate() != null) {
			Date date = jCalendar3.getDate();
			DateFormat df = DateFormat.getDateInstance();
			String date2 = df.format(date);
			return date2;
		}
		return null;
	}

	/**
	 * Obtien la hora de publicación
	 * 
	 * @return hora byte
	 */
	public byte hourP() {
		return (byte) ((int) jSpinnerPublicatedHour.getModel().getValue());
	}

	/**
	 * Obtien la hora de inicio
	 * 
	 * @return hora byte
	 */
	public byte hourI() {
		return (byte) ((int) jSpinnerStartHour.getModel().getValue());
	}

	/**
	 * Obtien la hora de finalizacion
	 * 
	 * @return hora byte
	 */
	public byte hourF() {
		return (byte) ((int) jSpinnerFinishHour.getModel().getValue());
	}

	/**
	 * Verifica si la subasta es automatica
	 * 
	 * @return jRadioButton auto
	 */
	public boolean isAutomatic() {
		return (jRadioButton.isSelected() ? true : false);
	}

	/**
	 * Verifica si la subasta es publica
	 * 
	 * @return jRadioButtonPublic public
	 */
	public boolean isPublic() {
		return (jRadioButtonPublic.isSelected() ? true : false);
	}

	/**
	 * Cambia el idioma :/
	 */
	public void changeLanguage() {

	}

	/**
	 * JFileChooser para cargar la imagen de la subasta o publicacion
	 * 
	 * @return jFileChooser chooser
	 * @throws Exception
	 *             exception con el archivo
	 */
	public File getFile() throws Exception {
		jFileChooser = new JFileChooser();
		jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int option = jFileChooser.showOpenDialog(this);
		if (option == JFileChooser.APPROVE_OPTION) {
			return jFileChooser.getSelectedFile();
		}
		throw new Exception();
	}

}
