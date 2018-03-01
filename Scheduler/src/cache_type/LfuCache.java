package cache_type;

/**
 * Clasa LfuCache.
 *
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public class LfuCache extends Cache {

	/**
	 * Instantiaza un nou lfu cache.
	 *
	 * @param max
	 *            numarul maxim de elemente
	 */
	public LfuCache(int max) {
		super(max);
	}

	/**
	 * Lfu inc
	 * 
	 * se modifica de cate ori a fost apelat procesul cu numarul respectiv
	 */
	@Override
	protected void inc(int nr_temp) {
		cache[nr_temp].incWork_count();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cache_type.Cache#add(cache_type.Process_structure)
	 */
	@Override
	public void add(ProcessType temp) {
		if (nr < max) {
			cache[nr++] = temp;
		} else {
			int id = findMin(cache);
			cache[id] = temp;
		}
	}

	/**
	 * Cauta procesul care a fost apelat de cele mai putine ori.
	 * 
	 * @param temp
	 *            vectorul cache
	 * @return indexul procesului gasit
	 */
	private int findMin(ProcessType[] temp) {
		int id = 0, min = temp[0].work_count;

		for (int i = 0; i < max; i++) {
			if (temp[i].work_count < min) {
				min = temp[i].work_count;
				id = i;
			}
		}

		return id;
	}
}
