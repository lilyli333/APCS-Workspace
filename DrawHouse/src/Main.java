import java.awt.Dimension;

import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class Main {
	public static void main(String args[]) {
		DrawingSurface drawing = new DrawingSurface();
		PApplet.runSketch(new String[]{""}, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame)canvas.getFrame();

		window.setSize(500, 500);
		window.setMinimumSize(new Dimension(300,300));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		window.setVisible(true);
	}
}

//public class Main {
//	private static DrawingSurface drawing = new DrawingSurface();
//	private static PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
//	private static PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
//	private static JFrame window = (JFrame)canvas.getFrame();
//	
//	public static void main(String args[]) {
////		DrawingSurface drawing = new DrawingSurface();
//		PApplet.runSketch(new String[]{""}, drawing);
////		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
////		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
////		JFrame window = (JFrame)canvas.getFrame();
//
//		window.setSize(500, 500);
//		window.setMinimumSize(new Dimension(300,300));
//		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		window.setResizable(true);
//
//		window.setVisible(true);
//	}
//	
//	public static void resetWindowSize() {
//		window.setSize(500, 500);
//	}
//}
