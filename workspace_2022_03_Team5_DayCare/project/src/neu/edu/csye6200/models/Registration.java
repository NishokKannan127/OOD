package neu.edu.csye6200.models;

public class Registration {
	private Classroom classroom;
	private Group group;
	private StudentDetails studentDetails;
	
	public Registration(Group group, StudentDetails studentDetails) {
		this.group=group;
		this.studentDetails=studentDetails;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public StudentDetails getStudentDetails() {
		return studentDetails;
	}

	public void setStudentDetails(StudentDetails studentDetails) {
		this.studentDetails = studentDetails;
	}
	
}
