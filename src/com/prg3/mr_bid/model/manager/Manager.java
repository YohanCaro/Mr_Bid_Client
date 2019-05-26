package com.prg3.mr_bid.model.manager;

import com.prg3.mr_bid.model.entity.BidDate;
import com.prg3.mr_bid.model.entity.BidTime;
import com.prg3.mr_bid.model.entity.Bidding;
import com.prg3.mr_bid.model.entity.CreditCard;
import com.prg3.mr_bid.model.entity.Product;
import com.prg3.mr_bid.model.entity.TypeProduct;
import com.prg3.mr_bid.model.entity.User;

public class Manager {
	
	private User user;
	
	public Manager(String firstName, String lastName, String email, String password, BidDate birthDate,
			boolean isFemale, CreditCard creditCard) {
		user = new User(firstName, lastName, email, password, birthDate, isFemale, creditCard);
	}
	
	public void addBidding(String biddingName, TypeProduct typeProduct, Product product, BidTime publicationTime,
			BidTime initTime, BidTime finishTime, boolean isAutomaticIncremet, boolean isPublic) {
		
		Bidding bidding = new Bidding(biddingName, typeProduct, product, publicationTime, initTime,
				finishTime, isAutomaticIncremet, isPublic);
		user.getMyBiddings().add(bidding);
	}
	
	public String showUserBiddings() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < user.getMyBiddings().size(); i++) {
			builder.append((i+1) + ") --------------------------------------\n");
			builder.append(user.getMyBiddings().get(i).toString());
			builder.append("\n");
		}
		return builder.toString();
	}
	
	public User getUser() {
		return user;
	}
	
}