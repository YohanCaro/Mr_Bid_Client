package com.prg3.mr_bid.model.entity;

/**
 * Clase Product - Crea un producto para subastar
 *
 * @author Yohan Caro
 * @version 1.0 - 2/06/2019
 */
public class Product {
	
	private String nameProduct;
	private String description;
	private String image;
	
	/**
	 * Crea un producto con los siguientes datos
	 * @param nameProduct nombre del producto
	 * @param description descripción del producto
	 * @param images imagenes del producto
	 */
	public Product(String nameProduct, String description, String images) {
		this.nameProduct = nameProduct;
		this.description = description;
		this.image = images;
	}
	
	/**
	 * Crea un producto sin imagenes
	 * @param nameProduct nombre del producto
	 * @param description descripción del producto
	 */
	public Product(String nameProduct, String description) {
		this.nameProduct = nameProduct;
		this.description = description;
	}

	/**
	 * Obtiene le nombre del producto
	 * @return nameProduct nombre
	 */
	public String getNameProduct() {
		return nameProduct;
	}

	/**
	 * Obtiene la descripción del producto
	 * @return description descrición
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Obtiene unalista con la ruta de las imagenes
	 * @return images imagenes
	 */
	public String getImage() {
		return image;
	}
	
	@Override
	/**
	 * To string
	 */
	public String toString() {
		return "Nombre: " + nameProduct + ", descripcion: " + description;
	}

	/**
	 * Cambia el valor de la ruta de la imagen del producto
	 * @param paths ruta
	 */
	public void setImage(String paths) {
		this.image = paths;		
	}
	
}
