package com.prg3.mr_bid.communication;

import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.prg3.mr_bid.model.entity.Bidding;
import com.prg3.mr_bid.model.entity.User;
import com.prg3.mr_bid.utilities.Constants;
import com.prg3.mr_bid.utilities.Utilities;

/**
 * Clase Client - Envia y recibe datos del servidor 
 * Utiliza la librería Gson para enviar objetos 
 *
 * @author Yohan Caro
 * @version 1.0 - 2/06/2019
 */
public class Client extends Socket implements Runnable {
	
	private DataInputStream dataIS;
	private DataOutputStream dataOS;
	private Gson gson;
	private boolean isConect;
	private static Client client;
	private User user;
	
	/**
	 * Constructor que crea el cliente con una ip y puerto
	 * @throws UnknownHostException u
	 * @throws IOException ioe
	 */
	private Client() throws UnknownHostException, IOException {
		super(Constants.ip, Constants.port);
		dataIS = new DataInputStream(this.getInputStream());
		dataOS = new DataOutputStream(this.getOutputStream());
		gson = new Gson();
		this.isConect = true;
	}
	
	/**
	 * Crea un unico cliente
	 * @return client cliente
	 * @throws UnknownHostException uhe
	 * @throws IOException ioe
	 */
	public static Client getInstanceOf() throws UnknownHostException, IOException {
		if (client == null) {
			client = new Client();
		}
		return client;
	}
	
	/**
	 * Inicia el hilo de cliente
	 */
	public void initClient() {
		new Thread(this).start();
	}

	@Override
	/**
	 * Recibe comandos y objetos del servidor
	 */
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
	 * @throws IOException ioe
	 */
	public void sendImages(ArrayList<String> pathsImg, long bidId) throws IOException {
		sendMessage(Commands.SENDIMG, pathsImg.size()+" "+bidId);
		for (int i = 0; i < pathsImg.size(); i++) {
			BufferedImage bufferedImage = ImageIO.read(new File(pathsImg.get(i)));
			ImageIO.write(bufferedImage, "png", dataOS);
			bufferedImage.flush();
		}
	}
	
	public ArrayList<String> getImages(int numImgs, long id) throws IOException {
		ArrayList<String> paths = new ArrayList<>();
		BufferedImage bufferedImage;
		for (int i = 1; i <= numImgs; i++) {
			bufferedImage = ImageIO.read(this.getInputStream());
			String imagePath = "data/biddingImages/bidding"+id+"_"+i+".png";
			ImageIO.write(bufferedImage, "png", new FileOutputStream(imagePath));
			bufferedImage.flush();
			paths.add(imagePath);
		}		
		return paths;
	}
	
	/**
	 * Ejecuta una acción con un comando
	 * @param command comando
	 * @param json JsonString object
	 */
	private void excecuteAction(Commands command, String json) {
		switch (command) {
		case ERROR_SINGIN:
			Utilities.showMessageWarning(json + "\nIntente con otra dirección o cargue su cuenta!",
					"Correo no valido!");
			break;
		case ERROR_LOGIN:
			if (json.charAt(1) == 'f') {
				Utilities.showMessageWarning("Correo o contraseña incorrectos\n"
						+ "Por favor vuelva a intentarlo", "Datos no validos!");				
			} else {
				Utilities.showMessageInfo("Si! :D", "Usuario logueado");
				user = gson.fromJson(json, User.class);
			}
			break;
		case UPBIDDING:
			Type listType = new TypeToken<List<Bidding>>(){}.getType();
			Constants.biddingsList = gson.fromJson(json, listType);
		case UPDATE_BID:
			Type listType2 = new TypeToken<List<Bidding>>(){}.getType();
			try {
				Constants.biddingsList = gson.fromJson(json, listType2);
			} catch (IllegalStateException e) {
			}
			break;
		case GETIMG:
			String datas[] = json.split(" ");
			long id = Long.parseLong(datas[1]);
			try {
				ArrayList<String> paths = this.getImages(Integer.parseInt(datas[0]), (int) id);
				Constants.biddingsList.get((int) id).getProduct().setImages(paths);
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}
	
	public void updateBiddings() throws IOException {
		dataOS.writeUTF(gson.toJson(Commands.UPDATE_BID));
		dataOS.writeUTF(gson.toJson(Commands.GETIMG));
	}
	
	public void sendNewBidding(Bidding bidding) throws IOException {
		sendMessage(Commands.UPBIDDING, bidding);
	}
	
	/**
	 * Envia un mensaje al servidor
	 * @param command comando
	 * @param o objeto
	 * @throws IOException ioe
	 */
	public void sendMessage(Commands command, Object o) throws IOException {
		dataOS.writeUTF(gson.toJson(command));
		if (o.getClass().equals(String.class)) {
			dataOS.writeUTF(o.toString());
		} else {
			dataOS.writeUTF(gson.toJson(o));
		}
	}
	
	/**
	 * Obtiene 
	 * @return user
	 */
	public User getUser() {
		return user;
	}

}
