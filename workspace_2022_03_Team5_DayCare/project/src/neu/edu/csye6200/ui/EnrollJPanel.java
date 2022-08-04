package neu.edu.csye6200.ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EnrollJPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private JPanel container;
	
	public EnrollJPanel(JPanel container) {
		setBackground(new Color(204, 255, 255));
		this.container = container;
		this.setBounds(0, 0, 990, 990);
		setLayout(null);
		
		JButton backButton = new JButton("<< back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backJButtonActionPerformed(e);
			}
		});
		backButton.setBounds(58, 98, 117, 29);
		add(backButton);
		
		JLabel lblEnroll = new JLabel("Enroll");
		lblEnroll.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnroll.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblEnroll.setBounds(6, 6, 978, 78);
		add(lblEnroll);
		
		
	}
	
	public void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {
		container.remove(this);
      Component[] componentArray = container.getComponents();
      Component component = componentArray[componentArray.length - 1];
      DashBoardJPanel dashBoardJPanel = (DashBoardJPanel) component;

      CardLayout layout = (CardLayout) container.getLayout();
      layout.previous(container);
	}

}
