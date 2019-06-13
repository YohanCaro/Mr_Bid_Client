package com.prg3.mr_bid.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JFileChooser;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.w3c.dom.DOMException;

import com.prg3.mr_bid.communication.Client;
import com.prg3.mr_bid.communication.Commands;
import com.prg3.mr_bid.model.entity.BidDate;
import com.prg3.mr_bid.model.entity.BidTime;
import com.prg3.mr_bid.model.entity.Bidding;
import com.prg3.mr_bid.model.entity.MyCaptcha;
import com.prg3.mr_bid.model.entity.Product;
import com.prg3.mr_bid.model.entity.User;
import com.prg3.mr_bid.model.manager.Manager;
import com.prg3.mr_bid.utilities.Constants;
import com.prg3.mr_bid.utilities.HandlerLanguage;
import com.prg3.mr_bid.utilities.Utilities;
import com.prg3.mr_bid.view.JDialogAbout;
import com.prg3.mr_bid.view.JDialogAddCreditCard;
import com.prg3.mr_bid.view.JDialogAddUser;
import com.prg3.mr_bid.view.JDialogListUsers;
import com.prg3.mr_bid.view.JFrameMain;
import com.prg3.mr_bid.view.JPanelMainProduct;
import com.prg3.mr_bid.view.JPanelMainWindow;

/**
 * Clase UserController - Clase encaragda de manejar las acciones de las
 * ventanas y botones.
 *
 * @author Yohan Caro
 * @version 1.0 - 2/06/2019
 */
public class UserController implements ActionListener, MouseListener {
	private static final String NAME_FILE_CONFIG = "config.init";

	private JFrameMain jFrameMain;
	private JDialogAddUser jDialogAddUser;
	private JDialogAddCreditCard jDialogAddCreditCard;
	private JDialogAbout jDialogAbout;
	private JPanelMainWindow jPanelMainWindow;
	private JDialogListUsers jDialogListUsers;
	private static UserController controller;
	private HandlerLanguage config = null;
	private String languageDefault;
	private MyCaptcha myCaptcha;
	private Manager manager;

	/**
	 * Construtor que inicia la app
	 */
	private UserController() {
		manager = new Manager();
		getLanguageDefault();
		loadConfiguration();
//		Utilities.fillBiddings();
		// myCaptcha.create();
		this.jFrameMain = new JFrameMain(this);
		this.jDialogListUsers = new JDialogListUsers(this);
		this.jDialogAddUser = new JDialogAddUser(this);
		this.jDialogAbout = new JDialogAbout();
		this.jDialogAddCreditCard = new JDialogAddCreditCard();
		this.jPanelMainWindow = new JPanelMainWindow(this);

		addProduct();
		sendComment();

	}

