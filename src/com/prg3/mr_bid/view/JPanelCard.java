package com.prg3.mr_bid.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.prg3.mr_bid.controller.ControlCommands;
import com.prg3.mr_bid.controller.UserController;
import com.prg3.mr_bid.model.entity.Bidding;
import com.prg3.mr_bid.model.entity.ConstantsBid;
import com.prg3.mr_bid.utilities.ConstantsView;
import com.prg3.mr_bid.utilities.HandlerLanguage;
import com.prg3.mr_bid.utilities.Utilities;

/**
 * Clase JPanelCard - Crea el panel con las tarjetas de cada subasta
 *
 * @version 1.3 - 4/08/2019
 * @author Bid Team
 */
public class JPanelCard extends JPanel {

	/**
	 * Serial por defecto
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel jPanelNorth, jPanelSouth, jPanelWest, jPanelEast, jPanelCenter, jPanelCenterEast, jPanelCenterWest,
			jpanelImageProduct, jPanelNameProduct, jPanelInfoProduct;
	private JLabel jLabelName, jLabelType, jLabelSatus, jLabelTime, jLabelType2, jLabelSatus2, jLabelTime2;
	private ImageIcon imageIcon;
	private Icon icon;
	private JButton jButton;

	/**
	 * Constructor vacio
	 */
	public JPanelCard() {

	}

	/**
	 * Constructor que crea una trajeta con
	 * @param name nombre
	 * @param type tipo
	 * @param staut stado
	 * @param time tiempo 
	 * @param url path
	 * @param controller controlador
	 */
	public JPanelCard(String name, String type, String staut, String time, String url, UserController controller) {
		this.jPanelNorth = new JPanel();
		this.jPanelSouth = new JPanel();
		this.jPanelWest = new JPanel();
		this.jPanelEast = new JPanel();
		this.jPanelCenter = new JPanel();
		this.jPanelCenterWest = new JPanel();
		this.jPanelCenterEast = new JPanel();
		this.jpanelImageProduct = new JPanel();
		this.jPanelNameProduct = new JPanel();
		this.jPanelInfoProduct = new JPanel();
		informacion(name, type, staut, time,controller);
		character();
		sizePanel();
		init();
		changeLanguage();
	}
	
	/**
	 * Constructor que crea unatarjeta con
	 * @param bid subasta
	 * @param controller controlador
	 */
	public JPanelCard(Bidding bid, UserController controller) {
		this.jPanelNorth = new JPanel();
		this.jPanelSouth = new JPanel();
		this.jPanelWest = new JPanel();
		this.jPanelEast = new JPanel();
		this.jPanelCenter = new JPanel();
		this.jPanelCenterWest = new JPanel();
		this.jPanelCenterEast = new JPanel();
		this.jpanelImageProduct = new JPanel();
		this.jPanelNameProduct = new JPanel();
		this.jPanelInfoProduct = new JPanel();
		changeData(bid, controller);
		character();
		sizePanel();
		myJButton(bid.getProduct().getImages(), bid.getId());
		init();
		this.repaint();
	}

	/**
	 * Colorea los paneles de las tarjetas
	 */
	private void character() {
		jPanelNorth.setBackground(Color.WHITE);
		jPanelSouth.setBackground(Color.WHITE);
		jPanelWest.setBackground(Color.WHITE);
		jPanelEast.setBackground(Color.WHITE);
		jPanelCenter.setOpaque(false);
		jPanelCenterWest.setBackground(Color.GRAY);
		jPanelCenterEast.setBackground(Color.BLUE);

		jPanelNameProduct.setBackground(Color.GRAY);
		jPanelInfoProduct.setBackground(Color.LIGHT_GRAY);
	}

