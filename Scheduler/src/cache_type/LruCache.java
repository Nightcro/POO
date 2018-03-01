package cache_type;

/**
 * Clasa LruCache.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public class LruCache extends Cache {

	/**
	 * Instantiaza un nou lru cache.
	 *
	 * @param max
	 *            numarul maxim de elemente
	 */
	public LruCache(int max) {
		super(max);
	}

	/**
	 * Lru inc
	 * 
	 * se reactualizeaza pozitia procesului gasit in cache
	 */
	@Override
	protected void inc(int nr_temp) {
		ProcessType save = cache[nr_temp];

		for (int i = nr_temp; i < nr - 1; i++) {
			cache[i] = cache[i + 1];
		}

		cache[nr - 1] = save;
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
			for (int i = 0; i < nr - 1; i++) {
				cache[i] = cache[i + 1];
			}

			cache[nr - 1] = temp;
		}
	}
}
