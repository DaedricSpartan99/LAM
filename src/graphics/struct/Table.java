package graphics.struct;

import graphics.SonPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import math.Util;

public class Table extends SonPanel implements ActionListener {
	
	ArrayList<NumberedBox> table;
	public InputField index;
	NumberedBox axys;
	JLabel visual;
	
	public static final Border BOX_BORDER = BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, new Color(40, 80, 30, 220), new Color(60, 40, 30, 220)), new EmptyBorder(0, 20, 0, 0));
	public static final int BOX_SIZE = 25;
	
	public static int ind = 0;
	private static int width;
	
	public Table() {
		
		super(null);
		
		setBorder(null);
		
		table = new ArrayList<NumberedBox>(0);
	}
	
	public void indexField() {
		
		width = getWidth();
		
		index = new InputField("1");
		index.setBounds(getWidth() / 2, 0, getWidth() / 3, BOX_SIZE);
		index.addActionListener(this);
		index.removeKeyListener(index);
		add(index);
		
		visual = new JLabel("Visual. da: ");
		visual.setSize(getWidth() * 45 / 100, BOX_SIZE);
		visual.setLocation(10, 0);
		visual.setFont(new Font(Font.SERIF, Font.ITALIC, BOX_SIZE * 3 / 5));
		visual.setForeground(new Color(255, 255, 255, 220));
		
		add(visual);
		
		axys = new NumberedBox("x", "random(x)", 1);
		axys.setBoxBorder(new EmptyBorder(0, 20, 0, 0));
		add(axys);
		
	}
	
	public void add(int x, float y) {
		
		NumberedBox box = new NumberedBox(x, y, table.size() + 2);
		table.add(box);
		add(box);
	}
	
	public void remove(int index) {
		
		remove(table.get(index));
		table.remove(index);
	}
	
	@Override
	public void removeAll() {
		
		super.removeAll();
		add(index);
		add(visual);
		add(axys);
		table.clear();
	}
	
	public static class NumberedBox extends JPanel {
		
		JLabel xlab, ylab;
		Border box_border;
		public Font box_font;
		public Color box_color;
		
		public NumberedBox(int x, float y, int position) {
			
			super(null);
			
			setLocation(0, position * BOX_SIZE);
			setSize(width, BOX_SIZE);
			setBackground(null);
			
			box_border = BOX_BORDER;
			box_font = new Font(Font.SERIF, Font.ITALIC, BOX_SIZE * 3 / 5);
			box_color = new Color(255, 255, 255, 220);
			
			xlab = new JLabel(String.valueOf(x));
			xlab.setSize(getWidth() * 47 / 100, BOX_SIZE);
			xlab.setLocation(0, 0);
			xlab.setFont(box_font);
			xlab.setForeground(box_color);
			xlab.setBorder(box_border);
			
			String _y;
			
			if (y >= 100000) {
				
				int exp = (int)Math.log10(y);
				y = Util.round(y / (float)Math.pow(10, exp), 2);
				_y = String.valueOf(y) + "e" + String.valueOf(exp);
				
			} else
				_y = String.valueOf(y);
			
			ylab = new JLabel(_y);
			ylab.setSize(getWidth() * 47 / 100, BOX_SIZE);
			ylab.setLocation(getWidth() * 47 / 100, 0);
			ylab.setFont(box_font);
			ylab.setForeground(box_color);
			ylab.setBorder(box_border);
			
			add(xlab);
			add(ylab);
		}
		
		public NumberedBox(String x, String y, int position) {
			
			super(null);
			
			setLocation(0, position * BOX_SIZE);
			setSize(width, BOX_SIZE);
			setBackground(null);
			
			box_border = BOX_BORDER;
			box_font = new Font(Font.SERIF, Font.ITALIC, BOX_SIZE * 3 / 5);
			box_color = new Color(255, 255, 255, 220);
			
			xlab = new JLabel(x);
			xlab.setSize(width * 47 / 100, BOX_SIZE);
			xlab.setLocation(0, 0);
			xlab.setFont(box_font);
			xlab.setForeground(box_color);
			xlab.setBorder(box_border);
			
			ylab = new JLabel(y);
			ylab.setSize(width * 47 / 100, BOX_SIZE);
			ylab.setLocation(width * 47 / 100, 0);
			ylab.setFont(box_font);
			ylab.setForeground(box_color);
			ylab.setBorder(box_border);
			
			add(xlab);
			add(ylab);
		}
		
		public void setBoxBorder(Border border) {
			
			xlab.setBorder(border);
			ylab.setBorder(border);
		}
	}

	@Override
	public synchronized void actionPerformed(ActionEvent e) {
		
		InputField text;
		
		try {
			text = (InputField)e.getSource();
		} catch (Exception ex) {
			return;
		}
		
		ind = (int)text.getInput() - 1;
		
		if (ind <= -1)
			ind = 0;
	}
}
