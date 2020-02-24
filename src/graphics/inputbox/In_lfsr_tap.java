package graphics.inputbox;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import math.Generators;
import graphics.struct.Decoration;
import graphics.struct.Icon;
import graphics.struct.IconButton;
import graphics.struct.InputArrayBox;

public class In_lfsr_tap extends InputArrayBox {
	
	public static final int BUTTON_SIZE = 30;
	
	public static int index = 0;
	public JButton plus, minus;
	JLabel len;
	
	public In_lfsr_tap() {
		super("tap:", Generators.LFSR_TAP, "Bit");
		
		try {
			select(index);
		} catch (IllegalArgumentException e) {
			select(index - 1);
		}
		
		plus = new IconButton(Icon.plus(), BUTTON_SIZE);
		plus.setLocation(20, 4 * HEIGHT / 5 - 10);
		plus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				plus();
				setVar();
				/*
				int size = Generators.LFSR_TAP.length + 1;
				
				int[] tmp = new int[size];
				
				for (int i = 0; i < size; i++) {
					if (i == size - 1)
						tmp[i] = 1;
					else
						tmp[i] = Generators.LFSR_TAP[i];
				}
				
				Generators.LFSR_TAP = tmp;
				*/
			}
			
		});
		
		minus = new IconButton(Icon.minus(), BUTTON_SIZE);
		minus.setLocation(80, 4 * HEIGHT / 5 - 10);
		minus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				minus();
				setVar();
				/*
				int size = Generators.LFSR_TAP.length;
				
				int[] tmp = new int[size - 1];
				
				for (int i = 0; i < size; i++) {
					if (i == size - 1)
						tmp[i] = 1;
					else
						tmp[i] = Generators.LFSR_TAP[i];
				}
				
				Generators.LFSR_TAP = tmp;
				*/
			}
			
		});
		
		len = new JLabel("L = " + String.valueOf(choose.getItemCount()));
		len.setFont(new Font(Font.SERIF, Font.ITALIC, 17));
		len.setForeground(new Color(255, 255, 255, 220));
		len.setBounds(choose.getX() + choose.getWidth() + 10, choose.getY(), 50, 25);
		
		add(plus);
		add(minus);
		add(len);
	}

	@Override
	public void setVar() {
		
		if (getValue() < 1 || getValue() > 32) {
			return;
		}
			
		list.set(choose.getSelectedIndex(), getValue());
		
		Generators.LFSR_TAP = getValues();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		super.actionPerformed(e);
		index = selection();
	}

}
