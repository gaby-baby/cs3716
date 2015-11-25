import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ViewSocietyPanel extends JPanel {
	UniversitySocieties universitySocieties;
	Society society;
	private JTextField txtName;
	private JTextField txtMajor;
	private JTextField txtMemberCount;
	/**
	 * Create the panel.
	 */
	public ViewSocietyPanel(UniversitySocieties societies, Society s) {
		this.society = s;
		this.universitySocieties = societies;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblSocietyName = new JLabel("Society Name:");
		GridBagConstraints gbc_lblSocietyName = new GridBagConstraints();
		gbc_lblSocietyName.anchor = GridBagConstraints.EAST;
		gbc_lblSocietyName.insets = new Insets(0, 0, 5, 5);
		gbc_lblSocietyName.gridx = 0;
		gbc_lblSocietyName.gridy = 0;
		add(lblSocietyName, gbc_lblSocietyName);
		
		txtName = new JTextField();
		txtName.setEditable(false);
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.insets = new Insets(0, 0, 5, 5);
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.gridx = 1;
		gbc_txtName.gridy = 0;
		add(txtName, gbc_txtName);
		txtName.setColumns(10);
		
		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 2;
		gbc_label.gridy = 0;
		add(label, gbc_label);
		
		JLabel lblNewLabel = new JLabel("Society Major");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		txtMajor = new JTextField();
		txtMajor.setEditable(false);
		GridBagConstraints gbc_txtMajor = new GridBagConstraints();
		gbc_txtMajor.insets = new Insets(0, 0, 5, 5);
		gbc_txtMajor.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMajor.gridx = 1;
		gbc_txtMajor.gridy = 1;
		add(txtMajor, gbc_txtMajor);
		txtMajor.setColumns(10);
		
		JLabel lblSocietyDescription = new JLabel("Society Description:");
		GridBagConstraints gbc_lblSocietyDescription = new GridBagConstraints();
		gbc_lblSocietyDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblSocietyDescription.gridx = 0;
		gbc_lblSocietyDescription.gridy = 2;
		add(lblSocietyDescription, gbc_lblSocietyDescription);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);
		
		JTextArea txtDescrption = new JTextArea();
		txtDescrption.setEditable(false);
		scrollPane.setViewportView(txtDescrption);
		txtDescrption.setLineWrap(true);
		
		JLabel lblMembers = new JLabel("Members:");
		GridBagConstraints gbc_lblMembers = new GridBagConstraints();
		gbc_lblMembers.anchor = GridBagConstraints.EAST;
		gbc_lblMembers.insets = new Insets(0, 0, 5, 5);
		gbc_lblMembers.gridx = 0;
		gbc_lblMembers.gridy = 3;
		add(lblMembers, gbc_lblMembers);
		
		txtMemberCount = new JTextField();
		txtMemberCount.setEditable(false);
		GridBagConstraints gbc_txtMemberCount = new GridBagConstraints();
		gbc_txtMemberCount.insets = new Insets(0, 0, 5, 5);
		gbc_txtMemberCount.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMemberCount.gridx = 1;
		gbc_txtMemberCount.gridy = 3;
		add(txtMemberCount, gbc_txtMemberCount);
		txtMemberCount.setColumns(10);
		
		JButton btnJoinSociety = new JButton("Join Society");
		btnJoinSociety.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				society.joinSociety(universitySocieties.studentLoggedIn);
				JOptionPane.showMessageDialog(null, "Society Joined!");
				txtMemberCount.setText("" + society.getMembers().size());
			}
		});
		GridBagConstraints gbc_btnJoinSociety = new GridBagConstraints();
		gbc_btnJoinSociety.anchor = GridBagConstraints.EAST;
		gbc_btnJoinSociety.insets = new Insets(0, 0, 0, 5);
		gbc_btnJoinSociety.gridx = 1;
		gbc_btnJoinSociety.gridy = 4;
		add(btnJoinSociety, gbc_btnJoinSociety);
		
		txtMemberCount.setText("" + society.getMembers().size());
		txtName.setText(society.getName());
		txtMajor.setText(society.getMajor());
		txtDescrption.setText(society.getDescription());
	}

}
