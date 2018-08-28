/**
 * a college entity that is pulled from online JSON library
 * @author lilili
 *
 */
public class School {
	private AnnualStats annualStats;
	private String name, city, state, url;
	private double admissionRate;
	
	public School(String name, String city, String state, String url, double admissionRate, AnnualStats annualStats) {
		this.name = name;
		this.city = city;
		this.state = state;
		this.url = url;
		this.annualStats = annualStats;
		this.admissionRate = admissionRate;
	}
	
	public AnnualStats getStats() {
		return annualStats;
	}
	
	public double getAdmissionRate() {
		return admissionRate;
	}
	
}
