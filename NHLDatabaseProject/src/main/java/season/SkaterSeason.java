/**
 * Class used to hold the stats for one season of a skater.
 */

package season;

public class SkaterSeason extends Season {
    private int points;
    private int goals;
    private int assists;
    private int plusMinus;

    /**
     * Makes a skater season with given stats.
     * 
     * @param playerYear        The year which the season occurred.
     * @param playerGamesPlayed The number of games played during the season.
     * @param playerPoints      The number of points scored during the season.
     * @param playerGoals       The number of goals scored during the season.
     * @param playerAssists     The number of assists scored during the season.
     * @param playerPlusMinus   The plus-minus during the season.
     */
    public SkaterSeason(String playerYear, int playerGamesPlayed, int playerPoints, int playerGoals, int playerAssists, int playerPlusMinus) {
        setYear(playerYear);
        setGamesPlayed(playerGamesPlayed);
        setPoints(playerPoints);
        setGoals(playerGoals);
        setAssists(playerAssists);
        setPlusMinus(playerPlusMinus);
    }
    
    protected void setPoints(int playerPoints) {
        points = playerPoints;
    }

    protected void setGoals(int playerGoals) {
        goals = playerGoals;
    }

    protected void setAssists(int playerAssists) {
        assists = playerAssists;
    }

    protected void setPlusMinus(int playerPlusMinus) {
        plusMinus = playerPlusMinus;
    }

    public int getGoals() {
        return goals;
    }

    public int getAssists() {
        return assists;
    }

    public int getPoints() {
        return points;
    }

    public int getPlusMinus() {
        return plusMinus;
    }

    /**
     * Creates a String generation of the skater season.
     */
    @Override
    public String toString() {
        return "Games Played: " + "\t| Points: " + points + getGamesPlayed() + "\t| Goals: " + goals + "\t| Assists: " + assists  + "\t| Plus/Minus: " + plusMinus + "\n";
    }
}
