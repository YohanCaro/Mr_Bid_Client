package utilities;

import com.prg3.mr_bid.model.entity.BidDate;
import com.prg3.mr_bid.model.entity.BidTime;
import com.prg3.mr_bid.utilities.Utilities;

/**
 * Clase TestTime - Prueba de la clase bidTime y las utlidades
 * Para la conversión de fechas y las operaciones con estas
 *
 * @author Yohan Caro
 * @version 1.0 - 12/06/2019
 */
public class TestTime {

	/**
	 * Main test
	 * @param args argumentos
	 */
	public static void main(String[] args) {
		BidTime bidTime = new BidTime(new BidDate(12, 6, 2019), (float) 20);
		System.out.println(Utilities.isAfterOfToDay(bidTime));
	}

}
