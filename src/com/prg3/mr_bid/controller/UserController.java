package com.prg3.mr_bid.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import com.prg3.mr_bid.communication.Client;
import com.prg3.mr_bid.communication.Commands;
import com.prg3.mr_bid.model.entity.BidDate;
import com.prg3.mr_bid.model.entity.User;
import com.prg3.mr_bid.model.manager.Manager;
import com.prg3.mr_bid.view.JDialogAddCreditCard;
import com.prg3.mr_bid.view.JDialogAddUser;
import com.prg3.mr_bid.view.JFrameMain;

public class UserController implements ActionListener {

	private JFrameMain jFrameMain;
	private JDialogAddUser jDialogAddUser;
	private JDialogAddCreditCard jDialogAddCreditCard;
	private static UserController controller;

	public UserController() {
		this.jFrameMain = new JFrameMain(this);
		this.jDialogAddUser = new JDialogAddUser(this);
		this.jDialogAddCreditCard = new JDialogAddCreditCard();
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

		}
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
	 * @return
	 */
//	private User createUser() {
//		return Manager.getInstanceOf().createUser(jDialogAddUser.getjPanelForm().getFirstName(),
//				jDialogAddUser.getjPanelForm().getLastName(), jDialogAddUser.getjPanelForm().getEmail(),
//				jDialogAddUser.getjPanelForm().getPassword(), new BidDate(jDialogAddUser.getjPanelForm().getBirthDate()),
//				jDialogAddUser.getjPanelForm()., null);
//	}
	
	public static UserController getInstanceOf() {
		if (controller == null) {
			controller = new UserController();
		}
		return controller;
	}

}
