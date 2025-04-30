package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Inheritance.Employee;
import SystemClassAndMain.EmployeeSystem;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteFrame extends JFrame {

	private JPanel contentPane;
	private JTextField idTextField;

	MainFrame mf;
	
	public DeleteFrame(MainFrame mf) {
		this.mf = mf;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel idLabel = new JLabel("ID:");
		idLabel.setBounds(187, 74, 36, 16);
		contentPane.add(idLabel);
		
		idTextField = new JTextField();
		idTextField.setBounds(217, 69, 130, 26);
		contentPane.add(idTextField);
		idTextField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(42, 145, 458, 158);
		contentPane.add(textArea);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mf.setVisible(true);
				textArea.setText("");
				idTextField.setText("");
				dispose();
			}
		});
		backButton.setBounds(217, 315, 117, 29);
		contentPane.add(backButton);
		
		JLabel descriptionLabel = new JLabel("Delete Employee with ID");
		descriptionLabel.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		descriptionLabel.setBounds(121, 20, 314, 26);
		contentPane.add(descriptionLabel);
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idTextField.getText().isEmpty())
					textArea.setText("Enter an ID first.");
				
				else {
				boolean isDeleted = EmployeeSystem.deleteEmployee(Integer.parseInt(idTextField.getText()));
				
				if(!isDeleted)
					textArea.setText("There is no employee with the given ID. Employee couldn't be deleted. ");
				
				else
					textArea.setText("Employee is deleted successfully.");
			}
			}
		});
		deleteButton.setBounds(217, 102, 117, 29);
		contentPane.add(deleteButton);
	}
}
