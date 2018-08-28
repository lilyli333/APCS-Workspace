package loginSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

/**
 * This class represents the graphics interface for when the application is first opened. It leads to the
 * login page and has graphics to show basic actions the application can perform.
 * 
 *@author Anushka
 *@version 05/22/2018
 */
public class WelcomePage {

	private JFrame frame;

	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomePage window = new WelcomePage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creates the window and initializes the contents of the window
	 */
	public WelcomePage() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 128));
		panel.setBounds(6, 6, 988, 49);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 255));
		separator.setBounds(763, 38, 130, 5);
		panel.add(separator);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(6, 55, 988, 288);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("High School Decoded");
		lblNewLabel_3.setForeground(new Color(0, 0, 255));
		lblNewLabel_3.setFont(new Font("Copperplate", Font.BOLD, 35));
		lblNewLabel_3.setBounds(574, 35, 391, 101);
		panel_1.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login window = new Login();
				frame.dispose();
				frame.getContentPane().add(window);
			}
		});
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setBackground(new Color(0, 0, 255));
		btnNewButton.setBounds(682, 174, 152, 38);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(WelcomePage.class.getResource("/Resource/Welcome.jpg")));
		lblNewLabel_1.setBounds(83, 22, 453, 246);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(WelcomePage.class.getResource("/Resource/ombre.jpg")));
		lblNewLabel_2.setBounds(0, 0, 988, 288);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(6, 342, 988, 236);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(60, 43, 159, 165);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Assignments");
		lblNewLabel_7.setBounds(34, 85, 99, 42);
		panel_3.add(lblNewLabel_7);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(0, 0, 159, 165);
		panel_3.add(panel_7);
		
		JLabel label = new JLabel("");
		label.setBounds(50, 6, 52, 52);
		panel_7.add(label);
		
		JLabel label_1 = new JLabel("Assignments");
		label_1.setBounds(34, 85, 99, 42);
		panel_7.add(label_1);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(50, 21, 52, 52);
		panel_7.add(lblNewLabel_6);
		lblNewLabel_6.setIcon(new ImageIcon(WelcomePage.class.getResource("/Resource/correct.png")));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setBounds(516, 43, 159, 165);
		panel_2.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(WelcomePage.class.getResource("/Resource/correct.png")));
		lblNewLabel_8.setBounds(49, 17, 61, 52);
		panel_5.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Colleges");
		lblNewLabel_9.setBounds(49, 101, 61, 16);
		panel_5.add(lblNewLabel_9);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		panel_6.setBounds(755, 43, 159, 165);
		panel_2.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(WelcomePage.class.getResource("/Resource/correct.png")));
		label_3.setBounds(51, 24, 61, 52);
		panel_6.add(label_3);
		
		JLabel lblTimeManagement = new JLabel("Time Management");
		lblTimeManagement.setBounds(26, 103, 115, 16);
		panel_6.add(lblTimeManagement);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(286, 43, 159, 165);
		panel_2.add(panel_4);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(WelcomePage.class.getResource("/Resource/correct.png")));
		label_2.setBounds(50, 21, 52, 52);
		panel_4.add(label_2);
		
		JLabel lblGrades = new JLabel("Grades");
		lblGrades.setBounds(50, 85, 83, 42);
		panel_4.add(lblGrades);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(50, 6, 52, 52);
		panel_4.add(label_4);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(WelcomePage.class.getResource("/Resource/bd.jpg")));
		lblNewLabel.setBounds(0, 6, 988, 224);
		panel_2.add(lblNewLabel);
	}
}
