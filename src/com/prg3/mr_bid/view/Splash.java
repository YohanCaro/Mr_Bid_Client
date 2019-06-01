package com.prg3.mr_bid.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import com.prg3.mr_bid.controller.UserController;


public class Splash extends JDialog {

	private JLabel jLabelSplash;
	private JProgressBar jProgressBar;
	private JLabel porcentaje1;
	private JLabel porcentaje2;
	ImageIcon imageIcon;
	Icon icon;

	public Splash() {
		init();
		setSize(700, 600);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(0, 0, 0, 94));
		this.setLayout(null);
		setVisible(true);
		initThread();
	}

	private void initThread() {
		Thread thread = new Thread(new Runnable() {

			int x = 0;

			@Override
			public void run() {
				try {
					while (x <= 100) {
						jProgressBar.setValue(x);
						porcentaje1.setText(x + "%");
						x += 2;
						Thread.sleep(50);
					}
						dispose();
						
						UserController.getInstanceOf();

				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		thread.start();
	}

	private void init() {
	
		jLabelSplash = new JLabel();
		jLabelSplash.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jLabelSplash.setBounds(0, 50, 700, 400);
		imageIcon = new ImageIcon("src/Images/logo.jpg");
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(jLabelSplash.getWidth(), jLabelSplash.getHeight(),
				Image.SCALE_AREA_AVERAGING));
		jLabelSplash.setIcon(icon);

		this.add(jLabelSplash);

		jProgressBar = new JProgressBar();
		jProgressBar.setBounds(0, 500, 700, 32);
		this.add(jProgressBar);

		porcentaje1 = new JLabel("0%");
		porcentaje1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		porcentaje1.setForeground(new Color(255, 255, 255));// blanco
		porcentaje1.setBounds(330, 480, 46, 14);
		this.add(porcentaje1);

	}

}
