
public class Genre {
	private String genre;
	private double averageRating;
	private int numRatings;
	private double totalRatings;
	
	public Genre(String name, double rating) {
		totalRatings = rating;
		numRatings = 1;
		averageRating = rating;
		genre = name;
	}
	
	public Genre(String name) {
		totalRatings = 0;
		numRatings = 0;
		averageRating = 0;
		genre = name;
	}
	
	public void addRating(double rating) {
		numRatings ++;
		totalRatings += rating;
	}
	public double getAverageRating() {
		return totalRatings/(double)numRatings;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public int getNumRatings() {
		return numRatings;
	}
}