	/**
	 * Crea un botón para acceder a la información de la subasta
	 * @param url path
	 * @param id identificador
	 * @return button b
	 */
	private JButton myJButton(String url,long  id) {
		jButton = new JButton(String.valueOf(id));		 
		jButton.setBounds(0, 0, 200, 200);
		jButton.setBackground(ConstantsView.COLOR_BACK_PC);
		jButton.setForeground(ConstantsView.COLOR_FORE_PC);
		imageIcon = new ImageIcon(url);
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(100, 100,Image.SCALE_AREA_AVERAGING));
		jButton.setIcon(icon);
		this.add(jButton);
		return jButton;
	}

	/**
	 * Le da tamaño a los paneles
	 */
	private void sizePanel() {
		jPanelCenterWest.setPreferredSize(Utilities.setDimension(400, 0)); //500
		jPanelCenterEast.setPreferredSize(Utilities.setDimension(700, 0)); //700
		jPanelNameProduct.setPreferredSize(Utilities.setDimension(250, 0)); //300
		jPanelInfoProduct.setPreferredSize(Utilities.setDimension(250, 0)); //300

	}

	/**
	 * Crea los componentes de la información de la subasta
	 * @param name nombre
	 * @param type tipo
	 * @param status estado
	 * @param time tiempo
	 * @param control controlador
	 */
	private void informacion(String name, String type, String status, String time, UserController control) {
		jLabelType = new JLabel("Tipo");
		jLabelType.setFont(ConstantsView.FONT_PC_1);
		jLabelType.setBounds(10, 20, 130, 50);
		jLabelType.setBackground(ConstantsView.COLOR__FORE_WD);
		jLabelType.setPreferredSize(Utilities.setDimension(250, 60));
		jPanelInfoProduct.add(jLabelType);
	}
	
	/**
	 * Cambia los datos de la tarjeta
	 * @param b subasta
	 * @param control controller
	 */
	public void changeData(Bidding b, UserController control) {
		jPanelNameProduct.add(createLabel(b.getBiddingName(), 10, 100, jLabelName, 30, 400));
		
		jLabelType = new JLabel(HandlerLanguage.languageProperties.getProperty(ConstantsBid.T_KIND));
		jLabelType.setFont(ConstantsView.FONT_PC_1);
		jLabelType.setBounds(10, 20, 130, 50);
		jLabelType.setBackground(ConstantsView.COLOR__FORE_WD);
		jLabelType.setPreferredSize(Utilities.setDimension(200, 60));
		jPanelInfoProduct.add(jLabelType);
	
		jPanelInfoProduct.add(createLabel(ConstantsView.TEXT_STATE_PC, 10, 70, jLabelSatus, 20, 130));
		jPanelInfoProduct.add(createLabel(ConstantsView.TEXT_TIME_REAMING_PC, 10, 120, jLabelTime, 20, 400));
		
		jPanelInfoProduct.add(createLabel(b.getTypeProduct().name(), 200, 20, jLabelType2, 20, 130));
		jPanelInfoProduct.add(createLabel(Utilities.getState(b).toString(), 200, 70, jLabelSatus2, 20, 130));
		jPanelInfoProduct.add(createLabel(Utilities.getTimeRemaining(b), 220, 120, jLabelTime2, 20, 180));
		
		jButton = new JButton(ConstantsView.BT_OK_PC);
		jButton.setBounds(150, 200, 100, 30);
		jButton.setActionCommand(ControlCommands.SHOW_PRODUCT.name() + "," + b.getId());
		jButton.addActionListener(control);
		jPanelInfoProduct.add(jButton);
	}

	/**
	 * Inicializa los componentes de la tarjeta
	 */
	private void init() {
		this.setLayout(new BorderLayout());
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setPreferredSize(Utilities.setDimension(1200, 250));

		jPanelInfoProduct.setLayout(null);
		jPanelNameProduct.setLayout(null);

		jPanelCenterEast.setLayout(new BorderLayout());
		jPanelCenterEast.add(jPanelNameProduct, BorderLayout.WEST);
		jPanelCenterEast.add(jPanelInfoProduct, BorderLayout.CENTER);

		jPanelCenter.setLayout(new BorderLayout());
		jPanelCenter.add(jpanelImageProduct, BorderLayout.CENTER);
		jPanelCenter.add(jPanelCenterEast, BorderLayout.EAST);

		this.add(jPanelNorth, BorderLayout.NORTH);
		this.add(jPanelSouth, BorderLayout.SOUTH);
		this.add(jPanelWest, BorderLayout.WEST);
		this.add(jPanelEast, BorderLayout.EAST);
		this.add(jPanelCenter, BorderLayout.CENTER);
	}

	/**
	 * Crea un jlabel con:
	 * @param name nombre 
	 * @param x posX
	 * @param y posY
	 * @param jLabel label
	 * @param size tamaño
	 * @param sizeCamp tamaño de campo
	 * @return jalabel label
	 */
	public JLabel createLabel(String name, int x, int y, JLabel jLabel, int size, int sizeCamp) {
		jLabel = new JLabel(name);
		jLabel.setFont(ConstantsView.FONT_PC_1);
		jLabel.setBounds(x, y, sizeCamp, 50);
		jLabel.setBackground(ConstantsView.COLOR__FORE_WD);
		jLabel.setPreferredSize(Utilities.setDimension(200, 60));
		add(jLabel);
		return jLabel;
	}
	
	/**
	 * Cambia el idioma
	 */
	public void changeLanguage() {

	}

}
