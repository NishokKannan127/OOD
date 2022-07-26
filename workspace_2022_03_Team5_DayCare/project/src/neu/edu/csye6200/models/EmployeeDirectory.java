package neu.edu.csye6200.models;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDirectory {
	List<Teacher> teacherList;
	public EmployeeDirectory() {
		teacherList = new ArrayList<Teacher>();
	}
	public void addTeacher(Person pers) {
		// TODO Auto-generated method stub
		Teacher stu = (Teacher)pers;
		teacherList.add(stu);
	}
}
