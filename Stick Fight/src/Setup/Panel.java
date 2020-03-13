package Setup;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Panel extends JPanel{

	private static final long serialVersionUID = 1L;

	public Panel() {
		
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(0, 0, Main.screenSize.width, Main.screenSize.height);
		Main.terrainTester.drawTestTerrain(g);
		Main.player.render(g);
		Main.bot1.draw(g);
		Main.bot2.draw(g);
		Main.bot3.draw(g);
		Main.gun.draw(g);
		for(int i = 0; i < Main.bullets.size(); i++) {
			Main.bullets.get(i).draw(g);
		}
	}
	
}
