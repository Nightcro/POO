package tree;

/**
 * The Interface IVisitor.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public interface IVisitor {

	/**
	 * Visit the node and evaluates the name of the feed.
	 *
	 * @param operatorNode
	 *            the operator node
	 * @return true, if successful
	 */
	public boolean visit(EqNameNode operatorNode);

	/**
	 * Visit the node and evaluates the name of the feed.
	 *
	 * @param operatorNode
	 *            the operator node
	 * @return true, if successful
	 */
	public boolean visit(NeNameNode operatorNode);

	/**
	 * Visit the node and evaluates the value of the feed.
	 *
	 * @param operatorNode
	 *            the operator node
	 * @return true, if successful
	 */
	public boolean visit(EqValueNode operatorNode);

	/**
	 * Visit the node and evaluates the value of the feed.
	 *
	 * @param operatorNode
	 *            the operator node
	 * @return true, if successful
	 */
	public boolean visit(NeValueNode operatorNode);

	/**
	 * Visit the node and evaluates the value of the feed.
	 *
	 * @param operatorNode
	 *            the operator node
	 * @return true, if successful
	 */
	public boolean visit(GtNode operatorNode);

	/**
	 * Visit the node and evaluates the value of the feed..
	 *
	 * @param operatorNode
	 *            the operator node
	 * @return true, if successful
	 */
	public boolean visit(GeNode operatorNode);

	/**
	 * Visit the node and evaluates the value of the feed.
	 *
	 * @param operatorNode
	 *            the operator node
	 * @return true, if successful
	 */
	public boolean visit(LtNode operatorNode);

	/**
	 * Visit the node and evaluates the value of the feed.
	 *
	 * @param operatorNode
	 *            the operator node
	 * @return true, if successful
	 */
	public boolean visit(LeNode operatorNode);

	/**
	 * Visit the node and evaluates the right and left node.
	 *
	 * @param operatorNode
	 *            the operator node
	 * @return true, if successful
	 */
	public boolean visit(AndNode operatorNode);

	/**
	 * Visit the node and evaluates the right and left node.
	 *
	 * @param operatorNode
	 *            the operator node
	 * @return true, if successful
	 */
	public boolean visit(OrNode operatorNode);
}
