import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MainPanel extends JPanel {
	UniversitySocieties universitySocieties;
	/**
	 * Create the panel.
	 */
	public MainPanel(final Application app, UniversitySocieties societies) {
		this.universitySocieties = societies;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.EAST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{89, 0};
		gbl_panel.rowHeights = new int[]{23, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnMySocieties = new JButton("My Societies");
		btnMySocieties.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnMySocieties = new GridBagConstraints();
		gbc_btnMySocieties.fill = GridBagConstraints.BOTH;
		gbc_btnMySocieties.insets = new Insets(0, 0, 5, 0);
		gbc_btnMySocieties.gridx = 0;
		gbc_btnMySocieties.gridy = 0;
		panel.add(btnMySocieties, gbc_btnMySocieties);
		
		JButton btnSearchSocieties = new JButton("Search Societies");
		btnSearchSocieties.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new SearchSocietyPanel(app, universitySocieties);
				app.addPanel(panel);
			}
		});
		GridBagConstraints gbc_btnSearchSocieties = new GridBagConstraints();
		gbc_btnSearchSocieties.fill = GridBagConstraints.BOTH;
		gbc_btnSearchSocieties.insets = new Insets(0, 0, 5, 0);
		gbc_btnSearchSocieties.gridx = 0;
		gbc_btnSearchSocieties.gridy = 1;
		panel.add(btnSearchSocieties, gbc_btnSearchSocieties);
		
		JButton btnCreateSociety = new JButton("Create Society");
		btnCreateSociety.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new CreateSocietyPanel(app, universitySocieties);
				app.addPanel(panel);
			}
		});
		GridBagConstraints gbc_btnCreateSociety = new GridBagConstraints();
		gbc_btnCreateSociety.fill = GridBagConstraints.BOTH;
		gbc_btnCreateSociety.insets = new Insets(0, 0, 5, 0);
		gbc_btnCreateSociety.gridx = 0;
		gbc_btnCreateSociety.gridy = 2;
		panel.add(btnCreateSociety, gbc_btnCreateSociety);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		
		JLabel lblEvents = new JLabel("Events");
		panel_1.add(lblEvents);

	}

}
