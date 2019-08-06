package com.prg3.mr_bid.communication;

import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.imageio.ImageIO;
import com.google.gson.Gson;
import com.prg3.mr_bid.model.entity.Bidding;
import com.prg3.mr_bid.model.entity.User;
import com.prg3.mr_bid.structures.simple_list.SimpleList;
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
			}
		}
	}
	
	/**
	 * Recibe un string con la ruta de las imagenes de la subasta/ hacer en vista/controlador
	 * @throws IOException ioe
	 */
	public void sendImages(String pathsImg, long bidId) throws IOException {
		sendMessage(Commands.SENDIMG, pathsImg+" "+bidId);
		BufferedImage bufferedImage = ImageIO.read(new File(pathsImg));
		ImageIO.write(bufferedImage, "png", dataOS);
		bufferedImage.flush();
		
	}
	
	/**
	 * Obtiene una imagen de la subasta (por id)
	 * @param id de la subasta
	 * @return paths ruta
	 * @throws IOException ioe
	 */
	public String getImages( long id) throws IOException {
		String paths = "";
		BufferedImage bufferedImage;
		bufferedImage = ImageIO.read(this.getInputStream());
		String imagePath = "data/biddingImages/bidding"+id+"_"+".png";
		ImageIO.write(bufferedImage, "png", new FileOutputStream(imagePath));
		bufferedImage.flush();
		paths = imagePath;	
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
			if (json.equals("false")) {
				Utilities.showMessageWarning("Correo o contraseña incorrectos\n"
						+ "Por favor vuelva a intentarlo", "Datos no validos!");				
			} else {
				Utilities.showMessageInfo("Cuenta se ha cargado!", "Usuario logueado");
				user = gson.fromJson(json, User.class);
			}
			break;
		case UPBIDDING:
			Constants.biddingsList = (json.length()>0)?Utilities.stringToBiddings(json):new SimpleList<Bidding>();
			Utilities.changeCritrium();
		case UPDATE_BID:
			Constants.biddingsList = (json.length()>0)?Utilities.stringToBiddings(json):new SimpleList<Bidding>();
			Utilities.changeCritrium();
			break;
		case GETIMG:
			String datas[] = json.split(" ");
			long id = Long.parseLong(datas[1]);
			try {
				String paths = this.getImages( (int) id);
				Constants.biddingsList.get((int) id).getProduct().setImage(paths);
			} catch (NumberFormatException | IOException e) {
			}
			break;
		default:
			break;
		}
	}
	
	/**
	 * Actualiza las susbastas del servidor
	 * @throws IOException ioe
	 */
	public void updateBiddings() throws IOException {
		dataOS.writeUTF(gson.toJson(Commands.UPDATE_BID));
		dataOS.writeUTF(gson.toJson(Commands.GETIMG));
	}
	
	/**
	 * Envia una nueva subasta al servidor
	 * @param bidding subasta
	 * @throws IOException ioe
	 */
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
	 * Obtiene el usuario
	 * @return user usuario
	 */
	public User getUser() {
		return user;
	}

}
