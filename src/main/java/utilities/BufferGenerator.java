/**
 * A class used to print buffers for a UI menu.
 */

package utilities;

public class BufferGenerator {
<<<<<<< HEAD
    private static int SCREEN_WIDTH = 212;
=======
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
    
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
<<<<<<< HEAD
     * Prints enough dashes to cover the width of the screen followed by a newline
     * character.
     */
    public static void printBufferForScreenWidth() {
        for (int i = 0; i < SCREEN_WIDTH; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
=======
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
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
<<<<<<< HEAD

    /**
     * Generates a string of enough dashes to cover the width of the screen followed by 
     * a newline character.
     * 
     * @return  The string with all of the dashes and the newline character.
     */
    public static String addLineBufferForScreenWidth() {
        String string = "";
        for (int i = 0; i < SCREEN_WIDTH; i++) {
            string += "-";
        }
        string += "\n";
        return string;
    }
=======
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
}