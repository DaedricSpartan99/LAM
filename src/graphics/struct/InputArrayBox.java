package graphics.struct;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public abstract class InputArrayBox extends InputBox implements ActionListener {
	
	public static final int HEIGHT = InputBox.HEIGHT * 5 / 2;
	
	protected JComboBox<String> choose;
	protected ArrayList<Integer> list;
	String obj;
	
	public InputArrayBox(String msg, int[] list, String obj) {
		
		super(msg, list[0]);
		
		this.obj = obj;
		this.list = new ArrayList<Integer>(31);
		choose = new JComboBox<String>();
		
		for (int i = 0; i < list.length; i++) {
			this.list.add(list[i]);
			choose.addItem(obj + " " + String.valueOf(i + 1));
		}
		
		choose.addActionListener(this);
		
		setSize(WIDTH, HEIGHT);
		
		choose.setBounds(10, HEIGHT / 2 - 5, WIDTH / 2 + 10, 20);
		
		add(choose);
	}
	
	public void plus() {
		
		choose.addItem(obj + " " + String.valueOf(choose.getItemCount() + 1));
		
		list.add(1);
		this.setValue(list.get(list.size() - 1));
		
		choose.setSelectedItem(choose.getItemAt(choose.getItemCount() - 1));
	}
	
	public void minus() {
		
		int index = choose.getSelectedIndex();
		choose.removeItemAt(index);;
		list.remove(index);
		
		if (index == 0)
			index = 1;
		
		choose.setSelectedIndex(index - 1);
		this.setValue(list.get(index - 1));
	}
	
	public void select(int index) {
		
		choose.setSelectedIndex(index);
		setValue(list.get(index));
	}
	
	public int selection() {
		
		return choose.getSelectedIndex();
	}
	
	public int[] getValues() {
		
		int[] array = new int[list.size()];
		
		for (int i = 0; i < array.length; i++)
			array[i] = list.get(i);
		
		return array;
	}
	
	public void addItemListener(ItemListener il) {
		choose.addItemListener(il);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JComboBox<String> choose = (JComboBox<String>)e.getSource();
		int index = choose.getSelectedIndex();
		//list.set(index, getValue());
		this.setValue(list.get(index));
	}
}
