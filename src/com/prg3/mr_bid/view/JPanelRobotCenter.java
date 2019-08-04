package com.prg3.mr_bid.view;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.prg3.mr_bid.utilities.ConstantsView;

/**
 * Clase JPanelRobotCenter - Crea el panel robot de la aplicación
 *
 * @version 1.0 - 4/08/2019
 * @author Bid Team
 */
public class JPanelRobotCenter extends JPanel {

	/**
	 * Seral por defecto
	 */
	private static final long serialVersionUID = 1L;

	private JCheckBox jCheckBox;
	private JLabel jLabel;
	private ImageIcon imageIcon;
	private Icon icon;

	public JPanelRobotCenter() {
		this.jCheckBox = new JCheckBox (ConstantsView.TEXT_NO_ROBOT);
		this.jLabel = new JLabel();
		this.imageIcon = new ImageIcon(ConstantsView.PATH_RECAPTCHA_ROBOT);
		
		init();
	}

	private void init() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setBackground(ConstantsView.COLOR_BACKGROUD_ROBOT);
		
		jCheckBox.setMnemonic (KeyEvent.VK_C); 
		jCheckBox.setSelected (true);
		jCheckBox.setFont(ConstantsView.FONT_CHECK_ROBOT);
		this.add(jCheckBox);
		
		jLabel.setBorder(BorderFactory.createEmptyBorder(0,80,0,0));
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(60, 60,
				Image.SCALE_AREA_AVERAGING));
		jLabel.setIcon(icon);
		this.add(jLabel);
	}
}
