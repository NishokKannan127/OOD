package neu.edu.csye6200.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class Student extends Person{
	String dob;
	//mm/dd/yy
	int age;
	String parentName;
	
public Student(String line) {
		
		String delimiter[]=line.split(",");
		id=++counter;
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
	public String getAge() throws ParseException {
		// TODO Auto-generated method stub
		String dob = this.getDob();
		return calculateAge(dob);
	}
	public String calculateAge(String dob) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	    Date date = formatter.parse(dob);
	    Instant instant = date.toInstant();
	    ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
	    LocalDate givenDate = zone.toLocalDate();
	      
		LocalDate dateDob = zone.toLocalDate();//LocalDate.parse((CharSequence) date );
		LocalDate dateNow = LocalDate.now();
		Period period = Period.between(dateDob, dateNow);
		Integer months = period.getYears()*12 + period.getMonths();
		return months.toString();
	}
	

}
