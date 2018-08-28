package college;
import java.util.ArrayList;
/**
 * representing the entities being added whenever the search college button is pressed
 * @author Lily
 *
 */
public class SearchFunction {

	private ArrayList<School> schools;
	private Search search;

	private School selectedSchool;

	private double totalTestScore;

	private boolean SATScoreReport;
	private boolean success;

	public SearchFunction(String str, double totalTestScore, boolean SATScoreReport) {
		search = new Search(str);
		schools = search.getSchools();

		this.totalTestScore = totalTestScore;
		this.SATScoreReport = SATScoreReport;
		this.success = search.getSuccess();
	}
	
	public boolean getSuccess() {
		return success;
	}

	public ArrayList<School> getSchools() {
		return schools;
	}
	/**
	 * calculates the chance given the field for selectedScool (school), totalTestScore (double representing total or average score), and boolean field SATScoreReport determining whether score is given for SAT or ACT
	 * @return the double between 0 to 100 percent for the admission chances calculated
	 */
	public double calculateChance() {

		double at25, atMidpoint, at75, admissionRate;

		admissionRate = selectedSchool.getAdmissionRate();

		if(SATScoreReport) {
			at25 = selectedSchool.getStats().getSATScores(0).getTotalScore();
			atMidpoint = selectedSchool.getStats().getSATScores(1).getTotalScore();
			at75 = selectedSchool.getStats().getSATScores(2).getTotalScore();

			System.out.println("at25: " + at25 + ", atMidpoint: " + atMidpoint + ", at75:" + at75);
		}
		else {
			at25 = selectedSchool.getStats().getACTScores(0).getTotalScore();
			atMidpoint = selectedSchool.getStats().getACTScores(1).getTotalScore();
			at75 = selectedSchool.getStats().getACTScores(2).getTotalScore();
		}
		
		double chance = 0;

		if(totalTestScore < at25) {
			chance =  (totalTestScore)/(at25)*admissionRate * 0.25  * 100;		
		}
		else if(totalTestScore < atMidpoint) {
			chance =  (totalTestScore - at25)/(atMidpoint - at25)*admissionRate * 0.75 * 100;		
		}
		else if(totalTestScore == atMidpoint) {
			chance = admissionRate * 100;
		}
		else if(totalTestScore < at75) {
			System.out.println("**at");
			chance = (1+ (totalTestScore - atMidpoint)/(at75 - atMidpoint))*admissionRate * 100;
		}
		else{
			if(SATScoreReport)
				chance = (1 + (totalTestScore - at75)/(1600 - at75))*admissionRate *100;
			else
				chance = (1 + (totalTestScore - at75)/(36 - at75))*admissionRate * 100;
		}
		
		if(chance < 0.0001) {
			return 0;
		}
		System.out.println("printing chance");
		return chance;
	}
	public static void main(String[] args) {
		SearchFunction sf = new SearchFunction("boston", 1490, true);
		ArrayList<School> schools = sf.getSchools();
		for(School sc : schools) {
			System.out.println(sc.getName());
		}
	}
}
