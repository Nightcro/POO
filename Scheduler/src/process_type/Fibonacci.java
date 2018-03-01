package process_type;

/**
 * Clasa Fibonacci.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public class Fibonacci extends Process {

	/**
	 * Instantiaza un nou fibonacci.
	 *
	 * @param weight
	 *            cota procesului
	 */
	public Fibonacci(int weight) {
		super(weight);
		type = "Fibonacci";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see process_type.Process#work()
	 */
	@Override
	public int work() {
		if (number < 0) {
			return -1;
		}

		int first = 0, second = 1, next;

		for (int i = 1; i <= number; ++i) {
			next = first + second;
			first = second % 9973;
			second = next;
		}

		return first;
	}
}
