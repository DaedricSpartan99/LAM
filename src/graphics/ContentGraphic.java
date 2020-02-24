package graphics;

import java.awt.Color;
import java.awt.Graphics;

import graphics.struct.DecoratedPanel;
import graphics.struct.Graphic;

import javax.swing.JPanel;

public class ContentGraphic extends SonPanel {
	
	private DecoratedPanel graph_left, graph_right, graph_up;
	public Graphic graph;
	private JPanel contentGraph;
	
	public ContentGraphic() {
		
		super(null);
		setSize(Main.WINDOW_WIDTH - ShowValues.WIDTH, ShowValues.HEIGHT);
		setBackground(MainPanel.TRANSPARENT);
		
		/**
		 * Construct the graphic
		 */
		
		graph = new Graphic();
		
		contentGraph = new JPanel(null);
		contentGraph.setBackground(MainPanel.TRANSPARENT);
		contentGraph.setLocation(MainPanel.BORDER_SIZE, MainPanel.BORDER_SIZE);
		contentGraph.setSize(Main.WINDOW_WIDTH - ShowValues.WIDTH - (int)(2.5f * MainPanel.BORDER_SIZE), ShowValues.HEIGHT - MainPanel.BORDER_SIZE);

		graph.setSize(contentGraph.getWidth(), contentGraph.getHeight());
		graph.setBackground(MainPanel.TRANSPARENT);
		
		contentGraph.add(graph);
		
		/**
		 * Construct the graphic border
		 */
		
		graph_left = new DecoratedPanel();
		graph_right = new DecoratedPanel();
		graph_up = new DecoratedPanel();
		
		graph_left.setBounds(0, MainPanel.BORDER_SIZE, MainPanel.BORDER_SIZE, getHeight());
		graph_right.setBounds(getWidth() - (int)(1.5f * MainPanel.BORDER_SIZE), MainPanel.BORDER_SIZE, MainPanel.BORDER_SIZE, getHeight());
		graph_up.setBounds(0, 0, getWidth(), MainPanel.BORDER_SIZE);
		
		/**
		 * Add the components
		 */
		
		add(contentGraph);
		add(graph_left);
		add(graph_right);
		add(graph_up);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.setColor(new Color(0, 0, 0, 180));
		g.fillRect(MainPanel.BORDER_SIZE, MainPanel.BORDER_SIZE, contentGraph.getWidth(), contentGraph.getHeight());
	}
}
