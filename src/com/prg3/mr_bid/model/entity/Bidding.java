package com.prg3.mr_bid.model.entity;

/**
 * Clase Bidding - Modelo de la subasta con todos sus datos
 *
 * @author Yohan Caro
 * @version 1.0 - 2/06/2019
 */
public class Bidding {
	public final static int RECORD_SIZE = 221;
	private BidInfo bidInfo;
	private String biddingName;
	private TypeProduct typeProduct;
	private Product product;
	private BidTime publicationTime;
	private BidTime initTime;
	private BidTime finishTime;
	private boolean isAutomaticIncremet;
	private boolean isPublic;
	private String owner;
	
	/**
	 * Contruye una nueva subasta con los siguientes datos
	 * @param biddingName nombre de la subasta
	 * @param typeProduct tipo de susbasta 
	 * @param product producto
	 * @param publicationTime tiempo de publicación
	 * @param initTime tiempo de inicio
	 * @param finishTime teiempo de finalizado
	 * @param isAutomaticIncremet define el tipo de incremento
	 * @param isPublic define si es publica
	 * @param emailUser Dueño de la subasta
	 */
	public Bidding(int value, String biddingName, TypeProduct typeProduct, Product product, BidTime publicationTime,
			BidTime initTime, BidTime finishTime, boolean isAutomaticIncremet, boolean isPublic, String emailUser) {
		this.bidInfo = new BidInfo(value);
		this.biddingName = biddingName;
		this.typeProduct = typeProduct;
		this.product = product;
		this.publicationTime = publicationTime;
		this.initTime = initTime;
		this.finishTime = finishTime;
		this.isAutomaticIncremet = isAutomaticIncremet;
		this.isPublic = isPublic;
		this.owner = emailUser;
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
	 * @param emailUser Dueño de la subasta
	 */
	public Bidding(long id, int value, String highestBidder, String biddingName, TypeProduct typeProduct,
			Product product, BidTime publicationTime, BidTime initTime, BidTime finishTime,
			boolean isAutomaticIncremet, boolean isPublic, String emailUser) {
		this.bidInfo = new BidInfo(id, highestBidder, value);
		this.biddingName = biddingName;
		this.typeProduct = typeProduct;
		this.product = product;
		this.publicationTime = publicationTime;
		this.initTime = initTime;
		this.finishTime = finishTime;
		this.isAutomaticIncremet = isAutomaticIncremet;
		this.isPublic = isPublic;
		this.owner = emailUser;
	}
	
	/**
	 * Constructor vacío de la clase Bidding. Nota: es usado en operaciones de persistencia con arboles bst
	 */
	public Bidding() {
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
		return bidInfo.value;
	}
	
	/**
	 * Cambia 
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.bidInfo.value = value;
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
		return bidInfo.id;
	}
	/**
	 * Cambia 
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.bidInfo.id = id;
	}

	
	/**
	 * Convierte un string en una subasta
	 * @param bid subasta en cadena
	 * @return Bidding subasta
	 */
	public static Bidding stringToBidding(String bid) {
		String[] array = bid.split("-");
		return new Bidding(Long.parseLong(array[0]),Integer.parseInt(array[1]), array[2], array[3],
				TypeProduct.values()[Integer.parseInt(array[4])],
				new Product(array[5], array[6], array[7]), 
				new BidTime(new BidDate(array[8]), Float.parseFloat(array[9])),
				new BidTime(new BidDate(array[10]), Float.parseFloat(array[11])),
				new BidTime(new BidDate(array[12]), Float.parseFloat(array[13])),
				(array[14].equals("1")), (array[15].equals("1")), array[16]);
	}
	
	@Override
	public String toString() {
		return bidInfo.id + "-" + bidInfo.value+ "-" + bidInfo.highestBidder + "-" + biddingName 
				+ "-" + typeProduct.ordinal() + "-" + product.toString()
				+ "-" + publicationTime.toString() + "-" + initTime.toString() + "-"
				+ finishTime.toString() + "-" + (isAutomaticIncremet?1:0) + "-" 
				+ (isPublic?1:0) + "-" + owner ;
	}

}