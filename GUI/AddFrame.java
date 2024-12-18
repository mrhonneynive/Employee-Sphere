package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ButtonGroup;

public class AddFrame extends JFrame {


	private JPanel contentPane;
	private JTextField idField;
	private JTextField nameField;
	private JTextField surnameField;
	private JTextField salaryField;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public AddFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel addEmployeeLabel = new JLabel("Add Employee");
		addEmployeeLabel.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		addEmployeeLabel.setBounds(186, 21, 176, 30);
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

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Accounting and Finance", "Marketing", "IT", "Customer Service"}));
		comboBox.setBounds(186, 288, 252, 27);
		contentPane.add(comboBox);

		idField = new JTextField();
		idField.setBounds(186, 102, 252, 26);
		contentPane.add(idField);
		idField.setColumns(10);

		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(186, 149, 252, 26);
		contentPane.add(nameField);

		surnameField = new JTextField();
		surnameField.setColumns(10);
		surnameField.setBounds(186, 197, 252, 26);
		contentPane.add(surnameField);

		JButton addButton = new JButton("Add Employee");
		addButton.setBounds(195, 368, 141, 29);
		contentPane.add(addButton);

		JButton backButton = new JButton("Back");
		backButton.setBounds(208, 414, 117, 29);
		contentPane.add(backButton);

		JLabel salaryLabel = new JLabel("Salary:");
		salaryLabel.setBounds(73, 248, 83, 16);
		contentPane.add(salaryLabel);

		salaryField = new JTextField();
		salaryField.setColumns(10);
		salaryField.setBounds(186, 243, 252, 26);
		contentPane.add(salaryField);

		JRadioButton workerRadioButton = new JRadioButton("Worker");
		buttonGroup.add(workerRadioButton);
		workerRadioButton.setSelected(true);
		workerRadioButton.setBounds(148, 67, 95, 23);
		contentPane.add(workerRadioButton);

		JRadioButton managerRadioButton = new JRadioButton("Manager");
		buttonGroup.add(managerRadioButton);
		managerRadioButton.setBounds(281, 67, 100, 23);
		contentPane.add(managerRadioButton);
	}
}
