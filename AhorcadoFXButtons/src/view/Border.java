package view;

import java.io.FileInputStream;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Border extends BorderPane {

	Body body;
	Teclas teclas;
	ImageView mainPane;

	public Border(Body p, Teclas t) throws Exception {

		this.body = p;
		this.teclas = t;
		this.setCenter(body);
		this.setBottom(teclas); 

		teclas.setStyle("-fx-background-color: rosybrown; -fx-color:green; -fx-font-size:18px");
		teclas.setAlignment(Pos.BASELINE_CENTER);

		FileInputStream f = new FileInputStream("images/hangmanW.jfif");
		Image bgImage = new Image(f);
		BackgroundImage bg = new BackgroundImage(bgImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT, new BackgroundSize(800, 500, false, false, false, false));
		this.setBackground(new Background(bg));
	}

	public Border(ImageView imageview) throws Exception {
		this.mainPane = imageview;
		// createBackground();
	}

}
