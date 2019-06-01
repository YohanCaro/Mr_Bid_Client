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
public class RunViewTemp {

	/**
	 * Main
	 * @param args (ip, port) (localHost 12345)
	 */
	public static void main(String[] args) {
		
		UserController.getInstanceOf();
	}
}
