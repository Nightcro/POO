package scheduler_type;

import input_output.HomeworkWriter;
import input_output.ProblemData;

/**
 * Clasa WeightedScheduler.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public class WeightedScheduler extends Scheduler {

	/**
	 * Instantiaza un nou weighted scheduler.
	 *
	 * @param out
	 *            fisierul de output
	 * @param in
	 *            o structura ProblemData avand fisierul de input prelucrat
	 */
	public WeightedScheduler(HomeworkWriter out, ProblemData in) {
		super(out, in);
	}

	/**
	 * Weighted run
	 * 
	 * in functie de cota fiecarui proces se va rula fiecare proces de un numar de
	 * ori, dat de: cota_proces / cmmdc
	 */
	@Override
	public void run() {
		int nr_list = 0;

		for (int i = 0, j = 0; i < numbersToBeProcessed.length;) {
			if (j == nrProcess) {
				j = 0;
			}

			int count = list[j].getWeight() / cmmdc;

			if (count != nr_list) {
				display(i, j);
				nr_list++;
				i++;
			} else {
				nr_list = 0;
				j++;
			}
		}
	}
}
