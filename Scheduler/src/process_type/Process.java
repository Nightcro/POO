package process_type;

/**
 * Clasa Process.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public abstract class Process {

	/** Numarul de prelucrat. */
	protected int number = 0;

	/** Cota procesului. */
	protected int weight = 0;

	/** Tipul de proces. */
	protected String type;

	/**
	 * Instantiaza un nou process.
	 *
	 * @param weight
	 *            cota procesului
	 */
	public Process(int weight) {
		this.weight = weight;
	}

	/**
	 * Seteaza numarul pentru prelucrat.
	 *
	 * @param number
	 *            numarul de prelucrat
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * Returneaza tipul procesului.
	 *
	 * @return tipul de proces
	 */
	public String getType() {
		return type;
	}

	/**
	 * Returneaza cota procesului.
	 *
	 * @return cota procesului
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * Ruleaza procesul respectiv pe numarul setat.
	 *
	 * @return numarul prelucrat
	 */
	public abstract int work();
}
