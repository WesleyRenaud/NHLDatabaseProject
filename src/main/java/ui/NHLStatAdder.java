/**
 * A (UI) class used to add NHL stats to the database.
 */

package ui;

import nhl.NHLStatHolder;

public class NHLStatAdder {
    private NHLStatHolder statHolder;
    private static String promptMessage = "Enter an option from the menu or Q to quit >> ";

    protected void setStatHolder(NHLStatHolder newStatHolder) {
        statHolder = newStatHolder;
    }

    /**
     * Displays the menu for which part of the database we are to edit.
     */
    public void displayMenu() {
        BufferGenerator.printBuffer(100);
        System.out.println("Edit Teams [1]");
        System.out.println("Edit Players [2]");
        System.out.println("Stop Adding Data [3]");
        BufferGenerator.printBuffer(100);
    }

    /**
     * Gets the choice as to whether the user wants to edit team stats or player stats.
     * 
     * @return  The user input corresponding to the part of the database they want to enter.
     */
    protected int getUserChoice() {
        return InputAnalyzer.getValidInput(promptMessage, 3);
    }

    /**
     * Enters one part of the database according to input given.
     * 
     * @param input The user input given; 1 for teams and 2 for players.
     */
    protected void enterSubDatabase(int input) {
        switch (input) {
            case 1:
                manageTeams();
                break;
            
            case 2:
                managePlayers();
                break;

            default:
                break;
        }
    }

    /**
     * Adds and edits data for the teams in the database.
     */
    private void manageTeams() {
        printTeamsMenu();
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
    
    /**
     * Prints a menu displaying all options for adding/editing data concering teams.
     */
    private void printTeamsMenu() {
        BufferGenerator.printBuffer(100);
        System.out.println("Add a Team [1]");
        System.out.println("Edit a Team's City [2]");
        System.out.println("Edit a Team's Name [3]");
        System.out.println("Edit a Team's Conference [4]");
        System.out.println("Edit a Team's Division [5]");
        System.out.println("Edit a Team's Record [6]");
        BufferGenerator.printBuffer(100);
    }

    /**
     * Jumps to complete the appropriate task concerning adding/editing data for teams,
     * given an option number as input.
     * 
     * @param input The option number for the task to be completed.
     */
    private void completeTeamTask(int input) {
        switch (input) {
            case 1:
                addTeam();
                break;

            case 2:
                editTeamCity();
                break;

            case 3:
                editTeamName();
                break;

            case 4:
                editTeamConference();
                break;

            case 5:
                editTeamDivision();
                break;

            default:
                editTeamRecord();
                break;
        }
    }

    /**
     * Prints a menu displaying all options for adding/editing data concering players.
     */
    private void printPlayersMenu() {
        BufferGenerator.printBuffer(100);
        System.out.println("Edit the Current Seasons Stats for a Player [1]");
        System.out.println("Add Seasons to a Player's Career [2]");
        System.out.println("Edit a Player's Team [3]");
        System.out.println("Edit a Team's Number [4]");
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
                editPlayerSeasonStats();
                break;

            case 2:
                addPlayerSeasons();
                break;

            case 3:
                editPlayerTeam();
                break;

            default:
                editPlayerNumber();
                break;
        }
    }

    /**
     * Adds a team to the league with a city, name, conference, division, and possibly a record.
     */
    private void addTeam() {
        BufferGenerator.printBuffer(100);
        String city = InputAnalyzer.getLineInput("Enter Team City >> ");
        String name = InputAnalyzer.getLineInput("Enter Team Name >> ");
        String conference = InputAnalyzer.getStringInput("Enter Team Conference >> ");
        String division = InputAnalyzer.getStringInput("Enter Team Division >> ");
            if (InputAnalyzer.getYesNoInput("Does this team have a record? ")) {
            int wins = InputAnalyzer.getIntegerInput("Enter Number of Wins >> ");
            int loses = InputAnalyzer.getIntegerInput("Enter Number of Loses >> ");
            int overtimeLoses = InputAnalyzer.getIntegerInput("Enter Number of Overtime Loses >> ");
            InputAnalyzer.readBuffer();
            statHolder.addTeam(city, name, conference, division, wins, loses, overtimeLoses);
        } else {
            statHolder.addTeam(city, name, conference, division);
        }
    }

