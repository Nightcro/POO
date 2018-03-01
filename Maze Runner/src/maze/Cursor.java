package maze;

import java.util.ArrayList;

/**
 * Clasa Cursor.
 *
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public class Cursor {

	/** Portalul de intrare. */
	private Cell start;
	
	/** Portalul de iesire. */
	private Cell end;

	/** Coordonatele cursorului. */
	private Axis xoy;

	/** Orientarea cursorului. */
	private Character face;

	/**
	 * Instantiaza un nou cursor cu orientarea predefinita spre Nord.
	 */
	public Cursor() {
		face = '^';
	}

	public Cell getStart() {
		return start;
	}

	public void setStart(Cell start) {
		this.start = start;
	}

	public Cell getEnd() {
		return end;
	}

	public void setEnd(Cell end) {
		this.end = end;
	}

	public Axis getAxis() {
		return xoy;
	}

	public void setAxis(Axis xoy) {
		this.xoy = xoy;
	}

	public int getFace() {
		return face;
	}

	/**
	 * Seteaza orientarea cursorului pe baza coordonatelor noi.
	 * Orientare: E = '>'; N = '^'; V = '<'; S = 'V'.
	 * @param xoy_new
	 */
	public void setFace(Axis xoy_new) {
		int x = xoy.getX() - xoy_new.getX();
		int y = xoy.getY() - xoy_new.getY();

		if ((x == -1) && (y == 0)) {
			face = 'V';
		} else if ((x == 1) && (y == 0)) {
			face = '^';
		} else if ((x == 0) && (y == 1)) {
			face = '<';
		} else if ((x == 0) && (y == -1)) {
			face = '>';
		}
	}

	/**
	 * Verifica daca se poate muta pe celula.
	 *
	 * @param sq
	 *            Celula de verificat
	 * @return true, daca se poate misca pe celula
	 */
	public boolean isMovableToCell(Cell sq) {
		return !((sq instanceof Void) || (sq instanceof Wall));
	}

	/**
	 * Metoda de miscare a cursorului. Daca celula primita este una de tip Void sau
	 * Wall, atunci se va intoarce o exceptie, in caz contrar se seteaza orientarea
	 * si se muta eroul.
	 *
	 * @param sq
	 *            celula pe care se muta
	 * @throws HeroOutOfGroundException
	 *             cursorul a iesit inafara labirintului
	 * @throws CannotMoveIntoWallsException
	 *             cursorul a intrat intr-un zid
	 */
	public void move(Cell sq) throws HeroOutOfGroundException, CannotMoveIntoWallsException {
		if (sq instanceof Void) {
			throw new HeroOutOfGroundException();
		} else if (sq instanceof Wall) {
			throw new CannotMoveIntoWallsException();
		}

		setFace(sq.getAxis());
		xoy = sq.getAxis();
	}

	/**
	 * Intoarce o lista de coordonate a vecinilor cursorului in functie de
	 * orientarea si coordonatele acestuia.
	 *
	 * @return lista axis a vecinilor cursorului
	 */
	public ArrayList<Axis> getNeighboursAxis() {
		ArrayList<Axis> list = new ArrayList<>(4);

		if (face == '^') {
			list.add(new Axis(xoy.getX(), xoy.getY() + 1));
			list.add(new Axis(xoy.getX() - 1, xoy.getY()));
			list.add(new Axis(xoy.getX(), xoy.getY() - 1));
			list.add(new Axis(xoy.getX() + 1, xoy.getY()));
		} else if (face == '>') {
			list.add(new Axis(xoy.getX() + 1, xoy.getY()));
			list.add(new Axis(xoy.getX(), xoy.getY() + 1));
			list.add(new Axis(xoy.getX() - 1, xoy.getY()));
			list.add(new Axis(xoy.getX(), xoy.getY() - 1));
		} else if (face == 'V') {
			list.add(new Axis(xoy.getX(), xoy.getY() - 1));
			list.add(new Axis(xoy.getX() + 1, xoy.getY()));
			list.add(new Axis(xoy.getX(), xoy.getY() + 1));
			list.add(new Axis(xoy.getX() - 1, xoy.getY()));
		} else {
			list.add(new Axis(xoy.getX() - 1, xoy.getY()));
			list.add(new Axis(xoy.getX(), xoy.getY() - 1));
			list.add(new Axis(xoy.getX() + 1, xoy.getY()));
			list.add(new Axis(xoy.getX(), xoy.getY() + 1));
		}

		return list;
	}
}
