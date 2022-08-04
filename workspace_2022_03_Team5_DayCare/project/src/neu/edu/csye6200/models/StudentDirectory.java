package neu.edu.csye6200.models;

import java.util.ArrayList;
import java.util.List;

public class StudentDirectory {
	List<StudentDetails> studentList;
	public StudentDirectory() {
		studentList = new ArrayList<StudentDetails>();
	}
//	}
	public void addStudentDetails(StudentDetails st) {
		studentList.add(st);
	}
	
	public List<StudentDetails> getStudentList(){
		return this.studentList;
	}
}
