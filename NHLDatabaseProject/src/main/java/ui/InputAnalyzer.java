package ui;

import java.util.Scanner;

/**
 * A class used to compare and interpret strings of input.
 */
public class InputAnalyzer {
    static Scanner input = new Scanner(System.in);

    /**
     * Reads the next line to clear the terminal for the next input.
     */
    public static void readBuffer() {
        input.nextLine();
    }

    /**
     * Returns string input from a given prompt.
     * 
     * @param prompt    The string that prompts the user for input.
     * @return  The string given as input after the prompt.
     */
    public static String getStringInput(String prompt) {
        System.out.print(prompt);
        return input.next();
    }

    /**
     * Returns line (string) input from a given prompt.
     * 
     * @param prompt    The string that prompts the user for input.
     * @return  The line given as input after the prompt.
     */
    public static String getLineInput(String prompt) {
        System.out.print(prompt);
        return input.nextLine();
    }

    /**
     * Returns integer input from a given prompt.
     * 
     * @param prompt    The string that prompts the user for input.
     * @return  The integer given as input after the prompt.
     */
    public static int getIntegerInput(String prompt) {
        System.out.print(prompt);
        String in = input.next();
        while (!isIntegerInput(in)) {
            System.out.print("Error - input must be an integer.\nEnter new input >> ");
            in = input.next();
        }
        return Integer.parseInt(in);
    }

    /**
     * Returns double input from a given prompt.
     * 
     * @param prompt    The string that prompts the user for input.
     * @return  The double given as input after the prompt.
     */
    public static int getDoubleInput(String prompt) {
        System.out.print(prompt);
        String in = input.next();
        while (!isDoubleInput(in)) {
            System.out.print("Error - input must be an integer.\nEnter new input >> ");
            in = input.next();
        }
        return Integer.parseInt(in);
    }

    /**
     * Returns natural number input from a given prompt.
     * 
     * @param prompt    The string that prompts the user for input.
     * @return  The natural number given as input after the prompt.
     */
    public static int getNaturalNumberInput(String prompt) {
        System.out.print(prompt);
        String in = input.next();
        while (!isIntegerInput(in) || Integer.parseInt(in) < 0) {
            System.out.print("Error - input must be a nonnegative integer.\nEnter new input >> ");
            in = input.next();
        }
        return Integer.parseInt(in);
    }

    /**
     * Asks the user a yes/no question and returns their answer.
     * 
     * @param prompt    The string that prompts the user for an answer.
     * @return  True if the user says "yes", and false if the user says "no".
     */
    public static boolean getYesNoInput(String prompt) {
        readBuffer();
        String in = getLineInput(prompt);
        while (!(InputAnalyzer.checkSpecificInput(in, "Yes") || InputAnalyzer.checkSpecificInput(in, "yes") 
                || InputAnalyzer.checkSpecificInput(in, "No") || InputAnalyzer.checkSpecificInput(in, "no"))) {
            System.out.print("Error - input must be a yes/no answer");
            in = getLineInput(prompt);       
        }
        if (InputAnalyzer.checkSpecificInput(in, "Yes") || InputAnalyzer.checkSpecificInput(in, "yes")) {
            return true;
        }
        return false;
    }

    /**
     * Returns input from a given prompt in the form of a season.
     * 
     * @param prompt    The string that prompts the user for input.
     * @return  The season given as input after the prompt.
     */
    public static String getSeasonInput(String prompt) {
        System.out.print(prompt);
        String in = input.next();
        while (!InputAnalyzer.isSeasonInput(in)) {
            System.out.print("Error - input must be in the form of a season.\nEnter new input >> ");
            in = input.next();       
        }
        return in;
    }

    /**
     * Gets valid input given a prompt message where the accepted inputs are integers from
     * one up until max, or 'Q' or 'q' to quit the program.
     * 
     * @param prompt    The message to prompt the user with.
     * @param max   The maximum number accepted as input.
     * @return  The integer received as input.
     */
    public static int getValidInput(String prompt, int max) {
        String input = "";
        input = getLineInput(prompt);
        while (!verifyInput(input, max)) {
            System.out.println("Invalid Input - Pleas Try Again");
            input = getLineInput(prompt);
        }
        return Integer.parseInt(input);
    }

    /**
     * Checks if a string is exactly equal to another.
     * @param input     The first string to compare.
     * @param toCompare The second string to compare.
     * @return  True if the strings are equal, and false otherwise.
     */
    public static boolean checkSpecificInput(String input, String toCompare) {
        input.trim();
        toCompare.trim();
        boolean isSame = false;
        if (input.compareTo(toCompare)==0) {
            isSame = true;
        }
        return isSame;
    }

    /**
     * Checks if a string can be converted into an integer.
     * 
     * @param line  The string to check.
     * @return  True if the input is an integer, and false otherwise.
     */
    public static boolean isIntegerInput(String line) {
        //try to parse the String to an int
        try {
            Integer.parseInt(line);
            return true;
        } catch (Exception e) {
            //if there was an error, we don't have an int
            return false;
        }
    }

    /**
     * Checks if a string can be converted into an double.
     * 
     * @param line  The string to check.
     * @return  True if the input is an double, and false otherwise.
     */
    public static boolean isDoubleInput(String line) {
        //try to parse the String to an int
        try {
            Double.parseDouble(line);
            return true;
        } catch (Exception e) {
            //if there was an error, we don't have an int
            return false;
        }
    }

    /**
     * Checks if a given integer is within a pair of bounds.
     * 
     * @param min   The lower bound.
     * @param max   The upper bound.
     * @param given The number to compare against the bounds
     * @return  True if the number is between the bounds and false otherwise.
     */
    public static boolean isWithinBounds(int min, int max, int given) {
        if (given >= min && given <= max) {
            return true;
        }
        return false;
    }

    /**
     * Checks if a given string is of the form of a season.
     * 
     * @param input The string to check if it is a season.
     * @return  True if it is of the form of a season, and false otherwise.
     */
    public static boolean isSeasonInput(String input) {
        input.trim();
        if (input.length()!=9) {
            return false;
        }
        String firstYear = input.substring(0, 3);
        String secondYear = input.substring(5, 8);
        if (isIntegerInput(firstYear) && isIntegerInput(secondYear) && input.contains("-")) {
            return true;
        }
        return false;
    }

    /**
     * Checks whether an option is valid if the options start at zero and go until max, and
     * 'Q' or 'q' quits the program.
     * 
     * @param input The string given as input for an option.
     * @param max   The maximum number accepted as an option.
     * @return  True if the input is valid and false otherwise.
     */
    public static boolean verifyInput(String input, int max) {
        // check if we are to quit the program
        if (InputAnalyzer.checkSpecificInput("Q", input) || InputAnalyzer.checkSpecificInput("q", input)) {
            System.exit(0);
        }
        // then check if the input is an integer
        else if (InputAnalyzer.isIntegerInput(input)) {
            int intInput = Integer.parseInt(input);
            if (InputAnalyzer.isWithinBounds(1, max, intInput)) {
                return true;
            }
            return false;
        }
        return false;
    }
}