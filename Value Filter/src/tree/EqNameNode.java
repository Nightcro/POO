package tree;

/**
 * The Class EqNameNode.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public class EqNameNode extends Node implements IVisitable {

	/**
	 * Instantiates a new EqNameNode.
	 *
	 * @param name
	 *            the name of the feed
	 */
	public EqNameNode(String name) {
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
