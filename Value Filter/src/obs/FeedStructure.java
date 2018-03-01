package obs;

/**
 * The Class FeedStructure used methods, also used for storing information about
 * various feeds.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public class FeedStructure {

	/** The name. */
	private String name;

	/** The value. */
	private double value;

	/** The last increase value. */
	private double lastIncreaseValue;

	/** The count last print. */
	private int countLastPrint;

	/**
	 * Instantiates a new feed structure.
	 *
	 * @param name
	 *            the name of feed
	 * @param value
	 *            the value of feed
	 */
	public FeedStructure(String name, double value) {
		this.name = name;
		this.value = value;
		countLastPrint = 1;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value
	 *            the new value
	 */
	public void setValue(double value) {
		this.value = value;
	}

	/**
	 * Prints the name, value and last increase in percentage.
	 */
	public void print() {
		System.out.printf(name + " %.2f " + "%.2f%% ", value, calculateLastIncreaseValue());
		System.out.println(countLastPrint);
	}

	/**
	 * Sets the last increase value.
	 *
	 * @param lastIncreaseValue
	 *            the new last increase value
	 */
	public void setLastIncreaseValue(double lastIncreaseValue) {
		this.lastIncreaseValue = lastIncreaseValue;
	}

	/**
	 * Increase count last print.
	 */
	public void incCountLastPrint() {
		countLastPrint++;
	}

	/**
	 * Resets count last print.
	 */
	public void resetCountLastPrint() {
		countLastPrint = 0;
	}

	/**
	 * Calculates last increase value.
	 *
	 * @return the double
	 */
	public double calculateLastIncreaseValue() {
		if (lastIncreaseValue == 0) {
			lastIncreaseValue = value;
			return 0;
		}

		lastIncreaseValue = (value - lastIncreaseValue) * 100 / lastIncreaseValue;

		return lastIncreaseValue;
	}
}
