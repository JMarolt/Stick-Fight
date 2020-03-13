package Weapon;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

import Map.Point;
import Setup.Main;
import Sounds.Sound;

public class Gun {

	private Point p;
	private int width, height;
	private int damage;
	private int ammo;
	private Sound sound;
	//private String soundURL = "src/Sounds/";
	private Image img;
	private String imageURL = "ak47.png";
	private int weightFactor;
	private int cy = 5;
	
	public Gun(Point p, int width, int height, int damage, int ammo, int weightFactor) {
		this.p = p;
		this.width = width;
		this.height = height;
		this.damage = damage;
		this.ammo = ammo;
		this.weightFactor = weightFactor;
		setImage();
	}
	
	public void run() {
		p.setY(p.getY() + cy);
		checkCollision();
	}
	
	public void checkCollision() {
		for (int i = 0; i < Main.terrainTester.getObstacles().size(); i++) {
			if (collision().intersects(Main.terrainTester.getObstacles().get(i).collision())){
				p.setY(Main.terrainTester.getObstacles().get(i).getY() - height);
				cy = 0;
			}
		}
	}
	
	public void shoot() {
		ammo--;
		Main.bullets.add(new Bullet(new Point(p.getX() + 55, p.getY() + 6), 10, 10, 1));
		//sound.playNoise(soundURL);
	}
	
	public double rotateImageRelativeToMouse(Graphics g) {
		int cursorX = MouseInfo.getPointerInfo().getLocation().x;
		int cursorY = MouseInfo.getPointerInfo().getLocation().y;
		double theta = Math.atan2(cursorY - p.getY(), cursorX - p.getX());
		return theta;
	}
	
	public Rectangle collision() {
		return new Rectangle(p.getX(), p.getY(), width, height);
	}
	
	public Point randomSpawnPoint() {
		//get the current terrain and set an x value where the gun lands on a spot
		return new Point(100,100);
	}
	
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.rotate(rotateImageRelativeToMouse(g), p.getX(), p.getY());
		g2d.drawImage(img, p.getX(), p.getY(), null);
	}
	
	public Image setImage() {
		try {
			img = ImageIO.read(this.getClass().getResourceAsStream(imageURL));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
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

	public int getDamage() {
		return damage;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public int getAmmo() {
		return ammo;
	}
	
	public void setAmmo(int ammo) {
		this.ammo = ammo;
	}
	
	public Sound getSound() {
		return sound;
	}
	
	public void setSound(Sound sound) {
		this.sound = sound;
	}
	
	public Image getImg() {
		return img;
	}
	
	public void setImg(Image img) {
		this.img = img;
	}
	
	public int getWeightFactor() {
		return weightFactor;
	}
	
	public void setWeightFactor(int weightFactor) {
		this.weightFactor = weightFactor;
	}
	
}
