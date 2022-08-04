package neu.edu.csye6200.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EnrollTeacher extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the frame.
	 */
	public EnrollTeacher() {
		getContentPane().setBackground(new Color(204, 255, 255));
		getContentPane().setLayout(null);
		
		JButton enrollBtn = new JButton("Enroll");
		enrollBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		enrollBtn.setBounds(209, 299, 117, 29);
		enrollBtn.setBackground(new Color(102, 0, 51));
		getContentPane().add(enrollBtn);
		
		JLabel firstNameLabel = new JLabel("First Name");
		firstNameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		firstNameLabel.setBounds(159, 112, 72, 16);
		getContentPane().add(firstNameLabel);
		
		JLabel lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lastNameLabel.setBounds(159, 150, 72, 16);
		getContentPane().add(lastNameLabel);
		
		JLabel titleLabel = new JLabel("Enroll Teacher");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		titleLabel.setBounds(6, 23, 553, 36);
		getContentPane().add(titleLabel);
		
		textField = new JTextField();
		textField.setBounds(262, 107, 130, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(262, 145, 130, 26);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel addressLabel = new JLabel("Address");
		addressLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		addressLabel.setBounds(159, 190, 72, 16);
		getContentPane().add(addressLabel);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(262, 189, 130, 26);
		getContentPane().add(textField_2);
		
		JLabel dojLabel = new JLabel("Date of Joining");
		dojLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		dojLabel.setBounds(159, 231, 72, 16);
		getContentPane().add(dojLabel);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(262, 230, 130, 26);
		getContentPane().add(textField_3);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 410);
	}
}
