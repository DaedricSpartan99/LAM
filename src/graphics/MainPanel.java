package graphics;

import graphics.struct.InputField;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import math.Generators;

public class MainPanel extends JPanel implements Runnable, MouseListener, ActionListener, Accessible {
	
	public static final Color BACKGROUND = new Color(252, 252, 252);
	public static final Color TRANSPARENT = new Color(0, 0, 0, 0);
	public static final int BORDER_SIZE = 30;
	public static final float DEF_RANGE = 100;
	
	public ContentGraphic contentGraph;
	private ShowValues show;
	private VarPanel input;
	
	private Thread process;
	
	private BufferedImage background;
	
	public int[] AxysX;
	public float[] RandomList;
	
	public static float range = DEF_RANGE;
	
	public static long t_calc = 0;
	public static boolean update;
	public static boolean running;
	
	public MainPanel() {
		
		setBackground(BACKGROUND);
		setLayout(null);
		addMouseListener(this);
		setFocusable(true);
		
		/**
		 * Construct the graphic
		 */
		
		contentGraph = new ContentGraphic();
		contentGraph.setLocation(ShowValues.WIDTH, 0);
		
		/**
		 * Construct the panel that that show the generator values
		 */
		
		show = new ShowValues();
		show.setLocation(0, 0);
		
		/**
		 * Construct the panel that contains tha input instances
		 */
		
		input = new VarPanel();
		input.setLocation(0, ShowValues.HEIGHT);
		
		/**
		 * Set accessible links
		 */
		
		contentGraph.setAccessible(this);
		show.setAccessible(this);
		input.setAccessible(this);
		
		/**
		 * Import the image
		 */
		if (background == null) {
			
			try {
				background = ImageIO.read(ClassLoader.getSystemResourceAsStream("graphics/files/Background.png"));
			} catch (IOException e) {
				System.out.println("IOError: Background.png not loaded");
				e.printStackTrace();
			}
		}
		
				
		/**
		 * Add the components
		 */
		
		add(contentGraph);
		add(show);
		add(input);
		
		contentGraph.graph.paintGraph();
		reload();
	}
	
	public void setActionListeners(ActionListener al) {
		
		/**
		 * Add the action update listener
		 */
		
		input.input._run.addActionListener(this);
		input.input.seed.addActionListener(this);
		input.input.number.addActionListener(this);
		
		/**
		 * Add the repaint listeners
		 */
		
		input.choose.gen_c.addActionListener(al);
	}
	
	@Override
	public void addNotify(){
		
		super.addNotify();
		if (process == null) {
			process = new Thread(this);
			process.start();
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		if (background != null)
			g.drawImage(background, 0, 0, this);
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		this.requestFocus();
		this.load();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		//load();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		//load();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}
	
	@Override
	public synchronized void load() {
		
		update = false;
		this.notify();
	}
	
	@Override
	public synchronized void reload() {
		
		update = true;
		this.notify();
	}
	
	@Override
	public void repaint() {
		
		//empty
	}

	private synchronized void update() {
		
		/**
		 * Obtain the seed
		 */
		
		long _seed = input.input.seed.getInput();
		
		long _number = input.input.number.getInput();
		
		/**
		 * Control the seed is useful
		 */
		
		if (_seed > Generators.BIT32_MOD) {
			
			_seed %= Generators.BIT32_MOD;
			input.input.seed.setText("Valore corretto a " + String.valueOf(_seed));
			
		} else if (_seed == InputField.ILLEGAL_VALUE)
			return;
		
		if (_number > Generators.BIT32_MOD) {
			
			input.input.number.setText("Valore troppo alto");
			return;
			
			
		} else if (_seed == InputField.ILLEGAL_VALUE)
			return;
		
		/**
		 * Cast the seed to integer
		 */
		
		int seed = (int)_seed;
		
		int number = (int)_number;
		
		/**
		 * Initialize RandomList
		 */
		
		RandomList = new float[number];
		
		AxysX = new int[number];
		
		for (int i = 0; i < number; i++)
			AxysX[i] = i + 1;
		
		/**
		 * Take memory of the generators default values
		 */
		
		int fib_y = Generators.FIB_Y;
		int mid_div = (Generators.MIDSQ_DINAMIC) ? (int)Math.pow(10, (int)Math.log10(seed) + 1) : (int)Math.pow(10, Generators.MIDSQ_DIGITS);
		int mwc_c = Generators.MWC_C;
		int kiss_mwc_c = Generators.KISS_MWC_C;
		
		/**
		 * Compile the RandomList with the calculated values
		 */
		
		long t_0 = System.currentTimeMillis();
		
		for (int i = 0; i < number; i++) {
		
			switch (input.choose.generator) {
		
			case ChoosePanel.CONG:
				
				seed = Generators.CONG(seed);
				RandomList[i] = range * seed / Generators.CONG_M;
				break;
			
			case ChoosePanel.MIDSQ:
				
				seed = Generators.MIDSQ(seed);
				RandomList[i] = range * seed / mid_div;
				break;
				
			case ChoosePanel.FIB:
				
				seed = Generators.FIB(seed);
				RandomList[i] = range * seed / Generators.FIB_M;
				break;
				
			case ChoosePanel.GSK:
				
				seed = Generators.GSK(seed);
				RandomList[i] = range * seed / Generators.GSK_M;
				break;
				
			case ChoosePanel.LFSR:
				
				seed = Generators.LFSR(seed);
				RandomList[i] = range * seed / ((float)Math.pow(2, Generators.LFSR_BITS) - 1);
				break;
				
			case ChoosePanel.SHR3:
				
				seed = Generators.SHR3(seed);
				RandomList[i] = range * seed / Generators.BIT32_MOD;
				break;
				
			case ChoosePanel.MWC:
				
				seed = Generators.MWC(seed);
				RandomList[i] = range * seed / Generators.MWC_M;
				break;
				
			case ChoosePanel.KISS:
				
				seed = Generators.KISS(seed);
				RandomList[i] = range * seed / Generators.BIT32_MOD;
				break;
			}
			
			t_calc = System.currentTimeMillis() - t_0;
		}
		
		/**
		 * Reset the generators default values
		 */
		
		Generators.FIB_Y = fib_y;
		Generators.GSK_INIT = true;
		
		Generators.LFSR_INIT = true;
		
		Generators.MWC_C = mwc_c;
		Generators.MWC_INIT = true;
		
		Generators.KISS_MWC_C = kiss_mwc_c;
		Generators.KISS_MWC_INIT = true;
		
		/**
		 * Send the axys the the grafic to be drawn
		 */
		
		contentGraph.graph.setAxys(AxysX, RandomList);
		
		/**
		 * Update the grafic components
		 */
		
		contentGraph.graph.paintGraph();
		reload();
		//System.out.println(t_calc);
	}


	@Override
	public synchronized void run() {
		
		running = true;
		update = false;
		
		do {
			
			if (update) 
				this.update();
			
			input.mod.fields(input.choose.generator);
			show.setEquation(input.choose.generator);
			show.setTable(AxysX, RandomList);
			
			super.repaint();
			super.validate();
			
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (running);
		
		System.exit(0);
	}

	@Override
	public synchronized void actionPerformed(ActionEvent e) {
		
		this.reload();
	}
}
