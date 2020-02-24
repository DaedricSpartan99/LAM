package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import graphics.struct.DecoratedPanel;
import graphics.struct.Decoration;
import graphics.struct.Decoration.Equation;
import graphics.struct.Table;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import math.Util;

public class ShowValues extends SonPanel implements ActionListener {
	
	Table show;
	DecoratedPanel bor_high, bor_left, generator;
	
	public static final int WIDTH = 300;
	public static final int HEIGHT = 440;
	public static final int BORDER_SIZE = MainPanel.BORDER_SIZE;
	public static final int SHOW_HEIGHT = 300;
	public static final Color EQ_COLOR = new Color(250, 175, 0, 255);
	
	public ShowValues() {
		
		super(null);
		this.setSize(WIDTH, HEIGHT);
		setBackground(MainPanel.TRANSPARENT);
		
		generator = new DecoratedPanel();
		show = new Table();
		bor_high = new DecoratedPanel();
		bor_left = new DecoratedPanel();
		
		bor_high.setBounds(0, 0, WIDTH, BORDER_SIZE);
		bor_left.setBounds(0, BORDER_SIZE, BORDER_SIZE, HEIGHT);
		generator.setBounds(BORDER_SIZE, BORDER_SIZE, WIDTH - BORDER_SIZE, HEIGHT - BORDER_SIZE - SHOW_HEIGHT);
		show.setBounds(BORDER_SIZE, HEIGHT - SHOW_HEIGHT, WIDTH - BORDER_SIZE, SHOW_HEIGHT);
		
		show.setBackground(new Color(0, 30, 5, 150));
		generator.setBackground(new Color(0, 5, 30, 150));
		
		show.indexField();
		show.index.addActionListener(this);
		
		add(generator, BorderLayout.EAST);
		add(show, BorderLayout.SOUTH);
		add(bor_high, BorderLayout.WEST);
		add(bor_left, BorderLayout.NORTH);
	}
	
	public void setEquation(byte index) {
		
		switch (index) {
		
		case ChoosePanel.CONG:
			generator.setImage(eq_cong(generator));
			break;
			
		case ChoosePanel.MIDSQ:
			generator.setImage(eq_midsq(generator));
			break;
			
		case ChoosePanel.FIB:
			generator.setImage(eq_fib(generator));
			break;
			
		case ChoosePanel.GSK:
			generator.setImage(eq_gsk(generator));
			break;
			
		case ChoosePanel.LFSR:
			generator.setImage(eq_lfsr(generator));
			break;
			
		case ChoosePanel.SHR3:
			generator.setImage(eq_shr3(generator));
			break;
			
		case ChoosePanel.MWC:
			generator.setImage(eq_mwc(generator));
			break;
			
		case ChoosePanel.KISS:
			generator.setImage(eq_kiss(generator));
			break;
		}
	}
	
	public void setTable(int[] x, float[] y) {
		
		if (x == null || y == null)
			return;
		
		show.removeAll();
		
		int n = x.length - Table.ind;
		
		if (n > 10)
			n = 10;
		
		if (n < 0)
			n = 0;
		
		for (int i = Table.ind; i < Table.ind + n; i++)
			show.add(x[i], y[i]);
	}
	
	
	public static final Decoration eq_cong(DecoratedPanel observer) {
		
		Decoration img = new Decoration(observer.getWidth(), observer.getHeight());
		int x = 20;
		int y = img.getHeight() / 2;
		int size = 21;
		Color color = EQ_COLOR;
		
		Equation eq = img.beginEq(x, y, size, color);
		
		img.draw(eq, "x");
		img.toIndex(eq);
		img.draw(eq, "n + 1");
		img.toIndexBase(eq);
		img.draw(eq, "= a");
		img.translate(eq, size / 7);
		img.cDot(eq);
		img.draw(eq, "x");
		img.toIndex(eq);
		img.draw(eq, "n");
		img.toIndexBase(eq);
		img.draw(eq, "+ c mod m");
		
		return img;
	}
	
	
	public static final Decoration eq_midsq(DecoratedPanel observer) {
		
		Decoration img = new Decoration(observer.getWidth(), observer.getHeight());
		int x = 20;
		int y = img.getHeight() / 2;
		int size = 21;
		Color color = EQ_COLOR;
		
		Equation eq = img.beginEq(x, y, size, color);
		
		img.draw(eq, "x");
		img.toIndex(eq);
		img.draw(eq, "n + 1");
		img.toIndexBase(eq);
		img.draw(eq, "= mid( x");
		img.toIndex(eq);
		img.translate(eq, size / 5);
		img.draw(eq, "n");
		img.toIndexBase(eq);
		img.toExp(eq);
		img.draw(eq, "2");
		img.toExpBase(eq);
		img.draw(eq, " , cifre )");
		
		return img;
	}
	
