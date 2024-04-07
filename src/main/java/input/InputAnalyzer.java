/**
 * A class used to compare and interpret, and collect input.
 */

package input;


public class InputAnalyzer
{
    /**
     * Checks if a string is exactly equal to another.
     * 
     * @param input     The first string to compare.
     * @param toCompare The second string to compare.
     * @return  True if the strings are equal, and false otherwise.
     */
    public static boolean checkSpecificInput( String input, String toCompare )
    {
        input.trim();
        toCompare.trim();
        if (input.compareTo( toCompare )==0) {
            return true;
        }
        return false;
    }

    /**
     * Checks if a string can be converted into an integer.
     * 
     * @param line  The string to check.
     * @return  True if the input can be converted, and false otherwise.
     */
    public static boolean isIntegerInput( String line )
    {
        // try to parse the String to an int
        try {
            Integer.parseInt( line );
            return true;
        } catch (Exception e) {
            // if there was an error, we don't have an int
            return false;
        }
    }

    /**
     * Checks if a string can be converted into an double.
     * 
     * @param line  The string to check.
     * @return  True if the input can be converted, and false otherwise.
     */
    public static boolean isDoubleInput( String line )
    {
        // try to parse the String to an int
        try {
            Double.parseDouble( line );
            return true;
        } catch (Exception e) {
            // if there was an error, we don't have an int
            return false;
        }
    }

    /**
     * Checks if a given integer is within a pair of bounds, inclusively.
     * 
     * @param min   The lower bound.
     * @param max   The upper bound.
     * @param given The number to compare against the bounds
     * @return  True if the number is between the bounds, and false otherwise.
     */
    public static boolean isWithinBounds( int min, int max, int given )
    {
        if (given >= min && given <= max) {
            return true;
        }
        return false;
    }

    /**
     * Checks whether a menu option is valid if the options start at zero and go until max, and
     * 'Q' or 'q' quits the program.
     * 
     * @param input The string given as input for an option.
     * @param max   The maximum number accepted as an option.
     * @return  True if the input is valid and false otherwise.
     */
    public static boolean verifyInput( String input, int max )
    {
        // check if we are to quit the program
        if (InputAnalyzer.checkSpecificInput( "Q", input ) || InputAnalyzer.checkSpecificInput( "q", input )) {
            System.exit( 0 );
        }
        // then check if the input is an integer
        else if (InputAnalyzer.isIntegerInput( input )) {
            int intInput = Integer.parseInt( input );
            if (InputAnalyzer.isWithinBounds( 1, max, intInput )) {
                return true;
            }
        }
        return false;
    }
}