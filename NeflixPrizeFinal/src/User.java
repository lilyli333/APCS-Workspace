import java.util.ArrayList;

public class User implements Comparable<User>{
	ArrayList<Rating> ratings;
	ArrayList<Tag> tags;
	ArrayList<Genre> genres;
	int userId;
	
	public User(int userId) {
		this.userId = userId;
		ratings = new ArrayList<Rating>();		
		tags = new ArrayList<Tag>();
		genres = new ArrayList<Genre>();
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void addRating(Rating rating) {
		ratings.add(rating);
	}
	
	public void addTag(Tag tag) {
		tags.add(tag);
	}
	
	public ArrayList<Rating> getRatings() {
		return ratings;
	}
	
	public ArrayList<Genre> getGenres(){
		return genres;
	}
	public void addGenre(Genre genre) {
		genres.add(genre);
	}

	@Override
	public int compareTo(User o) {
		if(userId > o.getUserId()) {
			return 1;
		} else if(userId < o.getUserId()) {
			return -1;
		}
		return 0;
	}
}
