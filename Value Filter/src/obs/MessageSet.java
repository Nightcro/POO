package obs;

import java.util.HashMap;
import java.util.List;

/**
 * The Class MessageSet.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public class MessageSet implements ISubject {

	/** The observer map. The key is determined by the id. */
	private HashMap<Integer, IObserver> obsMap = new HashMap<Integer, IObserver>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see obs.ISubject#workObs(int, java.util.List)
	 */
	public void workObs(int id, List<String> log_feed) {
		obsMap.get(id).update(id, log_feed);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see obs.ISubject#add(int, obs.IObserver, java.util.List)
	 */
	@Override
	public void add(int id, IObserver obs, List<String> log_feed) {
		obsMap.put(id, obs);
		obs.workLog(id, log_feed);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see obs.ISubject#delete(int)
	 */
	@Override
	public void delete(int id) {
		obsMap.remove(id);
	}
}
