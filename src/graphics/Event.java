package graphics;

import java.io.IOException;
import java.io.InputStream;

public class Event extends Thread {
	
	public int input;
	private InputStream in;
	private byte[] buffer;
	
	public Event() {
		
		this.start();
	}
	
	public int getInput() {
		return input;
	}

	@Override
	public void run() {
		
		while(MainPanel.running) {
			
			in = System.in;
			buffer = new byte[3];
			
			int input;
			try {
				input = in.read(buffer);
			} catch (IOException e) {
				e.printStackTrace();
				input = 0;
			}
			
			if (input != this.input)
				this.input = input;
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
