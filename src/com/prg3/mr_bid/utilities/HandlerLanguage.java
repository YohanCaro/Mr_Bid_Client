package com.prg3.mr_bid.utilities;

import java.io.IOException;
import java.util.Properties;

/**
 * Clase HandlerLanguage - Se encarag del manejo del lenguaje
 *
 * @version 1.0 - 4/08/2019
 * @author Daniel García
 */
public class HandlerLanguage {
	public String fileName;
	public static String language = "undefined";
	public static Properties languageProperties;
	
	/**
	 * Constructor que carga el archivo de propiedades
	 * @param fileName ruta del archivo
	 */
	public HandlerLanguage(String fileName){
		this.fileName = fileName;
	}
	/**
	 * Metodo donde se cargan los archivos
	 * @throws IOException ioe
	 */
	public void loadLanguage() throws IOException{		
		HandlerProperties handlerproperties = new HandlerProperties(fileName);
		handlerproperties.load();
		language = handlerproperties.getProperty("Language");
		
		HandlerProperties handlerLanguageProperties = new HandlerProperties(language);
		handlerLanguageProperties.load();
		languageProperties = handlerLanguageProperties;
	}
	
	/**
	 * Guerad el lenguaje
	 * @throws IOException ioe
	 */
	public void saveLanguage() throws IOException{
		HandlerProperties handlerproperties = new HandlerProperties(fileName);
		handlerproperties.load();
		handlerproperties.setProperty("Language", language);
		handlerproperties.save();
	}	
}