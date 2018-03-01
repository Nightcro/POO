package scheduler_type;

import input_output.HomeworkWriter;
import cache_type.Cache;
import cache_type.LfuCache;
import cache_type.LruCache;
import cache_type.ProcessType;
import input_output.ProblemData;
import input_output.ProcessStructure;
import process_type.CheckPrime;
import process_type.Cube;
import process_type.Factorial;
import process_type.Fibonacci;
import process_type.NextPrime;
import process_type.Process;
import process_type.Sqrt;
import process_type.Square;

/**
 * Clasa Scheduler.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public abstract class Scheduler {

	/** Fisierul de output. */
	protected HomeworkWriter out;

	/** Lista cu procese. */
	protected Process[] list;

	/** Numerele ce trebuie sa fie procesate. */
	protected int[] numbersToBeProcessed;

	/** Numerele de procese. */
	protected int nrProcess;

	/** Cel mai mare divizor comun. */
	protected int cmmdc;

	/** Tipul de cache folosit. */
	protected String cache;

	/** Structucra cache din care se iau valori deja prelucrate. */
	protected Cache help;

	/** Valoare ce reprezinta daca se utilizeaza un Cache. */
	protected boolean useCache;

	/**
	 * Instantiaza un nou scheduler.
	 *
	 * @param out
	 *            fisierul de output
	 * @param in
	 *            o structura ProblemData avand fisierul de input prelucrat
	 */
	public Scheduler(HomeworkWriter out, ProblemData in) {
		this.out = out;
		this.numbersToBeProcessed = in.getNumbersToBeProcessed();

		ProcessStructure[] input = in.getProcesses();
		nrProcess = input.length;
		this.list = new Process[nrProcess];
		int nr_cmmdc = input[0].getWeight();
		useCache = false;

		for (int i = 0; i < nrProcess; i++) {
			int weight = input[i].getWeight();

			if (input[i].getType().equals("CheckPrime")) {
				list[i] = new CheckPrime(weight);
			} else if (input[i].getType().equals("NextPrime")) {
				list[i] = new NextPrime(weight);
			} else if (input[i].getType().equals("Fibonacci")) {
				list[i] = new Fibonacci(weight);
			} else if (input[i].getType().equals("Sqrt")) {
				list[i] = new Sqrt(weight);
			} else if (input[i].getType().equals("Square")) {
				list[i] = new Square(weight);
			} else if (input[i].getType().equals("Cube")) {
				list[i] = new Cube(weight);
			} else if (input[i].getType().equals("Factorial")) {
				list[i] = new Factorial(weight);
			}

			nr_cmmdc = cmmdc(weight, nr_cmmdc);
		}

		cmmdc = nr_cmmdc;
		int max_cache = in.getCacheCapacity();

		if (in.getCacheType().equals("LruCache")) {
			useCache = true;
			help = new LruCache(max_cache);
		} else if (in.getCacheType().equals("LfuCache")) {
			useCache = true;
			help = new LfuCache(max_cache);
		}
	}

	/**
	 * Cel mai mare divizor comun.
	 *
	 * @param a
	 *            numarul a
	 * @param b
	 *            numarul b
	 * @return cmmdc
	 */
	public int cmmdc(int a, int b) {
		int c;

		while (b != 0) {
			c = a % b;
			a = b;
			b = c;
		}

		return a;
	}

	/**
	 * Afiseaza numarul de prelucrat, tipul de proces si numarul prelucrat
	 *
	 * @param index_number
	 *            indexul numarului de procesat
	 * @param index_process
	 *            indexul procesului care va procesa numarul
	 */
	public void display(int index_number, int index_process) {
		int number = numbersToBeProcessed[index_number];
		list[index_process].setNumber(number);
		String type = list[index_process].getType();

		if (useCache == false) {
			out.println(number + " " + type + " " + list[index_process].work() + " Computed");
		} else {
			ProcessType check = help.searchCache(type, number);

			if (check == null) {
				int worked = list[index_process].work();
				out.println(number + " " + type + " " + worked + " Computed");
				ProcessType temp = new ProcessType(type, number, worked);
				help.add(temp);
			} else {
				out.println(number + " " + type + " " + check.getFinal_number() + " FromCache");
			}
		}
	}

	/**
	 * Ruleaza scheduler-ul ales.
	 */
	public abstract void run();
}
