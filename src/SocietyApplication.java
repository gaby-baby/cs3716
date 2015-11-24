import java.awt.EventQueue;
import java.io.*;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JEditorPane;
import java.awt.BorderLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JTabbedPane;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.border.BevelBorder;

public class SocietyApplication {

	private JFrame frmSocietySystem;
	private JTextField aStudentEmail;
	private JTextField aSocietyName;
	private JTextField aSocietyMajor;
	private JTextField aStudentName;
	private JTextField aStudentNumber;
	private UniversitySocieties mySystem = new UniversitySocieties();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SocietyApplication window = new SocietyApplication();
					window.frmSocietySystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public SocietyApplication() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()  {
		frmSocietySystem = new JFrame();
		frmSocietySystem.setTitle("Society System");
		frmSocietySystem.setBounds(100, 100, 450, 300);
		frmSocietySystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSocietySystem.getContentPane().setLayout(new CardLayout(0, 0));

		
		
			
		
		
		final JPanel panelMenu = new JPanel();
		frmSocietySystem.getContentPane().add(panelMenu, "name_154786120335146");
		panelMenu.setLayout(null);
		panelMenu.setVisible(true);

		JButton joinButton = new JButton("Join Society");
		joinButton.setBounds(290, 11, 134, 51);
		panelMenu.add(joinButton);
		

		
		JButton createButton = new JButton("Create Society");

		createButton.setBounds(10, 11, 145, 50);
		panelMenu.add(createButton);
		final DefaultListModel<Society> model = new DefaultListModel();

		JList list = new JList(model);
		list.setBounds(63, 93, 310, 142);
		panelMenu.add(list);
		
		ObjectInputStream objectInputStream = null;
		
		try {
			objectInputStream = new ObjectInputStream(new FileInputStream("output"));
			mySystem = (UniversitySocieties) objectInputStream.readObject();
			System.out.println("gothere");
			Iterator<Society> mySocietys= mySystem.getAllSocieties();
			while(mySocietys.hasNext()){
				model.addElement(mySocietys.next());
			}
			objectInputStream.close();
		} catch (IOException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		


		final JPanel panelSearch = new JPanel();
		frmSocietySystem.getContentPane().add(panelSearch, "name_154786129304777");
		panelSearch.setVisible(false);

		final JPanel panelCreateSociety = new JPanel();
		frmSocietySystem.getContentPane().add(panelCreateSociety, "name_154786136890495");
		panelCreateSociety.setLayout(null);
		panelCreateSociety.setVisible(false);

		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenu.setVisible(false);
				panelCreateSociety.setVisible(true);
			}
		});

		aStudentEmail = new JTextField();
		aStudentEmail.setBounds(110, 112, 86, 20);
		panelCreateSociety.add(aStudentEmail);
		aStudentEmail.setColumns(10);

		JLabel labelStudentName = new JLabel("Name ");
		labelStudentName.setBounds(64, 50, 36, 14);
		panelCreateSociety.add(labelStudentName);

		aSocietyName = new JTextField();
		aSocietyName.setColumns(10);
		aSocietyName.setBounds(293, 47, 86, 20);
		panelCreateSociety.add(aSocietyName);

		aSocietyMajor = new JTextField();
		aSocietyMajor.setColumns(10);
		aSocietyMajor.setBounds(293, 78, 86, 20);
		panelCreateSociety.add(aSocietyMajor);

		aStudentName = new JTextField();
		aStudentName.setColumns(10);
		aStudentName.setBounds(110, 47, 86, 20);
		panelCreateSociety.add(aStudentName);

		aStudentNumber = new JTextField();
		aStudentNumber.setColumns(10);
		aStudentNumber.setBounds(110, 78, 86, 20);
		panelCreateSociety.add(aStudentNumber);

		final JTextArea aSocietyDescription = new JTextArea();
		aSocietyDescription.setBounds(291, 110, 117, 69);
		panelCreateSociety.add(aSocietyDescription);

		JLabel lblStudentNumber = new JLabel("Student Number");
		lblStudentNumber.setBounds(10, 81, 86, 14);
		panelCreateSociety.add(lblStudentNumber);

		JLabel lblStudentemail = new JLabel("Email ");
		lblStudentemail.setBounds(64, 115, 27, 14);
		panelCreateSociety.add(lblStudentemail);

		JLabel lblSocietyName = new JLabel("Society Name");
		lblSocietyName.setBounds(206, 50, 77, 14);
		panelCreateSociety.add(lblSocietyName);

		JLabel lblMajor = new JLabel("Major");
		lblMajor.setBounds(206, 81, 46, 14);
		panelCreateSociety.add(lblMajor);

		JLabel lblSocietyDescription = new JLabel("Society Description");
		lblSocietyDescription.setBounds(198, 111, 97, 23);
		panelCreateSociety.add(lblSocietyDescription);

		JButton makeSocietyButton = new JButton("Create Society");
		makeSocietyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aName= aStudentName.getText();
				String aNumber= aStudentNumber.getText();
				String aEmail= aStudentEmail.getText();
				Student aStudent = new Student(aName,aNumber,aEmail);
				String societyName= aSocietyName.getText();
				String societyMajor = aSocietyMajor.getText();
				String societyDescription= aSocietyDescription.getText();
				Society aSociety= new Society(societyName,societyDescription,societyMajor,aStudent);
				mySystem.add(aSociety);
				model.addElement(aSociety);
				try {
					FileOutputStream fos = new FileOutputStream("output");
					ObjectOutputStream oos = new ObjectOutputStream(fos);   
					oos.writeObject(mySystem); // write mySystem to ObjectOutputStream
					oos.close(); 
				} catch(Exception ex) {
					ex.printStackTrace();
				}
				panelCreateSociety.setVisible(false);
				panelMenu.setVisible(true);

			}
		});
		makeSocietyButton.setBounds(262, 202, 146, 39);
		panelCreateSociety.add(makeSocietyButton);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCreateSociety.setVisible(false);
				panelMenu.setVisible(true);

			}
		});
		btnBack.setBounds(369, 13, 55, 23);
		panelCreateSociety.add(btnBack);

	}
	private void createSocietyPanel(){}
	private void createMainPanel(){}
	private void createPanel(){}
}
