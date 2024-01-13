/**
 * A class used as a data structure for all players in the database. The class manages
 * the data structure and retrieves data from it.
 */

package player;

import java.io.Serializable;

import java.util.ArrayList;

public class Players implements Serializable {
    private static final long serialVersionUID = -2181392019916751192L;
    private ArrayList<Player> players;

    /**
     * Updates the current season's stats for a given skater.
     * 
     * @param playerName    The skater whose stats are being updated.
     * @param gamesPlayed   The new number of games played.
     * @param points        The new number of points.
     * @param goals         The new number of goals.
     * @param assists       The new number of assists.
     * @param plusMinus     The new plus-minus.
     */
    public void updateSkaterSeasonStats(String playerName, int gamesPlayed, int points, int goals, int assists, int plusMinus) {
        int index = getPlayerIndex(playerName);
        players.get(index).updateSkaterSeason(gamesPlayed, points, goals, assists, plusMinus);
    }

    /**
     * Updates the current season's stats for a given goalie.
     * 
     * @param playerName            The goalie whose stats are being updated.
     * @param gamesPlayed           The new number of games played.
     * @param wins                  The new number of wins.
     * @param loses                 The new number of loses.
     * @param overtimeLoses         The new number of overtime loses.
     * @param savePercentage        The new save percentage.
     * @param goalsAgainstAverage   The new goals against average.
     */
    public void updateGoalieSeasonStats(String playerName, int gamesPlayed, int wins, int loses, int overtimeLoses, double savePercentage, double goalsAgainstAverage) {
        int index = getPlayerIndex(playerName);
        players.get(index).updateGoalieSeason(gamesPlayed, wins, loses, overtimeLoses, savePercentage, goalsAgainstAverage);
    }

    /**
     * Appends a season to a given skater's career.
     * 
     * @param playerName    The skater whose stats are being updated
     * @param season        The season being added.
     * @param gamesPlayed   The number of games played during the season.
     * @param points        The number of points during the season.
     * @param goals         The number of goals during the season.
     * @param assists       The number of assists during the season.
     * @param plusMinus     he plus-minus during the season.
     */
    public void addSkaterSeason(String playerName, String season, int gamesPlayed, int points, int goals, int assists, int plusMinus) {
        int index = getPlayerIndex(playerName);
        players.get(index).addSkaterSeason(season, gamesPlayed, points, goals, assists, plusMinus);
    }

    /**
     * Appends a season to a given goalie's career.
     * 
     * @param playerName            The goalie whose  stats are being updated.
     * @param season                The season being added.
     * @param gamesPlayed           The number of games played during the eason.
     * @param wins                  The number of wins during the season.
     * @param loses                 The number of loses during the season.
     * @param overtimeLoses         The number of overtime loses during the season.
     * @param savePercentage        The save percentafe during the season
     * @param goalsAgainstAverage   The goals against average during the season.
     */
    public void addGoalieSeason(String playerName, String season, int gamesPlayed, int wins, int loses, int overtimeLoses, double savePercentage, double goalsAgainstAverage) {
        int index = getPlayerIndex(playerName);
        players.get(index).addGoalieSeason(season, gamesPlayed, wins, loses, overtimeLoses, savePercentage, goalsAgainstAverage);
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
     * Gets the player's stats of a team, sorted by points.
     * 
     * @param team  The team to get the players' stats of.
     * @return  A string showing the team's player sorted by points.
     */
    public String getTeamLeaders(String team) {
        return null;
    }

    /**
     * Checks if a player exists inside of the database.
     * 
     * @param playerName    The name of the player to check.
     * @return  True if the player is in the database and false otherwise.
     */
    public boolean checkPlayerExists(String playerName) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals(playerName)) {
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
}