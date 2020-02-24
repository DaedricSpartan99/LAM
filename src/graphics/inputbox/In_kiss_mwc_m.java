package graphics.inputbox;

import math.Generators;
import graphics.struct.InputBox;

public class In_kiss_mwc_m extends InputBox {
	
	public In_kiss_mwc_m() {
		super("M:", Generators.KISS_MWC_M);
	}

	@Override
	public void setVar() {
		
		Generators.KISS_MWC_M = getValue();
	}

}
