package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;

public class DeleteFrame extends JFrame {

	private JPanel contentPane;
	private JTextField idTextField;

	public DeleteFrame() {
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
		textArea.setBounds(42, 119, 458, 184);
		contentPane.add(textArea);
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(217, 315, 117, 29);
		contentPane.add(backButton);
		
		JLabel descriptionLabel = new JLabel("Delete Employee with ID");
		descriptionLabel.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		descriptionLabel.setBounds(121, 20, 314, 26);
		contentPane.add(descriptionLabel);
	}
}
