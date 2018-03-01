package tree;

/**
 * The Class OrNode.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public class OrNode extends Node implements IVisitable {

	/**
	 * Instantiates a new OrNode.
	 *
	 * @param left
	 *            the left node
	 * @param right
	 *            the right node
	 */
	public OrNode(Node left, Node right) {
		super(left, right);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tree.Node#accept(tree.IVisitor)
	 */
	@Override
	public boolean accept(IVisitor visitor) {
		return visitor.visit(this);
	}
}