	public static final Decoration eq_fib(DecoratedPanel observer) {
		
		Decoration img = new Decoration(observer.getWidth(), observer.getHeight());
		int x = 20;
		int y = img.getHeight() / 4;
		int size = 21;
		Color color = EQ_COLOR;
		
		Equation eq = img.beginEq(x, y, size, color);
		
		img.draw(eq, "x");
		img.toIndex(eq);
		img.draw(eq, "n + 1");
		img.toIndexBase(eq);
		img.draw(eq, "= x");
		img.toIndex(eq);
		img.translate(eq, size / 7);
		img.draw(eq, "n");
		img.toIndexBase(eq);
		img.draw(eq, "+ x");
		img.toIndex(eq);
		img.translate(eq, size / 7);
		img.draw(eq, "n - 1");
		img.toIndexBase(eq);
		img.draw(eq, "mod m");
		
		eq = img.beginEq(x, 3 * y, size * 4 / 5, color);
		
		img.draw(eq, "x");
		img.toIndex(eq);
		img.draw(eq, "0");
		img.toIndexBase(eq);
		img.draw(eq, "= seed");
		
		eq = img.beginEq(x + observer.getWidth() / 2, 3 * y, size * 4 / 5, color);
		
		img.draw(eq, "x");
		img.toIndex(eq);
		img.draw(eq, "1");
		img.toIndexBase(eq);
		img.draw(eq, "= y");
		
		return img;
	}
	
	public static final Decoration eq_gsk(DecoratedPanel observer) {
		
		Decoration img = new Decoration(observer.getWidth(), observer.getHeight());
		int x = 20;
		int y = img.getHeight() / 4;
		int size = 21;
		Color color = EQ_COLOR;
		
		Equation eq = img.beginEq(x, y, size, color);
		
		img.draw(eq, "x");
		img.toIndex(eq);
		img.draw(eq, "n + 1");
		img.toIndexBase(eq);
		img.draw(eq, "= x");
		img.toIndex(eq);
		img.translate(eq, size / 7);
		img.draw(eq, "n");
		img.toIndexBase(eq);
		img.draw(eq, "+ x");
		img.toIndex(eq);
		img.translate(eq, size / 7);
		img.draw(eq, "n - k");
		img.toIndexBase(eq);
		img.draw(eq, "mod m");
		
		eq = img.beginEq(x, 3 * y, size * 4 / 5, color);
		
		img.draw(eq, "x");
		img.toIndex(eq);
		img.draw(eq, "0");
		img.toIndexBase(eq);
		img.draw(eq, "= seed");
		
		eq = img.beginEq(x + observer.getWidth() / 2, 3 * y, size * 4 / 5, color);
		
		img.draw(eq, "x");
		img.toIndex(eq);
		img.draw(eq, "1");
		img.toIndexBase(eq);
		img.draw(eq, "= y");
		
		return img;
	}
	
	public static final Decoration eq_lfsr(DecoratedPanel observer) {
		
		Decoration img = new Decoration(observer.getWidth(), observer.getHeight());
		int x = 20;
		int y = img.getHeight() / 4;
		int size = 20;
		Color color = EQ_COLOR;
		
		Equation eq = img.beginEq(x, y, size, color);
		
		img.vector(eq, "x");
		img.toIndex(eq);
		img.draw(eq, "n + 1");
		img.toIndexBase(eq);
		img.draw(eq, "= R");
		img.translate(eq, size / 2);
		img.cDot(eq);
		img.vector(eq, "x");
		img.toIndex(eq);
		img.draw(eq, "n");
		img.toIndexBase(eq);
		img.draw(eq, "+ ( ");
		img.vector(eq, "t");
		img.cDot(eq);
		img.vector(eq, "x");
		img.toIndex(eq);
		img.draw(eq, "n");
		img.toIndexBase(eq);
		img.draw(eq, " ");
		img.draw(eq, ")");
		img.cDot(eq);
		img.vector(eq, "e");
		img.toIndex(eq);
		img.draw(eq, "2");
		
		y *= 3;
		
		eq = img.beginEq(x, y, size, color);
		
		img.vector(eq, "t");
		img.draw(eq, "= ");
		img.drawSum(eq, "L", "i = 1");
		img.vector(eq, "e");
		img.toIndex(eq);
		img.draw(eq, "tap [ i ] + 1");
		
		return img;
	}
	
