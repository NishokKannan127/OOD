package neu.edu.csye6200.models;

import java.util.ArrayList;
import java.util.List;

//This is the teacher class
public class Teacher extends Person{
	String doj;	
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
public Teacher(String line) {
		
		String delimiter[]=line.split(",");
		id=counter++;
		//Integer id = 0;
		String fName = "";
		String lName = "";
		String doj= "";
		String address="";
		String email="";
		

		try {
			id = Integer.parseInt(delimiter[0]);

		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		fName = delimiter[1];
		lName = delimiter[2];
		doj= delimiter[3];
		address= delimiter[4];
		email=delimiter[5];

		
		//this.setId(id);
		this.setFirstName(fName);
		this.setLastName(lName);
		this.setDoj(doj);
		this.setAddress(address);
		this.setEmailAddress(email);
		

	}

}
