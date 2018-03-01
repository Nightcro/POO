package tree;

/**
 * The Class Node.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public class Node implements IVisitable {

	/** The left node. */
	public Node left;

	/** The right node. */
	public Node right;

	/** The value. */
	public double value;

	/** The name. */
	public String name;

	/**
	 * Instantiates a new node.
	 *
	 * @param left
	 *            the left node
	 * @param right
	 *            the right node
	 */
	public Node(Node left, Node right) {
		this.left = left;
		this.right = right;
	}

	/**
	 * Instantiates a new node.
	 *
	 * @param left
	 *            the left node
	 * @param right
	 *            the right node
	 * @param value
	 *            the value of the feed
	 */
	public Node(Node left, Node right, double value) {
		this.left = left;
		this.right = right;
		this.value = value;
	}

	/**
	 * Instantiates a new node.
	 *
	 * @param left
	 *            the left node
	 * @param right
	 *            the right node
	 * @param name
	 *            the name of the feed
	 */
	public Node(Node left, Node right, String name) {
		this.left = left;
		this.right = right;
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tree.IVisitable#accept(tree.IVisitor)
	 */
	@Override
	public boolean accept(IVisitor visitor) {
		return false;
	}
}