package functions;

/**
 * This class represents an assignment that the user has to complete. It includes the user’s time limit for each 
   assignment and points possible for each assignment 
 * @author Helen
 *
 */
public class Assignment {
	 private  String  subject;
     private  String assignment;
     private String duedate;
     private boolean isCompleted;
     private int time;
     private int priority;
     
     /**
      * Creates an Assignment Object
      * 
      * @param isCompleted Whether the assignment has been completed or not
      * @param subject The subject that relates to the assignment
      * @param assignment The name of the assignment
      * @param duedate The date that the assignment is due
      * @param time The time that the user wants to spend on each assginment
      * @param priority A number representing how important the assignment is, from 1(not very important) to 5 (very imortant)
      */
     public Assignment(boolean isCompleted,String subject, String assignment, String duedate,int time,int priority) {
 		super();
 		this.subject = subject;
 		this.assignment = assignment;
 		this.duedate = duedate;
 		this.isCompleted = isCompleted;
 		this.time = time;
 		this.priority = priority;
 	}

     
	public boolean isCompleted() {
		return isCompleted;
	}


	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}


	public int getTime() {
		return time;
	}


	public void setTime(int time) {
		this.time = time;
	}


	public int getPriority() {
		return priority;
	}


	public void setPriority(int priority) {
		this.priority = priority;
	}


	public String getSubject() {
		
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAssignment() {
		return assignment;
	}
	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}
	public String getDuedate() {
		return duedate;
	}
	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}
	


}
