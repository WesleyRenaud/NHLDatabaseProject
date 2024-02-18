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

    public void setTeam(String playerTeam) {
        team = playerTeam;
    }

    public void setNumber(int playerNumber) {
        number = playerNumber;
    }

    public void setRetired(boolean playerRetired) {
        retired = playerRetired;
    }

    protected void setName(String newName) {
        name = newName;
    }

    protected void setBirthday(String newBirthday) {
        birthday = newBirthday;
    }    

    /**
     * Updates the skater stats for the current season.
     * 
     * @param season        The season of which the stats are being updated.
     * @param gamesPlayed   The number of games played during the season.
     * @param goals         The number of goals scored during the season.
     * @param assists       The number of assists scored during the season.
     * @param plusMinus     The plus-minus during the season.
     */
    public void updateSkaterSeason(String season, int gamesPlayed, int goals, int assists, int plusMinus) {
        for (int i = 0; i < seasons.size(); i++) {
            if (InputAnalyzer.checkSpecificInput(season, seasons.get(i).getYear())) {
                seasons.set(i, new SkaterSeason(season, gamesPlayed, goals, assists, plusMinus));
            }
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
     * Prints the player's career stats.
     */
    public void printCareerStats() {
        System.out.println(this);
        BufferGenerator.printBuffer(112);
        for (int i = 0; i < seasons.size(); i++) {
            System.out.println(seasons.get(i));
        }
    }

    /**
     * Prints the player's stats from a given season
     * 
     * @param season    The season whose stats we are printing.
     */
    public void printStatsFromSeason(String season) {
        if (getSeasonsIndex(season) == -1) {
            System.out.println(" ! " + name + " did not play during the " + season + " season !");
        } else {
            System.out.println(this);
            BufferGenerator.printBuffer(112);
            System.out.println(seasons.get(getSeasonsIndex(season)));
        }        
    }

    /**
     * Prints the given player's stats over a range of seasons, given a start and an end.
     * 
     * @param firstSeason   The first season to print the stats of.
     * @param lastSeason    The last season to print the stats of.
     */
    public void printStatsFromStartUntilEnd(String firstSeason, String lastSeason) {
        int startingIndex = getSeasonsIndex(firstSeason), endingIndex = getSeasonsIndex(lastSeason);

        if (startingIndex == -1 || endingIndex == -1) {
            System.out.println(" ! " + name + " did not play over this range !");
        }
        else {
            System.out.println(this);
            BufferGenerator.printBuffer(112);
            for (int i = startingIndex; i <= endingIndex; i++) {
                System.out.println(seasons.get(i));
            }
        }
    }

    /**
     * Prints the given player's stats from a given starting season until the end of their
     * career.
     * 
     * @param firstSeason   The first season to print the stats of.
     */
    public void printStatsFromStart(String firstSeason) {
        int startingIndex = getSeasonsIndex(firstSeason);

        if (startingIndex == -1) {
            System.out.println(" ! " + name + " did not play during the " + firstSeason + " season !");
        } else {
            BufferGenerator.printBuffer(112);
            for (int i = startingIndex; i < seasons.size(); i++) {
                System.out.println(seasons.get(i));
            }
        }
    }

    /**
     * Prints the player's stats from the start of their career up until a given ending
     * season.
     * 
     * @param lastSeason   The first season to print the stats of.
     */
    public void printStatsUntilEnd(String lastSeason) {
        int endingIndex = getSeasonsIndex(lastSeason);

        if (endingIndex == -1) {
            System.out.println(" ! " + name + " did not play during the " + lastSeason + " season !");
        } else {
            BufferGenerator.printBuffer(112);
            for (int i = 0; i <= endingIndex; i++) {
                System.out.println(seasons.get(i));
            }
        }
    }

    /**
     * Prints the player's stats for the current season, plus their information.
     */
    public void printCurrentSeasonStats_WithPlayerName() {
        int seasonIndex = getSeasonsIndex("2023-2024");
        System.out.printf(" %-20s" + seasons.get(seasonIndex).printWithoutYear() + "\n", name);
    }


    /**
     * Returns the index of a season concerning the player's career.
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

    @Override
    public String toString() {
        return String.format("\t\t\t\t\t\t%-25s\n\n\tNumber: %-7d \t\t\tAge: %-7d \t\t\tHandedness: %-15s",
                    name, number, getAge(), handedness);
    }
}