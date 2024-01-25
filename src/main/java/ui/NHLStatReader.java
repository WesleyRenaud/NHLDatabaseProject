/**
 * A class used to read and display data from the database.
 */

package ui;

<<<<<<< HEAD

import input.InputReader;
import input.NHLInputReader;
import utilities.BufferGenerator;
import team.League;
import player.Players;

=======
import team.League;
import player.Players;
import utilities.BufferGenerator;
import utilities.InputAnalyzer;
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0

public class NHLStatReader {
    private League league;
    private Players players;

    protected void setData(League newLeague, Players newPlayers) {
        league = newLeague;
        players = newPlayers;
    }

    /**
     * A method used to display the standings in the way selected by the user.
     */
    public void printStandings() {
        printStandingsMenu();
<<<<<<< HEAD
        int choice = -1;
        while (choice != 0) {
            choice = InputReader.getValidInput_AcceptBack(" * Enter User Choice >> ", 7);
            printProperStandings(choice);
        }
=======
        int choice = InputAnalyzer.getValidInput("Enter User Choice >> ", 7);
        printProperStandings(choice);
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
    }

    /**
     * Prints the menu used for selecting an option for printing the data regarding teams.
     */
    private void printStandingsMenu() {
<<<<<<< HEAD
        BufferGenerator.printBufferForScreenWidth();
        System.out.println(" ~ Back [0]");
        System.out.println(" ~ See League Standings By Points [1]");
        System.out.println(" ~ See Wildcard Standings [2]");
        System.out.println(" ~ See Divisional Standings [3]");
        System.out.println(" ~ See Conference Standings [4]");
        System.out.println(" ~ See League Standings By Wins [5]");
        System.out.println(" ~ See League Standings By Losses [6]");
        System.out.println(" ~ See League Standings By Overtime Loses [7]");
        BufferGenerator.printBufferForScreenWidth();
=======
        BufferGenerator.printBuffer(100);
        System.out.println("See League Standings By Points [1]");
        System.out.println("See Wildcard Standings [2]");
        System.out.println("See Divisional Standings [3]");
        System.out.println("See Conference Standings [4]");
        System.out.println("See League Standings By Wins [5]");
        System.out.println("See League Standings By Losses [6]");
        System.out.println("See League Standings By Overtime Loses [7]");
        BufferGenerator.printBuffer(100);
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
    }

