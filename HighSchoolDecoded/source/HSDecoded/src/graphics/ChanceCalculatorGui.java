package graphics;
/**
 * graphics for calculating college admission chances given SAT or ACT scores
 * @author Lily
 */
import javax.swing.JPanel;
import college.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.imageio.ImageIO;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ChanceCalculatorGui extends JPanel {
	private JFrame frame;
	private JPanel contentPane;
	private JTextField SATtxtMath;
	private JTextField SATtxtReading;
	private JTextField txtCollege;

	private int SATtotalTestScore = 0;
	private int ACTtotalTestScore = 0;
	private JLabel lblSATTotal = new JLabel("");
	private JLabel lblACTTotal = new JLabel("");
	private JPanel displayCollegeInfoPanel = new JPanel();
	private JPanel collegePanel = new JPanel();

	private JLabel chanceLabel = new JLabel("");



	/**
	 * Creates the window and initializes the contents of the window.
	 */
	public ChanceCalculatorGui() {

		System.out.println("printing colleges");


		displayCollegeInfoPanel.setLayout(new FlowLayout());

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 650, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.setVisible(true);

		setBackground(new Color(240, 255, 255));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(6, 6, 627, 59);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("COLLEGE SEARCH");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Copperplate", Font.PLAIN, 41));
		lblNewLabel.setBounds(21, 6, 443, 47);
		panel.add(lblNewLabel);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(16, 77, 288, 164);
		contentPane.add(tabbedPane);		

		//sat pane
		JPanel SATPane = new JPanel();
		tabbedPane.addTab("SAT", null, SATPane, null);

		JLabel SATlblMathScore = new JLabel("Math Score:");
		JLabel SATlblCriticalReadingLabel = new JLabel("Critical Reading Score:");

		SATPane.add(SATlblMathScore);
		SATPane.add(SATlblCriticalReadingLabel);



		SATtxtMath = new JTextField();
		SATtxtMath.getDocument().addDocumentListener(new DocumentListener()
		{

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try  
				{  
					SATtotalTestScore = Integer.parseInt(SATtxtReading.getText()) + Integer.parseInt(SATtxtMath.getText());
					lblSATTotal.setText("Total Score: " + SATtotalTestScore);
					SATPane.add(lblSATTotal);
					collegePanel.revalidate();
					collegePanel.repaint();

				}  
				catch(NumberFormatException ex)  
				{  
				}  
				catch(NullPointerException ex) {

				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try  
				{  
					SATtotalTestScore = Integer.parseInt(SATtxtReading.getText()) + Integer.parseInt(SATtxtMath.getText());
					lblSATTotal.setText("Total Score: " + SATtotalTestScore);
					SATPane.add(lblSATTotal);
					collegePanel.revalidate();
					collegePanel.repaint();

				}  
				catch(NumberFormatException ex)  
				{  
				}  
				catch(NullPointerException ex) {

				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try  
				{  
					SATtotalTestScore = Integer.parseInt(SATtxtReading.getText()) + Integer.parseInt(SATtxtMath.getText());
					lblSATTotal.setText("Total Score: " + SATtotalTestScore);
					SATPane.add(lblSATTotal);
					collegePanel.revalidate();
					collegePanel.repaint();

				}  
				catch(NumberFormatException ex)  
				{  
				}  
				catch(NullPointerException ex) {

				}

			}
		} );
		SATtxtMath.setText("0");
		SATPane.add(SATtxtMath);
		SATtxtMath.setColumns(10);
		SATPane.add(SATlblCriticalReadingLabel);

		SATtxtReading = new JTextField();
		SATtxtReading.getDocument().addDocumentListener(new DocumentListener()
		{

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try  
				{  
					SATtotalTestScore = Integer.parseInt(SATtxtReading.getText()) + Integer.parseInt(SATtxtMath.getText());
					lblSATTotal.setText("Total Score: " + SATtotalTestScore);
					SATPane.add(lblSATTotal);
					collegePanel.revalidate();
					collegePanel.repaint();

				}  
				catch(NumberFormatException exx)  
				{  
				}  
				catch(NullPointerException ex) {

				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try  
				{  
					SATtotalTestScore = Integer.parseInt(SATtxtReading.getText()) + Integer.parseInt(SATtxtMath.getText());
					lblSATTotal.setText("Total Score: " + SATtotalTestScore);
					SATPane.add(lblSATTotal);
					collegePanel.revalidate();
					collegePanel.repaint();

				}  
				catch(NumberFormatException exx)  
				{  
				}  
				catch(NullPointerException ex) {

				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try  
				{  
					SATtotalTestScore = Integer.parseInt(SATtxtReading.getText()) + Integer.parseInt(SATtxtMath.getText());
					lblSATTotal.setText("Total Score: " + SATtotalTestScore);
					SATPane.add(lblSATTotal);
					collegePanel.revalidate();
					collegePanel.repaint();

				}  
				catch(NumberFormatException exx)  
				{  
				}  
				catch(NullPointerException ex) {

				}
			}
		} );
		SATtxtReading.setText("0");
		SATPane.add(SATtxtReading);
		SATtxtReading.setColumns(10);

		//act pane
		JPanel ACTPane = new JPanel();
		tabbedPane.addTab("ACT", null, ACTPane, null);

		JLabel ACTlblMathScore = new JLabel("Math Score:");
		JLabel ACtlblCriticalReadingLabel = new JLabel("English Score:");

		ACTPane.add(ACTlblMathScore);
		ACTPane.add(ACtlblCriticalReadingLabel);

		JTextField ACTtxtMath = new JTextField();
		JTextField ACTtxtReading = new JTextField();
		ACTtxtMath.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try  
				{  
					ACTtotalTestScore = (Integer.parseInt(ACTtxtReading.getText()) + Integer.parseInt(ACTtxtMath.getText()))/2;
					lblACTTotal.setText("Total Score: " + ACTtotalTestScore);
					ACTPane.add(lblACTTotal);		
					collegePanel.revalidate();
					collegePanel.repaint();
				}  
				catch(NumberFormatException exxxx)  
				{  
				}  
				catch(NullPointerException ex) {

				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try  
				{  
					ACTtotalTestScore = (Integer.parseInt(ACTtxtReading.getText()) + Integer.parseInt(ACTtxtMath.getText()))/2;
					lblACTTotal.setText("Total Score: " + ACTtotalTestScore);
					ACTPane.add(lblACTTotal);		
					collegePanel.revalidate();
					collegePanel.repaint();
				}  
				catch(NumberFormatException exxxx)  
				{  
				}  
				catch(NullPointerException ex) {

				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try  
				{  
					ACTtotalTestScore = (Integer.parseInt(ACTtxtReading.getText()) + Integer.parseInt(ACTtxtMath.getText()))/2;
					lblACTTotal.setText("Total Score: " + ACTtotalTestScore);
					ACTPane.add(lblACTTotal);		
					collegePanel.revalidate();
					collegePanel.repaint();
				}  
				catch(NumberFormatException exxxx)  
				{  
				}  
				catch(NullPointerException ex) {

				}

			}
		} );
		ACTtxtMath.setText("0");
		ACTPane.add(ACTtxtMath);
		ACTtxtMath.setColumns(10);
		ACTPane.add(ACtlblCriticalReadingLabel);

		ACTtxtReading.setText("0");
		ACTtxtReading.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try  
				{  
					ACTtotalTestScore = (Integer.parseInt(ACTtxtReading.getText()) + Integer.parseInt(ACTtxtMath.getText()))/2;
					lblACTTotal.setText("Total Score: " + ACTtotalTestScore);
					ACTPane.add(lblACTTotal);
					collegePanel.revalidate();
					collegePanel.repaint();

				}  
				catch(NumberFormatException exxxx)  
				{  
				}  
				catch(NullPointerException ex) {

				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try  
				{  
					ACTtotalTestScore = (Integer.parseInt(ACTtxtReading.getText()) + Integer.parseInt(ACTtxtMath.getText()))/2;
					lblACTTotal.setText("Total Score: " + ACTtotalTestScore);
					ACTPane.add(lblACTTotal);
					collegePanel.revalidate();
					collegePanel.repaint();

				}  
				catch(NumberFormatException exxxx)  
				{  
				}  
				catch(NullPointerException ex) {

				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try  
				{  
					ACTtotalTestScore = (Integer.parseInt(ACTtxtReading.getText()) + Integer.parseInt(ACTtxtMath.getText()))/2;
					lblACTTotal.setText("Total Score: " + ACTtotalTestScore);
					ACTPane.add(lblACTTotal);
					collegePanel.revalidate();
					collegePanel.repaint();

				}  
				catch(NumberFormatException exxxx)  
				{  
				} 
				catch(NullPointerException ex) {

				}
			}
		} );
		ACTPane.add(ACTtxtReading);
		ACTtxtReading.setColumns(10);

		displayCollegeInfoPanel.setBounds(316, 77, 317, 584);
		contentPane.add(displayCollegeInfoPanel);

		collegePanel.setBounds(26, 253, 278, 408);
		contentPane.add(collegePanel);

		JLabel lblSearchColleges = new JLabel("Search Colleges:");
		collegePanel.add(lblSearchColleges);

		JLabel lblEnterCollegeName = new JLabel("Enter College Name");
		collegePanel.add(lblEnterCollegeName);

		txtCollege = new JTextField();
		txtCollege.setText("college");
		collegePanel.add(txtCollege);
		txtCollege.setColumns(10);

		JButton btnSearch = new JButton("Search");
		collegePanel.add(btnSearch);
		JLabel loading = new JLabel(new ImageIcon("loader.gif"));	
		loading.setHorizontalAlignment(JLabel.CENTER);
		loading.setVerticalAlignment(JLabel.CENTER);

		btnSearch.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("should be loading");
				collegePanel.add(loading);
				collegePanel.revalidate();
				displayCollegeInfoPanel.removeAll(); 
				displayCollegeInfoPanel.repaint(); 

				Thread thread = new Thread(){
					public void run(){
						SearchFunction newSearch;


						if(tabbedPane.getSelectedIndex() == 1) {
							newSearch = new SearchFunction(txtCollege.getText(), (double)SATtotalTestScore, true);
						}
						else {
							newSearch = new SearchFunction(txtCollege.getText(), (double)ACTtotalTestScore, false);
						}

						if(!newSearch.getSuccess()){
							JOptionPane.showMessageDialog(frame, "search not successful, please try again");
							collegePanel.removeAll();
							collegePanel.add(loading);
							collegePanel.add(lblSearchColleges);
							collegePanel.add(loading);
							collegePanel.add(lblEnterCollegeName);
							collegePanel.add(txtCollege);
							collegePanel.add(btnSearch);
						}

						collegePanel.removeAll();
						collegePanel.add(loading);
						collegePanel.add(lblSearchColleges);
						collegePanel.add(lblEnterCollegeName);
						collegePanel.add(txtCollege);
						collegePanel.add(btnSearch);
						collegePanel.repaint();

						ArrayList<School> schools = newSearch.getSchools();

						for(int i = 0; i < schools.size(); i ++) {
							School school = schools.get(i);

							System.out.println("schooool: "  + school.getName());
							JButton schoolBtn = new JButton(school.getName());
							schoolBtn.setBounds(50, 50 * i + 100, 500, 30);
							collegePanel.add(schoolBtn);
							schoolBtn.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									displayCollegeInfoPanel.removeAll(); 
									displayCollegeInfoPanel.repaint();
									displaySchoolInfo(school, tabbedPane.getSelectedIndex() == 0);
								}

							});
						}


						//				collegePanel.revalidate();
						//				collegePanel.repaint();
						collegePanel.remove(loading);
						collegePanel.updateUI();
						displayCollegeInfoPanel.updateUI();
					}
				};
				thread.start();		
			}


		});


	}

	public void displaySchoolInfo(School school, boolean SATScores) {
		displayCollegeInfoPanel.removeAll();
		System.out.println("button pressed");
		JLabel nameLabel = new JLabel(school.getName());
		nameLabel.setBounds(10, 50, 500,30);
		displayCollegeInfoPanel.add(nameLabel);

		JLabel admissionLabel = new JLabel("admission rate: " + school.getAdmissionRate());
		admissionLabel.setBounds(10, 80, 500,30);
		displayCollegeInfoPanel.add(admissionLabel);

		JLabel location = new JLabel("location: " + school.getLocation());
		System.out.println("location " + school.getLocation());
		location.setBounds(10, 120, 500,30);
		displayCollegeInfoPanel.add(location);

		JButton chanceCalculatorBtn = new JButton("calculate chances");
		chanceCalculatorBtn.setBounds(10, 150, 100,30);
		displayCollegeInfoPanel.add(chanceCalculatorBtn);

		chanceCalculatorBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				double chance;
				if(SATScores) {
					chance = calculateChance(true, school, SATtotalTestScore);
					System.out.println("true");
				}
				else {
					System.out.println("false");
					chance = calculateChance(false, school, ACTtotalTestScore);
				}
				displayCollegeInfoPanel.updateUI();		

				chanceLabel.setText("Calculated chance: " + chance + "%");
				displayCollegeInfoPanel.add(chanceLabel);
			}

		});
	}
	/**
	 * 
	 * @param SATScoreReport boolean set to true if score report is given for SAT, false if score report is given for ACT
	 * @param selectedSchool school entity of the selected school
	 * @param totalTestScore the total (SAT) or average (ACT) score to calculate chances to
	 * @return returns double between 0 to 100 percent for the prediction admission chance 
	 */
	public double calculateChance(boolean SATScoreReport, School selectedSchool, double totalTestScore) {

		double at25, atMidpoint, at75, admissionRate;

		admissionRate = selectedSchool.getAdmissionRate();

		if(SATScoreReport) {
			at25 = selectedSchool.getStats().getSATScores(0).getTotalScore();
			atMidpoint = selectedSchool.getStats().getSATScores(1).getTotalScore();
			at75 = selectedSchool.getStats().getSATScores(2).getTotalScore();

			System.out.println("at25: " + at25 + ", atMidpoint: " + atMidpoint + ", at75:" + at75);
		}
		else {
			at25 = selectedSchool.getStats().getACTScores(0).getTotalScore();
			atMidpoint = selectedSchool.getStats().getACTScores(1).getTotalScore();
			at75 = selectedSchool.getStats().getACTScores(2).getTotalScore();
			System.out.println("act");
		}
		double chance = 0.0;
		if(totalTestScore < at25) {
			chance = (totalTestScore + 1)/(at25)*admissionRate * 0.025  * 100;		
		}
		else if(totalTestScore < atMidpoint) {
			System.out.println((totalTestScore - at25 + 1)/(atMidpoint - at25)*admissionRate * 0.75 * 100);
			chance = (totalTestScore - at25 + 1)/(atMidpoint - at25)*admissionRate * 0.75 * 100;		
		}
		else if((int) totalTestScore == (int)atMidpoint) {
			chance = admissionRate * 100;
		}
		else if(totalTestScore < at75) {
			chance = (1+ (totalTestScore - atMidpoint + 1)/(at75 - atMidpoint))*admissionRate * 100;
		}
		else{
			if(SATScoreReport)
				chance =  (1 + (totalTestScore - at75 + 1)/(1600 - at75))*admissionRate *100;
			else
				chance = (1 + (totalTestScore - at75)/(36 - at75))*admissionRate * 100;
		}
		if(chance < 0.0001) {
			chance = 0.0;
		}
		return chance;
	}
}
