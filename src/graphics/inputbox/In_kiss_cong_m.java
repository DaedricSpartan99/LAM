package graphics.inputbox;

import math.Generators;
import graphics.struct.InputBox;

public class In_kiss_cong_m extends InputBox {
	
	public In_kiss_cong_m() {
		super("m:", Generators.KISS_CONG_M);
	}

	@Override
	public void setVar() {
		
		Generators.KISS_CONG_M = getValue();
	}

}
