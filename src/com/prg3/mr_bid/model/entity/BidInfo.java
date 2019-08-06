package com.prg3.mr_bid.model.entity;

import java.io.UnsupportedEncodingException;
import com.prg3.mr_bid.utilities.Utilities;

/**
 * Clase BidInfo que contiene información del estado de puja de una subasta
 * @author Luis!
 */
public class BidInfo {
	protected long id;
	protected String highestBidder;
	protected int value;
	
	/**
	 * Constructor de la clase BidInfo para una subasta con un mayor pujador ya existente
	 * @param id identificador de la subasta
	 * @param highestBidder email del mayor postor de la subasta
	 * @param value valor de la mayor puja actual
	 */
	public BidInfo(long id, String highestBidder, int value) {
		this.id = id;
		this.highestBidder = highestBidder;
		this.value = value;
	}

	/**
	 * Constructor de la clase BidInfo para una nueva subasta
	 * @param id identificador de la subasta
	 * @param value valor de la puja inicial
	 */
	public BidInfo(long id, int value) {
		this.id = id;
		this.highestBidder = "";
		this.value = value;
	}

	/**
	 * Constructor de la clase BidInfo para una nueva subasta
	 * @param value valor de la puja inicial
	 */
	public BidInfo(int value) {
		this.highestBidder = "Sin pujas";
		this.value = value;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHighestBidder() {
		return highestBidder;
	}

	public void setHighestBidder(String highestBidder) {
		this.highestBidder = highestBidder;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}	
}
