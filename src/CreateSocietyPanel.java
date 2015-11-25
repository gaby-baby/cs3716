import javax.swing.JPanel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CreateSocietyPanel extends JPanel {
	private JTextField txtSocietyName;
	private JTextField txtSocietyMajor;
	private JTextArea txtSocietyDescription;
	private UniversitySocieties universitySocieties;
	/**
	 * Create the panel.
	 */
	public CreateSocietyPanel(UniversitySocieties societies) {
		this.universitySocieties = societies;
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
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblSocietyName = new JLabel("Society Name:");
		add(lblSocietyName, "2, 2, right, default");
		
		txtSocietyName = new JTextField();
		add(txtSocietyName, "4, 2, fill, default");
		txtSocietyName.setColumns(10);
		
		JLabel lblSocietyMajor = new JLabel("Society Major:");
		add(lblSocietyMajor, "2, 4, right, default");
		
		txtSocietyMajor = new JTextField();
		add(txtSocietyMajor, "4, 4, fill, default");
		txtSocietyMajor.setColumns(10);
		
		JLabel lblSocietyDescription = new JLabel("Society Description:");
		add(lblSocietyDescription, "2, 6, right, default");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane, "4, 6, fill, fill");
		
		txtSocietyDescription = new JTextArea();
		txtSocietyDescription.setLineWrap(true);
		scrollPane.setViewportView(txtSocietyDescription);
		txtSocietyDescription.setWrapStyleWord(true);
		JButton btnCreateSociety = new JButton("Create Society");
		btnCreateSociety.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				universitySocieties.add(new Society(txtSocietyName.getText(), txtSocietyDescription.getText(), txtSocietyMajor.getText(), universitySocieties.studentLoggedIn));
				JOptionPane.showMessageDialog(null, "Society Created!");
			}
		});
		add(btnCreateSociety, "4, 8, right, default");

	}

}
