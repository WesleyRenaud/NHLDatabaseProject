/**
 * A UI class used to add NHL stats to the database.
 */

package ui;

import input.InputReader;
import utilities.BufferGenerator;
import team.League;
import player.Players;


public class NHLStatEditor {
    private NHLTeamEditor teamEditor = new NHLTeamEditor();
    private NHLPlayerEditor playerEditor = new NHLPlayerEditor();
    private static String promptMessage = " * Enter an option from the menu or Q to quit >> ";

    protected void setData(League league, Players players) {
        teamEditor.setLeague(league);
        playerEditor.setPlayers(players);
    }

    /**
     * Displays the menu for which part of the database we are to edit.
     */
    public void printMenu() {
        BufferGenerator.printBufferForScreenWidth();
        System.out.println(" ~ Save and Exit [0]");
        System.out.println(" ~ Edit Teams [1]");
        System.out.println(" ~ Edit Players [2]");
        System.out.println();
    }

    /**
     * Gets the choice as to whether the user wants to edit team stats or player stats.
     * 
     * @return  The user input corresponding to the part of the database they want to enter.
     */
    protected int getUserChoice() {
        return InputReader.getValidInput_AcceptBack(promptMessage, 2);
    }

    /**
     * Enters one part of the database according to input given.
     * 
     * @param input The user input given; 1 for teams and 2 for players.
     */
    protected void enterSubDatabase(int input) {
        switch (input) {
            case 0:
                break;

            case 1:
                manageTeams();
                break;
            
            default:
                managePlayers();
                break;
        }
    }


    /**
     * Adds and edits data for the teams in the database.
     */
    private void manageTeams() {
        printTeamsMenu();
        int input = InputReader.getValidInput_AcceptBack(promptMessage, 6);
        completeTeamTask(input);
    }
    
    /**
     * Prints a menu displaying all options for adding/editing data concering teams.
     */
    private void printTeamsMenu() {
        BufferGenerator.printBufferForScreenWidth();
        System.out.println(" ~ Save and Exit [0]");
        System.out.println(" ~ Add a Team [1]");
        System.out.println(" ~ Edit a Team's Record [2]");
        System.out.println(" ~ Edit a Team's Division [3]");
        System.out.println(" ~ Edit a Team's Conference [4]");
        System.out.println(" ~ Edit a Team's City [5]");
        System.out.println(" ~ Edit a Team's Name [6]");
        System.out.println();
    }

    /**
     * Jumps to complete the appropriate task concerning adding/editing data for teams,
     * given an option number as input.
     * 
     * @param input The option number for the task to be completed.
     */
    private void completeTeamTask(int input) {
        switch (input) {
            case 0:
                break;

            case 1:
                teamEditor.addTeam();
                break;

            case 2:
                teamEditor.editTeamRecord();
                break;

            case 3:
                teamEditor.editTeamDivision();
                break;
            
            case 4:
                teamEditor.editTeamConference();
                break;

            case 5:
                teamEditor.editTeamCity();
                break;

            default:
                teamEditor.editTeamName();
                break;
        }
    }
    

    /**
     * Adds and edits data for the players in the database.
     */
    private void managePlayers() {
        int choice = -1;
        while (choice != 0) {
            printPlayersMenu();
            choice = InputReader.getValidInput_AcceptBack(promptMessage, 8);
            completePlayerTask(choice);
        }
    }

    /**
     * Prints a menu displaying all options for adding/editing data concering players.
     */
    private void printPlayersMenu() {
        BufferGenerator.printBufferForScreenWidth();
        System.out.println(" ~ Save and Exit [0]");
        System.out.println(" ~ Add a Player [1]");
        System.out.println(" ~ Edit Player's Current Season Stats [2]");
        System.out.println(" ~ Edit Player's Past Seasons Stats [3]");
        System.out.println(" ~ Add a Season to a Player's Career [4]");
        System.out.println(" ~ Edit a Player's Team [5]");
        System.out.println(" ~ Edit a Player's Number [6]");
        System.out.println(" ~ Edit a Player's Name [7]");
        System.out.println(" ~ Edit a Player's Birthday [8]");
        System.out.println();
    }

    /**
     * Jumps to complete the appropriate task concerning adding/editing data for players,
     * given an option number as input.
     * 
     * @param input The option number for the task to be completed.
     */
    private void completePlayerTask(int input) {
        switch (input) {
            case 0:
                break;

            case 1:
                playerEditor.addPlayer();
                InputReader.readBuffer();
                break;

            case 2:
                playerEditor.editPlayerCurrentSeasonStats();
                break;

            case 3:
                playerEditor.editPlayerPastSeasonStats();
                break;

            case 4:
                playerEditor.addPlayerSeason();
                InputReader.readBuffer();
                break;

            case 5:
                playerEditor.editPlayerTeam();
                break;

            case 6:
                playerEditor.editPlayerNumber();
                InputReader.readBuffer();
                break;

            case 7:
                playerEditor.editPlayerName();
                break;

            default:
                playerEditor.editPlayerBirthday();
                break;
        }
    }
}