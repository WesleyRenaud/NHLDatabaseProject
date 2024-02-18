/**
 * A class used to read and display data from the database.
 */

package ui;


import input.InputReader;
import input.NHLInputReader;
import utilities.BufferGenerator;
import team.League;
import player.Players;


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
        int choice = -1;
        while (choice != 0) {
            printStandingsMenu();
            choice = InputReader.getValidInput_AcceptBack(" * Enter User Choice >> ", 7);
            printProperStandings(choice);
        }
    }

    /**
     * Prints the menu used for selecting an option for printing the data regarding teams.
     */
    private void printStandingsMenu() {
        BufferGenerator.printBufferForScreenWidth();
        System.out.println(" ~ Back [0]");
        System.out.println(" ~ See League Standings By Points [1]");
        System.out.println(" ~ See Wildcard Standings [2]");
        System.out.println(" ~ See Divisional Standings [3]");
        System.out.println(" ~ See Conference Standings [4]");
        System.out.println(" ~ See League Standings By Wins [5]");
        System.out.println(" ~ See League Standings By Losses [6]");
        System.out.println(" ~ See League Standings By Overtime Loses [7]");
        System.out.println();
    }

    /**
     * Prints the proper standings according to the choice given as input.
     * 
     * @param choice    The choice corresponding to a set of standings.
     */
    private void printProperStandings(int choice) {
        switch (choice) {
            case 0:
                break;

            case 1:
                league.printStandings_ByLeague_ByPoints();    
                break;

            case 2:
                league.printStandings_ByWildcard_ByPoints();
                break;

            case 3:
                league.printStandings_ByDivision_ByPoints();
                break;

            case 4:
                league.printStandings_ByConference_ByPoints();
                break;

            case 5:
                league.printStandings_ByLeague_ByWins();
                break;

            case 6:
                league.printStandings_ByLeague_ByLoses();
                break;

            default:
                league.printStandings_ByLeague_ByOvertimeLoses();
                break;
        }
    }

    /**
     * Prints the standings from a previous season.
     */
    public void printStandingsFromPastSeason() {
        //TO DO:
        System.out.println(" ! TO DO !");
    }

    /**
     * Looks up stats for a specific player.
     */
    public void lookupSpecificPlayer() {
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
        }
    }

    /**
     * Prints the menu for options on viewing stats for a specific player.
     */
    private void printPlayerMenu() {
        BufferGenerator.printBufferForScreenWidth();
        System.out.println(" ~ Back [0]");
        System.out.println(" ~ See Current Season Stats [1]");
        System.out.println(" ~ See Career Stats [2]");
        System.out.println(" ~ See Stats From Specific Season [3]");
        System.out.println(" ~ See Stats Between Two Seasons [4]");
        System.out.println(" ~ See Stats Starting From One Season [5]");
        System.out.println(" ~ See Stats Up Until One Season [6]");
        System.out.println();
    }

    /**
     * Prints the proper player stats according to the choice given as input.
     * 
     * @param playerName    The name of the player whose stats we are finding.
     * @param choice        The choice corresponding to a set of the player's stats.
     */
    private void performPlayerTask(String playerName, int choice) {
        switch (choice) {
            case 0:
                break;

            case 1:
                players.printCurrentSeasonStats(playerName);
                break;

            case 2:
                players.printCareerStats(playerName);
                break;

            case 3:
                String season = NHLInputReader.getSeasonInput(" * Enter Season >> ");
                players.printStatsFromSeason(playerName, season);
                InputReader.readBuffer();
                break;

            case 4:
                String startSeason = NHLInputReader.getSeasonInput(" * Enter Starting Season >> ");
                String endSeason = NHLInputReader.getSeasonInput(" * Enter Ending Season >> ");
                players.printStatsFromStartUntilEnd(playerName, startSeason,  endSeason);
                InputReader.readBuffer();
                break;

            case 5:
                startSeason = NHLInputReader.getSeasonInput(" * Enter Starting Season >> ");
                players.printStatsFromStart(playerName, startSeason);
                InputReader.readBuffer();
                break;

            default:
                endSeason = NHLInputReader.getSeasonInput(" * Enter Last Season >> ");
                players.printStatsUntilEnd(playerName, endSeason);
                InputReader.readBuffer();
                break;
        }
    }

    /**
     * Prints the players' stats of a team sorted by points.
     */
    protected void printStatLeadersFromTeam() {
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
        System.out.println();
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
                players.printTeamLeaders_InPoints(fullTeamName);
                break;

            case 2:
                players.printTeamLeaders_InGoals(fullTeamName);
                break;

            case 3:
                players.printTeamLeaders_InAssists(fullTeamName);
                break;

            case 4:
                players.printTeamLeaders_InPlusMinus(fullTeamName);
                break;

            case 5:
                players.printTeamLeaders_InWins(fullTeamName);
                break;

            case 6:
                players.printTeamLeaders_InSavePercentage(fullTeamName);
                break;
        
            default:
                players.printTeamLeaders_InGoalsAgainstAverage(fullTeamName);
                break;
        }
    }

    
    /**
     * Prints the leaders in the league for a specific stat.
     */
    protected void printLeagueLeaders() {
        int choice = -1;
        while (choice != 0) {
            printLeagueLeadersMenu();
            choice = InputReader.getValidInput_AcceptBack(" * Enter Choice >> ", -1);
            performLeagueLeaderTask(choice);
        }
    }

    /**
     * Prints the menu that shows the options for printing league leaders.
     */
    private void printLeagueLeadersMenu() {
        BufferGenerator.printBufferForScreenWidth();
        System.out.println(" ~ Back [0]");
        System.out.println(" ~ Point Leaders [1]");
        System.out.println(" ~ Goal Leaders [2]");
        System.out.println(" ~ Assist Leaders [3]");
        System.out.println(" ~ Plus-Minus Leaders [4]");
        System.out.println(" ~ Win Leaders [5]");
        System.out.println(" ~ Save Percentage Leaders [6]");
        System.out.println(" ~ Goals Against Average Leaders [7]");
        System.out.println();
    }

    /**
     * Prints the proper league leaders' stats according to the choice given as input.
     * 
     * @param choice        The choice corresponding to printing the league leaders of a stat.
     */
    private void performLeagueLeaderTask(int choice) {
        switch (choice) {
            case 0:
                break;

            case 1:
                players.printPointLeaders();
                break;

            case 2:
                players.printGoalLeaders();
                break;

            case 3:
                players.printAssistLeaders();
                break;

            case 4:
                players.printPlusMinusLeaders();
                break;

            case 5:
                players.printWinLeaders();
                break;

            case 6:
                players.printSavePercentageLeaders();
                break;
        
            default:
                players.printGoalsAgainstAverageLeaders();
                break;
        }
    }
}