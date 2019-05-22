package view;

import javax.swing.JFrame;

import com.pgr3.mr_bid.view.JPanelLicencia;

public class Licencia{
	public static void main(String[] args) {
		JFrame jFrame= new JFrame();
		JPanelLicencia jPanelLicencia = new JPanelLicencia();
		jFrame.setBounds(0, 0, 600, 360);
		jFrame.add(jPanelLicencia);
		jFrame.setVisible(true);
		jFrame.setResizable(false);
		jFrame.setLocationRelativeTo(null);
	}

}
