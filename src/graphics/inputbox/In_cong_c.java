package graphics.inputbox;

import math.Generators;
import graphics.struct.InputBox;

public class In_cong_c extends InputBox {
	
	public In_cong_c() {
		super("c:", Generators.CONG_C);
	}

	@Override
	public void setVar() {
		
		Generators.CONG_C = getValue();
	}

}
