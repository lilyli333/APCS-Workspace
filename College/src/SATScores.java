import java.util.Map;

public class SATScores{
	
	private SATSystem at25th_percentile, at75th_percentile, midpoint;
	private Map<String, String> average;
	
	public String getAvgScore() {
		return average.get("overall");
	}
}
