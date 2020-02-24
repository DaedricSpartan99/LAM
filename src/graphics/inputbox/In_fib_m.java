package graphics.inputbox;

import math.Generators;
import graphics.struct.InputBox;

public class In_fib_m extends InputBox {
	
	public In_fib_m() {
		super("m:", Generators.FIB_M);
	}

	@Override
	public void setVar() {
		
		Generators.FIB_M = getValue();
	}

}
