package graphics.inputbox;

import math.Generators;
import graphics.struct.InputBox;

public class In_cong_m extends InputBox {
	
	public In_cong_m() {
		super("m:", Generators.CONG_M);
	}

	@Override
	public void setVar() {
		
		Generators.CONG_M = getValue();
	}

}