    /**
     * Prints the proper standings according to the choice given as input.
     * 
     * @param choice    The choice corresponding to a set of standings.
     */
    private void printProperStandings(int choice) {
        switch (choice) {
<<<<<<< HEAD
            case 0:
                break;

=======
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
            case 1:
                System.out.print(league.getStandings_ByLeague_ByPoints());    
                break;

            case 2:
                System.out.print(league.getStandings_ByWildcard_ByPoints());
                break;

            case 3:
                System.out.print(league.getStandings_ByDivision_ByPoints());
                break;

            case 4:
                System.out.print(league.getStandings_ByConference_ByPoints());
                break;

            case 5:
                System.out.print(league.getStandings_ByLeague_ByWins());
                break;

            case 6:
                System.out.print(league.getStandings_ByLeague_ByLoses());
                break;

            default:
                System.out.print(league.getStandings_ByLeague_ByOvertimeLoses());
                break;
        }
    }

<<<<<<< HEAD

=======
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
    /**
     * Prints the standings from a previous season.
     */
    public void printStandingsFromPastSeason() {
        //TO DO:
    }

<<<<<<< HEAD

=======
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
    /**
     * Looks up stats for a specific player.
     */
    public void lookupSpecificPlayer() {
<<<<<<< HEAD
        String playerName = InputReader.getLineInput(" * Enter Player Name >> ");
        if (players.checkPlayerExists(playerName)) {
            int choice = -1;
            while (choice != 0) {
                printPlayerMenu();
                choice = InputReader.getValidInput_AcceptBack(" * Enter Choice >> ", 6);
                performPlayerTask(playerName, choice);
            }
        } else {
            System.out.println(" ! Player Does Not Exist !");
=======
        String playerName = InputAnalyzer.getLineInput("Enter Player Name >> ");
        if (players.checkPlayerExists(playerName)) {
            printPlayerMenu();
            int choice = InputAnalyzer.getValidInput("Enter Choice >> ", 6);
            performPlayerTask(playerName, choice);
        } else {
            System.out.println("Player Does Not Exist");
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
        }
    }

    /**
     * Prints the menu for options on viewing stats for a specific player.
     */
    private void printPlayerMenu() {
<<<<<<< HEAD
        BufferGenerator.printBufferForScreenWidth();
        System.out.println(" ~ Back [0]");
        System.out.println(" ~ See Current Season Stats [1]");
        System.out.println(" ~ See Career Stats [2]");
        System.out.println(" ~ See Stats From Specific Season [3]");
        System.out.println(" ~ See Stats Between Two Seasons [4]");
        System.out.println(" ~ See Stats Starting From One Season [5]");
        System.out.println(" ~ See Stats Up Until One Season [6]");
        BufferGenerator.printBufferForScreenWidth();
=======
        BufferGenerator.printBuffer(100);
        System.out.println("See Current Season Stats [1]");
        System.out.println("See Career Stats [2]");
        System.out.println("See Stats From Specific Season [3]");
        System.out.println("See Stats Between Two Seasons [4]");
        System.out.println("See Stats Starting From One Season [5]");
        System.out.println("See Stats Up Until One Season [6]");
        BufferGenerator.printBuffer(100);
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
    }

    /**
     * Prints the proper player stats according to the choice given as input.
     * 
     * @param playerName    The name of the player whose stats we are finding.
     * @param choice        The choice corresponding to a set of the player's stats.
     */
    private void performPlayerTask(String playerName, int choice) {
        switch (choice) {
<<<<<<< HEAD
            case 0:
                break;

            case 1:
                System.out.print(players.getCurrentSeasonStats(playerName));
                break;

            case 2:
                System.out.print(players.getCareerStats(playerName));
                break;

            case 3:
                String season = NHLInputReader.getSeasonInput(" * Enter Season >> ");
                System.out.print(players.getStatsFromSeason(playerName, season));
                break;

            case 4:
                String startSeason = NHLInputReader.getSeasonInput(" * Enter Starting Season >> ");
                String endSeason = NHLInputReader.getSeasonInput(" * Enter Ending Season >> ");
                System.out.print(players.getStatsFromStartUntilEnd(playerName, startSeason,  endSeason));
                break;

            case 5:
                startSeason = NHLInputReader.getSeasonInput(" * Enter Starting Season >> ");
                System.out.print(players.getStatsFromStart(playerName, startSeason));
                break;

            default:
                endSeason = NHLInputReader.getSeasonInput(" * Enter Last Season >> ");
                System.out.print(players.getStatsUntilEnd(playerName, endSeason));
=======
            case 1:
                System.out.println(players.getCurrentSeasonStats(playerName));
                break;

            case 2:
                System.out.println(players.getCareerStats(playerName));
                break;

            case 3:
                String season = InputAnalyzer.getSeasonInput("Enter Season >> ");
                System.out.println(players.getStatsFromSeason(playerName, season));
                break;

            case 4:
                String startSeason = InputAnalyzer.getSeasonInput("Enter Starting Season >> ");
                String endSeason = InputAnalyzer.getSeasonInput("Enter Ending Season >> ");
                System.out.println(players.getStatsFromStartUntilEnd(playerName, startSeason,  endSeason));
                break;

            case 5:
                startSeason = InputAnalyzer.getSeasonInput("Enter Starting Season >> ");
                System.out.println(players.getStatsFromStart(playerName, startSeason));
                break;

            default:
                endSeason = InputAnalyzer.getSeasonInput("Enter Last Season >> ");
                System.out.println(players.getStatsUntilEnd(playerName, endSeason));
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
                break;
        }
    }

<<<<<<< HEAD

=======
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
    /**
     * Prints the players' stats of a team sorted by points.
     */
    protected void printStatLeadersFromTeam() {
<<<<<<< HEAD
        String fullName = InputReader.getLineInput(" * Enter Team >> ");
        int choice = -1;
        while (choice != 0) {
            printTeamLeadersMenu();
            choice = InputReader.getValidInput_AcceptBack(" * Enter Choice >> ", 6);
            performTeamLeaderTask(choice, fullName);
        }
    }

    /**
     * Prints the menu that shows the options for printing team leaders.
     */
    private void printTeamLeadersMenu() {
        BufferGenerator.printBufferForScreenWidth();
        System.out.println(" ~ Back [0]");
        System.out.println(" ~ Point Leaders [1]");
        System.out.println(" ~ Goal Leaders [2]");
        System.out.println(" ~ Assist Leaders [3]");
        System.out.println(" ~ Plus-Minus Leaders [4]");
        System.out.println(" ~ Win Leaders [5]");
        System.out.println(" ~ Save Percentage Leaders [6]");
        System.out.println(" ~ Goals Against Average Leaders [7]");
        BufferGenerator.printBufferForScreenWidth();
    }

    /**
     * Prints the proper team leaders' stats according to the choice given as input.
     * 
     * @param choice        The choice corresponding to printing the team leaders of a stat.
     */
    private void performTeamLeaderTask(int choice, String fullTeamName) {
        switch (choice) {
            case 0:
                break;

            case 1:
                System.out.println(players.getTeamLeaders_InPoints(fullTeamName));
                break;

            case 2:
                System.out.println(players.getTeamLeaders_InGoals(fullTeamName));
                break;

            case 3:
                System.out.println(players.getTeamLeaders_InAssists(fullTeamName));
                break;

            case 4:
                System.out.println(players.getTeamLeaders_InPlusMinus(fullTeamName));
                break;

            case 5:
                System.out.println(players.getTeamLeaders_InWins(fullTeamName));
                break;

            case 6:
                System.out.println(players.getTeamLeaders_InSavePercentage(fullTeamName));
                break;
        
            default:
                System.out.println(players.getTeamLeaders_InGoalsAgainstAverage(fullTeamName));
                break;
        }
    }

    
    /**
=======
        String team = InputAnalyzer.getLineInput("Enter Team >> ");
        System.out.println(players.getTeamLeaders(team));
    }

    /**
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
     * Prints the leaders in the league for a specific stat.
     */
    protected void printLeagueLeaders() {
        printLeagueLeadersMenu();
<<<<<<< HEAD
        int choice = InputReader.getValidInput(" * Enter Choice >> ", -1);
=======
        int choice = InputAnalyzer.getValidInput("Enter Choice >> ", -1);
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
        performLeagueLeaderTask(choice);
    }

    /**
     * Prints the menu that shows the options for printing league leaders.
     */
    private void printLeagueLeadersMenu() {
<<<<<<< HEAD
        BufferGenerator.printBufferForScreenWidth();
        System.out.println(" ~ Back [0]");
        System.out.println(" ~ Point Leaders [1]");
        System.out.println(" ~ Goal Leaders [2]");
        System.out.println(" ~ Assist Leaders [3]");
        System.out.println(" ~ Plus-Minus Leaders [4]");
        System.out.println(" ~ Win Leaders [5]");
        System.out.println(" ~ Save Percentage Leaders [6]");
        System.out.println(" ~ Goals Against Average Leaders [7]");
        BufferGenerator.printBufferForScreenWidth();
=======
        BufferGenerator.printBuffer(100);
        System.out.println("Point Leaders [1]");
        System.out.println("Goal Leaders [2]");
        System.out.println("Assist Leaders [3]");
        System.out.println("Plus-Minus Leaders [4]");
        System.out.println("Win Leaders [5]");
        System.out.println("Save Percentage Leaders [6]");
        System.out.println("Goals Against Average Leaders [7]");
        BufferGenerator.printBuffer(100);
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
    }

    /**
     * Prints the proper league leaders' stats according to the choice given as input.
     * 
     * @param choice        The choice corresponding to printing the league leaders of a stat.
     */
    private void performLeagueLeaderTask(int choice) {
        switch (choice) {
            case 1:
                //System.out.println(statHolder.getPointLeaders());
                break;

            case 2:
                //System.out.println(statHolder.getGoalLeaders());
                break;

            case 3:
                //System.out.println(statHolder.getAssistLeaders());
                break;

            case 4:
                //System.out.println(statHolder.getPlusMinusLeaders());
                break;

            case 5:
                //System.out.println(statHolder.getWinLeaders());
                break;

            case 6:
                //System.out.println(statHolder.getSavePercentageLeaders());
                break;
        
            default:
                //System.out.println(statHolder.getGoalsAgainstAverageLeaders());
                break;
        }
    }
}