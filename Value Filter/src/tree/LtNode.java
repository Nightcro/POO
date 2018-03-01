package tree;

/**
 * The Class LtNode.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public class LtNode extends Node implements IVisitable {

	/**
	 * Instantiates a new LtNode.
	 *
	 * @param value
	 *            the value of the feed
	 */
	public LtNode(double value) {
		super(null, null, value);
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
