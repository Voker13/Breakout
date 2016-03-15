package model;

import java.util.LinkedList;

import javax.swing.JOptionPane;

public class HighscoreList extends LinkedList<HighscoreEntry>{

	public HighscoreList() {
		
		for (int i=0; i<10; i++) {
			this.add(new HighscoreEntry("---", 0));
		}
	}
	
	public void addEntry(HighscoreEntry hse) {
		for (int i=0; i<this.size(); i++) {
			if (hse.getScore() > this.get(i).getScore()) {
				add(i, hse);
				break;
			}
		}
	}

}
