package neu.edu.csye6200.models;

import java.util.ArrayList;
import java.util.List;

public class StudentDirectory {
	List<Student> studentList;
	public StudentDirectory() {
		studentList = new ArrayList<Student>();
	}
	public void addStudent(Person pers) {
		Student stu = (Student)pers;
		studentList.add(stu);
	}
}
