import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

public class TestScoreTab extends JPanel{

	JPanel SATPanel = new JPanel();
	JPanel ACTPanel = new JPanel();

	JLabel ACTLabel = new JLabel("ACT");
	JLabel SATLabel = new JLabel("SAT");

	JTabbedPane tabbedPane = new JTabbedPane();

	public TestScoreTab(){
		SATPanel.add(SATLabel);
		ACTPanel.add(ACTLabel);

		tabbedPane.add("SAT", SATPanel);
		tabbedPane.add("ACT", ACTPanel);
		add(tabbedPane);
	}

	public static void main(String[] args) {

		TestScoreTab tp = new TestScoreTab();
		JFrame frame = new JFrame();
		frame.add(tp);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(600,400);
		frame.setVisible(true);
	}
}