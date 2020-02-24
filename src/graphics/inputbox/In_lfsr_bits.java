package graphics.inputbox;

import math.Generators;
import graphics.struct.InputBox;

public class In_lfsr_bits extends InputBox {
	
	public In_lfsr_bits() {
		
		super("bit: ", Generators.LFSR_BITS);
	}

	@Override
	public void setVar() {
		
		Generators.LFSR_BITS = getValue();
	}

}
