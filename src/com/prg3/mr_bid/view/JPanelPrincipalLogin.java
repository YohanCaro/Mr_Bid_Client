package com.prg3.mr_bid.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.prg3.mr_bid.controller.ControlCommands;
import com.prg3.mr_bid.controller.UserController;
import com.prg3.mr_bid.model.entity.MyCaptcha;
import com.prg3.mr_bid.utilities.HintJTextField;


public class JPanelPrincipalLogin extends JPanel{

	private JPanel jPanelNorth, jPanelWest, jPanelEast, jPanelSout, jPanelCenter, jPanelCenterImage, jPanelCenterCampos;
	private JLabel jLabel;
	private JButton jButton;
	private HintJTextField jTextFieldName;
    private JPasswordField jpassword;


	ImageIcon imageIcon;
	Icon icon;

	public JPanelPrincipalLogin(UserController controller) {
		this.setOpaque(false);
		jPanelCenter = new JPanel();
		jPanelCenter.setOpaque(false);
		jPanelCenter.setLayout(new BorderLayout());
		jPanelCenter.setBackground(new Color(59, 232, 183));
		jPanelCenter.setPreferredSize(new Dimension(400, 400));

		jPanelCenterImage = new JPanel();
//		jPanelCenterImage.setOpaque(false);
		jPanelCenterImage.setBackground(new Color(0,0,0,64));
		jPanelCenterImage.setPreferredSize(new Dimension(100, 350));

		jPanelCenterCampos = new JPanel();
		jPanelCenterCampos.setBackground(new Color(0,0,0,64));
		jPanelCenterCampos.setPreferredSize(new Dimension(100, 100));

		jPanelNorth = new JPanel();
		jPanelNorth.setOpaque(false);
		jPanelNorth.setPreferredSize(new Dimension(100, 900));

		jPanelWest = new JPanel();
		jPanelWest.setOpaque(false);
		jPanelWest.setPreferredSize(new Dimension(400, 0));

		jPanelEast = new JPanel();
		jPanelEast.setOpaque(false);
		jPanelEast.setPreferredSize(new Dimension(400, 0));

		jPanelSout = new JPanel();
		jPanelSout.setOpaque(false);
		jPanelSout.setPreferredSize(new Dimension(100, 100));

		init(controller);
	}

	private void init(UserController controller) {

		this.setLayout(new BorderLayout());
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setBackground(Color.RED);

		jLabel = new JLabel();
		imageIcon = new ImageIcon("data/images/usuario.png");
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(250, 250, Image.SCALE_AREA_AVERAGING));
		jLabel.setIcon(icon);
		jPanelCenterImage.add(jLabel);
				
		jTextFieldName = createTextField("name", 0, 0, jTextFieldName, 400);
		jPanelCenterCampos.add(jTextFieldName);

		jpassword = new JPasswordField();
		jpassword.setPreferredSize(new Dimension(400, 30));
		jpassword.setBackground(new Color(244, 244, 244));
		jPanelCenterCampos.add(jpassword);

		jPanelCenter.add(jPanelCenterCampos, BorderLayout.CENTER);
		jPanelCenter.add(jPanelCenterImage, BorderLayout.NORTH);
		jButton = new JButton("INGRESAR");
		jButton.setActionCommand(ControlCommands.ACTION_LOGIN.name());
		jButton.addActionListener(controller);
		jPanelSout.add(jButton);

		this.add(jPanelCenter, BorderLayout.CENTER);
//		this.add(jPanelNorth, BorderLayout.NORTH);
		this.add(jPanelWest, BorderLayout.WEST);
		this.add(jPanelEast, BorderLayout.EAST);
		this.add(jPanelSout, BorderLayout.SOUTH);

	}

	public JLabel createEspacio() {
		jLabel = new JLabel();
		jLabel.setPreferredSize(new Dimension(0, 20));
		this.add(jLabel);
		return jLabel;

	}
	
    public String getjTextFieldName() {
        return jTextFieldName.getText();
    }

    public String getJpassword() {
        return String.valueOf(jpassword.getPassword());
    }
    
    
    public HintJTextField createTextField(String name, int x, int y, HintJTextField atribute, int xsize) {
		atribute = new HintJTextField(name);
		atribute.setBounds(x, y, xsize, 30);
		atribute.setBackground(new Color(244, 244, 244));
		atribute.setPreferredSize(new Dimension(400, 30));
		add(atribute);
		return atribute;

	}
	
	@Override
	protected void paintComponent(Graphics g) {
		imageIcon = new ImageIcon("data/images/fondoLogin.jpg");
		g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paintComponent(g);
	}
        

}
