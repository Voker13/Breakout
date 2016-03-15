package model;

import java.util.LinkedList;

public class HighscoreList extends LinkedList<HighscoreEntry>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2149862055543169249L;

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
