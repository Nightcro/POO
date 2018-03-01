package process_type;

/**
 * Clasa Square.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public class Square extends Process {

	/**
	 * Instantiaza un nou square.
	 *
	 * @param weight
	 *            cota procesului
	 */
	public Square(int weight) {
		super(weight);
		type = "Square";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see process_type.Process#work()
	 */
	@Override
	public int work() {
		return number * number;
	}
}
