package graphics.inputbox;

import math.Generators;
import graphics.struct.InputBox;

public class In_mwc_a extends InputBox {
	
	public In_mwc_a() {
		super("a:", Generators.MWC_A);
	}

	@Override
	public void setVar() {
		
		Generators.MWC_A = getValue();
	}

}
