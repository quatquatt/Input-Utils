import java.util.Scanner;
import java.math.BigDecimal;
import java.util.Optional;
/**
 * Input.java
 * Class handles user input via the Scanner class for types: int, double, String, BigDecimal, char. The input is validated before being returned. 
 * The private readInput() method is called by all input methods to get a non-empty string input, which can be casted to the chosen type.
*/
class Input {
	/**
 * Helper method checks a line of input to make sure it's not empty.
 * @return A non-empty string of user-inputted text
	*/
	private static String readInput() 
	{
		Scanner scanner = new Scanner(System.in);
		String lineInput = ""; 
		do { 
			lineInput = scanner.nextLine().trim(); // Trims the user's input to remove leading and trailing spaces
			if (lineInput.isEmpty()) {
				System.err.println("ERROR: You didn't enter anything!"); 
				System.err.print("Try again: ");
			}
		} while (lineInput.isEmpty()); // Will now repeat loop until lineInput is no longer empty
		return lineInput;
	}
	/**
 * Helper method prints an error message to the console if the input was an invalid type. 
 * @param error This holds the type that should be told to the user. The actual name of the type isn't used, and instead something more user-friendly is printed such as "whole number" instead of "int".
 	*/
	public static void errorMessage (String error) {
		System.err.println("ERROR: That's not a " + error + "!");
		System.err.print("Try again: ");
	}

	private static void promptUser(String[] promptArr, String type) {
		if (promptArr.length == 0) {
			System.out.print("Tell me any " + type + ": ");
		}
		else if (promptArr.length == 1) {
			System.out.print(promptArr[0] + ": ");
		}
		else {
			errorMessage("valid amount of prompts!");
		}
	}



	/**
 * Method converts a string input into an int. If the input isn't a valid int, the error is caught and a new input is gotten from the user.
 * @param prompt The prompt the user is asked before providing the input
 * @return A non-empty user-inputted integer
	*/
	public static int intInput(String ... prompt) 
	{
		int num = 0;
		String type = "whole number"; // Make this a non-static constructor maybe?? 
		promptUser(inppromptutPrompt, type);
		while (true) {
			try {
				num = Integer.parseInt(readInput()); // Throws error if input isn't an integer
				break; // Only breaks infinite loop if input is an integer
			}
			catch (NumberFormatException e) { // Thrown error caught here
				errorMessage(type);
			}
		} 
		return num;
	}


	/**
 * Method converts a string input into an double. If the input isn't a valid double, the error is caught and a new input is gotten from the user.
 * @param prompt The prompt the user is asked before providing the input
 * @return A non-empty user-inputted double
	*/
	public static double doubleInput(String ... prompt) 
	{
		double num = 0.0;
		String type = "number";
		promptUser(prompt, type);
		while (true) {
			try {
				num = Double.parseDouble(readInput()); // Throws error from here if input isn't a double
				break; // Only breaks infinite loop if input is a double
			}
			catch (NumberFormatException e) { // Thrown error caught here
				errorMessage(type);
			}
		} 
		return num;
	}


	/**
 * Method converts a string input into an BigDecimal. If the input isn't a valid number, the error is caught and a new input is gotten from the user.
 * @param prompt The prompt the user is asked before providing the input
 * @return A non-empty user-inputted BigDecimal
		*/
	public static BigDecimal bigDecimalInput(String ... prompt)
	{
		BigDecimal num;
		String type = "number";
		promptUser(prompt, type);
		while (true) {
			try {
				num = new BigDecimal(readInput()); // Throws error if input isn't a valid number
				break; // Only gets to this line and breaks infinite loop if input is valid
			}
			catch (NumberFormatException e) { // Thrown error caught here
				errorMessage(type);
			}
		}
		return num; 
	}


	/**
 * Method gets a string input from the user. 
 * @param prompt The prompt the user is asked before providing the input
 * @return A non-empty user-inputted string.
	*/
	public static String stringInput(String ... prompt) 
	{
		String type = "string";
		promptUser(prompt, type);
		return readInput();
	}


	/**
 * Method gets a string input from the user, and checks if the length is only one character long. If so, the string is casted to a char and returned. Otherwise, a new input is gotten from the user.
 * @param prompt The prompt the user is asked before providing the input
 * @return A non-empty user-inputted char.
	*/
	public static char charInput(String ... prompt) 
	{
		String string;
		String type = "character";
		promptUser(prompt, type);
		while (true) {
			string = readInput();
			if (string.length() == 1) { // Will only leave loop if the input is one character long
				break; 
			}
			else { // If the string's length is more than one
				errorMessage(type);
			}
		}
		return string.charAt(0); // Takes and returns first char of string only if one character was provided 
	}



}