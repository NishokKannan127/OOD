package neu.edu.csye6200.ui.student;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;

import neu.edu.csye6200.DayCare;
import neu.edu.csye6200.models.StudentDetails;
import neu.edu.csye6200.ui.DashBoardJPanel;
import neu.edu.csye6200.ui.EnrollStudentJPanelDisplay;
import neu.edu.csye6200.models.Classroom;
import neu.edu.csye6200.models.Group;
import neu.edu.csye6200.models.Student;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class StudentJPanel extends JPanel {

	private JPanel container;
	private DayCare daycare;
	private JTable table;

	JComboBox<String> classCombobox;
	JComboBox<String> groupCombobox;
	
	private HashMap<String, List<String>> classmap;

	public StudentJPanel(JPanel container, DayCare daycare) {
		
		classmap = new HashMap<>();
		
		
		
		setBackground(new Color(204, 255, 255));
		this.container = container;
		this.daycare = daycare;
		this.setBounds(0, 0, 990, 990);
		setLayout(null);

		table = new JTable();
		table.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		table.setForeground(Color.WHITE);

		table.setBackground(Color.BLACK);
		table.setBounds(317, 220, 650, 16);

		table.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
		table.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null }},
				new String[] { "ID", "First Name", "Last Name", "Date of Birth", "Address" }));

		JButton backButton = new JButton("<< back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backJButtonActionPerformed(e);
			}
		});
		backButton.setBounds(58, 98, 117, 29);
		add(backButton);

		JLabel lblStudent = new JLabel("Student");
		lblStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudent.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblStudent.setBounds(6, 6, 978, 78);
		add(lblStudent);

		

		add(table);

		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setBounds(446, 192, 90, 16);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setBounds(580, 192, 83, 16);
		add(lblNewLabel_1);

		classCombobox = new JComboBox<>();
		groupCombobox = new JComboBox<>();
		
		List<String> allclasses = new ArrayList<>();
		allclasses.add("All Groups");
		classmap.put("All Classes", allclasses);
		classCombobox.addItem("All Classes");
		for(Classroom cr:daycare.getClassroomDir().getClassRoomDir()) {
			classmap.put(cr.getClassroomname(), new ArrayList<>());
			classmap.get(cr.getClassroomname()).add("All Groups");
			groupCombobox.addItem("All Groups");
			classCombobox.addItem(cr.getClassroomname());
			for(Group g:cr.getGroupList()) {
				classmap.get(cr.getClassroomname()).add(g.getGroupName());
				groupCombobox.addItem(g.getGroupName());
			}
		}
		
		
//		classCombobox.addItem("All Classes");
//		classCombobox.addItem("Class 1");
//		classCombobox.addItem("Class 2");
		classCombobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				classComboboxChanged(e);
			}
		});
		classCombobox.setBounds(317, 153, 152, 27);
		add(classCombobox);

		
//		groupCombobox.addItem("All Groups");
		groupCombobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				groupComboboxChanged(e);
			}
		});
		groupCombobox.setBounds(504, 153, 137, 27);
		add(groupCombobox);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(317, 192, 90, 16);
		add(lblId);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setBounds(706, 192, 90, 16);
		add(lblDateOfBirth);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(834, 192, 90, 16);
		add(lblAddress);
		
		JButton editBtn = new JButton("View");
		editBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewStudent(e);
			}
		});
		
		editBtn.setBounds(95, 258, 117, 29);
		add(editBtn);
		
		JButton viewBtn = new JButton("Edit");
		viewBtn.setBounds(95, 317, 117, 29);
		add(viewBtn);
		
		JLabel lblNewLabel_2 = new JLabel("Select Class Room");
		lblNewLabel_2.setBounds(341, 124, 128, 16);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Select Group");
		lblNewLabel_3.setBounds(549, 124, 137, 16);
		add(lblNewLabel_3);
		
		populateTable();
	}
	
	public void viewStudent(ActionEvent e) {
		int selectedRowIndex = table.getSelectedRow();
		if(selectedRowIndex<0) {
			JOptionPane.showMessageDialog(this, "Please select a row to View");
            return;
		}
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		StudentDetails sd = (StudentDetails) model.getValueAt(selectedRowIndex, 0);
		
		CardLayout layout=(CardLayout)container.getLayout();
		EnrollStudentJPanelDisplay enrollStudentJPanelDisplay = new EnrollStudentJPanelDisplay(container, daycare, sd, false);
		container.add("EnrollStudentJPanelDisplay", enrollStudentJPanelDisplay);
		layout.next(container);
	}

	public void classComboboxChanged(ActionEvent e) {
		List<String> classlist = classmap.get((String)classCombobox.getSelectedItem());
		groupCombobox.removeAllItems();
		for(String g:classlist) {
			groupCombobox.addItem(g);
		}
		populateTable();
		
	}

	public void groupComboboxChanged(ActionEvent e) {
		if(groupCombobox.getSelectedItem() == null) {
			return;
		}
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

		for (StudentDetails sd : daycare.getPersonDir().getStuDir().getStudentList()) {
//            if ((sd.getGroupid().equals(groupCombobox.getSelectedItem()) && sd.getGroupid().equals(classCombobox.getSelectedItem())) ||
//            		(sd.getGroupid().equals("All Groups") && sd.getGroupid().equals("All Classes"))) {
//            }

			if (classCombobox.getSelectedItem().equals("All Classes")) {
				Object[] row = new Object[5];
				row[0] = sd;
				row[1] = sd.getStudent().getFirstName();
				row[2] = sd.getStudent().getLastName();
				row[3] = ((Student)sd.getStudent()).getDob();
				row[4] = ((Student)sd.getStudent()).getAddress();
				
				model.addRow(row);
				table.setBounds(317, 220, 650, i);
				i += 16;
			} else {
				String temp = (String) groupCombobox.getSelectedItem();
				if (sd.getClassid().equals(classCombobox.getSelectedItem()) && temp.equals("All Groups")) {
					Object[] row = new Object[5];
					row[0] = sd;
					row[1] = sd.getStudent().getFirstName();
					row[2] = sd.getStudent().getLastName();
					row[3] = ((Student)sd.getStudent()).getDob();
					row[4] = ((Student)sd.getStudent()).getAddress();
					
					model.addRow(row);
					table.setBounds(317, 220, 650, i);
					i += 16;
				} else {
					if ((sd.getGroupid().equals(groupCombobox.getSelectedItem())
							&& sd.getClassid().equals(classCombobox.getSelectedItem()))) {
						Object[] row = new Object[5];
						row[0] = sd;
						row[1] = sd.getStudent().getFirstName();
						row[2] = sd.getStudent().getLastName();
						row[3] = ((Student)sd.getStudent()).getDob();
						row[4] = ((Student)sd.getStudent()).getAddress();
						
						model.addRow(row);
						table.setBounds(317, 220, 650, i);
						i += 16;
					}
				}
			}

		}
	}
}
