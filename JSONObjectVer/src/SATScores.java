/**
 * represents a set of SAT scores with critical reading/writing/math/total aspects
 * only total is used to determine admission chances because some colleges does not provide all relevant information.
 * @author lilili
 *
 */
public class SATScores {
	
	private double critical_reading, writing, math;
	private int total;
	
	public SATScores(double critical_reading, double writing, double math) {
		this.critical_reading = critical_reading;
		this.writing = writing;
		this.math = math;
		
		total = (int)(math + critical_reading);
	}
	
	public SATScores(int total) {
		this.total = total;
		writing = -1;
		math = -1;
		critical_reading = -1;
	}
	public SATScores(double critical_reading, double math) {
		this.critical_reading = critical_reading;
		this.math = math;
		writing = -1;
		total = (int)(math + critical_reading);
	}
	
	public int getTotalScore() {
		return total;
	}
}
