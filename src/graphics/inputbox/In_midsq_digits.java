package graphics.inputbox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

import math.Generators;
import graphics.struct.InputBox;

public class In_midsq_digits extends InputBox implements ActionListener {
	
	public In_midsq_digits() {
		super("cif:", Generators.MIDSQ_DIGITS);
		
		if (Generators.MIDSQ_DINAMIC)
			input.disable();
	}

	@Override
	public void setVar() {
		
		Generators.MIDSQ_DIGITS = getValue();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JRadioButton in = (JRadioButton) e.getSource();
		
		if (in.getText().equals("Dinamiche")) {
			input.disable();
		} else {
			input.enable();
		}
	}

}
