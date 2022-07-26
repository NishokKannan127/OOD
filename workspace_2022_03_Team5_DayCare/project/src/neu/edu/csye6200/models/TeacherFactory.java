package neu.edu.csye6200.models;

public class TeacherFactory extends AbstractPersonFactory {
	public Person createObject(String line)
	{
		return new Teacher(line);
	}

}
