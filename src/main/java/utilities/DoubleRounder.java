package utilities;

/**
 * A class used for rounding doubles to a certain number of places.
 */
public class DoubleRounder {
    
    /**
<<<<<<< HEAD
     * Credit for round method
     * 
     * https://stackoverflow.com/questions/2808535/round-a-double-to-2-decimal-places
     */

    /**
=======
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
     * Rounds a given double to a given number of places.
     * 
     * @param value     The double to round.
     * @param places    The number of places to round the double to.
     * @return  The rounded double.
     */
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
    
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }    
}