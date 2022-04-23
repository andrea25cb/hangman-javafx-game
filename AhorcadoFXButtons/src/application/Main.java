package application;

import java.io.FileNotFoundException;

import controller.MenuController;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.stage.Stage;
import model.Music;
import view.IntroPane;
import view.Menu;
import javafx.scene.Scene;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		IntroPane intro = new IntroPane();

		Scene scene = new Scene(intro, 800, 500);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("HANGMAN");
		primaryStage.show();

		delay(15000, () -> {
			try {
				Music music = new Music();
				music.music("music/songwin.mp3");

				Menu menu = new Menu();
				Scene scene2 = new Scene(menu, 800, 500);
				primaryStage.setScene(scene2);
				MenuController startBoton = new MenuController(menu, primaryStage); // boton
				menu.getChildren();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

	}

	public static void main(String[] args) {
		launch(args);
	}

	public static void delay(long millis, Runnable continuation) {
		Task<Void> sleeper = new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				try {
					Thread.sleep(millis);
				} catch (InterruptedException e) {
				}
				return null;
			}
		};
		sleeper.setOnSucceeded(event -> continuation.run());
		new Thread(sleeper).start();
	}
}
