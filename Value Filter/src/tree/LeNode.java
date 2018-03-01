package tree;

/**
 * The Class LeNode.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public class LeNode extends Node implements IVisitable {

	/**
	 * Instantiates a new LeNode.
	 *
	 * @param value
	 *            the value of the feed
	 */
	public LeNode(double value) {
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
