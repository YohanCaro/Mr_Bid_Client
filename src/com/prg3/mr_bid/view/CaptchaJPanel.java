package com.prg3.mr_bid.view;

import java.awt.Graphics;

import javax.swing.JPanel;

import com.prg3.mr_bid.model.entity.MyCaptcha;

/**
 * clase que creal Captcha
 * @author Daniel Garcia
 * fecha 13/06/2019
 */
public class CaptchaJPanel extends JPanel {
	
	private MyCaptcha captcha;
	
	public CaptchaJPanel(MyCaptcha captcha) {
		this.captcha = captcha;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(captcha.getImage(), 10, 10, this);
	}
}

