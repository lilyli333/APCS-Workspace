package graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument.Content;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

public class GradesGui extends JPanel {
	private JFrame frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Create the window and initializes the contents of the window.
	 */
	public GradesGui() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 650, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(6, 6, 638, 56);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Grades");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setBounds(229, 6, 210, 44);
		panel.add(lblNewLabel);
		
		JLabel lblMath = new JLabel("Math");
		lblMath.setBounds(70, 93, 155, 23);
		contentPane.add(lblMath);
		
		textField = new JTextField();
		textField.setBounds(308, 91, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEnglish = new JLabel("English");
		lblEnglish.setBounds(70, 151, 155, 23);
		contentPane.add(lblEnglish);
		
		JLabel lblScience = new JLabel("Science");
		lblScience.setBounds(70, 209, 155, 23);
		contentPane.add(lblScience);
		
		JLabel lblSocialScience = new JLabel("Social Studies");
		lblSocialScience.setBounds(70, 270, 155, 23);
		contentPane.add(lblSocialScience);
		
		JLabel lblPhysicalEducation = new JLabel("Physical Education");
		lblPhysicalEducation.setBounds(70, 346, 155, 23);
		contentPane.add(lblPhysicalEducation);
		
		JLabel lblFineArts = new JLabel("Fine Arts");
		lblFineArts.setBounds(70, 426, 155, 23);
		contentPane.add(lblFineArts);
		
		JLabel lblAppliedArts = new JLabel("Applied Arts");
		lblAppliedArts.setBounds(70, 497, 155, 23);
		contentPane.add(lblAppliedArts);
		
		JLabel lblOtherElective = new JLabel("Other Elective");
		lblOtherElective.setBounds(70, 569, 155, 23);
		contentPane.add(lblOtherElective);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(308, 149, 130, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(308, 207, 130, 26);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(308, 268, 130, 26);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(308, 344, 130, 26);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(308, 424, 130, 26);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(308, 495, 130, 26);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(308, 567, 130, 26);
		contentPane.add(textField_7);
		frame.setVisible(true);

	}
}
