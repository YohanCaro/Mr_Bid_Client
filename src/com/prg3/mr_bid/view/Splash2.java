package com.prg3.mr_bid.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeoutException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import com.prg3.mr_bid.communication.Client;
import com.prg3.mr_bid.controller.UserController;

/**
 * Clase Splash2 - Primera ventana de la aplición, carga cuando se conecta con el servidor y 
 * mientras carag la ventana principal
 *
 * @author Yohan Caro
 * @version 1.0 - 2/06/2019
 */
public class Splash2 extends JDialog {

	private JLabel jLabelSplash;
	private JProgressBar jProgressBar;
	private JLabel porcentaje1;
	private JLabel porcentaje2;
	private JLabel conectText;
	ImageIcon imageIcon;
	Icon icon;

	/**
	 * Constructor que crea el Splash
	 */
	public Splash2() {
		init();
		setSize(700, 600);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(0, 0, 0, 94));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(null);
		setVisible(true);
		initThread();
	}

	/**
	 * Hilo de la barra de progreso
	 */
	private void initThread() {
		Thread thread = new Thread(new Runnable() {
			int x = 0;
			boolean isConect = false;
			@Override
			public void run() {
				Random rnd = new Random();
				try {
					while (x <= 100) {
						while (!isConect) {
							try {
								Thread.sleep(3000);
								x = 1;
								Client.getInstanceOf().initClient();
								this.isConect = true;
							} catch (IOException e) {
								if (x > 0) {
									conectText.setText("Reintentando...!");
								}
							}
						}
						jProgressBar.setValue(x);
						conectText.setText("Conexión exitosa!");
						porcentaje1.setText("  " + x + "%");
						x += rnd.nextInt(5);
						Thread.sleep(70*rnd.nextInt(7));
					}
					if (isConect) {
						dispose();
						UserController.getInstanceOf();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		thread.start();
	}

	/**
	 * Inicia los componentes de la ventana del splash
	 */
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
		
		conectText = new JLabel("Conectando con el servidor!");
		conectText.setForeground(new Color(255, 255, 255));
		conectText.setFont(new Font("Tahoma", 1, 15));
		conectText.setBounds(20, 20, 200, 14);
		this.add(conectText);

	}

}
