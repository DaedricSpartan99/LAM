package graphics.struct;

import java.awt.Color;
import java.awt.Graphics2D;

public class Icon {
	
	public static final int WIDTH = 100;
	public static final int HEIGHT = 100;

	public static final Decoration IMG_1() {
		
		Decoration img = new Decoration(WIDTH, HEIGHT);
		Graphics2D g = img.g;
		
		g.setColor(new Color(200, 200, 100));
		g.fillRect(20, 20, 60, 60);
		g.setColor(Color.black);
		g.drawRect(20, 20, 60, 60);
		
		return img;
	}
	
	public static final Decoration plus() {
		
		Decoration img = new Decoration(WIDTH, HEIGHT);
		Graphics2D g = img.g;
		
		g.setColor(new Color(50, 50, 50));
		g.fillRect(40, 20, 20, 60);
		g.fillRect(20, 40, 60, 20);
		
		return img;
	}
	
	public static final Decoration minus() {
		
		Decoration img = new Decoration(WIDTH, HEIGHT);
		Graphics2D g = img.g;
		
		g.setColor(new Color(50, 50, 50));
		g.fillRect(20, 40, 60, 20);
		
		return img;
	}
}
