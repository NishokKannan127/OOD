package neu.edu.csye6200;

import javax.swing.JFrame;

import neu.edu.csye6200.models.AbstractPersonFactory;
import neu.edu.csye6200.models.StudentFactory;
import neu.edu.csye6200.models.TeacherFactory;
import neu.edu.csye6200.ui.MainJFrame;

public class Demo{
	public static void demo()
	{
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	JFrame mainframe = new MainJFrame();
        		mainframe.setSize(1000, 1000);
        		mainframe.setVisible(true);
            }
        });
		System.out.println("afaf");
	}
	
	

}
