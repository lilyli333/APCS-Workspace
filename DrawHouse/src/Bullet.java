import processing.core.PApplet;

public class Bullet extends Line{
	public Bullet(Person person) {	
		super(person.getXPos() + 54, person.getYPos() - 19, person.getXPos() + 55, person.getYPos() - 20);
	}
	
	public void getBullet() {
//		super.draw(drawer);
		super.move(8, -7);
//		super.printMoves();
	}
	
//	public boolean detect(Line one, Line two, Line three, Line four, PApplet drawer) {
//		if(super.intersects(one, drawer) || super.intersects(two, drawer) || super.intersects(three, drawer) || super.intersects(four, drawer)) {
//			return true;
//		}
//		else {
//			return false;
//		}
//	}
}
