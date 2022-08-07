package neu.edu.csye6200.models;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDirectory {
	List<Employee> employeeList;
	public EmployeeDirectory() {
		employeeList = new ArrayList<Employee>();
	}
	public void addEmployee(Employee pers) {
		// TODO Auto-generated method stub
		Employee stu = pers;
		employeeList.add(stu);
	}
	public List<Employee> getEmployeeList()
	{
		return employeeList;
	}
}
