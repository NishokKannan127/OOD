package neu.edu.csye6200.ui;

import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainJFrame extends javax.swing.JFrame{
	
//	private DayCare daycare;
	JPanel container;
	
	public MainJFrame() {
//		daycare = DayCareBuilder.getInstance();
		initialSetup();
		
	}
	
	public void initialSetup() {
		container = new JPanel();
		container.setBackground(java.awt.SystemColor.textHighlight);
        container.setLayout(new java.awt.CardLayout());
        container.setSize(500,500);
        
        container.setBackground(new java.awt.Color(0, 109, 119));
        this.add(container);
//        container.setVisible(true);
	}
	
	
	
	
}
