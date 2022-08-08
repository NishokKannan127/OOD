package neu.edu.csye6200.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Group {
	private String groupName;
	private Employee emp;
	private List<StudentDetails> studDetailsList;
	private long id;
	static int counter=0;
	
	public Group() {
		studDetailsList = new ArrayList<StudentDetails>();
		long leftLimit = 1000L;
	    long rightLimit = 10000L;
	    this.id = leftLimit + (long) (new Random().nextFloat() * (rightLimit - leftLimit));
	    this.groupName = "Group ".concat(String.valueOf(id));
	    
	}
	public Group(Employee emp) {
		this();
		this.emp=emp;
	}
	
	
	
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
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
