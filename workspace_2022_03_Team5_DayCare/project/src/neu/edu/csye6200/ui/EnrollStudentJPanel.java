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
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class EnrollStudentJPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private JPanel container;
	private DayCare daycare;
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
	StudentFactory sFactory;
	
	public EnrollStudentJPanel(JPanel container, DayCare daycare) {
		setBackground(new Color(204, 255, 255));
		this.container = container;
		this.daycare=daycare;
		this.setBounds(0, 0, 990, 990);
		this.sFactory=(StudentFactory) daycare.getsFactory();
		setLayout(null);
		
		JButton backButton = new JButton("<< back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backJButtonActionPerformed(e);
			}
		});
		backButton.setBounds(58, 98, 117, 29);
		add(backButton);
		
		JLabel lblEnroll = new JLabel("Enroll Student");
		lblEnroll.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnroll.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblEnroll.setBounds(6, 6, 978, 78);
		add(lblEnroll);
		
		JLabel firstNameLabel = new JLabel("First Name");
		firstNameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		firstNameLabel.setBounds(305, 160, 72, 16);
		add(firstNameLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(437, 159, 130, 26);
		add(textField);
		
		JLabel lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lastNameLabel.setBounds(305, 215, 72, 16);
		add(lastNameLabel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(437, 214, 130, 26);
		add(textField_1);
		
		JLabel addressLabel = new JLabel("Address");
		addressLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		addressLabel.setBounds(305, 270, 72, 16);
		add(addressLabel);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(437, 269, 130, 26);
		add(textField_2);
		
		JLabel parentNameLabel = new JLabel("Parent Name");
		parentNameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		parentNameLabel.setBounds(305, 327, 72, 16);
		add(parentNameLabel);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(437, 326, 130, 26);
		add(textField_3);
		
		JLabel dobLabel = new JLabel("Date of Birth");
		dobLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		dobLabel.setBounds(305, 381, 72, 16);
		add(dobLabel);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(437, 380, 130, 26);
		add(textField_4);
		
		JLabel ageLabel = new JLabel("Age");
		ageLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		ageLabel.setBounds(305, 444, 72, 16);
		add(ageLabel);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(437, 443, 130, 26);
		add(textField_5);
		
		JButton enrollBtn = new JButton("Enroll");
		enrollBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fName=textField.getText();
				lName=textField_1.getText();
				address=textField_2.getText();
				parentName=textField_3.getText();
				dob=textField_4.getText();
				age=textField_5.getText();
				
				StringBuilder st = new StringBuilder("");
				st.append(",");
				st.append(fName);
				st.append(",");
				st.append(lName);
				st.append(",");
				st.append(dob);
				st.append(",");
				st.append(parentName);
				st.append(",");
				st.append(address);
				
				Person pObj = sFactory.createObject(st.toString());
				StudentDetails s = new StudentDetails(pObj);
				daycare.getPersonDir().addStudentDet(s);
				FileUtil.writeItems(st.toString(), "src/neu/edu/csye6200/csv/EnrollmentRoster.txt");
				readStudent(s, e);
//				CardLayout layout=(CardLayout)container.getLayout();
//				StudentJPanel studentJPanel = new StudentJPanel(container, daycare);
//				container.add("StudentJPanel", studentJPanel);
//				layout.next(container);
			}
		});
		enrollBtn.setBackground(new Color(102, 0, 51));
		enrollBtn.setBounds(450, 519, 117, 29);
		add(enrollBtn);
	}
	public void readStudent(StudentDetails st, java.awt.event.ActionEvent evt) {
		CardLayout layout=(CardLayout)container.getLayout();
		EnrollStudentJPanelDisplay studentJPanelDisp = new EnrollStudentJPanelDisplay(container, daycare, st);
		container.add("StudentJPanelDisp", studentJPanelDisp);
		layout.next(container);
	}
	public void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {
		container.remove(this);
      Component[] componentArray = container.getComponents();
      Component component = componentArray[componentArray.length - 1];
      //DashBoardJPanel dashBoardJPanel = (DashBoardJPanel) component;

      CardLayout layout = (CardLayout) container.getLayout();
      layout.previous(container);
	}
}