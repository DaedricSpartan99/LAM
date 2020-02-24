package graphics;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class Menu extends JMenuBar implements MouseListener {
	
	public static final int MENU_HEIGHT = 20;
	JMenu file;

	public Menu() {
		
		setSize(Main.WINDOW_WIDTH, MENU_HEIGHT);
		setBackground(new Color(240, 255, 255, 150));
		
		file = new JMenu("File");
		file.setBackground(getBackground());
		file.setBounds(20, 0, 50, MENU_HEIGHT);
		file.addMouseListener(this);
		
		add(file);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		JMenu menu = (JMenu)e.getSource();
		menu.setBackground(getBackground());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		JMenu menu = (JMenu)e.getSource();
		menu.setBackground(getBackground());
	}
}
