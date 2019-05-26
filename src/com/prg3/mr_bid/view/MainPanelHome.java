
package com.prg3.mr_bid.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.prg3.mr_bid.controller.UserController;


public class MainPanelHome extends JPanel{
	private JPanelMainWindow jPanelPrincipal;

    public MainPanelHome(UserController control) {
    	jPanelPrincipal = new JPanelMainWindow(control);
    	this.setLayout(new BorderLayout());
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.add(jPanelPrincipal, BorderLayout.CENTER);
    }
    
}
