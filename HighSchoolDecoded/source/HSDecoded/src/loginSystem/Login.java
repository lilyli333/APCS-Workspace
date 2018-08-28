package loginSystem;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

/**
 * This class represents the graphics interface for when the user logs in. The user must register if it
 * is their first time using the program, but if it is not their first time, the user can directly sign in 
 * with the username and password they provided when registering.
 * 
 * @author Anushka
 * @version 05/22/2018
 */
public class Login extends JPanel {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField studentName;
	private boolean tableCreated = false;
    private static Connection con;
    private JPasswordField passwordField;
    private String userName,password;
    private String user;
	
	/**
	 * Creates the window and initializes the contents of the window.
	 */
	public Login() {
		initialize();
		try {
			con = DriverManager.getConnection("jdbc:h2:"+"./Database/my","root","mypassword");
	    } catch (SQLException e1) {
			e1.printStackTrace();
		}
		//System.out.println("Connection successful");
		if(!tableCreated && con !=null)
			createTables(con);
	}

	 // Initializes the contents of the frame
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(105, 105, 105));
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(89, 132, 94, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Student Login");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBounds(114, 73, 256, 47);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		frame.getContentPane().add(lblNewLabel);
		
		studentName = new JTextField();
		studentName.setBounds(208, 133, 162, 28);
		frame.getContentPane().add(studentName);
		studentName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(89, 203, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				    
				  
					
				    userName =  studentName.getText();
				    password = passwordField.getText();
				    
				   
				    if(userName.equals("") && password.equals(""))
			    		JOptionPane.showConfirmDialog(null, "Enter Username and Password");
				    else if(!userName.equals(null) && !password.equals(null)) {
				    	
				         if(validateUser(con, userName,password)) {
				         
				           Dashboard window = new Dashboard(user);
				    	   frame.add(window);
		    		        
				         }
				          else
				    	      JOptionPane.showMessageDialog(null, "Enter Correct Info");
				    } 
				    frame.dispose();
			}
			
		});
		
		loginButton.setBounds(84, 255, 107, 29);
		frame.getContentPane().add(loginButton);
		
		JButton signInButton = new JButton("Register");
		signInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register window = new Register();
				frame.dispose();
				frame.add(window);
			}
		});
		signInButton.setBounds(247, 255, 101, 29);
		frame.getContentPane().add(signInButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(208, 196, 162, 30);
		frame.getContentPane().add(passwordField);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(30, 6, 374, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(51, 55, 382, 16);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(51, 313, 382, 16);
		frame.getContentPane().add(separator_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Apple Chancery", Font.BOLD, 30));
		lblNewLabel_3.setForeground(Color.ORANGE);
		lblNewLabel_3.setIcon(new ImageIcon("/Users/speedy/Downloads/backgrounds-of-books.jpg"));
		lblNewLabel_3.setBounds(0, 42, 1244, 570);
		frame.getContentPane().add(lblNewLabel_3);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 248, 220));
		panel.setBounds(0, 0, 1000, 82);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel_4 = new JLabel("High School-Decoded");
		lblNewLabel_4.setFont(new Font("Apple Chancery", Font.BOLD, 30));
		lblNewLabel_4.setForeground(Color.RED);
		panel.add(lblNewLabel_4);
		

	}
	//When user logins this method creates tables in database		
	private void createTables(Connection con) {
		Statement stmt;
		String sql = "CREATE TABLE IF NOT EXISTS USER_VALIDATION"
    		    + "(id INTEGER auto_increment,"
    		    + "userName VARCHAR(255),"
    		    + "password VARCHAR(255),"
    		    + "name VARCHAR(255),"
    		    + "email VARCHAR(255))";
		String sql2 = "CREATE TABLE IF NOT EXISTS USER_PROFILE"
    		    + "(id INTEGER auto_increment,"
    		    + "firstName VARCHAR(255),"
    		    + "lastName VARCHAR(255),"
    		    + "grade INTEGER,"
    		    + "school VARCHAR(255),"
    		    +"gpa DOUBLE)";
		String sql3 = "CREATE TABLE IF NOT EXISTS CLASS_ASSIGNMENTS"
    		    + "(id INTEGER auto_increment,"
				+"isCompleted BOOLEAN,"
    		    + "subjects VARCHAR(255),"
    		    + "assignments VARCHAR(255),"
    		    + "due_date VARCHAR(255),"
    		    +"time INTEGER,"
    		    +"priority INTEGER,"
    		    + "primary key(id))";
		String sql4 = "CREATE TABLE IF NOT EXISTS DEPARTMENT"
    		    + "(id INTEGER auto_increment,"
				+ "class VARCHAR(255),"
    		    + "subjects VARCHAR(255),"
    		    + "grades VARCHAR(1),"
    		    + "primary key(id))";
		String sql5 = "CREATE TABLE IF NOT EXISTS COLLEGES"
    		    + "(id INTEGER auto_increment,"
    		    + "college_name VARCHAR(255),"
    		    + "primary key(id))";
		String sql6 = "CREATE TABLE IF NOT EXISTS ACTIVITIES"
    		    + "(id INTEGER auto_increment,"
    		    + "activity VARCHAR(255),"
    		    + "time VARCHAR(255))";
		String sql7 = "CREATE TABLE IF NOT EXISTS POINTS"
    		    + "(id INTEGER auto_increment,"
    		    + "point INTEGER,"
    		    + "time INTEGER)";
		try {
			stmt = con.createStatement();
		    stmt.execute(sql);
		    stmt.execute(sql2);
		    stmt.execute(sql3);
		    stmt.execute(sql4);
		    stmt.execute(sql5);
		    stmt.execute(sql6);
		    stmt.execute(sql7);
		    stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		tableCreated = true;
	
	}
	
	//Validate user information
	private boolean validateUser(Connection con,String userName,String password) {
		
		String sql3 = "SELECT * FROM USER_VALIDATION ";
		Statement stmt;
		try {
		stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(sql3);
	    while(rs.next()) {
	    
	    	if(rs.getString(2).equals(userName) && rs.getString(3).equals(password)) {
	    		user = rs.getString(4);
	            return true;
	    	}
	    	
	    }
	    	    JOptionPane.showMessageDialog(null, "Wrong Username or Password", "Incorrect input", JOptionPane.ERROR_MESSAGE);
	    	
	    
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
	
		return false;
	}
	
	
}