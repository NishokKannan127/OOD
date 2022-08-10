package neu.edu.csye6200.models;

import java.util.ArrayList;
import java.util.List;

public class StudentDetails {
	Person person;
	String parentName;
	Immunization im;
	Registration reg;
	Group group;
	Classroom classroom;
	ImmunizationRule immunizationrule;
	private List<String> allVaccines;
	
	public StudentDetails(Person person) {
		this.person=person;
		this.im = new Immunization();
		this.allVaccines = new ArrayList<>();
	}
	

	public List<String> getAllVaccines() {
		return allVaccines;
	}



	public void setAllVaccines(List<String> allVaccines) {
		this.allVaccines = allVaccines;
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
	
	public void addVaccine(String vaccine, int value) {
		this.im.addImmunizationRecord(vaccine, value);
	}
	
	

	public ImmunizationRule getImmunizationrule() {
		return immunizationrule;
	}

	public void setImmunizationrule(ImmunizationRule immunizationrule) {
		this.immunizationrule = immunizationrule;
	}

	@Override
	public String toString() {
		return String.valueOf(this.getStudent().getId());
	}
	
}
