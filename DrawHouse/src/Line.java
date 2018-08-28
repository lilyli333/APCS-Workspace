import processing.core.PApplet;

public class Line {
	private int x1, x2;
	private int y1, y2;
	private double moveX, moveY;

	public Line(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		moveX = 0;
		moveY = 0;
	}

	public void draw(PApplet drawer) {
//		System.out.println("drawing line");
		drawer.fill(0);
		drawer.strokeWeight(5);
		x1 += moveX;
		x2 += moveX;
		y1 += moveY;
		y2 += moveY;
		drawer.line(x1, y1, x2, y2);
	}
	
	public String cordinatePoint() {
		String str = x1 + ", " + y1 + " and " + x2 + ", " + y2;
		return str;
	}

	public boolean intersects(Line line, PApplet drawer) {
//		System.out.println("checking");
		int intX;
		int intY;
		
//		System.out.println(x1 + ", " + y1 + " and " + x2 + ", " + y2);
//		System.out.println(line.x1 + ", " + line.y1 + " and " + line.x2 + ", " + line.y2);
		
		
		int divideBy = ((x1 - x2) * (line.y1 - line.y2) - (y1 - y2) * (line.x1 - line.x2));
		
		if(divideBy == 0) {
//			System.out.println(line.x1 + ", " + line.y1 + " and " + line.x2 + ", " + line.y2);
//			System.out.println(x1 + ", " + y1 + " and " + x2 + ", " + y2);
//			System.out.println("");
			if (x1 == line.x1 && y1 == line.y1 && x2 == line.x2 && y2 == line.y2) {
//				System.out.println("printing true");
				return true;
			}
			else {
				return false;
			}
		}
		intX = ((x1 * y2 - y1 * x2)*(line.x1 - line.x2) - (x1 - x2) * (line.x1 * line.y2 - line.y1 * line.x2))/divideBy;
		intY = ((x1 * y2 - y1 * x2) * (line.y1 - line.y2) - (y1 - y2)  * (line.x1 * line.y2 - line.y1 * line.x2))/divideBy;
//		System.out.println(intX + ", " + intY);
		
		int lesserX1;
		int lesserY1;
		int largerX1;
		int largerY1;
		
		int lesserX2;
		int lesserY2;
		int largerX2;
		int largerY2;
		
		if(x1 > x2) {
			largerX1 = x1;
			lesserX1 = x2;
		}else {
			largerX1 = x2;
			lesserX1 = x1;
		}
		if(y1 > y2) {
			largerY1 = y1;
			lesserY1 = y2;
		} else {
			largerY1 = y2;
			lesserY1 = y1;
		}
		if(line.x1 > line.x2) {
			largerX2 = line.x1;
			lesserX2 = line.x2;
		} else {
			largerX2 = line.x2;
			lesserX2 = line.x1;
		}
		if(line.y1 > line.y2) {
			largerY2 = line.y1;
			lesserY2 = line.y2;
		} else {
			largerY2 = line.y2;
			lesserY2 = line.y1;
		}
		
//		System.out.println(intX + ", " + intY);
		
		if((intX + 1 >= lesserX1 || intX >= lesserX1) && (intX - 1 <= largerX1 || intX <= largerX1)&& (intX + 1 >= lesserX2 || intX >= lesserX2) && (intX -1 <= largerX2 || intX <= largerX2)) {
			if((intY + 1 >= lesserY1 || intY >= lesserY1) && (intY - 1 <= largerY1 || intY <= largerY1) && (intY + 1 >= lesserY2 || intY >= lesserY2) && (intY - 1<= largerY2 || intY <= largerY2)) {
			return true;
			} else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	public void setPoint(int x1, int y1, int x2, int y2) {
		//used for wand
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
//		System.out.println(x1 + ", " + y1 + " and " + x2 + ", " + y2);
	}
	public void move(double x, double y) {
		moveX = x;
		moveY = y;
		
//		System.out.println("moving");
	}
	public int getY2() {
		return y2;
	}
	public void printMoves() {
		System.out.println("moveX: " + moveX + " moveY: " + moveY);
		System.out.println(x1 + ", " + y1 + " and " + x2 + ", " + y2);
	}
}