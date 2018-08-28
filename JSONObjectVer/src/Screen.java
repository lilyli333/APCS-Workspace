import java.util.ArrayList;
/**
 * 
 * @author lilili
 *
 */
public class Screen {
	
	private School[] schools;
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
		
		if(totalTestScore < at25) {
			return (totalTestScore)/(at25)*admissionRate * 0.25  * 100;		
		}
		else if(totalTestScore < atMidpoint) {
			return (totalTestScore - at25)/(atMidpoint - at25)*admissionRate * 0.75 * 100;		
		}
		else if(totalTestScore == atMidpoint) {
			return admissionRate * 100;
		}
		else if(totalTestScore < at75) {
			System.out.println("**at");
			return (1+ (totalTestScore - atMidpoint)/(at75 - atMidpoint))*admissionRate * 100;
		}
		else{
			if(SATScoreReport)
				return (1 + (totalTestScore - at75)/(1600 - at75))*admissionRate *100;
			else
				return (1 + (totalTestScore - at75)/(36 - at75))*admissionRate * 100;
		}
	}
	
	public static void main(String[] args) {
		
		Screen newScreen = new Screen();
		
		newScreen.searchSchools("stanford");
		newScreen.SATScoreReport = true;
		newScreen.selectedSchool = newScreen.schools[0];
		newScreen.totalTestScore = 1490;
		
		System.out.println(newScreen.calculateChance());

	}
}
