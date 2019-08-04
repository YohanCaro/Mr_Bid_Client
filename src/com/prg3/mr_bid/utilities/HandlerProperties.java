package com.prg3.mr_bid.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Clase HandlerProperties - 
 *
 * @version 1.0 - 12/06/2019
 * @author Daniel García
 */
public class HandlerProperties extends Properties {
	
	/**
	 * Serial por defecto
	 */
	private static final long serialVersionUID = 1L;
	private String fileName;
	
	/**
	 * Constructor  que carag el archivo de propiedades
	 * @param fileName ruta 
	 * @throws IOException ioe
	 */
	public HandlerProperties(String fileName) throws IOException{
		this.fileName = fileName;
	}
	/**
	 * Se carga el archivo
	 * @throws IOException ioe
	 */
	public void load() throws IOException{
		InputStream input;
		input = new FileInputStream(fileName);
		load(input);
		input.close();
	}	
	
	/**
	 * Guarda el archivo
	 * @throws IOException ioe
	 */
	public void save() throws IOException{
		FileOutputStream output = new FileOutputStream(fileName);
		store(output, null);
		output.close();
	}
}