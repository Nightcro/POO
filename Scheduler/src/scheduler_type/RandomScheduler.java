package scheduler_type;

import java.util.Random;

import input_output.HomeworkWriter;
import input_output.ProblemData;

/**
 * Clasa RandomScheduler.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public class RandomScheduler extends Scheduler {

	/**
	 * Instantiaza un nou random scheduler.
	 *
	 * @param out
	 *            fisierul de output
	 * @param in
	 *            o structura ProblemData avand fisierul de input prelucrat
	 */
	public RandomScheduler(HomeworkWriter out, ProblemData in) {
		super(out, in);
	}

	/**
	 * Random run
	 * 
	 * se alege un proces la intamplare si se ruleaza procesul respectiv
	 */
	@Override
	public void run() {
		for (int i = 0; i < numbersToBeProcessed.length; i++) {
			Random random = new Random();
			int nr = random.nextInt(list.length);
			display(i, nr);
		}
	}
}