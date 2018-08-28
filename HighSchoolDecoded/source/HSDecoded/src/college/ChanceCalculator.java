package college;
import java.util.ArrayList;
/**
 * code to calculate admission chances 
 * @author Lily
 *
 */
public class ChanceCalculator {
	
	private ArrayList<School> schools;
	private Search search;
	
	private School selectedSchool;
	
	private double totalTestScore;
	
	private boolean SATScoreReport;
	
	public void searchSchools(String str) {
		search = new Search(str);
		schools = search.getSchools();
	}
	
	public void displaySchools() {
		
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
		
		double percentage = 0.0;
		
		if(totalTestScore < at25) {
			percentage =  (totalTestScore)/(at25)*admissionRate * 0.25  * 100;		
		}
		else if(totalTestScore < atMidpoint) {
			percentage =  (totalTestScore - at25)/(atMidpoint - at25)*admissionRate * 0.75 * 100;		
		}
		else if(totalTestScore == atMidpoint) {
			percentage = admissionRate * 100;
		}
		else if(totalTestScore < at75) {
			percentage = (1+ (totalTestScore - atMidpoint)/(at75 - atMidpoint))*admissionRate * 100;
		}
		else{
			if(SATScoreReport)
				percentage = (1 + (totalTestScore - at75)/(1600 - at75))*admissionRate *100;
			else
				percentage = (1 + (totalTestScore - at75)/(36 - at75))*admissionRate * 100;
		}
		
		if(percentage < 0.0001) {
			percentage = 0;
		}
		System.out.println("printing percentage");

		return percentage;
	}
}
