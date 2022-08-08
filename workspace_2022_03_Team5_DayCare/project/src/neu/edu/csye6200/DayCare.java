package neu.edu.csye6200;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import neu.edu.csye6200.models.AbstractPersonFactory;
import neu.edu.csye6200.models.Classroom;
import neu.edu.csye6200.models.ClassroomDirectory;
import neu.edu.csye6200.models.Employee;
import neu.edu.csye6200.models.FileUtil;
import neu.edu.csye6200.models.Person;
import neu.edu.csye6200.models.PersonDirectory;
import neu.edu.csye6200.models.Student;
import neu.edu.csye6200.models.StudentDetails;
import neu.edu.csye6200.models.StudentFactory;
import neu.edu.csye6200.models.Teacher;
import neu.edu.csye6200.models.TeacherFactory;
import neu.edu.csye6200.models.GroupRule;
import neu.edu.csye6200.models.ImmunizationRule;

public class DayCare {
	private PersonDirectory personDir;
	private ClassroomDirectory classroomDir;
	private AbstractPersonFactory tFactory;//=new TeacherFactory();
	private AbstractPersonFactory sFactory;//=new StudentFactory();
	private List<GroupRule> groupRuleList;
	private List<ImmunizationRule> immunizationRuleList;

	public DayCare() {
		personDir = new PersonDirectory();				;
		classroomDir = new ClassroomDirectory();
		tFactory=new TeacherFactory();
		sFactory=new StudentFactory();
		groupRuleList = new ArrayList<>();
		immunizationRuleList = new ArrayList<>();

		initializeRules();
		initializeImmunization();
		initializeEmployees();
		initializeStudents();



	}
	public int initializeStudents() {
		String line;
		String errorCheck="";
		int i=0,j=0,k=0;
		List<String> enrollmentContent = new ArrayList<String>();
		try {
			enrollmentContent= FileUtil.readItems("src/neu/edu/csye6200/csv/EnrollmentRoster.txt");
		}
		catch(Exception ex) {
			errorCheck = ex.toString()+" "+"unable to find contents";
		}
		while(j!=enrollmentContent.size())
		{
			Person obj= sFactory.createObject(enrollmentContent.get(j));
			StudentDetails st = new StudentDetails(obj);
			try {
				this.autoAssignStudent(st);
			} catch (NumberFormatException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//			if(j%3==0) {
			//				st.setGroupid("Group 1");
			//			}
			//			else if(j%3==1) {
			//				st.setGroupid("Group 2");
			//			}
			//			else {
			//				st.setGroupid("Group 3");
			//			}
			//			if((j%10)<5) {
			//				st.setClassid("Class 1");
			//			}
			//			else {
			//				st.setClassid("Class 2");
			//			}
			personDir.addStudentDet(st);
			j++;
		}
		if(errorCheck=="") {
			return 1; //successful
		}
		else {
			return 0;
		}
	}
	public int initializeEmployees() {
		String line;
		String errorCheck="";
		int i=0,j=0,k=0;
		List<String> employeeContent = new ArrayList<String>();
		try {
			employeeContent= FileUtil.readItems("src/neu/edu/csye6200/csv/EmployeeRoll.txt");
		}
		catch(Exception ex) {
			errorCheck = ex.toString()+" "+"unable to find contents";
		}
		while(j!=employeeContent.size()-1)
		{
			Person obj= tFactory.createObject(employeeContent.get(j));
			//Employee emp = (Employee)obj;
			personDir.addEmployee(new Employee((Teacher)obj, null));
			j++;
		}
		if(errorCheck=="") {
			return 1; //successful
		}
		else {
			return 0;
		}
	}

	public void initializeImmunization()
	{
		List<String> immunizationRules = new ArrayList<>();
		String errorCheck="";
		try {
			immunizationRules = FileUtil.readItems("src/neu/edu/csye6200/csv/ImmunizationCSV.txt");
		}
		catch(Exception ex)
		{
			errorCheck = ex.toString()+" "+"unable to find contents";
		}
		for(String dose: immunizationRules)
		{
			ImmunizationRule ir= new ImmunizationRule(dose);
			immunizationRuleList.add(ir);		
		}
	}

	public void initializeRules() {
		List<String> groupRules = new ArrayList<>();
		String errorCheck="";
		try {
			groupRules = FileUtil.readItems("src/neu/edu/csye6200/csv/GroupRulesCSV.txt");
		}
		catch(Exception ex) {
			errorCheck = ex.toString()+" "+"unable to find contents";
		}

		for(String rule: groupRules) {
			GroupRule gr = new GroupRule(rule);
			groupRuleList.add(gr);
		}
	}

	public void autoAssignStudent(StudentDetails sd) throws NumberFormatException, ParseException {
		GroupRule gr=null;
		Student st = (Student) sd.getStudent();
		for(GroupRule g:groupRuleList) {
			System.out.println(st.getAge());
			if(Integer.parseInt(st.getAge()) >=g.getAgeLower() && Integer.parseInt(st.getAge()) <=g.getAgeHigher()) {
				gr = g;
			}
		}
		boolean classfound = false;
		
		System.out.println(classroomDir.getClassRoomDir().size());

		for(Classroom cr:classroomDir.getClassRoomDir()) {
			if(cr.getGrouprule().equals(gr) && cr.isFull() == false) {
				classfound = true;
				cr.addStudent(sd, personDir.getEmpDir());
			}
		}
		
		if(classfound == false) {
			Classroom cr = new Classroom();
			cr.setGrouprule(gr);
			classroomDir.addClassroom(cr);
			cr.addStudent(sd, personDir.getEmpDir());
		}
		
		System.out.println(sd.getClassid());
	}

	public PersonDirectory getPersonDir() {
		return personDir;
	}

	public void setPersonDir(PersonDirectory personDir) {
		this.personDir = personDir;
	}
	public ClassroomDirectory getClassroomDir() {
		return classroomDir;
	}
	public void setClassroomDir(ClassroomDirectory classroomDir) {
		this.classroomDir = classroomDir;
	}
	public AbstractPersonFactory gettFactory() {
		return tFactory;
	}
	public void settFactory(AbstractPersonFactory tFactory) {
		this.tFactory = tFactory;
	}
	public AbstractPersonFactory getsFactory() {
		return sFactory;
	}
	public void setsFactory(AbstractPersonFactory sFactory) {
		this.sFactory = sFactory;
	}
	public DayCare getInstance() {
		return this;
	}

}