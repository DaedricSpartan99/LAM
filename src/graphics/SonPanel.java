package graphics;

import java.awt.LayoutManager;

import javax.swing.JPanel;

public abstract class SonPanel extends JPanel {
	
	private volatile Accessible link;

	public SonPanel() {
		
	}

	public SonPanel(LayoutManager layout) {
		super(layout);
	}
	
	public void setAccessible(Accessible link) {
		if (link == null)
			throw new NullPointerException("link is null");
		this.link = link;
	}
	
	public Accessible getAccessible() {
		return link;
	}
	
	public void load() {
		link.load();
	}
	
	public void reload() {
		link.reload();
	}
}
