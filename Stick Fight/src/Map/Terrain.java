package Map;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Terrain {
	
	private String name;
	private int ID;
	private File file;
	private BufferedImage background;
	private ArrayList<Image> images;
	private ArrayList<Obstacle> obstacles;
	private ArrayList<Point> spawnpoints;
	private int fileScale;

	public Terrain(String name, int ID, File file, BufferedImage background, ArrayList<Image> images, ArrayList<Obstacle> obstacles, ArrayList<Point> spawnpoints, int fileScale) {
		this.name = name;
		this.ID = ID;
		this.file = file;
		this.background = background;
		this.images = images;
		this.obstacles = obstacles;
		this.spawnpoints = spawnpoints;
		this.fileScale = fileScale;
	}
	
	public void createTerrain() {
		
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

	public BufferedImage getBackground() {
		return background;
	}

	public void setBackground(BufferedImage background) {
		this.background = background;
	}

	public ArrayList<Image> getImages() {
		return images;
	}

	public void setImages(ArrayList<Image> images) {
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
	
}
