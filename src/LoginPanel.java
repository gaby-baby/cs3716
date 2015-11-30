import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class LoginPanel extends JPanel{

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtStudentId;
	private JTextField txtEmail;
	UniversitySocieties universitySocieties;

	/**
	 * Create the application.
	 */
	public LoginPanel(final Application app, UniversitySocieties societies) {
		universitySocieties = societies;
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		JLabel lblName = new JLabel("Name :");
		add(lblName, "2, 2, right, default");
		
		txtName = new JTextField();
		add(txtName, "4, 2, fill, default");
		txtName.setColumns(10);
		
		JLabel lblStudentId = new JLabel("Student Id:");
		add(lblStudentId, "2, 4, right, default");
		
		txtStudentId = new JTextField();
		add(txtStudentId, "4, 4, fill, default");
		
		JLabel lblEmail = new JLabel("Email :");
		add(lblEmail, "2, 6, right, default");
		
		txtEmail = new JTextField();
		add(txtEmail, "4, 6, fill, default");
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			// Creates the Student object, not set up to do anything else at this point
			public void actionPerformed(ActionEvent arg0) {
				if(txtName.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Error, Please fill in the Name Field");
					return;
				}
				if(txtStudentId.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Error, Please fill in the Student Id Field");
					return;
				}
				if(txtEmail.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Error, Please fill in the Email Field");
					return;
				}
				
				Student aStudent= new Student(txtName.getText(),txtStudentId.getText(),txtEmail.getText());
				universitySocieties.studentLoggedIn = aStudent;
				
				app.addPanel(new MainPanel(app, universitySocieties));
				
				
			}
		});
		add(btnLogin, "4, 10, right, default");
		
	}

	


}
