
package com.prg3.mr_bid.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.prg3.mr_bid.controller.UserController;


public class MainPanelHome extends JPanel{
	private JPanelMainWindow jPanelPrincipal;

	ImageIcon imageIcon;
	Icon icon;
    public MainPanelHome(UserController control) {
    	jPanelPrincipal = new JPanelMainWindow(control);
    	this.setLayout(new BorderLayout());
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.add(jPanelPrincipal, BorderLayout.CENTER);
    }
    
	@Override
	protected void paintComponent(Graphics g) {
		imageIcon = new ImageIcon(getClass().getResource("/images/fondoLogin.jpg"));
		g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paintComponent(g);
	}
    
}
