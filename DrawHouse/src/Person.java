import processing.core.PApplet;

public class Person {

	private int xPos;
	private int yPos;
	private Boolean inHouse;
	private int scale;
	private Line wand;

	public Person(int xSect) {
		xPos = xSect + 50;
		inHouse = false;
		yPos = 350;
		scale = 0;			
		wand = new Line(xPos + 35, yPos + 20, xPos + 55, yPos - 20);
	}

	public void draw(PApplet drawer) {
		wand.setPoint(xPos + 35, yPos + 20, xPos + 55, yPos - 20);
		drawer.strokeWeight(2);
		if (inHouse) {
			xPos = 150;
			//body
			drawer.fill(244, 115, 201);
			drawer.rect(xPos - 15 - scale, yPos - 10, 30 + (int)(0.5 * scale), 35 + (int)(0.5 * scale));
			//head
			drawer.fill(222,222,222);
			if (scale == 0) {
				drawer.ellipse(xPos, yPos - (int)(0.5 * scale), 35, 35 + (int)(0.5 * scale));	
			}
			else {
				drawer.ellipse(xPos  - (int)(0.8 * scale), yPos - (int)(0.25 * scale), 35 + (int)(0.5 * scale), 35 + (int)(0.5 * scale));	
				System.out.println(scale);
			}
		}
		else {
			if(xPos == 150 && yPos == 300) {
				xPos = 250;
				yPos = 350;
			}
			//legs
			drawer.fill(160, 217, 255);
			drawer.rect(xPos - 10, yPos + 50, 5, 60);
			drawer.rect(xPos + 5, yPos + 50, 5, 60);
			//arms
			drawer.fill(244, 115, 201);
			drawer.rect(xPos - 35, yPos + 20, 70, 5);
			//body
			drawer.rect(xPos - 15, yPos - 10, 30, 60);
			//head
			drawer.fill(222,222,222);
			drawer.ellipse(xPos , yPos, 50 , 50);
			
			//wand
//			float t = drawer.millis()/1000.0f;
//		    double yPos = (int)(((40)*Math.sin(t) + (this.yPos + 10)));
//		    double x = (int)(((40)*Math.cos(t) + (this.xPos + 40)));

//		    System.out.println(yPos);
//		    wand.setPoint2((int)x, (int)yPos);
			wand.draw(drawer);
		}
	}

	public boolean isPointOn(int mouseX, int mouseY, int width, int height) {
		boolean bool = false;
			if(mouseX > (getXPos() - 30) * width/500 && mouseX < (getXPos() + 30)* width/500 && mouseY > (getYPos() - 20) * height/500 && mouseY < (getYPos() + 100) * height/500) {
				bool = true;
			}
		return bool;
	}

	public void changeXPos(int amt) {
		xPos += amt;
	}
	public void movetoYPos(int amt) {
		this.yPos = amt;
	}

	public int getXPos() {
		return xPos;
	}
	public int getYPos() {
		return yPos;
	}

	public boolean isInsideHouse() {
		return inHouse;
	}

	public void goInsideHouse(int yPos) {
		inHouse = !inHouse;
		this.yPos = yPos;
	}
	public void changeScale(int amt) {
		scale = amt;
		System.out.println(scale);
	}
	public void increaseScale(int amt) {
		scale += amt;
	}
}
