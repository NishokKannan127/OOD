package neu.edu.csye6200;

import javax.swing.JFrame;

import neu.edu.csye6200.models.AbstractPersonFactory;
import neu.edu.csye6200.models.StudentFactory;
import neu.edu.csye6200.models.TeacherFactory;
import neu.edu.csye6200.ui.MainJFrame;

public class Demo{
	public static void demo()
	{
<<<<<<< HEAD
		DayCare dc = new DayCare();
		dc.getInstance();
		System.out.print("s");
	}	
=======
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	JFrame mainframe = new MainJFrame();
        		mainframe.setSize(1000, 1000);
        		mainframe.setVisible(true);
            }
        });
		System.out.println("afaf");
	}
	
>>>>>>> 64c4698896f2d124fa5890fd18cdf7c92c1bf0be
	

}
