import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 *represents the entities after the "search" button is pressed
 *includes JSON parsing and organizes data into objects
 * @author lilili
 *
 */
public class Search {

	private long numResults;
	private School[] results;
	private String searchName;

	public Search(String searchName) {
		this.searchName = searchName;
		
		JSONParser parser = new JSONParser();
		this.searchName = searchName;
		try {
			//get numResults
			String fileData = new String(Files.readAllBytes(Paths.get(searchName)));
			JSONObject arr = (JSONObject) parser.parse(fileData);
			JSONObject metadata = (JSONObject) arr.get("metadata");
			numResults = (long)metadata.get("total");

			//initialize array of results
			results = new School[(int) numResults];
			JSONArray resultLs = (JSONArray) arr.get("results");


			for(int i = 0; i < results.length; i++) {
				//get scores stats
				JSONObject collegeFind = (JSONObject) resultLs.get(i);
				JSONObject yearStats = (JSONObject) collegeFind.get("2015");
				JSONObject admissions = (JSONObject) yearStats.get("admissions");
				JSONObject admission_rate = (JSONObject) admissions.get("admission_rate");
				if(admission_rate.get("overall") == null)
					break;
				double overallAdmissionRate = (double)admission_rate.get("overall");

				SATScores[] SATScores = new SATScores[3];
				JSONObject sat_scores = (JSONObject)admissions.get("sat_scores");
				
				//25th percentile
				JSONObject sat_scores_25 = (JSONObject)sat_scores.get("25th_percentile");
					//check for null
					if(sat_scores_25.get("critical_reading") == null || sat_scores_25.get("math") == null)
						break;
				SATScores at25 = new SATScores((double)sat_scores_25.get("critical_reading"), (double)sat_scores_25.get("math"));
				SATScores[0] = at25;

				//midpoint
				JSONObject sat_scores_midpoint = (JSONObject)sat_scores.get("midpoint");
					//check for null
					if(sat_scores_midpoint.get("critical_reading") == null || sat_scores_midpoint.get("math") == null)
						break;
				SATScores atmidpoint = new SATScores((double)sat_scores_midpoint.get("critical_reading"),(double)sat_scores_midpoint.get("math"));
				SATScores[1] = atmidpoint;

				//75th percentile
				JSONObject sat_scores_75 = (JSONObject)sat_scores.get("75th_percentile");
					//check for sat_scores_75
					if(sat_scores_midpoint.get("critical_reading") == null || sat_scores_75.get("math") == null)
						break;
				SATScores at75 = new SATScores((double)sat_scores_75.get("critical_reading"), (double)sat_scores_75.get("math"));	
				SATScores[2] = at75;

				ACTScores[] ACTScores = new ACTScores[3];
				JSONObject act_scores = (JSONObject)admissions.get("act_scores");

				//25th percentile
				JSONObject act_scores_25 = (JSONObject)act_scores.get("25th_percentile");
					//check for sat_scores_75
					if(act_scores_25.get("cumulative") == null)
						break;
				ACTScores act_at25 = new ACTScores((double)act_scores_25.get("cumulative"));
				ACTScores[0] = act_at25;

				//midpoint
				JSONObject act_scores_midpoint = (JSONObject)act_scores.get("midpoint");
					//check for sat_scores_75
					if(act_scores_midpoint.get("cumulative") == null)
						break;
				ACTScores act_atmidpoint = new ACTScores((double)act_scores_midpoint.get("cumulative"));
				ACTScores[1] = act_atmidpoint;

				//75th percentile
				JSONObject act_scores_75 = (JSONObject)act_scores.get("75th_percentile");
					//check for sat_scores_75
					if(act_scores_75.get("cumulative") == null)
						break;
				ACTScores act_at75 = new ACTScores((double)act_scores_75.get("cumulative"));
				ACTScores[1] = act_at75;

				AnnualStats annualStats = new AnnualStats(SATScores, ACTScores);
				//get school info
				JSONObject schoolInfo = (JSONObject)collegeFind.get("school");
				String city = (String)schoolInfo.get("city");
				String state = (String)schoolInfo.get("state");
				String url = (String)schoolInfo.get("school_url");
				String name = (String)schoolInfo.get("name");

				results[i] = new School(name, city, state, url, overallAdmissionRate, annualStats);

				System.out.println("city: " + city + ", state: " + state + ", name: " + name + ", url: " + url);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public School getSchool(int index) {
		return results[index];
	}
	
	public School[] getSchools(){
		return results;
	}
	
	
	public static void main(String[] args) {

		Search sc = new Search("stanford");
		
		System.out.println(sc.getSchool(0).getStats().getSATScores(1).getTotalScore());

	}

}
