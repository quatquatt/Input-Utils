import java.util.Scanner;
import java.math.BigDecimal;
class InputArray {
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
		} while (lineInput.isEmpty()); // Will repeat loop until lineInput is no longer empty
		return lineInput;
	}
	/**
 * Helper method prompts user for how many elements to provide for their array.
 * @param type This tells the user what kind of input should be provided for their array values, such as "whole number"
	*/
	private static void promptUser(String type) {
		System.out.print("Tell me the amount of elements you want in your array of " + type + ": ");
	}
	/**
 * Helper method prints an error message to the console if the user's inputted number of elements was invalid.
 * @param error This holds the reason for the error, such as "zero elements" TODO: CHANGE THIS TO TELL THE USER WHAT A VALID AMOUNT OF ARRAYS IS
	*/
	private static void elemErrorMessage() { // TODO: PASS ERRORS INTO INPUT.JAVA INSTEAD OF HERE WITH AN EXTRA PARAMETER??
		System.err.println("ERROR: Your amount of elements should be positive!""
		System.err.print("Try again: ");
	}
	/**
 * Helper method that takes and returns an integer value for the number of elements in the array. The user gets an error message 
 	*/
	public static int amountOfElems() 
	{
		int num = 0;
		while (true) {
			try {
				num = Integer.parseInt(readInput()); // Throws error if input isn't an integer
				if (num < 1) { 
					elemErrorMessage(); 
				}
				else {
					break; // Only breaks infinite loop if input is a positive integer
				}
			}
			catch (NumberFormatException e) { // Thrown error caught here
				System.err.println("That's not a whole number!");
				System.err.print("Try again: ");
			}
		} 
		return num;
	}



	/**
 * Method creates an int array with n amount of elements. It then prompts the user for the value of each element.
 * n is prompted from the user via the promptUser() input, and the value of each element is prompted via the Input.intInput() method.
 * @return An int array with n elements and each element assigned to the user's input
	*/
	public static int[] intArrayInput()
	{
		promptUser("whole numbers"); // Prompts the user to provide how many elements should be stored. The user is told to provide "whole numbers" for the element values
		int n = amountOfElems();
		int[] arr = new int[n]; 
		for (int i = 0; i < n; i++) { // Repeats until a value for every element has been inputted by the user
			arr[i] = Input.intInput("Tell me the value you want at element " + (i+1));
		}
		return arr;
	}
	/**
 * Method creates a double array with n amount of elements. It then prompts the user for the value of each element.
 * n is prompted from the user via the promptUser() input, and the value of each element is prompted via the Input.doubleInput() method.
 * @return A double array with n elements and each element assigned to the user's input
	*/
	public static double[] doubleArrayInput()
	{
		promptUser("numbers"); // Prompts the user to provide how many elements should be stored. The user is told to provide "numbers" for the element values
		int n = amountOfElems();
		double[] arr = new double[n];
		for (int i = 0; i < n; i++) { // Repeats until a value for every element has been inputted by the user
			arr[i] = Input.doubleInput("Tell me the value you want at element " + (i+1));
		}
		return arr;
	}
	/**
 * Method creates a BigDecimal array with n amount of elements. It then prompts the user for the value of each element.
 * n is prompted from the user via the promptUser() input, and the value of each element is prompted via the Input.BigDecimal() method.
 * @return A BigDecimal array with n elements and each element assigned to the user's input
	*/
	public static BigDecimal[] bigDecimalArrayInput()
	{
		promptUser("numbers"); // Prompts the user to provide how many elements should be stored. The user is told to provide "numbers" for the element values
		int n = amountOfElems();
		BigDecimal[] arr = new BigDecimal[n];
		for (int i = 0; i < n; i++) { // Repeats until a value for every element has been inputted by the user
			arr[i] = Input.bigDecimalInput("Tell me the value you want at element " + (i+1));
		}
		return arr;
	}
	/**
 * Method creates a string array with n amount of elements. It then prompts the user for the value of each element.
 * n is prompted from the user via the promptUser() input, and the value of each element is prompted via the Input.stringInput() method.
 * @return A string array with n elements and each element assigned to the user's input
	*/
	public static String[] stringArrayInput()
	{
		promptUser("text strings");// Prompts the user to provide how many elements should be stored. The user is told to provide "text strings" for the element values
		int n = amountOfElems();
		String[] arr = new String[n];
		for (int i = 0; i < n; i++) { // Repeats until a value for every element has been inputted by the user
			arr[i] = Input.stringInput("Tell me the value you want at element " + (i+1));
		}
		return arr;
	}
	/**
 * Method creates a char array with n amount of elements. It then prompts the user for the value of each element.
 * n is prompted from the user via the promptUser() input, and the value of each element is prompted via the Input.charInput() method.
 * @return A char array with n elements and each element assigned to the user's input
	*/
	public static char[] charArrayInput()
	{
		promptUser("characters"); // Prompts the user to provide how many elements should be stored. The user is told to provide "characters" for the element values
		int n = amountOfElems();
		char[] arr = new char[n];
		for (int i = 0; i < n; i++) { // Repeats until a value for every element has been inputted by the user
			arr[i] = Input.charInput("Tell me the value you want at element " + (i+1));
		}
		return arr;
	}
}