package graphics;

import graphics.struct.DecoratedPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class VarPanel extends SonPanel implements ActionListener {
	
	public static final int COMP_HEIGHT = Main.WINDOW_HEIGHT - ShowValues.HEIGHT - 2 * MainPanel.BORDER_SIZE;
	public static final int SPACE_WIDTH = Main.WINDOW_WIDTH - InputPanel.WIDTH - ModifyPanel.WIDTH - ChoosePanel.WIDTH;
	
	InputPanel input;
	ModifyPanel mod;
	ChoosePanel choose;
	DecoratedPanel top, mid;
	
	public VarPanel() {
		
		super(null);
		setSize(Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT - ShowValues.HEIGHT);
		setBackground(MainPanel.TRANSPARENT);
		
		input = new InputPanel();
		input.setLocation(0, MainPanel.BORDER_SIZE);
		
		mod = new ModifyPanel();
		mod.setLocation(Main.WINDOW_WIDTH - ModifyPanel.WIDTH, MainPanel.BORDER_SIZE);
		
		choose = new ChoosePanel();
		choose.setLocation(SPACE_WIDTH + InputPanel.WIDTH, MainPanel.BORDER_SIZE);
		
		top = new DecoratedPanel();
		top.setBounds(0, 0, Main.WINDOW_WIDTH, MainPanel.BORDER_SIZE);
		
		mid = new DecoratedPanel();
		mid.setBounds(InputPanel.WIDTH, MainPanel.BORDER_SIZE, SPACE_WIDTH, COMP_HEIGHT);
		
		/**
		 * add relatives panels
		 */
		
		add(input);
		add(mod);
		add(choose);
		add(top);
		add(mid);
	}
	
	@Override
	public void setAccessible(Accessible link) {
		super.setAccessible(link);
		input.setAccessible(link);
		mod.setAccessible(link);
		choose.setAccessible(link);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
