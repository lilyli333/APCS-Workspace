package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

/**
 * graphics representing a list of majors
 * @author Lily
 */
public class MajorGui extends JPanel {

	private JPanel contentPane;
	private String[] majors;
	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MajorGui frame = new MajorGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the window and initializes the contents of the window.
	 */
	public MajorGui() {

		majors = new String[] {"Accounting",
				"Actuarial Science",
				"Advertising",
				"Agriculture",
				"Agricultural and Biological Engineering",
				"Agricultural Business Management",
				"Agriculture Economics",
				"Animal Bioscience",
				"Animal Sciences",
				"Anthropology",
				"Applied Mathematics",
				"Archaeology",
				"Architectural Engineering",
				"Architecture",
				"Art History",
				"Studio Art",
				"Art Education",
				"Biobehavioral Health",
				"Biochemistry",
				"Bioengineering",
				"Biology",
				"Biophysics",
				"Biotechnology",
				"Business Administration and Management",
				"Business Logistics",
				"Chemical Engineering",
				"Chemistry",
				"Children",
				"Civil Engineering",
				"Computer Engineering",
				"Computer Science",
				"Crime, Law, and Justice",
				"Dance",
				"Earth Sciences",
				"Economics",
				"Electrical Engineering",
				"Elementary and Kindergarten Education",
				"Engineering Science",
				"English",
				"Environmental Systems Engineering",
				"Environmental Sciences",
				"Environmental Resource Management",
				"Film and Video",
				"Finance",
				"Food Science",
				"Forest Science",
				"Forest Technology",
				"General Science",
				"Geography",
				"Geosciences",
				"Graphic Design and Photography",
				"Health and Physical Education",
				"Health Policy and Administration",
				"History",
				"Horticulture",
				"Hotel, Restaurant, and Institutional Management",
				"Human Development and Family Studies",
				"Individual and Family Studies",
				"Industrial Engineering",
				"Information Sciences and Technology",
				"Journalism",
				"Kinesiology",
				"Landscape Architecture",
				"Law Enforcement and Correction",
				"Marine Biology",
				"Marketing",
				"Mathematics",
				"Mechanical Engineering",
				"Media Studies",
				"Meteorology",
				"Microbiology",
				"Mineral Economics",
				"Modern Languages",
				"Music Education",
				"Nuclear Engineering",
				"Nursing",
				"Nutrition",
				"Philosophy",
				"Physics",
				"Physiology",
				"Political Science",
				"Pre-medicine",
				"Psychology",
				"Public Relations",
				"Real Estate",
				"Recreation and Parks",
				"Rehabilitation Services",
				"Religious Studies",
				"Secondary Education",
				"Sociology",
				"Social Work",
				"Special Education",
				"Speech Communication",
				"Speech Pathology and Audiology/Communication Disorder",
				"Statistics",
				"Telecommunications",
				"Theater",
				"Wildlife and Fishery Science",
				"Wildlife Technology",
		"Women's Studies"};
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		frame.setVisible(true);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblMajors = new JLabel("Majors");
		panel.add(lblMajors);

		JPanel majorPanel = new JPanel();
		JScrollPane scrollPanel = new JScrollPane(majorPanel);
		JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL);
		scrollPanel.setVerticalScrollBar(scrollBar);
//		scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);    
		//		scrollPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		contentPane.add(scrollPanel, BorderLayout.CENTER);
		majorPanel.setLayout(new BoxLayout(majorPanel,BoxLayout.Y_AXIS));
		
		for(int i = 0; i < majors.length; i ++) {
			//			lb.setHorizontalAlignment(JLabel.CENTER);
			JLabel lb = new JLabel(majors[i]);
			
			majorPanel.add(lb);
			//scrollBar.repaint();
		}			
		
		//majorPanel.setBackground(Color.GREEN);
		

	}

}