	/**
	 * Maneja los eventos de botones
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		String[] com = command.split(",");
		switch (ControlCommands.valueOf(com[0])) {
		case SHOW_LOGIN:
			jFrameMain.showLogin();
			break;
		case SHOW_HOME:
			this.updateBiddings();
			jFrameMain.showHome();
			break;
		case SHOW_REGISTER_USER:
			jDialogAddUser.setVisible(true);
			break;
		case ACTION_SINGIN:

			if (jDialogAddUser.isVisible() && this.createUser() != null) {
				this.sendData(Commands.SIGNIN, this.createUser());
				jDialogAddUser.setVisible(false);
			} else {
				Utilities.showMessageWarning("Por favor complete todos los campos correctamente!",
						"Datos no validos o vacios!");
			}
			break;
		case SHOW_ADD_CREDIT_CARD:
			jDialogAddCreditCard.setVisible(true);
			break;
		case SHOW_MYCOUNT:
			this.changeDataAcc();
			jFrameMain.showMyCount();
			break;
		case SHOW_ADDPRODUCT:
			this.changeDataAcc();
			jFrameMain.showPanelAddProduct();
			break;
		case SHOW_PRODUCT:
			if (manager.searchBiddingForID(Long.parseLong(com[1])) != null) {
				JPanelMainProduct jPanelMainProduct = new JPanelMainProduct();
				jFrameMain.setjPanelMainProduct(jPanelMainProduct);
				jFrameMain.getjPanelMainProduct()
						.setBidding(manager.searchBiddingForID(Long.parseLong(com[1])));
				jFrameMain.getjPanelMainProduct().start(this);
				jFrameMain.showPanelCardProduct();
			} else {
				Utilities.showMessageError("El id de la tarjeta es nulo", "Error");
			}

			break;
		case SHOW_HISTORY:
			jFrameMain.showMyHistory();
			break;
		case ADD_PHOTO:
			try {
				selectImagge();
			} catch (DOMException | TransformerFactoryConfigurationError | ParserConfigurationException
					| TransformerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;

		case ACTION_LOGIN:
			this.sendDataLogin();
			jFrameMain.showMyCount();
			break;
		case CLOSE_PRODUCT:
			jFrameMain.showMyCount();
			break;
		case ACTION_BIDDING:
//			try {
//				Client.getInstanceOf().sendNewBidding(null); //metodo de vista que retorne un objeto bidding con los datos recolectados
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			if (this.createBidding() != null) {
				this.sendData(Commands.UPBIDDING, this.createBidding());
				this.jFrameMain.showMain(this);
				Utilities.showMessageInfo("Si! :D", "Bien");
			} else {
				Utilities.showMessageWarning("Error al enviar la subasta", "Datos incompletos!");
			}
			
			break;
		case LIST_CONNECT:
			jDialogListUsers.setVisible(true);
			break;
		case SEND_BID:
			double value = jFrameMain.getjPanelMainProduct().getValuePuja();
			double valueActually = jFrameMain.getjPanelMainProduct().getValueActually();
			if (value > valueActually) {
				jFrameMain.getjPanelMainProduct().setValueActually(value);
			}
			break;
		case C_SHOWABOUT:
			jDialogAbout.setVisible(true);
			break;
		case C_ENGLISH:
			System.out.println("INGLES");
			manageChangeLanguageUS();
			break;
		case C_SPANISH:
			manageChangeLanguageES();
			System.out.println("ESPAÑOL");

		default:
			break;
		}
	}

	/**
	 * Añade un producto
	 */
	private void addProduct() {
		this.jPanelMainWindow = new JPanelMainWindow("Computador LG", "Publico", "No inicida", "7;80", "/images/lg.jpg",
				this);
	}

	/**
	 * Envia los datos de legueo
	 */
	private void sendDataLogin() {
		String email = jFrameMain.getjPanelPrincipalLogin().getjTextFieldName();
		String password = jFrameMain.getjPanelPrincipalLogin().getJpassword();
		this.sendData(Commands.LOGIN, email + "," + password);
	}

	/**
	 * Envia cualquier dato al servidor con
	 * 
	 * @param command
	 *            comando
	 * @param data
	 *            objeto a enviar
	 */
	private void sendData(Commands command, Object data) {
		try {
			Client.getInstanceOf().sendMessage(command, data);
		} catch (UnknownHostException e) {
			System.out.println("No se ha encontrado el servidor");
		} catch (IOException e) {
			System.out.println("Error al enviar el dato");
		}
	}

	/**
	 * Crea un usuario con los datos de la vista
	 * 
	 * @return user usuario
	 */
	private User createUser() {
		return manager.createUser(jDialogAddUser.getjPanelForm().getFirstName(),
				jDialogAddUser.getjPanelForm().getLastName(), jDialogAddUser.getjPanelForm().getEmail(),
				jDialogAddUser.getjPanelForm().getPassword(), jDialogAddUser.getjPanelForm().getBirthDate(),
				jDialogAddUser.getjPanelForm().getDocument(), jDialogAddUser.getjPanelForm().getTypeDocument(),
				jDialogAddUser.getjPanelForm().getGender(), null);
	}
	
