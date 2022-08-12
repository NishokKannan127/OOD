package neu.edu.csye6200.ui.student;

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
import neu.edu.csye6200.models.FileUtil;
import neu.edu.csye6200.models.Person;
import neu.edu.csye6200.models.Student;
import neu.edu.csye6200.models.StudentDetails;
import neu.edu.csye6200.models.StudentFactory;
import neu.edu.csye6200.ui.EnrollStudentJPanelDisplay;

import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class StudentEditJPanel extends JPanel {

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
	private JTextField textField_7;

	String fName;
	String lName;
	String address;
	String parentName;
	String dob;
	String age;
	String parentPhNo;
	String email;
	StudentFactory sFactory;
	private JTextField textField_6;
	private JTextField textField_8;
	private StudentDetails sd;
	

	public StudentEditJPanel(JPanel container, DayCare daycare, StudentDetails sd) {
		setBackground(new Color(204, 255, 255));
		this.container = container;
		this.daycare=daycare;
		this.setBounds(0, 0, 990, 990);
		this.sFactory=(StudentFactory) daycare.getsFactory();
		setLayout(null);
		this.sd = sd;
		Student st = (Student) sd.getStudent();

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
		textField.setText(st.getFirstName());
		textField.setColumns(10);
		textField.setBounds(490, 156, 130, 26);
		add(textField);

		JLabel lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lastNameLabel.setBounds(305, 215, 72, 16);
		add(lastNameLabel);

		textField_1 = new JTextField();
		textField_1.setText(st.getLastName());
		textField_1.setColumns(10);
		textField_1.setBounds(490, 211, 130, 26);
		add(textField_1);

		JLabel addressLabel = new JLabel("Address");
		
		addressLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		addressLabel.setBounds(305, 270, 72, 16);
		add(addressLabel);

		textField_2 = new JTextField();
		textField_2.setText(st.getAddress());
		textField_2.setColumns(10);
		textField_2.setBounds(490, 266, 130, 26);
		add(textField_2);

		JLabel parentNameLabel = new JLabel("Parent Name");
		parentNameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		parentNameLabel.setBounds(260, 327, 117, 16);
		add(parentNameLabel);

		textField_3 = new JTextField();
		textField_3.setText(st.getParentName());
		textField_3.setColumns(10);
		textField_3.setBounds(490, 323, 130, 26);
		add(textField_3);

		JLabel dobLabel = new JLabel("Date of Birth");
		dobLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		dobLabel.setBounds(305, 381, 72, 16);
		add(dobLabel);

		textField_4 = new JTextField();
		textField_4.setText(st.getDob());
		textField_4.setColumns(10);
		textField_4.setBounds(490, 377, 130, 26);
		add(textField_4);

		JLabel ageLabel = new JLabel("Age");
		ageLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		ageLabel.setBounds(305, 444, 72, 16);
		add(ageLabel);

		textField_5 = new JTextField();
		try {
			textField_5.setText(st.getAge());
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		textField_5.setEnabled(false);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(490, 440, 130, 26);
		add(textField_5);

		JButton modifyBtn = new JButton("Modify");
		modifyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				fName=textField.getText();
				lName=textField_1.getText();
				address=textField_2.getText();
				parentName=textField_3.getText();
				dob=textField_4.getText();
				parentPhNo=textField_6.getText();
				email=textField_8.getText();
				Integer hasError=0;
				try {
					hasError=loginAuthenticate();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					hasError=1;
				}
				try {
					age=calculateAge(dob);
					textField_5.setText(age);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					hasError=1;
				}//textField_5.getText();
				StringBuilder sb = new StringBuilder("");

				age=textField_5.getText();		


				if(hasError==0) {
					
					sb.append(st.getId());
					sb.append(",");
					sb.append(fName);
					sb.append(",");
					sb.append(lName);
					sb.append(",");
					sb.append(dob);
					sb.append(",");
					sb.append(parentName);
					sb.append(",");
					sb.append(address);
					sb.append(",");
					sb.append(parentPhNo);
					sb.append(",");
					sb.append(email);
					
					String line;
					String errorCheck="";
					int i=0,j=0,k=0;
					List<String> enrollmentContent = new ArrayList<String>();
					List<String> enrollmentDel = new ArrayList<>();
					try {
						enrollmentContent= FileUtil.readItems("src/neu/edu/csye6200/csv/EnrollmentRoster.txt");
						for(String content:enrollmentContent) {
							String[] params = content.split(",");
							System.out.println("Params "+params[0]);
							System.out.println("Val "+st.getId());
							if(!params[0].equals(String.valueOf(st.getId()))) {
								enrollmentDel.add(content);
							}
						}
						FileUtil.deleteFileItems("src/neu/edu/csye6200/csv/EnrollmentRoster.txt");
						
						for(String content:enrollmentDel) {
							FileUtil.writeItems(content, "src/neu/edu/csye6200/csv/EnrollmentRoster.txt");
						}
					}
					catch(Exception ex) {
						errorCheck = ex.toString()+" "+"unable to find contents";
					}
					
					boolean initAgain= false;
					try {
						if(st.getAge() != age) {
							initAgain=true;
						}
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					Person pObj = sFactory.createObject(sb.toString());
					sd.setStudent(pObj);
					
					
					
					
					FileUtil.writeItems(sb.toString(), "src/neu/edu/csye6200/csv/EnrollmentRoster.txt");
					System.out.println(sb);
					if(initAgain == true) {
						daycare.initAgain();
						daycare.initializeStudents();
					}
					readStudent(sd, e);
					
					
					//					CardLayout layout=(CardLayout)container.getLayout();
					//					StudentJPanel studentJPanel = new StudentJPanel(container, daycare);
					//					container.add("StudentJPanel", studentJPanel);
					//					layout.next(container);
					
				}


			}
		});
		modifyBtn.setBackground(new Color(102, 0, 51));
		modifyBtn.setBounds(453, 636, 117, 29);
		add(modifyBtn);

		JLabel lblParentPhoneNo = new JLabel("Parent Phone No");
		lblParentPhoneNo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblParentPhoneNo.setBounds(104, 504, 273, 16);
		add(lblParentPhoneNo);

		textField_6 = new JTextField();
		textField_6.setText(st.getPhoneNumberParent());
		textField_6.setColumns(10);
		textField_6.setBounds(490, 503, 130, 26);
		add(textField_6);
		
		JLabel lblEmailAddress = new JLabel("Email Address");
		lblEmailAddress.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmailAddress.setBounds(104, 557, 273, 16);
		add(lblEmailAddress);
		
		textField_8 = new JTextField();
		textField_8.setText(st.getEmailAddress());
		textField_8.setColumns(10);
		textField_8.setBounds(490, 556, 130, 26);
		add(textField_8);
	}
	public Integer loginAuthenticate() throws ParseException {
		Integer hasError=0;
		Pattern pattern = Pattern.compile("\\d{10}");
		Matcher matcher = pattern.matcher(parentPhNo);

		if (matcher.matches()) {
			System.out.println("Phone Number Valid");
		} else {
			System.out.println("Phone Number must be in the form XXX-XXXXXXX");
			JOptionPane.showMessageDialog(this,"Enter correct phone number");
			hasError=1;
		}

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		String formattedDate="";
		try {
			Date x = sdf.parse(dob);
			formattedDate = sdf.format(x);
		}
		catch(Exception e) {
			//JOptionPane.showMessageDialog(this,"Enter correct date");
			hasError=1;
		}
		if (formattedDate.equals(dob)) {
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
		if(parentName.length()==0) {
			JOptionPane.showMessageDialog(this,"Enter parent name");
			hasError=1;
		}
		if(email.length()==0) {
			JOptionPane.showMessageDialog(this,"Enter email");
			hasError=1;
		}
		System.out.print(fName);
		//	      fName=textField.getText();
		//			lName=textField_1.getText();
		//			address=textField_2.getText();
		//			parentName=textField_3.getText();
		//			dob=textField_4.getText();
		//			parentPhNo=textField_6.getText();
		return hasError;
	}
	public String calculateAge(String dob) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date date = formatter.parse(dob);
		Instant instant = date.toInstant();
		ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
		LocalDate givenDate = zone.toLocalDate();

		LocalDate dateDob = zone.toLocalDate();//LocalDate.parse((CharSequence) date );
		LocalDate dateNow = LocalDate.now();
		Period period = Period.between(dateDob, dateNow);
		Integer months = period.getYears()*12 + period.getMonths();
		return months.toString();
	}
	public void readStudent(StudentDetails st, java.awt.event.ActionEvent evt) {
		CardLayout layout=(CardLayout)container.getLayout();
		EnrollStudentJPanelDisplay studentJPanelDisp = new EnrollStudentJPanelDisplay(container, daycare, st, true);
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
