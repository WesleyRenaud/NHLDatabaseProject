/**
 * Class used to hold the stats for one season of a skater.
 */

package season;


public class SkaterSeason extends Season {
    private static final long serialVersionUID = 2310624046159046390L;
    private int goals;
    private int assists;
    private int plusMinus;

    /**
     * Makes a skater season with given stats.
     * 
     * @param playerYear        The year which the season occurred.
     * @param playerGamesPlayed The number of games played during the season.
     * @param playerGoals       The number of goals scored during the season.
     * @param playerAssists     The number of assists scored during the season.
     * @param playerPlusMinus   The plus-minus during the season.
     */
    public SkaterSeason(String year, int gamesPlayed, int playerGoals, int playerAssists, int playerPlusMinus) {
        setYear(year);
        setGamesPlayed(gamesPlayed);
        goals = playerGoals;
        assists = playerAssists;
        plusMinus = playerPlusMinus;
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
        return goals + assists;
    }

    public int getPlusMinus() {
        return plusMinus;
    }


    /**
     * Creates a String generation of the skater season.
     */
    @Override
    public String toString() {
        return "Games Played: " + getGamesPlayed() + "\t| Goals: " + goals + "\t| Assists: " + assists  + "\t| Points: " + getPoints() + "\t| Plus/Minus: " + plusMinus + "\n";
    }
}