package utilities;

/**
 * A class used for rounding doubles to a certain number of places.
 */
public class DoubleRounder
{
    
    /**
     * Credit for round method
     * 
     * https://stackoverflow.com/questions/2808535/round-a-double-to-2-decimal-places
     */

    /**
     * Rounds a given double to a given number of places.
     * 
     * @param value     The double to round.
     * @param places    The number of places to round the double to.
     * @throws IllegalArgumentException If the number of places is not valid (i.e. less than 0)
     * @return  The rounded double.
     */
    public static double round( double value, int places )
    {
        if (places < 0) throw new IllegalArgumentException();
    
        long factor = (long)(Math.pow( 10, places ));
        value = value * factor;
        long tmp = Math.round( value );
        return (double) tmp / factor;
    }    
}