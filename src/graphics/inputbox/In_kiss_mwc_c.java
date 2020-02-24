package graphics.inputbox;

import math.Generators;
import graphics.struct.InputBox;

public class In_kiss_mwc_c extends InputBox {
	
	public In_kiss_mwc_c() {
		super("C:", Generators.KISS_MWC_C);
	}

	@Override
	public void setVar() {
		
		Generators.KISS_MWC_C = getValue();
	}

}
