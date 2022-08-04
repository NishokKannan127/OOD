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
	public static void writeItems(String itemsToWrite, String filepath) {
		String line;
		
//		try {
//			enrollmentContent= FileUtil.readItems("src/neu/edu/csye6200/csv/EnrollmentRoster.txt");
//		}
//		catch(Exception ex) {
//			errorCheck = ex.toString()+" "+"unable to find contents";
//		}
//		while(j!=enrollmentContent.size())
//		{
//			Person obj= sFactory.createObject(enrollmentContent.get(j));
////			System.out.print(obj);
////			Student s = (Student)obj;
//			StudentDetails st = new StudentDetails(obj);
//			if(j%3==0) {
//				st.setGroupid("Group 1");
//			}
//			else if(j%3==1) {
//				st.setGroupid("Group 2");
//			}
//			else {
//				st.setGroupid("Group 3");
//			}
//			if((j%10)<5) {
//				st.setClassid("Class 1");
//			}
//			else {
//				st.setClassid("Class 2");
//			}
//			personDir.addStudentDet(st);
//			j++;
//		}
//		if(errorCheck=="") {
//			return 1; //successful
//		}
//		else {
//			return 0;
//		}
	}

}
