package graphics;


import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.util.ArrayList;

import javax.swing.*;


/**
 * Takes information from assignments to create a graph of the points earned everyday
 * 
 * @author Helen and hardwired, java-forums.org
 *
 */
public class Graph extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Integer> aList;
	private  int[] data;
	private int dataSize;
    private int[] d;
	public Graph() { //for testing
		System.out.println("Graph default constructor called");
		 d = new int[]{10,20,30
//				21, 14, 18, 03, 86, 88, 74, 87, 54, 77,
//				61, 55, 48, 60, 49, 36, 38, 27, 20, 18
				//1, 2, 3, 4, 5, 0, 7, 8, 9, 10,
				//11, 12, 13, 14, 17, 1, 2, 3, 4, 5, 55
		};
		
		data = d;
		dataSize = d.length;
	}

	/**
	 * Creates a Graph object using the arraylist that is passed in 
	 * @param points arraylist of points used to graph
	 */
	public Graph (ArrayList<Integer> points) {
		
		System.out.println("constructor called");

		aList = points;
		System.out.println("list"+aList);
		if(points != null) {
			 data = new int[aList.size()];
			for(int i = 0; i<aList.size(); i++) {
				data[0] = points.get(i);
				
			}
			d = data;
			dataSize = data.length;
			
		}else 
		{
			//data = d;
			//dataSize = d.length;
		}
		//goes through the list, for each assignment that is completed, gets the points from the assignment

		for(int i = 0; i<aList.size(); i++) {
			data[i] = points.get(i);
			/*Assignment as = aList.getAssignment(i);
			if(as.isCompleted())
				data[i] = as.getPoints();
			else
				data[i] = 0; */
		}

		dataSize = data.length;
		
	}

//	public void setAssignmentList(AssignmentList a) {
//		aList = a;
//	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;

		g2.setBackground(new Color(214, 241, 255));
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		int w = getWidth()-20;
		int h = getHeight()-20;
		
		// Draw ordinate.
		g2.draw(new Line2D.Double(dataSize+3, dataSize, dataSize+3, h-dataSize));
		// Draw abcissa.
		g2.draw(new Line2D.Double(dataSize+3, h-dataSize, w-dataSize, h-dataSize));
		// Draw labels.
		
		Font font = g2.getFont();
		FontRenderContext frc = g2.getFontRenderContext();
		LineMetrics lm = font.getLineMetrics("0", frc);
		float sh = lm.getAscent() + lm.getDescent();
		// Ordinate label.
		String s = "Points";
		float sy = dataSize + ((h - 2*dataSize) - s.length()*sh)/2 + lm.getAscent();
		for(int i = 0; i < s.length(); i++) {
			String letter = String.valueOf(s.charAt(i));
			float sw = (float)font.getStringBounds(letter, frc).getWidth();
			float sx = (dataSize - sw)/2;
			g2.drawString(letter, sx+2, sy);
			sy += sh;
		}
		
		// Abcissa label.
		s = "Day";
		sy = h - dataSize + (dataSize - sh)/2 + lm.getAscent();
		float sw = (float)font.getStringBounds(s, frc).getWidth();
		float sx = (w - sw)/2;
		g2.drawString(s, sx, sy+5);
		
		// Draw lines.
		
		double xInc = (double)(w - 2*dataSize)/(dataSize-1);
		double scale = (double)(h - 2*dataSize)/getMaxY();
		//g2.setPaint(Color.green.darker());
		g2.setPaint(new Color(83, 137, 129));
		for(int i = 0; i < dataSize-1; i++) {
			double x1 = dataSize + i*xInc;
			double y1 = h - dataSize - scale*data[i];
			double x2 = dataSize + (i+1)*xInc;
			double y2 = h - dataSize - scale*data[i+1];
			g2.draw(new Line2D.Double(x1, y1, x2, y2));
		}
		
		// Mark data points.
		g2.setPaint(Color.red);
		for(int i = 0; i < dataSize; i++) {
			double x = dataSize + i*xInc;
			double y = h - dataSize - scale*data[i];
			g2.fill(new Ellipse2D.Double(x-2, y-2, 4, 4));
		}
		
		g2.drawString(getMaxY() + "", 3, 28);
		//g2.drawString(getMax() + "", 1, (int) (h-dataSize-scale*data.length));
		g2.drawString(dataSize + "", w-25, h-3);
	}

	private int getMaxY() {
		int max = -Integer.MAX_VALUE;
		for(int i = 0; i < dataSize; i++) {
			if(data[i] > max)
				max = data[i];
		}
		return max;
	}

	/*public static void main(String[] args) {
		JFrame f = new JFrame();
		//f.setBackground(new Color(214, 241, 255));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new Graph());
		f.setSize(400,400);
		f.setLocation(200,200);
		f.setVisible(true);
	}  */
}
