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

public class StartJFrame extends JFrame {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the frame.
	 */
	public StartJFrame() {
		getContentPane().setBackground(new Color(204, 255, 255));
		getContentPane().setLayout(null);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		loginBtn.setBounds(209, 222, 117, 29);
		loginBtn.setBackground(new Color(102, 0, 51));
		getContentPane().add(loginBtn);
		
		JLabel useridLabel = new JLabel("User ID");
		useridLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		useridLabel.setBounds(159, 112, 72, 16);
		getContentPane().add(useridLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		passwordLabel.setBounds(159, 150, 72, 16);
		getContentPane().add(passwordLabel);
		
		JLabel titleLabel = new JLabel("Gautham's Day Care");
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 410);
	}
}
