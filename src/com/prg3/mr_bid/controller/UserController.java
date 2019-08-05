package com.prg3.mr_bid.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Locale;

import com.prg3.mr_bid.communication.Client;
import com.prg3.mr_bid.communication.Commands;
import com.prg3.mr_bid.model.entity.BidDate;
import com.prg3.mr_bid.model.entity.BidTime;
import com.prg3.mr_bid.model.entity.Bidding;
import com.prg3.mr_bid.model.entity.ConstantsBid;
import com.prg3.mr_bid.model.entity.MyCaptcha;
import com.prg3.mr_bid.model.entity.Product;
import com.prg3.mr_bid.model.entity.User;
import com.prg3.mr_bid.model.manager.Manager;
import com.prg3.mr_bid.structures.simple_list.SimpleList;
import com.prg3.mr_bid.utilities.Constants;
import com.prg3.mr_bid.utilities.HandlerLanguage;
import com.prg3.mr_bid.utilities.Utilities;
import com.prg3.mr_bid.view.JDialogAbout;
import com.prg3.mr_bid.view.JDialogAddCreditCard;
import com.prg3.mr_bid.view.JDialogAddUser;
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
public class UserController implements ActionListener {
	private static final String NAME_FILE_CONFIG = "config.init";

	private JFrameMain jFrameMain;
	private JDialogAddUser jDialogAddUser;
	private JDialogAddCreditCard jDialogAddCreditCard;
	private JDialogAbout jDialogAbout;
	private JPanelMainWindow jPanelMainWindow;
	private static UserController controller;
	private HandlerLanguage config = null;
	private String languageDefault;
	private MyCaptcha myCaptcha;
	private Manager manager;
	private File fileImage;

	/**
	 * Construtor que inicia la app
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	private UserController() throws UnknownHostException, IOException {
		manager = new Manager();
		getLanguageDefault();
		loadConfiguration();
		this.jFrameMain = new JFrameMain(this);
		this.jDialogAddUser = new JDialogAddUser(this);
		this.jDialogAbout = new JDialogAbout();
		this.jDialogAddCreditCard = new JDialogAddCreditCard();
		this.jPanelMainWindow = new JPanelMainWindow(this);
		sendComment();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		String[] com = command.split(",");
		switch (ControlCommands.valueOf(com[0])) {
		case SHOW_LOGIN:
			jFrameMain.showLogin();
			break;
		case SHOW_PROFILE:
			jFrameMain.showProfile();
			this.changeDataAcc();
			break;
		case SHOW_HOME:
			try {
				if(Client.getInstanceOf().isConnected()) {
					Client.getInstanceOf().updateBiddings();
				}
			} catch (IOException e2) {
			}
			this.jFrameMain.showMain(this);
			break;
		case SHOW_REGISTER_USER:
			jDialogAddUser.setVisible(true);
			break;
		case ACTION_SINGIN:
			if (jDialogAddUser.isVisible() && this.createUser() != null) {
				this.sendData(Commands.SIGNIN, this.createUser());
				jDialogAddUser.setVisible(false);
			} else {
				Utilities.showMessageWarning(ConstantsBid.TXT_COMPLETE,null);
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
				jFrameMain.getjPanelMainProduct().setBidding(manager.searchBiddingForID(Long.parseLong(com[1])));
				jFrameMain.getjPanelMainProduct().start(this);
				jFrameMain.showPanelCardProduct();
			} else {
				Utilities.showMessageError(ConstantsBid.TXT_NULL, ConstantsBid.TXT_ERROR);
			}
			break;
		case SHOW_HISTORY:
			jFrameMain.showMyHistory();
			break;
		case ADD_PHOTO:
			try {				
				fileImage = jFrameMain.getjPanelMainAddProduct().getFile();
			} catch (Exception e1) {
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
			Bidding bidding = this.createBidding();
			if (bidding != null) {
				this.sendData(Commands.UPBIDDING, bidding);
				this.jFrameMain.showMain(this);
				Utilities.showMessageInfo("Si! :D", "Bien");
				Utilities.showMessageInfo(ConstantsBid.TXT_CREATE, null);
				this.jFrameMain.repaint();
				String paths = (fileImage==null)?"":fileImage.getPath();
				try {
					Client.getInstanceOf().sendImages(paths, bidding.getId() +Constants.biddingsList.size());
				} catch (IOException e1) {
				}
				this.jFrameMain.getrepaint();
			}
			break;
		case SEND_BID:
			if (manager.getUser() != null) {
				double valueActually = jFrameMain.getjPanelMainProduct().getValueActually();
				double value = (!jFrameMain.getjPanelMainProduct().isAutomaticIncrement())?
						jFrameMain.getjPanelMainProduct().getValuePuja():valueActually+valueActually*0.05;
				if (value > valueActually) {
					jFrameMain.getjPanelMainProduct().setValueActually((int) value);
					jFrameMain.getjPanelMainAddProduct();
					this.sendData(Commands.NEWOFFER, com[1]+"-"+(int) value);
					jFrameMain.getjPanelMainProduct().setJTextP(manager.getUser().getEmail());
				}
			} else {
				Utilities.showMessageWarning(ConstantsBid.TXT_ERROR_LOAD,null);
			}

			break;
		case C_SHOWABOUT:
			jDialogAbout.setVisible(true);
			break;
		case C_ENGLISH:
			manageChangeLanguageUS();
			break;
		case C_SPANISH:
			manageChangeLanguageES();
		default:
			break;
		}
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
	 * Envia cualquier dato al servidor con:
	 * @param command comando
	 * @param data objeto a enviar
	 */
	private void sendData(Commands command, Object data) {
		try {
			Client.getInstanceOf().sendMessage(command, data);
		} catch (UnknownHostException e) {
			System.out.println(ConstantsBid.TXT_NOTFOUND);
		} catch (IOException e) {
			System.out.println(ConstantsBid.TXT_ERRORSENDDATE);
		}
	}

