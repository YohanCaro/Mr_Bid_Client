package com.prg3.mr_bid.model.entity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Random;

public class MyCaptcha {

	private final static byte CAPTCHA_LENGTH = 7;
	private final static int WIDTH = 250;
	private final static int HEIGTH = 60;
	
	private BufferedImage image;
	private String message;
	private int id;
	
	public MyCaptcha() {
		message = "";
	}
	
	public void create() {
		Random rnd = new Random();
		this.id = rnd.nextInt(1000);
		
		for (int i = 0; i < CAPTCHA_LENGTH; i++) {
			message += (char)(65 + rnd.nextInt(26));
		}
		
		this.image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = image.createGraphics();
		for (int i = 0; i < message.length(); i++) {
			g2d.setColor(Color.WHITE);
			g2d.setFont(new Font("Arial", 1, 14));
			g2d.drawString(""+ message.charAt(i), i*25, 20);
			g2d.fillOval(i*25, 17, 5, 5);	 
	        AffineTransform at = new AffineTransform();
	        at.rotate(Math.toRadians(15), 20, 100); //se asigna el angulo y centro de rotacion
	        g2d.setTransform(at);
			
			g2d.setColor(Color.lightGray);
			g2d.drawArc(i*30, i*3, 100, 110, 10, 150);
			g2d.drawLine(i, i*10, i*100, i*10);
		}
		
	}
	
	//Validar captcha
	
	public String getMessage() {
		return message;
	}
	
	public int getId() {
		return id;
	}
	
	public BufferedImage getImage() {
		return image;
	}
}
