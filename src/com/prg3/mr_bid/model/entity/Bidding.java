package com.prg3.mr_bid.model.entity;

/**
 * Clase Bidding - Modelo de la subasta con todos sus datos
 *
 * @author Yohan Caro
 * @version 1.0 - 2/06/2019
 */
public class Bidding {
	
	private long id;
	private String biddingName;
	private TypeProduct typeProduct;
	private Product product;
	private BidTime publicationTime;
	private BidTime initTime;
	private BidTime finishTime;
	private boolean isAutomaticIncremet;
	private boolean isPublic;
	private String owner;
	private int value;
	private int increment;
	
	/**
	 * Contruye una subasta con los siguientes datos
	 * @param biddingName nombre de la subasta
	 * @param typeProduct tipo de susbasta 
	 * @param product producto
	 * @param publicationTime tiempo de publicación
	 * @param initTime tiempo de inicio
	 * @param finishTime teiempo de finalizado
	 * @param isAutomaticIncremet define el tipo de incremento
	 * @param isPublic define si es publica
	 */
	public Bidding(String biddingName, TypeProduct typeProduct, Product product, BidTime publicationTime, BidTime initTime,
			BidTime finishTime, boolean isAutomaticIncremet, boolean isPublic, String user, int value, int increment) {
		this.biddingName = biddingName;
		this.typeProduct = typeProduct;
		this.product = product;
		this.publicationTime = publicationTime;
		this.initTime = initTime;
		this.finishTime = finishTime;
		this.isAutomaticIncremet = isAutomaticIncremet;
		this.isPublic = isPublic;
		this.owner = user;
		this.value = value;
		this.increment = increment;
	}
	
	public long getId() {
		return id;
	}
	
	/**
	 * Cambia 
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * Cambia el propietario
	 * @param owner pripietario
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * Obtiene el nombre
	 * @return nombre n
	 */
	public String getBiddingName() {
		return biddingName;
	}

	/**
	 * Obtiene el tipo de producto
	 * @return typeProduct t
	 */
	public TypeProduct getTypeProduct() {
		return typeProduct;
	}

	/**
	 * Obtiene el producto
	 * @return product p
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * Obtiene el tiempo de publicación
	 * @return publicationTime pt
	 */
	public BidTime getPublicationTime() {
		return publicationTime;
	}

	/**
	 * Obtiene el tiempo de inicio
	 * @return initTime it
	 */
	public BidTime getInitTime() {
		return initTime;
	}

	/**
	 * Obtiene el tiempo de finalizado
	 * @return finishTime ft
	 */
	public BidTime getFinishTime() {
		return finishTime;
	}
	
	/**
	 * Verifica si la susbasta es automatica
	 * @return isAutomaticIncremet ia
	 */
	public boolean isAutomaticIncremet() {
		return isAutomaticIncremet;
	}
	
	/**
	 * Obtiene si la subasta es publica
	 * @return isPublic ip
	 */
	public boolean isPublic() {
		return isPublic;
	}
	
	/**
	 * Obtiene le propietario de la subasta
	 * @return owner propietario
	 */
	public String getOwner() {
		return owner;
	}
	
	/**
	 * Obtiene 
	 * @return value
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Cambia 
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
	/**
	 * Obtiene 
	 * @return increment
	 */
	public int getIncrement() {
		return increment;
	}
	
	/**
	 * Cambia 
	 * @param increment the increment to set
	 */
	public void setIncrement(int increment) {
		this.increment = increment;
	}
	
	@Override
	/**
	 * Convierte la subasta en un cadena
	 * @return string c
	 */
	public String toString() {
		return "Nombre de publicacion: " + biddingName + ", tipo: " + typeProduct.name() + 
				"\nProducto: " + product.toString() + "\nTiempo de publicacion: " + publicationTime.toString() 
				+ "\nTiempo de inico: " + initTime.toString() + "\nTiempo final: " + finishTime.toString();
	}

}
