package graphics.inputbox;

import math.Generators;
import graphics.struct.InputBox;

public class In_cong_a extends InputBox {
	
	public In_cong_a() {
		super("a:", Generators.CONG_A);
	}

	@Override
	public void setVar() {
		
		Generators.CONG_A = getValue();
	}

}
