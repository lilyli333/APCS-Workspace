import java.util.ArrayList;

public class Rating {
	private double rating;
	private int timeStamp;
	Movie movie;
	
	
	public Rating(Movie movie, double rating, int timeStamp) {
		this.movie = movie;
		this.rating = rating;
		this.timeStamp = timeStamp;
	}
	
	public double getRating() {
		return rating;
	}
	
	public Movie getMovie() {
		return movie;
	}
}
