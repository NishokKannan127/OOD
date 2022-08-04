package neu.edu.csye6200.models;

import java.util.ArrayList;
import java.util.List;

public class Group {
	Employee emp;
	List<StudentDetails> studDetailsList;
	long id=0;
	static int counter=0;
	
	public Group() {
		id=counter++;
		studDetailsList = new ArrayList<StudentDetails>();
	}
	public Group(Employee emp) {
		this();
		this.emp=emp;
	}
	
	public void addStudentDetails(StudentDetails sd) {
		this.studDetailsList.add(sd);
	}
	
	@Override
	public String toString() {
		return "Group "+ String.valueOf(id);
	}
}
