package neu.edu.csye6200.ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import neu.edu.csye6200.DayCare;
import neu.edu.csye6200.models.Employee;
import neu.edu.csye6200.models.FileUtil;
import neu.edu.csye6200.models.Person;
import neu.edu.csye6200.models.Student;
import neu.edu.csye6200.models.StudentDetails;
import neu.edu.csye6200.models.StudentFactory;
import neu.edu.csye6200.models.Teacher;
import neu.edu.csye6200.models.TeacherFactory;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class EnrollTeacherJPanelDisplay extends JPanel {

	/**
	 * Create the panel.
	 */
	private JPanel container;
	private DayCare dayCare;
	private Teacher teacher;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private TeacherFactory tFactory;
	
	String fName;
	String lName;
	String address;
	String doj;
	
	public EnrollTeacherJPanelDisplay(JPanel container, DayCare dayCare, Teacher teacher) {
		setBackground(new Color(204, 255, 255));
		this.container = container;
		this.dayCare=dayCare;
		this.teacher=teacher;
		this.setBounds(0, 0, 990, 990);
		setLayout(null);
		
		JButton backButton = new JButton("<< back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backJButtonActionPerformed(e);
			}
		});
		backButton.setBounds(58, 98, 117, 29);
		add(backButton);
		
		JLabel lblEnroll = new JLabel("Teacher enrolled Successfully");
		lblEnroll.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnroll.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblEnroll.setBounds(6, 6, 978, 78);
		add(lblEnroll);
		
		JLabel firstNameLabel = new JLabel("First Name");
		firstNameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		firstNameLabel.setBounds(305, 160, 72, 16);
		add(firstNameLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setEnabled(false);
		textField.setColumns(10);
		textField.setBounds(437, 159, 130, 26);
		add(textField);
		
		JLabel lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lastNameLabel.setBounds(305, 215, 72, 16);
		add(lastNameLabel);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(437, 214, 130, 26);
		add(textField_1);
		
		JLabel addressLabel = new JLabel("Address");
		addressLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		addressLabel.setBounds(305, 270, 72, 16);
		add(addressLabel);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBounds(437, 269, 130, 26);
		add(textField_2);
		
		JLabel dojLabel = new JLabel("Date of Joining");
		dojLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		dojLabel.setBounds(305, 327, 72, 16);
		add(dojLabel);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBounds(437, 326, 130, 26);
		add(textField_3);

		
		
//		JButton btnNewButton = new JButton("Enroll");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				CardLayout layout=(CardLayout)container.getLayout();
//				EnrollJPanel enrollJPanel = new EnrollJPanel(container);
//				container.add("EnrollJPanel", enrollJPanel);
//				layout.next(container);
//			}
//		});
//		btnNewButton.setBounds(243, 243, 169, 70);
//		add(btnNewButton);
		
		
		displayTeacher();
	}
	
	public void displayTeacher() {
		textField.setText(teacher.getFirstName());
		textField_1.setText(teacher.getLastName());
		textField_2.setText(teacher.getAddress());;
		textField_3.setText(teacher.getDoj());
	}
	
	public void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {
		container.remove(this);
      Component[] componentArray = container.getComponents();
      Component component = componentArray[componentArray.length - 1];
      DashBoardJPanel dashBoardJPanel = (DashBoardJPanel) component;

      CardLayout layout = (CardLayout) container.getLayout();
      layout.previous(container);
	}
}
