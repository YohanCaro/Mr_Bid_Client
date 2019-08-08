package com.prg3.mr_bid.view;

import java.awt.Image;
import java.io.IOException;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import com.prg3.mr_bid.communication.Client;
import com.prg3.mr_bid.controller.UserController;
import com.prg3.mr_bid.utilities.ConstantsView;

/**
 * Clase Splash2 - Primera ventana de la aplición, carga cuando se conecta con el servidor y 
 * mientras carag la ventana principal
 *
 * @author Yohan Caro - Daniel García
 * @version 1.2 - 2/06/2019
 */
public class Splash extends JDialog {

	/**
	 * Serial por defecto
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel jLabelSplash;
	private JProgressBar jProgressBar;
	private JLabel porcentaje1;
	private JLabel conectText;
	private ImageIcon imageIcon;
	private Icon icon;

	/**
	 * Constructor que crea el Splash
	 */
	public Splash() {
		init();
		this.setSize(ConstantsView.SIZE_SPLASH);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(ConstantsView.COLOR_BACKGROUD_SPLASH);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		initThread();
	}

	/**
	 * Hilo de la barra de progreso
	 */
	private void initThread() {
		new Thread(new Runnable() {
			int x = 0;
			boolean isConect = false, iswait = false;
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
									conectText.setText(ConstantsView.TEXT_SPLASH_RESET);
								}
							}
						}
						jProgressBar.setValue(x);
						conectText.setText(ConstantsView.TEXT_SPLASH_CONNECT);
						porcentaje1.setText("  " + x + "%");
						x += rnd.nextInt(5);
						Thread.sleep(70*rnd.nextInt(7));
						repaint();
						if (isConect && x > 90 && !iswait) {
							UserController.getInstanceOf();
							iswait = true;
						}
					}
					dispose();
				} catch (Exception e) {
					dispose();
				}
			}
		}).start();
	}

	/**
	 * Inicia los componentes de la ventana del splash
	 */
	private void init() {
		jLabelSplash = new JLabel();
		jLabelSplash.setFont(ConstantsView.FONT_LABEL_SPLASH);
		jLabelSplash.setBounds(0, 50, 700, 400);
		imageIcon = new ImageIcon(ConstantsView.PATH_SPLASH_ICON_IMG);
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(jLabelSplash.getWidth(), jLabelSplash.getHeight(),
				Image.SCALE_AREA_AVERAGING));
		jLabelSplash.setIcon(icon);

		this.add(jLabelSplash);

		jProgressBar = new JProgressBar();
		jProgressBar.setBounds(0, 500, 700, 32);
		this.add(jProgressBar);

		porcentaje1 = new JLabel("0%");
		porcentaje1.setFont(ConstantsView.FONT_PERCENT_SPLASH);
		porcentaje1.setForeground(ConstantsView.COLOR_CONNECT_TEXT);// blanco
		porcentaje1.setBounds(330, 480, 46, 14);
		this.add(porcentaje1);
		
		conectText = new JLabel(ConstantsView.TEXT_SPLASH_CONNECT_INIT);
		conectText.setForeground(ConstantsView.COLOR_CONNECT_TEXT);
		conectText.setFont(ConstantsView.FONT_SPLASH);
		conectText.setBounds(20, 20, 200, 14);
		this.add(conectText);

	}

}
