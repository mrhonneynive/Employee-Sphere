package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Inheritance.Employee;
import SystemClassAndMain.EmployeeSystem;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class DisplayFrame extends JFrame {

	private JPanel contentPane;
	MainFrame mf;

	public DisplayFrame(MainFrame mf) {
		this.mf = mf;
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 255, 458, 153);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton displayButton = new JButton("Display");
        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean[] selectedEmployeeTypes = new boolean[2];
                selectedEmployeeTypes[0] = managerCheckBox.isSelected();
                selectedEmployeeTypes[1] = workerCheckBox.isSelected();
                
                int selectedCount = 0;
                if (accountingCheckBox.isSelected()) selectedCount++;
                if (marketingCheckBox.isSelected()) selectedCount++;
                if (customerServiceCheckBox.isSelected()) selectedCount++;
                if (itCheckBox.isSelected()) selectedCount++;
                
                // Check if at least one department is selected
                if (selectedCount == 0) {
                    textArea.setText("Please select at least one department.");
                    return;
                }
                
                // Create an array to hold selected department IDs
                int[] selectedDepartments = new int[selectedCount];
                int index = 0;
                if (accountingCheckBox.isSelected()) {
                    selectedDepartments[index] = 0;
                    index++;
                }
                if (marketingCheckBox.isSelected()) {
                    selectedDepartments[index] = 1;
                    index++;
                }
                if (customerServiceCheckBox.isSelected()) {
                    selectedDepartments[index] = 2;
                    index++;
                }
                if (itCheckBox.isSelected()) {
                    selectedDepartments[index] = 3;
                    index++;
                }
                
                boolean atLeastOneEmployeeTypeSelected = false;
                if (selectedEmployeeTypes[0] || selectedEmployeeTypes[1]) {
                	atLeastOneEmployeeTypeSelected = true;
                }
                if (!atLeastOneEmployeeTypeSelected) {
                    textArea.setText("Please select at least one employee type.");
                    return;
                }
                
                String displayResult = EmployeeSystem.display(selectedDepartments, selectedEmployeeTypes);
                
                if (displayResult == null) {
					displayResult = "An error occured while getting employees";
					textArea.setText(displayResult);
					return;
				}
               
                textArea.setText(" Total number of employees: "+ Employee.totalEmployees+ "\n"+displayResult );
            }
        });
      
		displayButton.setBounds(44, 216, 80, 29);
		contentPane.add(displayButton);
		
		
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mf.setVisible(true);
				textArea.setText("");
				dispose();
			}
		});
		backButton.setBounds(210, 424, 117, 29);
		contentPane.add(backButton);
		
		JButton btnDisplayByPerformance = new JButton("Display by Performance Score");
		btnDisplayByPerformance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 boolean[] selectedEmployeeTypes = new boolean[2];
	                selectedEmployeeTypes[0] = managerCheckBox.isSelected();
	                selectedEmployeeTypes[1] = workerCheckBox.isSelected();
	                
	                int selectedCount = 0;
	                if (accountingCheckBox.isSelected()) selectedCount++;
	                if (marketingCheckBox.isSelected()) selectedCount++;
	                if (customerServiceCheckBox.isSelected()) selectedCount++;
	                if (itCheckBox.isSelected()) selectedCount++;
	                
	                // Check if at least one department is selected
	                if (selectedCount == 0) {
	                    textArea.setText("Please select at least one department.");
	                    return;
	                }
	                
	                // Create an array to hold selected department IDs
	                int[] selectedDepartments = new int[selectedCount];
	                int index = 0;
	                if (accountingCheckBox.isSelected()) {
	                    selectedDepartments[index] = 0;
	                    index++;
	                }
	                if (marketingCheckBox.isSelected()) {
	                    selectedDepartments[index] = 1;
	                    index++;
	                }
	                if (customerServiceCheckBox.isSelected()) {
	                    selectedDepartments[index] = 2;
	                    index++;
	                }
	                if (itCheckBox.isSelected()) {
	                    selectedDepartments[index] = 3;
	                    index++;
	                }
	                
	                boolean atLeastOneEmployeeTypeSelected = false;
	                if (selectedEmployeeTypes[0] || selectedEmployeeTypes[1]) {
	                	atLeastOneEmployeeTypeSelected = true;
	                }
	                if (!atLeastOneEmployeeTypeSelected) {
	                    textArea.setText("Please select at least one employee type.");
	                    return;
	                }
	                
	                String displayResult = EmployeeSystem.displayByPerformanceScore(selectedDepartments, selectedEmployeeTypes);
	                
	                if (displayResult == null) {
						displayResult = "An error occured while getting employees";
					}
	                
	                textArea.setText(displayResult);
	            }
			
		});
		btnDisplayByPerformance.setBounds(134, 216, 204, 29);
		contentPane.add(btnDisplayByPerformance);
		
		JButton btnDisplayFiredEmployees = new JButton("Display Fired Employees");
		btnDisplayFiredEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String displayResult= EmployeeSystem.displayFiredEmployees();
				if(!displayResult.equalsIgnoreCase("")) {
					textArea.setText(displayResult);
				}else
				{
					textArea.setText("There are no fired Employees");
				}
				
			}
		});
		btnDisplayFiredEmployees.setBounds(348, 215, 178, 30);
		contentPane.add(btnDisplayFiredEmployees);
	}
}
