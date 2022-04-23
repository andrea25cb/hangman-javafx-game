package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.HangMan;
import model.Music;
import model.SoundEffects;
import view.Body;
import view.Border;
import view.Menu;
import view.Teclas;

public class MenuController {
	@FXML
	private Music music;
	@FXML
	private Button startButton;
	@FXML
	private Button exitButton;
	@FXML
	private Menu menu;
	@FXML
	private Stage primaryStage;
	@FXML
	private Body vista;
	@FXML
	private Border border;
	@FXML
	private Teclas tecla;
	@FXML
	private ImageView hangmanImage;
	@FXML
	private HangMan hangman;// modelo
	@FXML
	private Button boton2;// restart
	@FXML
	ArrayList<Image> imagenes = new ArrayList<Image>();
	ArrayList<Button> teclas;

	public MenuController(Menu menu, Stage primaryStage) throws FileNotFoundException {
		this.primaryStage = primaryStage;
		this.menu = menu;
		startButton = menu.getStart();

		startButton.setOnAction(new Manejador());// start game

	}

	class Manejador implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent arg0) {
			try {
				Music music = new Music();
				music.music("music/song.mp3");

				Body body = new Body();// vista
				Teclas teclas = new Teclas();
				Border border = new Border(body, teclas);

				Scene scene = new Scene(border, 700, 600);

				HangmanController boton = new HangmanController(body, border, teclas); // vista y modelo
				HangmanController boton2 = new HangmanController(body, primaryStage, border, teclas);

				primaryStage.setScene(scene);
				primaryStage.show();
				primaryStage.setTitle("HANGMAN");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public MenuController(Body vista, Stage primaryStage, Border border, Teclas teclas2) {

		this.primaryStage = primaryStage;
		this.vista = vista;
		hangman = new HangMan(vista.getMissingWord().getText());
		boton2 = vista.getRestart();
		this.tecla = teclas2;
		teclas = tecla.getTeclas();
		boton2.setOnAction(new Manejador2());// restart game

	}

	class Manejador2 implements EventHandler<ActionEvent> {
		private Stage primaryStage;

		// restart game//new word
		@Override
		public void handle(ActionEvent arg0) {
			try {

				Music music = new Music();
				music.music("music/song.mp3");

				Body body = new Body();// vista
				Teclas teclas = new Teclas();
				Border border = new Border(body, teclas);

				Scene scene = new Scene(border, 700, 600);

				FileInputStream stream = new FileInputStream("vaca3.jfif");
				Image image = new Image(stream);
				ImageView imageview = new ImageView(image);
				StackPane layout = new StackPane(imageview);

				HangmanController boton = new HangmanController(body, border, teclas); // vista y modelo
				HangmanController boton2 = new HangmanController(body, primaryStage, border, teclas);

				primaryStage.setScene(scene);
				primaryStage.show();
				primaryStage.setTitle("HANGMAN");
				layout.getChildren().add(body);
				border.getChildren().add(body);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void MenuController(Button exitButton, Stage primaryStage) {

			exitButton = menu.getExit();
			exitButton.setOnAction(new Manejador3());// restart game

			this.primaryStage = primaryStage;

		}

		class Manejador3 implements EventHandler<ActionEvent> {
			// EXIT
			@Override
			public void handle(ActionEvent arg0) {
				try {
					SoundEffects.playSound(new URI(menu.getButtonSfx()));
					MenuController exitButton = new MenuController(menu, primaryStage);
				} catch (URISyntaxException e) {
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Platform.exit();
				// menu.getMainStage().close();
			}
		}
	}
}
