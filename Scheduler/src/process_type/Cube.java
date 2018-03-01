package process_type;

/**
 * Clasa Cube.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public class Cube extends Process {

	/**
	 * Instantiaza un nou cube.
	 *
	 * @param weight
	 *            cota procesului
	 */
	public Cube(int weight) {
		super(weight);
		type = "Cube";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see process_type.Process#work()
	 */
	@Override
	public int work() {
		return number * number * number;
	}
}
