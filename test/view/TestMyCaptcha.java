package view;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.prg3.mr_bid.model.entity.MyCaptcha;
import com.prg3.mr_bid.view.CaptchaJPanel;



public class TestMyCaptcha {
	
	public static void main(String[] args) {
		
		MyCaptcha captcha = new MyCaptcha();
		JPanel jPanel = new JPanel();
		jPanel.setLayout(null);
		jPanel.setBackground(Color.red);
		captcha.create();
		System.out.println(captcha.getMessage());
		
		JFrame frame = new JFrame("Captcha");
		frame.add(jPanel);
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		jPanel.add(new CaptchaJPanel(captcha));
//		frame.add();
		frame.add(jPanel);
		frame.setVisible(true);
	}

}
