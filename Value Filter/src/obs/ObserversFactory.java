package obs;

import java.util.Stack;
import tree.Node;
import tree.OperatorsFactory;
import tree.Values;

/**
 * A factory for creating Observers objects.
 * 
 * @author Mindru Alexandru-Ionut Grupa 321CB
 */
public class ObserversFactory {

	/** The output stack filter. */
	private static Stack<String> outputStackFilter;

	/** The operator stack filter. */
	private static Stack<String> operatorStackFilter;

	/** The instance. */
	private static ObserversFactory INSTANCE;

	/**
	 * Instantiates a new observers factory.
	 */
	private ObserversFactory() {
		outputStackFilter = new Stack<String>();
		operatorStackFilter = new Stack<String>();
	}

	/**
	 * Gets the observers factory.
	 *
	 * @return the observers factory
	 */
	public static ObserversFactory getObserversFactory() {
		if (INSTANCE == null) {
			INSTANCE = new ObserversFactory();
		}

		return INSTANCE;
	}

	/**
	 * Returns the root node of the tree.
	 *
	 * @param filter
	 *            the filter
	 * @return the node
	 */
	public Node workTree(String filter) {
		outputStackFilter.removeAllElements();
		operatorStackFilter.removeAllElements();
		getPolish(filter);
		return getTree();
	}

	/**
	 * Creates the tree with elements stored in outputStack.
	 *
	 * @return the tree
	 */
	private Node getTree() {
		String thing = outputStackFilter.pop();
		String pop1, pop2;
		Node popN1, popN2;

		if (thing.equals("&&") || thing.equals("||")) {

			pop1 = outputStackFilter.peek();
			if (pop1.equals("&&") || pop1.equals("||")) {
				popN1 = getTree();
			} else {
				pop1 = outputStackFilter.pop();
				popN1 = OperatorsFactory.createNode(getValues(pop1));
			}

			pop2 = outputStackFilter.peek();
			if (pop2.equals("&&") || pop2.equals("||")) {
				popN2 = getTree();
			} else {
				pop2 = outputStackFilter.pop();
				popN2 = OperatorsFactory.createNode(getValues(pop2));
			}

			String op = new String((thing.contains("&&")) ? "&&" : "||");

			return OperatorsFactory.createNode(new Values(op, popN1, popN2));
		} else {
			return OperatorsFactory.createNode(getValues(thing));
		}
	}

	/**
	 * Using the shunting-yard algorithm we create a postfix order of the filter so
	 * we can create our tree.
	 *
	 * @param filter
	 *            the filter
	 */
	private void getPolish(String filter) {
		char[] letters = filter.toCharArray();

		for (int i = 0; i < letters.length; i++) {
			char c = filter.charAt(i);

			if (c == ' ') {
				continue;
			}

			if (c == '(') {
				int match = i + ParenthesisMatch(filter.substring(i));
				String sub = filter.substring(i + 1, match);

				if ((sub.contains("&&") == false) && (sub.contains("||") == false)) {
					outputStackFilter.push(sub);
					i = match;
					continue;
				}
			}

			if (c == '(') {
				operatorStackFilter.push("(");
			}

			if (c == ')') {
				while (!operatorStackFilter.peek().equals("(")) {
					outputStackFilter.push(operatorStackFilter.pop());
				}

				operatorStackFilter.pop();
			}

			if (c == '&' || c == '|') {
				i++;

				String op = new String(c == '&' ? "&&" : "||");

				while (isPrecedence(op)) {
					outputStackFilter.push(operatorStackFilter.pop());
				}

				operatorStackFilter.push(op);
			}
		}

		while (!operatorStackFilter.isEmpty()) {
			outputStackFilter.push(operatorStackFilter.pop());
		}
	}

	/**
	 * It's an algorithm used for seeking the index at which the current left
	 * bracket closes.
	 *
	 * @param str
	 *            the string
	 * @return the integer
	 */
	private Integer ParenthesisMatch(String str) {
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				if (stack.peek() == '(') {
					stack.pop();

					if (stack.empty()) {
						return i;
					}
				}
			}
		}

		return 0;
	}

	/**
	 * Checks if is precedence.
	 *
	 * @param op
	 *            the op
	 * @return true, if is precedence
	 */
	private boolean isPrecedence(String op) {

		if (operatorStackFilter.isEmpty()) {
			return false;
		}

		String last = operatorStackFilter.peek();

		if (last.equals("||") && op.contains("&&")) {
			return true;
		} else if (((last.equals(op)) || (last.equals(op))) && (!last.contains("("))) {
			return true;
		}

		return false;
	}

	/**
	 * Gets the values based of a string.
	 *
	 * @param message
	 *            the message
	 * @return the values
	 */
	private Values getValues(String message) {
		message = message.trim();
		message = message.replaceAll(" +", " ");
		String[] word = message.split(" ");

		Values info = null;

		if (word[0].equals("eq") || word[0].equals("ne")) {
			if (word[1].equals("name")) {
				info = new Values(word[0] + " " + word[1], word[2]);
			} else if (word[1].equals("value")) {
				info = new Values(word[0] + " " + word[1], Double.parseDouble(word[2]));
			}
		} else {
			info = new Values(word[0], Double.parseDouble(word[2]));
		}

		return info;
	}
}
