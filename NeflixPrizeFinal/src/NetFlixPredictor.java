import java.util.ArrayList;
/*
 * http://blog.echen.me/2011/10/24/winning-the-netflix-prize-a-summary/
 * DONE mean average rating of all users (overall mean)
 * DONE average of one user
 * DONE '' as compared to overall mean
 * DONE '' as compared to average rating of movie
 * 
 * days since movie's first rating
 * days since user's first rating
 */

public class NetFlixPredictor {


	// Add fields to represent your database.

	static private ArrayList<User> users;
	static private ArrayList<Movie> movies;

	private double averageMovieRating;

	static private ArrayList<Genre> allGenre;

	/**
	 * 
	 * Use the file names to read all data into some local structures. 
	 * 
	 * @param movieFilePath The full path to the movies database.
	 * @param ratingFilePath The full path to the ratings database.
	 * @param tagFilePath The full path to the tags database.
	 * @param linkFilePath The full path to the links database.
	 */
	public NetFlixPredictor(String movieFilePath, String ratingFilePath, String tagFilePath, String linkFilePath) {
		users = new ArrayList<User>();
		movies = new ArrayList<Movie>();
		allGenre = new ArrayList<Genre>();

		ArrayList<String> movieStrings = FileIO.readFile(movieFilePath);
		ArrayList<String> tagsStrings = FileIO.readFile(tagFilePath);
		ArrayList<String> linksStrings = FileIO.readFile(linkFilePath);
		ArrayList<String> ratingStrings = FileIO.readFile(ratingFilePath);

		MovieLLensCSVTTranslator translator = new MovieLLensCSVTTranslator();


		for(String s : movieStrings) {
			Movie m = translator.parseMovie(s);
			if(m != null) {
				movies.add(m);
			}
		}


		for(String s : tagsStrings) {
			User u  = translator.parseTags(s, users, movies);
			if(u != null){
				users.add(u);
			}
		}


		for(String s : linksStrings) {
			translator.parseLinks(s, movies);
		}



		for(String s : ratingStrings) {
			User u = translator.parseRatings(s, movies, users);
		}

		averageMovieRating = getOverAllRating();
	}
	public static ArrayList<Movie> getMovies(){
		return movies;
	}
	public static ArrayList<Genre> getAllGenres(){
		return allGenre;
	}
	public static void addGerne (Genre g) {
		allGenre.add(g);
	}
	public static void addUser(User u){

		users.add(u);
	}

	/**
	 * If userNumber has rated movieNumber, return the rating. Otherwise, return -1.
	 * 
	 * @param userNumber The ID of the user.
	 * @param movieNumber The ID of the movie.
	 * @return The rating that userNumber gave movieNumber, or -1 if the user does not exist in the database, the movie does not exist, or the movie has not been rated by this user.
	 */
	public double getRating(int userID, int movieID) {
		//		try{

		//		} catch (NullPointerException e){
		//			System.out.println("returning -1");
		//			return -1;
		//		}
		for(User u : users){
			if(u.getUserId() == userID){
				for(Rating r : u.getRatings()){
					if(r.getMovie().getMovieId() == movieID){
						//						System.out.println("returning " + r.getRating());
						return r.getRating();
					}
				}
			}
		}
		return -1;
	}

	private double getOverAllRating(){
		double total = 0.0;
		int num = 0;
		for(User u : users){
			ArrayList<Rating> ratings = u.getRatings();
			for(Rating r : ratings){
				total += r.getRating();
				num ++;
			}
		}
		if(num == 0)
			return 0.0;
		return total/(double)num;
	}

	private double getUserAverageRating(int userId){
		try{
			User user = null;

			for(User u : users) {
				if(u.getUserId() == userId) {
					user = u;
				}
			}
			double total = 0.0;
			int count = 0;
			for(Rating u: user.getRatings()){
				total += u.getRating();
				count++;
			}
			if(count == 0)
				return 0.0;
			return total/(double)count;
		} catch(Exception e){
			return 0.0;
		}
	}
	private double getMovieAverageRating(int movieId){
		try{
			Movie movie = null;

			for(Movie m : movies) {
				if(m.getMovieId() == movieId) {
					movie = m;
				}
			}
			double total = 0.0;
			int count = 0;
			for(Rating u: movie.getRatings()){
				total += u.getRating();
				count++;
			}
			if(count == 0)
				return 0.0;
			return total/(double)count;
		} catch(Exception e){
			return 0.0;
		}
	}

