/**
 * UI used to gt user input from a menu option and call the corresponding handling code.
 */

package ui;

import java.io.IOException;

import nhl.NHLStatHolder;

public class NHLUI {
    private static NHLStatReader statsReader;
    private static NHLStatAdder statsAdder;
    private static NHLStatHolder statHolder;
    private static Saver saver;

    /**
     * Loads the data into the stat reader and the stat adder.
     */
    private static void loadData() {
        initializeInterfaces();
        try {
            statHolder = (NHLStatHolder) saver.loadObject("data.txt");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            statHolder = new NHLStatHolder();
        }
        statsAdder.setStatHolder(statHolder);
        statsReader.setStatHolder(statHolder);
    }

    /**
     * Initializes the stats reader and stats adder classes.
     */
    private static void initializeInterfaces() {
        statsReader = new NHLStatReader();
        statsAdder = new NHLStatAdder();
        saver = new Saver();
    }

    /**
     * Saves the data from the stat holder into a separate file.
     */
    private static void saveData() {
        try {
            saver.saveObject(statHolder, "data.txt");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
    }

    /**
     * Displays all options of the program.
     */
    private static void displayMenuOnFirstTime() {
        System.out.println("\t\tWelcome to NHL Stat Analyzer -> Explore the Menu Below");
        BufferGenerator.printBuffer(100);
        printMenuOptions();
        BufferGenerator.printBuffer(100);
    }

    /**
     * Helper method to print the options of the menu
     */
    private static void printMenuOptions() {
        System.out.println("Enter data into the database [1]");
        System.out.println("Print Standings for this season [2] ");
        System.out.println("Print out standings from a previous season [3] ");
        System.out.println("Individual player lookup [4] ");
        System.out.println("Print out stats leaders for a specific team [5] ");
        System.out.println("Print out league leaders for a specific stat [6] ");
        System.out.println("Exit the program ['Q' or 'q']");
    }

    /**
     * Re-prints the menu without the title.
     */
    private static void reprintMenu() {
        BufferGenerator.printBuffer(100);
        printMenuOptions();
        BufferGenerator.printBuffer(100);
    }

    /**
     * Completes the appropriate task for the program based on the task number.
     * 
     * @param taskNumber    The number of the task to be completed.
     */
    public static void completeTask(int taskNumber) {
        switch (taskNumber) {
            case 1:
            int input = -1;
                while (input != 3) {
                    statsAdder.displayMenu();
                    input = statsAdder.getUserChoice();
                    if (input != 3) {
                        statsAdder.enterSubDatabase(input);
                        saveData();
                    }
                }
                break;

            case 2:
                statsReader.printStandings();
                break;

            case 3:
                statsReader.printStandingsFromPastSeason();
                break;

            case 4:
                statsReader.lookupSpecificPlayer();
                break;

            case 5:
                statsReader.printStatLeadersFromTeam();
                break;

            default:
                statsReader.printLeagueLeaders();
                break;            
        }
    }

    public static void main(String[] args) {
        loadData();
        displayMenuOnFirstTime();

        while (true) {
            int input = InputAnalyzer.getValidInput("Enter Menu Choice or 'Q'/'q' to Quit >> ", 6);
            completeTask(input);
            reprintMenu();
        }
    }
}