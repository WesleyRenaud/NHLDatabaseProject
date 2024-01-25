/**
 * A (UI) class used to add NHL stats to the database.
 */

package ui;

<<<<<<< HEAD
import input.InputReader;
import utilities.BufferGenerator;
import team.League;
import player.Players;

=======
import player.Players;
import team.League;

import utilities.BufferGenerator;
import utilities.InputAnalyzer;
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0

public class NHLStatEditor {
    private NHLTeamEditor teamEditor = new NHLTeamEditor();
    private NHLPlayerEditor playerEditor = new NHLPlayerEditor();
<<<<<<< HEAD
    private static String promptMessage = " * Enter an option from the menu or Q to quit >> ";
=======
    private static String promptMessage = "Enter an option from the menu or Q to quit >> ";
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0

    protected void setData(League league, Players players) {
        teamEditor.setLeague(league);
        playerEditor.setPlayers(players);
    }

    /**
     * Displays the menu for which part of the database we are to edit.
     */
<<<<<<< HEAD
    public void printMenu() {
        BufferGenerator.printBufferForScreenWidth();
        System.out.println(" ~ Back [0]");
        System.out.println(" ~ Edit Teams [1]");
        System.out.println(" ~ Edit Players [2]");
        BufferGenerator.printBufferForScreenWidth();
=======
    public void displayMenu() {
        BufferGenerator.printBuffer(100);
        System.out.println("Edit Teams [1]");
        System.out.println("Edit Players [2]");
        System.out.println("Stop Adding Data [3]");
        BufferGenerator.printBuffer(100);
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
    }

    /**
     * Gets the choice as to whether the user wants to edit team stats or player stats.
     * 
     * @return  The user input corresponding to the part of the database they want to enter.
     */
    protected int getUserChoice() {
<<<<<<< HEAD
        return InputReader.getValidInput_AcceptBack(promptMessage, 2);
=======
        return InputAnalyzer.getValidInput(promptMessage, 3);
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
    }

    /**
     * Enters one part of the database according to input given.
     * 
     * @param input The user input given; 1 for teams and 2 for players.
     */
    protected void enterSubDatabase(int input) {
        switch (input) {
<<<<<<< HEAD
            case 0:
                break;

=======
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
            case 1:
                manageTeams();
                break;
            
<<<<<<< HEAD
            default:
                managePlayers();
                break;
        }
    }


=======
            case 2:
                managePlayers();
                break;

            default:
                break;
        }
    }

>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
    /**
     * Adds and edits data for the teams in the database.
     */
    private void manageTeams() {
        printTeamsMenu();
<<<<<<< HEAD
        int input = InputReader.getValidInput_AcceptBack(promptMessage, 6);
        completeTeamTask(input);
    }
=======
        int input = InputAnalyzer.getValidInput(promptMessage, 6);
        completeTeamTask(input);
    }

    /**
     * Adds and edits data for the players in the database.
     */
    private void managePlayers() {
        printPlayersMenu();
        int input = InputAnalyzer.getValidInput(promptMessage, 4);
        completePlayerTask(input);
    }
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
    
    /**
     * Prints a menu displaying all options for adding/editing data concering teams.
     */
    private void printTeamsMenu() {
<<<<<<< HEAD
        BufferGenerator.printBufferForScreenWidth();
        System.out.println(" ~ Back [0]");
        System.out.println(" ~ Add a Team [1]");
        System.out.println(" ~ Edit a Team's City [2]");
        System.out.println(" ~ Edit a Team's Name [3]");
        System.out.println(" ~ Edit a Team's Conference [4]");
        System.out.println(" ~ Edit a Team's Division [5]");
        System.out.println(" ~ Edit a Team's Record [6]");
        BufferGenerator.printBufferForScreenWidth();
=======
        BufferGenerator.printBuffer(100);
        System.out.println("Add a Team [1]");
        System.out.println("Edit a Team's City [2]");
        System.out.println("Edit a Team's Name [3]");
        System.out.println("Edit a Team's Conference [4]");
        System.out.println("Edit a Team's Division [5]");
        System.out.println("Edit a Team's Record [6]");
        BufferGenerator.printBuffer(100);
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
    }

    /**
     * Jumps to complete the appropriate task concerning adding/editing data for teams,
     * given an option number as input.
     * 
     * @param input The option number for the task to be completed.
     */
    private void completeTeamTask(int input) {
        switch (input) {
<<<<<<< HEAD
            case 0:
                break;

=======
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
            case 1:
                teamEditor.addTeam();
                break;

            case 2:
                teamEditor.editTeamCity();
                break;

            case 3:
                teamEditor.editTeamName();
                break;

            case 4:
                teamEditor.editTeamConference();
                break;

            case 5:
                teamEditor.editTeamDivision();
                break;

            default:
                teamEditor.editTeamRecord();
                break;
        }
    }
<<<<<<< HEAD
    

    /**
     * Adds and edits data for the players in the database.
     */
    private void managePlayers() {
        int choice = -1;
        while (choice != 0) {
            printPlayersMenu();
            choice = InputReader.getValidInput_AcceptBack(promptMessage, 5);
            completePlayerTask(choice);
        }
    }
=======
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0

    /**
     * Prints a menu displaying all options for adding/editing data concering players.
     */
    private void printPlayersMenu() {
<<<<<<< HEAD
        BufferGenerator.printBufferForScreenWidth();
        System.out.println(" ~ Add a Player [1]");
        System.out.println(" ~ Edit Current Seasons Stats for a Player [2]");
        System.out.println(" ~ Add Seasons to a Player's Career [3]");
        System.out.println(" ~ Edit a Player's Team [4]");
        System.out.println(" ~ Edit a Player's Number [5]");
=======
        BufferGenerator.printBuffer(100);
        System.out.println("Add a Player [1]");
        System.out.println("Edit Current Seasons Stats for a Player [2]");
        System.out.println("Add Seasons to a Player's Career [3]");
        System.out.println("Edit a Player's Team [4]");
        System.out.println("Edit a Team's Number [5]");
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
    }

    /**
     * Jumps to complete the appropriate task concerning adding/editing data for players,
     * given an option number as input.
     * 
     * @param input The option number for the task to be completed.
     */
    private void completePlayerTask(int input) {
        switch (input) {
            case 1:
                playerEditor.addPlayer();
<<<<<<< HEAD
                InputReader.readBuffer();
=======
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
                break;

            case 2:
                playerEditor.editPlayerSeasonStats();
                break;

            case 3:
                playerEditor.addPlayerSeasons();
                break;

            case 4:
                playerEditor.editPlayerTeam();
                break;

            default:
                playerEditor.editPlayerNumber();
                break;
        }
    }
}