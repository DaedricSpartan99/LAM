package graphics.inputbox;

import math.Generators;
import graphics.struct.InputBox;

public class In_kiss_mwc_a extends InputBox {
	
	public In_kiss_mwc_a() {
		super("A:", Generators.KISS_MWC_A);
	}

	@Override
	public void setVar() {
		
		Generators.KISS_MWC_A = getValue();
	}

}
