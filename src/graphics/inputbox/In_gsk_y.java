package graphics.inputbox;

import math.Generators;
import graphics.struct.InputBox;

public class In_gsk_y extends InputBox {
	
	public In_gsk_y() {
		super("y:", Generators.FIB_Y);
	}

	@Override
	public void setVar() {
		
		Generators.FIB_Y = getValue();
	}

}
