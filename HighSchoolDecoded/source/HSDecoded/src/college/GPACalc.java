package college;
/**
 * This represents a GPA Calculator with methods to calculator weighted/unweighted
 * GPA and grades
 * @author Lily
 *
 */
public class GPACalc {
	/**
	 * 
	 * @param a number of 'A' letter grades received
	 * @param b number of 'B' letter grades received
	 * @param c number of 'C' letter grades received
	 * @param d number of 'D' letter grades received
	 * @param f number of 'F' letter grades received
	 * @param honor number of honors or AP grades received
	 * @return the weighted GPA given the number of classes 
	 */
	public static double weightedGPA(int a, int b, int c, int d, int f, int honor) {
		if(a < 0 || b < 0 || c < 0 || d < 0 || f < 0 ||honor < 0)
			throw new ArithmeticException();
		return (double)(a * 4 + b * 3 + c * 2 + d + honor)/(a + b + c + d + f);
	}
	
	/**
	 * 
	 * @param a number of 'A' letter grades received
	 * @param b number of 'B' letter grades received
	 * @param c number of 'C' letter grades received
	 * @param d number of 'D' letter grades received
	 * @param f number of 'F' letter grades received
	 * @return the unweighted GPA given the number of classes 
	 */
	public static double calcGPA(int a, int b, int c, int d, int f) {
		return (double)(a * 4 + b * 3 + c * 2 + d)/(a + b + c + d + f);
	}
	
	/**
	 * 
	 * @param current the current grade 
	 * @param wantedGrade the grade wanted in the class
	 * @param examWorth the percentage (between 0% and 100%) the exam is worth
	 * @return The percent grade needed to get the desired grade
	 */
	public static double finalsGradesCalculator (double current, double wantedGrade, double examWorth) {
		//Grade = Exam Worth × Exam Score + (100% − Exam Worth) × Current Grade
		return (wantedGrade - ((1.0 - examWorth/100.0) * current))/(examWorth/100.0);
	}
}
