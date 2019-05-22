package com.prg3.mr_bid.model.entity;

import java.util.ArrayList;

public class Product {
	
	private String nameProduct;
	private String description;
	private ArrayList<String> images;
	
	public Product(String nameProduct, String description, ArrayList<String> images) {
		this.nameProduct = nameProduct;
		this.description = description;
		this.images = images;
	}
	
	public Product(String nameProduct, String description) {
		this.nameProduct = nameProduct;
		this.description = description;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public String getDescription() {
		return description;
	}

	public ArrayList<String> getImages() {
		return images;
	}
	
	@Override
	public String toString() {
		return "Nombre: " + nameProduct + ", descripcion: " + description;
	}
	
}
