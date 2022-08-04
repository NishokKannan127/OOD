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

public class EnrollStudent extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Create the frame.
	 */
	public EnrollStudent() {
		getContentPane().setBackground(new Color(204, 255, 255));
		getContentPane().setLayout(null);
		
		JButton enrollBtn = new JButton("Enroll");
		enrollBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		enrollBtn.setBounds(210, 334, 117, 29);
		enrollBtn.setBackground(new Color(102, 0, 51));
		getContentPane().add(enrollBtn);
		
		JLabel firstNameLabel = new JLabel("First Name");
		firstNameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		firstNameLabel.setBounds(159, 89, 72, 16);
		getContentPane().add(firstNameLabel);
		
		JLabel lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lastNameLabel.setBounds(159, 125, 72, 16);
		getContentPane().add(lastNameLabel);
		
		JLabel titleLabel = new JLabel("Enroll Student");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		titleLabel.setBounds(6, 23, 553, 36);
		getContentPane().add(titleLabel);
		
		textField = new JTextField();
		textField.setBounds(262, 85, 130, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(262, 121, 130, 26);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(262, 157, 130, 26);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(262, 193, 130, 26);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(262, 229, 130, 26);
		getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(262, 265, 130, 26);
		getContentPane().add(textField_5);
		
		JLabel addressLabel = new JLabel("Address");
		addressLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		addressLabel.setBounds(159, 163, 72, 16);
		getContentPane().add(addressLabel);
		
		JLabel parentNameLabel = new JLabel("Parent Name");
		parentNameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		parentNameLabel.setBounds(159, 199, 72, 16);
		getContentPane().add(parentNameLabel);
		
		JLabel dobLabel = new JLabel("Date of Birth");
		dobLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		dobLabel.setBounds(159, 235, 72, 16);
		getContentPane().add(dobLabel);
		
		JLabel ageLabel = new JLabel("Age");
		ageLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		ageLabel.setBounds(159, 271, 72, 16);
		getContentPane().add(ageLabel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 410);
	}
}
