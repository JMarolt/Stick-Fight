package Sounds;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

	public Sound() {
		
	}
	
	public void playNoise(String fileName) {
		try {
			File noise = new File(fileName);
			if(noise.exists()) {
				AudioInputStream audio = AudioSystem.getAudioInputStream(noise);
				Clip clip = AudioSystem.getClip();
				clip.open(audio);
				clip.start();
			}
		}catch(Exception e) {
			System.out.println("Sound File Broken");
			e.printStackTrace();
		}
	}
	
}
