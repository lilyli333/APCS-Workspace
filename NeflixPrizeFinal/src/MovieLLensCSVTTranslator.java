import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MovieLLensCSVTTranslator {

	public Movie parseMovie(String line) {

		int firstComma = line.indexOf(",");
		int lastComma = line.lastIndexOf(",");

		if(line.substring(0, firstComma).equals("movieId")) {
			return null;
		}

		String movieId = line.substring(0, firstComma);
		String title = line.substring(firstComma + 1, lastComma);
		//		title = title.replaceAll("\"", "");
		String genre = line.substring(lastComma + 1);
		int indexParathensis = title.lastIndexOf(")");
		int year = 0;
		if(indexParathensis > 0 && title.charAt(indexParathensis - 1) != '-') {
			if(title.charAt(indexParathensis - 1) == '-') {
				year = Integer.parseInt(title.substring(indexParathensis - 5, indexParathensis - 1));
				title = title.substring(0, indexParathensis - 6);
			}
			else {
				year = Integer.parseInt(title.substring(indexParathensis - 4, indexParathensis));
				title = title.substring(0, indexParathensis - 5);
			}
		}
		ArrayList<String> genreList = new ArrayList<String>(Arrays.asList(genre.split("\\|")));
		ArrayList<Genre> genres = new ArrayList<Genre>();
		for(String g : genreList) {
			genres.add(new Genre(g));
		}
		return new Movie(Integer.parseInt(movieId), title.trim(), genres, year);
	}

	public User parseTags(String line, ArrayList<User> users, ArrayList<Movie> movies) {
		int userId, movieId, timestamp;
		String tagstr;

		String[] items = line.split(",");

		if(items[0].equals("userId")) {
			return null;
		}
		userId = Integer.parseInt(items[0]);
		movieId = Integer.parseInt(items[1]);

		if(line.indexOf("\"") != -1) {
			int firstChar = line.indexOf(line.substring(line.indexOf("\"")));
			int lastChar = line.lastIndexOf("\"");
			tagstr = line.substring(firstChar + 1, lastChar);
			String time = line.substring(lastChar + 2);
			timestamp = Integer.parseInt(time);
		} else {

			tagstr = items[2];
			timestamp = Integer.parseInt(items[3]);
		}
		Movie movie = getMovie(movies,movieId);
		Tag tag = new Tag(movie, tagstr, timestamp);

		User user = getUser(users, userId);
		user.addTag(tag);


		movie.addTag(userId, tagstr);

		return user;
	}	

	public User parseRatings(String line, ArrayList<Movie> movies, ArrayList<User> users) {
		String[] items = line.split(",");
		if(items[0].equals("userId")) {
			return null;
		}
		//		System.out.println(Integer.parseInt(items[0]));
		User user = getUser(users, Integer.parseInt(items[0]));
		Movie movie = getMovie(movies, Integer.parseInt(items[1]));
		double rating = Double.parseDouble(items[2]);
		int timeStamp = Integer.parseInt(items[3]);
		Rating rate = new Rating(movie, rating, timeStamp);



		//add genre in movie and user
		ArrayList<Genre> movieGenres = movie.getGenres();

		for(Genre mg : movieGenres) {
			boolean exist = false;
			for(Genre ug : user.getGenres()) {
				if(ug.getGenre().equals(mg.getGenre())) {
					ug.addRating(rating);
					exist = true;
				}
			}
			if(!exist) {
				user.addGenre(new Genre(mg.getGenre(), rating));
			}
			mg.addRating(rating);
		}

		//add rating to allGenre in predictor

		ArrayList<Genre> allGenres = NetFlixPredictor.getAllGenres();

		boolean exist = false;

		for(Genre mg : movieGenres) {
			for(Genre ag : allGenres) {
				if(mg.getGenre().equals(ag.getGenre())) {
					ag.addRating(rating);
					exist = true;
				}
			}
			if(exist == false) {
				NetFlixPredictor.addGerne(new Genre(mg.getGenre(), rating));
			}
			exist = false;
		}


		user.addRating(rate);
		movie.addRating(rate);
		return user;
	}

	public void parseLinks(String line, ArrayList<Movie> movies) {
		String[] items = line.split(",");
		if(items[0].equals("movieId")) {
			return;
		}
		Movie movie = getMovie(movies, Integer.parseInt(items[0]));
		movie.setimdbId(items[1]);
		if(items.length == 3) {
			movie.settmdbId(items[2]);
		}
		//		System.out.println("movie title: " + movie.getTitle() + " imbdID: " + items[1]);
	}

	private Movie getMovie(ArrayList<Movie> movies, int movieId) {

		int n = Collections.binarySearch(movies,new Movie(movieId));
		if(n>=0) {
			return movies.get(n);
		}
		else {
			Movie movie = new Movie(movieId);
			return movie;		
		}
	}

	private User getUser(ArrayList<User> users, int userId) {
		int n=Collections.binarySearch(users,new User(userId));
		if(n>=0) {
			return users.get(n);
		}
		else {
			User user = new User(userId);
			NetFlixPredictor.addUser(user);
			return user;		
		}

	}
}
