package graphics.inputbox;

import math.Generators;
import graphics.struct.InputBox;

public class In_gsk_m extends InputBox {
	
	public In_gsk_m() {
		super("m:", Generators.GSK_M);
	}

	@Override
	public void setVar() {
		
		Generators.GSK_M = getValue();
	}

}
