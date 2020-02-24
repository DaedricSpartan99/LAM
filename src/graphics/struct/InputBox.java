package graphics.struct;

import graphics.Accessible;
import graphics.SonPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import math.Generators;

public abstract class InputBox extends SonPanel {
	
	public static final int WIDTH = 150;
	public static final int HEIGHT = 50;
	
	JLabel message;
	protected InputField input;
	
	public InputBox(String msg, int init) {
		
		super(null);
		setBackground(new Color(0, 0, 0, 50));
		
		message = new JLabel(msg);
		input = new InputField(String.valueOf(init));
		input.removeKeyListener(input);
		
		setSize(WIDTH, HEIGHT);
		
		message.setFont(new Font(Font.SERIF, Font.ITALIC, 17));
		message.setForeground(new Color(255, 255, 255, 220));
		message.setBounds(10, 10, 50, HEIGHT / 2);
		
		input.setBounds(50, 15, 90, 20);
		
		add(message);
		add(input);
	}
	
	public InputBox(String msg, float init) {
		
		super(null);
		setBackground(new Color(0, 0, 0, 50));
		
		message = new JLabel(msg);
		input = new InputField(String.valueOf(init));
		input.removeKeyListener(input);
		
		setSize(WIDTH, HEIGHT);
		
		message.setFont(new Font(Font.SERIF, Font.ITALIC, 17));
		message.setForeground(new Color(255, 255, 255, 220));
		message.setBounds(10, 10, 50, HEIGHT / 2);
		
		input.setBounds(50, 15, 90, 20);
		
		add(message);
		add(input);
	}
	
	public void addActionListener(ActionListener al) {
		input.addActionListener(al);
	}
	
	public int getValue() {
		
		long in = input.getInput();
		
		if (in > Generators.BIT32_MOD) {
			in = Generators.BIT32_MOD;
			input.setText("Corretto a 2^31 - 1");
		}
		
		return (int) in;
	}
	
	public float getFloatValue() {
		
		return input.getFloatInput();
	}
	
	public void setValue(int out) {
		
		input.setText(String.valueOf(out));
	}
	
	public abstract void setVar();

}
