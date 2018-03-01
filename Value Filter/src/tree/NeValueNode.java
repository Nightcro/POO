package tree;

/**
 * The Class NeValueNode.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public class NeValueNode extends Node implements IVisitable {

	/**
	 * Instantiates a new NeValueNode.
	 *
	 * @param value
	 *            the value of the feed
	 */
	public NeValueNode(double value) {
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
