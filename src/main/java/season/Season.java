/**
 * A class used to hold the stats for a player during one season.
 */

package season;

public abstract class Season {
    private int gamesPlayed;
    private String year;

    protected void setGamesPlayed(int newGamesPlayed) {
        gamesPlayed = newGamesPlayed;
    }

    protected void setYear(String newYear) {
        year = newYear;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public String getYear() {
        return year;
    }
}