	/**
	 * Crea un usuario con los datos de la vista
	 * @return user usuario
	 */
	private User createUser() {
		return manager.createUser(jDialogAddUser.getjPanelForm().getFirstName(),
				jDialogAddUser.getjPanelForm().getLastName(), jDialogAddUser.getjPanelForm().getEmail(),
				jDialogAddUser.getjPanelForm().getPassword(), jDialogAddUser.getjPanelForm().getBirthDate(),
				jDialogAddUser.getjPanelForm().getDocument(), jDialogAddUser.getjPanelForm().getTypeDocument(),
				jDialogAddUser.getjPanelForm().getGender(), null);
	}

	/**
	 * Carga los datos de la cuenta del usuario
	 */
	public void changeDataAcc() {
		try {
			manager.setUser(Client.getInstanceOf().getUser());
			this.jFrameMain.getjPanelMainWindowCuenta().changeData(Client.getInstanceOf().getUser());
			this.jFrameMain.getjPanelMainWindowProfile().getjPanelFormProfile().changeData(Client.getInstanceOf().getUser());;
			this.jFrameMain.getjPanelMainWindowCuenta().repaint();
			this.jFrameMain.getjPanelMainWindowProfile().changeData(Client.getInstanceOf().getUser());
			this.jFrameMain.getjPanelMainWindowProfile().repaint();
			this.jFrameMain.getjPanelMainWindowProfile().getjPanelFormProfile().repaint();
			this.jFrameMain.repaint();
		} catch (UnknownHostException e) {
		} catch (IOException e) {
		}
	}

