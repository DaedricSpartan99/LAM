package graphics.inputbox;

import math.Generators;
import graphics.struct.InputBox;

public class In_gsk_k extends InputBox {
	
	public In_gsk_k() {
		super("k:", Generators.GSK_DIFF);
	}

	@Override
	public void setVar() {
		
		Generators.GSK_DIFF = getValue();
	}

}
