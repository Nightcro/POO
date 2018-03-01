package tree;

/**
 * The Class Values it contains information used by various methods and
 * constructors of other classes.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public class Values {

	/** The type of node. */
	public String node;

	/** The name of the feed. */
	public String name;

	/** The value of the feed. */
	public double value;

	/** The left node. */
	public Node left;

	/** The right node. */
	public Node right;

	/**
	 * Instantiates a new value structure.
	 *
	 * @param node
	 *            the node
	 * @param name
	 *            the name
	 */
	public Values(String node, String name) {
		this.node = node;
		this.name = name;
	}

	/**
	 * Instantiates a new value structure.
	 *
	 * @param node
	 *            the node
	 * @param value
	 *            the value
	 */
	public Values(String node, double value) {
		this.node = node;
		this.value = value;
	}

	/**
	 * Instantiates a new value structure.
	 *
	 * @param node
	 *            the node
	 * @param left
	 *            the left node
	 * @param right
	 *            the right node
	 */
	public Values(String node, Node left, Node right) {
		this.node = node;
		this.left = left;
		this.right = right;
	}
}
