package Map;

import java.util.ArrayList;

public class Map {
	
	private ArrayList<Terrain> terrains;

	public Map(ArrayList<Terrain> terrains) {
		makeTerrains();
		//terrains = randomizeOrder();
	}
	
	public void run() {
		
	}
	
	public void makeTerrains() {
		//Terrain map1 = new Terrain("map1", 1, "src/MapFiles/map1.txt", "cool purple sky")
	}
	
	public ArrayList<Terrain> randomizeOrder(){
		ArrayList<Terrain> temp = new ArrayList<Terrain>();
		for(int i = 0; i < terrains.size(); i++) {
			int random = (int) (Math.random()*terrains.size());
			temp.add(terrains.get(random));
		}
		return temp;
	}

	public ArrayList<Terrain> getTerrains() {
		return terrains;
	}

	public void setTerrains(ArrayList<Terrain> terrains) {
		this.terrains = terrains;
	}
	
}
