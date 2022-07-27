package neu.edu.csye6200.models;

import java.util.ArrayList;
import java.util.List;

public class TeacherDirectory {
	List<Teacher> teacherList;
	public TeacherDirectory() {
		teacherList = new ArrayList<Teacher>();
	}
	public void addTeacher(Person pers) {
		// TODO Auto-generated method stub
		Teacher stu = (Teacher)pers;
		teacherList.add(stu);
	}
}
