package control;

import java.io.File;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicThread extends Thread
{
	/**
	 * This method initializes the soundtrack to be player.
	 */
	 public void run()
	 {
	      try {
	        Clip clip = AudioSystem.getClip();
	        AudioInputStream inputStream = AudioSystem.getAudioInputStream(Main.class.getResourceAsStream("/sounds/background/"+getRandomBackgroundMusic()));        
	        clip.open(inputStream);
	        clip.start();
	        sleep(clip.getMicrosecondLength());
	      } catch (Exception e) {
	        System.err.println("Did not work :(");
	      }
	 }
	 /**
	  * Returns the name of a random backgroundmusic file.
	  * (a random file from the /sounds/background/ folder)
	  */
	 private String getRandomBackgroundMusic()
	 {
		 Random rand = new Random();
		 File folder = new File("./"+"/sounds/background/");
		 File[] listOfFiles = folder.listFiles();
	     int random = rand.nextInt(listOfFiles.length);
		 return listOfFiles[random].getName();
	 }
}
