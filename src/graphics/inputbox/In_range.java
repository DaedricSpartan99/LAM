package graphics.inputbox;

import graphics.MainPanel;
import graphics.struct.InputBox;

public class In_range extends InputBox {

	public In_range() {
		super("Int:", MainPanel.range);
	}

	@Override
	public void setVar() {
		
		MainPanel.range = getFloatValue();
	}

}
