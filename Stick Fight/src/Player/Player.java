package Player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

import Map.Point;
import Setup.Main;
import Weapon.Gun;
import Weapon.Melee;

public class Player {

	private Point p;
	private int width, height;
	private int health, speed, gravity;

	private int dy = 0;
	private Image playerImg;
	private String playerImgURL = "default stick figure.png";
	private boolean canJump = true;
	public static Gun currentGun = null;
	public static Melee currentMelee = null;
	private Point gunPoint;

	public Player(Point p, int width, int height, int health, int speed, int gravity) {
		this.p = p;
		this.width = width;
		this.height = height;
		this.health = health;
		this.speed = speed;
		this.gravity = gravity;
		setPlayerImage();
		gunPoint = new Point(p.getX() - 13, p.getY() + 38);
	}

	public void run() {
		canJump = false;
		dy += gravity;
		p.setY(p.getY() + dy);
		checkVerticalCollision();
		checkHorizontalCollision();
		checkHorizontalEntityCollision();
		if (p.getY() > Main.screenSize.height || (p.getX() < 0) || (p.getX() > Main.screenSize.width - width)) {
			die();
		}
	}

	public void attack() {

	}
	
	public void pickUpWeapon() {
		if((currentGun == null && currentMelee == null) && collision().intersects(Main.gun.collision())) {
			//identify weapon picked up
			Main.gun.setPickedUp(true);
			currentGun = Main.gun;
			Main.gun.setP(gunPoint);
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
	
	public void checkVerticalEntityCollision() {
		if(collision().intersects(Main.bot1.collision())) {
			
		}
	}
	
	public void checkHorizontalEntityCollision() {
		if(collision().intersects(Main.bot1.collision()) && p.getY() - 100 < Main.bot1.getP().getY()) {
			p.setX(p.getX() - width);
		}
		if(collision().intersects(Main.bot2.collision()) && p.getY() - 100 < Main.bot2.getP().getY()) {
			p.setX(p.getX() - width);
		}
		if(collision().intersects(Main.bot3.collision()) && p.getY() - 100 < Main.bot3.getP().getY()) {
			p.setX(p.getX() - width);
		}
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
	
	public void moveLeft() {
		p.setX(p.getX() - speed);
	}
	
	public void moveRight() {
		p.setX(p.getX() + speed);
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillPolygon(new int[] { p.getX() + (width / 4), p.getX() + (width / 2), p.getX() + ((width * 3) / 4) },
				new int[] { p.getY() - 10, p.getY() - 5, p.getY() - 10 }, 3);
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