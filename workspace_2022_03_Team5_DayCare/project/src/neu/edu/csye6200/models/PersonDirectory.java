package neu.edu.csye6200.models;

import java.util.ArrayList;
import java.util.List;

public class PersonDirectory {
	//List<Person> personList;
	StudentDirectory stuDir;
	EmployeeDirectory empDir;
	
	public PersonDirectory() {
		stuDir = new StudentDirectory();
		empDir = new EmployeeDirectory();
	}
	

	public void addStudentDet(StudentDetails pers) {
		stuDir.addStudentDetails(pers);
	}
	public void removeStudent() {
		
	}
	public void addEmployee(Employee pers) {
		empDir.addEmployee(pers);
	}
	public void removeTeacher() {
		
	}
	
	public StudentDirectory getStuDir() {
		return stuDir;
	}

	public void setStuDir(StudentDirectory stuDir) {
		this.stuDir = stuDir;
	}

	public EmployeeDirectory getEmpDir() {
		return empDir;
	}

	public void setEmpDir(EmployeeDirectory empDir) {
		this.empDir = empDir;
	}

	
}
