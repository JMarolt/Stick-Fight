package Weapon;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

import Map.Point;
import Setup.Main;

public class Bullet {

	private Point p;
	private int width, height;
	private int speed;
	private Image img;
	private String imgURL = "bullet.png";
	
	public Bullet(Point p, int width, int height, int speed) {
		this.p = p;
		this.width = width;
		this.height = height;
		this.speed = speed;
		setImage();
	}
	
	public void run() {
		p.setX(p.getX() + speed);
	}
	
	public boolean collidedWithObstacle() {
		for(int i = 0; i < Main.terrainTester.getObstacles().size(); i++) {
			if(collision().intersects(Main.terrainTester.getObstacles().get(i).collision())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean collidedWithEntity() {
		for(int i = 0; i < Main.terrainTester.getObstacles().size(); i++) {
			if(collision().intersects(Main.terrainTester.getObstacles().get(i).collision())) {
				return true;
			}
		}
		return false;
	}
	
	public Rectangle collision() {
		return new Rectangle(p.getX(), p.getY(), getWidth(), getHeight());
	}
	
	public Image setImage() {
		try {
			img = ImageIO.read(this.getClass().getResourceAsStream(imgURL));
		} catch (IOException e) {
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
}
