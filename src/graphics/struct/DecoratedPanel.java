package graphics.struct;

import graphics.MainPanel;
import graphics.SonPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class DecoratedPanel extends SonPanel {
	
	BufferedImage decoration;
	
	public DecoratedPanel() {
		
		setBackground(new Color(0, 0, 0, 0));
	}

	public DecoratedPanel(BufferedImage decoration) {
		
		this.decoration = decoration;
		setBackground(MainPanel.BACKGROUND);
	}
	
	public void setImage(BufferedImage decoration) {
		
		this.decoration = decoration;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		if (decoration != null)
			g.drawImage(decoration, 0, 0, this);
	}
}
