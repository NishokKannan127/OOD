package neu.edu.csye6200.models;
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
		Integer id = 0;
		String fName = "";
		String lName = "";
		String doj= "";
		String address="";

		try {
			id = Integer.parseInt(delimiter[0]);

		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		fName = delimiter[1];
		lName = delimiter[2];
		doj= delimiter[3];
		address= delimiter[4];

		
		this.setId(id);
		this.setFirstName(fName);
		this.setFirstName(lName);
		this.setDoj(doj);
		this.setAddress(address);
		

	}

}
