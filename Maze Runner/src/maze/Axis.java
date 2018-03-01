package maze;

/**
 * Clasa axis, contine coordonatele (x, y) unui punct.
 *
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public class Axis {

	/** x si y. */
	private int x, y;

	/**
	 * Instantiaza un nou Axis.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	public Axis(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
