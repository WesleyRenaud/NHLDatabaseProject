/**
 * A data structure class used to hold the data for all players.
 */

package nhl;

import java.io.Serializable;
import java.util.ArrayList;

import player.Player;
import player.Skater;
import team.League;

public class NHLStatHolder implements Serializable {
    private static final long serialVersionUID = -7994459885119932465L;
    private ArrayList<Player> players = new ArrayList<>();
    private League league = new League();

    /**
     * Adds a team to the league (list of teams) given a team's city, name, conference, division
     * and record.
     * 
     * @param city          The team's city.
     * @param name          The team's name.
     * @param conference    The team's conference.
     * @param division      The team's division.
     * @param wins          The team's number of wins.
     * @param loses         The team's number of loses.
     * @param overtimeLoses The team's number of overtime loses.
     */
    public void addTeam(String city, String name, String conference, String division, int wins, int loses, int overtimeLoses) {
        league.addTeam(city, name, conference, division, wins, loses, overtimeLoses);
    }

    /**
     * Adds a team to the league (list of teams) given a team's city, name, conference, and
     * division.
     * 
     * @param city          The team's city.
     * @param name          The team's name.
     * @param conference    The team's conference.
     * @param division  The team's division.
     */
    public void addTeam(String city, String name, String conference, String division) {
        league.addTeam(city, name, conference, division);
    }

    /**
     * Updates the city of a team based on the given full name.
     * 
     * @param fullName  The full name of the team to update.
     * @param city      The new city for the team.
     */
    public void updateCity(String fullName, String city) {
        league.updateCity(fullName, city);
    }

    /**
     * Updates the name of a team based on the given full name.
     * 
     * @param fullName  The current full name of the team.
     * @param newName   The new name of the team.
     */
    public void updateName(String fullName, String newName) {
        league.updateName(fullName, newName);
    }

    /**
     * Updates the conference of a team based on the given full name.
     * 
     * @param fullName      The full name of the team to update.
     * @param conference    The new conference of the team.
     */
    public void updateConference(String fullName, String conference) {
        league.updateConference(fullName, conference);
    }

    /**
     * Updates the division of a team based on the given full name.
     * 
     * @param fullName  The full name of the team to update.
     * @param division  The new division of the team.
     */
    public void updateDivision(String fullName, String division) {
        league.updateDivision(fullName, division);
    }

    /**
     * Updates the record for a team by supplying their wins, loses, and overtime loses.
     * 
     * @param fullName      The full name of the team to update.
     * @param wins          The new number of wins of the team.
     * @param loses         The new number of loses of the team.
     * @param overtimeLoses The new number of overtime loses of the team.
     */
    public void updateRecord(String fullName, int wins, int loses, int overtimeLoses) {
        league.updateRecord(fullName, wins, loses, overtimeLoses);
    }

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
     * Returns a string showing the standings filtered by points.
     * 
     * @return  The standings filtered by only points.
     */
    public String getStandings_ByLeague_ByPoints() {
        return league.getStandings_ByLeague_ByPoints();
    }

    /**
     * Returns a string showing the playoff/wildcard race.
     * 
     * @return  The standings for the playoff/wildcard race.
     */
    public String getStandings_ByWilcard_ByPoints() {
        return league.getStandings_ByWildcard_ByPoints();
    }

    /**
     * Returns a string showing the standings filtered by division and then by points.
     * 
     * @return  The standings filtered by division and then points.
     */
    public String getStandings_ByDivision_ByPoints() {
        return league.getStandings_ByDivision_ByPoints();
    }

    /**
     * Returns a string showing the standings filtered by conference and then by points.
     * 
     * @return  The standings filtered by conference and then by points.
     */
    public String getStandings_ByConference_ByPoints() {
        return league.getStandings_ByConference_ByPoints();
    }

    /**
     * Returns a string showing the standings filtered by wins.
     * 
     * @return  The standings filtered by wins.
     */
    public String getStandings_ByLeague_ByWins() {
        return league.getStandings_ByLeague_ByWins();
    }

    /**
     * Returns a string showing the standings filtered by loses.
     * 
     * @return  The standings filtered by loses.
     */
    public String getStandings_ByLeague_ByLoses() {
        return league.getStandings_ByLeague_ByLoses();
    }

    /**
     * Returns a string showing the standings filtered by overtime loses.
     * 
     * @return  The standings filtered by overtime loses.
     */
    public String getStandings_ByLeague_ByOvertimeLoses() {
        return league.getStandings_ByLeague_ByOvertimeLoses();
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

    /**
     * Checks if a team belongs to the league.
     * 
     * @param teamName  The team name to check for.
     * @return  True if the team name is found, and false otherwise.
     */
    public boolean checkTeamExists(String teamName) {
        return league.checkTeamExists(teamName);
    }
}