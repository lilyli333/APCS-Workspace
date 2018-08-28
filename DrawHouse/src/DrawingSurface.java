import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import processing.event.MouseEvent;

public class DrawingSurface extends PApplet {

	private House house;
	private Person person;
	private String instructionText;
	private List<Sun> suns;
	private List<Bullet> bullets;


	public DrawingSurface() {		
		int xSect = (int)width/10;
		house = new House();
		person = new Person(xSect);
		suns = new ArrayList<Sun>();
		bullets = new ArrayList<Bullet>();
		instructionText = "arrows: move person, scroll: change size of house, click on person: go into house";
	}

	public void setup() {
		for(int i = 0; i < 7; i ++) {
			Sun newSun = new Sun((int)(Math.random() * 500 + 100), (int)(Math.random() * -100 + 1));
			suns.add(newSun);
//			System.out.println(newSun.toString());
		}
		System.out.println(1 + 2.0);
	}

	public void draw() { 
		if(suns.size() == 0) {
			background(0,0,0);
		}
		else {
//			System.out.println(suns.size());
			scale((float)width/500, (float)height/500);

			background(198, 220, 255);  // Clear the screen with a black background 
			textSize(10);
			//grass
			fill(216, 255, 198);
			noStroke();
			rect(0 ,400, 500, 100);

			for (int i = 0 ; i < suns.size(); i ++) {
				Sun sun = suns.get(i);
				sun.draw(this);
				sun.update(this);
//							suns[i].printSun();
			}

			house.draw(this);
			person.draw(this);
			fill(100);
			text(instructionText, 10, 475); 
			text("press q to reset person and house", 10, 10); 
			textSize(7);
			text("SHOOT DOWN THE MOVING SUNS! (based on ancient Chinese Legend) but keep one!", 195,10);

			//		System.out.println(bullets.size());
			for(int i = 0; i < bullets.size(); i ++) {
				Bullet bull = bullets.get(i);
				bull.getBullet();
				bull.draw(this);
				if(bull.getY2() <= -5000) {
					bullets.remove(i);
				}
				for(int j = 0; j < suns.size(); j ++) {
					Sun sun = suns.get(j);
					if(sun.detect(bull, this)) {
						suns.remove(j);
					}
				}

				//			System.out.println(bullets.size());
			}
		}

	}

	public void keyPressed() {
		if (key == CODED) {
			if (keyCode == RIGHT && person.getXPos() < width - 37) {
				person.changeXPos(10);
				System.out.println("moving +10");
			}
			else if (keyCode == LEFT && person.getXPos() > 37) {
				person.changeXPos(-10);
				System.out.println("moving -10");
			}
			else if (keyCode == UP && person.isInsideHouse()) {
				house.changeYPos(-10);
				if (person.isInsideHouse()) {
					person.movetoYPos(house.getYPos() + 250);
				}	

				if(house.getYPos() < -400) {
					house.moveToYPos(600);
				}
			}
			else if (keyCode == DOWN && person.isInsideHouse()) {
				house.changeYPos(10);
				if (person.isInsideHouse()) {
					person.movetoYPos(house.getYPos() + 250);
				}

				if(house.getYPos() > 500) {
					house.moveToYPos(-400);
				}
			}
		}
		else if (key == 'q' || key == 'Q') {	
			System.out.println("deleting");
			int xSect = (int)width/10;
			house = null;
			person = null;
			house = new House();
			person = new Person(xSect);
		}
		else if (key == ' ') {
			bullets.add(new Bullet(person));
		}
	}

	public void mousePressed() {
		if (!person.isInsideHouse()) {
			if(person.isPointOn(mouseX, mouseY, width, height)) {
				person.changeScale(house.getScale());
				person.goInsideHouse(house.getYPos() + 250);
				instructionText = "scroll: change size of house, up/down arrow: move house, click on window: go out of house";
			}
		}
		else if(person.isInsideHouse()) {
			System.out.println("running!");
			if(house.pointInWindow(mouseX, mouseY, width, height)) {
				person.goInsideHouse(350);
				person.changeXPos(100);
				instructionText = "arrows: move person, scroll: change size of house, click on person: go into house";
			}
		}
	}

	public void mouseWheel(MouseEvent event) {
		float e = event.getCount();
		println(e);
		if (e > 0 && house.getScale() < 55) {
			person.increaseScale(1);
			house.increaseScale(1);
		}
		else {
			if(house.getScale() > -10) {
				person.increaseScale(-1);
				house.increaseScale(-1);
			} 
		}
	}
}