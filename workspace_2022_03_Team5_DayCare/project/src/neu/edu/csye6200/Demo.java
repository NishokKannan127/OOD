package neu.edu.csye6200;

import java.awt.EventQueue;

import javax.swing.JFrame;

import neu.edu.csye6200.models.AbstractPersonFactory;
import neu.edu.csye6200.models.StudentFactory;
import neu.edu.csye6200.models.TeacherFactory;
import neu.edu.csye6200.ui.MainJFrame;
import neu.edu.csye6200.ui.StartJFrame;

public class Demo{
	public static void demo()
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainJFrame frame = new MainJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



}
