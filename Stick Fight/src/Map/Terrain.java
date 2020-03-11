package Map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Terrain {
	
	private String name;
	private int ID;
	private File file;
	private BufferedImage backgroundImage;
	private ArrayList<Texture> images;
	private ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
	private ArrayList<Point> spawnpoints;
	private int fileScale;
	private int heightScale;
	private int totalNumberOfObstacles;

	public Terrain(String name, int ID, File file, BufferedImage backgroundImage, ArrayList<Texture> images,
			ArrayList<Obstacle> obstacles, ArrayList<Point> spawnpoints, int fileScale, int totalNumberOfObstacles) {
		this.name = name;
		this.ID = ID;
		this.file = file;
		this.backgroundImage = backgroundImage;
		this.images = images;
		this.obstacles = obstacles;
		spawnpoints = setSpawns();
		this.fileScale = fileScale;
		this.totalNumberOfObstacles = totalNumberOfObstacles;
		createTerrain();
	}
	
	public Terrain(File file, int fileScale, int heightScale, int totalNumberOfObstacles) {
		this.file = file;
		this.fileScale = fileScale;
		this.heightScale = heightScale;
		this.totalNumberOfObstacles = totalNumberOfObstacles;
		createTerrain();
		//obstacles = optimalObstacles();
	}

	public void createTerrain() {
		try {
			int ycounter = 0;
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			while (line != null) {
				String temp = line;
				for (int i = 0; i < temp.length(); i++) {
					if (temp.substring(i, i + 1).equals("b")) {
						obstacles.add(new Obstacle(i * fileScale, ycounter * fileScale, fileScale, heightScale));
					}
				}
				line = br.readLine();
				ycounter++;
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found...");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("File is not compatible or method is broken");
			e.printStackTrace();
		}
	}
	
	public void loadTerrain(Graphics2D g) {
		g.drawImage(backgroundImage, 0, 0, null);
		loadImages(g);
	}

	public void loadImages(Graphics2D g) {
		g.setColor(Color.black);
		for(int i = 0; i < images.size(); i++) {
			g.drawImage(images.get(i).getImg(), images.get(i).getX(), images.get(i).getY(), null);
		}
	}
	
	public ArrayList<Obstacle> optimalObstacles() {
		//theory: arraylist has already combined obstacle number 45 while also trying to access it at the same time
		for(int k = 0; k < obstacles.size(); k++) {
			System.out.println(obstacles.get(k) + " " + k);
		}
		while(obstacles.size() != totalNumberOfObstacles) {
			for(int i = 0; i < obstacles.size() - 1; i++) {
				//System.out.println(i);
				System.out.println(obstacles.get(i + 1) + " " + (i+1));
				obstacles.add(connectTwoObstacles(obstacles.get(i), obstacles.get(i + 1)));
				obstacles.remove(obstacles.get(i));
				obstacles.remove(obstacles.get(i + 1));
				//System.out.println(obstacles.size());
			}
		}
		return obstacles;
	}
	
	public Obstacle connectTwoObstacles(Obstacle a, Obstacle b) {
		if(a.getX() < b.getX() && a.getY() == b.getY()) {
			return new Obstacle(a.getX(), a.getY(), a.getWidth() + b.getWidth(), a.getHeight());
		}else if(a.getX() > b.getX() && a.getY() == b.getY()) {
			return new Obstacle(b.getX(), b.getY(), a.getWidth() + b.getWidth(), a.getHeight());
		}else if(a.getX() == b.getX() && a.getY() < b.getY()) {
			return new Obstacle(a.getX(), a.getY(), a.getWidth(), a.getHeight() + b.getHeight());
		}else if(a.getX() == b.getX() && a.getY() > b.getY()) {
			return new Obstacle(a.getX(), b.getY(), b.getWidth(), b.getHeight() + a.getHeight());
		}
		return null;
	}
	
	public ArrayList<Point> setSpawns() {
		for(int i = 0; i < obstacles.size(); i++) {
			spawnpoints.add(new Point(obstacles.get(i).getX(), obstacles.get(i).getY()));
		}
		return spawnpoints;
	}
	
	public Point randoimizeSpawn() {
		int random = (int) (Math.random()*spawnpoints.size());
		return spawnpoints.get(random);
	}
	
	public void drawTestTerrain(Graphics g) {
		g.setColor(Color.black);
		for(int i = 0; i < obstacles.size(); i++) {
			g.fillRect(obstacles.get(i).getX(), obstacles.get(i).getY(), obstacles.get(i).getWidth(), obstacles.get(i).getHeight());
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public BufferedImage getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackground(BufferedImage backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

	public ArrayList<Texture> getImages() {
		return images;
	}

	public void setImages(ArrayList<Texture> images) {
		this.images = images;
	}

	public ArrayList<Obstacle> getObstacles() {
		return obstacles;
	}

	public void setObstacles(ArrayList<Obstacle> obstacles) {
		this.obstacles = obstacles;
	}

	public ArrayList<Point> getSpawnpoints() {
		return spawnpoints;
	}

	public void setSpawnpoints(ArrayList<Point> spawnpoints) {
		this.spawnpoints = spawnpoints;
	}

	public int getFileScale() {
		return fileScale;
	}

	public void setFileScale(int fileScale) {
		this.fileScale = fileScale;
	}

	public int getTotalNumberOfObstacles() {
		return totalNumberOfObstacles;
	}

	public void setTotalNumberOfObstacles(int totalNumberOfObstacles) {
		this.totalNumberOfObstacles = totalNumberOfObstacles;
	}

}
