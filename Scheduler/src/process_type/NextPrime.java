package process_type;

/**
 * Clasa NextPrime.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public class NextPrime extends Process {

	/**
	 * Instantiaza un nou next prime.
	 *
	 * @param weight
	 *            cota procesului
	 */
	public NextPrime(int weight) {
		super(weight);
		type = "NextPrime";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see process_type.Process#work()
	 */
	@Override
	public int work() {
		if (number < 2) {
			return 2;
		}

		CheckPrime ck = new CheckPrime(0);

		for (int i = number + 1;; i++) {
			ck.setNumber(i);

			if (ck.work() == 1) {
				return i;
			}
		}
	}
}
