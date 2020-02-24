package graphics.inputbox;

import math.Generators;
import graphics.struct.InputBox;

public class In_kiss_mwc_k extends InputBox {
	
	public In_kiss_mwc_k() {
		super("K:", Generators.KISS_MWC_K);
	}

	@Override
	public void setVar() {
		
		Generators.KISS_MWC_K = getValue();
	}

}
