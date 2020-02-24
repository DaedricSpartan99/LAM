package graphics.inputbox;

import math.Generators;
import graphics.struct.InputBox;

public class In_kiss_cong_c extends InputBox {
	
	public In_kiss_cong_c() {
		super("c:", Generators.KISS_CONG_C);
	}

	@Override
	public void setVar() {
		
		Generators.KISS_CONG_C = getValue();
	}

}
