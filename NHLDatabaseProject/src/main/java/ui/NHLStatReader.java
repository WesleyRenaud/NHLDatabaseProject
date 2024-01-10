/**
 * A class used to read and display data from the database.
 */

package ui;

import nhl.NHLStatHolder;

public class NHLStatReader {
    private NHLStatHolder statHolder;
   
    protected void setStatHolder(NHLStatHolder newStatHolder) {
        statHolder = newStatHolder;
    }

    /**
     * A method used to display the standings in the way selected by the user.
     */
    public void printStandings() {
        printStandingsMenu();
        int choice = InputAnalyzer.getValidInput("Enter User Choice >> ", 7);
        printProperStandings(choice);
    }

    /**
     * Prints the menu used for selecting an option for printing the data regarding teams.
     */
    private void printStandingsMenu() {
        BufferGenerator.printBuffer(100);
        System.out.println("See League Standings By Points [1]");
        System.out.println("See Wildcard Standings [2]");
        System.out.println("See Divisional Standings [3]");
        System.out.println("See Conference Standings [4]");
        System.out.println("See League Standings By Wins [5]");
        System.out.println("See League Standings By Losses [6]");
        System.out.println("See League Standings By Overtime Loses [7]");
        BufferGenerator.printBuffer(100);
    }

    /**
     * Prints the proper standings according to the choice given as input.
     * 
     * @param choice    The choice corresponding to a set of standings.
     */
    private void printProperStandings(int choice) {
        switch (choice) {
            case 1:
                System.out.print(statHolder.getStandings_ByLeague_ByPoints());    
                break;

            case 2:
                System.out.print(statHolder.getStandings_ByWilcard_ByPoints());
                break;

            case 3:
                System.out.print(statHolder.getStandings_ByDivision_ByPoints());
                break;

            case 4:
                System.out.print(statHolder.getStandings_ByConference_ByPoints());
                break;

            case 5:
                System.out.print(statHolder.getStandings_ByLeague_ByWins());
                break;

            case 6:
                System.out.print(statHolder.getStandings_ByLeague_ByLoses());
                break;

            default:
                System.out.print(statHolder.getStandings_ByLeague_ByOvertimeLoses());
                break;
        }
    }

    /**
     * Prints the standings from a previous season.
     */
    public void printStandingsFromPastSeason() {
        //TO DO:
    }

    /**
     * Looks up stats for a specific player.
     */
    public void lookupSpecificPlayer() {
        String playerName = InputAnalyzer.getLineInput("Enter Player Name >> ");
        if (statHolder.checkPlayerExists(playerName)) {
            printPlayerMenu();
            int choice = InputAnalyzer.getValidInput("Enter Choice >> ", 6);
            performPlayerTask(playerName, choice);
        } else {
            System.out.println("Player Does Not Exist");
        }
    }

    /**
     * Prints the menu for options on viewing stats for a specific player.
     */
    private void printPlayerMenu() {
        BufferGenerator.printBuffer(100);
        System.out.println("See Current Season Stats [1]");
        System.out.println("See Career Stats [2]");
        System.out.println("See Stats From Specific Season [3]");
        System.out.println("See Stats Between Two Seasons [4]");
        System.out.println("See Stats Starting From One Season [5]");
        System.out.println("See Stats Up Until One Season [6]");
        BufferGenerator.printBuffer(100);
    }

    /**
     * Prints the proper player stats according to the choice given as input.
     * 
     * @param playerName    The name of the player whose stats we are finding.
     * @param choice        The choice corresponding to a set of the player's stats.
     */
    private void performPlayerTask(String playerName, int choice) {
        switch (choice) {
            case 1:
                System.out.println(statHolder.getCurrentSeasonStats(playerName));
                break;

            case 2:
                System.out.println(statHolder.getCareerStats(playerName));
                break;

            case 3:
                String season = InputAnalyzer.getSeasonInput("Enter Season >> ");
                System.out.println(statHolder.getStatsFromSeason(playerName, season));
                break;

            case 4:
                String startSeason = InputAnalyzer.getSeasonInput("Enter Starting Season >> ");
                String endSeason = InputAnalyzer.getSeasonInput("Enter Ending Season >> ");
                System.out.println(statHolder.getStatsFromStartUntilEnd(playerName, startSeason,  endSeason));
                break;

            case 5:
                startSeason = InputAnalyzer.getSeasonInput("Enter Starting Season >> ");
                System.out.println(statHolder.getStatsFromStart(playerName, startSeason));
                break;

            default:
                endSeason = InputAnalyzer.getSeasonInput("Enter Last Season >> ");
                System.out.println(statHolder.getStatsUntilEnd(playerName, endSeason));
                break;
        }
    }

    /**
     * Prints the players' stats of a team sorted by points.
     */
    protected void printStatLeadersFromTeam() {
        String team = InputAnalyzer.getLineInput("Enter Team >> ");
        if (statHolder.checkTeamExists(team)) {
            System.out.println(statHolder.getTeamLeaders(team));
        } else {
            System.out.println("Team Does Not Exist");
        }
    }

    /**
     * Prints the leaders in the league for a specific stat.
     */
    protected void printLeagueLeaders() {
        printLeagueLeadersMenu();
        int choice = InputAnalyzer.getValidInput("Enter Choice >> ", -1);
        performLeagueLeaderTask(choice);
    }

    /**
     * Prints the menu that shows the options for printing league leaders.
     */
    private void printLeagueLeadersMenu() {
        BufferGenerator.printBuffer(100);
        System.out.println("Point Leaders [1]");
        System.out.println("Goal Leaders [2]");
        System.out.println("Assist Leaders [3]");
        System.out.println("Plus-Minus Leaders [4]");
        System.out.println("Win Leaders [5]");
        System.out.println("Save Percentage Leaders [6]");
        System.out.println("Goals Against Average Leaders [7]");
        BufferGenerator.printBuffer(100);
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
