package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class DisplayFrame extends JFrame {

	private JPanel contentPane;

	public DisplayFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel displayEmployeeLabel = new JLabel("Display Employees");
		displayEmployeeLabel.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		displayEmployeeLabel.setBounds(161, 17, 233, 30);
		contentPane.add(displayEmployeeLabel);
		
		JLabel employeeLabel = new JLabel("Employee:");
		employeeLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		employeeLabel.setBounds(44, 89, 80, 16);
		contentPane.add(employeeLabel);
		
		JCheckBox workerCheckBox = new JCheckBox("Worker");
		workerCheckBox.setBounds(161, 85, 128, 23);
		contentPane.add(workerCheckBox);
		
		JCheckBox managerCheckBox = new JCheckBox("Manager");
		managerCheckBox.setBounds(301, 85, 128, 23);
		contentPane.add(managerCheckBox);
		
		JLabel departmentLabel = new JLabel("Department:");
		departmentLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		departmentLabel.setBounds(44, 133, 105, 16);
		contentPane.add(departmentLabel);
		
		JCheckBox accountingCheckBox = new JCheckBox("Accounting and Finance");
		accountingCheckBox.setBounds(161, 129, 202, 23);
		contentPane.add(accountingCheckBox);
		
		JCheckBox marketingCheckBox = new JCheckBox("Marketing");
		marketingCheckBox.setBounds(364, 129, 128, 23);
		contentPane.add(marketingCheckBox);
		
		JCheckBox customerServiceCheckBox = new JCheckBox("Customer Service");
		customerServiceCheckBox.setBounds(161, 164, 202, 23);
		contentPane.add(customerServiceCheckBox);
		
		JCheckBox itCheckBox = new JCheckBox("IT");
		itCheckBox.setBounds(364, 164, 128, 23);
		contentPane.add(itCheckBox);
		
		JButton displayButton = new JButton("Display");
		displayButton.setBounds(207, 209, 117, 29);
		contentPane.add(displayButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(44, 255, 458, 153);
		contentPane.add(textArea);
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(207, 420, 117, 29);
		contentPane.add(backButton);
	}
}
