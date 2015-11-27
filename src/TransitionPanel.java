import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.Timer;


public class TransitionPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public TransitionPanel(final Application app, int time, final JPanel destinationPanel, String message) {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("<html><center>"+message+"<center></html>");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel, BorderLayout.CENTER);
		
		Timer timer = new Timer(time, new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				app.removePanel();
				app.addPanel(destinationPanel);
			
			}
			
		});
		
		timer.setRepeats(false);
		timer.start();
		
	}

}
