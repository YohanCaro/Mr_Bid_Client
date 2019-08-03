package com.prg3.mr_bid.utilities;

import java.util.ArrayList;

import com.prg3.mr_bid.model.entity.BidTime;
import com.prg3.mr_bid.model.entity.Bidding;
import com.prg3.mr_bid.model.entity.Product;
import com.prg3.mr_bid.model.entity.User;
import com.prg3.mr_bid.structures.simple_list.SimpleList;

/**
 * Clase Constants - Constantes que se pueden usar 
 *
 * @author Yohan Caro
 * @version 1.0 - 2/06/2019
 */
public class Constants {
	
	//Communications
	public static String ip = "localHost";
	public static int port = 12345;
	public static User user = null;
	public static Product product = null;
	public static BidTime bidTime = null;
	public static SimpleList<Bidding> biddingsList = new SimpleList<>();
	
}
