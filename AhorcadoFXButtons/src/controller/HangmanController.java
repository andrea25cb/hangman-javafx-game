package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.HangMan;
import model.Music;
import view.Body;
import view.Border;
import view.Menu;
import view.Teclas;

public class HangmanController<Textfield> {
	@FXML
	private Body vista;
	@FXML
	private Menu menu;
	@FXML
	private Border border;
	@FXML
	private Teclas tecla;
	@FXML
	private ImageView hangmanImage;
	@FXML
	private HangMan hangman;// modelo
	@FXML
	private Textfield letter;
	@FXML
	private Button boton2;// restart
	@FXML
	private Button startButton;// start
	@FXML
	private Music music;
	@FXML
	private Stage primaryStage;
	@FXML
	ArrayList<Image> imagenes = new ArrayList<Image>();
	ArrayList<Button> teclas;

	public HangmanController(Menu menu, Stage primaryStage) {

		this.primaryStage = primaryStage;
		this.menu = menu;
	//	menu.getPhrase();

		// startButton.setOnAction(new Manejador3());// restart game

	}

	public HangmanController(Body vista, Border border, Teclas teclas2) throws FileNotFoundException {
		this.vista = vista;
		hangman = new HangMan(vista.getMissingWord().getText());

		for (int i = 0; i < 8; i++)
			imagenes.add(new Image(new FileInputStream("images/" + i + ".png")));

		this.vista.getMask().setText(this.hangman.getMask());

		this.border = border;
		this.tecla = teclas2;
		teclas = tecla.getTeclas();
		for (int i = 0; i < teclas.size(); i++) {
			teclas.get(i).setOnAction(new Manejador());
		}

	}

	public HangmanController(Body vista, Stage primaryStage, Border border, Teclas teclas2) {

		this.primaryStage = primaryStage;
		this.vista = vista;
		hangman = new HangMan(vista.getMissingWord().getText());
		boton2 = vista.getRestart();
		this.tecla = teclas2;
		teclas = tecla.getTeclas();
		boton2.setOnAction(new Manejador2());// restart game

	}

	class Manejador implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent arg0) {
			try {
				String palabraSecreta = vista.getMissingWord().getText().toUpperCase();

				Button t = (Button) arg0.getSource();
				char letra = t.getText().charAt(0);

				t.setDisable(true);// deseleccionar boton

				if (hangman.checkLetter(letra) == false) {
					hangman.upFails();
					vista.getResult().setText("Oh, no! Try another letter...");
					vista.getNfails().setText(String.valueOf(hangman.getFails()));// transformo el int en String
					System.out.println(hangman.getFails());
					vista.getImg().setImage(imagenes.get(hangman.getFails()));

				} else {
					hangman.isSaveLetter(letra);
					vista.getMask().setText(hangman.getMask());// vamos cambiando los guiones por las teclas que							// acertamos
					vista.getResult().setText("Perfect! Keep going");
				}

				if (hangman.youWin()) {
					vista.getResult().setText("YOU WON!! CONGRATULATIONS");
					vista.getWin().show();
					Music.playSound(new URI("music/songwin.mp3"));

					// music.music("music/songwin.mp3");
				}

				// System.out.println(palabraUser);
				System.out.println(palabraSecreta);

				if (hangman.getFails() > 6) {
					vista.getResult().setText("YOU RAN OUT OF TRIES!!");
					vista.getMask().setText(hangman.getMissingWord());
					vista.getLose().show();// ALERT
					//music.music("songlose.mp3");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	class Manejador2 implements EventHandler<ActionEvent> {
		// restart game//new word
		@Override
		public void handle(ActionEvent arg0) {
			try {

			//	Music music = new Music();
				//music.music("music/song.mp3");

				Body body = new Body();// vista
				Teclas teclas = new Teclas();
				Border border = new Border(body, teclas);

				Scene scene = new Scene(border, 700, 600);

				HangmanController boton = new HangmanController(body, border, teclas); // vista y modelo
				HangmanController boton2 = new HangmanController(body, primaryStage, border, teclas);

				primaryStage.setScene(scene);
				primaryStage.show();
				primaryStage.setTitle("HANGMAN");
			//	layout.getChildren().add(body);
			//	border.getChildren().add(body);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}