package view;

import java.nio.file.Paths;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class IntroPane extends StackPane{

private Media media;
private MediaPlayer player;
private MediaView view;

public IntroPane(){
	this.media= new Media(Paths.get("music/intro.mp4").toUri().toString());
	this.media.setOnError(() -> System.out.println("error media"));
	
	this.player= new MediaPlayer(media);
	this.player.setOnError(() -> System.out.println("error player"));
	this.player.setAutoPlay(true);
	
	this.view=new MediaView(player);
	this.view.setFitHeight(800);
	this.view.setFitWidth(800);
	
	this.getChildren().add(view);
}	
}
