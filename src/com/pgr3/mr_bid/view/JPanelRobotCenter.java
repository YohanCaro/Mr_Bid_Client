package com.pgr3.mr_bid.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelRobotCenter extends JPanel {

	private static final long serialVersionUID = 1L;

	private JCheckBox jCheckBox;
	private JLabel jLabel,jLabel2;
	ImageIcon imageIcon;
	Icon icon;

	public JPanelRobotCenter() {
		init();
	}

	private void init() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setBackground(Color.WHITE);
		jCheckBox = new JCheckBox ("  No soy un robot");
		jCheckBox.setMnemonic (KeyEvent.VK_C); 
		jCheckBox.setSelected (true);
//		jCheckBox.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		jCheckBox.setFont(new Font("Nunito Sams",0,20));
		this.add(jCheckBox);
		
		jLabel = new JLabel();
//		jLabel.setAlignmentX(CENTER_ALIGNMENT);
		jLabel.setBorder(BorderFactory.createEmptyBorder(0,80,0,0));
		imageIcon = new ImageIcon("data/images/reCaptcha.png");
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(60, 60,
				Image.SCALE_AREA_AVERAGING));
		jLabel.setIcon(icon);
		this.add(jLabel);


	}
}
