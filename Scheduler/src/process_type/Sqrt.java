package process_type;

/**
 * Clasa Sqrt.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public class Sqrt extends Process {

	/**
	 * Instantiaza un nou sqrt.
	 *
	 * @param weight
	 *            cota procesului
	 */
	public Sqrt(int weight) {
		super(weight);
		type = "Sqrt";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see process_type.Process#work()
	 */
	@Override
	public int work() {
		return (int) Math.floor(Math.sqrt(Math.abs(number)));
	}
}
