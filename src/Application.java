import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;


public class Application extends JFrame {

	private JPanel contentPane;
	Stack<JPanel> panels = new Stack<JPanel>();
	JPanel viewPort;
	UniversitySocieties universitySocieties = new UniversitySocieties();
	Application instance;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application frame = new Application();
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
	public Application() {
		instance = this;
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setTitle("Memorial University Society Manager");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblMemorialUniversity = new JLabel("Memorial University Society Manager");
		panel.add(lblMemorialUniversity);
		
		viewPort = new JPanel();
		contentPane.add(viewPort, BorderLayout.CENTER);
		viewPort.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		addPanel(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 25, 264, 518);
		panel_3.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblEvents = new JLabel("Events");
		lblEvents.setBounds(115, 5, 33, 14);
		panel_1.add(lblEvents);
		
		JButton btnCreateSociety = new JButton("Create Society");
		btnCreateSociety.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPanel panel = new CreateSocietyPanel(universitySocieties);
				addPanel(panel);
			}
		});
		

		
		btnCreateSociety.setBounds(597, 25, 145, 23);
		panel_3.add(btnCreateSociety);
		
		JButton btnNewButton_1 = new JButton("Search Societies");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new SearchSocietyPanel(instance, universitySocieties);
				addPanel(panel);
			}
		});
		btnNewButton_1.setBounds(597, 59, 145, 23);
		panel_3.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		FlowLayout fl_panel_2 = new FlowLayout(FlowLayout.RIGHT, 5, 5);
		panel_2.setLayout(fl_panel_2);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removePanel();
			}
		});
		panel_2.add(btnNewButton);
	}
	
	public void addPanel(JPanel panel){
		// Hide Current Panel
		if(!panels.isEmpty()){
			panels.peek().setVisible(false);
			viewPort.remove(panels.peek());
		}
		
		// Show new panel
		panels.add(panel);
		viewPort.add(panel, BorderLayout.CENTER);
		panel.setVisible(true);
	}
	
	public JPanel removePanel(){
		if(panels.size() <= 1)
			return null;
		
		// Get Current panel and hide it
		JPanel panel = panels.pop();
		viewPort.remove(panel);
		panel.setVisible(false);
		
		// Set current panel to new panel
		panels.add(panels.peek());
		viewPort.add(panels.peek(), BorderLayout.CENTER);
		panels.peek().setVisible(true);

		
		return panel;
	}
}
