package neu.edu.csye6200;

import java.util.ArrayList;
import java.util.List;

import neu.edu.csye6200.models.AbstractPersonFactory;
import neu.edu.csye6200.models.ClassroomDirectory;
import neu.edu.csye6200.models.FileUtil;
import neu.edu.csye6200.models.Person;
import neu.edu.csye6200.models.PersonDirectory;
import neu.edu.csye6200.models.StudentFactory;
import neu.edu.csye6200.models.TeacherFactory;

public class DayCare {
	PersonDirectory personDir;
	ClassroomDirectory classroomDir;
	AbstractPersonFactory tFactory;//=new TeacherFactory();
	AbstractPersonFactory sFactory;//=new StudentFactory();
	
	public DayCare() {
		personDir = new PersonDirectory();				;
		classroomDir = new ClassroomDirectory();
		tFactory=new TeacherFactory();
		sFactory=new StudentFactory();
	}
	public int initializeStudents() {
		String line;
		String errorCheck="";
		int i=0,j=0,k=0;
		List<String> enrollmentContent = new ArrayList<String>();
		try {
			enrollmentContent= FileUtil.readItems("src/edu/neu/csye6200/csv/EnrollmentRoster.txt");
		}
		catch(Exception ex) {
			errorCheck = ex.toString()+" "+"unable to find contents";
		}
		while(j!=enrollmentContent.size())
		{
			Person obj= sFactory.createObject(enrollmentContent.get(j));
			personDir.addStudent(obj);
			j++;
		}
		if(errorCheck=="") {
			return 1; //successful
		}
		else {
			return 0;
		}
	}
	public int initializeTeachers() {
		String line;
		String errorCheck="";
		int i=0,j=0,k=0;
		List<String> employeeContent = new ArrayList<String>();
		try {
			employeeContent= FileUtil.readItems("src/edu/neu/csye6200/csv/EmployeeRoster.txt");
		}
		catch(Exception ex) {
			errorCheck = ex.toString()+" "+"unable to find contents";
		}
		while(j!=employeeContent.size())
		{
			Person obj= sFactory.createObject(employeeContent.get(j));
			personDir.addTeacher(obj);
			j++;
		}
		if(errorCheck=="") {
			return 1; //successful
		}
		else {
			return 0;
		}
	}
	public void getInstance() {
//		In getInstance() check if we have our CSV files.
//		If not, return an empty instance. 
//		If we have these files, extract the data, and create students teachers etc with the methods sneha provides. 
//		Add all these objects in the directory objects we have in system
		int st;
		int teach;
		st=initializeStudents();
		teach=initializeTeachers();
	}
	
}
