package neu.edu.csye6200.models;

import java.util.ArrayList;
import java.util.List;

public class Group {
	private Employee emp;
	private List<StudentDetails> studDetailsList;
	private long id=0;
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
	
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	public List<StudentDetails> getStudDetailsList() {
		return studDetailsList;
	}
	public void setStudDetailsList(List<StudentDetails> studDetailsList) {
		this.studDetailsList = studDetailsList;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public static int getCounter() {
		return counter;
	}
	public static void setCounter(int counter) {
		Group.counter = counter;
	}
	@Override
	public String toString() {
		return "Group "+ String.valueOf(id);
	}
}
