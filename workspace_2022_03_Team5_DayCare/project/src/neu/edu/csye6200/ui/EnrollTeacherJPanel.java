package neu.edu.csye6200.ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import neu.edu.csye6200.DayCare;
import neu.edu.csye6200.models.Employee;
import neu.edu.csye6200.models.FileUtil;
import neu.edu.csye6200.models.Person;
import neu.edu.csye6200.models.StudentDetails;
import neu.edu.csye6200.models.StudentFactory;
import neu.edu.csye6200.models.Teacher;
import neu.edu.csye6200.models.TeacherFactory;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class EnrollTeacherJPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private JPanel container;
	private DayCare dayCare;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private TeacherFactory tFactory;
	
	private Employee employee;
	
	String fName;
	String lName;
	String address;
	String doj;
	
	public EnrollTeacherJPanel(JPanel container, DayCare dayCare) {
		setBackground(new Color(204, 255, 255));
		this.container = container;
		this.dayCare=dayCare;
		this.tFactory=(TeacherFactory) dayCare.gettFactory();
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
		
		JLabel lblEnroll = new JLabel("Enroll Teacher");
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
		
		JLabel dojLabel = new JLabel("Date of Joining");
		dojLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		dojLabel.setBounds(260, 327, 117, 16);
		add(dojLabel);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(437, 326, 130, 26);
		add(textField_3);
		
		JButton enrollBtn = new JButton("Enroll");
		enrollBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fName=textField.getText();
				lName=textField_1.getText();
				address=textField_2.getText();
				doj=textField_3.getText();
				Integer hasError=0;
				try {
					hasError=loginAuthenticate();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					hasError=1;
				}
				
				
				if(hasError==0) {
					StringBuilder st = new StringBuilder("");
					int min = 100000000;
				    int max = 999999999;			      
				    Integer random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
					st.append(random_int.toString());
					st.append(",");
					st.append(fName);
					st.append(",");
					st.append(lName);
					st.append(",");
					st.append(doj);
					st.append(",");
					st.append(address);
					
					Teacher pObj = (Teacher)tFactory.createObject(st.toString());
					employee = new Employee(pObj);//new Employee(pObj, null);
					dayCare.getPersonDir().addEmployee(employee);// addStudentDet(new StudentDetails(pObj));
					FileUtil.writeItems(st.toString(), "src/neu/edu/csye6200/csv/EmployeeRoll.txt");
					readTeacher(employee, e);
//					CardLayout layout=(CardLayout)container.getLayout();
//					EnrollJPanel enrollJPanel = new EnrollJPanel(container);
//					container.add("EnrollJPanel", enrollJPanel);
//					layout.next(container);
				}
				
			}
		});
		enrollBtn.setBackground(new Color(102, 0, 51));
		enrollBtn.setBounds(450, 519, 117, 29);
		add(enrollBtn);

		
		
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
	}
	public Integer loginAuthenticate() throws ParseException {
		Integer hasError=0;
		
	      SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	      
	      String formattedDate="";
	      try {
	    	  Date x = sdf.parse(doj);
	      formattedDate = sdf.format(x);
	      }
	      catch(Exception e) {
	    	  //JOptionPane.showMessageDialog(this,"Enter correct date");
	    	  hasError=1;
	      }
	      if (formattedDate.equals(doj)) {
	          System.out.println("valid date");
	      } else {
	    	  JOptionPane.showMessageDialog(this,"Enter correct date");
	    	  hasError=1;
	      }
	      
	      if(fName.length()==0) {
	    	  JOptionPane.showMessageDialog(this,"Enter first name");
	    	  hasError=1;
	      }
	      if(lName.length()==0) {
	    	  JOptionPane.showMessageDialog(this,"Enter last name");
	    	  hasError=1;
	      }
	      if(address.length()==0) {
	    	  JOptionPane.showMessageDialog(this,"Enter address");
	    	  hasError=1;
	      }
	      return hasError;
	}
	public void readTeacher(Employee employee, java.awt.event.ActionEvent evt) {
		CardLayout layout=(CardLayout)container.getLayout();
		EnrollTeacherJPanelDisplay teacherJPanelDisp = new EnrollTeacherJPanelDisplay(container, dayCare, employee, true);
		container.add("TeacherJPanelDisp", teacherJPanelDisp);
		layout.next(container);
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
