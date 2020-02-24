package graphics.inputbox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import math.Generators;
import graphics.struct.InputArrayBox;

public class In_kiss_shr3_tap extends InputArrayBox {
	
	public static int index = 0;
	
	public In_kiss_shr3_tap() {
		super("tap:", Generators.KISS_SHR3_TAP, "bit");
		select(index);
	}

	@Override
	public void setVar() {
		
		if (getValue() < 1 || getValue() > 32) {
			return;
		}
			
		list.set(choose.getSelectedIndex(), getValue());
		Generators.KISS_SHR3_TAP = getValues();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		index = selection();
	}
}
