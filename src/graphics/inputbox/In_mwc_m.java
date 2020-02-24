package graphics.inputbox;

import math.Generators;
import graphics.struct.InputBox;

public class In_mwc_m extends InputBox {

	public In_mwc_m() {
		super("m:", Generators.MWC_M);
	}

	@Override
	public void setVar() {
		
		Generators.MWC_M = getValue();
	}
}
