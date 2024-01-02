import java.util.Scanner;
import java.util.HashMap;
import java.util.function.Function;
import java.lang.reflect.*;


/**
 * Input.java
 * The Input class handles user input via the Scanner class and use of generics. 
 * The code checks if the passed type has a valid valueOf method. If so, that's used to extract the String. If not, there's a HashMap with links to functions that'll handle certain classes such as Character. 
 * The optional parameter customPrompt can be passed if the user should be told a specific message before inputting a value. If customPrompt is empty, a default prompt is used.
*/
class Input {
    // A constant map that stores the manual converters.
    private static final HashMap<Class<?>, Function<String, ?>> TYPE_TO_CONVERTER;
    
    /**
     * A static block that initializes and declares the TYPE_TO_CONVERTER map with the types that do not have a valueOf(String) method. 
     * @see Input
     */

    // Constants to avoid using magic numbers
    private static final int FIRST_INDEX = 0;
    private static final int NO_PROMPT = 0;
    private static final int ONE_PROMPT = 1;

    static 
    {
        TYPE_TO_CONVERTER = new HashMap<>();
        // Add the types that do not have a valueOf(String) method manually
        TYPE_TO_CONVERTER.put(Character.class, s -> 
        {
            if (s == null || s.isEmpty())
                System.out.println("Empty string!"); // Checked
            return s.charAt(FIRST_INDEX);
        });
        TYPE_TO_CONVERTER.put(String.class, s -> s); 
    }


    /**
     * A private helper method that checks if the given type has a valueOf(String) method.
     * @param type the Class object of the type to check
     * @return true if the type has a valueOf(String) method, false otherwise
     */
    private static boolean hasValueOfMethod(Class<?> type) 
    {
        try 
        {
            Method valueOfMethod = type.getDeclaredMethod("valueOf", String.class);
            return true;
        } 
        catch (NoSuchMethodException e) // If the given class has no valueOf method, checked
        {
            return false;
        }
    }

    
    /**
     * A private helper method that prints a prompt for the user to input a value of the given type.
     * @param type the Class object of the type to prompt
     * @param customPrompt an optional array of Strings that contains a custom message for the user
     * @throws IllegalArgumentException if the customPrompt array has more than one element
     */
    private static <T> void promptInput(Class<T> type, String[] customPrompt) {
        String typeName = type.getSimpleName();
        switch (customPrompt.length)
        {
            case NO_PROMPT:
                System.out.print("Tell me any " + typeName + ": ");
                break;
            case ONE_PROMPT: 
                System.out.print(customPrompt[FIRST_INDEX] + ": ");
                break;
            default: 
                throw new IllegalArgumentException("Invalid number of custom prompts: expected 0 or 1, but got " + customPrompt.length); // Unchecked
        }
    }

    /**
     * A private method that converts a String input to the given type using either the valueOf(String) method or the manual converter from the TYPE_TO_CONVERTER map.
     * @param scannedInput the String input to be converted
     * @param type the Class object of the type to convert to
     * @return the converted value of the given type
     * @throws Exception if the type is not supported or the input is invalid
     */
    private static <T> T convertInput (String scannedInput, Class<T> type) throws IllegalArgumentException, InvocationTargetException
    {
        Function<String, ?> converter = TYPE_TO_CONVERTER.get(type);
        if (hasValueOfMethod(type) && converter == null) 
        {
            Method valueOfMethod = type.getDeclaredMethod("valueOf", String.class);
            return type.cast(valueOfMethod.invoke(null, scannedInput));
        }
        else if (converter != null) 
            return type.cast(converter.apply (scannedInput) );
        throw new IllegalArgumentException("Unsupported type: " + type); // Exception thrown if there's no logic for handling this Class, unchecked
        
    }


    public static <T> T input(Class<T> type, String... customPrompt) 
    {
        Scanner sc = new Scanner(System.in);
        T userInput = null;
        promptInput(type, customPrompt);
        while (true) {
            try {
                userInput = (T) convertInput(sc.nextLine(), type); // Throws error if input isn't of the specified type
                break; // Only breaks infinite loop if input is valid
            }
            catch (InvocationTargetException e) { // Thrown error caught here, checked
                Throwable cause = e.getCause(); // get the original exception
                System.out.println("Cause: " + cause);
            }
        } 
        return userInput;
    }
}