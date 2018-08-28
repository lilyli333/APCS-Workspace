import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
/**
 * https://stackoverflow.com/questions/17314253/simple-jframe-with-a-combobox-and-a-textfield-and-a-result-in-a-label
 * @author maqjav (StackOverflow)
 *
 */
public class CollegeChanceCalculatorScreen extends JPanel {

    private JPanel SATPanel = new JPanel();
	private JPanel ACTPanel = new JPanel();
	
	private JTextField SATreading = new JTextField();
	private JTextField SATmath = new JTextField();
	
	private JTextField ACTreading = new JTextField();
	private JTextField ACTmath = new JTextField();
	
	private JLabel SATreadingLabel = new JLabel("reading score");
	private JLabel SATmathLabel = new JLabel("math score");
	
	private JLabel ACTreadingLabel = new JLabel("reading score");
	private JLabel ACTmathLabel = new JLabel("math score");
	
	JTabbedPane tabbedPane = new JTabbedPane();
	private final JTextField textField = new JTextField();

    public CollegeChanceCalculatorScreen() {
        super();
		this.setLayout(null);

        textField.setColumns(10);
        JPanel labelPanel = new JPanel(new FlowLayout()); 
        
        //new GridLayout(2, 2, 3, 3))
//        add(labelPanel, BorderLayout.EAST);

//        JPanel fieldPanel = new JPanel(); 
//        fieldPanel.setLayout(null);
//        add(fieldPanel, BorderLayout.WEST);

        SATPanel.add(SATreadingLabel);
        SATPanel.add(SATreading);
        SATPanel.add(SATmathLabel);
        SATPanel.add(SATmath);
        
        ACTPanel.add(ACTreadingLabel);
		ACTPanel.add(ACTreading);
        ACTPanel.add(ACTmathLabel);
		ACTPanel.add(ACTmath);
			
		tabbedPane.add("SAT", SATPanel);
		tabbedPane.add("ACT", ACTPanel);

        JLabel searchCollege = new JLabel("Search for college");
        JLabel selectCollege = new JLabel("Select college from list below");

        labelPanel.add(searchCollege);
        labelPanel.add(selectCollege);
        
        labelPanel.add(textField);
        
		add(tabbedPane, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
		
    	CollegeChanceCalculatorScreen tp = new CollegeChanceCalculatorScreen();
		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(tp);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(600,400);
		frame.setVisible(true);
	}
}