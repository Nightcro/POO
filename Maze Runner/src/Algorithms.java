// public void A*() {
// 	moves.clear();
// 	LinkedList<Cell> queue = new LinkedList<>();

// 	queue.add(hero.getStart());

// 	while (!queue.isEmpty()) {
// 		Collections.sort(queue, Comparator_Task);
// 		Cell sq = queue.removeFirst();
// 		hero.setAxis(sq.getAxis());

// 		if (sq.equals(hero.getEnd())) {
// 			reconstructPath();
// 			return;
// 		}

// 		moves.add(sq);
// 		ArrayList<Cell> list_cell = getNeighbours();

// 		for (Cell cl : list_cell) {

// 			if (!hero.isMovableToCell(cl)) {
// 				continue;
// 			}

// 			if (!moves.contains(cl)) {
// 				cl.setG(sq.getG() + 1);
// 				cl.setH(Math.abs(cl.getX() - hero.getEnd().getX()) + Math.abs(cl.getY() - hero.getEnd().getY()));

// 				if (!queue.contains(cl)) {
// 					queue.offer(cl);
// 					cl.setPrevious(sq);
// 					cl.setWeight(cl.getG() + cl.getH());
// 				} else if (cl.getWeight() > cl.getG() + cl.getH()) {
// 					cl.setWeight(cl.getG() + cl.getH());
// 					cl.setPrevious(cl.getPrevious());
// 				}
// 			}
// 		}
// 	}
// }

// public void Lee() {
// 	moves.clear();
// 	LinkedList<Cell> queue = new LinkedList<>();

// 	queue.add(hero.getStart());
// 	hero.getStart().setWeight(1);

// 	while (!queue.isEmpty()) {
// 		Cell sq = queue.remove();
// 		hero.setAxis(sq.getAxis());

// 		ArrayList<Cell> list_cell = getNeighbours();

// 		if (list_cell.contains(hero.getEnd())) {
// 			hero.getEnd().setPrevious(sq);
// 			reconstructPath();
// 			return;
// 		}

// 		for (Cell cl : list_cell) {
// 			if ((hero.isMovableToCell(cl)) && (cl.getWeight() == 0)) {
// 				cl.setWeight(1);
// 				cl.setPrevious(sq);
// 				queue.add(cl);
// 			}
// 		}
// 	}
// }