package neu.edu.csye6200.ui;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import neu.edu.csye6200.DayCare;
import neu.edu.csye6200.ui.student.StudentJPanel;

public class DashBoardJPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	JPanel container;
	DayCare daycare;

	public DashBoardJPanel(JPanel container, DayCare daycare) {
		setBackground(new Color(204, 255, 255));
		this.container = container;
		this.daycare = daycare;
		this.setBounds(0, 0, 990, 990);
		setLayout(null);

		JButton btnNewButton = new JButton("Enroll");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout layout=(CardLayout)container.getLayout();
				EnrollJPanel enrollJPanel = new EnrollJPanel(container, daycare);
				container.add("EnrollJPanel", enrollJPanel);
				layout.next(container);
			}
		});
		btnNewButton.setBounds(243, 243, 169, 70);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Sign out");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backJButtonActionPerformed(e);

			}
		});
		btnNewButton_1.setBounds(830, 108, 117, 29);
		add(btnNewButton_1);
		
		JLabel titleLabel = new JLabel("Day Care");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		titleLabel.setBounds(6, 6, 978, 78);
		add(titleLabel);
		
		JButton btnTeachers = new JButton("Teachers");
		btnTeachers.setBounds(462, 243, 169, 70);
		add(btnTeachers);
		
		JButton btnStudents = new JButton("Students");
		btnStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentJPanel(e);
			}
		});
		btnStudents.setBounds(243, 349, 169, 70);
		add(btnStudents);
		
		JButton btnVaccination = new JButton("Vaccination");
		btnVaccination.setBounds(462, 349, 169, 70);
		add(btnVaccination);

	}
	// signout code
	private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {
		Component[] componentArray = container.getComponents();
		Component component = componentArray[0];
		container.removeAll();
		container.add(component);
		CardLayout layout = (CardLayout) container.getLayout();
		layout.first(container);
	}
	
	private void studentJPanel(java.awt.event.ActionEvent evt) {
		CardLayout layout=(CardLayout)container.getLayout();
		StudentJPanel studentJPanel = new StudentJPanel(container, daycare);
		container.add("StudentJPanel", studentJPanel);
		layout.next(container);
	}

}
