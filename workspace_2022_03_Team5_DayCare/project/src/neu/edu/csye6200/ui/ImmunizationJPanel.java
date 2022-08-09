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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class ImmunizationJPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private JPanel container;
	private JTable table;
	public ImmunizationJPanel(JPanel container, DayCare daycare, StudentDetails st) {
		this.container=container;
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
		
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(92, 346, 83, 22);
		add(comboBox);
		
		JButton backButton = new JButton("<<Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backJButtonActionPerformed(e);
			}
		});
		backButton.setBounds(81, 76, 89, 23);
		add(backButton);

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
