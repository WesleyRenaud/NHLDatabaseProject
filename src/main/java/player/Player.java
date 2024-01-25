/**
 * An abstract class used to define generic methods for both skaters and goaltenders
 * while leaving space for type-specific methods. 
 */

package player;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import input.InputAnalyzer;
import utilities.BufferGenerator;
import utilities.BirthdayHandler;
import season.Season;
import season.SkaterSeason;
<<<<<<< HEAD
=======
import utilities.InputAnalyzer;
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
import season.GoalieSeason;


public abstract class Player implements Serializable {
    private static final long serialVersionUID = 6670502102885840597L;
    private String name;
    private String birthday;
    private String handedness;
    private boolean retired;
    private int number;
    private String team;
    private List<Season> seasons;

    /**
     * Creates a new skater given their name, birthday, handedness, retired status,
     * number, and team.
     * 
     * @param playerName        The player's full name.
     * @param playerBirthday    The player's birthday.
     * @param playerHandedness  The player's handedness.
     * @param playerRetired     Whether the player is retired.
     * @param playerNumber      The player's jersey number.
     * @param playerTeam        The player's team;
     */
    public Player(String playerName, String playerBirthday, String playerHandedness, boolean playerRetired, int playerNumber, String playerTeam) {
        name = playerName;
        birthday = playerBirthday;
        handedness = playerHandedness;
        retired = playerRetired;
        number = playerNumber;
        team = playerTeam;
        seasons = new ArrayList<>();
    }

