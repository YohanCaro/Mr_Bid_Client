package view;

import javax.swing.JFrame;

import com.prg3.mr_bid.view.JDialogAbout;

public class Licencia{
	public static void main(String[] args) {
		JFrame jFrame= new JFrame();
		JDialogAbout jPanelLicencia = new JDialogAbout();
		jFrame.setBounds(0, 0, 600, 360);
		jFrame.add(jPanelLicencia);
		jFrame.setVisible(true);
		jFrame.setResizable(false);
		jFrame.setLocationRelativeTo(null);
	}

}
