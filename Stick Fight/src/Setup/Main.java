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
import Player.Bot;
import Player.Player;
import Weapon.Bullet;
import Weapon.Gun;
import Weapon.Weapon;


public class Main implements ActionListener, KeyListener, MouseListener, MouseMotionListener{

	//important variables
	private JFrame f;
	private Panel p;
	private Timer timer;
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static double widthRatio = screenSize.getWidth()/1920;
	public static double heightRatio = screenSize.getHeight()/1080;
	//other variables
	//everything is hardcoded numbers cuz bored asf
	//needs to be an array list of melee weapons and guns that are spawned
	//bots spawn points will be updated later
	public static Map map;
	public static Player player = new Player(new Point(200,200),20,100,100,12,2);
	public static Bot bot1 = new Bot(1, new Point(500,200),20,100,100,12,2);
	public static Bot bot2 = new Bot(2, new Point(800,200),20,100,100,12,2);
	public static Bot bot3 = new Bot(3, new Point(1100,200),20,100,100,12,2);
	public static File file = new File("src/MapFiles/map1.txt");
	public static Terrain terrainTester = new Terrain(file, 40, 40, 5);
	public static Gun gun = new Gun(new Point(200,200), 66, 33, 35, 20, 0, false);
	public static ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	public static ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	boolean[] keys = new boolean[256];
	int i = 0;
	
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
		f.addMouseListener(this);
		makePanel();
		addToPanel();
		addToFrame();
		f.pack();
		f.setVisible(true);;
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
		if(keys[69]) {
			player.pickUpWeapon();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		i++;
		//System.out.println(i);
		if(i % 60 == 0) {
			//System.out.println("second");
			i = 0;
		}
		p.repaint();
		player.run();
		bot1.run();
		bot2.run();
		bot3.run();
		gun.run();
		for(int i = 0; i < Main.bullets.size(); i++) {
			Main.bullets.get(i).run();
			if(bullets.get(i).collidedWithObstacle()) {
				bullets.remove(i);
			}
			if(bullets.get(i).collidedWithEntity()) {
				bullets.remove(i);
			}
		}
		if(gun.outOfAmmo()) {
			
		}
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
		gun.shoot();
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
