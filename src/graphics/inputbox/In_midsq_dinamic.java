package graphics.inputbox;

import java.awt.event.MouseEvent;

import math.Generators;
import graphics.struct.InputBoolBox;

public class In_midsq_dinamic extends InputBoolBox {
	
	public In_midsq_dinamic() {
		super("Cifre:", "Dinamiche", "Fisse", Generators.MIDSQ_DINAMIC);
	}

	@Override
	public void setVar() {
		
		Generators.MIDSQ_DINAMIC = getBoolValue();
	}

}
