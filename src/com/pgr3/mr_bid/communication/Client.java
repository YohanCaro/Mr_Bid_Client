package com.pgr3.mr_bid.communication;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.google.gson.Gson;
import com.pgr3.mr_bid.model.entity.Product;
import com.pgr3.mr_bid.model.entity.User;
import com.pgr3.mr_bid.utilities.Constants;

public class Client extends Socket implements Runnable {
	
	private DataInputStream dataIS;
	private DataOutputStream dataOS;
	private Gson gson;
	private boolean isConect;
	
	public Client() throws UnknownHostException, IOException {
		super(Constants.ip, Constants.port);
		dataIS = new DataInputStream(this.getInputStream());
		dataOS = new DataOutputStream(this.getOutputStream());
		gson = new Gson();
		this.isConect = true;
	}
	
	public void initClient() {
		new Thread(this).start();
	}

	@Override
	public void run() {
		Commands command;
		String jsonString;
		while (isConect) {
			try {
				command = gson.fromJson(this.dataIS.readUTF(), Commands.class);
				jsonString = this.dataIS.readUTF();
				this.excecuteAction(command, jsonString);
			} catch (IOException e) {
				isConect = false;
				e.printStackTrace();
			}
		}
	}
	
	private void excecuteAction(Commands command, String json) {
		switch (command) {
		case LOGIN:
			Constants.user = gson.fromJson(json, User.class);
			break;
		case SIGNIN: 
			Constants.product = gson.fromJson(json, Product.class);
			break;
		case UPBIDDING: 
			
			break;
		default:
			break;
		}
	}
	
	public void sendMessage(Commands command, Object o) throws IOException {
		dataOS.writeUTF(gson.toJson(command));
		dataOS.writeUTF(gson.toJson(o));
	}

}
