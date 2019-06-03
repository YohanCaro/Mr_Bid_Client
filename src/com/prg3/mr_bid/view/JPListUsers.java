package com.prg3.mr_bid.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import com.prg3.mr_bid.controller.UserController;
public class JPListUsers extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<String> list;
	private JList<String> jListUsersConnected;
	private DefaultListModel<String> defaultListModel;
	public JPListUsers( UserController controllerApp ) {
		setLayout( new BorderLayout());
		initComponents( controllerApp );
	}

	private void initComponents(UserController controllerApp){
		JPanel jPConnectedUsers = new JPanel(new BorderLayout());
		add(jPConnectedUsers, BorderLayout.CENTER);

		JLabel jLConnectedUsers = new JLabel("Usuarios Conectados");
		jLConnectedUsers.setFont(new Font("Comic Sans Ms", Font.BOLD, 15));
		jPConnectedUsers.add(jLConnectedUsers, BorderLayout.WEST);

		defaultListModel = new DefaultListModel<>();
		jListUsersConnected = new JList(defaultListModel);
		jListUsersConnected.setPreferredSize(new Dimension(100, this.getHeight()));
		jListUsersConnected.addMouseListener(controllerApp);

		JScrollPane jsp2 = new JScrollPane(jListUsersConnected);
		JScrollBar bar2 = new JScrollBar(JScrollBar.VERTICAL);
		bar2.setForeground(Color.red);
		jsp2.setVerticalScrollBar(bar2);
		jPConnectedUsers.add(jsp2, BorderLayout.EAST);

	}

	/*
        RETORNA EL NUMERO DE USUARIOS CONECTADOS 
        */
	public int getSizeListModel(){
		return defaultListModel.size();
	}
	/*
        ACTUALIZA LOS USUARIOS CONECTADOS 
        */
	public void refreshUsersConnected(){
		defaultListModel.clear();		
	}
	/*
        ADICIONA UN USUARIO A LA LISTA 
        */
	public void addUserToList(String userName) {
		defaultListModel.addElement(userName);
	}
	
        /*
        SELECCIONA O CAPTURA EL USUARIO AL QUE SE LE VA A ENVIAR UN MENSAJE 
        */
	public String getHostSelected(){
		return jListUsersConnected.getSelectedValue();
	}
}
