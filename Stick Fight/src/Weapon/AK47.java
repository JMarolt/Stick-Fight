package Weapon;

import java.awt.Image;

import Map.Point;
import Sounds.Sound;

public class AK47 extends Gun{

	public AK47(Point p, int width, int height, int damage, int ammo, Sound sound, Image img, int weightFactor) {
		super(p, damage, ammo, weightFactor, weightFactor, sound, img, weightFactor);
	}

}
