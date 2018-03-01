
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import obs.ISubject;
import obs.MessageSet;
import obs.Observer;

/**
 * The Class Feed determines the feed and methods used to process it.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public class Feed {

	/** The log in which is stored the input. */
	private List<String> log;

	/** The log feed which stores what will be iterated. */
	private List<String> log_feed;

	/** Where we get our input. */
	private Scanner in;

	/** The command stores a command issued from the log. */
	private String command;

	/** The message used to send a command to the observers. */
	private ISubject message;

	/**
	 * Instantiates a new feed.
	 *
	 * @param in
	 *            the InputStream
	 */
	public Feed(InputStream in) {
		this.in = new Scanner(in);
		message = new MessageSet();
		log = new ArrayList<String>();
		log_feed = new ArrayList<String>();
	}

	/**
	 * Gets the input.
	 */
	public void getInput() {

		do {
			command = in.nextLine();
		} while (!command.equals("begin"));

		command = in.nextLine();

		while (!command.equals("end")) {
			log.add(command);
			command = in.nextLine();
		}
	}

	/**
	 * Works the log by splitting every line in 3 substrings and checks the first
	 * position for which command is it.
	 */
	public void workLog() {
		if (log.isEmpty()) {
			System.err.println("Nu exista stream de date.");
			return;
		}

		for (int i = 0; i < log.size(); i++) {
			String[] line = log.get(i).split(" ", 3);

			if (line[0].equals("create_obs")) {
				log_feed.add(line[0] + " " + line[1]);
				message.add(Integer.parseInt(line[1]), new Observer(line[2]), log_feed);
			}

			if (line[0].equals("delete_obs")) {
				log_feed.add(line[0] + " " + line[1]);
				message.delete(Integer.parseInt(line[1]));
			}

			if (line[0].equals("feed")) {
				log_feed.add(line[1] + " " + line[2]);
			}

			if (line[0].equals("print")) {
				message.workObs(Integer.parseInt(line[1]), log_feed);
				log_feed.add(line[0] + " " + line[1]);
			}
		}
	}
}
