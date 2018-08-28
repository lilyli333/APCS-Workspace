import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;

public class TestScreen extends JPanel {

	/**
	 * Create the panel.
	 */
	public TestScreen() {
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);
		
		JButton button = new JButton("New button");
		tabbedPane.addTab("New tab", null, button, null);
		
		JButton btnSat = new JButton("SAT");
		tabbedPane.addTab("New tab", null, btnSat, null);

	}

}
