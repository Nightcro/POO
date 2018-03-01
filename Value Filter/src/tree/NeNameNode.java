package tree;

/**
 * The Class NeNameNode.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public class NeNameNode extends Node implements IVisitable {

	/**
	 * Instantiates a new NeNameNode.
	 *
	 * @param name
	 *            the name of the feed
	 */
	public NeNameNode(String name) {
		super(null, null, name);
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
