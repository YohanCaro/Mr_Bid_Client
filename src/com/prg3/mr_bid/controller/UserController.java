package com.prg3.mr_bid.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.w3c.dom.DOMException;

import com.prg3.mr_bid.communication.Client;
import com.prg3.mr_bid.communication.Commands;
import com.prg3.mr_bid.model.entity.BidDate;
import com.prg3.mr_bid.model.entity.User;
import com.prg3.mr_bid.model.manager.Manager;
import com.prg3.mr_bid.utilities.Utilities;
import com.prg3.mr_bid.view.JDialogAddCreditCard;
import com.prg3.mr_bid.view.JDialogAddUser;
import com.prg3.mr_bid.view.JFrameMain;
import com.prg3.mr_bid.view.JPanelMainProduct;
import com.prg3.mr_bid.view.JPanelMainWindow;

public class UserController implements ActionListener {

	private JFrameMain jFrameMain;
	private JDialogAddUser jDialogAddUser;
	private JDialogAddCreditCard jDialogAddCreditCard;
	private JPanelMainWindow jPanelMainWindow;
	private static UserController controller;

	private UserController() {
		this.jFrameMain = new JFrameMain(this);
		this.jDialogAddUser = new JDialogAddUser(this);
		this.jDialogAddCreditCard = new JDialogAddCreditCard();
		this.jPanelMainWindow = new JPanelMainWindow(this);
		addProduct();
		sendComment();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (ControlCommands.valueOf(e.getActionCommand())) {
		case SHOW_LOGIN:
			jFrameMain.showLogin();
			break;
		case SHOW_HOME:
			jFrameMain.showHome();
			break;
		case SHOW_REGISTER_USER:
			jDialogAddUser.setVisible(true);
			break;
		case SHOW_ADD_CREDIT_CARD:
			jDialogAddCreditCard.setVisible(true);
			break;
		case SHOW_MYCOUNT:
			jFrameMain.showMyCount();
			break;
		case SHOW_ADDPRODUCT:
			jFrameMain.showPanelAddProduct();
			break;
		case SHOW_PRODUCT:
			jFrameMain.showPanelCardProduct();
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
		case ACTION_SINGIN:
			if (jDialogAddUser.isVisible() && this.createUser() != null) {
				this.sendData(Commands.SIGNIN, this.createUser());
			} else {
				Utilities.showMessageWarning("Por favor complete todos los campos correctamente!", "Datos no validos o vacios!");
			}
			break;
		}
	}

	private void addProduct() {
		this.jPanelMainWindow = new JPanelMainWindow("Computador LG", "Publico", "No inicida", "7;80", "/images/lg.jpg",
				this);

	}

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
	 * En proceso
	 * 
	 * @return
	 */
	private User createUser() {
		return Manager.getInstanceOf().createUser(jDialogAddUser.getjPanelForm().getFirstName(),
				jDialogAddUser.getjPanelForm().getLastName(), jDialogAddUser.getjPanelForm().getEmail(),
				jDialogAddUser.getjPanelForm().getPassword(),
				jDialogAddUser.getjPanelForm().getBirthDate(),
				jDialogAddUser.getjPanelForm().getDocument(), jDialogAddUser.getjPanelForm().getTypeDocument(),
				jDialogAddUser.getjPanelForm().getGender(), null);
	}
	
//	private void createBidding() {
//	Product p = new Product(, description);
//	Manager.getInstanceOf().addBidding(biddingName, typeProduct, product, publicationTime,
//			initTime, finishTime, isAutomaticIncremet, isPublic);
//}

	public static UserController getInstanceOf() {
		if (controller == null) {
			controller = new UserController();
		}
		return controller;
	}
	
	
	/**
	 * Metodo para mandar un array de string al panel de comentarios
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

	private void selectImagge() throws DOMException, TransformerFactoryConfigurationError,
			ParserConfigurationException, TransformerException {
		JFileChooser ventanaG = new JFileChooser();
		ventanaG.showSaveDialog(null);
		if (ventanaG.getSelectedFile() != null) {
			// se debe guardar la imagen
		}

	}

}
