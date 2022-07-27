package neu.edu.csye6200.models;

import java.util.ArrayList;
import java.util.List;

public class PersonDirectory {
	//List<Person> personList;
	StudentDirectory stuDir;
	TeacherDirectory teachDir;
	
	public PersonDirectory() {
		stuDir = new StudentDirectory();
		teachDir = new TeacherDirectory();
	}
	

	public void addStudent(Person pers) {
		stuDir.addStudent(pers);
	}
	public void removeStudent() {
		
	}
	public void addTeacher(Person pers) {
		teachDir.addTeacher(pers);
	}
	public void removeTeacher() {
		
	}
	
	public StudentDirectory getStuDir() {
		return stuDir;
	}

	public void setStuDir(StudentDirectory stuDir) {
		this.stuDir = stuDir;
	}

	public TeacherDirectory getTeachDir() {
		return teachDir;
	}

	public void setTeachDir(TeacherDirectory teachDir) {
		this.teachDir = teachDir;
	}

	
}
