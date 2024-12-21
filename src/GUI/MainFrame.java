package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	
	DeleteFrame df = new DeleteFrame(this);
	DisplayFrame dsf = new DisplayFrame(this);
	AddFrame af = new AddFrame(this);
	PromotionFrame pf = new PromotionFrame(this);
	SearchFrame sf = new SearchFrame(this);

	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nameLabel = new JLabel("Employee Sphere");
		nameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 47));
		nameLabel.setBounds(75, 62, 405, 76);
		contentPane.add(nameLabel);
		
		JButton addButton = new JButton("Add Employee");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				af.setVisible(true);
			}
		});
		addButton.setBounds(166, 170, 191, 29);
		contentPane.add(addButton);
		
		JButton deleteButton = new JButton("Delete Employee");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				df.setVisible(true);
			}
		});
		deleteButton.setBounds(166, 211, 191, 29);
		contentPane.add(deleteButton);
		
		JButton displayButton = new JButton("Display");
		displayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dsf.setVisible(true);
			}
		});
		displayButton.setBounds(166, 254, 191, 29);
		contentPane.add(displayButton);
		
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				sf.setVisible(true);
			}
		});
		searchButton.setBounds(166, 295, 191, 29);
		contentPane.add(searchButton);
		
		JButton promotionButton = new JButton("Promotion and Raise");
		promotionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				pf.setVisible(true);
			}
		});
		promotionButton.setBounds(166, 336, 191, 29);
		contentPane.add(promotionButton);
	}
}
