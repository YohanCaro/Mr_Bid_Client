package comminication;

import java.io.IOException;

import com.prg3.mr_bid.communication.Client;
import com.prg3.mr_bid.communication.Commands;
import com.prg3.mr_bid.model.entity.BidDate;
import com.prg3.mr_bid.model.entity.User;
import com.prg3.mr_bid.utilities.Constants;

public class TestClient {
	
	public static void main(String[] args) {
		try {
			User user = new User("Juan", "Diaz", "juan@nn.c", "1234", new BidDate(7, 4, 2003), false, null);
			Client client = Client.getInstanceOf();
			client.initClient();
			client.sendMessage(Commands.LOGIN, user);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Constants.user.getCreditCard().getCardholderName());
			System.out.println(Constants.user.getBirthDate().getDateString());
			client.close();
		} catch (IOException e) {
			System.err.println("Error al crear el cliente");
			e.printStackTrace();
		}
		
	}

}
