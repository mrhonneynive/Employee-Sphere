package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Inheritance.Employee;
import SystemClassAndMain.EmployeeSystem;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchFrame extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	MainFrame mf;


	public SearchFrame(MainFrame mf) {
		this.mf = mf;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(42, 145, 458, 158);
		contentPane.add(textArea);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mf.setVisible(true);
				textArea.setText("");
				textField.setText("");
				dispose();
			}
		});
		backButton.setBounds(218, 317, 117, 29);
		contentPane.add(backButton);
		
		JLabel idLabel = new JLabel("ID:");
		idLabel.setBounds(183, 73, 36, 16);
		contentPane.add(idLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(218, 68, 130, 26);
		contentPane.add(textField);
		
		JLabel lblSearchEmployeeWith = new JLabel("Search Employee with ID");
		lblSearchEmployeeWith.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		lblSearchEmployeeWith.setBounds(116, 16, 318, 36);
		contentPane.add(lblSearchEmployeeWith);
		
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField.getText().isEmpty())
					textArea.setText("Enter an ID first.");
				
				else {
				Employee employee = EmployeeSystem.searchEmployee(Integer.parseInt(textField.getText()));
				
				if(employee == null)
					textArea.setText("There is no employee with the given ID.");
				
				else
				textArea.setText(employee.toString());
			}
		}
	});
		searchButton.setBounds(218, 101, 117, 29);
		contentPane.add(searchButton);
	}

}