    public void setRetired(boolean playerRetired) {
        retired = playerRetired;
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
     * @param goals         The number of goals scored during the season.
     * @param assists       The number of assists scored during the season.
     * @param plusMinus     The plus-minus during the season.
     */
    public void updateSkaterSeason(int gamesPlayed, int goals, int assists, int plusMinus) {
        if (seasons.size() > 0) {
            seasons.set(seasons.size()-1, new SkaterSeason("2022-2024", gamesPlayed, goals, assists, plusMinus));
        } else {
            seasons.add(new SkaterSeason("2023-2024", gamesPlayed, goals, assists, plusMinus));
        }
    }

    /**
     * Appends a skater season to the career.
     * 
     * @param season        The year which the stats occurred.
     * @param gamesPlayed   The number of games played during the season.
     * @param goals         The number of goals scored during the season.
     * @param assists       The number of assists scored during the season.
     * @param plusMinus     The plus-minus during the season.
     */
    public void addSkaterSeason(String season, int gamesPlayed, int goals, int assists, int plusMinus) {
        seasons.add(new SkaterSeason(season, gamesPlayed, goals, assists, plusMinus));
    }

    /**
     * Updates the goalie stats for the current season.
     * 
     * @param year                  The year which the stats occurred.
     * @param wins                  The number of wins during the season.
     * @param loses                 The number of loses during the season.
     * @param overtimeLoses         The number of overtime loses during the season.
     * @param savePercentage        The save percentage during the season.
     * @param goalsAgainstAverage   The goals against average during the season.
     */
    public void updateGoalieSeason(int wins, int loses, int overtimeLoses, double savePercentage, double goalsAgainstAverage) {
        if (seasons.size() > 0) {
            seasons.set(seasons.size()-1, new GoalieSeason("2023-2024", wins, loses, overtimeLoses, savePercentage, goalsAgainstAverage));
        } else {
            seasons.add(new GoalieSeason("2023-2024", wins, loses, overtimeLoses, savePercentage, goalsAgainstAverage));
        }
    }

    /**
     * Appends a goalie season the the career.
     * 
     * @param year                  The year which the stats occurred.
     * @param wins                  The number of wins during the season.
     * @param loses                 The number of loses during the season.
     * @param overtimeLoses         The number of overtime loses during the season.
     * @param savePercentage        The save percentage during the season.
     * @param goalsAgainstAverage   The goals against average during the season.
     */
    public void addGoalieSeason(String year, int wins, int loses, int overtimeLoses, double savePercentage, double goalsAgainstAverage) {
        seasons.add(new GoalieSeason(year, wins, loses, overtimeLoses, savePercentage, goalsAgainstAverage));
    }
    

    public String getName() {
        return name;
    }

    public boolean isRetired() {
        return retired;
    }

    public int getNumber() {
        return number;
    }

    public String getTeam() {
        return team;
    }

    public int getAge() {
        return BirthdayHandler.getAge(birthday);
    }

    public boolean isSkater() {
        if (getClass().equals(Skater.class)) {
            return true;
        }
        return false;
    }

    public boolean isGoalie() {
        if (!isSkater()) {
            return true;
        }
        return false;
    }

    public int getCurrentSeasonPoints() {
        if (!isRetired() && isSkater()) {
            return seasons.get(seasons.size() - 1).getPoints();
        }
        return -1;
    }

    public int getCurrentSeasonGoals() {
        if (!isRetired() && isSkater()) {
            return seasons.get(seasons.size() - 1).getGoals();
        }
        return -1;
    }

    public int getCurrentSeasonAssists() {
        if (!isRetired() && isSkater()) {
            return seasons.get(seasons.size() - 1).getAssists();
        }
        return -1;
    }

    public int getCurrentSeasonPlusMinus() {
        if (!isRetired() && isSkater()) {
            return seasons.get(seasons.size() - 1).getPlusMinus();
        }
        return -1;
    }

    public int getCurrentSeasonWins() {
        if (!isRetired() && isGoalie()) {
            return seasons.get(seasons.size() - 1).getWins();
        }
        return -1;
    }

    public double getCurrentSeasonSavePercentage() {
        if (!isRetired() && isGoalie()) {
            return seasons.get(seasons.size() - 1).getSavePercentage();
        }
        return -1;
    }

    public double getCurrentSeasonGoalsAgainstAverage() {
        if (!isRetired() && isGoalie()) {
            return seasons.get(seasons.size() - 1).getGoalsAgainstAverage();
        }
        return -1;
    }


    /**
     * Returns the player's stats from the current year.
     * 
     * @return  A string for the stats of the player in the current year.
     */
    public String getCurrentSeasonStats() {
        String currentSeasonStats = "";
        currentSeasonStats += "\n";
        currentSeasonStats += BufferGenerator.addLineBufferForScreenWidth();
        currentSeasonStats += seasons.get(seasons.size() - 1).toString();
        return currentSeasonStats;
    }

    /**
     * Returns the player's stats from the current year.
     * 
     * @return  A string for the stats of the player in the current year.
     */
    public String getCurrentSeasonStats_WithPlayerInformation() {
        String currentSeasonStats = "";
        currentSeasonStats += "\n";
        currentSeasonStats += name;
        if (name.length() < 15) {
            currentSeasonStats +=  ":\t\t";
        } else {
            currentSeasonStats +=  ":\t";
        }
        currentSeasonStats += seasons.get(seasons.size() - 1).toString();
        return currentSeasonStats;
    }

    /**
     * Returns the player's career stats.
     * 
     * @return  A string for the career stats of the player.
     */
    public String getCareerStats() {
        String careerStats = "";
        careerStats += "\n";
        careerStats += BufferGenerator.addLineBufferForScreenWidth();
        for (int i = 0; i < seasons.size(); i++) {
            careerStats += "\n";
            careerStats += seasons.get(i).getYear() + " | \t";
            careerStats += seasons.get(i).toString();
        }
        return careerStats;
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
        String seasonStats = "";
        seasonStats += "\n";
        seasonStats += BufferGenerator.addLineBufferForScreenWidth();
        seasonStats += seasons.get(getSeasonsIndex(season)).toString();
        return seasonStats;
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
        String seasonsStats = "";
        seasonsStats += "\n";
        seasonsStats += BufferGenerator.addLineBufferForScreenWidth();
        for (int i = startingIndex; i <= endingIndex; i++) {
            seasonsStats += seasons.get(i).toString();
        }
        return seasonsStats;
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