/**
 * A class used to print buffers for a UI menu.
 */

package ui;

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
}
