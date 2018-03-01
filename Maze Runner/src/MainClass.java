import maze.Maze;

/**
 * Clasa MainClass.
 *
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public class MainClass {

	/**
	 * Metoda main.
	 *
	 * @param args
	 *            Trebuie sa primeasca 3 parametrii, numarul task-ului, fisierul de
	 *            intrare si de iesire
	 */
	public static void main(String[] args) {

		if (args.length != 3) {
			System.err.println("Number of arguments invalid.");
		}

		Maze runner = new Maze(args[1], args[2]);

		runner.createMaze();

		if (args[0].contains("1")) {
			runner.task1();
		} else {
			runner.task2();
		}

		runner.printTask();
		runner.close();
	}
}
