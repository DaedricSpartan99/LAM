package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class Main extends JFrame implements WindowListener, KeyListener, ActionListener {
	
	public static final int WINDOW_X = 30;
	public static final int WINDOW_Y = 30;
	public static final int WINDOW_WIDTH = 1200;
	public static final int WINDOW_HEIGHT = 700;
	
	public static void main(String[] args) {
		
		Main frame = new Main();
		frame.setVisible(true);
	}
	
	MainPanel panel = new MainPanel();
	Menu menu;
	Event listener;
	
	public static boolean running;
	
	public Main() {
		
		setBounds(WINDOW_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
		setMaximumSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		setTitle("Metodo Monte Carlo");
		addWindowListener(this);
		setResizable(false);
		
		addKeyListener(this);
		setFocusable(true);
		
		//listener = new Event();
		
		panel = new MainPanel();
		panel.addKeyListener(this);
		panel.setActionListeners(this);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		setContentPane(panel);
		
		//menu = new Menu();
		
		//add(menu);
	}
	
	@Override
	public void validate() {
		
		super.validate();
		panel.repaint();
	}

	@Override
	public void windowOpened(WindowEvent e) {
		
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		
		MainPanel.running = false;
		panel.contentGraph.graph.breakloop();
		System.exit(0);
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		
		this.requestFocus();
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.isControlDown()) {
			
			switch (e.getKeyCode()) {
			
			case KeyEvent.VK_F4:
				System.exit(0);
				break;
			
			case KeyEvent.VK_R:
				panel.load();
				break;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		panel.load();
		panel.load();
	}
}
