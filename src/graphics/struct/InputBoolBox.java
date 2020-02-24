package graphics.struct;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

public abstract class InputBoolBox extends InputBox {
	
	public static final int HEIGHT = InputBox.HEIGHT + 50;
	
	public JRadioButton tr, fa;

	public InputBoolBox(String msg, String tru, String fal, boolean value) {
		
		super(msg, 0);
		setSize(WIDTH, HEIGHT);
		
		message.setSize(WIDTH, message.getHeight());
		
		remove(input);
		
		tr = new JRadioButton(tru);
		tr.setBounds(15, HEIGHT / 2 - 5, WIDTH - 15, 25);
		
		fa = new JRadioButton(fal);
		fa.setBounds(15, 3 * HEIGHT / 4, WIDTH - 15, 25);
		fa.setBackground(new Color(220, 220, 250));
		fa.setForeground(new Color(10, 10, 10));
		
		
		setBoolValue(value);
		
		ButtonGroup but = new ButtonGroup();
		but.add(tr);
		but.add(fa);
		
		add(tr);
		add(fa);
		
	}
	
	public boolean getBoolValue() {
		
		return tr.isSelected();
	}
	
	public void setBoolValue(boolean value) {
		
		tr.setSelected(value);
		fa.setSelected(!value);
	}
	
	@Override
	public void addActionListener(ActionListener al) {
		tr.addActionListener(al);
		fa.addActionListener(al);
	}

}
