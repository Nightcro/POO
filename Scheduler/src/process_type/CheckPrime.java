package process_type;

/**
 * Clasa CheckPrime.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public class CheckPrime extends Process {

	/**
	 * Instantiaza un nou check prime.
	 *
	 * @param weight
	 *            cota procesului
	 */
	public CheckPrime(int weight) {
		super(weight);
		type = "CheckPrime";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see process_type.Process#work()
	 */
	@Override
	public int work() {

		if (number <= 1) {
			return 0;
		}

		if (number == 2) {
			return 1;
		}

		int help = (int) Math.floor(Math.sqrt(number));

		for (int i = 2; i <= help; i++) {
			if (number % i == 0) {
				return 0;
			}
		}

		return 1;
	}
}
