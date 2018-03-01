
import input_output.HomeworkReader;
import input_output.HomeworkWriter;
import input_output.ProblemData;
import scheduler_type.RandomScheduler;
import scheduler_type.RoundRobinScheduler;
import scheduler_type.Scheduler;
import scheduler_type.WeightedScheduler;

/**
 * Clasa MainClass.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public class MainClass {

	/**
	 * Metoda main.
	 *
	 * @param args
	 *            vector ce contine fisierele de input si output
	 */
	public static void main(String[] args) {

		HomeworkReader in = new HomeworkReader(args[0]);
		ProblemData input = in.readData();
		in.close();

		HomeworkWriter out = new HomeworkWriter(args[1]);
		work(out, input);
		out.close();
	}

	/**
	 * Prelucrarea datelor in functie de scheduler.
	 *
	 * @param out
	 *            fisierul de output
	 * @param input
	 *            fisierul de input
	 */
	public static void work(HomeworkWriter out, ProblemData input) {
		Scheduler schd = null;
		String schedulerType = input.getSchedulerType();

		if (schedulerType.equals("RandomScheduler")) {
			schd = new RandomScheduler(out, input);
		} else if (schedulerType.equals("RoundRobinScheduler")) {
			schd = new RoundRobinScheduler(out, input);
		} else if (schedulerType.equals("WeightedScheduler")) {
			schd = new WeightedScheduler(out, input);
		}

		if (schd != null) {
			schd.run();
		}
	}
}
