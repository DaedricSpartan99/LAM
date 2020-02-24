package graphics.inputbox;

import math.Generators;
import graphics.struct.InputBox;

public class In_mwc_c extends InputBox {

	public In_mwc_c() {
		super("c:", Generators.MWC_C);
	}

	@Override
	public void setVar() {
		
		Generators.MWC_C = getValue();
	}
}
