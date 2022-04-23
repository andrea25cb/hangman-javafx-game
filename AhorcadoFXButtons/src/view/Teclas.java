package view;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class Teclas extends GridPane {

	private ArrayList<Button> teclas;

	public Teclas() throws Exception {

		teclas = new ArrayList<Button>();
		this.setAlignment(Pos.BASELINE_CENTER);
	

		this.setVgap(20);
		this.setHgap(20);
		
		int r = 0;
		int c = 0;
		for (int i = 0; i < 26; i++) {
			char letra = (char) ('A' + i);
			Button b = new Button(letra + " ");
			teclas.add(b);

			this.add(teclas.get(i), c++, r);
			if (c > 9) {
				c = 0;
				r++;
			}
		}
	}
	

	public void setTeclas(ArrayList<Button> teclas) {
		this.teclas = teclas;
	}

	public ArrayList<Button> getTeclas() {
		return teclas;
	}
}
