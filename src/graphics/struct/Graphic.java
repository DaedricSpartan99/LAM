package graphics.struct;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import math.Util;

public class Graphic extends JPanel {
	
	private BufferedImage buffer;
	private Graphics2D g;
	private int width, height, x0, y0, xf, yf;
	private boolean stop;
	private int[] X;
	private float[] Y;
	private Color color_points, color_grid, color_axys;
	
	public static long t_draw = 0;
	
	public static final int WIDTH_DEF = 1000;
	public static final int HEIGHT_DEF = 600;
	
	public Graphic() {
		
		super(null, true);
		
		color_points = new Color(150, 150, 250, 240);
		color_axys = new Color(255, 150, 50, 240);
		color_grid = new Color(100, 100, 100, 30);
		
		buffer = null;
		stop = false;
	}
	
	public void setAxys(int[] X, float Y[]) {
		
		this.X = X;
		this.Y = Y;
		
		sort_Y();
		sort_X();
		
		repaint();
	}

	public synchronized void paintGraph() {
		
		width = (getWidth() != 0) ? getWidth() : WIDTH_DEF;
		height = (getHeight() != 0) ? getHeight() : HEIGHT_DEF;
				
		this.render();
		
		this.paintBuffer();
	}
	
	private void render() {
		
		buffer = null;
		
		if (buffer == null) {
			buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			if (buffer == null) {
				System.out.println("Buffer is null");
				return;
			} else {
				g = buffer.createGraphics();
			}
		}
	}
	
	private synchronized void paintBuffer() {
		
		if (g != null) {
		
			base();
		
			if (X != null && Y != null)
				points();
		}
	}
	
	@Override
	public synchronized void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		if ((buffer != null) && (g != null))
			g.drawImage(buffer, 0, 0, this); // Draw the buffer Image (second buffer)
	}
	
	public synchronized void breakloop() {
		
		stop = true;
	}
	
	private void base() {
		
		x0 = 80 * width / WIDTH_DEF;
		y0 = 500 * height / HEIGHT_DEF;
		xf = 920 * width / WIDTH_DEF;
		yf = 40 * height / HEIGHT_DEF;
		
		g.setColor(color_axys);

		g.drawLine(0, y0, width, y0); //axys x
		g.drawLine(x0, 0, x0, height);	// axys y
		g.drawString("0", x0 - 20, y0 + 25); // write "0"
		
		int max_x = (X != null) ? X[X.length - 1] : 16;
		
		g.drawLine(xf, y0, xf, y0 - 10); // ref x
		
		for(int i = 1; i <= 16; i++) {
			
			int x_i = x0 + (int)(i * (xf - x0)/ 16);
			g.drawLine(x_i, y0, x_i, y0 - 5);
			
			if ((i & 1) == 0) {
				
				float xRif = Util.round((float)max_x * i / 16, 2);
				
				String xRif_str;
				
				if (xRif >= 10000f) {
					
					int exp = (int)Math.log10(xRif);
					xRif = Util.round(xRif / (float)Math.pow(10, exp), 2);
					xRif_str = String.valueOf(xRif) + "e" + String.valueOf(exp);
					
				} else
					xRif_str = String.valueOf(xRif);
				
				g.drawString(xRif_str, x_i - 10, y0 + 20);
			}
		}
		
		
		g.drawLine(x0, yf, x0 + 10, yf); // ref y
		
		for(int i = 1; i <= 8; i++) {
			
			int y_i = y0 - (int)(i * (y0 - yf)/ 8);
			g.drawLine(x0, y_i, x0 + 5, y_i);
			
			if (i % 2 == 0) {
				
				float max_y = (Y != null) ? Util.maxValue(Y) : 16;
				
				float yRif = Util.round((float)max_y * i / 8, 2);
				
				String yRif_str;
				
				if (yRif >= 10000) {
					
					int exp = (int)Math.log10(yRif);
					yRif = Util.round(yRif / (float)Math.pow(10, exp), 2);
					yRif_str = String.valueOf(yRif) + "e" + String.valueOf(exp);
					
				} else if (yRif >= 1000 && yRif < 10000) {
					
					yRif_str = String.valueOf(Util.round(yRif, 1));
					
				} else
					yRif_str = String.valueOf(yRif);
				
				g.drawString(yRif_str, x0 * 9 / 10 - yRif_str.length() * width / 100, y_i + 5);
			}
		}
		
		g.setColor(color_grid); // grid color
		
		for(int i = 1; i < 56; i++) {
			
			g.drawLine(width * i / 50, 0, width * i / 50, height); // grid axys y
			g.drawLine(0, height * i / 30, width, height * i / 30); // grid axys x
		}
	}
	
	private void points() {
		
		g.setColor(color_points);
		
		int max_x = Util.maxValue(X);
		float max_y = Util.maxValue(Y);
		
		long t_0 = System.currentTimeMillis();
		
		stop = false;
		
		for(int i = 0; i < X.length; i++) {
			
			if (max_y == 0)
				max_y = 1;
			
			int x = (int)((x0 - 1) + (long)21 * width * X[i] / (max_x * 25));
			int y = (int)(y0 - (long)23 * height * Y[i] / (max_y * 30) - 2);
			
			g.fillOval(x, y, 3, 4);
			
			t_draw = System.currentTimeMillis() - t_0;
			
			if(stop)
				return;
		}
	}
	
	private void sort_Y() {
		
		boolean flag = false;
		
		for (int i = 0; i < Y.length; i++) {
			
			flag = false;
			
			for(int j = 0; j < Y.length - 1; j++) {
				
				if(X[j] > X[j+1]) {
					
					float k = Y[j];
                	Y[j] = Y[j+1];
               		Y[j+1] = k;
                    flag = true;
                }
			}
			
			if (!flag)
				break;
		}
	}
	
	private void sort_X() {
		
		boolean flag = false;
		
		for (int i = 0; i < X.length; i++) {
			
			flag = false;
			
			for(int j = 0; j < X.length - 1; j++) {
				
				if(X[j] > X[j+1]) {
					
					int k = X[j];
                	X[j] = X[j+1];
               		X[j+1] = k;
                    flag = true;
                }
			}
			
			if (!flag)
				break;
		}
	}
}
