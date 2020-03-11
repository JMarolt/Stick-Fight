package Weapon;

import java.awt.Image;
import java.awt.Rectangle;

import Map.Point;
import Sounds.Sound;

public class Gun {

	private Point p;
	private int width, height;
	private int damage;
	private int ammo;
	private Sound sound;
	private Image img;
	private int weightFactor;
	
	private int cy = 5;
	
	public Gun(Point p, int width, int height, int damage, int ammo, Sound sound, Image img, int weightFactor) {
		this.p = p;
		this.damage = damage;
		this.ammo = ammo;
		this.sound = sound;
		this.img = img;
		this.weightFactor = weightFactor;
	}
	
	public void run() {
		p.setY(p.getY() + cy);
	}
	
	public Rectangle collision() {
		return new Rectangle(p.getX(), p.getY(), width, height);
	}
	
	public Point randomSpawnPoint() {
		//get the current terrain and set an x value where the gun lands on a spot
		return new Point(100,100);
	}
	
	public Image setImage() {
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
