package graphics.struct;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Decoration extends BufferedImage {
	
	public Graphics2D g;
	public static final int COLOR_RANGE = (int)Math.pow(2, 24);

	public Decoration(int width, int height) {
		
		super(width, height, BufferedImage.TYPE_INT_ARGB);
		g = createGraphics();
	}
	
	public void pixel(int x, int y, int red, int green, int blue) {
		
		setRGB(x, y, color(red, green, blue));
	}
	
	public void pixel(int x, int y, int red, int green, int blue, int alpha) {
		
		int color = this.getRGB(x, y);
		
		int _red = red(color);
		int _green = green(color);
		int _blue = blue(color);
		int _alpha = 255 - alpha;
		
		red = (alpha * red + _alpha * _red) / 510;
		green = (alpha * green + _alpha * _green) / 510;
		blue = (alpha * blue + _alpha * _blue) / 510;
		
		pixel(x, y, red, green, blue);
	}
	
	public static int color(int red, int green, int blue) {
		
		return (int)Math.pow(2, 16) * red + (int)Math.pow(2, 8) + blue - COLOR_RANGE;
	}
	
	public static int red(int color) {
		
		color += COLOR_RANGE;
		color /= (int)Math.pow(2, 16);
		return color % 256;
	}
	
	public static int green(int color) {
		
		color += COLOR_RANGE;
		color /= 256;
		return color % 256;
	}
	
	public static int blue(int color) {
		
		color += COLOR_RANGE;
		return color % 256;
	}

	public void gradientLine(int x0, int y0, int x1, int y1, int red0, int green0, int blue0, int red1, int green1, int blue1) {
		
		boolean length_w = x1 - x0 > y1 - y0;
		int width = x1 - x0;
		int height = y1 - y0;
		float x = (float) x0;
		float y = (float) y0;
		float red = (float) red0;
		float green = (float) green0;
		float blue = (float) blue0;
		
		while(x == x1 || y == y1) {
			
			pixel((int)x, (int)y, (int)red, (int)green, (int)blue);
			
			if (length_w) {
				x += 1f;
				y += height / width;
			} else {
				x += width / height;
				y += 1f;
			}
			
			if (length_w) {
				red += (red1 - red0) / width;
				green += (green1 - green0) / width;
				blue += (blue1 - blue0) / width;
			} else {
				red += (red1 - red0) / height;
				green += (green1 - green0) / height;
				blue += (blue1 - blue0) / height;
			}
		}
		
		pixel(x1, y1, red1, green1, blue1);
	}
	
	public Equation beginEq(int x, int y, int size, Color color) {
		
		Equation eq = new Equation();
		eq.x = x;
		eq.y = y;
		eq.size = new Font(Font.SERIF, Font.ITALIC, size);
		eq.color = color;
		g.setFont(eq.size);
		g.setColor(eq.color);
		g.setRenderingHint(
		        RenderingHints.KEY_TEXT_ANTIALIASING,
		        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		
		return eq;
	}
	
	public Equation draw(Equation eq, String arg) {
		
		g.drawString(arg, eq.x, eq.y);
		eq.x += eq.size.getSize() * arg.length() / 2;
		
		return eq;
	}
	
	public Equation translate(Equation eq, int translation) {
		
		eq.x += translation;
		return eq;
	}
	
	public Equation cDot(Equation eq) {
		
		eq.x += eq.size.getSize() / 5;
		g.drawOval(eq.x, eq.y - eq.size.getSize() / 4, eq.size.getSize() / 8, eq.size.getSize() / 8);
		eq.x += eq.size.getSize() / 3;
		
		return eq;
	}
	
	public Equation frac(Equation eq, int length) {
		
		eq.y -= eq.size.getSize() * 2 / 5;
		g.drawLine(eq.x, eq.y, eq.x + length, eq.y);
		
		return eq;
	}
	
	public Equation enumerator(Equation eq, float position, int length) {
		
		eq.x += position * length;
		eq.y -= (int)(eq.size.getSize() * 0.4f);
		
		return eq;
	}
	
	public Equation denominator(Equation eq, float position, int length) {
		
		eq.x += position * length;
		eq.y += eq.size.getSize();
		
		return eq;
	}
	
	public Equation toFracBase(Equation eq, boolean enumer, int translation) {
		
		if (enumer) {
			eq.y += (int)(eq.size.getSize() * 0.4f);
		} else {
			eq.y -= eq.size.getSize();
		}
		
		translate(eq, translation);
		
		return eq;
	}
	
	public Equation toExp(Equation eq) {
		
		eq.x -= eq.size.getSize() * 3 / 12;
		eq.y -= eq.size.getSize() * 6 / 10;
		eq.size = eq.size.deriveFont((float)eq.size.getSize() / 1.75f);
				
		g.setFont(eq.size);
		
		return eq;
	}
	
	public Equation toExpBase(Equation eq) {
		
		eq.x += eq.size.getSize() / 12;
		eq.y += eq.size.getSize();
		eq.size = eq.size.deriveFont((float)eq.size.getSize() * 1.75f);
		
		g.setFont(eq.size);
		
		return eq;
	}
	
	public Equation toIndex(Equation eq) {
		
		eq.x += eq.size.getSize() / 10;
		eq.y += eq.size.getSize() * 3 / 10;
		eq.size = eq.size.deriveFont((float)eq.size.getSize() / 1.75f);
		
		g.setFont(eq.size);
		
		return eq;
	}
	
	public Equation toIndexBase(Equation eq) {
		
		eq.x += eq.size.getSize() / 3;
		eq.y -= eq.size.getSize() * 45 / 100;
		eq.size = eq.size.deriveFont((float)eq.size.getSize() * 1.75f);
		
		g.setFont(eq.size);
		
		return eq;
	}
	
	public Equation drawSum(Equation eq, String exp, String ind) {
		
		g.setFont(new Font(Font.SERIF, Font.ITALIC, eq.size.getSize() * 3 / 5));
		
		g.drawString(exp, eq.x + eq.size.getSize() * 0.5f, eq.y - eq.size.getSize() * 1.3f);
		g.drawString(ind, eq.x - eq.size.getSize() * 0.1f, eq.y + eq.size.getSize() * 1.0f);
		
		g.setFont(new Font(Font.SERIF, Font.ITALIC, eq.size.getSize() * 2));
		g.drawString("\u03A3", eq.x, eq.y + eq.size.getSize() * 3 / 10);
		g.setFont(new Font(Font.SERIF, Font.ITALIC, eq.size.getSize()));
		
		eq.x += eq.size.getSize() * 3 / 2;
		
		return eq;
	}
	
	public Equation vector(Equation eq, String arg) {
		
		g.drawString(arg, eq.x, eq.y);
		
		eq.y -= eq.size.getSize() * 9 / 11;
		g.drawLine(eq.x, eq.y, eq.x + eq.size.getSize() * arg.length() / 2, eq.y);
		eq.x += eq.size.getSize() * arg.length() / 2;
		g.drawLine(eq.x, eq.y, eq.x - eq.size.getSize() * arg.length() / 10, eq.y - eq.size.getSize() / 8);
		g.drawLine(eq.x, eq.y, eq.x - eq.size.getSize() * arg.length() / 10, eq.y + eq.size.getSize() / 8);
		
		eq.y += eq.size.getSize() * 9 / 11;
		
		eq.x += eq.size.getSize() * arg.length() / 6;
		
		return eq;
	}
	
	public static class Equation {
		
		public int x, y;
		public Font size;
		public Color color;
	}
}
