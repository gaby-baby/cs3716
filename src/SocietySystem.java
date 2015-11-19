import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JEditorPane;
import java.awt.BorderLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JTabbedPane;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SocietySystem {

	private JFrame frmSocietySystem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SocietySystem window = new SocietySystem();
					window.frmSocietySystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SocietySystem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSocietySystem = new JFrame();
		frmSocietySystem.setTitle("Society System");
		frmSocietySystem.setBounds(100, 100, 450, 300);
		frmSocietySystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmSocietySystem.getContentPane().add(panel, BorderLayout.CENTER);
		
		JButton createButton = new JButton("Create Society");
		createButton.setBounds(10, 87, 121, 65);
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.setLayout(null);
		panel.add(createButton);
		
		JButton joinButton = new JButton("Join Society");
		joinButton.setBounds(158, 87, 114, 65);
		panel.add(joinButton);
		
		JButton leaveButton = new JButton("Leave Society");
		leaveButton.setBounds(302, 87, 107, 65);
		panel.add(leaveButton);
	}

}
