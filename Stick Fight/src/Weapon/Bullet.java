package Weapon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import Map.Point;
import Setup.Main;

public class Bullet {

	private Point p;
	private int width, height;
	private int speed;
	
	public Bullet(Point p, int width, int height, int speed) {
		this.p = p;
		this.width = width;
		this.height = height;
		this.speed = speed;
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
		return new Rectangle(getP().getX(), getP().getY(), getWidth(), getHeight());
	}

	public void draw(Graphics g) {
		g.setColor(Color.orange);
		g.fillOval(p.getX(), p.getY(), width, height);
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
