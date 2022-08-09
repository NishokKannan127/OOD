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
import neu.edu.csye6200.models.FileUtil;
import neu.edu.csye6200.models.Person;
import neu.edu.csye6200.models.Student;
import neu.edu.csye6200.models.StudentDetails;
import neu.edu.csye6200.models.StudentFactory;
import neu.edu.csye6200.ui.student.StudentJPanel;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class EnrollStudentJPanelDisplay extends JPanel {

	/**
	 * Create the panel.
	 */
	private JPanel container;
	private DayCare daycare;
	private StudentDetails st;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	String fName;
	String lName;
	String address;
	String parentName;
	String dob;
	String age;
	String parentPhoneNo;
	StudentFactory sFactory;
	private JTextField textField_6;
	
	public EnrollStudentJPanelDisplay(JPanel container, DayCare daycare, StudentDetails st, boolean isEnroll) {
		setBackground(new Color(204, 255, 255));
		this.container = container;
		this.daycare=daycare;
		this.st=st;
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
		
		JLabel lblEnroll = null;;
		
		if(isEnroll == true) {
			lblEnroll= new JLabel("Student enrolled succesfully");
		}
		else {
			lblEnroll= new JLabel("Student Details");
		}
		lblEnroll.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnroll.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblEnroll.setBounds(6, 6, 978, 78);
		add(lblEnroll);
		
		JLabel firstNameLabel = new JLabel("First Name");
		firstNameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		firstNameLabel.setBounds(247, 160, 130, 16);
		add(firstNameLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setEnabled(false);
		textField.setColumns(10);
		textField.setBounds(493, 156, 130, 26);
		add(textField);
		
		JLabel lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lastNameLabel.setBounds(265, 215, 112, 16);
		add(lastNameLabel);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(493, 211, 130, 26);
		add(textField_1);
		
		JLabel addressLabel = new JLabel("Address");
		addressLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		addressLabel.setBounds(265, 270, 112, 16);
		add(addressLabel);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBounds(493, 266, 130, 26);
		add(textField_2);
		
		JLabel parentNameLabel = new JLabel("Parent Name");
		parentNameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		parentNameLabel.setBounds(265, 327, 112, 16);
		add(parentNameLabel);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(493, 323, 130, 26);
		add(textField_3);
		
		JLabel dobLabel = new JLabel("Date of Birth");
		dobLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		dobLabel.setBounds(265, 381, 112, 16);
		add(dobLabel);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(493, 377, 130, 26);
		add(textField_4);
		
		JLabel ageLabel = new JLabel("Age");
		ageLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		ageLabel.setBounds(265, 444, 112, 16);
		add(ageLabel);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setEnabled(false);
		textField_5.setColumns(10);
		textField_5.setBounds(493, 440, 130, 26);
		add(textField_5);
		
		JButton btnGoToDashboard = new JButton("Go to Dashboard");
		btnGoToDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGoToDashboard.setBounds(58, 257, 117, 29);
		add(btnGoToDashboard);
		
		JButton btnImmunization = new JButton("Immunization");
		btnImmunization.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				immunizationButtonActionPerformed(st,e);
			}
		});
		btnImmunization.setBounds(318, 577, 117, 29);		
		add(btnImmunization);
		
		JLabel lblParentPhoneNo = new JLabel("Parent Phone No");
		lblParentPhoneNo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblParentPhoneNo.setBounds(197, 499, 180, 16);
		add(lblParentPhoneNo);
		
		textField_6 = new JTextField();
		textField_6.setText((String) null);
		textField_6.setEnabled(false);
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(493, 498, 130, 26);
		add(textField_6);
//		btnImmunization.setBounds(318, 529, 117, 29);
//		add(btnImmunization);


		
		
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
		
		displayStudent();
	}
	public void displayStudent() {
		textField.setText(st.getStudent().getFirstName());
		textField_1.setText(st.getStudent().getLastName());
		textField_2.setText(st.getStudent().getAddress());
		//st.getStudent().getgetParentName()
		textField_3.setText(((Student) st.getStudent()).getParentName() );
		textField_4.setText(((Student) st.getStudent()).getDob());
		try {
			textField_5.setText(((Student) st.getStudent()).getAge());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textField_6.setText(((Student)st.getStudent()).getPhoneNumberParent());
	}
	
	public void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {
		container.remove(this);
      Component[] componentArray = container.getComponents();
      Component component = componentArray[componentArray.length - 1];
      //DashBoardJPanel dashBoardJPanel = (DashBoardJPanel) component;

      CardLayout layout = (CardLayout) container.getLayout();
      layout.previous(container);
	}
	public void immunizationButtonActionPerformed(StudentDetails st, java.awt.event.ActionEvent evt) {
		System.out.println("hola");
		CardLayout layout=(CardLayout)container.getLayout();
		ImmunizationJPanel immunizationJPanel = new ImmunizationJPanel(container, daycare, st);
		container.add("StudentJPanelDisp", immunizationJPanel);
		layout.next(container);
	}
}
