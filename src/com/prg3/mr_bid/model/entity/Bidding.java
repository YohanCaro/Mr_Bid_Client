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
	public Bidding(long id,String biddingName, TypeProduct typeProduct, Product product, BidTime publicationTime,
			BidTime initTime, BidTime finishTime, boolean isAutomaticIncremet, boolean isPublic, String emailUser,
			int value) {
		this.id = id;
		this.biddingName = biddingName;
		this.typeProduct = typeProduct;
		this.product = product;
		this.publicationTime = publicationTime;
		this.initTime = initTime;
		this.finishTime = finishTime;
		this.isAutomaticIncremet = isAutomaticIncremet;
		this.isPublic = isPublic;
		this.owner = emailUser;
		this.value = value;
	}
	
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
	 * Dueño de la subasta
	 */
	public Bidding(String biddingName, TypeProduct typeProduct, Product product, BidTime publicationTime,
			BidTime initTime, BidTime finishTime, boolean isAutomaticIncremet, boolean isPublic, 
			String emailUser, int value) {
		this.biddingName = biddingName;
		this.typeProduct = typeProduct;
		this.product = product;
		this.publicationTime = publicationTime;
		this.initTime = initTime;
		this.finishTime = finishTime;
		this.isAutomaticIncremet = isAutomaticIncremet;
		this.isPublic = isPublic;
		this.owner = emailUser;
		this.value = value;
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
	
	public static Bidding stringToBidding(String bid) {
		String[] array = bid.split("-");
		
		return new Bidding(Long.parseLong(array[0]), array[1], TypeProduct.values()[Integer.parseInt(array[2])],
				new Product(array[3], array[4], array[5]), 
				new BidTime(new BidDate(array[6]), Float.parseFloat(array[7])),
				new BidTime(new BidDate(array[8]), Float.parseFloat(array[9])),
				new BidTime(new BidDate(array[10]), Float.parseFloat(array[11])),
				(array[12].equals("1")), (array[13].equals("1")), array[14],Integer.parseInt(array[15]));
	}
	
	@Override
	public String toString() {
		return id + "-" + biddingName + "-" + typeProduct.ordinal() + "-" + product.toString()
				+ "-" + publicationTime.toString() + "-" + initTime.toString() + "-"
				+ finishTime.toString() + "-" + (isAutomaticIncremet?1:0) + "-" 
				+ (isPublic?1:0) + "-" + owner + "-" + value;
	}

}