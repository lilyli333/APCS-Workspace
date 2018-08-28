package graphics;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JCalendar;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JTextField;

public class UtilitiesGui extends JPanel {
	/**
	 * This class is the graphics interface for utilities such as a calendar, stop watch, and 
	 * basic math calculator, which the user can use for homework if needed. The calculator does not 
	 * work if the user tries to perform multiple operations at one time
     * 
     * @author Helen(graphics)
     * @version 05/22/18
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblNewLabel_1;
	private JLabel lblStopWatch;
	private JPanel panel_3;
	private JLabel lblNewLabel_2;
	private JButton btnReset;
	private boolean setClear=true;  
	private double memValue;
	private JLabel memLabel;
	private double number;
	private char op;

	private static int hours = 0;
	private static int minutes = 0;
	private static int seconds = 0;
	private static int milliseconds = 0;
	private static boolean state = true;
	private JTextField textField;
	private JButton btn_back;
	private JButton btn_Ce;
	private JButton btn_C;
	private JButton btn_7;
	private JButton btn_8;
	private JButton btn_9;
	private JButton btn_4;
	private JButton btn_5;
	private JButton btn_6;
	private JButton btn_1;
	private JButton btn_2;
	private JButton btn_3;
	private JButton btn_0;
	private JButton btn_Add_Sub;
	private JButton btn_deci;
	private JButton btn_div;
	private JButton btn_sqrt;
	private JButton btn_multi;
	private JButton btn_mod;
	private JButton btn_sub;
	private JButton btn_x;
	private JButton btn_add;
	private JButton btn_eq;
	private JButton btn_Mc;
	private JButton btn_Mr;
	private JButton btn_Ms;
	private JButton btn_M;
	/**
	 * Create the window and initializes the contents of the window.
	 */
	public UtilitiesGui() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 850, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 218, 185));
		panel.setBounds(6, 6, 838, 80);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("UTILITIES");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setBounds(350, 19, 179, 43);
		panel.add(lblNewLabel);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 255, 255));
		panel_1.setBounds(31, 415, 332, 296);
		
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(6, 5, 313, 41);
		panel_1.add(textField);
		textField.setColumns(10);
		
		btn_back = new JButton("Backspace");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				specialAction(e);
			}
		});
		btn_back.setBounds(77, 58, 84, 41);
		panel_1.add(btn_back);
		
		btn_Ce = new JButton("CE");
		btn_Ce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				specialAction(e);
			}
		});
		btn_Ce.setBounds(246, 58, 61, 41);
		panel_1.add(btn_Ce);
		
		btn_C = new JButton("C");
		btn_C.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				specialAction(e);
			}
		});
		btn_C.setBounds(173, 58, 61, 41);
		panel_1.add(btn_C);
		
		btn_7 = new JButton("7");
		btn_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digitAction(e);
			}
		});
		btn_7.setBounds(87, 111, 29, 29);
		panel_1.add(btn_7);
		
		btn_8 = new JButton("8");
		btn_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digitAction(e);
			}
		});
		btn_8.setBounds(128, 111, 29, 29);
		panel_1.add(btn_8);
		
		btn_9 = new JButton("9");
		btn_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digitAction(e);
			}
		});
		btn_9.setBounds(169, 111, 29, 29);
		panel_1.add(btn_9);
		
		btn_4 = new JButton("4");
		btn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digitAction(e);
			}
		});
		btn_4.setBounds(87, 152, 29, 29);
		panel_1.add(btn_4);
		
		btn_5 = new JButton("5");
		btn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digitAction(e);
			}
		});
		btn_5.setBounds(128, 152, 29, 29);
		panel_1.add(btn_5);
		
		btn_6 = new JButton("6");
		btn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digitAction(e);
			}
		});
		btn_6.setBounds(169, 152, 29, 29);
		panel_1.add(btn_6);
		
		btn_1 = new JButton("1");
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digitAction(e);
			}
		});
		btn_1.setBounds(87, 193, 29, 29);
		panel_1.add(btn_1);
		
		btn_2 = new JButton("2");
		btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digitAction(e);
			}
		});
		btn_2.setBounds(128, 193, 29, 29);
		panel_1.add(btn_2);
		
		btn_3 = new JButton("3");
		btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digitAction(e);
			}
		});
		btn_3.setBounds(169, 193, 29, 29);
		panel_1.add(btn_3);
		
		btn_0 = new JButton("0");
		btn_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digitAction(e);
			}
		});
		btn_0.setBounds(87, 234, 29, 29);
		panel_1.add(btn_0);
		
		btn_Add_Sub = new JButton("+/-");
		btn_Add_Sub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operatorAction(e);
			}
		});
		btn_Add_Sub.setBounds(128, 234, 29, 29);
		panel_1.add(btn_Add_Sub);
		
		btn_deci = new JButton(".");
		btn_deci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digitAction(e);
			}
		});
		btn_deci.setBounds(169, 234, 29, 29);
		panel_1.add(btn_deci);
		
		btn_div = new JButton("/");
		btn_div.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operatorAction(e);
			}
		});
		btn_div.setBounds(221, 111, 39, 29);
		panel_1.add(btn_div);
		
		btn_sqrt = new JButton("sqrt");
		btn_sqrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operatorAction(e);
			}
		});
		btn_sqrt.setBounds(272, 111, 39, 29);
		panel_1.add(btn_sqrt);
		
		btn_multi = new JButton("*");
		btn_multi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operatorAction(e);
			}
		});
		btn_multi.setBounds(221, 152, 39, 29);
		panel_1.add(btn_multi);
		
		btn_mod = new JButton("%");
		btn_mod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operatorAction(e);
			}
		});
		btn_mod.setBounds(272, 152, 39, 29);
		panel_1.add(btn_mod);
		
		btn_sub = new JButton("-");
		btn_sub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operatorAction(e);
			}
		});
		btn_sub.setBounds(221, 193, 39, 29);
		panel_1.add(btn_sub);
		
		btn_x = new JButton("1/x");
		btn_x.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operatorAction(e);
			}
		});
		btn_x.setBounds(272, 193, 39, 29);
		panel_1.add(btn_x);
		
		btn_add = new JButton("+");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operatorAction(e);
			}
		});
		btn_add.setBounds(221, 234, 39, 29);
		panel_1.add(btn_add);
		
		btn_eq = new JButton("=");
		btn_eq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operatorAction(e);
			}
		});
		btn_eq.setBounds(272, 234, 39, 29);
		panel_1.add(btn_eq);
		
		btn_Mc = new JButton("MC");
		btn_Mc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memoryAction(e);
			}
		});
		btn_Mc.setBounds(23, 111, 39, 29);
		panel_1.add(btn_Mc);
		
		btn_Mr = new JButton("MR");
		btn_Mr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memoryAction(e);
			}
		});
		btn_Mr.setBounds(23, 152, 39, 29);
		panel_1.add(btn_Mr);
		
		btn_Ms = new JButton("MS");
		btn_Ms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memoryAction(e);
			}
		});
		btn_Ms.setBounds(23, 193, 39, 29);
		panel_1.add(btn_Ms);
		
		btn_M = new JButton("M+");
		btn_M.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memoryAction(e);
			}
		});
		btn_M.setBounds(23, 234, 39, 29);
		panel_1.add(btn_M);
		
		memLabel = new JLabel("");
		memLabel.setBounds(6, 58, 61, 41);
		panel_1.add(memLabel);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 240, 245));
		panel_2.setBounds(387, 429, 372, 243);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel hoursLbl = new JLabel("00:");
		hoursLbl.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		hoursLbl.setForeground(new Color(255, 0, 0));
		hoursLbl.setBounds(43, 75, 64, 27);
		panel_2.add(hoursLbl);
		
		JLabel minutesLbl = new JLabel("00:");
		minutesLbl.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		minutesLbl.setForeground(new Color(255, 0, 0));
		minutesLbl.setBounds(119, 75, 54, 27);
		panel_2.add(minutesLbl);
		
		JLabel secondsLbl = new JLabel("00:");
		secondsLbl.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		secondsLbl.setForeground(new Color(255, 0, 0));
		secondsLbl.setBounds(185, 75, 64, 27);
		panel_2.add(secondsLbl);
		
		JLabel millisecLbl = new JLabel("00:");
		millisecLbl.setForeground(new Color(255, 0, 0));
		millisecLbl.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		millisecLbl.setBounds(279, 76, 95, 27);
		panel_2.add(millisecLbl);
		
		
		JButton btnStart = new JButton("START");
		btnStart.setBounds(19, 179, 88, 41);
		panel_2.add(btnStart);
		
		//stopwatch functionality
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				state =true;
				Thread t = new Thread() {

					public void run() {
						for(;;) {
							if(state == true)
							{
								try {
									sleep(1);

									if(milliseconds > 1000)
									{
										seconds++;
										milliseconds = 0;	
									}
									if(seconds > 60) {
										milliseconds = 0;
										seconds = 0;
										minutes++;
									}
									if(minutes > 60) {
										milliseconds = 0;
										seconds = 0;
										minutes = 0;
										hours++;
									}

									
									hoursLbl.setText(""+hours);
									minutesLbl.setText(" : "+minutes);
									secondsLbl.setText(" : "+seconds);
									millisecLbl.setText(" : "+milliseconds);
									
									milliseconds++;
								} catch(Exception e) {
									e.printStackTrace();
								}
							}
						}
					}
				};
				t.start();
			}
			
		});
		
		
		JButton btnStop = new JButton("STOP");
		btnStop.setBounds(138, 179, 88, 41);
		panel_2.add(btnStop);
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state = false;
				
			}
		});
		
		btnReset = new JButton("RESET");
		btnReset.setBounds(253, 179, 88, 41);
		panel_2.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				state = false;
				milliseconds = 0;
				seconds = 0;
				minutes = 0;
				hours = 0;

				hoursLbl.setText("00: ");
				minutesLbl.setText("00: ");
				secondsLbl.setText("00: ");
				millisecLbl.setText("00 ");
				
			}
		});
		
		lblNewLabel_1 = new JLabel("CALCULATOR");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(128, 387, 146, 16);
		contentPane.add(lblNewLabel_1);
		
		lblStopWatch = new JLabel("STOP WATCH");
		lblStopWatch.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblStopWatch.setBounds(530, 401, 146, 16);
		contentPane.add(lblStopWatch);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(86, 120, 673, 255);
		contentPane.add(panel_3);
		
		JCalendar calendar = new JCalendar();
		calendar.getMonthChooser().getComboBox().setBackground(new Color(224, 255, 255));
		calendar.getDayChooser().getDayPanel().setBackground(new Color(224, 255, 255));
		calendar.setDecorationBackgroundColor(new Color(30, 144, 255));
		calendar.setBackground(new Color(135, 206, 250));
		panel_3.add(calendar);
		
		lblNewLabel_2 = new JLabel("CALANDER");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(342, 100, 108, 16);
		contentPane.add(lblNewLabel_2);
		
		
	}
	//add functionality to digit buttons in calculator
	private void digitAction(ActionEvent ev) {
		{  
			String tempText=((AbstractButton) ev.getSource()).getLabel();  
			  
			if(tempText.equals("."))  
			{  
			 if(setClear)   
			    {textField.setText("0.");setClear=false;}  
			 else if(!isInString(textField.getText(),'.'))  
				 textField.setText(textField.getText()+".");  
			 return;  
			}  
			  
			int index=0;  
			try{  
			        index=Integer.parseInt(tempText);  
			    }catch(NumberFormatException e){return;}  
			  
			if (index==0 && textField.getText().equals("0")) return;  
			  
			if(setClear)  
			            {textField.setText(""+index);setClear=false;}  
			else  
				textField.setText(textField.getText()+index);  
			}
	}
	//check to see if a char is in the given string
	static boolean isInString(String s, char ch)  
	{  
	for(int i=0; i<s.length();i++) if(s.charAt(i)==ch) return true;  
	return false;  
	} 
	
	//add functionality to memory buttons in calculator
	private void memoryAction(ActionEvent e) {
		char memop=((AbstractButton)e.getSource()).getLabel().charAt(1);  

		setClear=true;  
		//double temp=Double.parseDouble(textField.getText());  

		switch(memop)  
		{  
		case 'C':   
			memLabel.setText(" ");memValue=0.0;break;  
		case 'R':   
			textField.setText(getFormattedText(memValue));break;  
		case 'S':  
			memValue=0.0;  
		case '+':   
			memValue+=Double.parseDouble(textField.getText());  
			if(textField.getText().equals("0") || textField.getText().equals("0.0")  )  
				memLabel.setText(" ");  
			else   
				memLabel.setText("M");     
			break;  
		}//switch  
	}
	//add functionality to operator buttons in calculator
	private void operatorAction(ActionEvent ev) {

		String opText=((AbstractButton)ev.getSource()).getLabel();  

		setClear=true;  
		double temp=Double.parseDouble(textField.getText());  

		if(opText.equals("1/x"))  
		{  
			try  
			{double tempd=1/(double)temp;  
			textField.setText(getFormattedText(tempd));}  
			catch(ArithmeticException excp)  
			{textField.setText("Divide by 0.");}  
			return;  
		}  
		if(opText.equals("sqrt"))  
		{  
			try  
			{double tempd=Math.sqrt(temp);  
			textField.setText(getFormattedText(tempd));}  
			catch(ArithmeticException excp)  
			{textField.setText("Divide by 0.");}  
			return;  
		}  
		if(!opText.equals("="))  
		{  
			number=temp;  
			op=opText.charAt(0);  
			return;  
		}  
		// process = button pressed  
		switch(op)  
		{  
		case '+':  
			temp+=number;break;  
		case '-':  
			temp=number-temp;break;  
		case '*':  
			temp*=number;break;  
		case '%':  
			try{temp=number%temp;}  
			catch(ArithmeticException excp)  
			{textField.setText("Divide by 0."); return;}  
			break;  
		case '/':  
			try{temp=number/temp;}  
			catch(ArithmeticException excp)  
			{textField.setText("Divide by 0."); return;}  
			break;  
		}//switch  

		textField.setText(getFormattedText(temp));  
		
	}  
	
	//format the input String
	private static String getFormattedText(double temp)  
	{  
	String resText=""+temp;  
	if(resText.lastIndexOf(".0")>0)  
	    resText=resText.substring(0,resText.length()-2);  
	return resText;  
	}  
	
	static String backSpace(String s)  
	{  
	String Res="";  
	for(int i=0; i<s.length()-1; i++) Res+=s.charAt(i);  
	return Res;  
	}  
	  
	/**
	 * provides the functionality for buttons such as backspace in the calculator
	 * @param ev ActionEvent
	 */
	public void specialAction(ActionEvent ev)  
	{  
	String opText=((AbstractButton)ev.getSource()).getLabel();  
	//check for backspace button  
	if(opText.equals("Backspace"))  
	{  
	String tempText=backSpace(textField.getText());  
	if(tempText.equals(""))   
		textField.setText("0");  
	else   
		textField.setText(tempText);  
	return;  
	}  
	//check for "C" button i.e. Reset  
	if(opText.equals("C"))   
	{  
	number=0.0; op=' '; memValue=0.0;  
	memLabel.setText(" ");  
	}  
	  
	//it must be CE button pressed  
	textField.setText("0");setClear=true;  
	}

}
