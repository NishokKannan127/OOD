package neu.edu.csye6200;

import neu.edu.csye6200.models.AbstractPersonFactory;
import neu.edu.csye6200.models.StudentFactory;
import neu.edu.csye6200.models.TeacherFactory;

public class Demo{
	public static void demo()
	{
		DayCare dc = new DayCare();
		dc.getInstance();
		System.out.print("s");
	}	
	

}
