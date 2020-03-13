package Player;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.imageio.ImageIO;

import Map.Point;
import Setup.Main;

public class Bot {

	private int ID;
	private Point p;
	private int width, height;
	private int health, speed, gravity;
	
	private int dy = 0;
	private boolean canJump = true;
	
	Image img;
	String imageURL = "default stick figure.png";
	
	public Bot(int ID, Point p, int width, int height, int health, int speed, int gravity) {
		this.ID = ID;
		this.p = p;
		this.width = width;
		this.height = height;
		this.health = health;
		this.speed = speed;
		this.gravity = gravity;
		setImage();
	}
	
	public void run() {
		canJump = false;
		if(ID == 1) {
			chooseTarget(Main.player, Main.bot2, Main.bot3);
		}
		if(ID == 2) {
			chooseTarget(Main.player, Main.bot1, Main.bot3);
		}
		if(ID == 3) {
			chooseTarget(Main.player, Main.bot1, Main.bot2);
		}
		dy += gravity;
		p.setY(p.getY() + dy);
		checkVerticalCollision();
		checkHorizontalCollision();
	}
	
	public Rectangle collision() {
		return new Rectangle(getP().getX(), getP().getY(), getWidth(), getHeight());
	}
	
	public void checkVerticalCollision() {
		for (int i = 0; i < Main.terrainTester.getObstacles().size(); i++) {
			if (collision().intersects(Main.terrainTester.getObstacles().get(i).collision())
					&& (p.getY() + width < Main.terrainTester.getObstacles().get(i).getY()
							|| p.getY() > Main.terrainTester.getObstacles().get(i).getY())) {
				if (dy > 0 && p.getY() + width < Main.terrainTester.getObstacles().get(i).getY()) {
					p.setY(Main.terrainTester.getObstacles().get(i).getY() - height);
					dy = 0;
					canJump = true;
				}
				if (dy < 0 && p.getY() > Main.terrainTester.getObstacles().get(i).getY()) {
					dy = 0;
					p.setY(Main.terrainTester.getObstacles().get(i).getY()
							+ Main.terrainTester.getObstacles().get(i).getHeight());
				}
			}
		}
	}
	
	public void checkHorizontalCollision() {
		for (int i = 0; i < Main.terrainTester.getObstacles().size(); i++) {
			if (collision().intersects(Main.terrainTester.getObstacles().get(i).collision())
					&& (p.getY() > Main.terrainTester.getObstacles().get(i).getY()
							&& p.getY() < Main.terrainTester.getObstacles().get(i).getY()
									+ Main.terrainTester.getObstacles().get(i).getHeight())) {
				if (p.getX() > Main.terrainTester.getObstacles().get(i).getX()) {
					p.setX(Main.terrainTester.getObstacles().get(i).getX()
							+ Main.terrainTester.getObstacles().get(i).getWidth());
				}
				if (p.getX() < Main.terrainTester.getObstacles().get(i).getX()) {
					p.setX(Main.terrainTester.getObstacles().get(i).getX() - width);
				}
			}
		}
	}
	
	public void chooseTarget(Player p, Bot a, Bot b) {
		if(distanceBetweenPlayer(p) < distanceBetweenBot(a) && distanceBetweenPlayer(p) < distanceBetweenBot(b)) {
			targetPlayer(p);
		}else if(distanceBetweenBot(a) < distanceBetweenPlayer(p) && distanceBetweenBot(a) < distanceBetweenBot(b)) {
			targetBot(a);
		}else if(distanceBetweenBot(b) < distanceBetweenPlayer(p) && distanceBetweenBot(b) < distanceBetweenBot(a)){
			targetBot(b);
		}
	}
	
	public void targetPlayer(Player a) {
		if(p.getX() < a.getP().getX()) {
			moveRight();
		}
		if(p.getX() > a.getP().getX()) {
			moveLeft();
		}
	}
	
	public void attack() {
		
	}
	
	public void targetBot(Bot a) {
		if(p.getX() < a.getP().getX()) {
			moveRight();
		}
		if(p.getX() > a.getP().getX()) {
			moveLeft();
		}
	}
	
	public void jump() {
		if(canJump) {
			dy = -35;
		}
	}
	
	public void moveRight() {
		p.setX(p.getX() + speed);
	}
	
	public void moveLeft() {
		p.setX(p.getX() - speed);
	}
	
	public int distanceBetweenPlayer(Player a) {
		return (int)Math.sqrt((p.getX() - a.getP().getX())^2 + (p.getY() - a.getP().getY()));
	}
	
	public int distanceBetweenBot(Bot b) {
		return (int)Math.sqrt((p.getX() - b.getP().getX())^2 + (p.getY() - b.getP().getY()));
	}
	
	public Image setImage() {
		try {
			img = ImageIO.read(this.getClass().getResourceAsStream(imageURL));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return img;
	}
	
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(img, p.getX(), p.getY(), null);
	}

	public Point getP() {
		return p;
	}

	public void setP(Point p) {
		this.p = p;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getGravity() {
		return gravity;
	}

	public void setGravity(int gravity) {
		this.gravity = gravity;
	}
	
}
