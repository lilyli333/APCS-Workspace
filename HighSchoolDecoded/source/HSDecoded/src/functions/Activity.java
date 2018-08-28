package functions;


/**
 * This class represents an activity that the user enters in activity window on the dashboard
 * 
 * @author Helen
 */
public class Activity {
	
	private String activity;
	private String time;
	
	/**
	 * Creates an Activity object 
	 * @param activity The name of the event
	 * @param time The time that the event will start
	 */
	public Activity(String activity, String time) {
		super();
		this.activity = activity;
		this.time = time;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

}
