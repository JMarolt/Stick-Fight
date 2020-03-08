package Player;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

import Setup.Main;

public class Player {

	//gravity is 2. add gravity to vy. add vy to point.getY()
	private int x, y;
	private int width, height;
	private int health, speed, gravity;
	
	private int dy = 0;
	private Image playerImg;
	private String playerImgURL = "default stick figure.png";
	private boolean canJump = true;
	
	public Player(int x, int y, int width, int height, int health, int speed, int gravity) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.health = health;
		this.speed = speed;
		this.gravity = gravity;
		setPlayerImage();
	}
	
	public void run() {
		canJump = false;
		dy += gravity;
		y += dy;
		for(int i = 0; i < Main.terrainTester.getObstacles().size(); i++) {
			if(collision().intersects(Main.terrainTester.getObstacles().get(i).collision()) && dy > 0){
				dy = 0;
				y = Main.terrainTester.getObstacles().get(i).getY() - height;
				canJump = true;
			}
			if(collision().intersects(Main.terrainTester.getObstacles().get(i).collision()) && dy < 0){
				dy = 0;
				y = Main.terrainTester.getObstacles().get(i).getY() + Main.terrainTester.getObstacles().get(i).getHeight();
			}
		}
	}
	
	public void jump() {
		if(canJump) {
			dy = -35;
		}
	}
	
	public void moveRight() {
		x += speed;
	}
	
	public void moveLeft() {
		x -= speed;
	}
	
	public Rectangle collision() {
		return new Rectangle(getX(), getY(), getWidth(), getHeight());
	}
	
	public Image setPlayerImage() {
		try {
			playerImg = ImageIO.read(this.getClass().getResourceAsStream(playerImgURL));
		}catch(IOException e) {
			e.printStackTrace();
		}
		return playerImg;
	}
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(playerImg, x, y, null);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
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
