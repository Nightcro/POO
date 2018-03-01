package maze;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clasa Maze.
 *
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public class Maze {

	/** Labirintul. */
	private ArrayList<ArrayList<Cell>> CellList;

	/** Fisierul de input. */
	private BufferedReader reader;

	/** Fisierul de output. */
	private PrintWriter writer;

	/** Eroul. */
	private Cursor hero;

	/** Lista ce contine miscarile eroului. */
	private ArrayList<Cell> moves;

	/** Latime si inaltimea labirintului. */
	private int height, width;

	/** Comparatorul folosit pentru cele doua task-uri. */
	private Comparator<Cell> Comparator_Task = new Comparator<Cell>() {

		public int compare(Cell sq1, Cell sq2) {

			if (sq1.getWeight() < sq2.getWeight()) {
				return -1;
			} else if (sq1.getWeight() > sq2.getWeight()) {
				return 1;
			}

			return 0;
		}
	};

	/**
	 * Instantiaza un nou labirint cu un fisier de intrare si unul de output.
	 *
	 * @param input
	 *            fisierul de input
	 * @param output
	 *            fisierul de output
	 */
	public Maze(String input, String output) {
		try {
			reader = new BufferedReader(new FileReader(new File(input)));
			writer = new PrintWriter(new File(output));
			moves = new ArrayList<>();
		} catch (FileNotFoundException ex) {
			Logger.getLogger(Maze.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
		}
	}

	/**
	 * Creeaza labirintul pe baza fisierului de intrare. De asemenea inconjoara
	 * labirintul cu o casuta in plus denumita Void Pentru a determina cand eroul
	 * iese inafara labirintului.
	 */
	public void createMaze() {
		try {
			String[] line = reader.readLine().split(" ");

			height = Integer.parseInt(line[0]);
			width = Integer.parseInt(line[1]);
			hero = new Cursor();

			CellList = new ArrayList<ArrayList<Cell>>(height + 1);

			for (int i = 0; i <= height + 1; i++) {
				if (i == 0 || i == height + 1) {
					// se adauga o linie la final si inceput de Void
					ArrayList<Cell> col = new ArrayList<>(width + 1);

					for (int j = 0; j <= width + 1; j++) {
						col.add(CellFactory.createCell('V', i, j));
					}

					CellList.add(col);
				} else {
					line = reader.readLine().split("");
					ArrayList<Cell> col = new ArrayList<>(width + 1);
					col.add(CellFactory.createCell('V', i, 0));

					for (int j = 1; j <= line.length; j++) {
						Character letter = line[j - 1].charAt(0);
						Cell sq = CellFactory.createCell(letter, i, j);
						col.add(sq);

						// se seteaza pozitia de start, portalul de intrare
						// si iesire al eroului
						if (letter == 'I') {
							hero.setAxis(new Axis(i, j));
							hero.setStart(sq);
						} else if (letter == 'O') {
							hero.setEnd(sq);
						}
					}

					col.add(CellFactory.createCell('V', i, width + 1));

					CellList.add(col);
				}
			}
		} catch (IOException ex) {
			Logger.getLogger(Maze.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
		}
	}

	/**
	 * Inchide fisierele de input si output.
	 */
	public void close() {
		try {
			reader.close();
		} catch (IOException ex) {
			Logger.getLogger(Maze.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			writer.close();
		}
	}

	/**
	 * Task 1. Eroul se afla pe pozitia de inceput, se adauga pe lista de miscari
	 * celula initiala, apoi se ia vecinii in functie de orientarea eroului, se
	 * adauga pe rand pe lista de miscari si se muta eroul, in caz de eroul iese
	 * inafara labirintului sau intra intr-un zid, metoda move din clasa Cursor va
	 * arunca o exceptie ce va fi prinsa si va determina sa se treaca la urmatoarea
	 * celula din lista de vecini sortata.
	 */
	public void task1() {
		moves.clear();
		moves.add(hero.getStart());
		hero.getStart().incWeight();

		while (true) {
			ArrayList<Cell> list_cell = getNeighbours();

			if (list_cell.contains(hero.getEnd())) {
				moves.add(hero.getEnd());
				return;
			}

			Collections.sort(list_cell, Comparator_Task);
			int index = 0;

			while (true) {
				try {
					Cell sq = list_cell.get(index);
					hero.move(sq);
					moves.add(sq);
					sq.incWeight();

					break;
				} catch (Exception e) {
					index++;
					continue;
				}
			}
		}
	}

	/**
	 * Task 2. Se foloseste algoritmul lui Lee. Se seteaza greutate pozitiei de
	 * start cu 1, intram in while, luam prima celula din lista queue, cum obtinerea
	 * de vecini se bazeaza pe clasa cursor, doar vom seta coordonatele acestuia,
	 * nu-l vom muta pe erou. Se obtine vecinii in ordinea E, N, W, S, orientarea
	 * implicita a eroului fiind nord, astfel obtinandu-se acea lista de vecini, mai
	 * intai se verifica daca lista de vecini contine portalul de final, in caz de
	 * il contine algoritmul se opreste seteaza o referinta de la portalul de iesire
	 * catre ultima celula pe care se afla eroul si se intoarce functia, altfel se
	 * ia fiecare celula din lista, se verifica daca eroul se poate seta pe el si
	 * daca am mai fost pe celula respectiva, se seteaza weight-ul si referinta la
	 * celula pe care se afla si se adauga pe lista de mutari.
	 */
	public void task2() {
		moves.clear();
		LinkedList<Cell> queue = new LinkedList<>();

		queue.add(hero.getStart());
		hero.getStart().setWeight(1);

		while (!queue.isEmpty()) {
			Cell sq = queue.remove();
			hero.setAxis(sq.getAxis());

			ArrayList<Cell> list_cell = getNeighbours();

			if (list_cell.contains(hero.getEnd())) {
				hero.getEnd().setPrevious(sq);
				reconstructPath();
				return;
			}

			for (Cell cl : list_cell) {
				if ((hero.isMovableToCell(cl)) && (cl.getWeight() == 0)) {
					cl.setWeight(1);
					cl.setPrevious(sq);
					queue.add(cl);
				}
			}
		}
	}

	/**
	 * Se reface drumul de la portalul de intrare catre cel de iesire punand in
	 * lista de miscari celulele prin care s-a trecut urmand de la final catre
	 * inceput referintele intre celule.
	 */
	private void reconstructPath() {
		moves.clear();
		Cell sq = hero.getEnd();
		moves.add(sq);

		while (sq != null) {
			sq = sq.getPrevious();
			if (sq != null) {
				moves.add(sq);
			}
		}

		Collections.reverse(moves);
	}

	/**
	 * Metoda de obtinere a vecinilor, se apeleaza metoda getNeighboursAxis, pentru
	 * a obtine o lista de coordonate vecine in functie de orientarea eroului, apoi
	 * pe baza acestor coordonate se pun celulele de la coordonatele respective.
	 *
	 * @return Lista de vecini
	 */
	private ArrayList<Cell> getNeighbours() {
		ArrayList<Axis> list = hero.getNeighboursAxis();
		ArrayList<Cell> list_cell = new ArrayList<>(4);

		for (Axis ax : list) {
			list_cell.add(CellList.get(ax.getX()).get(ax.getY()));
		}

		return list_cell;
	}

	/**
	 * Afisarea numarului de miscari si drumului prin coordonate de celule.
	 */
	public void printTask() {
		writer.println(moves.size());

		for (Cell sq : moves) {
			Axis ax = sq.getAxis();
			writer.println((ax.getX() - 1) + " " + (ax.getY() - 1));
		}
	}
}
