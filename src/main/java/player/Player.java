/**
 * An abstract class used to define generic methods for both skaters and goaltenders
 * while leaving space for type-specific methods. 
 */

package player;

import java.io.Serializable;
import java.util.ArrayList;

import season.Season;
import season.SkaterSeason;
import utilities.InputAnalyzer;
import season.GoalieSeason;

public abstract class Player implements Serializable {
    private static final long serialVersionUID = 6670502102885840597L;
    private String name;
    private int age;
    private int number;
    private String team;
    private ArrayList<Season> seasons;

    /**
     * Creates a player from a given name, age, number, and team.
     * 
     * @param playerName    The player's full name.
     * @param playerAge     The player's age.
     * @param playerNumber  The player's jersey number.
     * @param playerTeam    The player's team;
     */
    public Player(String playerName, int playerAge, int playerNumber, String playerTeam) {
        setName(playerName);
        setAge(playerAge);
        setNumber(playerNumber);
        setTeam(playerTeam);
        seasons = new ArrayList<>();
    }

    /**
     * Creates a player from a given name, age, and number, and no team.
     * 
     * @param playerName    The player's full name.
     * @param playerAge     The player's age.
     * @param playerNumber  The player's jersey number.
     */
    public Player(String playerName, int playerAge, int playerNumber) {
        setName(playerName);
        setAge(playerAge);
        setNumber(playerNumber);
        setTeam("/Free Agent/");
        seasons = new ArrayList<>();
    }

    protected void setName(String playerName) {
        name = playerName;
    }

    public void setAge(int playerAge) {
        age = playerAge;
    }

    public void updateAge() {
        age++;
    }

    public void setNumber(int playerNumber) {
        number = playerNumber;
    }

    public void setTeam(String playerTeam) {
        team = playerTeam;
    }

    /**
     * Updates the skater stats for the current season.
     * 
     * @param gamesPlayed   The number of games played during the season.
     * @param points        The number of points scored during the season.
     * @param goals         The number of goals scored during the season.
     * @param assists       The number of assists scored during the season.
     * @param plusMinus     The plus-minus during the season.
     */
    public void updateSkaterSeason(int gamesPlayed, int points, int goals, int assists, int plusMinus) {
        if (seasons.size() > 0) {
            seasons.set(seasons.size()-1, new SkaterSeason("2022-2024", gamesPlayed, points, goals, assists, plusMinus));
        } else {
            seasons.add(new SkaterSeason("2023-2024", gamesPlayed, points, goals, assists, plusMinus));
        }
    }

    /**
     * Appends a skater season to the career.
     * 
     * @param season        The year which the stats occurred.
     * @param gamesPlayed   The number of games played during the season.
     * @param points        The number of points scored during the season.
     * @param goals         The number of goals scored during the season.
     * @param assists       The number of assists scored during the season.
     * @param plusMinus     The plus-minus during the season.
     */
    public void addSkaterSeason(String season, int gamesPlayed, int points, int goals, int assists, int plusMinus) {
        seasons.add(new SkaterSeason(season, gamesPlayed, points, goals, assists, plusMinus));
    }

    /**
     * Updates the goalie stats for the current season.
     * 
     * @param year                  The year which the stats occurred.
     * @param gamesPlayed           The number of games played during the season.
     * @param wins                  The number of wins during the season.
     * @param loses                 The number of loses during the season.
     * @param overtimeLoses         The number of overtime loses during the season.
     * @param savePercentage        The save percentage during the season.
     * @param goalsAgainstAverage   The goals against average during the season.
     */
    public void updateGoalieSeason(int gamesPlayed, int wins, int loses, int overtimeLoses, double savePercentage, double goalsAgainstAverage) {
        if (seasons.size() > 0) {
            seasons.set(seasons.size()-1, new GoalieSeason("2023-2024", gamesPlayed, wins, loses, overtimeLoses, savePercentage, goalsAgainstAverage));
        } else {
            seasons.add(new GoalieSeason("2023-2024", gamesPlayed, wins, loses, overtimeLoses, savePercentage, goalsAgainstAverage));
        }
    }

