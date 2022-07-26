package neu.edu.csye6200.models;

public class StudentFactory extends AbstractPersonFactory{
	public Person createObject(String line)
	{
		return new Student(line);
	}

}
