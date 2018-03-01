package obs;

import java.util.List;

/**
 * An asynchronous update interface for receiving notifications about Feed
 * information as the Feed is constructed.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public interface IObserver {

	/**
	 * This method is called when information about a Feed which was previously
	 * requested using an asynchronous interface becomes available. Used when an
	 * observer is issued the command to print.
	 *
	 * @param id
	 *            the id of the observer
	 * @param log_feed
	 *            the log of the feed up to the moment of the observer's creation
	 */
	public void workLog(int id, List<String> log_feed);

	/**
	 * This method is called when information about a Feed which was previously
	 * requested using an asynchronous interface becomes available. Used when an
	 * observer is created
	 *
	 * @param id
	 *            the id of the observer
	 * @param log_feed
	 *            the log of the feed up to the moment the print command is issued
	 */
	public void update(int id, List<String> log_feed);
}
