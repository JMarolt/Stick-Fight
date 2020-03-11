package Player;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

import Map.Point;
import Setup.Main;

public class Player {

	private Point p;
	private int width, height;
	private int health, speed, gravity;

	private int dy = 0;
	private Image playerImg;
	private String playerImgURL = "default stick figure.png";
	private boolean canJump = true;
	private boolean isHoldingWeapon = false;
	Point gunPoint;
	
	public Player(Point p, int width, int height, int health, int speed, int gravity) {
		this.p = p;
		this.width = width;
		this.height = height;
		this.health = health;
		this.speed = speed;
		this.gravity = gravity;
		gunPoint = new Point(p.getX() - 13, p.getY() + 40);
		setPlayerImage();
	}

	public void run() {
		canJump = false;
		dy += gravity;
		p.setY(p.getY() + dy);
		checkVerticalCollision();
		checkHorizontalCollision();
		if (p.getY() > Main.screenSize.height || (p.getX() < 0) || (p.getX() > Main.screenSize.width - width)) {
			die();
		}
	}

	public void jump() {
		if (canJump) {
			dy = -35;
		}
	}

	public void die() {
		// set it to spawn point of terrain later
		p.setX(200);
		p.setY(200);
		dy = 0;
	}

	public void checkVerticalCollision() {
		for (int i = 0; i < Main.terrainTester.getObstacles().size(); i++) {
			if (collision().intersects(Main.terrainTester.getObstacles().get(i).collision()) && (p.getY() + width < Main.terrainTester.getObstacles().get(i).getY() || p.getY() >  Main.terrainTester.getObstacles().get(i).getY())) {
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

	public void pickUpWeapon() {
		if(collision().intersects(Main.gun.collision())) {
			Main.gun.setP(gunPoint);
		}
		isHoldingWeapon = true;
	}
	
	public void dropWeapon() {
		if(isHoldingWeapon) {
			
		}
	}
	
	public void shoot() {
		
	}
	
	public void drop() {
		
	}
	
	public void moveRight() {
		p.setX(p.getX() + speed);
	}

	public void moveLeft() {
		p.setX(p.getX() - speed);
	}

	public Rectangle collision() {
		return new Rectangle(getP().getX(), getP().getY(), getWidth(), getHeight());
	}

	public Image setPlayerImage() {
		try {
			playerImg = ImageIO.read(this.getClass().getResourceAsStream(playerImgURL));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return playerImg;
	}

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(playerImg, p.getX(), p.getY(), null);
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