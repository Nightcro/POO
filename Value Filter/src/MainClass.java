
/**
 * The Class MainClass.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public class MainClass {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		Feed bussiness = new Feed(System.in);

		bussiness.getInput();
		bussiness.workLog();
	}
}
