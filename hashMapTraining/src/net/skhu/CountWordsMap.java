package net.skhu;

import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CountWordsMap {
	public static void main(String[] args) {
		Map<String, Integer> wordMap = new HashMap<String, Integer>();
		
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
		
		for(String s : wordList) {
			if(wordMap.containsKey(s)) {
				wordMap.put(s, wordMap.get(s)+1);
			} else {
				wordMap.put(s, 1);
			}
		}
		List<String> keyList = new ArrayList<String>(wordMap.keySet());
		keyList.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareToIgnoreCase(o2);
			}
			
		});

		for(String key : keyList){
			 
            int value = wordMap.get(key);
 
            System.out.println(key+" : "+value);
 
        }
	}
}
