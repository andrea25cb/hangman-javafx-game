package view;

import java.io.FileInputStream;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.Dictionary;
import model.HangMan;

public class Body extends GridPane {

	private Label title;
	private Label missingWord;// palabra a acertar
	private Label mask; // salen los guiones
	private Label escribeLabel; // letras dichas
	private Label result;// 'has fallado'/'acertaste'
	private Label fails;
	private Label nfails;
	private ImageView imV;
	private HangMan hangman;
	private Button button;// check letter
	private Button restart; // restart game

	public Body() throws Exception {

		this.setVgap(20);
		this.setHgap(20);

//cambiar de sitio:
		Dictionary dic = new Dictionary("dictionary.txt");// mis palabras
		String wordgame = dic.getRandomWord();
		hangman = new HangMan(wordgame);// modelo
		FileInputStream d = new FileInputStream("images/0.png");
		Image img = new Image(d);
		imV = new ImageView(img);

		this.setVgap(15);
		this.setHgap(15);

		this.setAlignment(Pos.BASELINE_CENTER);

		this.title = new Label("WELCOME TO HANGMAN");
		this.missingWord = new Label(wordgame);
		this.mask = new Label(hangman.getMask());// guiones
		this.result = new Label();
		this.fails = new Label("Fails:");
		this.nfails = new Label("0");
		this.escribeLabel = new Label();
		this.imV = new ImageView();

		restart = new Button("NEW GAME");

		title.setFont(new Font("Impact", 40));
		title.setTextFill(Color.BLACK);
		mask.setFont(new Font("Lucida Sans Unicode", 30));
		mask.setTextFill(Color.BLACK);
		result.setFont(new Font("Impact", 30));
		result.setTextFill(Color.BLACK);
		fails.setFont(new Font("Lucida Sans Unicode", 20));
		fails.setTextFill(Color.BLACK);
		nfails.setFont(new Font("Lucida Sans Unicode", 20));
		nfails.setTextFill(Color.BLACK);

		restart.setFont(new Font("Lucida Sans Unicode", 20));
		restart.setTextFill(Color.DARKSEAGREEN);
		restart.setStyle("-fx-border-color: DARKGREEN; -fx-border- width: 5px; -fx-background-color: DARKGREEN;");

		this.add(this.title, 1, 1);
		this.add(this.mask, 1, 6);//
		this.add(this.restart, 4, 6);
		this.add(this.result, 1, 8);
		this.add(this.fails, 4, 1);
		this.add(this.nfails, 5, 1);
		this.add(this.escribeLabel, 1, 7);
		this.add(this.imV, 4, 8);

		imV.setFitHeight(140);
		imV.setFitWidth(140);

	}

	Alert win = new Alert(AlertType.INFORMATION, "CONGRATULATIONS!!!! YOU ARE A WINNER!");
	Alert lose = new Alert(AlertType.INFORMATION, "OH NO... YOU ARE DEAD.");

	public Alert getWin() {
		return win;
	}

	public void setWin(Alert win) {
		this.win = win;
	}

	public Alert getLose() {
		return lose;
	}

	public void setLose(Alert lose) {
		this.lose = lose;
	}

	public Label getEscribeLabel() {
		return escribeLabel;
	}

	public void setEscribeLabel(Label escribeLabel) {
		this.escribeLabel = escribeLabel;
	}

	public Label getResult() {
		return result;
	}

	public void setResult(Label result) {
		this.result = result;
	}

	public Label getMask(Label missingWord) {
		return mask;
	}

	public void setMask(Label mask) {
		this.mask = mask;
	}

	public Button button() {
		return null;
	}

	public Button getButton() {
		return button;
	}

	public void setButton(Button button) {
		this.button = button;
	}

	public Label getFails() {
		return fails;
	}

	public void setFails(Label fails) {
		this.fails = fails;
	}

	public Label getMissingWord() {
		return missingWord;
	}

	public void setMissingWord(Label missingWord) {
		this.missingWord = missingWord;
	}

	public Label getMask() {
		return mask;
	}

	public HangMan getHangman() {
		return hangman;
	}

	public void setHangman(HangMan hangman) {
		this.hangman = hangman;
	}

	public Label getNfails() {
		return nfails;
	}

	public void setNfails(Label nfails) {
		this.nfails = nfails;
	}

	public Button getRestart() {
		return restart;
	}

	public ImageView getImg() {
		return imV;
	}

	public void setImg(ImageView img) {
		this.imV = img;
	}

}