    /**
     * Updates the city for a team supplied as input.
     */
    private void editTeamCity() {
        String fullName = InputAnalyzer.getLineInput("Enter Full Team Name >> ");
        if (statHolder.checkTeamExists(fullName)) {
            String newCity = InputAnalyzer.getLineInput("Enter New City >> ");
            statHolder.updateCity(fullName, newCity);
        } else {
            System.out.println("The Team Does not Exist");
        }
    }

    /**
     * Updates the name for a team supplied as input.
     */
    private void editTeamName() {
        String fullName = InputAnalyzer.getLineInput("Enter Full Team Name >> ");
        if (statHolder.checkTeamExists(fullName)) {
            String newName = InputAnalyzer.getLineInput("Enter New Name >> ");
            statHolder.updateName(fullName, newName);
        } else {
            System.out.println("The Team Does not Exist");
        }
    }

    /**
     * Updates the conference for a team supplied as input.
     */
    private void editTeamConference() {
        String fullName = InputAnalyzer.getLineInput("Enter Full Team Name >> ");
        if (statHolder.checkTeamExists(fullName)) {
            String newConference = InputAnalyzer.getStringInput("Enter New Conference >> ");
            statHolder.updateConference(fullName, newConference);
        } else {
            System.out.println("The Team Does not Exist");
        }
    }

    /**
     * Updates the division for a team supplied as input.
     */
    private void editTeamDivision() {
        String fullName = InputAnalyzer.getLineInput("Enter Full Team Name >> ");
        if (statHolder.checkTeamExists(fullName)) {
            String newDivision = InputAnalyzer.getStringInput("Enter New Division >> ");
            statHolder.updateDivision(fullName, newDivision);
        } else {
            System.out.println("The Team Does not Exist");
        }
    }

    /**
     * Updates the record for a team supplied as input.
     */
    private void editTeamRecord() {
        String fullName = InputAnalyzer.getLineInput("Enter Full Team Name >> ");
        if (statHolder.checkTeamExists(fullName)) {
            int wins = InputAnalyzer.getIntegerInput("Wins >> ");
            int loses = InputAnalyzer.getIntegerInput("Loses >> ");
            int overtimeLoses = InputAnalyzer.getIntegerInput("Overtime Loses >> ");
            InputAnalyzer.readBuffer();
            statHolder.updateRecord(fullName, wins, loses, overtimeLoses);
        } else {
            System.out.println("The Team Does not Exist");
        }
    }

    /**
     * Updates the current season stats for a player supplied as input.
     */
    private void editPlayerSeasonStats() {
        String playerName = InputAnalyzer.getLineInput("Enter Full Player Name >> ");
        if (statHolder.checkPlayerExists(playerName)) {
            if (statHolder.checkPlayerIsSkater(playerName)) {
                editSkaterSeasonStats(playerName);
            } else {
                editGoalieSeasonStats(playerName);
            }
        } else {
            System.out.println("The Player Does not Exist");
        }
    }

    /**
     * Updates the current season stats for a skater supplied as a parameter.
     */
    private void editSkaterSeasonStats(String playerName) {
        int gamesPlayed = InputAnalyzer.getIntegerInput("Games Played >> ");
        int points = InputAnalyzer.getIntegerInput("Points >> ");
        int goals = InputAnalyzer.getIntegerInput("Goals >> ");
        int assists = InputAnalyzer.getIntegerInput("Assists >> ");
        int plusMinus = InputAnalyzer.getIntegerInput("Plus-Minus >> ");
        statHolder.updateSkaterSeasonStats(playerName, gamesPlayed, points, goals, assists, plusMinus);
    }

