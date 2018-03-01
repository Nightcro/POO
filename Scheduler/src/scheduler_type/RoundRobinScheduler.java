package scheduler_type;

import input_output.HomeworkWriter;
import input_output.ProblemData;

/**
 * Clasa RoundRobinScheduler.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public class RoundRobinScheduler extends Scheduler {

	/**
	 * Instantiaza un nou round robin scheduler.
	 *
	 * @param out
	 *            fisierul de output
	 * @param in
	 *            o structura ProblemData avand fisierul de input prelucrat
	 */
	public RoundRobinScheduler(HomeworkWriter out, ProblemData in) {
		super(out, in);
	}

	/**
	 * RoundRobin run
	 * 
	 * va rula fiecare proces cu o diferenta de o unitate de timp intre ele.
	 */
	@Override
	public void run() {
		for (int i = 0; i < numbersToBeProcessed.length; i++) {
			display(i, i % nrProcess);
		}
	}
}
