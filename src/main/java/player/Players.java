/**
 * A class used as a data structure for all players in the database. The class manages the data
 * structure and retrieves data from it.
 */

package player;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import input.InputAnalyzer;


public class Players implements Serializable {
    private static final long serialVersionUID = -2181392019916751192L;
    private List<Player> players = new ArrayList<>();

    /**
     * Adds a new skater to the list of players given their name, birthday, handedness, retired
     * status, number, and team.
     * 
     * @param name          The skater's name.
     * @param birthday      The skater's birthday.
     * @param handedness    The skater's handedness.
     * @param retired       The skater's retired status.
     * @param number        The skater's jersey number.
     * @param team          The skater's team.
     */
    public void addSkater(String name, String birthday, String handedness, boolean retired, int number, String team) {
        players.add(new Skater(name, birthday, handedness, retired, number, team));
    }

    /**
     * Adds a new goalie to the list of players given their name, birthday, handedness, 
     * retired status, number, and team.
     * 
     * @param name          The goalie's name.
     * @param birthday      The goalie's birthday.
     * @param handedness    The goalie's handedness.
     * @param retired       The goalie's retired status.
     * @param number        The goalie's jersey number.
     * @param team          The goalie's team.
     */
    public void addGoalie(String name, String birthday, String handedness, boolean retired, int number, String team) {
        players.add(new Skater(name, birthday, handedness, retired, number, team));
    }

    /**
     * Appends a season to a given skater's career.
     * 
     * @param name          The skater whose stats are being updated
     * @param season        The season being added.
     * @param gamesPlayed   The number of games played during the season.
     * @param goals         The number of goals during the season.
     * @param assists       The number of assists during the season.
     * @param plusMinus     he plus-minus during the season.
     */
    public void addSkaterSeason(String name, String season, int gamesPlayed, int goals, int assists, int plusMinus) {
        int index = getPlayerIndex(name);
        players.get(index).addSkaterSeason(season, gamesPlayed, goals, assists, plusMinus);
    }

    /**
     * Appends a season to a given goalie's career.
     * 
     * @param playerName            The goalie whose  stats are being updated.
     * @param season                The season being added.
     * @param wins                  The number of wins during the season.
     * @param loses                 The number of loses during the season.
     * @param overtimeLoses         The number of overtime loses during the season.
     * @param savePercentage        The save percentafe during the season
     * @param goalsAgainstAverage   The goals against average during the season.
     */
    public void addGoalieSeason(String playerName, String season, int wins, int loses, int overtimeLoses, double savePercentage, double goalsAgainstAverage) {
        int index = getPlayerIndex(playerName);
        players.get(index).addGoalieSeason(season, wins, loses, overtimeLoses, savePercentage, goalsAgainstAverage);
    }


    /**
     * Updates the current season's stats for a given skater.
     * 
     * @param playerName    The skater whose stats are being updated.
     * @param gamesPlayed   The new number of games played.
     * @param goals         The new number of goals.
     * @param assists       The new number of assists.
     * @param plusMinus     The new plus-minus.
     */
    public void updateSkaterSeasonStats(String playerName, int gamesPlayed, int goals, int assists, int plusMinus) {
        int index = getPlayerIndex(playerName);
        players.get(index).updateSkaterSeason(gamesPlayed, goals, assists, plusMinus);
    }

    /**
     * Updates the current season's stats for a given goalie.
     * 
     * @param playerName            The goalie whose stats are being updated.
     * @param wins                  The new number of wins.
     * @param loses                 The new number of loses.
     * @param overtimeLoses         The new number of overtime loses.
     * @param savePercentage        The new save percentage.
     * @param goalsAgainstAverage   The new goals against average.
     */
    public void updateGoalieSeasonStats(String playerName, int wins, int loses, int overtimeLoses, double savePercentage, double goalsAgainstAverage) {
        int index = getPlayerIndex(playerName);
        players.get(index).updateGoalieSeason(wins, loses, overtimeLoses, savePercentage, goalsAgainstAverage);
    }

    /**
     * Updates the number of a given player.
     * 
     * @param playerName    The name of the player whose number is being updated.
     * @param number        The new number of the player.
     */
    public void updateNumber(String playerName, int number) {
        int index = getPlayerIndex(playerName);
        players.get(index).setNumber(number);
    }

    /**
     * Updates the team of a given player.
     * 
     * @param playerName    The name of the player whose team is being updated.
     * @param team          The new team of the player.
     */
    public void updateTeam(String playerName, String team) {
        int index = getPlayerIndex(playerName);
        players.get(index).setTeam(team);
    }


    /**
     * Returns a string showing a given player's stats during the most recent season.
     * 
     * @param playerName    The name of the player whose stats we are retreiving.
     * @return  The player's stats for the current season.
     */
    public String getCurrentSeasonStats(String playerName) {
        int index = getPlayerIndex(playerName);
        return players.get(index).getCurrentSeasonStats();
    }

