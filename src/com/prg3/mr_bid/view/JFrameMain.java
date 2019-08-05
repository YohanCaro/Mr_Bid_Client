package com.prg3.mr_bid.view;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import com.prg3.mr_bid.controller.UserController;
import com.prg3.mr_bid.utilities.ConstantsView;

/**
 * Clase JFrameMain - CLASE QUE CONTIENE TODOS LOS PANELES DE LA VISTA y crea
 * la ventana principal de la aplicación
 *
 * @version 1.2 - 4/08/2019
 * @author Daniel García
 */
public class JFrameMain extends JFrame {

	/**
	 * Serial del panel
	 */
	private static final long serialVersionUID = -6364867265927971657L;
	
	private JScrollPane jScrollPane;
	private JPanelMainWindow jPanelMain;
	private JPanelPrincipalLogin jPanelPrincipalLogin;
	private JPanelOptionMenu jPanelOptionMenu;
	private JPanelMainWindowAccount jPanelMainWindowAccount;
	private JPanelMainAddProduct jPanelMainAddProduct;
	private MainPanelHome jMainPanelHome;
	private JPanelMainProduct jPanelMainProduct;
	private JPanelMainWindowMyBiddings jPanelMainWindowMyBiddings;
	private JPanelMainWindowProfile jPanelMainWindowProfile;


	/**
	 * Constructor que crea los paneles de la aplicación
	 * @param control controlador
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public JFrameMain(UserController control) throws UnknownHostException, IOException {
		this.jScrollPane = new JScrollPane();
		jScrollPane.setOpaque(false);
		this.jPanelMain = new JPanelMainWindow(control);
		this.jPanelPrincipalLogin = new JPanelPrincipalLogin(control);
		this.jMainPanelHome = new MainPanelHome(control);
		jMainPanelHome.setOpaque(false);
		this.jPanelOptionMenu = new JPanelOptionMenu(control);
		this.jPanelMainWindowAccount = new JPanelMainWindowAccount(control);
		this.jPanelMainAddProduct = new JPanelMainAddProduct(control);
		this.jPanelMainWindowMyBiddings = new JPanelMainWindowMyBiddings();
		this.jPanelMainWindowProfile = new JPanelMainWindowProfile();

		
		init();
	}

	/**
	 * Inicia y añade los componentes del frame
	 */
	private void init() {
		this.setResizable(true);
		this.setLayout(new BorderLayout());
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setTitle(ConstantsView.TITLE_APP);
		jScrollPane.setViewportView(jPanelMain);
		this.add(jScrollPane, BorderLayout.CENTER);
		this.add(jPanelOptionMenu, BorderLayout.NORTH);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Muestra el panel Home
	 */
	public void showHome() {
		jPanelMain.removeAll();
		jPanelMain.add(jMainPanelHome, BorderLayout.CENTER);
		repaint();
		revalidate();
	}
	
	/**
	 * Muestra el panel principal
	 * @param controller controlador
	 */
	public void showMain(UserController controller) {
		this.jPanelMain = new JPanelMainWindow(controller);
		jScrollPane.setViewportView(jPanelMain);
		jScrollPane.repaint();
		this.repaint();
	}

	/**
	 * Muestra el panel del login
	 */
	public void showLogin() {
		jPanelMain.removeAll();
		jPanelMain.add(jPanelPrincipalLogin, BorderLayout.CENTER);
		repaint();
		revalidate();
	}
	
	/**
	 * Muestra el panel de la cuenta del usuario
	 */
	public void showMyCount() {
		jPanelMain.removeAll();
		jPanelMain.add(jPanelMainWindowAccount, BorderLayout.CENTER);
		repaint();
		revalidate();
	}
	
	/**
	 * Muestra el panel para añadir producto
	 */
	public void showPanelAddProduct() {
		jPanelMain.removeAll();
		jPanelMain.add(jPanelMainAddProduct, BorderLayout.CENTER);
		revalidate();
	}
	
	/**
	 * Muestra los paneles de las tarjetas de los productos
	 */
	public void showPanelCardProduct() {
		jPanelMain.removeAll();
		jPanelMain.add(jPanelMainProduct, BorderLayout.CENTER);
		repaint();
		revalidate();
	}
	
	/**
	 * Muestra el panel de historias
	 */
	public void showMyHistory() {
		jPanelMain.removeAll();
		jPanelMain.add(jPanelMainWindowMyBiddings, BorderLayout.CENTER);
		repaint();
		revalidate();
	}
	public void showProfile() {
		jPanelMain.removeAll();
		jPanelMain.add(jPanelMainWindowProfile, BorderLayout.CENTER);
		repaint();
		revalidate();
	}
	
	/**
	 * Obtiene el panel del producto
	 * @return jPanelMainProduct panel
	 */
	public JPanelMainProduct getjPanelMainProduct() {
		return jPanelMainProduct;
	}
	
	/**
	 * Obtiene el panel del login
	 * @return jPanelPrincipalLogin panel
	 */
	public JPanelPrincipalLogin getjPanelPrincipalLogin() {
		return jPanelPrincipalLogin;
	}
	
	/**
	 * Cambia el lenguaje de los paneles de la aplicación
	 */
	public void changeLanguage() {
		jPanelOptionMenu.changeLanguage();
		jPanelMainWindowAccount.changeLanguage();
		jPanelMain.getjPanelMainWindowProduct().changeLanguage();
		if (jPanelMainProduct != null) {
			jPanelMainProduct.changeLanguage();
		}
		
		if (jPanelMainAddProduct != null) {
			jPanelMainAddProduct.changeLanguage();
		}
	}

	/**
	 * Cambia el panel de principal del producto
	 * @param jPanelMainProduct the jPanelMainProduct to set
	 */
	public void setjPanelMainProduct(JPanelMainProduct jPanelMainProduct) {
		this.jPanelMainProduct = jPanelMainProduct;
	}
	
	/**
	 * Obtiene el pandel de la ventana de cuenta de usuario
	 * @return jPanelMainWindowCuenta jpanel
	 */
	public JPanelMainWindowAccount getjPanelMainWindowCuenta() {
		return jPanelMainWindowAccount;
	}
	
	/**
	 * Obtiene el panel principal
	 * @return jPanelMain jpanel
	 */
	public JPanelMainWindow getjPanelMain() {
		return jPanelMain;
	}
	
	/**
	 * Cambia 
	 * @param jPanelMain a jPanelMain 
	 */
	public void setjPanelMain(JPanelMainWindow jPanelMain) {
		this.jPanelMain = jPanelMain;
	}
	
	/**
	 * Obtiene el panel de añadir productos de la app
	 * @return jPanelMainAddProduct jpanel
	 */
	public JPanelMainAddProduct getjPanelMainAddProduct() {
		return jPanelMainAddProduct;
	}
	
	/**
	 * Redibuja el panel principal
	 */
	public void getrepaint() {
		jPanelMain.repaints();
	}
	public JPanelMainWindowProfile getjPanelMainWindowProfile() {
		return jPanelMainWindowProfile;
	}
	
}
