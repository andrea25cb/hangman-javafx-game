package view;

import java.io.FileInputStream;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Menu extends GridPane {

	private Label title; // HANGMAN hacer logo chulo online
	private Button start; // para empezar a jugar, cambia a la segunda escena
	private Button exit; // salir del juego

	private ImageView imV;

	private static final String BUTTON_SFX = "music/robotSFX.wav"; // para que sue

	public Menu() throws Exception {

		this.setVgap(20);
		this.setHgap(20);

		FileInputStream d = new FileInputStream("images/fondohangman-overlay.png");
		Image img = new Image(d);
		imV = new ImageView(img);

		start = new Button("PLAY");
		exit = new Button("EXIT");
		this.imV = new ImageView();

		this.add(this.start, 1, 20);
		this.add(this.exit, 2, 20);
		this.add(this.imV, 1, 1);

		imV.setFitHeight(14);
		imV.setFitWidth(14);

		start.setFont(new Font("Lucida Sans Unicode", 20));
		start.setTextFill(Color.DARKSEAGREEN);
		start.setStyle("-fx-border-color: DARKGREEN; -fx-border- width: 5px; -fx-background-color: GREEN;");

		exit.setFont(new Font("Lucida Sans Unicode", 20));
		exit.setTextFill(Color.DARKSEAGREEN);
		exit.setStyle("-fx-border-color: DARKGREEN; -fx-border- width: 5px; -fx-background-color: GREEN;");
		this.setAlignment(Pos.BASELINE_CENTER);

		FileInputStream f = new FileInputStream("images/fondohangman-overlay.png");
		Image bgImage = new Image(f);
		BackgroundImage bg = new BackgroundImage(bgImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT, new BackgroundSize(800, 500, false, false, false, false));
		this.setBackground(new Background(bg));

	}

	// boton para salir del juego
	/*
	 * private void createExitButton() { Button exit = new Button("EXIT"); //
	 * addMenuButton(exit); exit.setOnAction(new EventHandler<ActionEvent>() {
	 * 
	 * @Override public void handle(ActionEvent arg0) { try {
	 * SoundEffects.playSound(new URI(BUTTON_SFX)); } catch (URISyntaxException e) {
	 * e.printStackTrace(); } Platform.exit(); mainStage.close(); } }); }
	 */

	public Label getTitle() {
		return title;
	}

	public void setTitle(Label title) {
		this.title = title;
	}

	public Button getStart() {
		return start;
	}

	public void setStart(Button start) {
		this.start = start;
	}

	public Button getExit() {
		return exit;
	}

	public void setExit(Button exit) {
		this.exit = exit;
	}

	public static String getButtonSfx() {
		return BUTTON_SFX;
	}

	public ImageView getImg() {
		return imV;
	}

	public void setImg(ImageView img) {
		this.imV = img;
	}

}
