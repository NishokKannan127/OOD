package neu.edu.csye6200.ui.student;

import java.awt.Color;

import javax.swing.JPanel;

import neu.edu.csye6200.DayCare;
import neu.edu.csye6200.models.StudentDetails;

import javax.swing.JLabel;
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
		List<String> class1 = new ArrayList<>();
		class1.add("All Groups");
		class1.add("Group 1");
		class1.add("Group 2");
		class1.add("Group 3");
		classmap.put("Class 1", class1);
		List<String> class2 = new ArrayList<>();
		class2.add("All Groups");
		class2.add("Group 1");
		class2.add("Group 2");
		class2.add("Group 3");
		classmap.put("Class 2", class2);
		List<String> allclasses = new ArrayList<>();
		allclasses.add("All Groups");
		classmap.put("All Classes", allclasses);
		
		setBackground(new Color(204, 255, 255));
		this.container = container;
		this.daycare = daycare;
		this.setBounds(0, 0, 990, 990);
		setLayout(null);

		table = new JTable();
		table.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		table.setForeground(Color.WHITE);

		table.setBackground(Color.BLACK);
		table.setBounds(417, 180, 348, 64);

		table.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
		table.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null }},
				new String[] { "ID", "First Name", "Last Name", "Date of Birth", "Address" }));

		JButton backButton = new JButton("<< back");
		backButton.setBounds(58, 98, 117, 29);
		add(backButton);

		JLabel lblStudent = new JLabel("Student");
		lblStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudent.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblStudent.setBounds(6, 6, 978, 78);
		add(lblStudent);

		

		add(table);

		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setBounds(446, 152, 90, 16);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setBounds(638, 152, 83, 16);
		add(lblNewLabel_1);

		classCombobox = new JComboBox<>();
		classCombobox.addItem("All Classes");
		classCombobox.addItem("Class 1");
		classCombobox.addItem("Class 2");
		classCombobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				classComboboxChanged(e);
			}
		});
		classCombobox.setBounds(75, 210, 117, 27);
		add(classCombobox);

		groupCombobox = new JComboBox<>();
		groupCombobox.addItem("All Groups");
		groupCombobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				groupComboboxChanged(e);
			}
		});
		groupCombobox.setBounds(75, 284, 117, 27);
		add(groupCombobox);
		
		populateTable();
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

	public void populateTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		int i = 16;
		table.setBounds(417, 180, 348, i);

		for (StudentDetails sd : daycare.getPersonDir().getStuDir().getStudentList()) {
//            if ((sd.getGroupid().equals(groupCombobox.getSelectedItem()) && sd.getGroupid().equals(classCombobox.getSelectedItem())) ||
//            		(sd.getGroupid().equals("All Groups") && sd.getGroupid().equals("All Classes"))) {
//            }

			if (classCombobox.getSelectedItem().equals("All Classes")) {
				Object[] row = new Object[2];
				row[0] = sd.getStudent().getFirstName();
				row[1] = sd.getStudent().getLastName();
				model.addRow(row);
				table.setBounds(417, 180, 348, i);
				i += 16;
			} else {
				String temp = (String) groupCombobox.getSelectedItem();
				if (sd.getClassid().equals(classCombobox.getSelectedItem()) && temp.equals("All Groups")) {
					Object[] row = new Object[2];
					row[0] = sd.getStudent().getFirstName();
					row[1] = sd.getStudent().getLastName();
					model.addRow(row);
					table.setBounds(417, 180, 348, i);
					i += 16;
				} else {
					if ((sd.getGroupid().equals(groupCombobox.getSelectedItem())
							&& sd.getClassid().equals(classCombobox.getSelectedItem()))) {
						Object[] row = new Object[2];
						row[0] = sd.getStudent().getFirstName();
						row[1] = sd.getStudent().getLastName();
						model.addRow(row);
						table.setBounds(417, 180, 348, i);
						i += 16;
					}
				}
			}

		}
	}
}
