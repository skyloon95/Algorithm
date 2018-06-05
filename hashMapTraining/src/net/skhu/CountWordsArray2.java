package net.skhu;

import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CountWordsArray2 {
	public static void main(String[] args) {
		List<WordInfo> WIlist = new ArrayList<WordInfo>();

		Path projectPath = Paths.get(System.getProperty("user.dir"));
		try {
			projectPath = projectPath.toRealPath(LinkOption.NOFOLLOW_LINKS);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		List<String> scrPath = FileSystem.getFileListInDirectory(projectPath.toString(), "txt");

		Path filePath = Paths.get(scrPath.get(0));
		try {
			filePath = filePath.toRealPath(LinkOption.NOFOLLOW_LINKS);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String txt = FileSystem.readTXT(filePath);

		String regex = "[.*''\"\"?!`~<>/@\\[\\]\\(\\)=%;:,\\{\\}-]";
		txt = txt.replaceAll(regex, "");
		txt = txt.replaceAll(" ", "/");
		txt = txt.toLowerCase();
		List<String> wordList = Arrays.asList(txt.split("/"));

		int index;
		for(String s : wordList) {
			index = binarySearch(WIlist, 0, WIlist.size()-1, s);
			if(index!=-1) {
				WIlist.get(index).addtCount();
			}
			else {
				WIlist.add(new WordInfo(s));
				WIlist.sort(new WordInfoComparator());
			}
		}

		for(WordInfo w : WIlist){
			System.out.println(w.getWord() +" : "+ w.getCount());
		}
	}
	
	public static int binarySearch(List<WordInfo> list, int start, int end, String word) {
		if(start>=end)
			return -1;
		int middle = (start+end)/2;
		if(list.get(middle).getWord().compareToIgnoreCase(word)>0) {
			return binarySearch(list, start, middle-1, word);
		}
		if(list.get(middle).getWord().compareToIgnoreCase(word)<0) {
			return binarySearch(list, middle+1, end, word);
		}
		return middle;
	}
}