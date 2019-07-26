package com.prg3.mr_bid.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.prg3.mr_bid.communication.Client;
import com.prg3.mr_bid.controller.ControlCommands;
import com.prg3.mr_bid.model.entity.User;
import com.prg3.mr_bid.model.manager.Manager;
import com.prg3.mr_bid.utilities.Constants;

public class JpanelChat extends JPanel implements ActionListener {

	private JButton jButton;
	private JTextField jTextField;
	private JTextArea jTextArea;
	private Manager manager;
	String username, address;
	ArrayList<String> users = new ArrayList();
	// int port = 12345;
	Boolean isConnected = false;
	Socket sock;
	BufferedReader reader;
	PrintWriter writer;

	public JpanelChat() {
		jButton = new JButton("SEND");
		jButton.setActionCommand(ControlCommands.C_CONECT_CHAT.name());
		jButton.addActionListener(this);

		jTextField = new JTextField("Escriba su mensaje");
		jTextArea = new JTextArea();
		init();
	}

	public void ListenThread() {
		Thread IncomingReader = new Thread(new IncomingReader());
		IncomingReader.start();
	}

	public void userAdd(String data) {
		users.add(data);
	}

	public void userRemove(String data) {
		jTextArea.append(data + " is now offline.\n");
	}

	public void writeUsers() {
		String[] tempList = new String[(users.size())];
		users.toArray(tempList);
		for (String token : tempList) {
			// users.append(token + "\n");
		}
	}

	// --------------------------//

	public void sendDisconnect() throws UnknownHostException, IOException {
		String bye = (Client.getInstanceOf().getUser().getFirstName() + ": :Disconnect");
		try {
			writer.println(bye);
			writer.flush();
		} catch (Exception e) {
			jTextArea.append("Could not send Disconnect message.\n");
		}
	}

	// --------------------------//

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
						users.clear();
					}
				}
			} catch (Exception ex) {
			}
		}
	}

	private void b_connectActionPerformed() {// GEN-FIRST:event_b_connectActionPerformed
		if (isConnected == false) {
			System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
			System.out.println("la ip es " + Constants.port + "El ´puerto es " + Constants.ip);
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

			ListenThread();

		} else if (isConnected == true) {
			jTextArea.append("You are already connected. \n");
		}
	}

	private void b_sendActionPerformed() {
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
		b_connectActionPerformed();
		// this.setPreferredSize(new Dimension(100, 100));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		String[] com = command.split(",");

		switch (ControlCommands.valueOf(com[0])) {
		case C_CONECT_CHAT:
			System.out.println("jajajaja funciono");
			b_sendActionPerformed();

			break;

		default:
			break;
		}
	}

}
