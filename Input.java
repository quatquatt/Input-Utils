import java.util.Scanner;
import java.math.BigDecimal;
/**
 * Input.java
 * The Input class handles user input via the Scanner class for types: int, double, String, BigDecimal, char. The input is validated before being returned. 
 * The readInput() method is called by all input methods to get a non-empty string input, which can be casted to the chosen type.
 * The optional parameter customPrompt can be passed if the user should be told a specific message before inputting a value. If customPrompt is empty, a default prompt is used.
*/
class Input {

	/**
 * Helper method checks a line of input to make sure it's not empty.
 * @return A non-empty string of user-inputted text
	*/
	protected static String readInput() 
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
 * @param error This holds the type of desired input which should be printed to the user, such as "whole number".
 	*/
	protected static void errorMessage (String error) {
		System.err.println("ERROR: That's not a " + error + "!");
		System.err.print("Try again: ");
	}

	/**
 * Helper method prints the default prompt with the specified type if the customPrompt array is empty. 
 * If the customPrompt parameter was called, that prompt is printed.
 * @param customPrompt This array holds the optional customPrompt variable that can be passed as a parameter when calling an input method.
 * @param type This String holds the desired type of input that should be printed to the user if no custom prompt was passed, such as "whole number".
	*/
	private static void promptUser(String[] customPrompt, String type) {
		if (customPrompt.length == 0) {
			System.out.print("Tell me any " + type + ": ");
		}
		else if (customPrompt.length == 1) {
			System.out.print(customPrompt[0] + ": ");
		}
			
		else {
			errorMessage("valid amount of prompts!");
		}
	}



	/**
 * Method converts a string input into an int. 
 * If the input isn't a valid int, the error is caught and a new input is prompted from the user.
 * @param prompt  An optional custom prompt the user can provide instead of the default one. 
 * @return A non-empty user-inputted integer
	*/
	public static int intInput(String ... customPrompt) 
	{
		String type = "whole number";
		promptUser(customPrompt, type);
		int num = 0;
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
 * Method converts a string input into an double. 
 * If the input isn't a valid double, the error is caught and a new input is gotten from the user.
 * @param prompt An optional custom prompt the user can provide instead of the default one. 
 * @return A non-empty user-inputted double
	*/
	public static double doubleInput(String ... customPrompt) 
	{
		String type = "number";
		promptUser(customPrompt, type);

		double num = 0.0;
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
 * Method converts a string input into an BigDecimal. 
 * If the input isn't a valid number, the error is caught and a new input is gotten from the user.
 * @param prompt An optional custom prompt the user can provide instead of the default one. 
 * @return A non-empty user-inputted BigDecimal
		*/
	public static BigDecimal bigDecimalInput(String ... customPrompt)
	{
		String type = "number";
		promptUser(customPrompt, type);
		
		BigDecimal num;
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
 * @param prompt  An optional custom prompt the user can provide instead of the default one. 
 * @return A non-empty user-inputted string.
	*/
	public static String stringInput(String ... customPrompt) 
	{
		promptUser(customPrompt, "string");
		return readInput();
	}


	/**
 * Method gets a string input from the user, and checks if the length is only one character long. If so, the string is casted to a char and returned. Otherwise, a new input is gotten from the user.
 * @param prompt An optional custom prompt the user can provide instead of the default one. 
 * @return A non-empty user-inputted char.
	*/
	public static char charInput(String ... customPrompt) 
	{
		String type = "character";
		promptUser(customPrompt, type);

		String string;
		while (true) {
			string = readInput();
			if (string.length() == 1) { // Will only leave loop if the input is one character long
				break; 
			}
			else { // If the string's length is more than one, print an error message
				errorMessage(type);
			}
		}
		return string.charAt(0); // Takes and returns first char of string only if one character was provided 
	}



}