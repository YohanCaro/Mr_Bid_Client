package view;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import com.pgr3.mr_bid.view.JPanelMainProduct;

public class Product {

	public static void main(String[] args) {
		JPanelMainProduct jPanelMainProduct;
		JScrollPane jScrollPane;
		jScrollPane = new JScrollPane();

		JFrame jFrame = new JFrame("hola");
		Icon icon;

		jPanelMainProduct = new JPanelMainProduct();

		jFrame.setResizable(true);
		jFrame.setLayout(new BorderLayout());
		jFrame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		jFrame.setTitle("MR BID");
		jScrollPane.setViewportView(jPanelMainProduct);
		jFrame.add(jScrollPane, BorderLayout.CENTER);	
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
