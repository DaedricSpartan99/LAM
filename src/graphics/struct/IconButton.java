package graphics.struct;

import java.awt.Graphics;

import javax.swing.JButton;

public class IconButton extends JButton {
	
	Decoration dc;
	
	public IconButton(Decoration dc, int size) {
		
		setSize(size, size);
		this.dc = dc;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.drawImage(dc, 0, 0, getWidth(), getHeight(), null);
	}

}
