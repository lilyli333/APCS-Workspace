import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Screen {

	private JFrame frame;
	private JTextField testScore;
	private JTextField  GPA;
	private JComboBox testType;
	private String[] testTypeChoices;
	private JLabel enterTestScore, enterGPA, enterCollegeCity;
	private JButton search;

	private final JPanel panel = new JPanel();

	public Screen() {
		frame = new JFrame("College Chance Calculator");
		frame.setVisible(true);
		frame.setSize(1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(new FlowLayout());
		frame.setLayout(new FlowLayout());
		
		panel.setSize(1000,600);
		panel.setBackground(Color.magenta);
		//		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); 

		search = new JButton("search");
		enterTestScore = new JLabel("enter best standardized testing score");
		enterGPA = new JLabel("enter **** GPA");
		enterCollegeCity = new JLabel("search college by city");
		String[] testTypeChoices = { "SAT","ACT"};
		testType = new JComboBox<String>(testTypeChoices);
		ActionListener testTypeActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		};	
		testType.addActionListener(testTypeActionListener);
		testType.setBounds(159, 81, 189, 41);

		panel.add(search);
		panel.add(enterTestScore);
		panel.add(enterGPA);
		panel.add(enterCollegeCity);
		//		panel.add(testType);
		panel.add(testType);
		testType.setVisible(true);

		search.setBounds(100,500, search.preferredSize().width,search.preferredSize().height);
		enterTestScore.setBounds(100,10, enterTestScore.preferredSize().width, enterTestScore.preferredSize().height);
		enterGPA.setBounds(100, 100, enterGPA.preferredSize().width, enterGPA.preferredSize().height);
		enterCollegeCity.setBounds(100, 200, enterCollegeCity.preferredSize().width, enterCollegeCity.preferredSize().height);
		//		testType.setBounds(100, 500, 100, 50);
		frame.getContentPane().add(panel);	
//				frame.pack();
	}

	public void showScreen() {

	}

	public static void main(String[] args) {
		Screen sc = new Screen();
	}

}
