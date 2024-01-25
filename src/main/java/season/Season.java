/**
 * A class used to hold the stats for a player during one season.
 */

package season;

<<<<<<< HEAD

import java.io.Serializable;


public abstract class Season implements Serializable {
    private static final long serialVersionUID = 3469746612261262771L;
=======
public abstract class Season {
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
    private int gamesPlayed;
    private String year;

    protected void setGamesPlayed(int newGamesPlayed) {
        gamesPlayed = newGamesPlayed;
    }

    protected void setYear(String newYear) {
        year = newYear;
    }
<<<<<<< HEAD
    
=======
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public String getYear() {
        return year;
    }
<<<<<<< HEAD

    public int getPoints() {
        if (getClass().equals(SkaterSeason.class)) {
            return ((SkaterSeason)(this)).getPoints();
        }
        return -1;
    }

    public int getGoals() {
        if (getClass().equals(SkaterSeason.class)) {
            return ((SkaterSeason)(this)).getGoals();
        }
        return -1;
    }

    public int getAssists() {
        if (getClass().equals(SkaterSeason.class)) {
            return ((SkaterSeason)(this)).getAssists();
        }
        return -1;
    }

    public int getPlusMinus() {
        if (getClass().equals(SkaterSeason.class)) {
            return ((SkaterSeason)(this)).getPlusMinus();
        }
        return -1;
    }

    public int getWins() {
        if (getClass().equals(GoalieSeason.class)) {
            return ((GoalieSeason)(this)).getWins();
        }
        return -1;
    }

    public double getSavePercentage() {
        if (getClass().equals(GoalieSeason.class)) {
            return ((GoalieSeason)(this)).getSavePercentage();
        }
        return -1;
    }

    public double getGoalsAgainstAverage() {
        if (getClass().equals(GoalieSeason.class)) {
            return ((GoalieSeason)(this)).getGoalsAgainstAverage();
        }
        return -1;
    }
=======
>>>>>>> 6814e25f9da3ed0ca82d45bef8836113876b42a0
}