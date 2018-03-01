package obs;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import tree.Node;
import tree.TreeVisitor;

/**
 * The Class Observer.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public class Observer implements IObserver {

	/** The node. Represents the filter. */
	private Node node;

	/** The boolean used to determine if we have a filter. */
	private boolean useFilter;

	/** The log in which the observer saves the last value of the feeds. */
	private TreeMap<String, FeedStructure> log;

	/** The index used to determine the position in the log_feed. */
	private int index;

	/**
	 * Instantiates a new observer with the corresponding filter.
	 *
	 * @param filter
	 *            the filter
	 */
	public Observer(String filter) {
		log = new TreeMap<String, FeedStructure>();

		if (!filter.contains("nil")) {
			useFilter = true;
			node = ObserversFactory.getObserversFactory().workTree(filter);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see obs.IObserver#workLog(int, java.util.List)
	 */
	@Override
	public void workLog(int id, List<String> log_feed) {
		Iterator<String> iter1 = log_feed.listIterator(index);

		while (iter1.hasNext()) {
			String[] message = iter1.next().split(" ");
			FeedStructure strut;
			index++;

			if ((message[0].equals("delete_obs")) || (message[0].equals("create_obs"))) {
				if ((id == Integer.parseInt(message[1]))) {

					for (Entry<String, FeedStructure> iter3 : log.entrySet()) {
						iter3.getValue().resetCountLastPrint();
					}
				}
			} else if (message[0].equals("print")) {
				continue;
			} else {
				if (log.containsKey(message[0])) {
					strut = log.get(message[0]);
					strut.setValue(Double.parseDouble(message[1]));
					strut.incCountLastPrint();
				} else {
					strut = new FeedStructure(message[0], Double.parseDouble(message[1]));
					log.put(message[0], strut);
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see obs.IObserver#update(int, java.util.List)
	 */
	@Override
	public void update(int id, List<String> log_feed) {
		workLog(id, log_feed);
		print(id);
	}

	/**
	 * Prints the latest value of the feeds.
	 *
	 * @param id
	 *            the id
	 */
	private void print(int id) {
		Iterator<FeedStructure> iter2 = log.values().iterator();

		while (iter2.hasNext()) {
			FeedStructure strut = iter2.next();

			if (useFilter) {
				if (node.accept(TreeVisitor.getTreeVisitor(strut.getName(), strut.getValue()))) {
					print_obs(id, strut);
				}
			} else {
				print_obs(id, strut);
			}
		}
	}

	/**
	 * Prints the feed.
	 *
	 * @param id
	 *            the id
	 * @param strut
	 *            the structure feed
	 */
	private void print_obs(int id, FeedStructure strut) {
		System.out.printf("obs %d: ", id);
		strut.print();
		strut.setLastIncreaseValue(strut.getValue());
		strut.resetCountLastPrint();
	}
}
