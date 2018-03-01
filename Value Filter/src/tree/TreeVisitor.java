package tree;

/**
 * The Class TreeVisitor.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public class TreeVisitor implements IVisitor {

	/** The name of the feed to be verified. */
	private static String name;

	/** The value of the feed to be verified. */
	private static double value;

	/** The instance. */
	private static TreeVisitor INSTANCE;

	/**
	 * Instantiates a new tree visitor.
	 */
	private TreeVisitor() {

	}

	/**
	 * Gets the tree visitor.
	 *
	 * @param name_search
	 *            the name search
	 * @param value_search
	 *            the value search
	 * @return the tree visitor
	 */
	public static TreeVisitor getTreeVisitor(String name_search, double value_search) {
		if (INSTANCE == null) {
			INSTANCE = new TreeVisitor();
		}

		name = name_search;
		value = value_search;
		return INSTANCE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tree.IVisitor#visit(tree.EqNameNode)
	 */
	@Override
	public boolean visit(EqNameNode operatorNode) {
		return operatorNode.name.equals(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tree.IVisitor#visit(tree.NeNameNode)
	 */
	@Override
	public boolean visit(NeNameNode operatorNode) {
		return !operatorNode.name.equals(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tree.IVisitor#visit(tree.EqValueNode)
	 */
	@Override
	public boolean visit(EqValueNode operatorNode) {
		return operatorNode.value == value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tree.IVisitor#visit(tree.NeValueNode)
	 */
	@Override
	public boolean visit(NeValueNode operatorNode) {
		return operatorNode.value != value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tree.IVisitor#visit(tree.GtNode)
	 */
	@Override
	public boolean visit(GtNode operatorNode) {
		return operatorNode.value < value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tree.IVisitor#visit(tree.GeNode)
	 */
	@Override
	public boolean visit(GeNode operatorNode) {
		return operatorNode.value <= value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tree.IVisitor#visit(tree.LtNode)
	 */
	@Override
	public boolean visit(LtNode operatorNode) {
		return operatorNode.value > value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tree.IVisitor#visit(tree.LeNode)
	 */
	@Override
	public boolean visit(LeNode operatorNode) {
		return operatorNode.value >= value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tree.IVisitor#visit(tree.AndNode)
	 */
	@Override
	public boolean visit(AndNode operatorNode) {
		return operatorNode.left.accept(this) && operatorNode.right.accept(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tree.IVisitor#visit(tree.OrNode)
	 */
	@Override
	public boolean visit(OrNode operatorNode) {
		return operatorNode.left.accept(this) || operatorNode.right.accept(this);
	}
}
