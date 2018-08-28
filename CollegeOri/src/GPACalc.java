
/**
 * This represents a GPA Calculator with methods to calculator weighted/unweighted
 * GPA and grades
 * @author lilili
 *
 */
public class GPACalc {
	
	public static double weightedGPA(int a, int b, int c, int d, int f, int honor) {
		if(a < 0 || b < 0 || c < 0 || d < 0 || f < 0 ||honor < 0)
			throw new ArithmeticException();
		return (double)(a * 4 + b * 3 + c * 2 + d + honor)/(a + b + c + d + f);
	}
	
	public static double calcGPA(int a, int b, int c, int d, int f) {
		return (double)(a * 4 + b * 3 + c * 2 + d)/(a + b + c + d + f);
	}
	
	public static double finalsGradesCalculator (double current, double wantedGrade, double examWorth) {
		//Grade = Exam Worth × Exam Score + (100% − Exam Worth) × Current Grade
		return (wantedGrade- ((1.0 - examWorth) * current))/examWorth;
	}
}
