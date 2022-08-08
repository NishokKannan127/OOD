package neu.edu.csye6200.models;

public class Employee {
	Review rev;
	Teacher teacher;
	boolean isEmployed;
	public Employee(Teacher teacher, Review rev) {
		this.rev=rev;
		this.teacher=teacher;
		this.isEmployed = false;
	}
	public Teacher getEmployee()
	{
		return teacher;
	}
	
	
	public Review getRev() {
		return rev;
	}
	public void setRev(Review rev) {
		this.rev = rev;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public boolean isEmployed() {
		return isEmployed;
	}
	public void setEmployed(boolean isEmployed) {
		this.isEmployed = isEmployed;
	}
	@Override
	public String toString() {
		return String.valueOf(teacher.id);
	}
	
}
