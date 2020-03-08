package Setup;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Panel extends JPanel{

	private static final long serialVersionUID = 1L;

	public Panel() {
		
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, Main.screenSize.width, Main.screenSize.height);
		Main.terrainTester.drawTestTerrain(g);
		Main.player.render(g);
	}
	
}
