package maze;

/**
 * Un Factory pentru crearea de celule.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public class CellFactory {

	/**
	 * Creeaza o noua celula pe baza tipului de celula si coordonatele acestuia.
	 *
	 * @param cell
	 * @param x
	 * @param y
	 * @return the node
	 */
	public static Cell createCell(Character cell, int x, int y) {

		if (cell.equals('.')) {
			return new Empty(x, y);
		} else if (cell.equals('#')) {
			return new Wall(x, y);
		} else if (cell.equals('I')) {
			return new InPortal(x, y);
		} else if (cell.equals('O')) {
			return new OutPortal(x, y);
		} else if (cell.equals('V')) {
			return new Void(x, y);
		} else {
			throw new IllegalArgumentException("Undefined cell " + cell);
		}
	}
}
