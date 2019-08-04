package com.prg3.mr_bid.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import com.prg3.mr_bid.controller.ControlCommands;
import com.prg3.mr_bid.controller.UserController;
import com.prg3.mr_bid.utilities.ConstantsView;
import com.prg3.mr_bid.utilities.HintJTextField;
import com.prg3.mr_bid.utilities.Utilities;

/**
 * Clase JPanelPrincipalLogin - Se encarga de crear el panel donde el usuario 
 * carga su cuenta (login)
 *
 * @version 1.0 - 4/08/2019
 * @author Daniel García
 */
public class JPanelPrincipalLogin extends JPanel {

	/**
	 * Serial por defecto
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel jPanelNorth, jPanelWest, jPanelEast, jPanelSout, jPanelCenter, jPanelCenterImage, jPanelCenterCampos;
	private JLabel jLabel;
	private JButton jButton;
	private HintJTextField jTextFieldName;
    private JPasswordField jpassword;
	private ImageIcon imageIcon;
	private Icon icon;

	/**
	 * Constructor  que crea el panel del login
	 * @param controller controlador
	 */
	public JPanelPrincipalLogin(UserController controller) {
		this.setOpaque(false);
		
		jPanelCenter = new JPanel();
		jPanelCenterImage = new JPanel();
		jPanelCenterCampos = new JPanel();
		jPanelNorth = new JPanel();
		jPanelWest = new JPanel();
		jPanelEast = new JPanel();
		jPanelSout = new JPanel();
		jpassword = new JPasswordField();
		jButton = new JButton(ConstantsView.BTN_JPRINCPAL_LOGIN);
		jLabel = new JLabel();
		imageIcon = new ImageIcon(ConstantsView.PATH_JPRINCIPAL_USER_IMG);
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(250, 250, Image.SCALE_AREA_AVERAGING));

		this.setSpaces();
		init(controller);
	}
	
	private void setSpaces() {
		jPanelCenter.setOpaque(false);
		jPanelCenter.setLayout(new BorderLayout());
		jPanelCenter.setBackground(ConstantsView.COLOR_BACKGROUD_JPRINCIPAL_CENTER);
		jPanelCenter.setPreferredSize(Utilities.setDimension(400, 400));
		
		jPanelCenterImage.setBackground(ConstantsView.COLOR_BACKGROUD_JPRINCIPAL_CENTER_IMG);
		jPanelCenterImage.setPreferredSize(Utilities.setDimension(100, 350));
		
		jPanelCenterCampos.setBackground(ConstantsView.COLOR_BACKGROUD_JPRINCIPAL_CENTER_IMG);
		jPanelCenterCampos.setPreferredSize(Utilities.setDimension(100, 100));
		
		jPanelNorth.setOpaque(false);
		jPanelNorth.setPreferredSize(Utilities.setDimension(100, 900));
		
		jPanelWest.setOpaque(false);
		jPanelWest.setPreferredSize(Utilities.setDimension(400, 0));
		
		jPanelEast.setOpaque(false);
		jPanelEast.setPreferredSize(Utilities.setDimension(400, 0));
		
		jPanelSout.setOpaque(false);
		jPanelSout.setPreferredSize(Utilities.setDimension(100, 100));
	}

	private void init(UserController controller) {
		this.setLayout(new BorderLayout());
		this.setBackground(ConstantsView.COLOR_BACKGROUD_JPRINCIPAL);

		jLabel.setIcon(icon);
		jPanelCenterImage.add(jLabel);
				
		jTextFieldName = createTextField("name", 0, 0, jTextFieldName, 400);
		jPanelCenterCampos.add(jTextFieldName);

		jpassword.setPreferredSize(new Dimension(400, 30));
		jpassword.setBackground(ConstantsView.COLOR_BACKGROUD_JPRINCIPAL_PASSWORD);
		jPanelCenterCampos.add(jpassword);

		jPanelCenter.add(jPanelCenterCampos, BorderLayout.CENTER);
		jPanelCenter.add(jPanelCenterImage, BorderLayout.NORTH);
		jButton.setActionCommand(ControlCommands.ACTION_LOGIN.name());
		jButton.addActionListener(controller);
		jPanelSout.add(jButton);

		this.add(jPanelCenter, BorderLayout.CENTER);
		this.add(jPanelWest, BorderLayout.WEST);
		this.add(jPanelEast, BorderLayout.EAST);
		this.add(jPanelSout, BorderLayout.SOUTH);
	}

	public JLabel createEspacio() {
		jLabel = new JLabel();
		jLabel.setPreferredSize(Utilities.setDimension(0, 20));
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
		atribute.setBackground(ConstantsView.COLOR_BACKGROUD_JPRINCIPAL_PASSWORD);
		atribute.setPreferredSize(Utilities.setDimension(400, 30));
		add(atribute);
		return atribute;

	}
	
	@Override
	protected void paintComponent(Graphics g) {
		imageIcon = new ImageIcon(ConstantsView.PATH_JPRINCIPAL_BACK_IMG);
		g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paintComponent(g);
	}
        

}
