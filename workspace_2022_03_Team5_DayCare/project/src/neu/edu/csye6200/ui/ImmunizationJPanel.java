package neu.edu.csye6200.ui;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import neu.edu.csye6200.DayCare;
import neu.edu.csye6200.models.StudentDetails;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ImmunizationJPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	
	JComboBox<String> vaccineComboBox;
	private JPanel container;
	private JTable table;
	private JTextField vaccineDoseTextField;
	private JButton addButton;
	StudentDetails st;
	public ImmunizationJPanel(JPanel container, DayCare daycare, StudentDetails st) {
		this.container=container;
		this.st=st;
		setBackground(new Color(204, 255, 255));
		this.setBounds(0, 0, 990, 990);
		setLayout(null);
		
		table = new JTable();
		table.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		table.setForeground(Color.WHITE);

		table.setBackground(Color.BLACK);
		table.setBounds(318, 220, 650, 16);

		table.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
		table.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null }},
				new String[] { "ID", "First Name", "Last Name", "Date of Birth", "Address" }));
		
		add(table);
		
		
		vaccineComboBox = new JComboBox();
		vaccineComboBox.setBounds(92, 346, 83, 22);
		add(vaccineComboBox);
		
		for(String vaccines: daycare.getAllVaccines())
		{
			vaccineComboBox.addItem(vaccines);
		}
		vaccineComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vaccineDoseChange(e);
			}
		});
		JButton backButton = new JButton("<<Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backJButtonActionPerformed(e);
			}
		});
		
		
		backButton.setBounds(81, 76, 89, 23);
		add(backButton);
		
		vaccineDoseTextField = new JTextField();
		vaccineDoseTextField.setBounds(89, 408, 86, 20);
		add(vaccineDoseTextField);
		vaccineDoseTextField.setColumns(2);
		vaccineDoseTextField.setEnabled(false);
		
		addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addVaccineDose(e, vaccineDoseTextField, vaccineComboBox);
			}
		});
		addButton.setBounds(92, 463, 89, 23);
		add(addButton);
		addButton.setEnabled(false);

	}
	public void vaccineDoseChange(java.awt.event.ActionEvent evt)
	{
		vaccineDoseTextField.setEnabled(true);
		addButton.setEnabled(true);
		if(st.getIm().getVaccineMap().containsKey(vaccineComboBox.getSelectedItem())) {
			vaccineDoseTextField.setText(Integer.toString(st.getIm().getVaccineMap().get(vaccineComboBox.getSelectedItem())));
		}
		else
			vaccineDoseTextField.setText(Integer.toString(0));
			
		
	}
	public void addVaccineDose(java.awt.event.ActionEvent evt, JTextField vaccineDoseTextField, JComboBox vaccineComboBox)
	{
		
		HashMap<String,Integer> vaccineMap= new HashMap<>();
		int dose=Integer.parseInt(vaccineDoseTextField.getText());
		vaccineMap.put((String) vaccineComboBox.getSelectedItem(),dose);
		st.getIm().setVaccineMap(vaccineMap);
		
	}
	public void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {
		container.remove(this);
		Component[] componentArray = container.getComponents();
		Component component = componentArray[componentArray.length - 1];
		//DashBoardJPanel dashBoardJPanel = (DashBoardJPanel) component;
		
		CardLayout layout = (CardLayout) container.getLayout();
		layout.previous(container);
	}
}
