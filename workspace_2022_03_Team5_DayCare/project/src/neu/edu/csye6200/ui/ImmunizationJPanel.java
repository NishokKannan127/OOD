package neu.edu.csye6200.ui;

import javax.swing.JPanel;
import javax.swing.JTable;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class ImmunizationJPanel extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ImmunizationJPanel() {
		setBackground(new Color(204, 255, 255));
		this.setBounds(0, 0, 990, 990);
		setLayout(null);
		
		table = new JTable();
		table.setBounds(810, 538, -451, -241);
		add(table);
		
		JButton btnNewButton = new JButton("Edit");
		btnNewButton.setBounds(92, 277, 89, 23);
		add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(92, 346, 83, 22);
		add(comboBox);
		
		JButton btnNewButton_1 = new JButton("<<Back");
		btnNewButton_1.setBounds(81, 76, 89, 23);
		add(btnNewButton_1);

	}
}
