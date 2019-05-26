package com.prg3.mr_bid.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.prg3.mr_bid.view.JDialogAddCreditCard;
import com.prg3.mr_bid.view.JDialogAddUser;
import com.prg3.mr_bid.view.JFrameMain;

public class UserController implements ActionListener {

	private JFrameMain jFrameMain;
	private JDialogAddUser jDialogAddUser;
	private JDialogAddCreditCard jDialogAddCreditCard;

	public UserController() {
		this.jFrameMain = new JFrameMain(this);
		this.jDialogAddUser = new JDialogAddUser(this);
		this.jDialogAddCreditCard = new JDialogAddCreditCard();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Commands.valueOf(e.getActionCommand())) {
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

		default:
			break;
		}

	}

}
