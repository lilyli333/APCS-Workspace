import java.util.ArrayList;

public class Movie implements Comparable<Movie>  {

	private String imdbId, tmdbId, title;
	private int movieId;
	private ArrayList<Rating> ratings;
	private ArrayList<String[]> tags;
	private int year, numRatings;
	private double totalRating;
	private ArrayList<Genre> genres;

	public Movie(int movieId, String title, ArrayList<Genre> genres, int year) {
		this.movieId = movieId;
		this.title = title;
		this.year = year;
		tags = new ArrayList<String[]>();
		numRatings = 0;
		ratings = new ArrayList<Rating>();
		this.genres = genres;
	}

	public Movie(int movieId) {
		this.movieId = movieId;
		tags = new ArrayList<String[]>();
		genres = new ArrayList<Genre>();
		ratings = new ArrayList<Rating>();
	}
	public void addRating(Rating rating) {
		ratings.add(rating);
		totalRating += rating.getRating();
		numRatings++;
	}
	public double getAvgRating() {
		return totalRating/numRatings;
	}
	public void addGenre(Genre genre) {
		genres.add(genre);
	}

	public void addTag(int userID, String tag) {
		tags.add(new String[] {userID + "", tag});
	}

	public int getMovieId() {
		return movieId;
	}

	public String getTitle() {
		return title;
	}
	public ArrayList<Genre> getGenres(){
		return genres;
	}

	public ArrayList<Rating> getRatings(){
		return ratings;
	}

	public int getYear() {
		return year;
	}
	public void setimdbId(String id) {
		imdbId = id;
	}
	public String getimdbId() {
		return imdbId;
	}
	public void settmdbId(String id) {
		tmdbId = id;
	}

	@Override
	public int compareTo(Movie o) {
		if(movieId > o.getMovieId()) {
			return 1;
		} else if(movieId < o.getMovieId()) {
			return -1;
		}
		return 0;
	}
}
