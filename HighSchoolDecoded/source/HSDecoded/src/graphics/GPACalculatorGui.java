package graphics;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import college.GPACalc;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

/**
 * graphics to calculate weighted/unweighted/finals scores
 * @author Lily
 */
public class GPACalculatorGui extends JPanel {

	private JPanel contentPane;
	private JFrame frame;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GPACalculatorGui frame = new GPACalculatorGui();
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
	public GPACalculatorGui() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 650, 200);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblGradeCalculators = new JLabel("Grade Calculators");
		panel.add(lblGradeCalculators);
		
		JTabbedPane tabbedPane = new JTabbedPane();
		contentPane.add(tabbedPane);
		
		JPanel weightedPanel = new JPanel();
		JPanel unweightedPanel = new JPanel();
		JPanel finalsPanel = new JPanel();
		
		tabbedPane.addTab("Weighted GPA Calculator", null, weightedPanel, null);
		tabbedPane.addTab("Unweighted GPA Calculator", null, unweightedPanel, null);
		tabbedPane.addTab("Finals Grade Calculator", null, finalsPanel, null);
		
		/*
		 * weighted panel
		 */
		JLabel weightA = new JLabel("# of 'A' grades received");
		JLabel weightB = new JLabel("# of 'B' grades received");
		JLabel weightC = new JLabel("# of 'C' grades received");
		JLabel weightD = new JLabel("# of 'D' grades received");
		JLabel weightF = new JLabel("# of 'F' grades received");
		JLabel weightHonor = new JLabel("# of honors or AP classes taken");
		
		JTextField fieldWeightA = new JTextField("#");
		JTextField fieldWeightB = new JTextField("#");
		JTextField fieldWeightC = new JTextField("#");
		JTextField fieldWeightD = new JTextField("#");
		JTextField fieldWeightF = new JTextField("#");
		JTextField fieldWeightHonor = new JTextField("#");
		
		weightedPanel.add(weightA);
		weightedPanel.add(fieldWeightA);
		weightedPanel.add(weightB);
		weightedPanel.add(fieldWeightB);
		weightedPanel.add(weightC);
		weightedPanel.add(fieldWeightC);
		weightedPanel.add(weightD);
		weightedPanel.add(fieldWeightD);
		weightedPanel.add(weightF);
		weightedPanel.add(fieldWeightF);
		weightedPanel.add(weightHonor);
		weightedPanel.add(fieldWeightHonor);
		
		JLabel calcLabel = new JLabel("");
		
		JButton btnWeightCalculate = new JButton("calculate weighted GPA");
		weightedPanel.add(btnWeightCalculate);
		weightedPanel.add(calcLabel);
		btnWeightCalculate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				double calculatedGPA = GPACalc.weightedGPA(Integer.parseInt(fieldWeightA.getText()), Integer.parseInt(fieldWeightB.getText()), Integer.parseInt(fieldWeightC.getText()), Integer.parseInt(fieldWeightD.getText()), Integer.parseInt(fieldWeightF.getText()), Integer.parseInt(fieldWeightHonor.getText()));
				calcLabel.setText("weighted GPA: " + calculatedGPA);
			}
		});
		
		/*
		 * unweighted panel
		 */
		JLabel unweightA = new JLabel("# of 'A' grades received");
		JLabel unweightB = new JLabel("# of 'B' grades received");
		JLabel unweightC = new JLabel("# of 'C' grades received");
		JLabel unweightD = new JLabel("# of 'D' grades received");
		JLabel unweightF = new JLabel("# of 'F' grades received");
		
		JTextField fieldUnweightA = new JTextField("#");
		JTextField fieldUnweightB = new JTextField("#");
		JTextField fieldUnweightC = new JTextField("#");
		JTextField fieldUnweightD = new JTextField("#");
		JTextField fieldUnweightF = new JTextField("#");
		
		unweightedPanel.add(unweightA);
		unweightedPanel.add(fieldUnweightA);
		unweightedPanel.add(unweightB);
		unweightedPanel.add(fieldUnweightB);
		unweightedPanel.add(unweightC);
		unweightedPanel.add(fieldUnweightC);
		unweightedPanel.add(unweightD);
		unweightedPanel.add(fieldUnweightD);
		unweightedPanel.add(unweightF);
		unweightedPanel.add(fieldUnweightF);
		
		JLabel uncalcLabel = new JLabel("");
		
		JButton btnUnweightCalculate = new JButton("calculate unweighted GPA");
		unweightedPanel.add(btnUnweightCalculate);
		unweightedPanel.add(uncalcLabel);
		btnUnweightCalculate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				double calculatedGPA = GPACalc.calcGPA(Integer.parseInt(fieldUnweightA.getText()), Integer.parseInt(fieldUnweightB.getText()), Integer.parseInt(fieldUnweightC.getText()), Integer.parseInt(fieldUnweightD.getText()), Integer.parseInt(fieldUnweightF.getText()));
				uncalcLabel.setText("unweighted GPA: " + calculatedGPA);
			}
		});
		
		/*
		 * finals grade calculator
		 */
		
		JLabel currentGrade = new JLabel("current grade in class");
		JLabel wantedGrade = new JLabel("grade wated in class");
		JLabel examWorth = new JLabel("% of exam");
		
		JTextField fieldCurrentGrade = new JTextField("#");
		JTextField fieldWantedGrade = new JTextField("#");
		JTextField fieldExamWorth = new JTextField("#");
		
		finalsPanel.add(currentGrade);
		finalsPanel.add(fieldCurrentGrade);
		finalsPanel.add(wantedGrade);
		finalsPanel.add(fieldWantedGrade);
		finalsPanel.add(examWorth);
		finalsPanel.add(fieldExamWorth);
		
		JButton btnCalculateFinal = new JButton("calculate % needed on final");
		
		finalsPanel.add(btnCalculateFinal);
		
		JLabel finalsCalculatedLabel = new JLabel("");
		
		finalsPanel.add(finalsCalculatedLabel);
		btnCalculateFinal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				double calculatedGPA = GPACalc.finalsGradesCalculator(Double.parseDouble(fieldCurrentGrade.getText()), Double.parseDouble(fieldWantedGrade.getText()), Double.parseDouble(fieldExamWorth.getText()));
				finalsCalculatedLabel.setText("% needed on final: " + calculatedGPA + "%");
			}
		});
	}

}
