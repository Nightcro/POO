package cache_type;

/**
 * Clasa Cache.
 *
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public abstract class Cache {

	/** Vectorul cache cu procese. */
	protected ProcessType[] cache;

	/** Numarul actual de elemente aflate in cache. */
	protected int nr;

	/** Numarul maxim alocat de elemente pentru cache. */
	protected int max;

	/**
	 * Instantiaza un nou cache.
	 *
	 * @param max
	 *            numarul maxim de elemente
	 */
	protected Cache(int max) {
		this.max = max;
		cache = new ProcessType[max];
	}

	/**
	 * Cauta in cache.
	 *
	 * @param type
	 *            tipul de proces
	 * @param work_number
	 *            numarul prelucrat de proces
	 * @return procesul cu numarul prelucrat
	 */
	public ProcessType searchCache(String type, int work_number) {
		for (int i = 0; i < nr; i++) {
			if (cache[i].type.equals(type) && (cache[i].work_number == work_number)) {
				ProcessType save = cache[i];
				inc(i);
				return save;
			}
		}

		return null;
	}

	/**
	 * Adauga in cache.
	 *
	 * @param temp
	 *            procesul de adaugat
	 */
	public abstract void add(ProcessType temp);

	/**
	 * Modifica un parametru din proces-ul adaugat in functie de cache.
	 *
	 * @param nr_temp
	 *            indexul din cache la care se afla procesul
	 */
	protected abstract void inc(int nr_temp);
}
