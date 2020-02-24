package graphics;

import graphics.struct.InputField;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InputPanel extends SonPanel {
	
	public static final int WIDTH = 350;
	
	public InputField seed, number;
	private JLabel _seed, _number;
	public JButton _run;

	public InputPanel() {
		
		super(null);
		setSize(WIDTH, VarPanel.COMP_HEIGHT);
		setBackground(new Color(0, 0, 0, 150));
		
		seed = new InputField("Qual'è il seed?");
		seed.setBounds(WIDTH / 2, VarPanel.COMP_HEIGHT / 4, WIDTH / 2 - 20, 20);
		
		number = new InputField("Quanti numeri?");
		number.setBounds(WIDTH / 2, 2 * VarPanel.COMP_HEIGHT / 4, WIDTH / 2 - 30, 20);
		
		Font font = new Font(Font.SERIF, Font.ITALIC, 20);
		Color foreground = new Color(255, 255, 255, 220);
		
		_seed = new JLabel("Seed:");
		_seed.setBounds(50, VarPanel.COMP_HEIGHT / 6, WIDTH / 2 - 50, VarPanel.COMP_HEIGHT / 5);
		_seed.setFont(font);
		_seed.setForeground(foreground);
		
		_number = new JLabel("Quanti:");
		_number.setBounds(50, 11 * VarPanel.COMP_HEIGHT / 30, WIDTH / 2 - 50, VarPanel.COMP_HEIGHT / 5);
		_number.setFont(font);
		_number.setForeground(foreground);
		
		_run = new JButton("Calcola");
		_run.setBounds(WIDTH / 2 + 30, 3 * VarPanel.COMP_HEIGHT / 4, WIDTH / 4, 30);
		
		add(seed);
		add(number);
		add(_seed);
		add(_number);
		add(_run);
	}
}
