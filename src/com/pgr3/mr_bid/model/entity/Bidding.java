package com.pgr3.mr_bid.model.entity;

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
	
	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getBiddingName() {
		return biddingName;
	}

	public TypeProduct getTypeProduct() {
		return typeProduct;
	}

	public Product getProduct() {
		return product;
	}

	public BidTime getPublicationTime() {
		return publicationTime;
	}

	public BidTime getInitTime() {
		return initTime;
	}

	public BidTime getFinishTime() {
		return finishTime;
	}
	
	public boolean isAutomaticIncremet() {
		return isAutomaticIncremet;
	}
	
	public boolean isPublic() {
		return isPublic;
	}
	
	public User getOwner() {
		return owner;
	}

}
