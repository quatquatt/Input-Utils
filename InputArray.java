import java.util.Scanner;
import java.math.BigDecimal;

/**
 * InputArray.java
 * The InputArray class extends the functionality of the Input class by providing the ability to take arrays as inputs. 
 * The methods readInput() and errorMessage() are passed in and reused from the Input class. 
*/
class InputArray extends Input {

	/**
 * Helper method prompts the user for how many elements to provide for their array.
 * @param type This tells the user what kind of input should be provided for their array values, such as "whole numbers".
	*/
	private static void elemsPromptUser(String type) {
		System.out.print("Tell me the amount of elements you want in your array of " + type + ": ");
	}

	/**
 * Helper method that takes and returns an integer value for the number of elements in the array. 
 * An error message is printed if the number of elements is invalid.
 * @return A positive number of elements
 	*/
	public static int amountOfElemsInput() 
	{
		int num = 0;
		while (true) {
			try {
				num = Integer.parseInt(readInput()); // Throws error if input isn't an integer
				if (num < 1) { 
					errorMessage("positive amount of elements"); 
				}
				else {
					break; // Only breaks infinite loop if input is a positive integer
				}
			}
			catch (NumberFormatException e) { // Thrown error caught here
				errorMessage("whole number");
			}
		} 
		return num;
	}



	/**
 * Method creates an int array with n amount of elements. It then prompts the user for the value of each element.
 * n is prompted from the user via the elemsPromptUser() input. 
 * The value of each element is inputted via the Input.intInput() method, with a custom prompt being passed.
 * @return An int array with n elements and each element assigned to the user's input
	*/
	public static int[] intArrayInput()
	{
		elemsPromptUser("whole numbers"); // Prompts the user to provide how many elements should be stored. The user is told to provide "whole numbers" for the element values.
		int n = amountOfElemsInput(); 
		int[] arr = new int[n]; // Creates an int array with n elems 
		for (int i = 0; i < n; i++) { // Repeats until a value for every element has been inputted by the user.
			arr[i] = Input.intInput("Tell me the value you want at element " + (i+1));
		}
		return arr;
	}

	/**
 * Method creates a double array with n amount of elements. It then prompts the user for the value of each element.
 * n is prompted from the user via the elemsPromptUser() input.
 * The value of each element is inputted via the Input.doubleInput() method, with a custom prompt being passed.
 * @return A double array with n elements and each element assigned to the user's input
	*/
	public static double[] doubleArrayInput()
	{
		elemsPromptUser("numbers"); // Prompts the user to provide how many elements should be stored. The user is told to provide "numbers" for the element values.
		int n = amountOfElemsInput(); 
		double[] arr = new double[n]; // Creates a double array with n elems 
		for (int i = 0; i < n; i++) { // Repeats until a value for every element has been inputted by the user.
			arr[i] = Input.doubleInput("Tell me the value you want at element " + (i+1));
		}
		return arr;
	}

	/**
 * Method creates a BigDecimal array with n amount of elements. It then prompts the user for the value of each element.
 * n is prompted from the user via the elemsPromptUser() input. 
 * The value of each element is inputted via the Input.BigDecimal() method, with a custom prompt being passed.
 * @return A BigDecimal array with n elements and each element assigned to the user's input.
	*/
	public static BigDecimal[] bigDecimalArrayInput()
	{
		elemsPromptUser("numbers"); // Prompts the user to provide how many elements should be stored. The user is told to provide "numbers" for the element values.
		int n = amountOfElemsInput();
		BigDecimal[] arr = new BigDecimal[n]; // Creates a BigDecimal array with n elems 
		for (int i = 0; i < n; i++) { // Repeats until a value for every element has been inputted by the user.
			arr[i] = Input.bigDecimalInput("Tell me the value you want at element " + (i+1));
		}
		return arr;
	}

	/**
 * Method creates a string array with n amount of elements. It then prompts the user for the value of each element.
 * n is prompted from the user via the elemsPromptUser() input. 
 * The value of each element is inputted via the Input.stringInput() method, with a custom prompt being passed.
 * @return A string array with n elements and each element assigned to the user's input
	*/
	public static String[] stringArrayInput()
	{
		elemsPromptUser("text strings");// Prompts the user to provide how many elements should be stored. The user is told to provide "text strings" for the element values.
		int n = amountOfElemsInput();
		String[] arr = new String[n]; // Creates a String array with n elems 
		for (int i = 0; i < n; i++) { // Repeats until a value for every element has been inputted by the user.
			arr[i] = Input.stringInput("Tell me the value you want at element " + (i+1));
		}
		return arr;
	}

	/**
 * Method creates a char array with n amount of elements. It then prompts the user for the value of each element.
 * n is prompted from the user via the promptUser() input.
 * The value of each element is inputted via the Input.charInput() method, with a custom prompt being passed.
 * @return A char array with n elements and each element assigned to the user's input
	*/
	public static char[] charArrayInput()
	{
		elemsPromptUser("characters"); // Prompts the user to provide how many elements should be stored. The user is told to provide "characters" for the element values.
		int n = amountOfElemsInput();
		char[] arr = new char[n]; // Creates a char array with n elems 
		for (int i = 0; i < n; i++) { // Repeats until a value for every element has been inputted by the user.
			arr[i] = Input.charInput("Tell me the value you want at element " + (i+1));
		}
		return arr;
	}
}