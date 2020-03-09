package Setup;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

import Map.Map;
import Map.Point;
import Map.Terrain;
import Player.Player;


public class Main implements ActionListener, KeyListener, MouseListener, MouseMotionListener{

	//important variables
	private JFrame f;
	private Panel p;
	private Timer timer;
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	//other variables
	public static Map map;
	public static Player player = new Player(new Point(200,200),30,100,100,12,2);
	public static File file = new File("src/MapFiles/map1.txt");
	public static Terrain terrainTester = new Terrain(file, 40);
	boolean[] keys = new boolean[256];
	
	public Main() {
		map = new Map(new ArrayList<Terrain>());
	}
	
	public void makeFrame() {
		f = new JFrame();
		f.setTitle("Stick Fight");
		f.setResizable(false);
		f.setFocusable(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setPreferredSize(screenSize);
		f.addKeyListener(this);
		makePanel();
		addToPanel();
		addToFrame();
		f.pack();
		f.setVisible(true);
	}
	
	public void addToFrame() {
		f.add(p);
	}
	
	public void addToPanel() {
		
	}
	
	public void makePanel() {
		p = new Panel();
	}
	
	public void start() {
		//1000/(desired FPS)
		timer = new Timer(1000/60, this);
		timer.start();
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.makeFrame();
		main.start();
	}
	
	public void update() {
		if(keys[32]) {
			player.jump();
		}
		if(keys[65]) {
			player.moveLeft();
		}
		if(keys[68]) {
			player.moveRight();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		p.repaint();
		player.run();
		update();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		    
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}
	
}
