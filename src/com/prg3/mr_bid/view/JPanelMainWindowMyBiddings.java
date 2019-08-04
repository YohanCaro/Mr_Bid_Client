package com.prg3.mr_bid.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.prg3.mr_bid.utilities.ConstantsView;
import com.prg3.mr_bid.utilities.Utilities;

/**
 * Clase JPanelMainWindowMisSubastas - Se encarga de crear el panel donde
 * estan las obciones de las subastas
 *
 * @version 1.0 - 4/08/2019
 * @author BidTeam
 */
public class JPanelMainWindowMyBiddings extends JPanel {

	/**
	 * Serial por defecto
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel jPanelNorth, jPanelNorth2, jPanelSouth, jPanelSouth2, jPanelWest, jPanelEast, jPanelCenter,
			jPanelMainImage, jPanelTools, jPanelPhoto;
//	private JPanelOptionMenu jPanelOptionMenu;
	private JLabel jLabel, jLabelMisSubastas, jLabelParticipaciones;
	private ImageIcon imageIcon;
	private Icon icon;
//	private JLabel jLabelName;
//	private JButton jButton, jButton2, jButton3, jButton4, jButton5;
	private JTextArea jTextAreaMyBid, jTextAreaParticiped;
//	private JScrollPane jScrollPane, jScrollPane2;

	/**
	 * Constructor que inica los componentes del panel
	 */
	public JPanelMainWindowMyBiddings() {
		this.setOpaque(false);
		this.jPanelNorth = new JPanel();
		this.jPanelNorth2 = new JPanel();
		this.jPanelSouth = new JPanel();
		this.jPanelSouth2 = new JPanel();
		this.jPanelWest = new JPanel();
		this.jPanelEast = new JPanel();
		this.jPanelCenter = new JPanel();
		this.jPanelMainImage = new JPanel();
		this.jPanelTools = new JPanel();
		this.jPanelPhoto = new JPanel();
		this.jLabel = new JLabel();
		panelPhoto();
		myjButton();
		character();
		sizePanel();
		jPanelImage();
		init();
	}

	/**
	 * Se encarga de organizar los paneles
	 */
	private void character() {
		jPanelNorth.setBackground(Color.WHITE);
		jPanelNorth.setOpaque(false);
		jPanelSouth.setBackground(Color.WHITE);
		jPanelSouth.setOpaque(false);

		jPanelWest.setBackground(Color.WHITE);
		jPanelWest.setOpaque(false);

		jPanelEast.setBackground(Color.WHITE);
		jPanelEast.setOpaque(false);
	}

	/**
	 * Se encarga de poner la imagen del usuario
	 */
	private void jPanelImage() {
		imageIcon = new ImageIcon(ConstantsView.PATH_USER_IMAGE);
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_AREA_AVERAGING));
		jLabel.setIcon(icon);
		jPanelMainImage.setOpaque(false);
		jPanelMainImage.add(jLabel);
	}

	/**
	 * Se encarag de darle el tamaño a los paneles
	 */
	private void sizePanel() {
		jPanelWest.setPreferredSize(Utilities.setDimension(100, 0));
		jPanelEast.setPreferredSize(Utilities.setDimension(100, 0));
		jPanelNorth.setPreferredSize(Utilities.setDimension(0, 100));
		jPanelSouth.setPreferredSize(Utilities.setDimension(0, 100));
		jPanelSouth2.setPreferredSize(Utilities.setDimension(0, 100));

		jPanelMainImage.setPreferredSize(Utilities.setDimension(0, 100));
		jPanelTools.setPreferredSize(Utilities.setDimension(300, 0));
		jPanelPhoto.setPreferredSize(Utilities.setDimension(550, 0));
		jPanelNorth2.setPreferredSize(Utilities.setDimension(100, 100));
	}

	/**
	 * Se encarga de poner los botones 
	 */
	private void myjButton() {
		createLabel(ConstantsView.TEXT_PARTICIPATIONS_BID_WD, 50, 20, jLabelParticipaciones,
				jPanelTools);
		jPanelTools.setLayout(null);
		jPanelTools.setBackground(ConstantsView.COLOR_COMPONENT_BID_WD);
		jPanelTools.setPreferredSize(Utilities.setDimension(300, 300));
		jTextAreaParticiped = new JTextArea(ConstantsView.TEXT_PARTICIPATIONS_BID_WD);
		jTextAreaParticiped.setEditable(false);
		jTextAreaParticiped.setBounds(50, 60, 450, 300);
		jPanelTools.add(jTextAreaParticiped);
	}

	/**
	 * Se encarag de poner el panel de la foto
	 */
	private void panelPhoto() {
		createLabel(ConstantsView.TEXT_BIDDINGS_BID_WID, 50, 20,
				jLabelMisSubastas, jPanelPhoto);
		jPanelPhoto.setBackground(Color.red);
		jPanelPhoto.setLayout(null);
		jPanelPhoto.setBackground(ConstantsView.COLOR_COMPONENT_BID_WD);
		jTextAreaMyBid = new JTextArea(ConstantsView.TEXT_BIDDINGS_BID_WID);
		jTextAreaMyBid.setEditable(false);
		jTextAreaMyBid.setBounds(50, 60, 450, 300);
		jPanelPhoto.add(jTextAreaMyBid);
	}

	/**
	 * Se encarga de crear un boton
	 * @param name nombre
	 * @param x pos x
	 * @param y pos y
	 * @param atribute valor
	 * @param url ruta
	 * @return
	 */
	public JButton createJbuton(String name, int x, int y, JButton atribute, String url) {
		atribute = new JButton(name);
		atribute.setForeground(ConstantsView.COLOR_ATRIBUTE_BACK_BID_WD);
		atribute.setBackground(ConstantsView.COLOR_ATRIBUTE_FORE_BID_WD);
		// atribute.setActionCommand(Commands.C_ENGLISH.name());
		// atribute.addActionListener(control);
		imageIcon = new ImageIcon(getClass().getResource(url));
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(70, 70, Image.SCALE_AREA_AVERAGING));
		atribute.setIcon(icon);
		return atribute;
	}

	/**
	 * Se encarag de inicializar los componentes del panel
	 */
	private void init() {
		this.setLayout(new BorderLayout());
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		jPanelCenter.setLayout(new BorderLayout());
		jPanelCenter.setOpaque(false);
		jPanelCenter.add(jPanelTools, BorderLayout.CENTER);
		jPanelCenter.add(jPanelPhoto, BorderLayout.WEST);

		this.add(jPanelNorth, BorderLayout.NORTH);
		this.add(jPanelSouth, BorderLayout.SOUTH);
		this.add(jPanelWest, BorderLayout.WEST);
		this.add(jPanelEast, BorderLayout.EAST);
		this.add(jPanelCenter, BorderLayout.CENTER);
	}

	/**
	 * Se encarga de crear un label con la siguiente información
	 * @param name nombre
	 * @param x pos x
	 * @param y pos y
	 * @param jLabel label
	 * @param jPanel panel
	 * @return jLabel label
	 */
	public JLabel createLabel(String name, int x, int y, JLabel jLabel, JPanel jPanel) {
		jLabel = new JLabel(name);
		jLabel.setBounds(x, y, 200, 50);
		jLabel.setBackground(ConstantsView.COLOR_ATRIBUTE_BACK_BID_WD);
		jLabel.setPreferredSize(Utilities.setDimension(200, 60));
		jPanel.add(jLabel);
		return jLabel;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		imageIcon = new ImageIcon(ConstantsView.PATH_BACK_IMG);
		g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paintComponent(g);
	}

}
