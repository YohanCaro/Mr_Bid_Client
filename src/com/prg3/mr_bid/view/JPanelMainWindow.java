package com.prg3.mr_bid.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.prg3.mr_bid.controller.UserController;
import com.prg3.mr_bid.model.entity.Bidding;
import com.prg3.mr_bid.utilities.Constants;
import com.prg3.mr_bid.utilities.ConstantsView;
import com.prg3.mr_bid.utilities.Utilities;

/**
 * Clase JPanelMainWindow - SE encarag de crear y unir el panel
 * principal de lavista
 *
 * @version 1.0 - 4/08/2019
 * @author Daniel García
 */
public class JPanelMainWindow extends JPanel {

	/**
	 * Serial por defecto
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel jPanelNorth, jPanelSouth, jPanelWest, jPanelEast, jPanelCenter, jPanelMainImage, jPanelEspacio;
	private JPanelCard jPanelMainWindowProduct;
	private JLabel jLabel;
	private ImageIcon imageIcon;
	private JScrollPane jScrollPane;
	private String names;
	private Icon icon;

	/**
	 * Constructor que crea los paneles del panel
	 * @param controller controlador
	 */
	public JPanelMainWindow(UserController controller) {
		this.jPanelMainWindowProduct = new JPanelCard();
		this.jPanelNorth = new JPanel();
		this.jPanelSouth = new JPanel();
		this.jPanelWest = new JPanel();
		this.jPanelEast = new JPanel();
		this.jPanelCenter = new JPanel();
		this.jPanelMainImage = new JPanel();
		this.jPanelEspacio = new JPanel();
		this.jScrollPane = new JScrollPane();
		this.jLabel = new JLabel();
		character();
		sizePanel();
		jPanelImage();
		init(controller);
	}
	
	/**
	 * Repinta
	 */
	public void repaints() {
		this.repaint();
	}
	
	/**
	 * Constructor que resive datos de los estados del producto
	 * @param name nombre
	 * @param type tipo
	 * @param staut esatdo
	 * @param time tiempo
	 * @param url path
	 * @param control controlador
	 */
	public JPanelMainWindow(String name, String type, String staut, String time, String url, UserController control) {
		addNewProduct(name, type, staut, time, url, control);
		names = name;
	}
	
	/**
	 * Obtiene los nombres
	 * @return names n
	 */
	public String getNames() {
		return names;
	}

	/**
	 * Coloca los panesle de las imagenes
	 */
	private void character() {
		jPanelNorth.setBackground(Color.RED);
		jPanelCenter.setBackground(Color.black);
		jPanelEspacio.setBackground(Color.WHITE);
	}

	/**
	 * Crea la imagen de la publicidad
	 */
	private void jPanelImage() {
		imageIcon = new ImageIcon(ConstantsView.PATH_PUBLI_IMG);
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(1150, 300, Image.SCALE_AREA_AVERAGING));
		jLabel.setIcon(icon);
		jPanelMainImage.add(jLabel);
	}

	/**
	 * Le da tamaño a los paneles
	 */
	private void sizePanel() {
		jPanelWest.setPreferredSize(Utilities.setDimension(100, 0));
		jPanelEast.setPreferredSize(Utilities.setDimension(100, 0));
		jPanelNorth.setPreferredSize(Utilities.setDimension(0, 100));
		jPanelMainImage.setPreferredSize(Utilities.setDimension(0, 300));
		jPanelCenter.setPreferredSize(Utilities.setDimension(0, 1000));
		jPanelMainWindowProduct.setPreferredSize(Utilities.setDimension(0, 500));
	}

	/**
	 * Añade un nuevo producto a los paneles
	 * @param name nombre
	 * @param type tipo
	 * @param staut estado
	 * @param time tiempo
	 * @param url path
	 * @param control controlador
	 * @return jPanelMainWindowProduct nuevo panel
	 */
	public JPanelCard addNewProduct(String name, String type, String staut, String time, String url, UserController control) {
		return jPanelMainWindowProduct = new JPanelCard(name, type, staut, time, url,control);
	}

	/**
	 * Inicializa los componentes del panel
	 * @param control controlador
	 */
	private void init(UserController control) {
		this.setLayout(new BorderLayout());
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());

		jPanelCenter.setLayout(new BorderLayout());
		jScrollPane.setViewportView(jPanelEspacio);

		jPanelCenter.add(jPanelMainImage, BorderLayout.NORTH);
		jPanelCenter.add(jScrollPane, BorderLayout.CENTER);

		jPanelEspacio.setLayout(new GridLayout(0, 1));
		
		this.addAllCards(control);
		
		this.add(jPanelSouth, BorderLayout.SOUTH);
		this.add(jPanelWest, BorderLayout.WEST);
		this.add(jPanelEast, BorderLayout.EAST);
		this.add(jPanelCenter, BorderLayout.CENTER);
	}
	
	/**
	 * Añade en una tarjeta las subasta realizadas
	 * @param control controlador
	 */
	public void addAllCards(UserController control) {
		for (int i = 0; i < Constants.biddingsList.size(); i++) {
			jPanelEspacio.add(new JPanelCard(Constants.biddingsList.get(i),control));
		}		
	}
	
	/**
	 * Añade una tarjeta de una subasta
	 * @param bid subasta
	 * @param control controlador
	 */
	public void addCard(Bidding bid, UserController control) {
		if (bid != null) {
			jPanelEspacio.add(new JPanelCard(bid, control));
			jPanelEspacio.repaint();
		}
		this.init(control);
		this.repaint();
	}
	
	/**
	 * Obtiene el panel del productO
	 * @return jPanelMainWindowProduct panel
	 */
	public JPanelCard getjPanelMainWindowProduct() {
		return jPanelMainWindowProduct;
	}

}
