package neu.edu.csye6200.models;

public class StudentDetails {
	Person person;
	String parentName;
	Immunization im;
	Registration reg;
	String groupid;
	String classid;
	
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

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public String getClassid() {
		return classid;
	}

	public void setClassid(String classid) {
		this.classid = classid;
	}
	
}
