package view;

import java.io.IOException;
import java.net.UnknownHostException;

import com.prg3.mr_bid.controller.UserController;
import com.prg3.mr_bid.view.JFrameMain;

public class MainTest {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		UserController userController = null;
		JFrameMain jFrameMain = new JFrameMain(userController.getInstanceOf());
	}

}
