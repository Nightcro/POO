package tree;

/**
 * The Class GeNode.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public class GeNode extends Node implements IVisitable {

	/**
	 * Instantiates a new GeNode.
	 *
	 * @param value
	 *            the value of the feed
	 */
	public GeNode(double value) {
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
