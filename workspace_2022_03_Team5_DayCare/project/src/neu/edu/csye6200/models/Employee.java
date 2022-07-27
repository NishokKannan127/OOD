package neu.edu.csye6200.models;

public class Employee {
	Review rev;
	Teacher teacher;
	public Employee(Teacher teacher, Review rev) {
		this.rev=rev;
		this.teacher=teacher;
	}
}
