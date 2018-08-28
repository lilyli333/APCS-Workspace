package graphics;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import loginSystem.Dashboard;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ClassesGui extends JPanel {

	/**
	 * This class represents the graphics interface for entering classes and grades for those classes
	 * by the user. This information is then displayed on the Dashboard window under the current grades
	 * panel.
	 * 
	 * 
	 * @author Helen (graphics), Anushka (database)
	 * @version 05/22/18
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel contentPane;
	private JTextField mathField;
	private JTextField scienceField;
	private JTextField socialField;
	private JTextField peField;
	private JTextField fineAField;
	private JTextField appliedField;
	private JTextField englishField;
	private JTextField englishGrade;
	private JTextField mathGrade;
	private JTextField scienceGrade;
	private JTextField socialGrade;
	private JTextField peGrade;
	private JTextField fineAGrade;
	private JTextField appliedGrade;
	private JTextField otherField;
	private JTextField otherGrade;
	private JPanel panel_2;
	private static Connection con = null;

	/**
	 * Creates the window and initializes the contents of the window.
	 */
	public ClassesGui() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 650, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(65, 105, 225));
		panel.setBounds(6, 6, 638, 65);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ClassesGui.class.getResource("/Resource/ps_classes.jpg")));
		lblNewLabel.setBounds(6, 6, 54, 53);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Your classes Here");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblNewLabel_1.setBounds(169, 16, 366, 31);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(6, 83, 638, 596);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblEnglish = new JLabel("English");
		lblEnglish.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblEnglish.setBounds(55, 42, 101, 29);
		panel_1.add(lblEnglish);
		
		JLabel lblMathematics = new JLabel("Mathematics");
		lblMathematics.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblMathematics.setBounds(55, 107, 121, 29);
		panel_1.add(lblMathematics);
		
		JLabel lblScience = new JLabel("Science");
		lblScience.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblScience.setBounds(55, 177, 101, 29);
		panel_1.add(lblScience);
		
		JLabel lblSocialScience = new JLabel("Social Studies");
		lblSocialScience.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblSocialScience.setBounds(55, 241, 121, 29);
		panel_1.add(lblSocialScience);
		
		JLabel lblPhysicalEducation = new JLabel("Physical Education");
		lblPhysicalEducation.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblPhysicalEducation.setBounds(55, 319, 175, 29);
		panel_1.add(lblPhysicalEducation);
		
		JLabel lblFineArts = new JLabel("Fine Arts");
		lblFineArts.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblFineArts.setBounds(55, 386, 101, 29);
		panel_1.add(lblFineArts);
		
		JLabel lblAppliedArts = new JLabel("Applied Arts");
		lblAppliedArts.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblAppliedArts.setBounds(55, 452, 144, 29);
		panel_1.add(lblAppliedArts);
		
		mathField = new JTextField();
		mathField.setBounds(270, 110, 130, 26);
		panel_1.add(mathField);
		mathField.setColumns(10);
		
		scienceField = new JTextField();
		scienceField.setColumns(10);
		scienceField.setBounds(270, 180, 130, 26);
		panel_1.add(scienceField);
		
		socialField = new JTextField();
		socialField.setColumns(10);
		socialField.setBounds(270, 244, 130, 26);
		panel_1.add(socialField);
		
		peField = new JTextField();
		peField.setColumns(10);
		peField.setBounds(270, 322, 130, 26);
		panel_1.add(peField);
		
		fineAField = new JTextField();
		fineAField.setColumns(10);
		fineAField.setBounds(270, 389, 130, 26);
		panel_1.add(fineAField);
		
		appliedField = new JTextField();
		appliedField.setColumns(10);
		appliedField.setBounds(270, 455, 130, 26);
		panel_1.add(appliedField);
		
		englishField = new JTextField();
		englishField.setColumns(10);
		englishField.setBounds(270, 45, 130, 26);
		panel_1.add(englishField);
		
		JLabel lblNewLabel_3 = new JLabel("Subjects");
		lblNewLabel_3.setBounds(307, 17, 101, 16);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblGrades = new JLabel("Grades");
		lblGrades.setBounds(487, 17, 101, 16);
		panel_1.add(lblGrades);
		
		englishGrade = new JTextField();
		englishGrade.setBounds(467, 45, 87, 26);
		panel_1.add(englishGrade);
		englishGrade.setColumns(10);
		
		mathGrade = new JTextField();
		mathGrade.setColumns(10);
		mathGrade.setBounds(467, 110, 87, 26);
		panel_1.add(mathGrade);
		
		scienceGrade = new JTextField();
		scienceGrade.setColumns(10);
		scienceGrade.setBounds(467, 180, 87, 26);
		panel_1.add(scienceGrade);
		
		socialGrade = new JTextField();
		socialGrade.setColumns(10);
		socialGrade.setBounds(467, 244, 87, 26);
		panel_1.add(socialGrade);
		
		peGrade = new JTextField();
		peGrade.setColumns(10);
		peGrade.setBounds(467, 322, 87, 26);
		panel_1.add(peGrade);
		
		fineAGrade = new JTextField();
		fineAGrade.setColumns(10);
		fineAGrade.setBounds(467, 389, 87, 26);
		panel_1.add(fineAGrade);
		
		appliedGrade = new JTextField();
		appliedGrade.setColumns(10);
		appliedGrade.setBounds(467, 455, 87, 26);
		panel_1.add(appliedGrade);
		
		JLabel lblOtherElective = new JLabel("Other Elective");
		lblOtherElective.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblOtherElective.setBounds(55, 524, 144, 29);
		panel_1.add(lblOtherElective);
		
		otherField = new JTextField();
		otherField.setColumns(10);
		otherField.setBounds(270, 527, 130, 26);
		panel_1.add(otherField);
		
		otherGrade = new JTextField();
		otherGrade.setColumns(10);
		otherGrade.setBounds(467, 527, 87, 26);
		panel_1.add(otherGrade);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 255));
		panel_2.setBounds(280, 565, 132, 29);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(6, 0, 117, 29);
		panel_2.add(btnSubmit);
		btnSubmit.setBackground(new Color(0, 0, 255));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					Connection con =null;
					PreparedStatement stmt = null;
					Statement st = null;
					ResultSet  rs = null;
					
					//clear previous record from department
					String query = "DELETE FROM DEPARTMENT";
					try {
						con = AssignmentGui.getConnection();
						stmt = con.prepareStatement(query);
						stmt.execute();
					} catch (SQLException e5) {
						
						e5.printStackTrace();
					}
					//add new information to department
					String sql = "INSERT INTO DEPARTMENT(class,subjects,grades)"
						    + " values(?,?,?)";
					try {
						if(englishGrade.getText().toString().length() > 1 && !checkValidInpput(englishGrade.getText().toString())) {
							JOptionPane.showMessageDialog(null,"Enter Valid Character");
							return;
						}else {
						con = DriverManager.getConnection("jdbc:h2:"+"./Database/my","root","mypassword");
						stmt = con.prepareStatement(sql);
						stmt.setString(1,lblEnglish.getText());
						stmt.setString(2,englishField.getText());
						stmt.setString(3,englishGrade.getText());
						stmt.executeUpdate();
						Dashboard.getTextArea_1().setText(lblEnglish.getText()+": \n" +englishField.getText()+": \n"+englishGrade.getText()+"\n");
						}
						if(mathGrade.getText().toString().length() > 1 && !checkValidInpput(mathGrade.getText().toString())) {
							JOptionPane.showMessageDialog(null,"Enter Valid Character");
							return;
						}else {
						stmt.setString(1,lblMathematics.getText());
						stmt.setString(2,mathField.getText());
						stmt.setString(3,mathGrade.getText());
						stmt.executeUpdate();
						Dashboard.getTextArea_1().append(lblMathematics.getText()+": \n" +mathField.getText()+": \n"+mathGrade.getText()+"\n");
						}
						if(scienceGrade.getText().toString().length() > 1 && !checkValidInpput(scienceGrade.getText().toString())) {
							JOptionPane.showMessageDialog(null,"Enter Valid Character");
							return;
						}else {
						stmt.setString(1,lblScience.getText());
						stmt.setString(2,scienceField.getText());
						stmt.setString(3,scienceGrade.getText());
						stmt.executeUpdate();
						Dashboard.getTextArea_1().append(lblScience.getText()+": \n" +scienceField.getText()+": \n"+scienceGrade.getText()+"\n");
						}
						if(socialGrade.getText().toString().length() > 1 && !checkValidInpput(socialGrade.getText().toString())) {
							JOptionPane.showMessageDialog(null,"Enter Valid Character");
							return;
						}else {
						stmt.setString(1,lblSocialScience.getText());
						stmt.setString(2,socialField.getText());
						stmt.setString(3,socialGrade.getText());
						stmt.executeUpdate();
						Dashboard.getTextArea_1().append(lblSocialScience.getText()+": \n" +socialField.getText()+": \n"+socialGrade.getText()+"\n");
						}
						if(peGrade.getText().toString().length() > 1 && !checkValidInpput(peGrade.getText().toString())) {
							JOptionPane.showMessageDialog(null,"Enter Valid Character");
							return;
						}else {
						stmt.setString(1,lblPhysicalEducation.getText());
						stmt.setString(2,peField.getText());
						stmt.setString(3,peGrade.getText());
						stmt.executeUpdate();
						Dashboard.getTextArea_1().append(lblPhysicalEducation.getText()+": \n" +peField.getText()+": \n"+peGrade.getText()+"\n");
						
						}
						if(fineAGrade.getText().toString().length() > 1 && !checkValidInpput(fineAGrade.getText().toString())) {
							JOptionPane.showMessageDialog(null,"Enter Valid Character");
							return;
						}else {
						stmt.setString(1,lblFineArts.getText());
						stmt.setString(2,fineAField.getText());
						stmt.setString(3,fineAGrade.getText());
						stmt.executeUpdate();
						Dashboard.getTextArea_1().append(lblFineArts.getText()+": \n" +fineAField.getText()+": \n"+fineAGrade.getText()+"\n");
						}
						if(lblAppliedArts.getText().toString().length() > 1 && !checkValidInpput(appliedGrade.getText().toString())) {
							JOptionPane.showMessageDialog(null,"Enter Valid Character");
							return;
						}else {
						stmt.setString(1,lblAppliedArts.getText());
						stmt.setString(2,appliedField.getText());
						stmt.setString(3,appliedGrade.getText());
						stmt.executeUpdate();
						Dashboard.getTextArea_1().append(lblAppliedArts.getText()+": \n" +appliedField.getText()+": \n"+appliedGrade.getText()+"\n");
						}
						if(lblAppliedArts.getText().toString().length() > 1 && !checkValidInpput(otherGrade.getText().toString())) {
							JOptionPane.showMessageDialog(null,"Enter Valid Character");
							return;
						}else {
						stmt.setString(1,lblOtherElective.getText());
						stmt.setString(2,otherField.getText());
						stmt.setString(3,otherGrade.getText());
						stmt.executeUpdate();
						}
						
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
					finally {
						try {
							stmt.close();
							st.close();
							rs.close();
						} catch (SQLException e2) {
							
							e2.printStackTrace();
						}
						frame.dispose();
					}
				}
			//checks grades info for proper input
			private boolean checkValidInpput(String s) {
				
				switch(s) {
				case "A" : return true;
				case "a" : return true;
				case "B" : return true;
				case "b" : return true;
				case "C" : return true;
				case "c" : return true;
				case "D" : return true;
				case "d" : return true;
				case "E" : return true;
				case "e" : return true;
				case "F" : return true;
				case "f" : return true;
				case "p":return true;
				case "P":return true;
				default:return false;
				
				}
				
			}
		
		});
		
	}
	
	/**
	 * Reads information from the department database table, and displays it on Dashboard
	 */
	public static void readDepartmentToText(){
		try{

			con = getConnection();
			String query = "SELECT * FROM DEPARTMENT";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			Dashboard.getTextArea_1().setText("");
			while(rs.next()){

				Dashboard.getTextArea_1().append(rs.getString("class")+": \n" +rs.getString("subjects")+": \n"+rs.getString("grades")+"\n");
			}

		}
		catch(Exception e){

			JOptionPane.showMessageDialog(null , e);
		}

	}
	//gets the connection from database
	private static Connection getConnection() {
		try {
			if(con == null)
			 con = DriverManager.getConnection("jdbc:h2:"+"./Database/my","root","mypassword");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
		
	}
	
}
