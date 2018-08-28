package graphics;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import college.ChanceCalculator;
import college.GPACalc;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * graphics representing buttons leading to different calculators
 * @author Lily
 */
public class CollegesGui extends JPanel {
	private JFrame frame;

	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CollegesGui frame = new CollegesGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creates the window and initializes the contents of the window.
	 */
	public CollegesGui(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 650, 75);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout());
		frame.setVisible(true);
		
		JButton btnAdmissionsChanceCalculator = new JButton("Admissions Chance Calculator");
		contentPane.add(btnAdmissionsChanceCalculator);
		
		btnAdmissionsChanceCalculator.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ChanceCalculatorGui window = new ChanceCalculatorGui();
				frame.getContentPane().add(window);
			}
		});
		
		JButton btnGradesfinalsCalculator = new JButton("Grades/Finals Calculator");
		contentPane.add(btnGradesfinalsCalculator);
		btnGradesfinalsCalculator.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GPACalculatorGui window = new GPACalculatorGui();
				frame.getContentPane().add(window);
			}
		});
		
		JButton btnMajorsList = new JButton("Majors List");
		contentPane.add(btnMajorsList);
		
		btnMajorsList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MajorGui window = new MajorGui();
				frame.getContentPane().add(window);
			}
		});
	}

}
