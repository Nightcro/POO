package tree;

/**
 * The Interface IVisitable.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public interface IVisitable {

	/**
	 * Accept the visit.
	 *
	 * @param visitor
	 *            the visitor
	 * @return true, if successful
	 */
	public boolean accept(IVisitor visitor);
}
