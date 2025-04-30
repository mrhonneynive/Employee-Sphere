package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Inheritance.Department;
import Inheritance.Employee;
import Inheritance.Manager;
import Inheritance.Worker;
import SystemClassAndMain.EmployeeSystem;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PromotionFrame extends JFrame {

	private JPanel contentPane;
	MainFrame mf;
	private JTextField textField;

	public PromotionFrame(MainFrame mf) {
		this.mf = mf;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(24, 131, 502, 280);
		contentPane.add(textArea);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mf.setVisible(true);
				textArea.setText("");
				dispose();
			}
		});
		backButton.setBounds(207, 436, 117, 29);
		contentPane.add(backButton);
		
		JLabel lblPromotionAndSalary = new JLabel("Promotion and Raise");
		lblPromotionAndSalary.setHorizontalAlignment(SwingConstants.CENTER);
		lblPromotionAndSalary.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		lblPromotionAndSalary.setBounds(85, 10, 345, 36);
		contentPane.add(lblPromotionAndSalary);
		
		JButton btnNewButton = new JButton("Promotion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField.getText().isEmpty())
					textArea.setText("Enter an ID first.");
				
				else {
				Employee employee = EmployeeSystem.searchEmployee(Integer.parseInt(textField.getText()));
				
				
				if(employee == null) {
					textArea.setText("There is no employee with the given ID.");
						
				}
			
				
				else {
					for (Department department : EmployeeSystem.getDepartments()) {
						if(employee.getId()== department.getManager().getId()) {
							textArea.setText("This person already a Manager");
							return;
						}
						
						
					}
					
					EmployeeSystem.promoteWorkerToManager((Worker) employee);
					
					textArea.setText(employee.toString());

				}
					
			}
			}});
		btnNewButton.setBounds(21, 91, 189, 29);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(85, 62, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(49, 65, 45, 13);
		contentPane.add(lblNewLabel);
		
		JButton btnRaise = new JButton("Raise");
		btnRaise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField.getText().isEmpty())
					textArea.setText("Enter an ID first.");
				
				else {
				Employee employee = EmployeeSystem.searchEmployee(Integer.parseInt(textField.getText()));
				
				
				if(employee == null) {
					textArea.setText("There is no employee with the given ID.");
						
				}
			
				
				else {
					String res= employee.toString();
					
					for (Department department : EmployeeSystem.getDepartments()) {
						if(employee.getId()== department.getManager().getId()) {
							 ((Manager) employee).raiseSalary();
							textArea.setText(res +"\nManager new salary: "+ String.format("%.2f", employee.getSalary()) );
							return;
						}
						
						
					}
					((Worker) employee).raiseSalary();
					textArea.setText(res +"\nWorker new salary: "+ String.format("%.2f", employee.getSalary()));
					

				}
					
			}
				
			}
		});
		btnRaise.setBounds(257, 92, 189, 29);
		contentPane.add(btnRaise);
	}
}
