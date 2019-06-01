package view;

import com.prg3.mr_bid.controller.UserController;
import com.prg3.mr_bid.view.JFrameMain;

public class MainTest {
	
	public static void main(String[] args) {
		UserController userController = null;
		JFrameMain jFrameMain = new JFrameMain(userController.getInstanceOf());
	}

}
