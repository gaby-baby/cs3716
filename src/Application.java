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
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;


public class Application extends JFrame {

	private JPanel contentPane;
	Stack<JPanel> panels = new Stack<JPanel>();
	JPanel viewPort;
	UniversitySocieties universitySocieties = new UniversitySocieties();
	Application instance;
	JButton btnBackButton;
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
		setBounds(100, 100, 472, 613);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblMemorialUniversity = new JLabel("Memorial University Society Manager");
		panel.add(lblMemorialUniversity);
		
		
		viewPort = new JPanel();
		contentPane.add(viewPort, BorderLayout.CENTER);
		viewPort.setLayout(new BorderLayout(0, 0));
		viewPort.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panel_2, BorderLayout.SOUTH);
		FlowLayout fl_panel_2 = new FlowLayout(FlowLayout.RIGHT, 5, 5);
		panel_2.setLayout(fl_panel_2);
		
		btnBackButton = new JButton("Back");
		btnBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removePanel();
			}
		});
		panel_2.add(btnBackButton);
		
		
		addPanel(new LoginPanel(instance, universitySocieties));
		
	}
	
	public void addPanel(JPanel panel){
		// Hide Current Panel
		if(!panels.isEmpty()){
			panels.peek().setVisible(false);
			viewPort.remove(panels.peek());
		}
		
		panels.add(panel);
		viewPort.add(panel, BorderLayout.CENTER);
		panel.setVisible(true);
		
		if(panels.size() > 2){
			btnBackButton.setEnabled(true);
			btnBackButton.setText("Back");
		} else if (panels.size() > 1) {
			btnBackButton.setEnabled(true);
			btnBackButton.setText("Log out");
		} else {
			btnBackButton.setEnabled(false);
		}
	}
	
	public JPanel removePanel(){
		if(panels.isEmpty())
			return null;
		
		// Get Current panel and dispose of it
		JPanel panel = panels.pop();
		viewPort.remove(panel);
		panel.setVisible(false);
		panel = null;
		
		// Set current panel to new panel
		if(!panels.isEmpty()){
			viewPort.add(panels.peek(), BorderLayout.CENTER);
			panels.peek().setVisible(true);
		}
		
		
		if(panels.size() > 2){
			btnBackButton.setEnabled(true);
			btnBackButton.setText("Back");
		} else if (panels.size() > 1) {
			btnBackButton.setEnabled(true);
			btnBackButton.setText("Log out");
		} else {
			btnBackButton.setEnabled(false);
		}
		
		return panel;
	}
	

}
