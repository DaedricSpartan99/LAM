package graphics.inputbox;

import math.Generators;
import graphics.struct.InputBox;

public class In_mwc_k extends InputBox {

	public In_mwc_k() {
		super("k:", Generators.MWC_K);
	}

	@Override
	public void setVar() {
		
		Generators.MWC_K = getValue();
	}
}
