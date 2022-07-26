package neu.edu.csye6200.models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
	
	public static  List<String> readItems(String filepath) {
		List<String> content = new ArrayList<>();
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            
            while ((line = br.readLine()) != null) {
            	content.add(line);
               
            }
        }
		
		catch (IOException e) {
            e.printStackTrace();
        }
		return content;
	}

}
