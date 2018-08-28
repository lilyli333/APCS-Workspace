import java.util.ArrayList;

public class Tester {

	public static void main(String[] args) {

		ArrayList<String> movieStrings = FileIO.readFile("dataset" + FileIO.fileSeparator + "movies.csv");
		ArrayList<String> tagsStrings = FileIO.readFile("dataset" + FileIO.fileSeparator + "tags.csv");
		ArrayList<String> linksStrings = FileIO.readFile("dataset" + FileIO.fileSeparator + "links.csv");
		ArrayList<String> ratingStrings = FileIO.readFile("dataset" + FileIO.fileSeparator + "ratings.csv");

		//		for(String s: movieStrings) {
		//			System.out.println(s);
		//		}

		ArrayList<Movie> movieData = new ArrayList<Movie>();
		ArrayList<User> userData = new ArrayList<User>();
		MovieLLensCSVTTranslator translator = new MovieLLensCSVTTranslator();


		System.out.println("parse movies: *****************************************************************************************************************************************************");

		for(String s : movieStrings) {
			Movie m = translator.parseMovie(s);
			if(m != null) {
				System.out.println(m.getTitle() + ", " + m.getGenres() + ", " + m.getYear());
				movieData.add(m);
			}
		}

//		System.out.println("parse tags: *****************************************************************************************************************************************************");
//
//		for(String s : tagsStrings) {
//			translator.parseTags(s, movieData);
//		}
//
//		System.out.println("parse links: *****************************************************************************************************************************************************");
//
//		for(String s : linksStrings) {
//			translator.parseLinks(s, movieData);
//		}
//
//		System.out.println("parse ratings: *****************************************************************************************************************************************************");
//
//		for(String s : ratingStrings) {
//			translator.parseRatings(s, movieData, userData);
//		}

		//		for(String s: tagsStrings) {
		//			for(Movie m : movieData) {
		//				if(m.getMovieId().equals(translator.getMovieId(s))) {
		////					System.out.println(m.getMovieId());
		//					translator.parseTags(s, m);
		//				}
		//			}
		//		}
	}
}
