package neu.edu.csye6200.models;

import java.util.ArrayList;
import java.util.List;

public class Classroom{
	List<Group> groupList;
	public Classroom() {
		groupList = new ArrayList<Group>();
	}
//	public void Initiate()
//	{
//		AbstractPersonFactory tFactory=new TeacherFactory();
//		AbstractPersonFactory sFactory=new StudentFactory();
//		String line;
//		int i=0,j=0,k=0;
//		List<String> employeeContent= FileUtil.readItems("src/edu/neu/csye6200/csv/EmployeeRoster.txt");
//		while(i!=employeeContent.size())
//		{
//			Person obj= tFactory.createObject(employeeContent.get(i));
//			i++;
//		}
//		List<String> enrollmentContent= FileUtil.readItems("src/edu/neu/csye6200/csv/EnrollmentRoster.txt");
//		while(j!=enrollmentContent.size())
//		{
//			Person obj= sFactory.createObject(enrollmentContent.get(j));
//			j++;
//		}
//	}

}
