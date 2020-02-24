package graphics.struct;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;

public class InputField extends JTextField implements MouseListener, KeyListener {
	
	public static final long ILLEGAL_VALUE = -1L;
	
	String defaultText;
	
	public InputField(String defaultText) {
		
		super(defaultText);
		
		this.defaultText = defaultText;
		
		addMouseListener(this);
		addKeyListener(this);
	}
	
	public long getInput() {
		
		String text = getText();
		
		Long input;
		
		try {
			
			input = Long.parseLong(text);
			
			if (input < 0)
				throw new IllegalArgumentException();
			
		} catch (IllegalArgumentException e) {
			setText("Valore non valido");
			input = ILLEGAL_VALUE;
		} catch (NullPointerException e) {
			input = ILLEGAL_VALUE;
		}
		
		return input;
	}
	
	public float getFloatInput() {
		
		String text = getText();
		
		float input;
		
		try {
			
			input = Float.parseFloat(text);
			
			if (input < 0)
				throw new IllegalArgumentException();
			
		} catch (IllegalArgumentException e) {
			setText("Valore non valido");
			input = ILLEGAL_VALUE;
		} catch (NullPointerException e) {
			input = ILLEGAL_VALUE;
		}
		
		return input;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		

	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if (getText().equals(defaultText))
			setText("");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		setText("");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
