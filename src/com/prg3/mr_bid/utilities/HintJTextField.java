package com.prg3.mr_bid.utilities;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import javax.swing.JTextField;

/**
 * Clase HintJTextField - Oculta el texto de un JTextField
 *
 * @author Andres Felipe Chaparro - Ohmio Mega
 * @version 1.0 
 */
public class HintJTextField extends JTextField implements FocusListener {
	private static final long serialVersionUID = 1L;
	private final String hint;
	private boolean showingHint;
	private int limit;
	private LinkedList<Character> requiredCharacters;
	private LinkedList<Character> prohibitedCharacters;

	public HintJTextField(String hint) {
		super(hint);
		this.setForeground(Color.gray);
		this.hint = hint;
		this.showingHint = true;
		this.requiredCharacters = new LinkedList<>();
		this.prohibitedCharacters = new LinkedList<>();
		this.init();
	}

	public HintJTextField(String hint, int limit) {
		this(hint);
		this.limit = limit;
	}

	private void init() {
		super.addFocusListener(this);
		super.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (limit != 0)
					if (getText().length() == limit)
						e.consume();
				setForeground(isCompliant() ? Color.black : Color.red);
			}
		});
	}

	private boolean isCompliant() {
		for (Character c : this.requiredCharacters) {
			if (!this.getText().contains(c + ""))
				return false;
		}
		return true;
	}

	public void prohibitedCharacters(char... chars) {
		for (int i = 0; i < chars.length; i++) {
			this.prohibitedCharacters.add(chars[i]);
		}
	}

	public void requiredCharacters(char... chars) {
		for (int i = 0; i < chars.length; i++) {
			this.requiredCharacters.add(chars[i]);
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (this.getText().isEmpty()) {
			super.setText("");
			this.setForeground(Color.black);
			showingHint = false;
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (this.getText().isEmpty()) {
			super.setText(hint);
			this.setForeground(Color.gray);
			showingHint = true;
		}
	}

	public void putHint() {
		setText(hint);
		this.setForeground(Color.gray);
		showingHint = true;
	}

	@Override
	public void setText(String t) {
		super.setText(t);
		showingHint = false;
		this.setForeground(Color.black);
		if (t.equals("")) {
			putHint();
		}
	}

	@Override
	public String getText() {
		return showingHint ? "" : super.getText();
	}
}
