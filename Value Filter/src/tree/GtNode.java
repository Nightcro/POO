package tree;

/**
 * The Class GtNode.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public class GtNode extends Node implements IVisitable {

	/**
	 * Instantiates a new GtNode.
	 *
	 * @param value
	 *            the value of the feed
	 */
	public GtNode(double value) {
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
