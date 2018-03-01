package process_type;

/**
 * Clasa Factorial.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public class Factorial extends Process {

	/**
	 * Instantiaza un nou factorial.
	 *
	 * @param weight
	 *            cota procesului
	 */
	public Factorial(int weight) {
		super(weight);
		type = "Factorial";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see process_type.Process#work()
	 */
	public int work() {
		if (number < 0) {
			return 0;
		}

		if (number == 0) {
			return 1;
		}

		int fact = 1;

		for (int i = 2; i <= number; i++) {
			fact = (fact * i) % 9973;
		}

		return fact;
	}
}
