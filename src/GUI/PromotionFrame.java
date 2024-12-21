package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SystemClassAndMain.EmployeeSystem;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PromotionFrame extends JFrame {

	private JPanel contentPane;
	MainFrame mf;

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
		backButton.setBounds(216, 470, 117, 29);
		contentPane.add(backButton);
		
		JButton updateButton = new JButton("Update All Employees");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeSystem.resetTasks();
			}
		});
		updateButton.setBounds(163, 429, 208, 29);
		contentPane.add(updateButton);
		
		JLabel lblPromotionAndSalary = new JLabel("Promotion and Salary Raise");
		lblPromotionAndSalary.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		lblPromotionAndSalary.setBounds(107, 16, 345, 36);
		contentPane.add(lblPromotionAndSalary);
		
		JButton btnNewButton = new JButton("Promotion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(60, 81, 189, 29);
		contentPane.add(btnNewButton);
		
		JButton btnSalaryRaise = new JButton("Salary Raise");
		btnSalaryRaise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeSystem.raiseEmployee(null);
			}
		});
		btnSalaryRaise.setBounds(294, 81, 189, 29);
		contentPane.add(btnSalaryRaise);
	}
}