    /**
     * Updates the current season stats for a goalie supplied as a parameter.
     */
    private void editGoalieSeasonStats(String playerName) {
        int gamesPlayed = InputAnalyzer.getIntegerInput("Games Played >> ");
        int wins = InputAnalyzer.getIntegerInput("Wins >> ");
        int loses = InputAnalyzer.getIntegerInput("Loses >> ");
        int overtimeLoses = InputAnalyzer.getIntegerInput("Overtime Loses >> ");
        double savePercentage = InputAnalyzer.getDoubleInput("Save Percentage >> ");
        double goalsAgainstAverage = InputAnalyzer.getDoubleInput("Goals Against Average >> ");
        statHolder.updateGoalieSeasonStats(playerName, gamesPlayed, wins, loses, overtimeLoses, savePercentage, goalsAgainstAverage);
    }

    /**
     * Adds one or more historical seasons' stats for a player supplied as input.
     */
    private void addPlayerSeasons() {
        String playerName = InputAnalyzer.getLineInput("Enter Full Player Name >> ");
        if (statHolder.checkPlayerExists(playerName)) {
            int num = InputAnalyzer.getIntegerInput("Enter Number of Seasons to Add >> ");
            if (statHolder.checkPlayerIsSkater(playerName)) {
                for (int i = 0; i < num; i++) {
                    addSkaterSeason(playerName);
                }
            }  else {
                for (int i = 0; i < num; i++) {
                    addGoalieSeason(playerName);
                }
            }
        } else {
            System.out.println("The Player Does not Exist");
        }
    }

    /**
     * Adds one or more historical seasons' stats for a player supplied as input.
     */
    private void addSkaterSeason(String playerName) {
        String season = InputAnalyzer.getSeasonInput(playerName);
        int gamesPlayed = InputAnalyzer.getIntegerInput("Games Played >> ");
        int points = InputAnalyzer.getIntegerInput("Points >> ");
        int goals = InputAnalyzer.getIntegerInput("Goals >> ");
        int assists = InputAnalyzer.getIntegerInput("Assists >> ");
        int plusMinus = InputAnalyzer.getIntegerInput("Plus-Minus >> ");
        statHolder.addSkaterSeason(playerName, season, gamesPlayed, points, goals, assists, plusMinus);
    }

    /**
     * Adds one or more historical seasons' stats for a player supplied as input.
     */
    private void addGoalieSeason(String playerName) {
        String season = InputAnalyzer.getSeasonInput(playerName);
        int gamesPlayed = InputAnalyzer.getIntegerInput("Games Played >> ");
        int wins = InputAnalyzer.getIntegerInput("Wins >> ");
        int loses = InputAnalyzer.getIntegerInput("Loses >> ");
        int overtimeLoses = InputAnalyzer.getIntegerInput("Overtime Loses >> ");
        double savePercentage = InputAnalyzer.getDoubleInput("Save Percentage >> ");
        double goalsAgainstAverage = InputAnalyzer.getDoubleInput("Goals Against Average >> ");
        statHolder.addGoalieSeason(playerName, season, gamesPlayed, wins, loses, overtimeLoses, savePercentage, goalsAgainstAverage);
    }

    /**
     * Updates the jersey number for a player supplied as input.
     */
    private void editPlayerNumber() {
        String playerName = InputAnalyzer.getLineInput("Enter Full Player Name >> ");
        if (statHolder.checkPlayerExists(playerName)) {
            int number = InputAnalyzer.getIntegerInput("Enter New Number >> ");
            statHolder.updateNumber(playerName, number);
        } else {
            System.out.println("The Player Does not Exist");
        }
    }

    /**
     * Updates the team for a player supplied as input.
     */
    private void editPlayerTeam() {
        String playerName = InputAnalyzer.getLineInput("Enter Full Player Name >> ");
        if (statHolder.checkPlayerExists(playerName)) {
            String team = InputAnalyzer.getLineInput("Enter New Team >> ");
            statHolder.updateTeam(playerName, team);
        } else {
            System.out.println("The Player Does not Exist");
        }
    }
}