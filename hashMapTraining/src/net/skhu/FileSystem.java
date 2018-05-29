package net.skhu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileSystem {
	public static String readTXT(Path path) {
		File txtFile = path.toFile();

		StringBuffer buf = new StringBuffer();
		try {
			@SuppressWarnings("resource")
			BufferedReader buffer = new BufferedReader(new FileReader(txtFile));
			String line;
			while((line = buffer.readLine()) != null) {
				buf.append(line).append(" ");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return buf.toString();
	}
	
	public static List<String> getFileListInDirectory(String directoryPath, String format){
		List<String> fileList = new ArrayList<String>();

		String fileFormat = ".+\\.("+format.toLowerCase()+")|("+format.toUpperCase()+")";	//	파일 포맷을 구분하는 regex

		File[] files = new File(directoryPath).listFiles();

		//	 파일의 절대경로를 가져오고, 만약 regex와 일치할 경우 리스트에 add
		for(File f : files) {
			String tmp = f.getAbsolutePath();
			if(tmp.matches(fileFormat)) {
				fileList.add(tmp);
			}
		}

		return fileList;
	}	
}
