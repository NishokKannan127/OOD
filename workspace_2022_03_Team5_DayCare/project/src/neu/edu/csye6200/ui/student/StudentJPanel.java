package neu.edu.csye6200.ui.student;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import neu.edu.csye6200.DayCare;
import neu.edu.csye6200.models.Group;
import neu.edu.csye6200.models.StudentDetails;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class StudentJPanel extends JPanel {

	private JPanel container;
	private DayCare daycare;
	/**
	 * Create the panel.
	 */

	JComboBox classCombobox;
	JComboBox groupCombobox;
	private JTable table;

	public StudentJPanel(JPanel container, DayCare daycare) {
		setBackground(new Color(204, 255, 255));
		this.container = container;
		this.daycare = daycare;
		this.setBounds(0, 0, 990, 990);
		setLayout(null);

		table = new JTable();
		table.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		table.setForeground(Color.WHITE);

		table.setBackground(Color.YELLOW);
		table.setBounds(417, 180, 348, 64);

		table.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
		table.setForeground(new java.awt.Color(255, 255, 255));
		table.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null }, { null, null }, { null, null }, { null, null } },
				new String[] { "Username", "Retailer Name" }));

		classCombobox = new JComboBox();
		classCombobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				populatGroupCombobox();
//				populateTable();
			}
		});
		classCombobox.setBackground(new Color(51, 204, 255));
		classCombobox.setBounds(69, 199, 165, 27);
		add(classCombobox);

		groupCombobox = new JComboBox();
		groupCombobox.setBackground(new Color(51, 204, 255));
		groupCombobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				populatGroupCombobox((String)groupCombobox.getSelectedItem());
			}
		});
		groupCombobox.setBounds(69, 260, 165, 27);
		add(groupCombobox);
		populatClassCombobox();
		populatGroupCombobox();

		JButton backButton = new JButton("<< back");
		backButton.setBounds(58, 98, 117, 29);
		add(backButton);

		JLabel lblStudent = new JLabel("Student");
		lblStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudent.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblStudent.setBounds(6, 6, 978, 78);
		add(lblStudent);

//		populateTable();

		add(table);

	}
	
	public void populatGroupCombobox(String value) {
		groupCombobox.removeAllItems();
		groupCombobox.setSelectedItem(value);
//		populateTable();
		System.out.println("sdsf");
	}
	public void populatGroupCombobox() {
		groupCombobox.removeAllItems();
		if (classCombobox.getSelectedItem().equals("All Classes")) {
			groupCombobox.addItem("All Groups");
		} else {
			groupCombobox.addItem("All Groups");
			groupCombobox.addItem("Group 1");
			groupCombobox.addItem("Group 2");
			groupCombobox.addItem("Group 3");
		}
		populateTable();
	}

	public void populatClassCombobox() {
		classCombobox.removeAllItems();
		classCombobox.addItem("All Classes");
		classCombobox.addItem("Class 1");
		classCombobox.addItem("Class 2");
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
				String temp = (String)groupCombobox.getSelectedItem();
				if (sd.getClassid().equals(classCombobox.getSelectedItem())
						&& temp.equals("All Groups")) {
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