	public static final Decoration eq_shr3(DecoratedPanel observer) {
		
		Decoration img = new Decoration(observer.getWidth(), observer.getHeight());
		int x = 20;
		int y = img.getHeight() / 4;
		int size = 20;
		Color color = EQ_COLOR;
		
		Equation eq = img.beginEq(x, y, size, color);
		
		img.vector(eq, "x");
		img.toIndex(eq);
		img.draw(eq, "n + 1");
		img.toIndexBase(eq);
		img.draw(eq, "= T");
		img.translate(eq, size / 5);
		img.cDot(eq);
		img.vector(eq, "x");
		img.toIndex(eq);
		img.draw(eq, "n");
		
		eq = img.beginEq(x, y * 3, size - 9, color);
		
		img.draw(eq, "T = (I + R");
		img.toExp(eq);
		img.translate(eq, size / 2);
		img.draw(eq, "tap[ 3 ]");
		img.toExpBase(eq);
		img.draw(eq, ")");
		img.cDot(eq);
		img.draw(eq, "(I + L");
		img.translate(eq, size / 2);
		img.toExp(eq);
		img.draw(eq, "tap[ 2 ]");
		img.toExpBase(eq);
		img.draw(eq, ")");
		img.cDot(eq);
		img.draw(eq, "(I + R");
		img.translate(eq, size / 2);
		img.toExp(eq);
		img.draw(eq, "tap[ 1 ]");
		img.toExpBase(eq);
		img.draw(eq, ")");
		
		return img;
	}
	
	public static final Decoration eq_mwc(DecoratedPanel observer) {
		
		Decoration img = new Decoration(observer.getWidth(), observer.getHeight());
		int x = 20;
		int y = img.getHeight() / 4;
		int size = 19;
		Color color = EQ_COLOR;
		
		Equation eq = img.beginEq(x, y, size, color);
		
		img.draw(eq, "x");
		img.toIndex(eq);
		img.draw(eq, "n");
		img.toIndexBase(eq);
		img.draw(eq, "= a");
		img.translate(eq, size / 7);
		img.cDot(eq);
		img.draw(eq, "x");
		img.toIndex(eq);
		img.translate(eq, size / 7);
		img.draw(eq, "n - k");
		img.toIndexBase(eq);
		img.draw(eq, "+ c");
		img.toIndex(eq);
		img.translate(eq, size / 7);
		img.draw(eq, "n - 1");
		img.toIndexBase(eq);
		img.draw(eq, "mod m");
		
		eq = img.beginEq(x, y * 3, size, color);
		
		img.draw(eq, "c");
		img.toIndex(eq);
		img.draw(eq, "n");
		img.toIndexBase(eq);
		img.draw(eq, "= ");
		img.frac(eq, 7 * size);
		img.enumerator(eq, 0.05f, 6 * size);
		img.draw(eq, "a");
		img.cDot(eq);
		img.draw(eq, "x");
		img.toIndex(eq);
		img.translate(eq, size / 7);
		img.draw(eq, "n - k");
		img.toIndexBase(eq);
		img.draw(eq, "+ c");
		img.toIndex(eq);
		img.translate(eq, size / 7);
		img.draw(eq, "n - 1");
		img.toIndexBase(eq);
		
		img.toFracBase(eq, true, -6 * size);
		img.denominator(eq, 0.4f, 6 * size);
		img.draw(eq, "m");
		
		return img;
	}
	
	public static final Decoration eq_kiss(DecoratedPanel observer) {
		
		Decoration img = new Decoration(observer.getWidth(), observer.getHeight());
		int x = 10;
		int y = img.getHeight() / 2;
		int size = 10;
		Color color = EQ_COLOR;
		
		Equation eq = img.beginEq(x, y, size, color);
		
		img.draw(eq, "x");
		img.toIndex(eq);
		img.draw(eq, "n + 1");
		img.toIndexBase(eq);
		img.draw(eq, "= MWC(x");
		img.translate(eq, size * 8 / 15);
		img.toIndex(eq);
		img.translate(eq, size * 9 / 10);
		img.draw(eq, "n");
		img.toIndexBase(eq);
		img.translate(eq, size / 3);
		img.draw(eq, ") + LinCon(x");
		img.toIndex(eq);
		img.translate(eq, size * 7 / 10);
		img.draw(eq, "n");
		img.toIndexBase(eq);
		img.translate(eq, size / 3);
		img.draw(eq, ") + xOrSh(x");
		img.toIndex(eq);
		img.translate(eq, size * 8 / 10);
		img.draw(eq, "n");
		img.toIndexBase(eq);
		img.translate(eq, size / 3);
		img.draw(eq, ")");
		
		return img;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		load();
	}

}
