package com.prg3.mr_bid.utilities;

import java.io.IOException;
import java.util.Properties;

public class HandlerLanguage {
	public String fileName;
	public static String language = "undefined";
	public static Properties languageProperties;
	
	public HandlerLanguage(String fileName){
		this.fileName = fileName;
	}
	/**
	 * Metodo donde se cargan los archivos
	 * @throws IOException
	 */
	public void loadLanguage() throws IOException{		
		HandlerProperties handlerproperties = new HandlerProperties(fileName);
		handlerproperties.load();
		language = handlerproperties.getProperty("Language");
		
		HandlerProperties handlerLanguageProperties = new HandlerProperties(language);
		handlerLanguageProperties.load();
		languageProperties = handlerLanguageProperties;
	}
	
	public void saveLanguage() throws IOException{
		HandlerProperties handlerproperties = new HandlerProperties(fileName);
		handlerproperties.load();
		handlerproperties.setProperty("Language", language);
		handlerproperties.save();
	}	
}