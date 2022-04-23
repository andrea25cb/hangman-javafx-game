package model;

public class HangMan {
	private String missingWord;
	private char[] mask;
	private int fails;
	private String letters;
	private Music music;
	
	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}

	public HangMan(String word) {
		this.missingWord = word.toUpperCase();
		this.mask = new char[word.length()];
		for (int i = 0; i < word.length(); i++) {
			mask[i] = '-';
		}
		this.fails = 0;
		this.letters = "";
	}

	public String getMask() {
		String s = "";
		for (int i = 0; i < mask.length; i++) {
			s += " " + mask[i] + " ";
		}
		return s;
	}

	public boolean isSaveLetter(char letter) {
		int p = letters.indexOf(letter);// "ABCD"
		if (p == -1) {
			letters += letter;
			return false;
		}
		return true;
	}

	public String getLetters() {
		return letters;
	}

	public boolean checkLetter(char letter) {
		boolean esta = false;
		for (int i = 0; i < this.missingWord.length(); i++) {
			if (this.missingWord.charAt(i) == letter) {
				mask[i] = letter;
				esta = true;
			}
		}
		return esta;
	}

	public boolean equals(String word) {
		if(missingWord.equals(word))
			return true;
		return false;
	}
	
	public boolean youWin() {
		for (int i = 0; i < mask.length; i++) {
			if ((mask[i] == '-') || (missingWord.equals(letters)))
			//	music.setMusic("music/songwin");
				return false;
		}
		return true;//ganas si te quedas sin guiones
	}

	public int getFails() {
		return fails;
	}

	public void upFails() {
		++this.fails;
	}
	public String getMissingWord() {
		return missingWord;
	}
	public void setMissingWord(String missingWord) {
		this.missingWord = missingWord;
	}
	
	
}
