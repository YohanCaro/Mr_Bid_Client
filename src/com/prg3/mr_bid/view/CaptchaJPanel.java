package com.prg3.mr_bid.view;

import java.awt.Graphics;

import javax.swing.JPanel;

import com.prg3.mr_bid.model.entity.MyCaptcha;

/**
 * Clase CaptchaJPanel - Crea el captcha
 *
 * @version 1.0 - 13/06/2019
 * @author Daniel García
 */
public class CaptchaJPanel extends JPanel {
	
	/**
	 * Serial por defecto
	 */
	private static final long serialVersionUID = 1L;
	
	private MyCaptcha captcha;
	
	/**
	 * Constructor con un captcha que llega
	 * @param captcha
	 */
	public CaptchaJPanel(MyCaptcha captcha) {
		this.captcha = captcha;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(captcha.getImage(), 10, 10, this);
	}
}

