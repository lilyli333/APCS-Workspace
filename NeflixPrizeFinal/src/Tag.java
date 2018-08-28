
public class Tag {
	
	private int timestamp;
	private Movie movie;
	private String tag;

	public Tag(Movie movie, String tag, int timestamp) {
		this.movie = movie;
		this.timestamp = timestamp;
		this.tag = tag;
	}

}
