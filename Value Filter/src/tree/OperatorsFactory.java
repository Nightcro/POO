package tree;

/**
 * A factory for creating Operators objects.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public class OperatorsFactory {

	/**
	 * Creates a new Operators object.
	 *
	 * @param info
	 *            a structure that contains the required information to form a
	 *            coressponding node
	 * @return the node
	 */
	public static Node createNode(Values info) {

		if (info.node.equals("eq name")) {
			return new EqNameNode(info.name);
		} else if (info.node.equals("ne name")) {
			return new NeNameNode(info.name);
		} else if (info.node.equals("eq value")) {
			return new EqValueNode(info.value);
		} else if (info.node.equals("ne value")) {
			return new NeValueNode(info.value);
		} else if (info.node.equals("gt")) {
			return new GtNode(info.value);
		} else if (info.node.equals("ge")) {
			return new GeNode(info.value);
		} else if (info.node.equals("lt")) {
			return new LtNode(info.value);
		} else if (info.node.equals("le")) {
			return new LeNode(info.value);
		} else if (info.node.equals("&&")) {
			return new AndNode(info.left, info.right);
		} else if (info.node.equals("||")) {
			return new OrNode(info.left, info.right);
		} else {
			throw new IllegalArgumentException("Undefined node " + info.name);
		}
	}
}
