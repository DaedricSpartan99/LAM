package graphics.inputbox;

import math.Generators;
import graphics.struct.InputBox;

public class In_kiss_cong_a extends InputBox {
	
	public In_kiss_cong_a() {
		super("a:", Generators.KISS_CONG_A);
	}

	@Override
	public void setVar() {
		
		Generators.KISS_CONG_A = getValue();
	}

}
