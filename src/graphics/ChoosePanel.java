package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChoosePanel extends SonPanel implements ActionListener {
	
	public static final byte CONG = 0;
	public static final byte MIDSQ = 1;
	public static final byte FIB = 2;
	public static final byte GSK = 3;
	public static final byte LFSR = 4;
	public static final byte SHR3 = 5;
	public static final byte MWC = 6;
	public static final byte KISS = 7;
	
	public static final int WIDTH = 250;
	
	public byte generator;
	public JComboBox gen_c;
	private String[] gen_t;
	private JLabel gen_l;
	
	public ChoosePanel() {
		
		super(null);
		setSize(WIDTH, VarPanel.COMP_HEIGHT);
		setBackground(new Color(30, 15, 0, 170));
		
		gen_l = new JLabel("Generatore:");
		gen_l.setFont(new Font(Font.SERIF, Font.ITALIC, 22));
		gen_l.setForeground(new Color(255, 255, 255, 220));
		gen_l.setBounds(10, 50, WIDTH / 2 + 10, 40);
		
		gen_t = new String[8];
		
		gen_t[CONG] = "Linear congruential";
		gen_t[MIDSQ] = "Middle square";
		gen_t[FIB] = "Fibonacci";
		gen_t[GSK] = "Green, Smith, Klem";
		gen_t[LFSR] = "Linear feedback shift register";
		gen_t[SHR3] = "Xorshift";
		gen_t[MWC] = "Multiply with carry";
		gen_t[KISS] = "Keep it simple, stupid!";
		
		gen_c = new JComboBox(gen_t);
		gen_c.setBounds(30, VarPanel.COMP_HEIGHT / 2 + 30, WIDTH - 60, 30);
		gen_c.setFont(gen_c.getFont().deriveFont(12));
		gen_c.addActionListener(this);
		
		generator = CONG;
		
		add(gen_l);
		add(gen_c);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JComboBox gen_c = (JComboBox)e.getSource();
        this.generator = (byte)gen_c.getSelectedIndex();
        load();
	}

}
