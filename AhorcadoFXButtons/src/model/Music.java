package model;

import java.net.URI;
import java.nio.file.Paths;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Music {
	MediaPlayer mediaPlayer;
	String music;
	public void music(String music) {
		this.music=music;
		//music = "song.mp3";
		Media h = new Media(Paths.get(music).toUri().toString());
		mediaPlayer = new MediaPlayer(h);
		mediaPlayer.play();
	}
	
	private static double VOL = 0.2; // default volume 20%
	
	public static void playSound(URI sound) {		
		AudioClip clip = new AudioClip(sound.toString());
		clip.setVolume(VOL);
		clip.play();
	}

	
	public String getMusic() {
		return music;
	}
	public void setMusic(String music) {
		this.music = music;
	}

}