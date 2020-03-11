package Weapon;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
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
	private Image img;
	private String imgURL = "ak47.png";
	private Sound sound;
	private String soundURL = "src/Sounds/ak47 noise.wav";
	private int weightFactor;
	
	private int dy = 5;
	
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
		p.setY(p.getY() + dy);
		for(int i = 0; i < Main.terrainTester.getObstacles().size(); i++) {
			if(collision().intersects(Main.terrainTester.getObstacles().get(i).collision())) {
				dy = 0;
			}
		}
	}
	
	public void shoot() {
		ammo--;
		playSound();
	}
	
	public Rectangle collision() {
		return new Rectangle(getP().getX(), getP().getY(), getWidth(), getHeight());
	}
	
	public Image setImage() {
		try {
			img = ImageIO.read(this.getClass().getResourceAsStream(imgURL));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
	
	public void playSound() {
		sound.playNoise(soundURL);
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

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public Sound getSound() {
		return sound;
	}

	public void setSound(Sound sound) {
		this.sound = sound;
	}

	public int getWeightFactor() {
		return weightFactor;
	}

	public void setWeightFactor(int weightFactor) {
		this.weightFactor = weightFactor;
	}

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	public String getSoundURL() {
		return soundURL;
	}

	public void setSoundURL(String soundURL) {
		this.soundURL = soundURL;
	}
	
}
