

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.activation.FileDataSource;

import processing.core.PApplet;
import processing.core.PImage;

public class DrawingMovie {

	private Movie movie;
	private PImage coverArt;
	
	public DrawingMovie(Movie m) {
		this.movie = m;
		coverArt = null;
	}
	
	public void draw(PApplet drawer, float x, float y, float width, float height) {
		if (movie != null) {
//			System.out.println("reconmmendeed movie id: " + movie.getMovieId() + "; title: " + movie.getTitle());
			String title = movie.getTitle();
			drawer.text(title, x, y);
			if (coverArt != null) {
				drawer.image(coverArt, x, y,width,height);
			}
		}
		drawer.stroke(0);
		drawer.noFill();
		drawer.rect(x, y, width, height);
	}
	

	public void downloadArt(PApplet drawer) {
		
		Thread downloader = new Thread(new Runnable() {

			@Override
			public void run() {
				
				
				// Find the cover art using IMDB links
				// Initialize coverArt
				
				String imdbId = movie.getimdbId();
				String imageURLString = "http://www.imdb.com/title/tt" + imdbId + "/";
				Scanner scan = null;

				try {
					URL pageURl = new URL(imageURLString);
					InputStream is = pageURl.openStream();
					scan = new Scanner(is);
					String fileData = "";
					while(scan.hasNextLine()) {
						String line = scan.nextLine();
						fileData += line;
//						System.out.println(line);
					}
					fileData = fileData.substring(fileData.indexOf("class=\"poster\""));
					imageURLString = fileData.substring(fileData.indexOf("src=\""), fileData.indexOf("/>"));
					imageURLString = imageURLString.substring(imageURLString.indexOf("\""),imageURLString.lastIndexOf("\""));
					imageURLString = imageURLString.substring(imageURLString.indexOf("\""));
					imageURLString = imageURLString.substring(imageURLString.indexOf("\""));
					imageURLString = imageURLString.substring(imageURLString.indexOf("\""));
					imageURLString = imageURLString.substring(0, imageURLString.indexOf("itemprop"));
//					System.out.println("image URL: " + imageURLString);				
					imageURLString = imageURLString.substring(1, imageURLString.length() - 1);
				} catch (IOException e) {
					e.printStackTrace();
				}
				finally {
					coverArt = drawer.loadImage(imageURLString);
					if(scan != null)
						scan.close();
				}				
				
				
				//look for <div class="poster">
					//look for ids around div
				//look for src="
				//look for "
			}
			
		});
		
		downloader.start();

	}

	
}
