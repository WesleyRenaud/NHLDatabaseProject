/**
 * UI used to gt user input from a menu option and call the corresponding handling code.
 */

package ui;


import java.io.IOException;

<<<<<<< HEAD
import input.InputReader;
import utilities.BufferGenerator;
import utilities.Saver;
import team.League;
import player.Players;

=======

import utilities.BufferGenerator;
import utilities.InputAnalyzer;
import utilities.Saver;
import team.League;
import player.Players;
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0

public class NHLUI {
    private static NHLStatEditor statsEditor;
    private static NHLStatReader statsReader;
    private static Saver saver;
    private static League league;
    private static Players players;

    /**
     * Loads the data into the stat reader and the stat adder.
     */
    private static void loadData() {
        initializeInterfaces();
        try {
            league = (League) saver.loadObject("teams.txt");
            players = (Players) saver.loadObject("players.txt");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            league = new League();
            players = new Players();
        }
        statsEditor.setData(league, players);
        statsReader.setData(league, players);
    }

    /**
     * Initializes the stats reader and stats adder classes.
     */
    private static void initializeInterfaces() {
        statsReader = new NHLStatReader();
        statsEditor = new NHLStatEditor();
        saver = new Saver();
    }

    /**
     * Saves the data from the stat holder into a separate file.
     */
    private static void saveData() {
        try {
            saver.saveObject(league, "teams.txt");
            saver.saveObject(players, "players.txt");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    

    /**
     * Displays all options of the program.
     */
    private static void printMenuOnFirstTime() {
        System.out.println("\n\t\t\t\t\t\t\t\t\tWelcome to NHL Stat Analyzer -> Explore the Menu Below");
        BufferGenerator.printBufferForScreenWidth();
        printMenuOptions();
        BufferGenerator.printBufferForScreenWidth();
    }

    /**
     * Helper method to print the options of the menu
     */
    private static void printMenuOptions() {
        System.out.println(" ~ Enter data into the database [1]");
        System.out.println(" ~ Print Standings for this season [2] ");
        System.out.println(" ~ Print out standings from a previous season [3] ");
        System.out.println(" ~ Individual player lookup [4] ");
        System.out.println(" ~ Print out stats leaders for a specific team [5] ");
        System.out.println(" ~ Print out league leaders for a specific stat [6] ");
        System.out.println(" ~ Exit the program ['Q' or 'q']");
    }

    /**
     * Re-prints the menu without the title.
     */
    private static void reprintMenu() {
        BufferGenerator.printBufferForScreenWidth();
        printMenuOptions();
        BufferGenerator.printBufferForScreenWidth();
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
<<<<<<< HEAD
                while (input != 0) {
                    statsEditor.printMenu();
                    input = statsEditor.getUserChoice();
                    if (input != 0) {
=======
                while (input != 3) {
                    statsEditor.displayMenu();
                    input = statsEditor.getUserChoice();
                    if (input != 3) {
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
                        statsEditor.enterSubDatabase(input);
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
        printMenuOnFirstTime();

        while (true) {
            int input = InputReader.getValidInput(" * Enter Choice or 'Q'/'q' to Quit >> ", 6);
            completeTask(input);
            reprintMenu();
        }
    }
}