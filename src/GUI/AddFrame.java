package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SystemClassAndMain.EmployeeSystem;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddFrame extends JFrame {


	private JPanel contentPane;
	private JTextField idField;
	private JTextField nameField;
	private JTextField surnameField;
	private JTextField salaryField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField taskField;
	private JComboBox comboBox;
	private JRadioButton workerRadioButton;
	private JRadioButton managerRadioButton;
	
	MainFrame mf;
	
	void clean() {
		idField.setText("");
		nameField.setText("");
		surnameField.setText("");
		salaryField.setText("");
		comboBox.setSelectedIndex(0);
		taskField.setText("");
	}

	public AddFrame(MainFrame mf) {
		
		this.mf = mf;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JLabel resultLabel = new JLabel("");
		resultLabel.setBounds(148, 407, 296, 16);
		contentPane.add(resultLabel);

		JLabel addEmployeeLabel = new JLabel("Add Employee");
		addEmployeeLabel.setBounds(186, 21, 176, 30);
		addEmployeeLabel.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		contentPane.add(addEmployeeLabel);

		JLabel idLabel = new JLabel("ID:");
		idLabel.setBounds(73, 107, 61, 16);
		contentPane.add(idLabel);

		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setBounds(73, 154, 61, 16);
		contentPane.add(nameLabel);

		JLabel surnameLabel = new JLabel("Surname:");
		surnameLabel.setBounds(73, 202, 83, 16);
		contentPane.add(surnameLabel);

		JLabel departmentLabel = new JLabel("Department:");
		departmentLabel.setBounds(73, 292, 95, 16);
		contentPane.add(departmentLabel);

		comboBox = new JComboBox();
		comboBox.setBounds(186, 288, 252, 27);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Accounting and Finance", "Marketing", "IT", "Customer Service"}));
		contentPane.add(comboBox);

		idField = new JTextField();
		idField.setBounds(186, 102, 252, 26);
		contentPane.add(idField);
		idField.setColumns(10);

		nameField = new JTextField();
		nameField.setBounds(186, 149, 252, 26);
		nameField.setColumns(10);
		contentPane.add(nameField);

		surnameField = new JTextField();
		surnameField.setBounds(186, 197, 252, 26);
		surnameField.setColumns(10);
		contentPane.add(surnameField);

		JButton addButton = new JButton("Add Employee");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean result = false;
				
				if (workerRadioButton.isSelected()) {
				result= EmployeeSystem.addWorker(Integer.parseInt(idField.getText()), nameField.getText(), surnameField.getText(),
						Double.parseDouble(salaryField.getText()),
						comboBox.getSelectedIndex() + 1,
						Integer.parseInt(taskField.getText()));
				
			}
				
				else if (managerRadioButton.isSelected()){
					result = EmployeeSystem.addManager(Integer.parseInt(idField.getText()), nameField.getText(), surnameField.getText(),
							Double.parseDouble(salaryField.getText()),
							comboBox.getSelectedIndex() + 1);
				}
			
				if (result) {
					clean();
					resultLabel.setText("Employee added successfully!\n");
				} else {
					resultLabel.setText("Please write a correct id");
				}
			}
		});
		addButton.setBounds(195, 368, 141, 29);
		contentPane.add(addButton);

		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mf.setVisible(true);
				clean();
				dispose();
			}
		});
		backButton.setBounds(207, 434, 117, 29);
		contentPane.add(backButton);

		JLabel salaryLabel = new JLabel("Salary:");
		salaryLabel.setBounds(73, 248, 83, 16);
		contentPane.add(salaryLabel);

		salaryField = new JTextField();
		salaryField.setBounds(186, 243, 252, 26);
		salaryField.setColumns(10);
		contentPane.add(salaryField);


		JLabel taskLabel = new JLabel("Tasks:");
		taskLabel.setBounds(73, 334, 95, 16);
		contentPane.add(taskLabel);
		
		taskField = new JTextField();
		taskField.setColumns(10);
		taskField.setBounds(186, 330, 252, 26);
		contentPane.add(taskField);
		
		workerRadioButton = new JRadioButton("Worker");
		workerRadioButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				taskField.setEditable(true);
			}
		});
		workerRadioButton.setSelected(true);
		workerRadioButton.setBounds(148, 67, 95, 23);
		buttonGroup.add(workerRadioButton);
		contentPane.add(workerRadioButton);
		
		managerRadioButton = new JRadioButton("Manager");
		managerRadioButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				taskField.setEditable(false);
			}
		});
		managerRadioButton.setBounds(281, 67, 100, 23);
		buttonGroup.add(managerRadioButton);
		contentPane.add(managerRadioButton);
		
		
		

	}
}