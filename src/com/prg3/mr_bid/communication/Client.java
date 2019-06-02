package com.prg3.mr_bid.communication;

import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.google.gson.Gson;
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
			if (json.charAt(1) == 't') {
				//Cargó
				System.out.println(":D");
			} else {
				Utilities.showMessageWarning("Correo o contraseña incorrectos\n"
						+ "Por favor vuelva a intentarlo", "Datos no validos!");
			}
			break;
		default:
			break;
		}
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

}
