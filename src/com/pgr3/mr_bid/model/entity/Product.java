package com.pgr3.mr_bid.model.entity;

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

	public String getNameProduct() {
		return nameProduct;
	}

	public String getDescription() {
		return description;
	}

	public ArrayList<String> getImages() {
		return images;
	}
	
}