	public double getUserSpecificEffect(int userId){
		double userAvg = getUserAverageRating(userId);

		return averageMovieRating - userAvg;
	}

	private User getUser(int userId) {
		for(User u : users) {
			if(u.getUserId() == userId) {
				return u;
			}
		}
		return null;

	}
	public Movie getMovie(int id) {
		for(Movie u : movies) {
			if(u.getMovieId() == id) {
				return u;
			}
		}
		return null;

	}

	public double getAverageGenreUserRating(int userId, String g) {
		ArrayList<Genre> genres = getUser(userId).getGenres();
		for(Genre genre : genres) {
			if(genre.getGenre().equals(g)) {
				return genre.getAverageRating();
			}
		}
		return 0.0;
	}

	public double getMovieSpecificEffect(int movieId){
		try{
			Movie movie = null;
			for(Movie m : movies){
				if(m.getMovieId() == movieId){
					movie = m;
				}
			}
			ArrayList<Rating> ratings = movie.getRatings();
			double movieRating = 0.0;
			for(Rating r : ratings){
				if(r.getMovie().getMovieId() == movieId){
					movieRating = r.getRating();
				}
			}
			double rate = getMovieAverageRating(movieId);
			if(rate == 0)
				return 0.0;
			return movieRating/rate;
		} catch(Exception e){
			return 0.0;
		}

	}

	public double getGenreAverageRatings(String s) {
		for(Genre g : allGenre) {
			if(g.getGenre().equals(s)) {
				return g.getAverageRating();
			}
		}
		return 0.0;
	}

	private User findSimilarUser(int userId, int movieId) {
		User user = getUser(userId);
		int[] similarity = new int[users.size()];

		for(int i = 0; i < users.size(); i ++) {
			User u = users.get(i);
			int s = 0;

			ArrayList<Rating> uRatings = u.getRatings();

			boolean rated = false;

			for(Rating r : uRatings) {
				if(r.getMovie().getMovieId() == movieId)
					rated = true;
			}

			if(u.getUserId() != userId && rated) {
				ArrayList<Genre> genres = u.getGenres();
				ArrayList<Genre> userGenre = user.getGenres();
				//				System.out.println("movie genres" + getMovie(movieId).getGenres());
				//				System.out.println("length of genres: " + genres.size() + "**" + genres + " length of userGenre: " + userGenre.size() + " **" + userGenre);
				for(Genre g : genres) {
					for (Genre ug : userGenre) {
						if(g.getGenre().equals(ug.getGenre())) {
							s++;
							if(g.getNumRatings() == ug.getNumRatings()) 
								s ++;
							if((int)g.getAverageRating() == (int)ug.getAverageRating())
								s++;
						}
					}
				}			
				if(Math.abs(getUserAverageRating(u.getUserId()) - getUserAverageRating(user.getUserId())) < 1) {
					s++;
				}	
				//				System.out.println("movie id: " + movieId + " userId: " + u.getUserId() + " s: " + s);
				similarity[i] = s;
			}
		}
		int max = 0;
		int index = 0;
		for(int i = 0; i < similarity.length; i ++) {
			if(similarity[i] > max) {
				max = similarity[i];
				index = i;
			}
		}
		return users.get(index);
	}

