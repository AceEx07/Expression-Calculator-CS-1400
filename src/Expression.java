import java.util.*;
import java.io.*;

public class Expression {

	private String expression;
	private Scanner fileScnr = new Scanner("expressions.txt");
	private String[] numsA;
	private String[] opsA;
	private ArrayList<String> numsList = new ArrayList<String>();
	private ArrayList<String> opsList = new ArrayList<String>();
	private int tempAnswerInt;
	private double tempAnswerDouble;
	private double answer;
	private boolean integerMath = true;
	private boolean isComplete = false;

	public Expression(String s) {
		expression = s;
	}

	public void setIntegerMath(boolean x) {
		integerMath = x;
	}

	// Solves the expression given
	public void evaluate() {
		seperate();

		// Does integer arithmetic
		if (integerMath == true) {
			while (numsList.size() != 1) {
				for (int i = 0; i < opsList.size(); i++) {
					if (numsList.size() == 1) {
						break;
					} else if (opsList.get(i).equals("*")) {
						tempAnswerInt = Integer.parseInt(numsList.get(i)) * Integer.parseInt(numsList.get(i + 1));
						numsList.remove(i + 1);
						numsList.set(i, String.valueOf(tempAnswerInt));
						opsList.remove(i);
						i--;
					} else if (opsList.get(i).equals("/")) {
						tempAnswerInt = Integer.parseInt(numsList.get(i)) / Integer.parseInt(numsList.get(i + 1));
						numsList.remove(i + 1);
						numsList.set(i, String.valueOf(tempAnswerInt));
						opsList.remove(i);
						i--;
					}
				}
				for (int i = 0; i < opsList.size(); i++) {
					if (numsList.size() == 1) {
						break;
					} else if (opsList.get(i).equals("+")) {
						tempAnswerInt = Integer.parseInt(numsList.get(i)) + Integer.parseInt(numsList.get(i + 1));
						numsList.remove(i + 1);
						numsList.set(i, String.valueOf(tempAnswerInt));
						opsList.remove(i);
						i--;
					}

					else if (opsList.get(i).equals("-")) {
						tempAnswerInt = Integer.parseInt(numsList.get(i)) - Integer.parseInt(numsList.get(i + 1));
						numsList.remove(i + 1);
						numsList.set(i, String.valueOf(tempAnswerInt));
						opsList.remove(i);
						i--;
					}
				}
			}
			answer = Double.parseDouble(numsList.get(0));
		}

		// Does floating-point arithmetic
		else {
			while (numsList.size() != 1) {
				for (int i = 0; i < opsList.size(); i++) {
					if (numsList.size() == 1) {
						break;
					} else if (opsList.get(i).equals("*")) {
						tempAnswerDouble = Double.parseDouble(numsList.get(i))
								* Double.parseDouble(numsList.get(i + 1));
						numsList.remove(i + 1);
						numsList.set(i, String.valueOf(tempAnswerDouble));
						opsList.remove(i);
						i--;
					} else if (opsList.get(i).equals("/")) {
						tempAnswerDouble = Double.parseDouble(numsList.get(i))
								/ Double.parseDouble(numsList.get(i + 1));
						numsList.remove(i + 1);
						numsList.set(i, String.valueOf(tempAnswerDouble));
						opsList.remove(i);
						i--;
					}
				}
				for (int i = 0; i < opsList.size(); i++) {
					if (numsList.size() == 1) {
						break;
					} else if (opsList.get(i).equals("+")) {
						tempAnswerDouble = Double.parseDouble(numsList.get(i))
								+ Double.parseDouble(numsList.get(i + 1));
						numsList.remove(i + 1);
						numsList.set(i, String.valueOf(tempAnswerDouble));
						opsList.remove(i);
						i--;
					}

					else if (opsList.get(i).equals("-")) {
						tempAnswerDouble = Double.parseDouble(numsList.get(i))
								- Double.parseDouble(numsList.get(i + 1));
						numsList.remove(i + 1);
						numsList.set(i, String.valueOf(tempAnswerDouble));
						opsList.remove(i);

						i--;
					}
				}
			}
			answer = Double.parseDouble(numsList.get(0));
		}
	}

	// Separates the operations and the numbers in an expression and saves them to
	// two array lists
	public void seperate() {
		numsA = expression.split("\\+|-|\\*|/");
		for (int i = 0; i < numsA.length; i++) {
			numsList.add(numsA[i]);
		}

		opsA = expression.split("0|1|2|3|4|5|6|7|8|9");
		for (int i = opsA.length - 1; i >= 0; i--) {
			if (opsA[i] != "") {
				opsList.add(0, opsA[i]);
			}
		}
	}

	// Returns the list of numbers
	public ArrayList<String> returnNums() {
		return numsList;
	}

	// Returns the list of operators
	public ArrayList<String> returnOps() {
		return opsList;
	}

	// Prints out the solved expressions, depending on if integer arithmetic was
	// done or not
	public String toString() {
		if (integerMath == true) {
			return expression + " = " + (int) answer;
		} else {
			return expression + " = " + answer;
		}
	}
}
