package neu.edu.csye6200.ui.teacher;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;

import neu.edu.csye6200.DayCare;
import neu.edu.csye6200.models.StudentDetails;
import neu.edu.csye6200.ui.DashBoardJPanel;
import neu.edu.csye6200.ui.EnrollStudentJPanelDisplay;
import neu.edu.csye6200.models.Classroom;
import neu.edu.csye6200.models.Employee;
import neu.edu.csye6200.models.Group;
import neu.edu.csye6200.models.Review;
import neu.edu.csye6200.models.Student;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class ReviewJPanel extends JPanel {

	
	private Integer rating;
	private LocalDate dateOfReview;
	private LocalDate nextReviewDate;
	private String description;
	private Employee employee;
	
	private JPanel container;
	private DayCare daycare;
	private JTable table;	
	
	private JTextField textField;
	private JTextField textField_2;
	private JTextField sliderVal;

	public ReviewJPanel(JPanel container, DayCare daycare, Employee employee) {
		setBackground(new Color(204, 255, 255));
		this.container = container;
		this.daycare = daycare;
		this.employee=employee;
		this.setBounds(0, 0, 990, 990);
		setLayout(null);

		table = new JTable();
		table.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		table.setForeground(Color.WHITE);

		table.setBackground(Color.BLACK);
		table.setBounds(317, 220, 650, 16);

		table.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Date of Review", "Rating", "Description"
			}
		));

		JButton backButton = new JButton("<< back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backJButtonActionPerformed(e);
			}
		});
		backButton.setBounds(58, 98, 117, 29);
		add(backButton);

		JLabel lblStudent = new JLabel("Review");
		lblStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudent.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblStudent.setBounds(6, 6, 978, 78);
		add(lblStudent);

		

		add(table);

		JLabel lblNewLabel = new JLabel("Rating");
		lblNewLabel.setBounds(596, 139, 90, 16);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Description");
		lblNewLabel_1.setBounds(851, 139, 83, 16);
		add(lblNewLabel_1);
		
		JLabel lblId = new JLabel("Date of review");
		lblId.setBounds(317, 139, 90, 16);
		add(lblId);
		
		JButton btnReminderNextReview = new JButton("Reminder next review");
		
		//initially disable
		btnReminderNextReview.setEnabled(false);
		Review temp = employee.getLatestReview();
		if(temp!=null) {
			LocalDate d = temp.getNextReviewDate();
			//check if it should be enabled
			if(LocalDate.now()==d) {
				//enable button
				btnReminderNextReview.setEnabled(true);
			}
		}
		
		
				
		
		btnReminderNextReview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//popup on date of next review
				//LocalDate d = employee.getLatestReview().getNextReviewDate();
				//if(LocalDate.now()==d) {
					//btnReminderNextReview.setEnabled(true);
				Review temp = employee.getLatestReview();
				if(temp!=null) {
					LocalDate d = temp.getNextReviewDate();
					//check if it should be enabled
					if(LocalDate.now()==d) {
						//enable button
						btnReminderNextReview.setEnabled(true);
						JOptionPane.showMessageDialog(container,"Reminder, add review");
					}
				}
					
				//}
				//enable it once next year comes
			}
		});
		btnReminderNextReview.setBounds(736, 620, 198, 29);
		add(btnReminderNextReview);
		
		JLabel lblDateOfReview = new JLabel("Date of review");
		lblDateOfReview.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDateOfReview.setBounds(317, 450, 72, 16);
		add(lblDateOfReview);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setEnabled(false);
		textField.setColumns(10);
		textField.setBounds(449, 449, 130, 26);
		add(textField);
		
		JLabel lblRating = new JLabel("Rating");
		lblRating.setHorizontalAlignment(SwingConstants.TRAILING);
		lblRating.setBounds(317, 509, 72, 16);
		add(lblRating);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDescription.setBounds(317, 561, 72, 16);
		add(lblDescription);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(449, 560, 130, 26);
		add(textField_2);
		
		JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				sliderVal.setText(String.valueOf(slider.getValue()));
			}
		});
		slider.setPaintLabels(true);
		
		
		slider.setBounds(449, 509, 130, 22);
		add(slider);
//		slider.setMaximum(5);
//		slider.setMinimum(0);
//		slider.setValue(0);
		
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rating=slider.getValue();
				description=textField_2.getText();
				
				Review rev = new Review(rating, description);
				employee.addReview(rev);
				populateTable();
			}
		});
		btnSubmit.setBounds(446, 620, 198, 29);
		add(btnSubmit);
		
		sliderVal = new JTextField();
		sliderVal.setColumns(10);
		sliderVal.setBounds(596, 508, 130, 26);
		add(sliderVal);
		
		
		
		populateTable();
	}
	
	public void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {
		container.remove(this);
		Component[] componentArray = container.getComponents();
		Component component = componentArray[componentArray.length - 1];
		DashBoardJPanel dashBoardJPanel = (DashBoardJPanel) component;
		
		CardLayout layout = (CardLayout) container.getLayout();
		layout.previous(container);
	}

	public void populateTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		int i = 16;
		table.setBounds(317, 220, 650, i);
		Employee emp = this.employee;

		for (Review r : emp.getAllReviews()) {
			Object[] row = new Object[3];
			
			if(r!=null) {
				row[0]=r.getDateOfReview();
				row[1]= r.getRating();
				row[2]= r.getDescription();
				model.addRow(row);
			}
			
			table.setBounds(317, 180, 650, i);
			i += 16;
		}
	}
}
