package neu.edu.csye6200.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import neu.edu.csye6200.DayCare;
import neu.edu.csye6200.DayCareSingleton;
import neu.edu.csye6200.models.StudentDetails;

import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainJFrame extends JFrame {

	private JPanel container;
	private JTextField textField;
	private JTextField textField_1;
	
	private DayCare daycare;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public MainJFrame() {
		daycare = new DayCare();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 1000);
		container = new JPanel();
		container.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(container);
		container.setLayout(new CardLayout(0, 0));
		
		JPanel homePanel = new JPanel();
		homePanel.setBackground(new Color(204, 255, 255));
		container.add("HomePanel", homePanel);
		homePanel.setLayout(null);
		
		JLabel titleLabel = new JLabel("Day Care");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		titleLabel.setBounds(6, 6, 978, 78);
		homePanel.add(titleLabel);
		
		JLabel useridLabel = new JLabel("User ID");
		useridLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		useridLabel.setBounds(400, 295, 72, 16);
		homePanel.add(useridLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		passwordLabel.setBounds(400, 333, 72, 16);
		homePanel.add(passwordLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(503, 328, 130, 26);
		homePanel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(503, 290, 130, 26);
		homePanel.add(textField_1);
		
//		for(StudentDetails sd: daycare.getPersonDir().getStuDir().getStudentList()) {
//			System.out.println(sd.getStudent().getFirstName());
//		}
		
		JButton loginBtn = new JButton("Login");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout layout=(CardLayout)container.getLayout();
				DashBoardJPanel dashBoardJPanel = new DashBoardJPanel(container, daycare);
				container.add("dashBoardJPanel", dashBoardJPanel);
				layout.next(container);
			}
		});
		loginBtn.setBackground(new Color(102, 0, 51));
		loginBtn.setBounds(450, 405, 117, 29);
		homePanel.add(loginBtn);
	}

}
