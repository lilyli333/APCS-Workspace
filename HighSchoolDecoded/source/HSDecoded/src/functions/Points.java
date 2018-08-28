package functions;

/**
 * This class manages the points that the user receives for completing an assignment based on it
 * priority, and the time they took to complete it vs. the goal time limit that the user had set
 * 
 * @author Helen
 *
 */
public class Points{
	int timeLimit;
	int timeTaken;
	boolean isCompleted;
	int priority;
	int pointsPossible;

/**
 * Creates a Points object
 * @param time The goal amount of time the user wants to spend on the assignment
 * @param timeTaken The time that was actually taken on the assignment
 * @param isDone Whether the assignment is completed or not
 * @param stars The priority level of the assignment  from 1(very low priority) to 5(very high priority)
 */
public Points(int time, int timeTaken,boolean isDone,int stars)
{
	timeLimit = time;
	isCompleted = isDone;
	priority = stars;
	this.timeTaken = timeTaken;
	pointsPossible = stars * 10;
}

public int getTimeLimit() {
	return timeLimit;
}

public void setTimeLimit(int timeLimit) {
	this.timeLimit = timeLimit;
}

public boolean isCompleted() {
	return isCompleted;
}

public void setCompleted(boolean isCompleted) {
	this.isCompleted = isCompleted;
}

public void setTimeTaken(int t) {
	timeTaken = t;
}

public int getTimeTaken(int t) {
	return timeTaken;
}

public int getPointsPossible() {
	return pointsPossible;
}

/*public void setPointsPossible(int pointsPossible) {
	this.pointsPossible = pointsPossible;
} */

/**
 * @return points based on the priority level and time taken to complete the assignment, max points = star*10
 */
public int getPoints() {
	//points for time
	double diff = Math.abs(timeTaken-timeLimit);
	double percentage = diff/timeLimit; 
	double timePoints = pointsPossible/2; 
	
	if(percentage <= -0.5) 
		return pointsPossible;
	else if(percentage <= -0.25)
		return (int) (pointsPossible/2 + 7/8*timePoints);
	else if(percentage <= 0)
		return (int) (pointsPossible/2 + 6/8*timePoints);
	else if(percentage <= 0.25)
		return (int) (pointsPossible/2 + 5/8*timePoints);
	else if(percentage <= 0.5)
		return (int) (pointsPossible/2 + 4/8*timePoints);
	else if(percentage <= 0.75)
		return (int) (pointsPossible/2 + 3/8*timePoints);
	else if(percentage <= 0.875)
		return (int) (pointsPossible/2 + 2/8*timePoints);
	else if(percentage <= 0.9375)
		return (int) (pointsPossible/2 + 1/8*timePoints);
	else
		return 10 ;//(int) (pointsPossible/2);
}


}
