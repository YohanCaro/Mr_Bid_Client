package com.prg3.mr_bid.utilities;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class HandlerProperties extends Properties {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fileName;
	
	public HandlerProperties(String fileName) throws IOException{
		this.fileName = fileName;
	}
	/**
	 * Se carga el archivo
	 * @throws IOException
	 */
	public void load() throws IOException{
		InputStream input;
		input = new FileInputStream(fileName);
		load(input);
		input.close();
	}	
	
	public void save() throws IOException{
		FileOutputStream output = new FileOutputStream(fileName);
		store(output, null);
		output.close();
	}
}