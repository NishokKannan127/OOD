package neu.edu.csye6200.models;

public class StudentDetails {
	Person person;
	String parentName;
	Immunization im;
	Registration reg;
	Group group;
	Classroom classroom;
	
	public StudentDetails(Person person) {
		this.person=person;
	}

	public Person getStudent() {
		return person;
	}

	public void setStudent(Person person) {
		this.person = person;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public Immunization getIm() {
		return im;
	}

	public void setIm(Immunization im) {
		this.im = im;
	}

	public Registration getReg() {
		return reg;
	}

	public void setReg(Registration reg) {
		this.reg = reg;
	}

	public String getClassid() {
		return this.classroom.getClassroomname();
	}
	
	public String getGroupid() {
		return this.group.getGroupName();
	}
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	@Override
	public String toString() {
		return String.valueOf(this.getStudent().getId());
	}
	
}