	public void changeDataAcc() {
		try {
			manager.setUser(Client.getInstanceOf().getUser());
			this.jFrameMain.getjPanelMainWindowCuenta().changeData(Client.getInstanceOf().getUser());
			this.jFrameMain.getjPanelMainWindowCuenta().repaint();
			this.jFrameMain.repaint();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	 private Bidding createBidding() {
		 if (jFrameMain.getjPanelMainAddProduct().getJTextName() != null &&
				 jFrameMain.getjPanelMainAddProduct().getDescription() != null && jFrameMain.getjPanelMainAddProduct().getDateP() 
				 != null  && jFrameMain.getjPanelMainAddProduct().getDateI() != null && 
				 jFrameMain.getjPanelMainAddProduct().getDateF() != null) {
				ArrayList<String> list = new ArrayList<>();
				list.add("/images/iphone.png");
			 Product p = new Product(jFrameMain.getjPanelMainAddProduct().getJTextName(),
					 jFrameMain.getjPanelMainAddProduct().getDescription(), list);
			 System.out.println(p.toString());
			 return manager.addBidding(jFrameMain.getjPanelMainAddProduct().getJTextName(),
					 jFrameMain.getjPanelMainAddProduct().getTypeProduct(), p,
					 new BidTime(new BidDate(jFrameMain.getjPanelMainAddProduct().getDateP()), 
							 jFrameMain.getjPanelMainAddProduct().hourP()),
					 new BidTime(new BidDate(jFrameMain.getjPanelMainAddProduct().getDateI()), 
							 jFrameMain.getjPanelMainAddProduct().hourI()),
					 new BidTime(new BidDate(jFrameMain.getjPanelMainAddProduct().getDateF()), 
							 jFrameMain.getjPanelMainAddProduct().hourF()), true, true);
		 } else {
			 Utilities.showMessageWarning("Por favor, llene todos los campos para\n"
			 		+ "poder realizar la subasta", "Campos no llenados");
			 return null;
		 }
		
	 }

	/**
	 * Crea un unico controllador
	 * 
	 * @return controller controlador
	 */
	public static UserController getInstanceOf() {
		if (controller == null) {
			controller = new UserController();
		}
		return controller;
	}

	/**
	 * Metodo para manda y recibe un array de string al panel de comentarios
	 */
	public void sendComment() {
		ArrayList<String> menssge = new ArrayList<String>();
		menssge.add("hola");
		menssge.add("hola1");
		menssge.add("hola2");
		menssge.add("hola3");
		menssge.add("hola4");
		jFrameMain.getjPanelMainProduct().sendComment(menssge);

	}

	public void updateBiddings() {
		this.jFrameMain.getjPanelMain().addCard(Constants.biddingsList.get(Constants.biddingsList.size()-1), this);
		this.jFrameMain.getjPanelMain().repaint();
		this.jFrameMain.repaint();
	}

	/**
	 * Selecciona una img
	 * 
	 * @throws DOMException
	 *             e
	 * @throws TransformerFactoryConfigurationError
	 *             e
	 * @throws ParserConfigurationException
	 *             e
	 * @throws TransformerException
	 *             e
	 */
	private void selectImagge() throws DOMException, TransformerFactoryConfigurationError, ParserConfigurationException,
			TransformerException {
		JFileChooser ventanaG = new JFileChooser();
		ventanaG.showSaveDialog(null);
		if (ventanaG.getSelectedFile() != null) {
			// se debe guardar la imagen
		}

	}

	///////////////////////////////// 7

	public String getLanguageDefault() {
		languageDefault = Locale.getDefault().getLanguage();
		switch (languageDefault) {
		case "es":
			return "Spanish";
		case "us":
			return "English";
		}
		return "Spanish";
	}

	public void loadLanguage() throws IOException {
		try {
			config.loadLanguage();
		} catch (Exception e) {
		}
	}

	public void saveConfig() throws IOException {
		try {
			new HandlerLanguage(NAME_FILE_CONFIG).saveLanguage();
		} catch (Exception e) {
		}
	}

	public void changeToEnglish() throws IOException {
		HandlerLanguage.language = "language/languageUS.properties";
		saveConfig();
		loadLanguage();
	}

	public void changeToSpanish() throws IOException {
		HandlerLanguage.language = "language/languageES.properties";
		saveConfig();
		loadLanguage();
	}

	public void loadConfiguration() {
		if (config == null) {
			config = new HandlerLanguage(NAME_FILE_CONFIG);
		}
		try {
			config.loadLanguage();
		} catch (IOException e) {
			System.err.println("file not found : NAME_FILE_CONFIG");
		}
	}

	private void manageChangeLanguageUS() {
		try {
			changeToEnglish();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		manageChangeLanguage();

	}

	private void manageChangeLanguageES() {
		try {
			changeToSpanish();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		manageChangeLanguage();

	}

	private void manageChangeLanguage() {
		jFrameMain.changeLanguage();

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
