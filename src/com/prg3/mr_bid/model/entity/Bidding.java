package com.prg3.mr_bid.model.entity;

/**
 * Clase Bidding - Modelo de la subasta con todos sus datos
 *
 * @author Yohan Caro
 * @version 1.0 - 2/06/2019
 */
public class Bidding {
	
	private User owner;
	private String biddingName;
	private TypeProduct typeProduct;
	private Product product;
	private BidTime publicationTime;
	private BidTime initTime;
	private BidTime finishTime;
	private boolean isAutomaticIncremet;
	private boolean isPublic;
	
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
	public Bidding(String biddingName, TypeProduct typeProduct, Product product, BidTime publicationTime,
			BidTime initTime, BidTime finishTime, boolean isAutomaticIncremet, boolean isPublic) {
		this.biddingName = biddingName;
		this.typeProduct = typeProduct;
		this.product = product;
		this.publicationTime = publicationTime;
		this.initTime = initTime;
		this.finishTime = finishTime;
		this.isAutomaticIncremet = isAutomaticIncremet;
		this.isPublic = isPublic;
	}
	
	/**
	 * Cambia el propietario
	 * @param owner pripietario
	 */
	public void setOwner(User owner) {
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
	public User getOwner() {
		return owner;
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
