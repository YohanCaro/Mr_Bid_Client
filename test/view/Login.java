package view;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.pgr3.mr_bid.view.JPanelOptionMenu;
import com.pgr3.mr_bid.view.JPanelPrincipalLogin;

public class Login {

	public static void main(String[] args) {

		JPanelPrincipalLogin jPanelPrincipalLogin;
		JPanelOptionMenu jPanelOptionMenu;
		JPanel jPanel;
		JFrame jFrame = new JFrame("hola");
		Icon icon;

		jPanelPrincipalLogin = new JPanelPrincipalLogin();
		jPanelOptionMenu = new JPanelOptionMenu();
		jPanel = new JPanel();

		jFrame.setResizable(true);
		jFrame.setLayout(new BorderLayout());
		jFrame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		jFrame.setTitle("MR BID");
		jFrame.add(jPanelPrincipalLogin, BorderLayout.CENTER);
		jFrame.add(jPanelOptionMenu, BorderLayout.NORTH);
		jFrame.repaint();
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
		
	}

}
