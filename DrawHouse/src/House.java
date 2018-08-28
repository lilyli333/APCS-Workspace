import processing.core.PApplet;

public class House {
	private int yPos;
	private int scale;	

	public House() {
		yPos = 50;
		scale = 0;
	}

	public void draw(PApplet drawer){
		drawer.strokeWeight(2);

		//house body
		drawer.stroke(1);
		drawer.fill(183, 163, 130);
		drawer.rect(100 - scale, yPos + 150, 300 + 2 * scale, 250);

		//roof
		drawer.triangle(250, yPos, 100 - scale, yPos + 150, 400 + scale, yPos + 150);
		
		//door
		drawer.fill(91, 59, 7);

		drawer.rect((int)(200 - 0.25 * scale), yPos + 250, (int)(100 + scale * 0.5), 150);
		
		//left window
		drawer.fill(0);
		drawer.rect(125 - scale, yPos + 225, (int)(50 + 0.5 * scale), (int)(50 + 0.5 * scale));	

		//right window
		drawer.rect((int)(325 + 0.5 * scale), yPos + 225, (int)(50 + 0.5 * scale), (int)(50 + 0.5 * scale));	
	}
	
	public void changeYPos(int amt) {
		yPos += amt;
	}
	public int getYPos() {
		return yPos;
	}
	
	public void moveToYPos(int amt) {
		yPos = amt;
	}
	public void increaseScale(int amt) {
		scale += amt;
	}
	public int getScale() {
		return scale;
	}
	
	public boolean pointInWindow(int mouseX, int mouseY, int width, int height) {
		boolean bool = false;
		if(mouseY > (getYPos() + 225) * height/500  - getScale() && mouseY < (getYPos() + 275) * height/500 + getScale()&& mouseX > 125 * width/500 - getScale()&& mouseX < 175 * width/500 + getScale()){
			bool = true;
		}
		return bool;
	}
}