	private User findSimilarUser(int userId) {
		User user = getUser(userId);
		int[] similarity = new int[users.size()];

		for(int i = 0; i < users.size(); i ++) {
			User u = users.get(i);
			int s = 0;

			if(u.getUserId() != userId) {
				ArrayList<Genre> genres = u.getGenres();
				ArrayList<Genre> userGenre = user.getGenres();
				//				System.out.println("movie genres" + getMovie(movieId).getGenres());
				//				System.out.println("length of genres: " + genres.size() + "**" + genres + " length of userGenre: " + userGenre.size() + " **" + userGenre);
				for(Genre g : genres) {
					for (Genre ug : userGenre) {
						if(g.getGenre().equals(ug.getGenre())) {
							s++;
							if(g.getNumRatings() == ug.getNumRatings()) 
								s ++;
							if((int)g.getAverageRating() == (int)ug.getAverageRating())
								s++;
						}
					}
				}			
				if(Math.abs(getUserAverageRating(u.getUserId()) - getUserAverageRating(user.getUserId())) < 1) {
					s++;
				}	
				//				System.out.println("movie id: " + movieId + " userId: " + u.getUserId() + " s: " + s);
				similarity[i] = s;
			}
		}
		int max = 0;
		int index = 0;
		for(int i = 0; i < similarity.length; i ++) {
			if(similarity[i] > max) {
				max = similarity[i];
				index = i;
			}
		}
		return users.get(index);
	}

	/**
	 * If userNumber has rated movieNumber, return the rating. Otherwise, use other available data to guess what this user would rate the movie.
	 * 
	 * @param userNumber The ID of the user.
	 * @param movieNumber The ID of the movie.
	 * @return The rating that userNumber gave movieNumber, or the best guess if the movie has not been rated by this user.
	 * @pre A user with id userID and a movie with id movieID exist in the database.
	 */
	public double guessRating(int userID, int movieID) {
		User similarUser = findSimilarUser(userID, movieID);
		//		System.out.println("movieId: " + movieID);
		//		System.out.println("guessed user: " + similarUser.getUserId());

		ArrayList<Rating> suRatings = similarUser.getRatings();
		double suRate = 0.0;
		for(Rating r : suRatings) {
			if(r.getMovie().getMovieId() == movieID) {
				suRate = r.getRating();
				break;
			}
		}

		double rate = ((getUserAverageRating(userID) + getUserAverageRating(similarUser.getUserId()) + suRate) * 0.7 + (getMovieAverageRating(movieID)) + getMovieSpecificEffect(movieID) + getUserSpecificEffect(userID) - getUserSpecificEffect(similarUser.getUserId())) * 0.3;

		//		double rate = ((getUserAverageRating(userID) + getUserAverageRating(similarUser.getUserId()) + suRate) * 0.71 + (getMovieAverageRating(movieID)) + getMovieSpecificEffect(movieID) + getUserSpecificEffect(userID) - getUserSpecificEffect(similarUser.getUserId())) * 0.39;

		if(rate > 5)
			return 5.0;
		if(rate < 0)
			return 0.0;
		return rate;

		//		return (rate + suRate) / 2.0;
	}

	/**
	 * Recommend a movie that you think this user would enjoy (but they have not currently rated it). 
	 * 
	 * @param userNumber The ID of the user.
	 * @return The ID of a movie that data suggests this user would rate highly (but they haven't rated it currently).
	 * @pre A user with id userID exists in the database.
	 */
	public int recommendMovie(int userID) {

		User user = getUser(userID);
		ArrayList<Genre> genres = user.getGenres();
		int maxGenreRatings = 0;
		String genre = "";
		for(Genre g : genres) {
			int genreRating = g.getNumRatings();
			if(genreRating > maxGenreRatings) {
				maxGenreRatings = genreRating;
				genre = g.getGenre();
			}
		}

		User similarUser = findSimilarUser(userID);
		ArrayList<Rating> ratings= similarUser.getRatings();
		ArrayList<Movie> possibleMovies = new ArrayList<Movie>();
		
		for(Rating rate : ratings) {
			ArrayList<Genre> rateGenres = rate.getMovie().getGenres();
			for(Genre g : rateGenres) {
				if(g.getGenre().equals(genre)) {
					possibleMovies.add(rate.getMovie());
				}
			}
		}
		
		Movie movie = null;
		double maxRating = 0.0;
		for(Movie r : possibleMovies) {
			if(r.getAvgRating() > maxRating) {
				maxRating = r.getAvgRating();
				movie = r;
			}
		}
		return movie.getMovieId();
	}

}
