package obs;

import java.util.List;

/**
 * The Interface ISubject.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public interface ISubject {

	/**
	 * Issues a command to the observer to print.
	 *
	 * @param id
	 *            the id
	 * @param log_feed
	 *            the log feed
	 */
	public void workObs(int id, List<String> log_feed);

	/**
	 * Adds an observer to the list and issues the command inside the observer to
	 * work the log.
	 *
	 * @param id
	 *            the id
	 * @param obs
	 *            the obs
	 * @param log_feed
	 *            the log feed
	 */
	public void add(int id, IObserver obs, List<String> log_feed);

	/**
	 * Deletes the observer with the specified id.
	 *
	 * @param id
	 *            the id
	 */
	public void delete(int id);
}