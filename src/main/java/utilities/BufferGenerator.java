/**
 * A class used to print buffers for a UI menu.
 */

package utilities;

public class BufferGenerator {
    
    /**
     * Prints a given number of dashes followed by a newline character.
     * 
     * @param num   The number of dashes to print.
     */
    public static void printBuffer(int num) {
        for (int i = 0; i < num; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Generates a string of a given number of dashes.
     * 
     * @param num   The number of dashes to add to the string.
     * @return  The string with all of the dashes.
     */
    public static String addBuffer(int num) {
        String string = "";
        for (int i = 0; i < num; i++) {
            string += "-";
        }
        return string;
    }

    /**
     * Generates a string of a given number of dashes followed by a newline character.
     * 
     * @param num   The number of dashes to add to the string.
     * @return  The string with all of the dashes and the newline character.
     */
    public static String addLineBuffer(int num) {
        String string = "";
        for (int i = 0; i < num; i++) {
            string += "-";
        }
        string += "\n";
        return string;
    }
}