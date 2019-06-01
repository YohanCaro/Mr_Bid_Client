package com.prg3.mr_bid.runner;

import java.io.IOException;
import java.net.UnknownHostException;

import com.prg3.mr_bid.communication.Client;
import com.prg3.mr_bid.controller.UserController;
import com.prg3.mr_bid.utilities.Constants;

/**
 * Clase Run - Inicia la aplicaión del cliente
 *
 * @version 1.2 - 1/06/2019
 */
public class Run {

	/**
	 * Main
	 * @param args (ip, port) (localHost 12345)
	 */
	public static void main(String[] args) {
		
		
		
		if (args.length == 2) {
			try {
				Constants.ip = args[0];
				Constants.port = Integer.parseInt(args[1]);
				Client.getInstanceOf().initClient();
				UserController.getInstanceOf();
			} catch (UnknownHostException e) {
				System.out.println("No se ha encontrado al servidor");
			} 
			catch (NumberFormatException e) {
				System.out.println("El parametro del puerto debe ser numerico! (EJM: 12345)");
			} 
			catch (IOException e) {
				System.out.println("No se ha podido establecer conexión con el servidor");
			}
		} else {
			System.out.println("Debe ingresar la ip y el puerto");
		}
		
	}

}
