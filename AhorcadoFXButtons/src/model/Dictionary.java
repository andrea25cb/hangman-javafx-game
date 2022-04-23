package model;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Dictionary {
	private String dictName;//Nombre del fichero contiene el diccionario
	private Scanner dict;
	private ArrayList<String> wordList;
	
	public Dictionary (String mydict) throws Exception{
		this.dictName= mydict;
		dict = new Scanner(new File(this.dictName));
		wordList = new ArrayList<String>();
		
		while(dict.hasNext()) {

			wordList.add(dict.next());
		}
	}
		
	public String getRandomWord() {
		Random r = new Random();
		return wordList.get(r.nextInt(wordList.size()));
	}
}
