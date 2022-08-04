package neu.edu.csye6200.models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
	public static void writeItems(String itemsToWrite, String filepath) {
		try(FileWriter fw = new FileWriter(filepath, true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			    out.println(itemsToWrite);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
