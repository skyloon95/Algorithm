package net.skhu;

import java.util.Comparator;
import java.util.List;

public class WordInfo implements Comparable<WordInfo> {
	private String word;
	private int count;

	public WordInfo(String word) {
		this.word = word;
		this.count = 1;
	}

	public String getWord() {
		return word;
	}

	public int getCount() {
		return count;
	}

	public void addtCount() {
		this.count++;
	}

	@Override
	public int compareTo(WordInfo o) {
		// TODO Auto-generated method stub
		return this.word.compareToIgnoreCase(o.getWord());
	}
	
	public static int contains(List<WordInfo> list, String word) {
		for(int i = 0 ; i<list.size() ; i++) {
			if(list.get(i).getWord().equals(word))
				return i;
		}
		return -1;
	}
}

class WordInfoComparator implements Comparator<WordInfo>{

	@Override
	public int compare(WordInfo o1, WordInfo o2) {
		// TODO Auto-generated method stub
		return o1.getWord().compareToIgnoreCase(o2.getWord());
	}
	
}
