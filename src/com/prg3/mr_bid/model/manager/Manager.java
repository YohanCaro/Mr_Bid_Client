package com.prg3.mr_bid.model.manager;

import com.prg3.mr_bid.model.entity.BidDate;
import com.prg3.mr_bid.model.entity.BidTime;
import com.prg3.mr_bid.model.entity.Bidding;
import com.prg3.mr_bid.model.entity.CreditCard;
import com.prg3.mr_bid.model.entity.Gender;
import com.prg3.mr_bid.model.entity.Product;
import com.prg3.mr_bid.model.entity.TypeDocument;
import com.prg3.mr_bid.model.entity.TypeProduct;
import com.prg3.mr_bid.model.entity.User;
import com.prg3.mr_bid.utilities.Constants;
import com.prg3.mr_bid.utilities.Utilities;

/**
 * Clase Manager - Maneja los datos del usuario - cliente
 *
 * @author Yohan Caro
 * @version 1.0 - 2/06/2019
 */
public class Manager {
	
	private User user;
	private static Manager manager;
	
	/**
	 * Constructor vacio
	 */
	public Manager() {
		
	}
	
	/**
	 * Crea un usuario
	 * @param firstName nombre
	 * @param lastName apellido
	 * @param email correo
	 * @param password contraseña
	 * @param birthDate fecha de nacimiento
	 * @param document num de documento
	 * @param typeDocument tipo de documento
	 * @param gender genero
	 * @param creditCard tarjeta de credito
	 * @return User u
	 */
	public User createUser(String firstName, String lastName, String email, String password, String birthDate,
			String document, TypeDocument typeDocument, Gender gender, CreditCard creditCard) {
		if (firstName != null && lastName != null && email != null && password != null && birthDate != null
				&& document != null) {
			return new User(firstName, lastName, email, password,new BidDate(birthDate), document,
					typeDocument,	gender, creditCard);
		}
		return null;
	}
	
	/**
	 * Añade una subasta al user
	 * @param biddingName nombre de la subasta
	 * @param typeProduct tipo de producto
	 * @param product producto
	 * @param publicationTime nombre de la publicacion
	 * @param initTime tiempo de inicio
	 * @param finishTime tiempo de finalizado
	 * @param isAutomaticIncremet tipo de incremento
	 * @param isPublic publico/no
	 */
	public Bidding addBidding(String biddingName, TypeProduct typeProduct, Product product, BidTime publicationTime,
			BidTime initTime, BidTime finishTime, boolean isAutomaticIncremet, boolean isPublic) {
		if (user != null) {
			if (Utilities.isAfterOfToDay(initTime) && Utilities.isAfterOfToDay(finishTime)) {
				Bidding bidding = new Bidding(biddingName, typeProduct, product, publicationTime, initTime,
						finishTime, isAutomaticIncremet, isPublic, user.getEmail());
				user.getMyBiddings().add(bidding);
				return bidding;
			} else {
				Utilities.showMessageError("Las fechas de inicio y fin deben ser mayores a hoy\n"
						+ "Las hora también", "Fechas no validas");
			}
		} else {
			Utilities.showMessageWarning("Por favor cargue su cuenta para poder realizar\n"
					+ "Subasta", "Acción no valida");
		}
		return null;
	}
	
	/**
	 * Convierte a los users en cadenas
	 * @return string s
	 */
	public String showUserBiddings() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < user.getMyBiddings().size(); i++) {
			builder.append((i+1) + ") --------------------------------------\n");
			builder.append(user.getMyBiddings().get(i).toString());
			builder.append("\n");
		}
		return builder.toString();
	}
	
	public Bidding searchBiddingForID(long id) {
		for (int i = 0; i < Constants.biddingsList.size(); i++) {
			if (Constants.biddingsList.get(i).getId() == id) {
				return Constants.biddingsList.get(i);
			}
		}
		return null;
	}
		
	/**
	 * Obtiene el usuario
	 * @return user
	 */
	public User getUser() {
		return user;
	}
	
	/**
	 * Cambia 
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	/*
	 * Estaba haciendo lo del incremento!
	 */
	
}
