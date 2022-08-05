package neu.edu.csye6200.models;

public class Student extends Person{
	String dob;
	//mm/dd/yy
	int age;
	String parentName;
	
public Student(String line) {
		
		String delimiter[]=line.split(",");
		id=counter++;
		//Integer id = 0;
		String fName = "";
		String lName = "";
		String dob= "";
		String parentName= "";
		String address="";
		
		fName = delimiter[1];
		lName = delimiter[2];
		dob= delimiter[3];
		parentName = delimiter[4];
		address = delimiter[5];

		
		this.setId(id);
		this.setFirstName(fName);
		this.setLastName(lName);
		this.setDob(dob);
		this.setParentName(parentName);
		this.setAddress(address);
		

	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	

}