    /**
     * Returns a string showing a given player's career stats.
     * 
     * @param playerName    The name of the player whose stats we are retreiving.
     * @return  The player's career stats.
     */
    public String getCareerStats(String playerName) {
        int index = getPlayerIndex(playerName);
        return players.get(index).getCareerStats();
    }

    public String getStatsFromSeason(String playerName, String season) {
        int index = getPlayerIndex(playerName);
        return players.get(index).getStatsFromSeason(season);
    }

    /**
     * Returns the stats of a player over a range of seasons, given a start and an end.
     * 
     * @param firstSeason   The first season to get the stats of.
     * @param lastSeason    The last season to get the stats of.
     * @return  A string holding the stats of all of the sasons, or an error message.
     */
    public String getStatsFromStartUntilEnd(String playerName, String firstSeason, String lastSeason) {
        int index = getPlayerIndex(playerName);
        return players.get(index).getStatsFromStartUntilEnd(firstSeason, lastSeason);
    }

    /**
     * Returns the stats of a player from a given start season until the present.
     * 
     * @param firstSeason   The first season to get the stats of.
     * @return  A string holding the stats of all seasons, or an error message.
     */
    public String getStatsFromStart(String playerName, String firstSeason) {
        int index = getPlayerIndex(playerName);
        return players.get(index).getStatsFromStart(firstSeason);

    }

    /**
     * Returns the stats of a player from their first season up until a given ending season.
     * 
     * @param lastSeason   The first season to get the stats of.
     * @return  A string holding the stats of all seasons, or an error message.
     */
    public String getStatsUntilEnd(String playerName, String lastSeason) {
        int index = getPlayerIndex(playerName);
        return players.get(index).getStatsUntilEnd(lastSeason);
    }


    /**
     * Gets the skaters' stats of a team, sorted by points.
     * 
     * @param team  The team to get the skaters stats of.
     * @return  A string showing the team's skaters sorted by points.
     */
    public String getTeamLeaders_InPoints(String team) {
        List<Player> teamPlayers = getSkatersOnTeam(team);
        sortByPoints(teamPlayers);
        return getTeamPlayersString(teamPlayers);
    }

    /**
     * Gets the skaters' stats of a team, sorted by goals.
     * 
     * @param team  The team to get the skaters stats of.
     * @return  A string showing the team's skaters sorted by goals.
     */
    public String getTeamLeaders_InGoals(String team) {
        List<Player> teamPlayers = getSkatersOnTeam(team);
        sortByGoals(teamPlayers);
        return getTeamPlayersString(teamPlayers);
    }

    /**
     * Gets the skaters' stats of a team, sorted by assists.
     * 
     * @param team  The team to get the skaters stats of.
     * @return  A string showing the team's skaters sorted by assists.
     */
    public String getTeamLeaders_InAssists(String team) {
        List<Player> teamPlayers = getSkatersOnTeam(team);
        sortByAssists(teamPlayers);
        return getTeamPlayersString(teamPlayers);
    }

    /**
     * Gets the skaters' stats of a team, sorted by plus-minus.
     * 
     * @param team  The team to get the skaters stats of.
     * @return  A string showing the team's skaters sorted by plus-minus.
     */
    public String getTeamLeaders_InPlusMinus(String team) {
        List<Player> teamPlayers = getSkatersOnTeam(team);
        sortByPlusMinus(teamPlayers);
        return getTeamPlayersString(teamPlayers);
    }

    /**
     * Gets the goalie's stats of a team, sorted by wins.
     * 
     * @param team  The team to get the goalie' stats of.
     * @return  A string showing the team's goalies sorted by wins.
     */
    public String getTeamLeaders_InWins(String team) {
        List<Player> teamPlayers = getGoaliesOnTeam(team);
        sortByWins(teamPlayers);
        return getTeamPlayersString(teamPlayers);
    }

    /**
     * Gets the goalies' stats of a team, sorted by wins.
     * 
     * @param team  The team to get the goalies stats of.
     * @return  A string showing the team's goalies sorted by wins.
     */
    public String getTeamLeaders_InSavePercentage(String team) {
        List<Player> teamPlayers = getGoaliesOnTeam(team);
        sortBySavePercentage(teamPlayers);
        return getTeamPlayersString(teamPlayers);
    }

    /**
     * Gets the goalies' stats of a team, sorted by wins.
     * 
     * @param team  The team to get the goalies stats of.
     * @return  A string showing the team's goalies sorted by wins.
     */
    public String getTeamLeaders_InGoalsAgainstAverage(String team) {
        List<Player> teamPlayers = getGoaliesOnTeam(team);
        sortByGoalsAgainstAverage(teamPlayers);
        return getTeamPlayersString(teamPlayers);
    }


