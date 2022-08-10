package neu.edu.csye6200.ui.teacher;

import neu.edu.csye6200.models.Employee;
import neu.edu.csye6200.models.StudentDetails;
import neu.edu.csye6200.ui.EnrollStudentJPanel;
import neu.edu.csye6200.ui.EnrollStudentJPanelDisplay;
import neu.edu.csye6200.ui.EnrollTeacherJPanelDisplay;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTable;
import neu.edu.csye6200.DayCare;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TeacherJPanel extends JPanel {
	private JPanel container;
	private DayCare daycare;
	private JTable table;

	/**
	 * Create the panel.
	 */
	
	public TeacherJPanel(JPanel container, DayCare daycare) {
		setBackground(new Color(204, 255, 255));
		this.container = container;
		this.daycare = daycare;
		this.setBounds(0, 0, 990, 990);
		setLayout(null);
		
		table = new JTable();
		
		table.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		table.setForeground(Color.WHITE);

		table.setBackground(Color.BLACK);
		table.setBounds(317, 180, 650, 16);
		table.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
		table.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null }},
				new String[] { "ID", "First Name", "Last Name"}));
		add(table);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		lblNewLabel.setBounds(417, 148, 92, 32);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("FirstName");
		lblNewLabel_1.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		lblNewLabel_1.setBounds(535, 154, 79, 21);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		lblNewLabel_2.setBounds(650, 155, 76, 14);
		add(lblNewLabel_2);
		
		JButton btnReview = new JButton("Review");
		btnReview.setEnabled(true);
		JButton btnNewButton = new JButton("View");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewTeacher(e);//, btnReview);
			}
		});
		btnNewButton.setBounds(116, 203, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Edit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(116, 284, 89, 23);
		add(btnNewButton_1);
		
		
		btnReview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRowIndex = table.getSelectedRow();
				if(selectedRowIndex<0) {
					JOptionPane.showMessageDialog(container,  "Please select an Employee to Review", "Please select a row to View", selectedRowIndex);
		            return;
				}
				//btnReview.setEnabled(true);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				Employee ed = (Employee) model.getValueAt(selectedRowIndex, 0);
				
				CardLayout layout=(CardLayout)container.getLayout();
				ReviewJPanel reviewJPanel = new ReviewJPanel(container, daycare, ed);
				container.add("ReviewJPanel", reviewJPanel);
				layout.next(container);
			}
		});
		btnReview.setBounds(481, 436, 89, 23);
		add(btnReview);
		populateTable();
	}
		public void populateTable()
		{
			DefaultTableModel model= (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			int i = 16;
			table.setBounds(417, 180, 348, i);
			for(Employee e: daycare.getPersonDir().getEmpDir().getEmployeeList()) {
				Object[] row = new Object[3];
				row[0]=e;
				row[1]= e.getEmployee().getFirstName();
				System.out.println(e.getEmployee().getFirstName());
				row[2]= e.getEmployee().getLastName();
				model.addRow(row);
				table.setBounds(317, 180, 650, i);
				i += 16;
				
			
			}
			
			
			
		}
		public void viewTeacher(ActionEvent e){//, JButton btnReview) {
			//System.out.println("im here");
			int selectedRowIndex = table.getSelectedRow();
			if(selectedRowIndex<0) {
				JOptionPane.showMessageDialog(this, "Please select a row to View");
	            return;
			}
			//btnReview.setEnabled(true);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			Employee ed = (Employee) model.getValueAt(selectedRowIndex, 0);
			
			CardLayout layout=(CardLayout)container.getLayout();
			EnrollTeacherJPanelDisplay enrollTeacherJPanelDisplay = new EnrollTeacherJPanelDisplay(container, daycare, ed, false);
			container.add("EnrollTeacherJPanelDisplay", enrollTeacherJPanelDisplay);
			layout.next(container);
		}
}













































































