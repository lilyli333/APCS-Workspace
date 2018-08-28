import processing.core.PApplet;

public class Sun {
	private double x, y;
	private double oriX, oriY;
	private Line right, left, up, down;
	
	public Sun(int x, int y) {
		this.x = x;
		this.y = y;
		oriX = x;
		oriY = y;
		left = new Line(x - 25, y - 25, x - 25, y + 25);
		right = new Line(x + 25, y - 25, x + 25, y + 25);
		up = new Line(x - 25, y - 25, x + 25, y - 25);
		down = new Line(x - 25, y + 25, x + 25, y + 25);
	}

	public void draw(PApplet drawer){
		
//		if (x > drawer.width + 10) {
//			x = -10;
//		}
		
		drawer.fill(255, 243, 117);
		drawer.ellipse((int)(x), (int)(y), 50, 50);
		up.setPoint((int)x - 25, (int)y - 25, (int)x + 25, (int)y - 25);
		down.setPoint((int)x - 25, (int)y + 25, (int)x + 25, (int)y + 25);
		right.setPoint((int)x + 25, (int)y - 25, (int)x + 25, (int)y + 25);
		left.setPoint((int)x - 25, (int)y - 25, (int)x - 25, (int)y + 25);
		
		up.draw(drawer);
		down.draw(drawer);
		right.draw(drawer);
		left.draw(drawer);
	}
	
//	public double outPutY(double x, PApplet drawer) {
//		int height = drawer.height;
////		System.out.println(width/2);
////		double yPos =  Math.pow(x - height/2.0, 2)/1000.0;
////		double yPos = 100 * Math.sin(Math.toDegrees(x/100.0));
//		float t = drawer.millis()/1000.0f;
//	    double yPos = (int)(height/2*Math.sin(t) - height/9);
//		return yPos;
//	}
	
	public void update( PApplet drawer) {
		int height = drawer.height;
		int width = drawer.width;
//		float t = drawer.millis()/1000.0f;
		float t = drawer.millis()/1000.0f - 2 * (float)oriX;
	    double yPos = (int)(height/1.5*Math.sin(t) + height/2) + 9* oriY;
	    double xPos = (int)(width*1.5*Math.cos(t) + width/2) + oriX;
//		System.out.println(this.x + ", " + y);
	    x = xPos;
	    y = yPos;
	}
	
	public void printSun() {
		System.out.println(x + ", " + y);
	}
	
	public boolean detect(Bullet bull, PApplet drawer) {
		if(up.intersects(bull, drawer) || down.intersects(bull, drawer) || right.intersects(bull, drawer) || left.intersects(bull, drawer)) {
//			System.out.println("hit");
			return true;
		}
		else {
//			System.out.println("not hit");
			return false;
		}
	}
}
