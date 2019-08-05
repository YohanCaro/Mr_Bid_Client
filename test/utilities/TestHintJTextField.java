package utilities;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.prg3.mr_bid.utilities.HintJTextField;

/**
 * Clase TestHintJTextField - Preuba de la la clase HintJTextField
 * 
 * @author Yohan Caro
 * @version 1.0 - 24/05/2019
 */
public class TestHintJTextField {

	/**
	 * Main test
	 * @param args argumentos
	 */
	public static void main(String[] args) {
		JPanel panel = new JPanel(new GridLayout(3, 2));
		JLabel label = new JLabel();
		JLabel label2 = new JLabel();
		label.setBackground(Color.WHITE);
		label2.setBackground(Color.WHITE);
		JButton b = new JButton("Aceptar");
		JButton b2 = new JButton("Aceptar");
		b.setActionCommand("M");
		b2.setActionCommand("M2");
		
		HintJTextField h1 = new HintJTextField("Tiene limite", 10);
		HintJTextField h2 = new HintJTextField("No tiene limite");
		
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();
				if (command.equals("M")) {
					label.setText(h1.getText());
					h1.setText("");
				} else if (command.equals("M2")) {
					label2.setText(h2.getText());
					h2.setText("");
				}
				
			}
		};
		b.addActionListener(listener);
		b2.addActionListener(listener);
		
		panel.add(h1, BorderLayout.NORTH);
		panel.add(h2, BorderLayout.NORTH);
		panel.add(label, BorderLayout.EAST);
		panel.add(label2, BorderLayout.WEST);
		panel.add(b);
		panel.add(b2);
		
		JFrame frame = new JFrame("Prueba!");
		frame.setSize(500, 600);
		frame.add(panel);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
