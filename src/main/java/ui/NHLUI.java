/**
 * UI class used to operate the main page of the interface.
 */

package ui;


import java.io.IOException;

import input.InputReader;
import utilities.BufferGenerator;
import utilities.Saver;
import team.Seasons;
import player.Players;


public class NHLUI
{
    private static NHLStatEditor statsEditor;
    private static NHLStatReader statsReader;
    private static Saver saver;
    private static Seasons seasons;
    private static Players players;


    /**
     * Loads the data into the stat reader and the stat adder.
     */
    private static void loadData()
    {
        initializeInterfaces();
        try {
            seasons = (Seasons) saver.loadObject( "seasons.txt" );
            players = (Players) saver.loadObject( "players.txt" );
        } catch (IOException e) {
            System.out.println( e.getMessage() );
            seasons = new Seasons();
            players = new Players();
        }
        
        statsEditor.setData( seasons, players );
        statsReader.setData( seasons, players );
    }

    /**
     * Initializes the statsReader and statsEditor instances with the data saved in the
     * database.
     */
    private static void initializeInterfaces()
    {
        statsReader = new NHLStatReader();
        statsEditor = new NHLStatEditor();
        saver = new Saver();
    }

    /**
     * Saves the data from the stat holder into a separate file.
     */
    private static void saveData()
    {
        try {
            saver.saveObject( seasons, "seasons.txt" );
            saver.saveObject( players, "players.txt" );
        } catch (IOException e) {
            System.out.println( e.getMessage() );
        }
    }
    

    /**
     * Displays all options of the program.
     */
    private static void printMenuOnFirstTime()
    {
        System.out.println( "\n\t\t\t\t\t\t\t\t\tWelcome to NHL Stat Analyzer -> Explore the Menu Below" );
        BufferGenerator.printBufferForScreenWidth();
        printMenuOptions();
        System.out.println();
    }

    /**
     * Helper method to print the options of the menu.
     */
    private static void printMenuOptions()
    {
        System.out.println( " ~ Edit Database [1]" );
        System.out.println( " ~ Print Standings for Current Season [2]" );
        System.out.println( " ~ Print Standings from Previous Season [3]" );
        System.out.println( " ~ Lookup Individual Player [4]" );
        System.out.println( " ~ Print Team Leaders [5]" );
        System.out.println( " ~ Print League Leaders [6]" );
        System.out.println( " ~ Exit Program ['Q' or 'q']" );
    }

    /**
     * Re-prints the menu without the title.
     */
    private static void reprintMenu()
    {
        BufferGenerator.printBufferForScreenWidth();
        printMenuOptions();
        System.out.println();
    }

    /**
     * Completes the appropriate task for the program based on the task number.
     * 
     * @param taskNumber    The number of the task to be completed.
     */
    public static void completeTask( int taskNumber )
    {
        switch (taskNumber) {
            case 1:
            int input = -1;
                while (input != 0)
                {
                    statsEditor.printMenu();
                    input = statsEditor.getUserChoice();
                    if (input != 0) {
                        statsEditor.enterSubDatabase( input );
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

    public static void main( String[] args )
    {
        loadData();
        printMenuOnFirstTime();

        while (true)
        {
            int input = InputReader.getValidInput( " * Enter Choice or 'Q'/'q' to Quit >> ", 6 );
            completeTask( input );
            reprintMenu();
        }
    }
}