	/**
	 * Crea una subasta con los datos de la vista
	 * @return Bidding subasta
	 */
	private Bidding createBidding() {
		if (jFrameMain.getjPanelMainAddProduct().getJTextName() != null
				&& jFrameMain.getjPanelMainAddProduct().getDescription() != null
				&& jFrameMain.getjPanelMainAddProduct().getDateP() != null
				&& jFrameMain.getjPanelMainAddProduct().getDateI() != null
				&& jFrameMain.getjPanelMainAddProduct().getDateF() != null) {
			String list = (fileImage==null)?"":fileImage.getPath();
			Product p = new Product(jFrameMain.getjPanelMainAddProduct().getJTextName(),
					jFrameMain.getjPanelMainAddProduct().getDescription(), list);
			return manager.addBidding(jFrameMain.getjPanelMainAddProduct().getJTextName(),
					jFrameMain.getjPanelMainAddProduct().getTypeProduct(), p,
					new BidTime(new BidDate(jFrameMain.getjPanelMainAddProduct().getDateP()),
							jFrameMain.getjPanelMainAddProduct().hourP()),
					new BidTime(new BidDate(jFrameMain.getjPanelMainAddProduct().getDateI()),
							jFrameMain.getjPanelMainAddProduct().hourI()),
					new BidTime(new BidDate(jFrameMain.getjPanelMainAddProduct().getDateF()),
							jFrameMain.getjPanelMainAddProduct().hourF()),
					jFrameMain.getjPanelMainAddProduct().isAutomatic(),
					jFrameMain.getjPanelMainAddProduct().isPublic(), 
					Integer.parseInt(jFrameMain.getjPanelMainAddProduct().getValueMin()));
		} else {
			Utilities.showMessageWarning(ConstantsBid.TXT_COMPLETE,
					null);
			return null;
		}
	}

	/**
	 * Crea un unico controllador
	 * @return controller controlador
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static UserController getInstanceOf() throws UnknownHostException, IOException {
		if (controller == null) {
			controller = new UserController();
		}
		return controller;
	}
	
	/**
	 * Metodo para manda y recibe un array de string al panel de comentarios
	 */
	public void sendComment() {
		SimpleList<String> menssge = new SimpleList<String>();
		jFrameMain.getjPanelMainProduct().sendComment(menssge);
	}

	/**
	 * Cambia el valor por defecto del idioma de la aplicación
	 * @return cadena con el idioma
	 */
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

	/**
	 * Carga el idioma
	 * @throws IOException ioe
	 */
	public void loadLanguage() throws IOException {
		try {
			config.loadLanguage();
		} catch (Exception e) {
		}
	}

	/**
	 * Guarda el archivo de configuraciones (idioma)
	 * @throws IOException ioe
	 */
	public void saveConfig() throws IOException {
		try {
			new HandlerLanguage(NAME_FILE_CONFIG).saveLanguage();
		} catch (Exception e) {
		}
	}

	/**
	 * Cambia el idioma de la aplicación a inglés
	 * @throws IOException ioe
	 */
	public void changeToEnglish() throws IOException {
		HandlerLanguage.language = "language/languageUS.properties";
		saveConfig();
		loadLanguage();
	}

	/**
	 * Cambia el idioma de la aplicación a español
	 * @throws IOException ioe
	 */
	public void changeToSpanish() throws IOException {
		HandlerLanguage.language = "language/languageES.properties";
		saveConfig();
		loadLanguage();
	}

	/**
	 * Carga las configuraciones del archivo
	 */
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

	/**
	 * Manejo de idioma inglés
	 */
	private void manageChangeLanguageUS() {
		try {
			changeToEnglish();
		} catch (IOException e1) {
		}
		manageChangeLanguage();
	}

	/**
	 * Manejo de idioma español
	 */
	private void manageChangeLanguageES() {
		try {
			changeToSpanish();
		} catch (IOException e1) {
		}
		manageChangeLanguage();
	}

	/**
	 * Caraga el idioma en toda la aplicación y el frame
	 */
	private void manageChangeLanguage() {
		jFrameMain.changeLanguage();
	}

}
