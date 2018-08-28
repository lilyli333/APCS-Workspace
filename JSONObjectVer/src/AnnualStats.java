/**
 * represents the test score statistics for one year of a specified college
 * @author lilili
 *
 */
public class AnnualStats {
	
	private SATScores[] SATScores;
	private ACTScores[] ACTScores;
	/**
	 * 
	 * @param SATScores [0] 25th percentile, [1] midpoint, [2] 75th percentile
	 * @param ACTScores [0] 25th percentile, [1] midpoint, [2] 75th percentile
	 */
	public AnnualStats(SATScores[] SATScores, ACTScores[] ACTScores) {
		this.SATScores = SATScores;
		this.ACTScores = ACTScores;
	}
	
	public SATScores getSATScores(int index) {
		return SATScores[index];
	}
	public ACTScores getACTScores(int index) {
		return ACTScores[index];
	}
	
}
