import java.util.Scanner;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.ConversionException;

import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.DoubleConverter;
import org.apache.commons.beanutils.converters.CharacterConverter;

import org.apache.commons.collections.FastHashMap;
import org.apache.commons.logging.LogFactory;
/**
 * Input.java
 * The Input class handles user input via the Scanner class for types: int, double, String, BigDecimal, char. The input is validated before being returned. 
 * The getNonEmptyInput() method is called by all input methods to get a non-empty string input, which can be casted to the chosen type.
*/

class Input 
{
    /**
 * Helper method checks a line of input to make sure it's not empty.
 * @return A non-empty string of user-inputted text
    */
    private static String getNonEmptyInput() 
    {
        Scanner scanner = new Scanner(System.in);
        String lineInput = ""; 
        do 
        { 
            lineInput = scanner.nextLine().trim(); 
            if (lineInput.isEmpty()) 
            {
                System.err.println("ERROR: You didn't enter anything!"); // Hardcoded error logic, should be removed in the future
                System.err.print("Try again: ");
            }
        } while ( lineInput.isEmpty() ); 
        return lineInput;
    }

    /**
 * Helper method prints an error message to the console if the input was an invalid type. 
 * @param error This holds the type of desired input which should be printed to the user, such as "whole number".
    **/
    private static void errorMessage (String error) 
    {
        System.out.println("ERROR: That's not a " + error + "!");
        System.out.print("Try again: ");
    }

    /**

    **/
    private static void promptUser(String type) 
    {
        System.out.print("Tell me any " + type + ": ");
    }

    private static <T> T parseStringToType(String input, Class<T> targetType) 
    {
        
        T output = null;
        try 
        {
            output = (T) ConvertUtils.convert(input, targetType);
        }
        catch (ConversionException | ClassCastException e) 
        {
            // pass the targetType variable to your custom error handler
            errorMessage(targetType.getSimpleName());
        }
        return output;
    }
    
    /**
 * Method converts a string input into an int. 
 * If the input isn't a valid int, the error is caught and a new input is prompted from the user.
 * @return A non-empty user-inputted integer
    **/
    public static int intInput() 
    {
        Class<Integer> targetType = Integer.class;
        ConvertUtils.register(new IntegerConverter(), targetType);
        
        promptUser(targetType.getSimpleName());
        
        boolean isValidInput = false;
        Integer num = null;
        
        while (!isValidInput) 
        {
            String input = getNonEmptyInput();
            num = parseStringToType(input, targetType);
            if (num != null)
                isValidInput = true; 
        } 
        return num;
    }


    /**
 * Method converts a string input into an double. 
 * If the input isn't a valid double, the error is caught and a new input is gotten from the user.
 * @return A non-empty user-inputted double
    **/

    public static double doubleInput() 
    {
        Class<Double> targetType = Double.class;
        
        ConvertUtils.register(new DoubleConverter(), targetType);
        promptUser(targetType.getSimpleName());

        boolean isValidInput = false;
        Double num = null;
        
        while (!isValidInput) 
        {
            String input = getNonEmptyInput();
            num = parseStringToType(input, targetType);
            if (num != null)
                isValidInput = true; 
        } 
        return num;
    }

    /**
 * Method gets a string input from the user. 
 * @return A non-empty user-inputted string.
    **/
    public static String stringInput() 
    {
        promptUser("String");
        return getNonEmptyInput();
    }


    /**
 * Method gets a string input from the user, and casts it to a char.
    **/
    public static char charInput() 
    {
        Class<Character> targetType = Character.class;

        ConvertUtils.register(new CharacterConverter(), targetType);
        promptUser(targetType.getSimpleName());

        boolean isValidInput = false;
        Character chara = null;
        
        while (!isValidInput) 
        {
            String input = getNonEmptyInput();
            chara = parseStringToType(input, targetType);
            if (chara != null)
                isValidInput = true; 
        }
        return chara; 
    }   
}
