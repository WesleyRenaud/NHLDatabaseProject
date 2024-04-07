/**
 * A class used for reading different forms of input from the keyboard.
 */

package input;


import java.util.Scanner;


public class InputReader
{
    private static Scanner input = new Scanner( System.in );

    
    /**
     * Reads the next line to reset the terminal for the next input.
     */
    public static void readBuffer() {
        input.nextLine();
    }

    /**
     * Returns string input from a given prompt and accepts the 'Q' and 'q' keys to quit
     * the program.
     * 
     * @param prompt    The string that prompts the user for input.
     * @return  The string given as input from the prompt.
     */
    public static String getStringInput( String prompt )
    {
        System.out.print( prompt );
        String in = input.next();

        if (InputAnalyzer.checkSpecificInput( "Q", in ) || InputAnalyzer.checkSpecificInput( "q", in )) {
            System.exit( 0 );
        }
        return in;
    }

    /**
     * Returns line (string) input from a given prompt and accepts the 'Q' and 'q' keys
     * to quit the program.
     * 
     * @param prompt    The string that prompts the user for input.
     * @return  The line given as input after the prompt.
     */
    public static String getLineInput( String prompt )
    {
        System.out.print( prompt );
        String in = input.nextLine();
        return in;
    }

    /**
     * Returns integer input from a given prompt and accepts the 'Q' and 'q' keys to quit
     * the program.
     * 
     * @param prompt    The string that prompts the user for input.
     * @return  The integer given as input after the prompt.
     */
    public static int getIntegerInput( String prompt )
    {
        System.out.print( prompt );
        String in = input.next();
        while (!InputAnalyzer.isIntegerInput (in ))
        {
            if (InputAnalyzer.checkSpecificInput( "Q", in ) || InputAnalyzer.checkSpecificInput( "q", in )) {
                System.exit( 0 );
            }
            InputReader.readBuffer();
            System.out.print( "Error - input must be an integer.\nEnter new input >> " );
            in = input.next();
        }
        return Integer.parseInt( in );
    }

    /**
     * Returns double input from a given prompt and accepts the 'Q' and 'q' keys to quit
     * the program.
     * 
     * @param prompt    The string that prompts the user for input.
     * @return  The double given as input after the prompt.
     */
    public static double getDoubleInput( String prompt )
    {
        System.out.print( prompt );
        String in = input.next();
        while (!InputAnalyzer.isDoubleInput( in ))
        {
            if (InputAnalyzer.checkSpecificInput( "Q", in ) || InputAnalyzer.checkSpecificInput( "q", in )) {
                System.exit( 0 );
            }
            System.out.print( "Error - input must be an integer.\nEnter new input >>  ");
            in = input.next();
        }
        return Double.parseDouble( in );
    }

    /**
     * Returns natural number input from a given prompt and accepts the 'Q' and 'q' keys
     * to quit the program.
     * 
     * @param prompt    The string that prompts the user for input.
     * @return  The natural number given as input after the prompt.
     */
    public static int getNaturalNumberInput( String prompt )
    {
        System.out.print( prompt );
        String in = input.next();
        while (!InputAnalyzer.isIntegerInput( in ) || Integer.parseInt( in ) < 0)
        {
            if (InputAnalyzer.checkSpecificInput( "Q", in ) || InputAnalyzer.checkSpecificInput( "q", in )) {
                System.exit( 0 );
            }
            System.out.print( "Error - input must be a nonnegative integer.\nEnter new input >> " );
            in = input.next();
        }
        return Integer.parseInt( in );
    }

    /**
     * Returns natural number input, or -1, from a given prompt and accepts the 'Q' and 'q'
     * keys to quit the program.
     * 
     * @param prompt    The string that prompts the user for input.
     * @return  The natural number or -1 given as input after the prompt.
     */
    public static int getNaturalNumberInput_AcceptMinusOne( String prompt )
    {
        System.out.print( prompt );
        String in = input.next();
        while (!InputAnalyzer.isIntegerInput( in ) || Integer.parseInt( in ) < 0 && Integer.parseInt( in ) != -1)
        {
            if (InputAnalyzer.checkSpecificInput( "Q", in ) || InputAnalyzer.checkSpecificInput( "q", in )) {
                System.exit( 0 );
            }
            System.out.print( "Error - input must be a nonnegative integer.\nEnter new input >> " );
            in = input.next();
        }
        return Integer.parseInt( in );
    }

    /**
     * Asks the user a yes/no question and returns their answer and accepts the 'Q' and 'q' 
     * keys to quit the program.
     * 
     * @param prompt    The string that prompts the user for an answer.
     * @return  True if the user says "yes", and false if the user says "no".
     */
    public static boolean getYesNoInput( String prompt )
    {
        readBuffer();
        String in = getLineInput( prompt );
        while (!(InputAnalyzer.checkSpecificInput( in, "Yes" ) || InputAnalyzer.checkSpecificInput( in, "yes" ) 
                || InputAnalyzer.checkSpecificInput( in, "No" ) || InputAnalyzer.checkSpecificInput( in, "no" )))
        {
            if (InputAnalyzer.checkSpecificInput( "Q", in ) || InputAnalyzer.checkSpecificInput( "q", in )) {
                System.exit( 0 );
            }
            System.out.println( "Error - input must be a yes/no answer" );
            in = getLineInput( prompt );     
        }
        if (InputAnalyzer.checkSpecificInput( in, "Yes" ) || InputAnalyzer.checkSpecificInput( in, "yes" )) {
            return true;
        }
        return false;
    }

    /**
     * Gets valid input given a prompt message where the accepted inputs are integers from 1 up 
     * until max, or 'Q' or 'q' to quit the program.
     * 
     * @param prompt    The message to prompt the user with.
     * @param max       The maximum number accepted as input.
     * @return  The integer received as input.
     */
    public static int getValidInput( String prompt, int max )
    {
        String in = getLineInput( prompt );
        while (!InputAnalyzer.verifyInput( in, max ))
        {
            if (InputAnalyzer.checkSpecificInput( "Q", in ) || InputAnalyzer.checkSpecificInput( "q", in )) {
                System.exit( 0 );
            }
            System.out.println( "\nInvalid Input - Pleas Try Again\n" );
            in = getLineInput( prompt );
        }
        return Integer.parseInt( in );
    }

    /**
     * Gets valid input given a prompt message where the accepted inputs are integers from 0 up
     * until max, where 0 means to go back, or 'Q' or 'q' to quit the program.
     * 
     * @param prompt    The message to prompt the user with.
     * @param max       The maximum number accepted as input.
     * @return  The integer received as input.
     */
    public static int getValidInput_AcceptBack( String prompt, int max )
    {
        String in = getLineInput( prompt );
        while (!(InputAnalyzer.verifyInput( in, max ) || InputAnalyzer.checkSpecificInput( in, "0" )))
        {
            if (InputAnalyzer.checkSpecificInput( "Q", in ) || InputAnalyzer.checkSpecificInput( "q", in )) {
                System.exit( 0 );
            }
            System.out.println( "\nInvalid Input - Pleas Try Again\n" );
            in = getLineInput( prompt );
        }
        return Integer.parseInt( in );
    }   
}