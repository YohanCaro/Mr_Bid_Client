package com.prg3.mr_bid.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.prg3.mr_bid.view.JFrameMain;

public class UserController implements ActionListener {

	private JFrameMain jFrameMain;

	public UserController() {
		this.jFrameMain = new JFrameMain(this);
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

		default:
			break;
		}

	}

}
