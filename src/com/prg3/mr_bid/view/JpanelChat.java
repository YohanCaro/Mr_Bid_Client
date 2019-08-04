package com.prg3.mr_bid.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.prg3.mr_bid.communication.Client;
import com.prg3.mr_bid.controller.ControlCommands;
import com.prg3.mr_bid.model.manager.Manager;
import com.prg3.mr_bid.structures.simple_list.SimpleList;
import com.prg3.mr_bid.utilities.Constants;

/**
 * Clase JpanelChat - Crea el panel de la zona de comentarios de las subastas
 *
 * @version 1.0 - 4/08/2019
 * @author Daniel García
 */
public class JpanelChat extends JPanel implements ActionListener {

	private JButton jButton;
	private JTextField jTextField;
	private JTextArea jTextArea;
	private Manager manager;
	private String username, address;
	private SimpleList<String> users;
	private Boolean isConnected;
	private Socket sock;
	private BufferedReader reader;
	private PrintWriter writer;

	/**
	 * Constructor que crea los componentes del chat
	 */
	public JpanelChat() {
		jButton = new JButton("SEND");
		jButton.setActionCommand(ControlCommands.C_CONECT_CHAT.name());
		jButton.addActionListener(this);
		
		users = new SimpleList<>();
		isConnected = false;

		jTextField = new JTextField("Escriba su mensaje");
		jTextArea = new JTextArea();
		init();
	}

	/**
	 * Inicializa un hilo
	 */
	public void listenThread() {
		Thread IncomingReader = new Thread(new IncomingReader());
		IncomingReader.start();
	}

	/**
	 * Agrega un usuario al chat
	 * @param data dato
	 */
	public void userAdd(String data) {
		users.add(data);
	}

	/**
	 * Remueve un usuario 
	 * @param data dato
	 */
	public void userRemove(String data) {
		jTextArea.append(data + " is now offline.\n");
	}

	/**
	 * Escribe los usuarios
	 */
	public void writeUsers() {
		String[] tempList = new String[(users.size())];
//		users.toArray(tempList);
		for (String token : tempList) {
			// users.append(token + "\n");
		}
	}

	/**
	 * Enevia mesaje de desconexión
	 * @throws UnknownHostException no host
	 * @throws IOException io e
	 */
	public void sendDisconnect() throws UnknownHostException, IOException {
		String bye = (Client.getInstanceOf().getUser().getFirstName() + ": :Disconnect");
		try {
			writer.println(bye);
			writer.flush();
		} catch (Exception e) {
			jTextArea.append("Could not send Disconnect message.\n");
		}
	}

	/**
	 * Desconecta
	 */
	public void Disconnect() {
		try {
			jTextArea.append("Disconnected.\n");
			sock.close();
		} catch (Exception ex) {
			jTextArea.append("Failed to disconnect. \n");
		}
		isConnected = false;
		// tf_username.setEditable(true);

	}

	/**
	 * Clase IncomingReader - Clase envoltoria
	 *
	 * @version 1.0 - 4/08/2019
	 * @author Daniel García
	 */
	public class IncomingReader implements Runnable {
		@Override
		public void run() {
			String[] data;
			String stream, done = "Done", connect = "Connect", disconnect = "Disconnect", chat = "Chat";

			try {
				while ((stream = reader.readLine()) != null) {
					data = stream.split(":");

					if (data[2].equals(chat)) {
						jTextArea.append(data[0] + ": " + data[1] + "\n");
						jTextArea.setCaretPosition(jTextArea.getDocument().getLength());
					} else if (data[2].equals(connect)) {
						jTextArea.removeAll();
						userAdd(data[0]);
					} else if (data[2].equals(disconnect)) {
						userRemove(data[0]);
					} else if (data[2].equals(done)) {
						// users.setText("");
						writeUsers();
//						users.clear();
					}
				}
			} catch (Exception ex) {
			}
		}
	}

	/**
	 * Acción de conectar
	 */
	private void bConnectActionPerformed() {// GEN-FIRST:event_b_connectActionPerformed
		if (isConnected == false) {
			try {
				sock = new Socket(Constants.ip, 2222);// debe ser el puesto y la ip del servidor
				InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
				reader = new BufferedReader(streamreader);
				writer = new PrintWriter(sock.getOutputStream());
				writer.println(Client.getInstanceOf().getUser().getFirstName() + ":has connected.:Connect");
				writer.flush();
				isConnected = true;
			} catch (Exception ex) {
				jTextArea.append("Cannot Connect! Try Again. \n");
			}

			listenThread();
		} else if (isConnected == true) {
			jTextArea.append("You are already connected. \n");
		}
	}

	/**
	 * Acción de enviar
	 */
	private void bSendActionPerformed() {
		String nothing = "";
		if ((jTextField.getText()).equals(nothing)) {
			jTextField.setText("");
			jTextField.requestFocus();
		} else {
			try {
				writer.println(
						Client.getInstanceOf().getUser().getFirstName() + ":" + jTextField.getText() + ":" + "Chat");
				writer.flush(); // flushes the jTextField
			} catch (Exception ex) {
				jTextArea.append("Message was not sent. \n");
			}
			jTextField.setText("");
			jTextField.requestFocus();
		}

		jTextField.setText("");
		jTextField.requestFocus();
	}

	/**
	 * Acción de iniciar
	 */
	public void init() {
		manager = new Manager();
		this.setLayout(null);
		this.setBackground(Color.RED);
		jTextField.setBounds(20, 370, 300, 30);
		jTextArea.setBounds(20, 20, 490, 320);
		jButton.setBounds(400, 370, 100, 30);
		this.add(jButton);
		this.add(jTextField);
		this.add(jTextArea);
		bConnectActionPerformed();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		String[] com = command.split(",");

		switch (ControlCommands.valueOf(com[0])) {
		case C_CONECT_CHAT:
			bSendActionPerformed();
			break;
		default:
			break;
		}
	}

}
