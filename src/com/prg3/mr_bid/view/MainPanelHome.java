package com.prg3.mr_bid.view;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.prg3.mr_bid.controller.UserController;
import com.prg3.mr_bid.utilities.ConstantsView;

/**
 * Clase MainPanelHome - Crea el panel donde estan las cartas de las subastas que 
 * se hacen (fonfo de la ventana principal
 *
 * @version 1.1 - 4/08/2019
 * @author Bid Team
 */
public class MainPanelHome extends JPanel {
	
	/**
	 * Serial por defecto
	 */
	private static final long serialVersionUID = 1L;

	private JPanelMainWindow jPanelPrincipal;
	private ImageIcon imageIcon;
	
	/**
	 * Constructor que inical el panel
	 * @param control controlador
	 */
    public MainPanelHome(UserController control) {
    	this.jPanelPrincipal = new JPanelMainWindow(control);
    	this.setLayout(new BorderLayout());
		this.add(jPanelPrincipal, BorderLayout.CENTER);
    }
    
	@Override
	protected void paintComponent(Graphics g) {
		imageIcon = new ImageIcon(ConstantsView.PATH_JPRINCIPAL_BACK_IMG);
		g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paintComponent(g);
	}
    
}
