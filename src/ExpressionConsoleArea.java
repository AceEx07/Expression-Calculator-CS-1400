import java.util.*;
import java.io.*;

public class ExpressionConsoleArea {

	public static void main(String[] args) {

		Scanner keyboardScnr = new Scanner(System.in);
		Scanner fileScnr = null;
		FileOutputStream fileStream = null;
		PrintWriter answerFileText = null;
		File file = null;
		File answerFile = null;
		String fileName;
		String intMath;
		String equation = "";
		boolean intMathBoolean = true;

		// Asks user for the file with the expressions on it
		System.out.print("Enter the file name with expressions you wish to solve: ");

		// Try + Catch statement to see if the file exists
		try {
			fileName = keyboardScnr.nextLine();
			file = new File(fileName);
			fileScnr = new Scanner(file);

			// Asks the user what they would like to name the file to store the solved
			// expressions in
			System.out.print("Enter the name of the file you would like to create to store answers: ");
			fileName = keyboardScnr.nextLine();

			// Ensures that the file typed is more than 4 letters long/must be a.txt file
			if (fileName.length() < 4) {
				System.out.println("Incorrect input. Please enter a .txt file");
				return;
			}
			// Ensures that the file typed in is a .txt file
			else if (!fileName.substring(fileName.length() - 4, fileName.length()).equals(".txt")) {
				System.out.println("Incorrect input. Please enter a .txt file");
				return;
			}

			answerFile = new File(fileName);
			fileStream = new FileOutputStream(answerFile);
			answerFileText = new PrintWriter(fileStream);

			// Asks the user if they would like to do integer arithmetic or not
			System.out.print("Would you like to do integer arithmetic? (Y/N)  ");
			intMath = keyboardScnr.nextLine();
			intMath = intMath.toLowerCase();

			if (intMath.equals("y")) {
				intMathBoolean = true;
			} else if (intMath.equals("n")) {
				intMathBoolean = false;
			} else {
				System.out.println("Incorect input. Type Y or N.");
				answerFileText.close();
				return;
			}
			System.out.println("");

			// Goes through each expression in a file and prints them out in the console and
			// also writes them into the text file.
			while (fileScnr.hasNextLine()) {
				equation = fileScnr.nextLine();
				Expression expression = new Expression(equation);
				expression.setIntegerMath(intMathBoolean);
				expression.evaluate();
				System.out.println(expression.toString());
				answerFileText.println(expression.toString());
			}
			answerFileText.close();
			System.out.println("\nFile created.");
		}

		// Catch statement that prints if the file is not found.
		catch (IOException ioe) {
			System.out.println("File not found.");
		}

	}

}
