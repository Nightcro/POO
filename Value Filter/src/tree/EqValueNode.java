package tree;

/**
 * The Class EqValueNode.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public class EqValueNode extends Node implements IVisitable {

	/**
	 * Instantiates a new EqValueNode.
	 *
	 * @param value
	 *            the value of the feed
	 */
	public EqValueNode(double value) {
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
