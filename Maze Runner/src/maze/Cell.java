package maze;

/**
 * Clasa Cell.
 *
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public abstract class Cell {

	/** Cordonatele XoY. */
	private Axis xoy;

	/** Cost folosit pentru task 1 si task 2. */
	private int weight;
	
	/** Cost folosit in task-ul 2 (Manhattan distance). */ 
	private int h;
	
	/** Cost folosit in task-ul 2 (heuristic distance de valoare 1). */
	private int g;

	/**
	 * Referinta la celula precedenta, folosit pentru reconstruirea drumului in
	 * task2.
	 */
	private Cell previous;

	/**
	 * Instantiaza o noua celula.
	 *
	 * @param x
	 * @param y
	 */
	public Cell(int x, int y) {
		xoy = new Axis(x, y);
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public void setPrevious(Cell previous) {
		this.previous = previous;
	}

	public Cell getPrevious() {
		return previous;
	}

	public int getWeight() {
		return weight;
	}

	public void incWeight() {
		weight++;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Axis getAxis() {
		return xoy;
	}

	public int getX() {
		return xoy.getX();
	}

	public int getY() {
		return xoy.getY();
	}
}
