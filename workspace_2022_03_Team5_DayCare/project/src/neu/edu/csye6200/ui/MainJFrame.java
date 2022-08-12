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
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainJFrame extends JFrame {

	private JPanel container;
	private JTextField passwordText;
	private JTextField useridText;
	
	private String passwordReal;
	
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
		
		passwordReal = "";
		
		JPanel homePanel = new JPanel();
		homePanel.setBackground(new Color(153, 50, 204));
		container.add("HomePanel", homePanel);
		homePanel.setLayout(null);
		
		JLabel titleLabel = new JLabel("Day Care");
		titleLabel.setForeground(new Color(255, 255, 255));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 29));
		titleLabel.setBounds(6, 6, 978, 78);
		homePanel.add(titleLabel);
		
		JLabel useridLabel = new JLabel("User ID");
		useridLabel.setForeground(new Color(255, 255, 255));
		useridLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		useridLabel.setBounds(388, 470, 72, 16);
		homePanel.add(useridLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setForeground(new Color(255, 255, 255));
		passwordLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		passwordLabel.setBounds(400, 512, 72, 16);
		homePanel.add(passwordLabel);
		
		passwordText = new JTextField();
		passwordText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER) {
					loginAuthenticate();
				}
				if(e.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
					passwordReal = passwordReal.concat(String.valueOf(e.getKeyChar()));
					String stars = "";
					for(int i=0; i<passwordReal.length()-1; i++) {
						stars = stars.concat("*");
					}
					passwordText.setText(stars);
					
				}
				else {
					passwordReal = passwordReal.substring(0, passwordReal.length()-1);
				}
				System.out.println(passwordReal);
				
			}
		});
		passwordText.setColumns(10);
		passwordText.setBounds(514, 507, 130, 26);
		homePanel.add(passwordText);
		
		useridText = new JTextField();
		useridText.setColumns(10);
		useridText.setBounds(514, 465, 130, 26);
		homePanel.add(useridText);
		
//		for(StudentDetails sd: daycare.getPersonDir().getStuDir().getStudentList()) {
//			System.out.println(sd.getStudent().getFirstName());
//		}
		
		JButton loginBtn = new JButton("Login");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String userid = useridText.getText();
				String password = passwordReal;
				
				if(userid.equals("admin") && password.equals("admin") ) {
					CardLayout layout=(CardLayout)container.getLayout();
					DashBoardJPanel dashBoardJPanel = new DashBoardJPanel(container, daycare);
					container.add("dashBoardJPanel", dashBoardJPanel);
					layout.next(container);
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid credentials");
				}
				
				
			}
		});
		loginBtn.setBackground(new Color(102, 0, 51));
		loginBtn.setBounds(449, 578, 117, 48);
		homePanel.add(loginBtn);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(261, 77, 509, 318);
		homePanel.add(lblNewLabel);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/img12.jpeg"));
		lblNewLabel.setIcon(img);
	}
	
	public void loginAuthenticate() {
		String userid = useridText.getText();
		String password = passwordReal;
		
		if(userid.equals("admin") && password.equals("admin") ) {
			CardLayout layout=(CardLayout)container.getLayout();
			DashBoardJPanel dashBoardJPanel = new DashBoardJPanel(container, daycare);
			container.add("dashBoardJPanel", dashBoardJPanel);
			layout.next(container);
		}
		else {
			JOptionPane.showMessageDialog(null, "Invalid credentials");
		}
	}

}
