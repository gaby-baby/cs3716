import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class SearchSocietyPanel extends JPanel {
	private UniversitySocieties universitySocieties;
	private JTextField txtSearch;
	JList lstResults;
	DefaultListModel searchListModel = new DefaultListModel();
	/**
	 * Create the panel.
	 */
	public SearchSocietyPanel(final Application app, UniversitySocieties societies) {
		this.universitySocieties = societies;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				searchListModel.clear();
				ArrayList<Society> societies = universitySocieties.searchSimilar(txtSearch.getText());
				
				for(Society society : societies)
					searchListModel.addElement(society);
			}
		});
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 0;
		add(txtSearch, gbc_textField);
		txtSearch.setColumns(10);
		
		JComboBox cmbFilter = new JComboBox();
		cmbFilter.setModel(new DefaultComboBoxModel(new String[] {"Society Name", "Society Major"}));
		GridBagConstraints gbc_cmbFilter = new GridBagConstraints();
		gbc_cmbFilter.insets = new Insets(0, 0, 5, 0);
		gbc_cmbFilter.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbFilter.gridx = 1;
		gbc_cmbFilter.gridy = 0;
		add(cmbFilter, gbc_cmbFilter);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		
		lstResults = new JList(searchListModel);
		lstResults.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if(evt.getClickCount() == 2){
					if(lstResults.getSelectedValue() != null){
						app.addPanel(new ViewSocietyPanel(universitySocieties,(Society)lstResults.getSelectedValue()));
					}
				}
			}
		});
		lstResults.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent evt) {

			}
		});
		scrollPane.setViewportView(lstResults);

	}

}
