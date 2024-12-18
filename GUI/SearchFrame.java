package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class SearchFrame extends JFrame {
	private JPanel contentPane;
	private JTextField textField;


	public SearchFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(43, 118, 458, 184);
		contentPane.add(textArea);
		
		JButton backButton = new JButton("Back");
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
	}

}
