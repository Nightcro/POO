package cache_type;

/**
 * Clasa ProcessType.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public class ProcessType {

	/** Tipul de proces. */
	public String type;

	/** Numarul de prelucrat. */
	public int work_number;

	/** Numarul prelucrat. */
	protected int final_number;

	/** De cate ori a fost apelat procesul cu numarul respectiv. */
	protected int work_count;

	/**
	 * Instantiaza un nou process type.
	 *
	 * @param type
	 *            tipul de proces
	 * @param work_number
	 *            numarul de prelucrat
	 * @param final_number
	 *            numarul prelucrat
	 */
	public ProcessType(String type, int work_number, int final_number) {
		this.type = type;
		this.work_number = work_number;
		this.final_number = final_number;
		work_count = 1;
	}

	/**
	 * Creste cu o unitate de cate ori a fost apelat procesul cu numarul respectiv.
	 */
	public void incWork_count() {
		work_count++;
	}

	/**
	 * Returneaza numarul prelucrat.
	 *
	 * @return numarul prelucrat
	 */
	public int getFinal_number() {
		return final_number;
	}
}
