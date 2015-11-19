import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateScreen frame = new CreateScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CreateScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JFormattedTextField nameText = new JFormattedTextField();
		nameText.setBounds(82, 11, 125, 20);
		panel.add(nameText);
		
		JLabel labelName = new JLabel("Name : ");
		labelName.setBounds(26, 14, 46, 14);
		panel.add(labelName);
		
		JLabel labelStudent = new JLabel("Student # :");
		labelStudent.setBounds(10, 45, 62, 14);
		panel.add(labelStudent);
		
		JFormattedTextField textStudentId = new JFormattedTextField();
		textStudentId.setBounds(82, 42, 125, 20);
		panel.add(textStudentId);
		
		JFormattedTextField textEmail = new JFormattedTextField();
		textEmail.setBounds(82, 73, 125, 20);
		panel.add(textEmail);
		
		JFormattedTextField textSocietyName = new JFormattedTextField();
		textSocietyName.setBounds(82, 108, 125, 20);
		panel.add(textSocietyName);
		
		JFormattedTextField textMajor = new JFormattedTextField();
		textMajor.setBounds(82, 142, 125, 20);
		panel.add(textMajor);
		
		JLabel labelEmail = new JLabel("Email :");
		labelEmail.setBounds(10, 76, 62, 14);
		panel.add(labelEmail);
		
		JLabel labelSocietyName = new JLabel("Society Name :");
		labelSocietyName.setBounds(10, 111, 62, 14);
		panel.add(labelSocietyName);
		
		JLabel labelMajor = new JLabel("Major :");
		labelMajor.setBounds(10, 145, 62, 14);
		panel.add(labelMajor);
		
		JLabel labelDiscription = new JLabel("Society Description :");
		labelDiscription.setBounds(10, 176, 62, 14);
		panel.add(labelDiscription);
		
		JTextArea textAreaSociety = new JTextArea();
		textAreaSociety.setBounds(82, 173, 125, 67);
		panel.add(textAreaSociety);
		
		JButton createButton = new JButton("Create");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String name = textName.getT
			}
		});
		createButton.setBounds(275, 176, 89, 50);
		panel.add(createButton);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		backButton.setBounds(352, 10, 62, 23);
		panel.add(backButton);
	}
}
