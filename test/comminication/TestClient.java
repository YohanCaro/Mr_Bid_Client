package comminication;

import java.io.IOException;

import com.prg3.mr_bid.communication.Client;
import com.prg3.mr_bid.communication.Commands;
import com.prg3.mr_bid.model.entity.BidDate;
import com.prg3.mr_bid.model.entity.Gender;
import com.prg3.mr_bid.model.entity.TypeDocument;
import com.prg3.mr_bid.model.entity.User;
import com.prg3.mr_bid.utilities.Constants;

/**
 * Clase TestClient - Test del cliente
 *
 * @version 1.0 - 4/08/2019
 * @author Yohan Caro
 */
public class TestClient {
	
	/**
	 * Test main
	 * @param args arguments
	 */
	public static void main(String[] args) {
		try {
			User user = new User("Juan", "Diaz", "juan@nn.c", "1234", new BidDate(7, 4, 2003),
					"2132", TypeDocument.CEDULA, Gender.MALE, null);
			Client client = Client.getInstanceOf();
			client.initClient();
			client.sendMessage(Commands.LOGIN, user);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
			System.out.println(Constants.user.getCreditCard().getCardholderName());
			System.out.println(Constants.user.getBirthDate().getDateString());
			client.close();
		} catch (IOException e) {
			System.err.println("Error al crear el cliente");
		}
		
	}

}
