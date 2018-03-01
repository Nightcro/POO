package tree;

/**
 * The Class AndNode.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public class AndNode extends Node implements IVisitable {

	/**
	 * Instantiates a new AndNode.
	 *
	 * @param left
	 *            the left node
	 * @param right
	 *            the right node
	 */
	public AndNode(Node left, Node right) {
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
