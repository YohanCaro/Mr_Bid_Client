package com.prg3.mr_bid.communication;

import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;

import com.google.gson.Gson;
import com.prg3.mr_bid.model.entity.Product;
import com.prg3.mr_bid.model.entity.User;
import com.prg3.mr_bid.utilities.Constants;

public class Client extends Socket implements Runnable {
	
	private DataInputStream dataIS;
	private DataOutputStream dataOS;
	private Gson gson;
	private boolean isConect;
	private static Client client;
	
	private Client() throws UnknownHostException, IOException {
		super(Constants.ip, Constants.port);
		dataIS = new DataInputStream(this.getInputStream());
		dataOS = new DataOutputStream(this.getOutputStream());
		gson = new Gson();
		this.isConect = true;
	}
	
	public static Client getInstanceOf() throws UnknownHostException, IOException {
		if (client == null) {
			client = new Client();
		}
		return client;
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
	
	/**
	 * Recibe un arraylist con la ruta de las imagenes de la subasta/ hacer en vista/controlador
	 * @throws IOException 
	 */
	public void sendImages(ArrayList<String> pathsImg, long bidId) throws IOException {
		sendMessage(Commands.SENDIMG, pathsImg.size()+" "+bidId);
		for (int i = 0; i < pathsImg.size(); i++) {
			BufferedImage bufferedImage = ImageIO.read(new File(pathsImg.get(i)));
			ImageIO.write(bufferedImage, "png", dataOS);
			bufferedImage.flush();
		}
	}
	
	private void excecuteAction(Commands command, String json) {
		switch (command) {
		case LOGIN:
			Constants.user = gson.fromJson(json, User.class);
			break;
		case SIGNIN: 
			Constants.user = gson.fromJson(json, User.class);
			break;
		case UPBIDDING: 
			
			break;
		case CHANGE_BIDDING:
			
			break;
		case DELETE_BIDDING:
			
			break;
		case DELETE_USER:
			
			break;
		}
	}
	
	public void sendMessage(Commands command, Object o) throws IOException {
		dataOS.writeUTF(gson.toJson(command));
		if (o.getClass().equals(String.class)) {
			dataOS.writeUTF(o.toString());
		} else {
			dataOS.writeUTF(gson.toJson(o));
		}
		
	}

}
