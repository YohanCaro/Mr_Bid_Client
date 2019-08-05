package utilities;

import com.prg3.mr_bid.model.entity.BidDate;
import com.prg3.mr_bid.model.entity.BidTime;
import com.prg3.mr_bid.model.entity.Bidding;
import com.prg3.mr_bid.model.entity.Product;
import com.prg3.mr_bid.model.entity.TypeProduct;
import com.prg3.mr_bid.utilities.Utilities;

/**
 * Clase TestTime - Prueba los metodos de las utilidades para saber el tiempo
 * que falta para que la subasta cambie de estado
 *
 * @author Yohan Caro
 * @version 1.0 - 12/06/2019
 */
public class TestTime2 {

	/**
	 * Main Test
	 * @param args argumentos
	 */
	public static void main(String[] args) {
		BidTime bidTime = new BidTime(new BidDate(13, 6, 2019), (float) 12);
		BidTime bidTime2 = new BidTime(new BidDate(28, 6, 2019), (float) 20);
		Bidding b = new Bidding("a", TypeProduct.ACCESSORIESVEHICLES, new Product("m", "n"),
				bidTime, bidTime, bidTime2, true, true, null, 1000);
		System.out.println(Utilities.getTimeRemaining(b));
	}

}