    /**
     * Appends a goalie season the the career.
     * 
     * @param year                  The year which the stats occurred.
     * @param gamesPlayed           The number of games played during the season.
     * @param wins                  The number of wins during the season.
     * @param loses                 The number of loses during the season.
     * @param overtimeLoses         The number of overtime loses during the season.
     * @param savePercentage        The save percentage during the season.
     * @param goalsAgainstAverage   The goals against average during the season.
     */
    public void addGoalieSeason(String year, int gamesPlayed, int wins, int loses, int overtimeLoses, double savePercentage, double goalsAgainstAverage) {
        seasons.add(new GoalieSeason(year, gamesPlayed, wins, loses, overtimeLoses, savePercentage, goalsAgainstAverage));
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getNumber() {
        return number;
    }

    public String getTeam() {
        return team;
    }

    /**
     * Returns the player's stats from the current year.
     * 
     * @return  A string for the stats of the player in the current year.
     */
    public String getCurrentSeasonStats() {
        return seasons.get(seasons.size() - 1).toString();
    }

    /**
     * Returns the player's career stats.
     * 
     * @return  A string for the career stats of the player.
     */
    public String getCareerStats() {
        return seasons.toString();
    }

    /**
     * Returns the stats for a player from a specific season they played in.
     * 
     * @param season    The season whose stats we are looking for.
     * @return  The stats of the season if found, or an error string.
     */
    public String getStatsFromSeason(String season) {
        if (getSeasonsIndex(season) == -1) {
            return "Season not Found for Player";
        }
        return seasons.get(getSeasonsIndex(season)).toString();
    }

    /**
     * Returns the stats of a player over a range of seasons, given a start and an end.
     * 
     * @param firstSeason   The first season to get the stats of.
     * @param lastSeason    The last season to get the stats of.
     * @return  A string holding the stats of all of the sasons, or an error message.
     */
    public String getStatsFromStartUntilEnd(String firstSeason, String lastSeason) {
        int startingIndex = getSeasonsIndex(firstSeason), endingIndex = getSeasonsIndex(lastSeason);

        if (startingIndex == -1 || endingIndex == -1) {
            return "Player did not Player over These Seasons";
        }
        String statsString = "";
        for (int i = startingIndex; i <= endingIndex; i++) {
            statsString += seasons.get(i).toString();
        }
        return statsString;
    }

    /**
     * Returns the stats of a player from a given start season until the present.
     * 
     * @param firstSeason   The first season to get the stats of.
     * @return  A string holding the stats of all seasons, or an error message.
     */
    public String getStatsFromStart(String firstSeason) {
        int startingIndex = getSeasonsIndex(firstSeason);

        if (startingIndex == -1) {
            return "Player did not Play in the Starting Season";
        }
        String statsString = "";
        for (int i = startingIndex; i < seasons.size(); i++) {
            statsString += seasons.get(i).toString();
        }
        return statsString;
    }

    /**
     * Returns the stats of a player from their first season up until a given ending season.
     * 
     * @param lastSeason   The first season to get the stats of.
     * @return  A string holding the stats of all seasons, or an error message.
     */
    public String getStatsUntilEnd(String lastSeason) {
        int endingIndex = getSeasonsIndex(lastSeason);

        if (endingIndex == -1) {
            return "Player did not Play in the Starting Season";
        }
        String statsString = "";
        for (int i = 0; i <= endingIndex; i++) {
            statsString += seasons.get(i).toString();
        }
        return statsString;
    }

    /**
     * Returns the index of a season concerning a player's career.
     * 
     * @param season    The season to get the index of.
     * @return  The index of the season if found, or -1.
     */
    private int getSeasonsIndex(String season) {
        for (int i = 0; i < seasons.size(); i++) {
            if (InputAnalyzer.checkSpecificInput(seasons.get(i).getYear(), season)) {
                return i;
            }
        }
        return -1;
    }
}