    /**
     * Gets a list of all the skaters on a given team.
     * 
     * @param team  The team to get the skaters of.
     * @return  The list of the skaters on the team.
     */
    private List<Player> getSkatersOnTeam(String team) {
        List<Player> teamSkaters = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            if (!players.get(i).isRetired() && players.get(i).isSkater() && players.get(i).getTeam().equals(team)) {
                teamSkaters.add(players.get(i));
            }
        }
        return teamSkaters;
    }

    /**
     * Gets a list of all the goalies on a given team.
     * 
     * @param team  The team to get the goalies of.
     * @return  The list of the goalies on the team.
     */
    private List<Player> getGoaliesOnTeam(String team) {
        List<Player> teamGoalies = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            if (!players.get(i).isRetired() && players.get(i).isGoalie() && players.get(i).getTeam().equals(team)) {
                teamGoalies.add(players.get(i));
            }
        }
        return teamGoalies;
    }


    /**
     * Sorts the list of players of a team by their number of points, in descending order.
     */
    private void sortByPoints(List<Player> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).getCurrentSeasonPoints() < list.get(j + 1).getCurrentSeasonPoints()) {
                    swapPlayers(list, j, j + 1);
                }
            }
        }
    }

    /**
     * Sorts the list of players of a team by their number of goals, in descending order.
     */
    private void sortByGoals(List<Player> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).getCurrentSeasonGoals() < list.get(j + 1).getCurrentSeasonGoals()) {
                    swapPlayers(list, j, j + 1);
                }
            }
        }
    }

    /**
     * Sorts the list of players of a team by their number of assists, in descending order.
     */
    private void sortByAssists(List<Player> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).getCurrentSeasonAssists() < list.get(j + 1).getCurrentSeasonAssists()) {
                    swapPlayers(list, j, j + 1);
                }
            }
        }
    }

    /**
     * Sorts the list of players of a team by their plus-minus, in descending order.
     */
    private void sortByPlusMinus(List<Player> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).getCurrentSeasonPlusMinus() < list.get(j + 1).getCurrentSeasonPlusMinus()) {
                    swapPlayers(list, j, j + 1);
                }
            }
        }
    }

    /**
     * Sorts the list of players of a team by their number of wins, in descending order.
     */
    private void sortByWins(List<Player> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).getCurrentSeasonWins() < list.get(j + 1).getCurrentSeasonWins()) {
                    swapPlayers(list, j, j + 1);
                }
            }
        }
    }

    /**
     * Sorts the list of players of a team by their goals against averages, in ascending order.
     */
    private void sortBySavePercentage(List<Player> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).getCurrentSeasonSavePercentage() < list.get(j + 1).getCurrentSeasonSavePercentage()) {
                    swapPlayers(list, j, j + 1);
                }
            }
        }
    }

    /**
     * Sorts the list of players of a team by their save percentages, in descending order.
     */
    private void sortByGoalsAgainstAverage(List<Player> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).getCurrentSeasonGoalsAgainstAverage() > list.get(j + 1).getCurrentSeasonGoalsAgainstAverage()) {
                    swapPlayers(list, j, j + 1);
                }
            }
        }
    }


    /**
     * Returns the string of a team's players ordered by number of points.
     * 
     * @param list  The list of the teams of the player.
     * @return  The string of players' stats from the list.
     */
    private String getTeamPlayersString(List<Player> list) {
        String listString = "";
        for (int i = 0; i < list.size(); i++) {
            listString += list.get(i).getCurrentSeasonStats_WithPlayerInformation();
        }
        return listString;
    }

    /**
     * Swaps two given players' positions in the list of teams.
     * 
     * @param list      The list of players which are swapping in.
     * @param first     The position of the first player to swap.
     * @param second    The position of the second player to swap.
     */
    private void swapPlayers(List<Player> list, int first, int second) {
        Player temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    /**
     * Checks if a player exists inside of the database.
     * 
     * @param playerName    The name of the player to check.
     * @return  True if the player is in the database and false otherwise.
     */
    public boolean checkPlayerExists(String playerName) {
        for (int i = 0; i < players.size(); i++) {
            if (InputAnalyzer.checkSpecificInput(players.get(i).getName(), playerName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a given player is a skater.
     * 
     * @param playerName    The name of the player to check.
     * @return  True if the player is a skater, and false otherwise.
     */
    public boolean checkPlayerIsSkater(String playerName) {
        int index = getPlayerIndex(playerName);
        if (players.get(index).getClass().equals(Skater.class)) {
            return true;
        }
        return false;
    }

    /**
     * Checks if a given player is a goalie.
     * 
     * @param playerName    The name of the player to check.
     * @return  True if the player is a goalie, and false otherwise.
     */
    public boolean checkPlayerIsGoalie(String playerName) {
        if (!checkPlayerIsSkater(playerName)) {
            return true;
        }
        return false;
    }   

    /**
     * Returns the index in the array of a specific player.
     * 
     * @param playerName    The name of the player to get the index of.
     * @return  The index of the player if it is found, and -1 otherwise.
     */
    private int getPlayerIndex(String playerName) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals(playerName)) {
                return i;
            }
        }
        return -1;
    }
}