package graphics;

import graphics.struct.InputArrayBox;
import graphics.struct.InputBoolBox;
import graphics.struct.InputBox;
import graphics.inputbox.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import math.Generators;

public class ModifyPanel extends SonPanel implements ActionListener, ItemListener {

	public static final int WIDTH = 500;
	
	InputBox[] fields;
	
	public ModifyPanel() {
		
		super(null);
		setSize(WIDTH, VarPanel.COMP_HEIGHT);
		setBackground(new Color(20, 0, 0, 150));
	}
	
	public void fields(byte gen) {
		
		this.removeAll();
		
		InputBox a, c, m, y, k;
		InputArrayBox tap;
		
		InputBox range = new In_range();
		
		switch (gen) {
		
		case ChoosePanel.CONG:
			
			fields = new InputBox[4];
			
			a = new In_cong_a();
			a.setLocation(0, 0);
			
			c = new In_cong_c();
			c.setLocation(0, InputBox.HEIGHT);
			
			m = new In_cong_m();
			m.setLocation(0, InputBox.HEIGHT * 2);
			
			range.setLocation(InputBox.WIDTH, 0);
			
			fields[0] = a;
			fields[1] = c;
			fields[2] = m;
			fields[3] = range;
			
			break;
			
		case ChoosePanel.MIDSQ:
			
			fields = new InputBox[3];
			
			InputBoolBox din = new In_midsq_dinamic();
			din.setLocation(0, 0);
			
			In_midsq_digits dig = new In_midsq_digits();
			dig.setLocation(0, InputBoolBox.HEIGHT);
			
			din.addActionListener(dig);
			
			range.setLocation(InputBox.WIDTH, 0);
			
			fields[0] = din;
			fields[1] = dig;
			fields[2] = range;
			
			break;
			
		case ChoosePanel.FIB:
			
			fields = new InputBox[3];
			
			y = new In_fib_y();
			y.setLocation(0, 0);
			
			m = new In_fib_m();
			m.setLocation(0, InputBox.HEIGHT);
			
			range.setLocation(InputBox.WIDTH, 0);
			
			fields[0] = y;
			fields[1] = m;
			fields[2] = range;
			
			break;
			
		case ChoosePanel.GSK:
			
			fields = new InputBox[4];
			
			y = new In_gsk_y();
			y.setLocation(0, 0);
			
			k = new In_gsk_k();
			k.setLocation(0, InputBox.HEIGHT);
			
			m = new In_gsk_m();
			m.setLocation(0, InputBox.HEIGHT * 2);
			
			range.setLocation(InputBox.WIDTH, 0);
			
			fields[0] = y;
			fields[1] = k;
			fields[2] = m;
			fields[3] = range;
			
			break;
			
		case ChoosePanel.LFSR:
			
			fields = new InputBox[3];
			
			tap = new In_lfsr_tap();
			tap.setLocation(0, 0);
			tap.addItemListener(this);
			
			InputBox bits = new In_lfsr_bits();
			bits.setLocation(0, InputArrayBox.HEIGHT);
			
			range.setLocation(InputBox.WIDTH, 0);
			
			fields[0] = tap;
			fields[1] = bits;
			fields[2] = range;
			
			break;
			
		case ChoosePanel.SHR3:
			
			fields = new InputBox[2];
			
			tap = new In_shr3_tap();
			tap.setLocation(0, 0);
			tap.addItemListener(this);
			
			range.setLocation(InputBox.WIDTH, 0);
			
			fields[0] = tap;
			fields[1] = range;
			
			break;
			
		case ChoosePanel.MWC:
			
			fields = new InputBox[5];
			
			a = new In_mwc_a();
			a.setLocation(0, 0);
			
			c = new In_mwc_c();
			c.setLocation(0, InputBox.HEIGHT);
			
			m = new In_mwc_m();
			m.setLocation(0, InputBox.HEIGHT * 2);
			
			k = new In_mwc_k();
			k.setLocation(InputBox.WIDTH, 0);
			
			range.setLocation(InputBox.WIDTH, InputBox.HEIGHT);
			
			fields[0] = a;
			fields[1] = c;
			fields[2] = m;
			fields[3] = k;
			fields[4] = range;
			
			break;
			
		case ChoosePanel.KISS:
			
			fields = new InputBox[9];
			
			a = new In_kiss_mwc_a();
			a.setLocation(0, 0);
			
			c = new In_kiss_mwc_c();
			c.setLocation(0, InputBox.HEIGHT);
			
			m = new In_kiss_mwc_m();
			m.setLocation(0, InputBox.HEIGHT * 2);
			
			k = new In_kiss_mwc_k();
			k.setLocation(0, InputBox.HEIGHT * 3);
			
			InputBox _a = new In_kiss_cong_a();
			_a.setLocation(InputBox.WIDTH, 0);
			
			InputBox _c = new In_kiss_cong_c();
			_c.setLocation(InputBox.WIDTH, InputBox.HEIGHT);
			
			InputBox _m = new In_kiss_cong_m();
			_m.setLocation(InputBox.WIDTH, InputBox.HEIGHT * 2);
			
			tap = new In_kiss_shr3_tap();
			tap.setLocation(InputBox.WIDTH * 2, 0);
			tap.addItemListener(this);
			
			range.setLocation(InputBox.WIDTH * 2, InputArrayBox.HEIGHT);
			
			fields[0] = a;
			fields[1] = c;
			fields[2] = m;
			fields[3] = k;
			fields[4] = _a;
			fields[5] = _c;
			fields[6] = _m;
			fields[7] = tap;
			fields[8] = range;
			
			break;
			
		default:
			return;
		}
		
		for (int i = 0; i < fields.length; i++) {
			fields[i].addActionListener(this);
			add(fields[i]);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for (int i = 0; i < fields.length; i++) {
			fields[i].setVar();
		}
		load();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		load();
	}
}
