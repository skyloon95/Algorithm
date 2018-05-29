package net.skhu;

import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CountWords {
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
		
		String regex = "[.*''\"\"?!`~<>/@\\[\\]\\(\\)=%;:,]";
		txt = txt.replaceAll(regex, "");
		txt = txt.replaceAll(" ", "/");
		List<String> wordList = Arrays.asList(txt.split("/"));
		
		for(String s : wordList) {
			if(wordMap.containsKey(s)) {
				wordMap.put(s, wordMap.get(s)+1);
			} else {
				wordMap.put(s, 1);
			}
		}

		for(String key : wordMap.keySet()){
			 
            int value = wordMap.get(key);
 
            System.out.println(key+" : "+value);
 
        }
	}
}
