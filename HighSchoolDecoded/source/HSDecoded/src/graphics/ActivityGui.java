package graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import functions.Activity;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ActivityGui extends JPanel {
	/**
	 * This class is the Gui for the activities window. In this window, the user can create a daily schedule
	 * that lists an event/activity and the time it will occur. An event/activity can also be deleted,
	 * but there is a bug with that(the table will create some empty rows at the top of the table, but if you close
	 * the window and then open it again, the empty rows will disappear and it will work as expected).
	 * 
	 *@author Helen(graphics), Anushka(database)
     *@version 05/22/2018
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel contentPane;
	private JTable table;
	private JTextField activityField;
	private JTextField timeField;
	private static Connection con;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private JPanel panel_1,panel_4;
	private JScrollPane scrollPane_1;

	/**
	 * Creates the window and initializes the contents of the window.
	 */
	public ActivityGui() {
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
		
		JLabel lblNewLabel = new JLabel("Today's Schedule");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setBounds(229, 6, 210, 44);
		panel.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 57, 617, 235);
		contentPane.add(scrollPane);
		
		panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(null);
		
		
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 0));
		panel_4.setBounds(6, 6, 597, 26);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		String[] columnNames =  {"Activity","time"};
		Object[][] data = {/*{"Play Tennis","5:00"},
				           {"Meet Friends","6:00"},
				           {"Studies","7:00-8:00"}*/
		};
		
		
		model = new DefaultTableModel(data,columnNames);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 52, 597, 173);
		panel_1.add(scrollPane_1);
		table = new JTable(model);
		scrollPane_1.setViewportView(table);
		table.setToolTipText("Activity time");
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				TableModel model = table.getModel();
				activityField.setText(model.getValueAt(i, 0).toString());
				timeField.setText(model.getValueAt(i, 1).toString());

			}
		});
		
		table.setBackground(new Color(173, 216, 230));table.setSurrendersFocusOnKeystroke(true);
		table.setForeground(new Color(0, 0, 0));
		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true);
		//readFromActivities(); 
		writeToActivities();
		
		
		
		activityField = new JTextField();
		activityField.setBounds(252, 327, 293, 37);
		contentPane.add(activityField);
		activityField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Activity");
		lblNewLabel_1.setBounds(113, 327, 63, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setBounds(113, 418, 63, 37);
		contentPane.add(lblTime);
		
		timeField = new JTextField();
		timeField.setColumns(10);
		timeField.setBounds(252, 418, 293, 37);
		contentPane.add(timeField);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			String activity,time;
			public void actionPerformed(ActionEvent e) {
				addToActivities();
				//readFromActivities();
			}

			//add information to display in window table
			private void addToActivities() {
				activity = activityField.getText();
				time = timeField.getText();
				
				activityField.setText("");
				timeField.setText("");
				
			  ((DefaultTableModel) table.getModel()).insertRow(model.getRowCount(), new Object[] {activity,time});
			  insertIntoActivities();
				
			}

			//add information to activity table
			private void insertIntoActivities() {
				Connection con;
				PreparedStatement stmt = null;
				String sql = "INSERT INTO ACTIVITIES(activity,time)"
					    + " values(?,?)";
				try {
					
					con = getConnection();
					stmt = con.prepareStatement(sql);
					stmt.setString(1,activity);
					stmt.setString(2,time);
					
					
					stmt.executeUpdate();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				finally {
					try {
						stmt.close();
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					
				}
				
			}
		});
		btnEnter.setBounds(130, 561, 117, 29);
		contentPane.add(btnEnter);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!activityField.getText().equals("")  && !timeField.getText().equals("")) {
					removeFromList();
				}
			     else {
				     JOptionPane.showMessageDialog(null, "enter valid info");
			    }
			}
		});
		btnRemove.setBounds(385, 561, 117, 29);
		contentPane.add(btnRemove);
		frame.setVisible(true);

	}
	//read database table and displays in dashboard table
	private void writeToActivities() {
		ArrayList<Activity>  activityList = new ArrayList<>();
		try{

			con = getConnection();
			String query = "SELECT * FROM ACTIVITIES";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			Activity activty;

			while(rs.next()){

				activty = new Activity(rs.getString("activity"),rs.getString("time"));
				activityList.add(activty);
				
			}
			 Object[] row = new Object[2];
	         for(int i=0;i<activityList.size();i++){

	                    row[0] = activityList.get(i).getActivity();
	                    row[1] = activityList.get(i).getTime();
	                                
	                    model.addRow(row);
	                  
	          }

		}
		catch(Exception e){

			JOptionPane.showMessageDialog(null , e);
		}
		
		
	}
	//get connection from database
	public static Connection getConnection() {
		try {
			if(con == null)
			 con = DriverManager.getConnection("jdbc:h2:"+"./Database/my","root","mypassword");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return con;
		
	}
	
    //delete data from database table
    private void removeFromList() {
    	
    	String query = "DELETE FROM  ACTIVITIES WHERE  activity = "+ "'"+model.getValueAt(table.getSelectedRow(), 0)+"'";
    	
    	Statement st = null;
		try {
			Connection con = getConnection();
		    st = con.createStatement();
		    if(st.executeUpdate(query) == 1) {
		    	JOptionPane.showMessageDialog(null, " operation sucessfull");
		    	
		    	model.removeRow(table.getSelectedRow());
		    }
		    else
		    	JOptionPane.showMessageDialog(null, " operation not sucessfull");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally
		{
			try {
				st.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
        activityField.setText("");
		timeField.setText("");
		
    	
    }
}
